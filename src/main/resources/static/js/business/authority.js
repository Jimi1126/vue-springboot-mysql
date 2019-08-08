var Authority = function() {}

Authority.prototype = {
	name: 'authority',
  auths: [],
  users: [],
	/**
		* 构造组件动作.
		*/
	init: function() {
    this.adjustUI();
    this.initData();
		this.initComponent();
		this.completeComponent();
		this.bindEvent();
		this.loadTable();
	},
	/**
		* 调整UI.
		*/
  adjustUI: function() {},
  initData: function(callback) {
    var that = this;
    async.parallel([
      function(cb) {
        $.post("/authority/selectByExample", function(response) {
          that.auths = that.addDialogComponent._vue.$data.auths = response.data || [];
          that.auths = that.editDialogComponent._vue.$data.auths = response.data || [];
          cb(null);
        });
      },
      function(cb) {
        $.post("/user/selectByExample", function(response) {
          that.users = that.addDialogComponent._vue.$data.users = response.data || [];
          that.users = that.editDialogComponent._vue.$data.users = response.data || [];
          cb(null);
        });
      }
    ], function(err) {
      callback && callback(err);
    });
  },
	/**
		* 初始化子组件.
		*/
	initComponent: function() {
		var that = this;
		var that = this;
		that.addDialogComponent = that.getAddDialog();
		that.editDialogComponent = that.getAddDialog("修改");
		that.authDialogComponent = that.getAuthControlDialog();
		that.delDialogComponent = that.getDelDialog();
	},
	/**
		* 获取一个新控制对象.
		*/
	newControlform: function () {
		return {
			gid: Util.uuid(32, 52),
			authid: [],
			authname: [],
			userid:[],
			username:[],
			state:'0001'
		}
  },
  /**
		* 获取一个新权限对象.
		*/
	newform: function () {
		return {
			gid: Util.uuid(32, 52),
			authid: "",
			authname: '',
			keyword:'',
			roles:[],
			state:'0001'
		}
	},
	getAddDialog: function (flag) {
		var that = this;
		return new Dialog({
			title: flag ? "修改" : "新增",
			width: "30%",
			body: 
			`<el-form ref="form" label-width="90px">
        <el-form-item label="权限：">
					<el-select solt="prepend" multiple v-model="form.authid" style="width: 100%">
						<el-option v-for="item in auths" :label="item.name" :value=item.gid></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="用户：">
					<el-select solt="prepend" multiple v-model="form.userid" style="width: 100%">
						<el-option v-for="item in users" :label="item.name" :value=item.gid></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="状态：">
					<el-select solt="prepend" v-model="form.state" style="width: 100%">
						<el-option v-for="item in statuss" :label="item.name" :value=item.code></el-option>
					</el-select>
				</el-form-item>
			</el-form>`,
			data: {
				auths: that.auths.filter((aut)=> {return aut.roles.indexOf(ic_sms.user.rid) > -1}),
				users: that.users,
				statuss: ic_sms.enum["停启用"],
				form: that.newControlform()
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
						var authority = Util.clone(dialogThis._vue.$data.form);
            authority.authid = authority.authid.join(",");
            authority.userid = authority.userid.join(",");
            authority.authname = dialogThis._vue.$data.auths.reduce(function(pro, cur) {
              if (typeof pro == "object") {
                if (authority.authid.indexOf(pro.gid) == -1 && authority.authid.indexOf(cur.gid) == -1) {
                  return "";
                }
                if (authority.authid.indexOf(cur.gid) == -1) {
                  return pro.name;
                }
                if (authority.authid.indexOf(pro.gid) == -1) {
                  return cur.name;
                }
                return `${pro.name},${cur.name}`;
              }
              if (authority.authid.indexOf(cur.gid) == -1) {
                return pro;
              }
              return `${pro},${cur.name}`;
            });
            authority.username = dialogThis._vue.$data.users.reduce(function(pro, cur) {
              if (typeof pro == "object") {
                if (authority.userid.indexOf(pro.gid) == -1 && authority.userid.indexOf(cur.gid) == -1) {
                  return "";
                }
                if (authority.userid.indexOf(cur.gid) == -1) {
                  return pro.name;
                }
                if (authority.userid.indexOf(pro.gid) == -1) {
                  return cur.name;
                }
                return `${pro.name},${cur.name}`;
              }
              if (authority.userid.indexOf(cur.gid) == -1) {
                return pro;
              }
              return `${pro},${cur.name}`;
            });
						var url = flag ? "/accessControl/updateByPrimaryKey" : "/accessControl/insert";
						$.post(url, authority, function(data, status, xhr) {
							$.ic.loadUI.hide();
							if (data.data == 1) {
								alert("操作成功");
								dialogThis._vue.$data.form = that.newControlform();
							}
							dialogThis.hide();
						});
					}
				},
			]
		});
	},
	getAuthControlDialog: function () {
		var that = this;
		return new Dialog({
			title: "权限控制",
			body: 
      `<el-button @click="addAuthEvent">新增权限控制</el-button>
      <el-table :data="authList" border height="320" stripe style="width: 100%;">
				<el-table-column prop="name" :show-overflow-tooltip="tooltip" label="权限名称"></el-table-column>
				<el-table-column prop="machine" :show-overflow-tooltip="tooltip" sortable :formatter="displayFormat" label="控制类型"></el-table-column>
				<el-table-column prop="keyword" :show-overflow-tooltip="tooltip" label="控制标识" sortable></el-table-column>
				<el-table-column prop="roles" :show-overflow-tooltip="tooltip" :formatter="displayFormat" label="应用角色"></el-table-column>
				<el-table-column prop="state" :show-overflow-tooltip="tooltip" :formatter="displayFormat" label="状态"></el-table-column>
				<el-table-column width="125" label="操作">
					<template slot-scope="scope">
						<el-button size="mini" @click="editBtnEvent(scope.$index, scope.row)"><i class="el-icon-edit"></i></el-button>
						<el-button size="mini" @click="delBtnEvent(scope.$index, scope.row)"><i class="el-icon-delete"></i></el-button>
					</template>
				</el-table-column>
			</el-table>`,
			data: {
				authList: [],
				tooltip: true,
			},
			methods: {
				addAuthEvent: function () {
					var ethis = that.authDialogComponent;
					ethis.children[0]._vue.$data.sign = "insert";
					ethis.children[0]._vue.$data.form = that.newform();
					ethis.children[0].show();
				},
				editBtnEvent: (index, row) => {
					var ethis = that.authDialogComponent;
					ethis.children[0]._vue.$data.sign = "updateByPrimaryKey";
					ethis.children[0]._vue.$data.form = row;
					ethis.children[0].show();
				},
				delBtnEvent: (index, row) => {
          var ethis = that.authDialogComponent;
					ethis.children[1]._vue.$data.form = row;
					ethis.children[1].show();
        },
        displayFormat: function(row, column, cellValue, index) {
					var obj;
					switch(column.property) {
						case "machine":
							obj = ic_sms.enum["控制类型"].filter((item)=> {return item.code == cellValue})[0] || {};
              return obj.name || "";
            case "roles":
              obj = ic_sms.enum["角色"].filter((item)=> {return cellValue.indexOf(item.code) > -1}).map((it)=> {return it.name}) || [];
              return obj.join(",");
            case "state":
              obj = ic_sms.enum["停启用"].filter((item)=> {return item.code == cellValue})[0] || {};
              return obj.name || "";
						default:
							return cellValue;
					}
				}
			},
			children: [
				{
					title: "新增|修改",
					width: "30%",
					body: 
					`<el-form ref="form" label-width="90px">
						<el-form-item label="权限名称：">
							<el-input v-model="form.name"></el-input>
						</el-form-item>
						<el-form-item label="控制类型：">
							<el-select solt="prepend" v-model="form.machine" style="width: 100%">
								<el-option v-for="item in types" :label="item.name" :value=item.code></el-option>
							</el-select>
						</el-form-item>
						<el-form-item label="控制标识：">
							<el-input v-model="form.keyword"></el-input>
						</el-form-item>
						<el-form-item label="应用角色：">
							<el-select solt="prepend" multiple v-model="form.roles" style="width: 100%">
								<el-option v-for="item in roles" :label="item.name" :value=item.code></el-option>
							</el-select>
						</el-form-item>
						<el-form-item label="状态：">
							<el-select solt="prepend" v-model="form.state" style="width: 100%">
								<el-option v-for="item in statuss" :label="item.name" :value=item.code></el-option>
							</el-select>
						</el-form-item>
					</el-form>`,
					data: {
						types: ic_sms.enum["控制类型"],
						roles: ic_sms.enum["角色"],
						statuss: ic_sms.enum["停启用"],
						sign: "",
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
							name: "新增|修改",
							type: "primary",
							event: function () {
								var dialogThis = this;
								$.ic.loadUI.show();
								var authority = Util.clone(dialogThis._vue.$data.form);
								authority.roles = authority.roles && authority.roles.join(",");
								var url = `/authority/${dialogThis._vue.$data.sign}`;
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
				},
				{
          title: "删除",
          width: "320px",
					body: `是否删除该数据?`,
					data: {
						rowData: {}
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
								var delDialogThis = this;
								$.post("/authority/deleteByPrimaryKey", delDialogThis._vue.$data.rowData, function (data, status, xhr) {
									if (data.data > 0) {
										alert("删除成功");
										delDialogThis.hide();
									} else {
										alert("删除失败");
									}
								});
							}
						}
					]
				}
			],
			buttons: [
				{
					name: "关闭",
					event: function () {
						this.hide();
					}
				}
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
						$.post("/accessControl/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
				tooltip: true,
				search_form: {
					username: "",
					authname: '',
				}
			},
			methods: {
				addBtnEvent: $.getRole( that.name, "addBtn", () => {
          that.addDialogComponent.show();
				}),
				authBtnEvent: $.getRole( that.name, "authBtn", () => {
					$.post("/authority/selectByExample", function(response) {
            that.authDialogComponent._vue.$data.authList = response.data || [];
            that.authDialogComponent._vue.$data.authList.forEach((item)=> {
              item.roles = item.roles ? item.roles.split(",") : [];
            });
            that.authDialogComponent.show();
          });
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
						case "state":
							obj = ic_sms.enum["停启用"].filter((item)=> {return item.code == cellValue})[0] || {};
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
  bindEvent: function () {
  },
	/**
		* 加载表格
		*/
	loadTable: function() {
		var that = this;
		$.ic.loadUI.show();
		var cloneObj = Util.clone(that.page_vue.$data.search_form);
		cloneObj.authname = `%${cloneObj.authname}%`;
		cloneObj.username = `%${cloneObj.username}%`;
		$.post("/accessControl/selectByExample", cloneObj, function(data) {
      that.page_vue.$data.mainList = data.data || [];
      that.page_vue.$data.mainList.forEach((item)=> {
        item.authid = item.authid ? item.authid.split(",") : [];
        item.authname = item.authname ? item.authname.split(",") : [];
        item.userid = item.userid ? item.userid.split(",") : [];
        item.username = item.username ? item.username.split(",") : [];
      })
			$.ic.loadUI.hide();
		});
	}
}

var auth = new Authority();
auth.init();
