var Main = function () { }

Main.prototype = {
  oldLink: "",
  /**
   * 构造组件动作.
   */
  init: function () {
    var that = this;
    this.adjustUI();
    this.initData(function() {
      that.initComponent();
      that.completeComponent();
      that.bindEvent();
    });
  },
  /**
   * 初始化数据.
   */
  initData: function(next) {
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
          callback(null);
        });
      },
      (callback)=> {
        $.post("/enum/selectByExample", function(res) {
          res.data.forEach((en)=> {
            window.ic_sms.enum[en.typeName] || (window.ic_sms.enum[en.typeName] = []);
            window.ic_sms.enum[en.typeName].push(en);
          });
          for (var key in window.ic_sms.enum) {
            window.ic_sms.enum[key] = window.ic_sms.enum[key].sort((a, b)=> {
              return +a.code - +b.code;
            })
          }
          ic_sms.getEnum("角色").forEach((it)=> {
            if (it.code == ic_sms.user.rid) {
              return ic_sms.user.rName = it.name;
            }
          });
          ic_sms.getEnum("职位").forEach((it)=> {
            if (it.code == ic_sms.user.pid) {
              return ic_sms.user.pName = it.name;
            }
          });
          ic_sms.getEnum("员工状态").forEach((it)=> {
            if (it.code == ic_sms.user.status) {
              return ic_sms.user.status = it.name;
            }
          });
          callback(null);
        });
        window.ic_sms.getEnum = function(str) {
          return window.ic_sms.enum[str] || []
        }
      },
      (callback)=> {
        $.post("/user/selectByExample", function(res) {
          window.ic_sms.enum["用户"] = res.data;
          callback(null);
        });
      },
      (callback)=> {
        $.post("/authority/selectByExample", function(res) {
          ic_sms.auths = res.data || [];
          callback(null);
        });
      },
      (callback)=> {
        $.post("/accessControl/selectByExample", function(res) {
          ic_sms.accessControl = {};
          var list = res.data || [];
          list.forEach((it)=> {
            ic_sms.accessControl[it.authid] = ic_sms.accessControl[it.authid] || "";
            ic_sms.accessControl[it.authid] += "," + it.userid;
          })
          callback(null);
        });
      }
    ], (err)=>{
      $.ic.loadUI.hide();
      next(err);
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
    var menuList = [
      {title: "业务管理", type: "01", subMenu: [
        {title: "电话拓展管理", type: "02", link: "/html/customer.html"},
        {title: "合同管理", type: "02", link: "/html/contract.html"},
        {title: "客户采购系统管理", type: "02", link: "/html/customerBSM.html"},
      ]},
      {title: "日常事务", type: "01", subMenu: [
        {title: "出差拜访管理", type: "02", link: "/html/BusinessTravel.html"},
        {title: "客户来访管理", type: "02", link: "/html/CustomerVisit.html"},
        {title: "会议交流管理", type: "02", link: "/html/MeetingExchange.html"},
      ]},
      {title: "系统设置", type: "01", subMenu: [
        {title: "权限管理", type: "02", link: "/html/authority.html"},
        {title: "用户管理", type: "02", link: "/html/user.html"},
        {title: "枚举管理", type: "02", link: "/html/enum.html"},
      ]}
    ];
    var curRoleMenu = ic_sms.auths.filter((item)=> {
      return item.machine == "0001" && item.roles.indexOf(ic_sms.user.rid) > -1
    }).map((item)=> {
      return item.keyword;
    });
    var fun = function(arr1, arr2) {
      arr1.forEach((it)=> {
        if (arr2.indexOf(it.title) == -1) {
          it.hidden = true;
        }
        if (it.subMenu) {
          fun(it.subMenu, arr2);
        }
      });
    }
    fun(menuList, curRoleMenu);
    window.$navMenu = $("#nav-menu").navList({
      default: [1],
      data: menuList
    });
  },
  /**
   * 获取退出对话框.
   */
  getQuitDialog: function () {
    return new Dialog({
      title: "退出",
      width: "320px",
      body: `是否退出系统?`,
      buttons: [
        {
          name: "取消",
          event: function () {
            this.hide();
          }
        },
        {
          name: "确定",
          type: "primary",
          event: function () {
            var that = this;
            window.location.href = "/"
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
        user: ic_sms.user || {},
        condition: true
      },
      methods: {
        quitEvent: function() {
          that.getQuitDialog().show();
        },
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