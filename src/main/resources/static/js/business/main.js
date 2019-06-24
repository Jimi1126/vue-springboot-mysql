var Main = function () { }

Main.prototype = {
  oldLink: "",
  /**
   * 构造组件动作.
   */
  init: function () {
    this.initData();
    this.adjustUI();
    this.initComponent();
    this.completeComponent();
    this.bindEvent();
  },
  /**
   * 初始化数据.
   */
  initData: function() {
    var that = this;
    window.ic_sms || (window.ic_sms = {});
    window.ic_sms.address = [];
    window.ic_sms.enum = {};
    async.series([
      (callback)=> {
        $.post("/address/selectByExample", function(res) {
          window.ic_sms["国"] = [{
            'areaid': "-1",
            'areacode': "100000",
            'areaname': "中国",
            'level': "0",
            'citycode': "000",
            'center': "0,0",
            'parentid': ""
          }];
          window.ic_sms.address = window.ic_sms["国"].concat(res.data);
          callback(null);
        });
      },
      (callback)=> {
        delete window.ic_sms.user.password;
        $.post("/user/selectByExample", window.ic_sms.user, function(res) {
          window.ic_sms.user = res.data[0];
          that.page_vue.$data.name = window.ic_sms.user.name;
          callback(null);
        });
      },
      (callback)=> {
        $.post("/enum/selectByExample", function(res) {
          res.data.forEach((en)=> {
            window.ic_sms.enum[en.typeName] || (window.ic_sms.enum[en.typeName] = []);
            window.ic_sms.enum[en.typeName].push(en);
          });
          callback(null);
        });
      }
    ], (err)=>{
      $.ic.loadUI.hide();
    });
  },
  /**
   * 调整UI.
   */
  adjustUI: function () {
    $(".el-main").height(window.innerHeight - $(".el-header").height() - 40);
  },
  /**
   * 初始化子组件.
   */
  initComponent: function () {
    var that = this;
    window.$navMenu = $("#nav-menu").navList({
      default: [1],
      data: [
        {title: "业务管理", subMenu: [
          {title: "电话拓展管理", link: "/html/customer.html"},
          {title: "合同管理", link: "/html/contract.html"},
          {title: "客户采购系统管理", link: "/html/customerBSM.html"},
        ]},
        {title: "日常事务", subMenu: [
          {title: "出差拜访管理", link: "/html/BusinessTravel.html"},
          {title: "客户来访管理", link: "/html/CustomerVisit.html"},
          {title: "会议交流管理", link: "/html/MeetingExchange.html"},
        ]},
        {title: "系统设置", subMenu: [
          {title: "权限管理", link: "/html/authority.html"},
          {title: "用户管理", link: "/html/user.html"},
          {title: "枚举管理", link: "/html/enum.html"},
        ]}
      ]
    });
    that.delDialogComponent = that.getDelDialog();
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
      el: ".app-container",
      data: {
        name: ""
      },
      methods: {
        navMenuClickHendle: function(e) {
          var link = $(e.target).attr("link");
          if (link && that.oldLink != link) {
            that.oldLink = link;
            $.ic.loadUI.show();
            window.$navMenu.beforeChangeMenu && window.$navMenu.beforeChangeMenu();
            $('#main-content').load(link, ()=> {
              window.$navMenu.afterChangeMenu && window.$navMenu.afterChangeMenu();
              $.ic.loadUI.hide();
            });
          }
        }
      },
    });
  },
  /**
   * 额外事件绑定.
   */
  bindEvent: function () {
    window.onresize = this.adjustUI;
    window.$navMenu.beforeChangeMenu = function() {
      $("body").children().each(function(i, target) {
        if (target.id == "mainframe" || target.nodeName == "SCRIPT") {
          return;
        }
        $(target).remove();
      });
    }
  },
}

var main = new Main();
main.init();