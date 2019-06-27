var BusinessTravel = function () {
}

BusinessTravel.prototype = {
    /**
     * 构造组件动作.
     */
    init: function () {
        this.adjustUI();
        this.initComponent();
        this.completeComponent();
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
        that.delDialogComponent = that.getDelDialog();
    },
    newform: function () {
        return {
            gid: Util.uuid(32, 52),
            year: "",
            visitTime: new Date(),
            visitUnit: '',
            country: '',
            province: '',
            city: '',
            objective: '',
            cUser: '',
            hlUser: '',
            result: '',
            remark: ''
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
                `<el-form ref="form"  label-width="120px">
                    <el-form-item label="年份:">
                      <el-date-picker
                        v-model="form.year"
                        align="right"
                        type="year"
                        placeholder="选择年">
                      </el-date-picker>
                     </el-form-item>
                     <el-form-item label="日期:">
                      <el-date-picker
                        v-model="form.visitTime"
                        align="right"
                        type="datetime"
                        placeholder="选择日期"
                        format="MM月dd日 HH:mm">
                      </el-date-picker>
                     </el-form-item>
                     <el-form-item label="拜访单位:">
                       <el-input v-model="form.visitUnit"></el-input>
                     </el-form-item>
                     <el-form-item label="所在城市:">  
                      <el-row>
                        <el-col :span="5">
                            <el-select  v-model="form.country" placeholder="国" @change="select_change" clearable>
                                <el-option
                                    v-for="item in countrys"
                                    :label="item.areaname"
                                    :value="item.areaid">
                                </el-option>
                            </el-select>
                        </el-col>
                        <el-col :span="5">
                          <el-select v-model="form.province" placeholder="省份" @change="select_change" clearable>
                            <el-option
                              v-for="item in provinces"
                              :label="item.areaname"
                              :value="item.areaid">
                            </el-option>
                          </el-select>
                        </el-col>
                          <el-col :span="5">
                              <el-select v-model="form.city" placeholder="城市" @change="select_change" clearable>
                                <el-option
                                  v-for="item in citys"
                                  :label="item.areaname"
                                  :value="item.areaid">
                                </el-option>
                              </el-select>
                          </el-col>
                      </el-form-item>
                      <el-form-item label="拜访目的:">
                        <el-input v-model="form.objective"></el-input>
                      </el-form-item>
                      <el-form-item label="客户接访人员:">
                        <el-input v-model="form.cUser"></el-input>
                      </el-form-item>
                      <el-form-item label="HL拜访参与人员:">
                        <el-input v-model="form.hlUser"></el-input>
                      </el-form-item>
                      <el-form-item label="拜访效果:">
                        <el-input v-model="form.result"></el-input>
                      </el-form-item>
                      <el-form-item label="备注:">
                        <el-input
                          type="textarea"
                          :rows="2"
                          placeholder="请输入内容"
                          v-model="form.remark">
                        </el-input>
                       </el-form-item>
                    </el-form>`,
            data: {
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
                        var businessVisit = dialogThis._vue.$data.form;
                        businessVisit.visitTime = moment(businessVisit.visitTime).format("MM-DD HH:mm");
                        businessVisit.year = moment(businessVisit.year).format("YYYY");
                        var url = flag ? "/businessVisit/updateByPrimaryKey" : "/businessVisit/insert";
                        $.post(url, businessVisit, function (data, status, xhr) {
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
                        var that = this;
                        $.post("/businessVisit/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
    completeComponent: function () {
        var that = this;
        var $tableTH = $("#BT_table").children();
        this.titles = [];
        this.fields = [];
        $.each($tableTH, function (ind, row) {
            if($(row).attr("label")=="操作"){
                return
            }
            that.titles.push($(row).attr("label"))
            that.fields.push($(row).attr("prop"));
        });
        that.mainTable = new Vue({
            el: "#BusinessTravel",
            data: {
                travelTable: [],
                message: "lrmtest",
                input: "",
                dialogVisible: false,
                countrys: window.ic_sms["国"],
                provinces: [],
                citys: [],
                search_form: {
                    year: "",
                    visitTime: "",
                    visitUnit: "",
                    province: "",
                    city: "",
                },
                months: [{
                    lable: "一月",
                    value: "01"
                }, {
                    lable: "二月",
                    value: "02"
                }, {
                    lable: "三月",
                    value: "03"
                }, {
                    lable: "四月",
                    value: "04"
                }, {
                    lable: "五月",
                    value: "05"
                }, {
                    lable: "六月",
                    value: "06"
                }, {
                    lable: "七月",
                    value: "07"
                }, {
                    lable: "八月",
                    value: "08"
                }, {
                    lable: "九月",
                    value: "09"
                }, {
                    lable: "十月",
                    value: "10"
                }, {
                    lable: "十一月",
                    value: "11"
                }, {
                    lable: "十二月",
                    value: "12"
                }]
            },
            methods: {
                addBtnEvent: () => {
                    that.addDialogComponent.show();
                },

                editBtnEvent: (index, row) => {
                    that.editDialogComponent._vue.$data.provinces = ic_sms.address.filter((add) => {
                        return add.parentid == row.country
                    });
                    that.editDialogComponent._vue.$data.citys = ic_sms.address.filter((add) => {
                        return add.parentid == row.province
                    });
                    that.editDialogComponent._vue.$data.form = Util.clone(row);
                    that.editDialogComponent._vue.$data.form.country=window.ic_sms["国"][0];
                    that.editDialogComponent._vue.$data.form.cUser = that.editDialogComponent._vue.$data.form.cuser;
                    that.editDialogComponent.show();
                },
                delBtnEvent: (index, row) => {
                    that.delDialogComponent._vue.$data.rowData = row;
                    that.delDialogComponent.show();
                },
                search() {
                    that.loadTable();
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
                        that.mainTable.$data.provinces = arr;
                        that.mainTable.$data.search_form.province = "";
                    } else if (curAdd.level == "1") {
                        that.mainTable.$data.citys = arr;
                        that.mainTable.$data.search_form.city = "";
                    }
                },
                exportTable:()=>{
                    var searchForm=that.page_vue.$data.search_form;
                    var cloneObj = Util.clone(searchForm);
                    cloneObj.visitUnit = cloneObj.visitUnit ? `%${cloneObj.visitUnit}%` : '';
                    exportTable("businessVisit",searchForm,this.titles,this.fields,"出差拜访管理");
                }

            },
        })
    },
    loadTable: function () {
        var that = this;
        $.ic.loadUI.show();
        var cloneObj = Util.clone(that.mainTable.$data.search_form);
        cloneObj.visitUnit = `%${cloneObj.visitUnit}%`;
        var unconveMonth = cloneObj.visitTime;
        cloneObj.visitTime = `%${cloneObj.visitTime}%`;
        $.post("/businessVisit/selectByExample", cloneObj, function (data) {
            if (cloneObj.visitTime !== "%%") {
                data.data.forEach(function (item, index) {
                    var month = item.visitTime.split(" ")[0].split("-")[0];
                    if (month != unconveMonth) {
                        data.data.splice(index, 1);
                    }
                });
            }
            window.ic_sms.address.forEach(function (address) {
                data.data.forEach(function (data) {
                    if (address.areaid == data.city) {
                        data.city = address.areaname;
                    }
                    if (address.areaid == data.province) {
                        data.province = address.areaname;
                    }
                });
            });
            that.mainTable.$data.travelTable = data.data || [];
            $.ic.loadUI.hide();
        })
    }
}

var BusinessTravel = new BusinessTravel();
BusinessTravel.init();