var Authority = function() {}

Authority.prototype = {
  /**
   * 构造组件动作.
   */
  init: function() {
    this.adjustUI();
    this.initComponent();
    this.completeComponent();
    this.bindEvent();
    this.loadTable();
  },
  /**
   * 调整UI.
   */
  adjustUI: function() {},
  /**
   * 初始化子组件.
   */
  initComponent: function() {
    var that = this;
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
      authid: "",
      authname: '',
      userid:'',
      usercode:'',
      state:''
    }
  },
  getAddDialog: function (flag) {
    var that = this;
    return new Dialog({
      title: flag ? "修改" : "新增",
      width: "30%",
      body: 
      `<el-form ref="form" label-width="90px">
        <el-form-item label="权限名称：">
          <el-select solt="prepend" v-model="form.authid">
            <el-option v-for="item in auths" :label="item.name" :value=item.gid></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户名称：">
          <el-select solt="prepend" v-model="form.userid">
            <el-option v-for="item in users" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态：">
          <el-select solt="prepend" v-model="form.state">
            <el-option v-for="item in statuss" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
      </el-form>`,
      data: {
        auths: ic_sms.enum["角色"],
        users: ic_sms.enum["职位"],
        statuss: ic_sms.enum["员工状态"],
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
            var authority = dialogThis._vue.$data.form;
            var url = flag ? "/authority/updateByPrimaryKey" : "/authority/insert";
            $.post(url, authority, function(data, status, xhr) {
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
            $.post("/authority/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
  completeComponent: function() {
    var that = this;
    that.page_vue = new Vue({
      el: "#main_app",
      data: {
        mainList: [],
        roles: ic_sms.enum["角色"],
        statuss: ic_sms.enum["员工状态"],
        search_form: {
          code: "",
          name:'',
          rid:'',
          status:''
        }
      },
      methods: {
        addBtnEvent: () => {
          that.addDialogComponent.show();
        },
        findBtnEvent: ()=> {
          that.loadTable();
        },
        editBtnEvent: (index, row) => {
          that.editDialogComponent._vue.$data.form = Util.clone(row);
          that.editDialogComponent.show();
        },
        delBtnEvent: (index, row) => {
          that.delDialogComponent._vue.$data.rowData = row;
          that.delDialogComponent.show();
        },
        displayFormat: function(row, column, cellValue, index) {
          var obj;
          switch(column.property) {
            case "rid":
                obj = ic_sms.enum["角色"].filter((item)=> {return item.code == cellValue})[0] || {};
                return obj.name || "";
            case "pid":
                obj = ic_sms.enum["职位"].filter((item)=> {return item.code == cellValue})[0] || {};
                return obj.name || "";
            case "status":
                obj = ic_sms.enum["员工状态"].filter((item)=> {return item.code == cellValue})[0] || {};
                return obj.name || "";
            default:
              return cellValue;
          }
        }
      },
    })
  },
  /**
   * 额外事件绑定.
   */
  bindEvent: function() {

  },
  /**
   * 加载表格
   */
  loadTable: function() {
    var that = this;
    $.ic.loadUI.show();
    var cloneObj = Util.clone(that.page_vue.$data.search_form);
    cloneObj.code = `%${cloneObj.code}%`;
    cloneObj.name = `%${cloneObj.name}%`;
    $.post("/authority/selectByExample", cloneObj, function(data) {
      that.page_vue.$data.mainList = data.data || [];
      $.ic.loadUI.hide();
    })
  }
}

var auth = new Authority();
auth.init();