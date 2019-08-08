package com.iconfluence.sms.model;

public class IcSmsCustomerActivity extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.GID
     *
     * @mbg.generated
     */
    private String gid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.CID
     *
     * @mbg.generated
     */
    private String cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.SUBJECT
     *
     * @mbg.generated
     */
    private String subject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.CONTACT
     *
     * @mbg.generated
     */
    private String contact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.TOUCH_TIME
     *
     * @mbg.generated
     */
    private String touchTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.RECORD
     *
     * @mbg.generated
     */
    private String record;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.TYPE
     *
     * @mbg.generated
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.NEXT_TIME
     *
     * @mbg.generated
     */
    private String nextTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.POTENTIAL
     *
     * @mbg.generated
     */
    private String potential;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.REMARK
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.CREATE_TIME
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_sms_customer_activity.grade
     *
     * @mbg.generated
     */
    private String grade;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public IcSmsCustomerActivity(String gid, String cid, String subject, String contact, String touchTime, String record, String type, String nextTime, String potential, String remark, String createTime, String grade) {
        this.gid = gid;
        this.cid = cid;
        this.subject = subject;
        this.contact = contact;
        this.touchTime = touchTime;
        this.record = record;
        this.type = type;
        this.nextTime = nextTime;
        this.potential = potential;
        this.remark = remark;
        this.createTime = createTime;
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public IcSmsCustomerActivity() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.GID
     *
     * @return the value of ic_sms_customer_activity.GID
     *
     * @mbg.generated
     */
    public String getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.GID
     *
     * @param gid the value for ic_sms_customer_activity.GID
     *
     * @mbg.generated
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.CID
     *
     * @return the value of ic_sms_customer_activity.CID
     *
     * @mbg.generated
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.CID
     *
     * @param cid the value for ic_sms_customer_activity.CID
     *
     * @mbg.generated
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.SUBJECT
     *
     * @return the value of ic_sms_customer_activity.SUBJECT
     *
     * @mbg.generated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.SUBJECT
     *
     * @param subject the value for ic_sms_customer_activity.SUBJECT
     *
     * @mbg.generated
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.CONTACT
     *
     * @return the value of ic_sms_customer_activity.CONTACT
     *
     * @mbg.generated
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.CONTACT
     *
     * @param contact the value for ic_sms_customer_activity.CONTACT
     *
     * @mbg.generated
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.TOUCH_TIME
     *
     * @return the value of ic_sms_customer_activity.TOUCH_TIME
     *
     * @mbg.generated
     */
    public String getTouchTime() {
        return touchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.TOUCH_TIME
     *
     * @param touchTime the value for ic_sms_customer_activity.TOUCH_TIME
     *
     * @mbg.generated
     */
    public void setTouchTime(String touchTime) {
        this.touchTime = touchTime == null ? null : touchTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.RECORD
     *
     * @return the value of ic_sms_customer_activity.RECORD
     *
     * @mbg.generated
     */
    public String getRecord() {
        return record;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.RECORD
     *
     * @param record the value for ic_sms_customer_activity.RECORD
     *
     * @mbg.generated
     */
    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.TYPE
     *
     * @return the value of ic_sms_customer_activity.TYPE
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.TYPE
     *
     * @param type the value for ic_sms_customer_activity.TYPE
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.NEXT_TIME
     *
     * @return the value of ic_sms_customer_activity.NEXT_TIME
     *
     * @mbg.generated
     */
    public String getNextTime() {
        return nextTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.NEXT_TIME
     *
     * @param nextTime the value for ic_sms_customer_activity.NEXT_TIME
     *
     * @mbg.generated
     */
    public void setNextTime(String nextTime) {
        this.nextTime = nextTime == null ? null : nextTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.POTENTIAL
     *
     * @return the value of ic_sms_customer_activity.POTENTIAL
     *
     * @mbg.generated
     */
    public String getPotential() {
        return potential;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.POTENTIAL
     *
     * @param potential the value for ic_sms_customer_activity.POTENTIAL
     *
     * @mbg.generated
     */
    public void setPotential(String potential) {
        this.potential = potential == null ? null : potential.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.REMARK
     *
     * @return the value of ic_sms_customer_activity.REMARK
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.REMARK
     *
     * @param remark the value for ic_sms_customer_activity.REMARK
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.CREATE_TIME
     *
     * @return the value of ic_sms_customer_activity.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.CREATE_TIME
     *
     * @param createTime the value for ic_sms_customer_activity.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_sms_customer_activity.grade
     *
     * @return the value of ic_sms_customer_activity.grade
     *
     * @mbg.generated
     */
    public String getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_sms_customer_activity.grade
     *
     * @param grade the value for ic_sms_customer_activity.grade
     *
     * @mbg.generated
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}