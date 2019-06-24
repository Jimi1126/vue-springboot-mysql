var Contract = function() {}

Contract.prototype = {
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
    that.addDialogComponent = that.getAddDialog();
    that.editDialogComponent = that.getAddDialog("修改");
    that.delDialogComponent = that.getDelDialog();
  },
  newform: function() {
    return {
      gid: Util.uuid(32, 52),
      customerName: "",
      name: '',
      trade:'',
      type:'',
      term:'',
      contractTime:'',
      overTime:'',
      status:'',
      cooperationType:'',
      returnTime:'',
      quality:'',
      remark:''
    }
  },
  getAddDialog: function(flag) {
    var that = this;
    return new Dialog({
      title: flag ? "修改" : "新增",
      width: "50%",
      body: 
      `<el-form ref="form" label-width="90px">
        <el-form-item label="客户名称：">
          <el-input v-model="form.customerName"></el-input>
        </el-form-item>
        <el-form-item label="合同名称：">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="所属行业：">
          <el-select solt="prepend" v-model="form.trade" placeholder="行业" style="width: 100%">
            <el-option v-for="item in trades" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="合作类型：">
          <el-select solt="prepend" v-model="form.cooperationType" style="width: 100%">
            <el-option v-for="item in cooperationTypes" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="合作期限：">
          <el-input v-model="form.term"></el-input>
        </el-form-item>
        <el-form-item label="签约时间：">
          <el-date-picker v-model="form.contractTime" style="width: 100%" type="date" placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间：">
          <el-date-picker v-model="form.overTime" style="width: 100%" type="date" placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="合作状态：">
          <el-select solt="prepend" v-model="form.status" style="width: 100%">
            <el-option v-for="item in statuss" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="合同类型：">
          <el-select solt="prepend" v-model="form.type" style="width: 100%">
            <el-option v-for="item in types" :label="item.name" :value=item.code></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="时 效：">
          <el-input type="textarea" v-model="form.returnTime"></el-input>
        </el-form-item>
        <el-form-item label="质 量：">
          <el-input type="textarea" v-model="form.quality"></el-input>
        </el-form-item>
        <el-form-item label="备 注：">
          <el-input type="textarea" v-model="form.remark"></el-input>
        </el-form-item>
      </el-form>`,
      data: {
        trades: ic_sms.enum["行业"],
        cooperationTypes: ic_sms.enum["合作类型"],
        types: ic_sms.enum["合同类型"],
        statuss: ic_sms.enum["合作状态"],
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
            var contract = Util.clone(dialogThis._vue.$data.form);
            contract.contractTime = moment(contract.contractTime).format("YYYY-MM-DD");
            contract.overTime = moment(contract.overTime).format("YYYY-MM-DD");
            var url = flag ? "/contract/updateByPrimaryKey" : "/contract/insert";
            $.post(url, contract, function(data, status, xhr) {
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
            $.post("/contract/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
        customList: [],
        trades: ic_sms.enum["行业"],
        cooperationTypes: ic_sms.enum["合作类型"],
        types: ic_sms.enum["合同类型"],
        tooltip: true,
        search_form: {
          customerName: "",
          name:'',
          trade:'',
          cooperationType:'',
          type: '',
          contractTime: ''
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
        displayFormat: function (row, column, cellValue, index) {
          var obj;
          switch (column.property) {
            case "trade":
              obj = ic_sms.enum["行业"].filter((item) => { return item.code == cellValue })[0] || {};
              return (obj && obj.name) || cellValue;
            case "cooperationType":
              obj = ic_sms.enum["合作类型"].filter((item) => { return item.code == cellValue })[0] || {};
              return (obj && obj.name) || cellValue;
            case "status":
              obj = ic_sms.enum["合作状态"].filter((item) => { return item.code == cellValue })[0] || {};
              return (obj && obj.name) || cellValue;
            case "type":
              obj = ic_sms.enum["合同类型"].filter((item) => { return item.code == cellValue })[0] || {};
              return (obj && obj.name) || cellValue;
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
    cloneObj.customerName = `%${cloneObj.customerName}%`;
    cloneObj.name = `%${cloneObj.name}%`;
    $.post("/contract/selectByExample", cloneObj, function(data) {
      that.page_vue.$data.customList = data.data || [];
      $.ic.loadUI.hide();
    })
  }
}

var contract = new Contract();
contract.init();