var Customer = function () {
}

Customer.prototype = {
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
	adjustUI: function () {
	},
	/**
		* 初始化子组件.
		*/
	initComponent: function () {
		var that = this;
		that.addDialogComponent = that.getInsertDialog();
		that.editDialogComponent = that.getInsertDialog("修改");
		that.detailDialogComponent = that.getDetailDialog();
		that.delDialogComponent = that.getDelDialog();
		that.imptDialogComponent = that.getImptDialog();
	},
	newform: function () {
		return {
			gid: Util.uuid(32, 52),
			code: "",
			postalcode: '',
			name: '',
			area: '',
			address: '',
			site: '',
			origin: '',
			grade: '',
			stffName: '',
			uid: '',
			trade: '',
			status: '',
			regDate: new Date(),
			remark: '',
			country: '',
			province: '',
			city: '',
			nextTime: '',
			lastTime: '',
			createTime: new Date()
		}
	},
	getContact: function () {
		return {
			gid: Util.uuid(32, 52),
			name: '',
			sex: '',
			department: '',
			position: '',
			areaCode: '',
			phone: '',
			extension: '',
			mobile: '',
			email: '',
			area: '',
			mainContact: '',
			grade: '',
			remark: ''
		}
	},
	getActivity: function () {
		return {
			gid: Util.uuid(32, 52),
			subject: "",
			touchTime: '',
			record: '',
			type: '',
			nextTime: '',
			grade: '',
		}
	},
	/**
		* 获取新增对话框.
		*/
	getInsertDialog: function (flag) {
		var that = this;
		return new Dialog({
			title: flag ? "修改" : "新增",
			width: "50%",
			body:
				`<el-form ref="form" label-width="80px">
	<el-form-item label="客户名称">
		<el-input v-model="form.name"></el-input>
	</el-form-item>
	<el-form-item label="地区">
		<el-input v-model="form.area"></el-input>
	</el-form-item>
	<el-form-item label="详细地址">
		<el-row>
			<el-col :span="4">
				<el-select solt="prepend" v-model="form.country" @change="select_change" filterable placeholder="国家">
					<el-option v-for="item in countrys" :label="item.areaname" :value=item.areaid></el-option>
				</el-select>
			</el-col>
			<el-col :span="5">
				<el-select solt="prepend" v-model="form.province" @change="select_change" filterable placeholder="省份">
					<el-option v-for="item in provinces" :label="item.areaname" :value=item.areaid></el-option>
				</el-select>
			</el-col>
			<el-col :span="5">
				<el-select solt="prepend" v-model="form.city" filterable placeholder="城市">
					<el-option v-for="item in citys" :label="item.areaname" :value=item.areaid></el-option>
				</el-select>
			</el-col>
		</el-row>
	</el-form-item>
	<el-form-item label="公司网站">
		<el-input v-model="form.site"></el-input>
	</el-form-item>
	<el-form-item label="客户来源">
		<el-select solt="prepend" v-model="form.origin">
			<el-option v-for="item in origins" :label="item.name" :value="item.code"></el-option>
		</el-select>
	</el-form-item>
	<el-form-item label="所属行业">
		<el-select solt="prepend" v-model="form.trade">
			<el-option v-for="item in trades" :label="item.name" :value="item.code"></el-option>
		</el-select>
	</el-form-item>
	<el-form-item label="客户状态">
		<el-select solt="prepend" v-model="form.status">
			<el-option v-for="item in statuss" :label="item.name" :value="item.code"></el-option>
		</el-select>
	</el-form-item>
	<el-form-item label="登记日期">
		<el-date-picker v-model="form.regDate" type="date" placeholder="选择日期"></el-date-picker>
	</el-form-item>
	<el-form-item label="备注">
		<el-input type="textarea" v-model="form.remark"></el-input>
	</el-form-item>
	</el-form>`,
		data: {
			trades: window.ic_sms.enum["行业"],
			statuss: window.ic_sms.enum["客户状态"],
			origins: window.ic_sms.enum["客户来源"],
			countrys: window.ic_sms["国"],
			provinces: [],
			citys: [],
			form: that.newform()
		},
		methods: {
			select_change: function (areaid) {
				var curAdd, that = this;
				window.ic_sms.address.forEach((add) => {
					if (add.areaid == areaid) {
						return curAdd = add;
					}
				});
				if (!curAdd) return;
				var arr = window.ic_sms.address.filter((add) => {
					return add.parentid == areaid;
				});
				if (curAdd.level == "0") {
					that._vue.$data.provinces = arr;
					that._vue.$data.form.province = "";
				} else if (curAdd.level == "1") {
					that._vue.$data.citys = arr;
					that._vue.$data.form.city = "";
				}
			}
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
					var customer = dialogThis._vue.$data.form;
					customer.regDate = moment(customer.regDate).format("YYYY-MM-DD HH:mm:ss");
					flag || (customer.createTime = moment(customer.createTime).format("YYYY-MM-DD HH:mm:ss"));
					var url = flag ? "/customer/updateByPrimaryKey" : "/customer/insert";
					$.post(url, customer, function (data, status, xhr) {
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
			* 获取详情对话框.
			*/
		getDetailDialog: function () {
			var that = this;
			return new Dialog({
				title: "详情",
				width: "80%",
				body:
					`<h3>客户信息</h3>
			<el-form ref="form" label-width="102px">
				<el-row>
					<el-col :span="8">
						<el-form-item label="客户名称：">
							<el-input v-bind:value="form.name" :readOnly="true"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="客户行业：">
							<el-select solt="prepend" v-bind:value="form.trade" :readOnly="true" style="width:100%">
								<el-option v-for="item in trades" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="公司地址：">
							<el-input v-bind:value="form.area" :readOnly="true"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
			<el-col :span="8">
				<el-form-item label="客户来源：">
					<el-select solt="prepend" v-bind:value="form.origin" :readOnly="true" style="width:100%">
						<el-option v-for="item in origins" :label="item.name" :value="item.code"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :span="8">
				<el-form-item label="客户状态：">
					<el-select solt="prepend" v-bind:value="form.status" :readOnly="true" style="width:100%">
						<el-option v-for="item in statuss" :label="item.name" :value="item.code"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :span="8">
				<el-form-item label="所属业务员：">
					<el-select solt="prepend" v-bind:value="form.uid" :readOnly="true" style="width:100%">
						<el-option v-for="item in trades" :label="item.name" :value="item.code"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="8">
				<el-form-item label="省 份：">
					<el-select solt="prepend" v-bind:value="form.province" :readOnly="true" style="width:100%">
						<el-option v-for="item in provinces" :label="item.areaname" :value="item.areaid"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :span="8">
				<el-form-item label="城 市：">
					<el-select solt="prepend" v-bind:value="form.city" :readOnly="true" style="width:100%">
						<el-option v-for="item in citys" :label="item.areaname" :value="item.areaid"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :span="8">
				<el-form-item label="地 址：">
					<el-input v-bind:value="form.area" :readOnly="true"></el-input>
				</el-form-item>
			</el-col>
		</el-row>
		<el-form-item label="备 注：">
			<el-input type="textarea" v-bind:value="form.remark" :readOnly="true"></el-input>
		</el-form-item>
			</el-form>

			<h3>联系人信息</h3>
			<el-button @click="addContactEvent">新增</el-button>
			<el-table :data="contacts" border height="250" stripe style="width: 100%;">
				<el-table-column prop="name" label="姓名"></el-table-column>
				<el-table-column prop="department" label="部门"></el-table-column>
				<el-table-column prop="position" label="职位"></el-table-column>
				<el-table-column prop="landline" label="座机"></el-table-column>
				<el-table-column prop="extension" label="分机"></el-table-column>
				<el-table-column prop="mobile" label="手机"></el-table-column>
				<el-table-column prop="email" label="邮箱"></el-table-column>
				<el-table-column prop="lastTime" label="最后联系时间" width="180"></el-table-column>
				<el-table-column width="125" label="操作">
					<template slot-scope="scope">
						<el-button size="mini" @click="editBtnEvent(scope.$index, scope.row)"><i class="el-icon-edit"></i></el-button>
						<el-button size="mini" @click="delBtnEvent(scope.$index, scope.row)"><i class="el-icon-delete"></i></el-button>
					</template>
				</el-table-column>
			</el-table>

			<h3>活动信息</h3>
			<el-table :data="activitys" border height="250" stripe style="width: 100%;">
				<el-table-column prop="subject" label="活动主题"></el-table-column>
				<el-table-column prop="contact" label="联系人"></el-table-column>
				<el-table-column prop="touchTime" label="联系时间"></el-table-column>
				<el-table-column prop="record" label="沟通记录"></el-table-column>
				<el-table-column prop="type" label="联系类型"></el-table-column>
				<el-table-column prop="nextTime" label="下次联系时间"></el-table-column>
				<el-table-column prop="grade" label="关系等级"></el-table-column>
				<el-table-column width="125" label="操作">
					<template slot-scope="scope">
						<el-button size="mini" @click="editBtnEvent(scope.$index, scope.row)"><i class="el-icon-edit"></i></el-button>
						<el-button size="mini" @click="delBtnEvent(scope.$index, scope.row)"><i class="el-icon-delete"></i></el-button>
					</template>
				</el-table-column>
			</el-table>
			`,
				data: {
					trades: window.ic_sms.enum["行业"],
					statuss: window.ic_sms.enum["客户状态"],
					origins: window.ic_sms.enum["客户来源"],
					provinces: [],
					citys: [],
					contacts: [],
					activitys: [],
					form: that.newform()
				},
				methods: {
					addContactEvent: function () {
						this.children[0]._vue.$data.sign = "insert";
						this.children[0]._vue.$data.showTab = ["contact", "activity"];
						this.children[0].show();
					},
					editBtnEvent: (index, row) => {
						var ethis = that.detailDialogComponent;
						ethis.children[0]._vue.$data.sign = "updateByPrimaryKey";
						if (row.subject) {
							ethis.children[0]._vue.$data.showTab = ["activity"];
							ethis.children[0]._vue.$data.activity = row;
						} else {
							ethis.children[0]._vue.$data.showTab = ["contact"];
							ethis.children[0]._vue.$data.contact = row;
						}
						ethis.children[0].show();
					},
					delBtnEvent: (index, row) => {
						var ethis = that.detailDialogComponent;
						if (row.subject) {
							ethis.children[1]._vue.$data.sign = ["activity"];
							ethis.children[1]._vue.$data.rowData = row;
						} else {
							ethis.children[1]._vue.$data.sign = ["contact"];
							ethis.children[1]._vue.$data.rowData = row;
						}
						ethis.children[1].show();
					},
				},
				children: [
					{
						title: "联系人",
						width: "80%",
						body:
							`<el-form label-width="120px">
				<div v-show="showTab.includes('contact')">
				<el-row>
					<el-col :span="6">
						<el-form-item label="姓名：">
							<el-input v-model="contact.name"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="性别：">
							<el-select solt="prepend" v-model="contact.sex" style="width:100%">
								<el-option v-for="item in sexs" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="部门：">
							<el-select solt="prepend" v-model="contact.department" style="width:100%">
								<el-option v-for="item in departments" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="职位：">
							<el-select solt="prepend" v-model="contact.position" style="width:100%">
								<el-option v-for="item in positions" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="6">
						<el-form-item label="座机：">
							<el-input v-model="contact.areaCode" placeholder="区号"></el-input>
							<el-input v-model="contact.phone" placeholder="电话"></el-input>
							<el-input v-model="contact.extension" placeholder="分机"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="手机：">
							<el-input v-model="contact.mobile"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="邮箱：">
							<el-input v-model="contact.email"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="地 址：">
							<el-input v-model="contact.area"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="8">
						<el-form-item label="是否主责联系人：">
							<el-select solt="prepend" v-model="contact.mainContact" style="width:100%">
								<el-option v-for="item in isOrNot" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="关系等级：">
							<el-select solt="prepend" v-model="contact.grade" style="width:100%">
								<el-option v-for="item in grades" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				<el-form-item label="备 注：">
					<el-input type="textarea" v-model="contact.remark"></el-input>
				</el-form-item>
				</div>
				<div v-show="showTab.includes('activity')">
				<el-row>
					<el-col :span="12">
						<el-form-item label="活动主题：">
							<el-input v-model="activity.subject"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="联系类型：">
							<el-select solt="prepend" v-model="contact.type" style="width:100%">
								<el-option v-for="item in types" :label="item.name" :value="item.code"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				<el-form-item label="联系记录：">
					<el-input type="textarea" v-model="activity.record"></el-input>
				</el-form-item>
				<el-row>
					<el-col :span="12">
						<el-form-item label="联系时间：">
							<el-date-picker v-model="activity.touchTime" type="date" placeholder="选择日期"></el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="下次联系时间：">
							<el-date-picker v-model="activity.nextTime" type="date" placeholder="选择日期"></el-date-picker>
						</el-form-item>
					</el-col>
				</el-row>
				</div>
				</el-form>`,
					data: {
						sign: "",
						showTab: [],
						sexs: ic_sms.enum["性别"] || [],
						departments: ic_sms.enum["部门"] || [],
						positions: ic_sms.enum["职位"] || [],
						isOrNot: ic_sms.enum["是否"] || [],
						grades: ic_sms.enum["关系等级"] || [],
						types: ic_sms.enum["联系类型"] || [],
						contact: that.getContact(),
						activity: that.getActivity()
					},
					buttons: [
						{
							name: "关闭",
							event: function () {
								this.hide();
							}
						},
						{
							name: "操作",
							type: "primary",
							event: function () {
								var dialogThis = this;
								$.ic.loadUI.show();
								var contact = Util.clone(dialogThis._vue.$data.contact);
								var activity = Util.clone(dialogThis._vue.$data.activity);
								contact.cid = dialogThis.parent._vue.$data.form.gid;
								activity.cid = dialogThis.parent._vue.$data.form.gid;
								contact.createTime = moment().format("YYYY-MM-DD HH:mm:ss");
								activity.touchTime = moment(activity.touchTime).format("YYYY-MM-DD HH:mm:ss");
								activity.nextTime = moment(activity.nextTime).format("YYYY-MM-DD HH:mm:ss");
								async.series([
									function (callback) {
										if (!dialogThis._vue.$data.showTab.includes("contact")) {
											return callback(null);
										}
										$.post("/contact/" + dialogThis._vue.$data.sign, contact, function (data, status, xhr) {
											dialogThis._vue.$data.sign == "insert" && dialogThis.parent._vue.$data.contacts.push(contact);
											dialogThis._vue.$data.contact = that.getContact();
											callback(null);
										});
									},
									function (callback) {
										if (!dialogThis._vue.$data.showTab.includes("activity")) {
											return callback(null);
										}
										$.post("/activity/" + dialogThis._vue.$data.sign, activity, function (data, status, xhr) {
											dialogThis._vue.$data.sign == "insert" && dialogThis.parent._vue.$data.activitys.push(activity);
											dialogThis._vue.$data.activity = that.getActivity();
											callback(null);
										});
									}
								], function (err) {
									alert("操作完成");
									$.ic.loadUI.hide();
									dialogThis.hide();
								});
							}
						},
					]
					},
					{
						title: "删除",
						body: `是否删除该数据?`,
						data: {
							sign: "",
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
									$.post(`/${delDialogThis._vue.$data.sign}/deleteByPrimaryKey`, delDialogThis._vue.$data.rowData, function (data, status, xhr) {
										if (data.data > 0) {
											alert("删除成功");
											// var thisArr = that.detailDialogComponent._vue.$data[`${delDialogThis._vue.$data.sign}s`];
											// thisArr = thisArr.filter((dat)=> {
											// return dat.gid != delDialogThis._vue.$data.rowData.gid
											// });
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
							type: "primary",
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
					rowData: {name: ""}
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
							$.post("/customer/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
			* 获取导入对话框.
			*/
		getImptDialog: function () {
			return new Dialog({
				title: "导入",
				width: "30%",
				body:
					`<el-upload
			class="upload-demo"
			ref="upload"
			action="/customer/importExcel"
			:on-preview="handlePreview"
			:on-remove="handleRemove"
			multiple
			:file-list="fileList"
			:auto-upload="false">
			<el-button slot="trigger" size="small" type="primary">选取文件</el-button>
			<el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">导入数据</el-button>
			<div slot="tip" class="el-upload__tip">只能上传excel文件，且不超过100Mb</div>
			</el-upload>`,
				data: {
					fileList: []
				},
				methods: {
					submitUpload() {
						this._vue.$refs.upload.submit();
					},
					handleRemove(file, fileList) {
						console.log(file, fileList);
					},
					handlePreview(file) {
						console.log(file);
					}
				},
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
			* 完成组件初始化动作.
			*/
		completeComponent: function () {
			var that = this;
			var $tableTH = $("#CS_Table").children();
			this.titles = [];
			this.fields = [];
			$.each($tableTH, function (ind, row) {
				if($(row).attr("label")=="操作"){
					return
				}
				that.titles.push($(row).attr("label"))
				that.fields.push($(row).attr("prop"));
			});
			that.page_vue = new Vue({
				el: "#customer_app",
				data: {
					customList: [],
					trades: window.ic_sms.enum["行业"],
					statuss: window.ic_sms.enum["客户状态"],
					origins: window.ic_sms.enum["客户来源"],
					countrys: window.ic_sms["国"],
					provinces: [],
					citys: [],
					tooltip: true,
					search_form: {
						name: '',
						origin: '',
						grade: '',
						stffName: '',
						uid: '',
						trade: '',
						status: '',
						country: '',
						province: '',
						city: ''
					},
					customTotal: 0,
					currentPage: 1,
					pagesize: 10
				},
				methods: {
					addBtnEvent: () => {
						that.addDialogComponent.show();
					},
					importBtnEvt: function () {
						that.imptDialogComponent.show();
					},
					findBtnEvent: () => {
						that.loadTable();
					},
					cellClickEvent: (row, col, cell, e) => {
						if (col.property == "name") {
							that.detailDialogComponent._vue.$data.provinces = ic_sms.address.filter((add) => {
								return add.parentid == row.country
							});
							that.detailDialogComponent._vue.$data.citys = ic_sms.address.filter((add) => {
								return add.parentid == row.province
							});
							row.province = +row.province;
							row.city = +row.city;
							that.detailDialogComponent._vue.$data.form = row;
							var query = {cid: row.gid};
							$.ic.loadUI.show();
							async.series([
								function (callback) {
									$.post("/contact/selectByExample", query, function (response) {
										that.detailDialogComponent._vue.$data.contacts = response.data || [];
										callback(null);
									});
								},
								function (callback) {
									$.post("/activity/selectByExample", query, function (response) {
										that.detailDialogComponent._vue.$data.activitys = response.data || [];
										callback(null);
									});
								}
							], function (err) {
								$.ic.loadUI.hide();
								if (err) {
									return alert(JSON.stringify(err));
								}
								that.detailDialogComponent.show();
							});
						}
					},
					select_change: (areaid) => {
						var curAdd;
						window.ic_sms.address.forEach((add) => {
							if (add.areaid == areaid) {
								return curAdd = add;
							}
						});
						if (!curAdd) return;
						var arr = window.ic_sms.address.filter((add) => {
							return add.parentid == areaid;
						});
						if (curAdd.level == "0") {
							that.page_vue.$data.provinces = arr;
							that.page_vue.$data.search_form.province = "";
						} else if (curAdd.level == "1") {
							that.page_vue.$data.citys = arr;
							that.page_vue.$data.search_form.city = "";
						}
					},
					editBtnEvent: (index, row) => {
						that.editDialogComponent._vue.$data.provinces = ic_sms.address.filter((add) => {
							return add.parentid == row.country
						});
						that.editDialogComponent._vue.$data.citys = ic_sms.address.filter((add) => {
							return add.parentid == row.province
						});
						row.province = +row.province;
						row.city = +row.city;
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
							case "city":
								obj = ic_sms.address.filter((item) => {
									return item.areaid == cellValue
								})[0] || {};
								return obj.areaname || "";
							case "origin":
								obj = ic_sms.enum["客户来源"].filter((item) => {
									return item.code == cellValue
								})[0] || {};
								return obj.name || "";
							case "trade":
								obj = ic_sms.enum["行业"].filter((item) => {
									return item.code == cellValue
								})[0] || {};
								return obj.name || "";
							case "status":
								obj = ic_sms.enum["客户状态"].filter((item) => {
									return item.code == cellValue
								})[0] || {};
								return obj.name || "";
							default:
								return cellValue;
						}
					},
					exportTable: () => {
						var searchForm=that.page_vue.$data.search_form;
						var cloneObj = Util.clone(searchForm);
						cloneObj.name = cloneObj.name ? `%${cloneObj.name}%` : '';
						exportTable("customer",searchForm,this.titles,this.fields,"电话拓展管理");
					},
					handleSizeChange: function (val) {
						that.page_vue.$data.pagesize = val;
						that.pagingQuery();
					},
					handleCurrentChange: function (val) {
						that.page_vue.$data.currentPage = val;
						that.pagingQuery();
					}
				},
			})
		},
		pagingQuery: function(callback) {
			var that = this;
			$.ic.loadUI.show();
			var param = {
				entity: that.curQueryObj,
				pageNum: that.page_vue.$data.currentPage,
				size: that.page_vue.$data.pagesize,
				jcls: "com.iconfluence.sms.model.IcSmsCustomer"
			};
			$api("/customer/selectByExampleAndPage", JSON.stringify(param), function (data) {
				if (data.status == "fail" && callback) {
					return callback(data.data.errMsg);
				}
				callback || $.ic.loadUI.hide();
				if (data.status == "fail") {
					return alert(data.data.errMsg);
				} else {
					that.page_vue.$data.customList = data.data || [];
					callback && callback(null);
				}
			})
		},
		/**
			* 额外事件绑定.
			*/
		bindEvent: function () {
			var that = this;
		},
		/**
			* 加载表格
			*/
		loadTable: function () {
			var that = this;
			$.ic.loadUI.show();
			that.curQueryObj = Util.clone(that.page_vue.$data.search_form);
			that.curQueryObj.name = that.curQueryObj.name ? `%${that.curQueryObj.name}%` : '';
			async.parallel([
				(cb)=> {
					$.post("customer/countByExample", that.curQueryObj, function(res) {
						that.page_vue.$data.customTotal = res.data || 0;
						cb(null)
					});
				},
				$.proxy(that.pagingQuery, that)
			], function(err) {
				$.ic.loadUI.hide();
				if (err) {
					alert(err);
				}
			})
		}
}

var custom = new Customer();
custom.init();

