var MeetingExchange = function () {
}

MeetingExchange.prototype = {
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
            meetingTime: new Date(),
            country: '',
            provience: '',
            city: '',
            theme: '',
            hlUser: '',
            objective: '',
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
                        v-model="form.meetingTime"
                        align="right"
                        type="datetime"
                        placeholder="选择日期"
                        format="MM月dd日 HH:mm">
                      </el-date-picker>
                     </el-form-item>
                     <el-form-item label="地区:">  
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
                          <el-select v-model="form.provience" placeholder="省份" @change="select_change" clearable>
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
                      <el-form-item label="会议主题:">
                        <el-input v-model="form.theme"></el-input>
                      </el-form-item>
                      <el-form-item label="HL参会人员:">
                        <el-input v-model="form.hlUser"></el-input>
                      </el-form-item>
                      <el-form-item label="参会目的:">
                        <el-input v-model="form.objective"></el-input>
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
                        var meeting = dialogThis._vue.$data.form;
                        meeting.meetingTime = moment(meeting.meetingTime).format("MM-DD HH:mm");
                        meeting.year = moment(meeting.year).format("YYYY");
                        var url = flag ? "/meeting/updateByPrimaryKey" : "/meeting/insert";
                        $.post(url, meeting, function (data, status, xhr) {
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
                        $.post("/meeting/deleteByPrimaryKey", that._vue.$data.rowData, function (data, status, xhr) {
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
        that.mainTable = new Vue({
            el: "#MeetingExchange",
            data: {
                countrys: window.ic_sms["国"],
                provinces: [],
                citys: [],
                search_form: {
                    year: "",
                    meetingTime: "",
                    province: "",
                    city: "",
                    theme: ""
                },
                MeetingTable: [],
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
                search: () => {
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
            },
        })
    },
    loadTable: function () {
        var that = this;
        $.ic.loadUI.show();
        var cloneObj = Util.clone(that.mainTable.$data.search_form);
        cloneObj.theme = `%${cloneObj.theme}%`;
        var unconveMonth = cloneObj.meetingTime;
        cloneObj.meetingTime = `%${cloneObj.meetingTime}%`;
        $.post("/meeting/selectByExample", cloneObj, function (data) {
            if (cloneObj.meetingTime !== "%%") {
                data.data.forEach(function (item, index) {
                    var month = item.meetingTime.split(" ")[0].split("-")[0];
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
                    if (address.areaid == data.provience) {
                        data.provience = address.areaname;
                    }
                });
            });
            that.mainTable.$data.MeetingTable = data.data || [];
            $.ic.loadUI.hide();
        })
    }

}

var MeetingExchange = new MeetingExchange();
MeetingExchange.init();