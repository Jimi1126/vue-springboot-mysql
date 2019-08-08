var User = function() {}

User.prototype = {
  name: "user",
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
      code: "",
      name: '',
      password:'',
      rid:'',
      pid:'',
      status:'',
      createTime: moment().format("YYYY-MM-DD HH:mm:ss")
    }
  },
  getAddDialog: function (flag) {
    var that = this;
    return new Dialog({
      title: flag ? "修改" : "新增",
      width: "450px",
      body: 
      `<el-form ref="form" label-width="90px">
        <el-form-item label="工号：">
          <el-input v-model="form.code"></el-input>
        </el-form-item>
        <el-form-item label="姓名：">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="密码：">
          <el-input v-model="form.password" type="password" style="width:210px"></el-input>
          <el-button @click="showPwdEvent">查看密码</el-button>
        </el-form-item>
        <el-form-item label="角色：">
          <el-select solt="prepend" v-model="form.rid" style="width:100%">
            <el-option v-for="item in roles" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职位：">
          <el-select solt="prepend" v-model="form.pid" style="width:100%">
            <el-option v-for="item in positions" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态：">
          <el-select solt="prepend" v-model="form.status" style="width:100%">
            <el-option v-for="item in statuss" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
      </el-form>`,
      data: {
        roles: ic_sms.enum["角色"],
        positions: ic_sms.enum["职位"],
        statuss: ic_sms.enum["员工状态"],
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
            $.ic.loadUI.show();
            var user = dialogThis._vue.$data.form;
            var url = flag ? "/user/updateByPrimaryKey" : "/user/insert";
            $.post(url, user, function(data, status, xhr) {
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
            $.post("/user/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
    $.post("/user/selectByExample", cloneObj, function(data) {
      that.page_vue.$data.mainList = data.data || [];
      $.ic.loadUI.hide();
    })
  }
}

var user = new User();
user.init();