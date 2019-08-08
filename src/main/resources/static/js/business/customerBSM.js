var CustomerBuySysManage = function () { }

CustomerBuySysManage.prototype = {
  name: "customerBSM",
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
      name: "",
      usercode: "",
      password: "",
      site: "",
      uid: "",
      remark: "",
      regTime: new Date()
    }
  },
  getAddDialog: function (flag) {
    var that = this;
    return new Dialog({
      title: flag ? "修改" : "新增",
      width: "450px",
      body:
        `<el-form ref="form" label-width="90px">
          <el-form-item label="客户名称：">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="账号：">
            <el-input v-model="form.usercode"></el-input>
          </el-form-item>
          <el-form-item label="密码：">
            <el-input v-model="form.password" type="password" style="width:210px"></el-input>
            <el-button @click="showPwdEvent">查看密码</el-button>
          </el-form-item>
          <el-form-item label="网址：">
            <el-input v-model="form.site"></el-input>
          </el-form-item>
          <el-form-item label="经办人：">
            <el-input v-model="form.uid"></el-input>
          </el-form-item>
          <el-form-item label="注册时间：">
            <el-date-picker v-model="form.regTime" type="date" placeholder="选择日期" style="width: 100%"></el-date-picker>
          </el-form-item>
          <el-form-item label="备注：">
            <el-input type="textarea" v-model="form.remark"></el-input>
          </el-form-item>
        </el-form>`,
      data: {
        form: that.newform()
      },
      methods: {
        showPwdEvent: $.getRole( that.name, "showPwd", function() {
          $.post("/pwd/selectByExample", {rid: this._vue.$data.form.gid}, function(response) {
            alert(response.data[0] && (response.data[0].pwd || ""));
          })
        })
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
            var purchase = Util.clone(dialogThis._vue.$data.form);
            purchase.regTime = moment(purchase.regTime).format("YYYY-MM-DD");
            flag || (purchase.createTime = moment().format("YYYY-MM-DD HH:mm:ss"));
            $.ic.loadUI.show();
            var url = flag ? "/purchase/updateByPrimaryKey" : "/purchase/insert";
            $.post(url, purchase, function (data, status, xhr) {
              $.ic.loadUI.hide();
              if (data.data == 1) {
                alert("操作成功");
                dialogThis._vue.$data.form = that.newform()
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
            $.post("/purchase/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
    var $tableTH = $("#CSBSM_Table").children();
    this.titles = [];
    this.fields = [];
    $.each($tableTH, function (ind, row) {
      if($(row).attr("label")=="操作"){
        return
      }
      that.titles.push($(row).attr("label"));
      that.fields.push($(row).attr("prop"));
    })
    that.page_vue = new Vue({
      el: "#customer-buy-sys-tab",
      data: {
        customTable: [],
        tooltip: true,
        search_form: {
          name:""
        }
      },
      methods: {
        addBtnEvent: $.getRole( that.name, "addBtn", () => {
          that.addDialogComponent.show();
        }),
        findBtnEvent: $.getRole( that.name, "findBtn", () => {
          that.loadTable();
        }),
        editBtnEvent: $.getRole( that.name, "editBtn", (index, row) => {
          that.editDialogComponent._vue.$data.form = Util.clone(row);
          that.editDialogComponent.show();
        }),
        delBtnEvent: $.getRole( that.name, "delBtn", (index, row) => {
          that.delDialogComponent._vue.$data.rowData = row;
          that.delDialogComponent.show();
        }),
        displayFormat: function(row, column, cellValue, index) {
          switch(column.property) {
            case "password":
                return "*******";
            default:
              return cellValue;
          }
        },
        exportTable: $.getRole( that.name, "export", () => {
          var searchForm=that.page_vue.$data.search_form;
          var cloneObj = Util.clone(searchForm);
          cloneObj.name = cloneObj.name ? `%${cloneObj.name}%` : '';
          exportTable("purchase",searchForm,this.titles,this.fields,"客户采购系统管理");
        })
      },
    })
  },
  /**
   * 额外事件绑定.
   */
  bindEvent: function () {

  },
  /**
   * 加载表格
   */
  loadTable: function () {
    var that = this;
    $.ic.loadUI.show();
    var cloneObj = Util.clone(that.page_vue.$data.search_form);
    cloneObj.name = `%${cloneObj.name}%`;
    $api("/purchase/selectByParam", cloneObj, function (data) {
      that.page_vue.$data.customTable = data.data || [];
      $.ic.loadUI.hide();
    });
  }
}

var custom = new CustomerBuySysManage();
custom.init();
