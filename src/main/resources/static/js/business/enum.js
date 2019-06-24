var Enum = function () { }

Enum.prototype = {
  /**
   * 构造组件动作.
   */
  init: function () {
    this.adjustUI();
    this.initComponent();
    this.completeComponent();
    this.bindEvent();
    this.loadTable();
  },
  /**
   * 调整UI.
   */
  adjustUI: function () { },
  /**
   * 初始化子组件.
   */
  initComponent: function () {
    var that = this;
    that.addDialogComponent = that.getAddDialog();
    that.editDialogComponent = that.getAddDialog("修改");
    that.delDialogComponent = that.getDelDialog();
  },
  /**
   * 获取一个新对象.
   */
  newform: function () {
    return {
      gid: Util.uuid(32, 52),
      type: "",
      typeName: '',
      code: '',
      name: ''
    }
  },
  getAddDialog: function (flag) {
    var that = this;
    return new Dialog({
      title: flag ? "修改" : "新增",
      width: "30%",
      body:
        `<el-form ref="form" label-width="90px">
        <el-form-item label="类型编码：">
          <el-input v-model="form.type"></el-input>
        </el-form-item>
        <el-form-item label="类型名称：">
          <el-input v-model="form.typeName"></el-input>
        </el-form-item>
        <el-form-item label="枚举编码：">
          <el-input v-model="form.code"></el-input>
        </el-form-item>
        <el-form-item label="枚举名称：">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
      </el-form>`,
      data: {
        form: that.newform()
      },
      buttons: [
        {
          name: "关闭",
          event: function () {
            this.hide();
          }
        },
        {
          name: flag ? "修改" : "新增",
          type: "primary",
          event: function () {
            var dialogThis = this;
            $.ic.loadUI.show();
            var enumOO = dialogThis._vue.$data.form;
            var url = flag ? "/enum/updateByPrimaryKey" : "/enum/insert";
            $.post(url, enumOO, function (data, status, xhr) {
              $.ic.loadUI.hide();
              if (data.data == 1) {
                alert("操作成功");
                dialogThis._vue.$data.form = that.newform();
              }
              dialogThis.hide();
            });
          }
        },
      ]
    });
  },
  /**
   * 获取删除对话框.
   */
  getDelDialog: function () {
    return new Dialog({
      title: "删除",
      body: `是否删除【{{rowData.name}}】?`,
      data: {
        rowData: { name: "" }
      },
      buttons: [
        {
          name: "关闭",
          event: function () {
            this.hide();
          }
        },
        {
          name: "确定",
          type: "primary",
          event: function () {
            var that = this;
            $.post("/enum/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
              if (data.data > 0) {
                alert("删除成功");
                that.hide();
              } else {
                alert("删除失败");
              }
            });
          }
        }
      ]
    });
  },
  /**
   * 完成组件初始化动作.
   */
  completeComponent: function () {
    var that = this;
    that.page_vue = new Vue({
      el: "#main_app",
      data: {
        mainList: [],
        search_form: {
          typeName: "",
          name: ''
        }
      },
      methods: {
        addBtnEvent: () => {
          that.addDialogComponent.show();
        },
        findBtnEvent: () => {
          that.loadTable();
        },
        editBtnEvent: (index, row) => {
          that.editDialogComponent._vue.$data.form = Util.clone(row);
          that.editDialogComponent.show();
        },
        delBtnEvent: (index, row) => {
          that.delDialogComponent._vue.$data.rowData = row;
          that.delDialogComponent.show();
        }
      },
    })
  },
  /**
   * 额外事件绑定.
   */
  bindEvent: function () {

  },
  /**
   * 自定义排序
   * @param {*} arr 
   */
  customSort: function (arr) {
    if (Array.isArray(arr)) {
      arr.sort(function (a, b) {
        if (a.type != b.type) {
          return +a.type - +b.type;
        } else {
          return +a.code - +b.code;
        }
      });
    }
  },
  /**
   * 加载表格
   */
  loadTable: function () {
    var that = this;
    $.ic.loadUI.show();
    var cloneObj = Util.clone(that.page_vue.$data.search_form);
    cloneObj.typeName = `%${cloneObj.typeName}%`;
    cloneObj.name = `%${cloneObj.name}%`;
    $.post("/enum/selectByExample", cloneObj, function (data) {
      that.page_vue.$data.mainList = data.data || [];
      that.customSort(that.page_vue.$data.mainList);
      $.ic.loadUI.hide();
    })
  }
}

var enumer = new Enum();
enumer.init();