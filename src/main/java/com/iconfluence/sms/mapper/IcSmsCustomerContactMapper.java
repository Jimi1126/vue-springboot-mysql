package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsCustomerContact;
import com.iconfluence.sms.model.IcSmsCustomerContactExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IcSmsCustomerContactMapper extends BaseMapper<IcSmsCustomerContact, IcSmsCustomerContactExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsCustomerContactSqlProvider.class, method="countByExample")
    long countByExample(IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @DeleteProvider(type=IcSmsCustomerContactSqlProvider.class, method="deleteByExample")
    int deleteByExample(IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ic_sms_customer_contact",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ic_sms_customer_contact (gid, cid, ",
        "name, department, ",
        "phone, mobile, qq, ",
        "msn, icq, email, ",
        "is_important, remark, ",
        "create_time, fax, ",
        "area_code, extension, ",
        "sex)",
        "values (#{gid,jdbcType=VARCHAR}, #{cid,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{department,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, ",
        "#{msn,jdbcType=VARCHAR}, #{icq,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{isImportant,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=VARCHAR}, #{fax,jdbcType=VARCHAR}, ",
        "#{areaCode,jdbcType=VARCHAR}, #{extension,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=BINARY})"
    })
    int insert(IcSmsCustomerContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @InsertProvider(type=IcSmsCustomerContactSqlProvider.class, method="insertSelective")
    int insertSelective(IcSmsCustomerContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsCustomerContactSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="cid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="department", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="mobile", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="qq", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="msn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="icq", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_important", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="fax", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="area_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="extension", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="sex", javaType=byte[].class, jdbcType=JdbcType.BINARY)
    })
    List<IcSmsCustomerContact> selectByExampleWithBLOBs(IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsCustomerContactSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="cid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="department", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="mobile", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="qq", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="msn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="icq", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_important", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="fax", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="area_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="extension", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<IcSmsCustomerContact> selectByExample(IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "gid, cid, name, department, phone, mobile, qq, msn, icq, email, is_important, ",
        "remark, create_time, fax, area_code, extension, sex",
        "from ic_sms_customer_contact",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="cid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="department", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="mobile", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="qq", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="msn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="icq", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_important", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="fax", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="area_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="extension", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="sex", javaType=byte[].class, jdbcType=JdbcType.BINARY)
    })
    IcSmsCustomerContact selectByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsCustomerContactSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IcSmsCustomerContact record, @Param("example") IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsCustomerContactSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") IcSmsCustomerContact record, @Param("example") IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsCustomerContactSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IcSmsCustomerContact record, @Param("example") IcSmsCustomerContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsCustomerContactSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IcSmsCustomerContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_customer_contact",
        "set cid = #{cid,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "department = #{department,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "msn = #{msn,jdbcType=VARCHAR},",
          "icq = #{icq,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "is_important = #{isImportant,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR},",
          "fax = #{fax,jdbcType=VARCHAR},",
          "area_code = #{areaCode,jdbcType=VARCHAR},",
          "extension = #{extension,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=BINARY}",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(IcSmsCustomerContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_customer_contact",
        "set cid = #{cid,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "department = #{department,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "msn = #{msn,jdbcType=VARCHAR},",
          "icq = #{icq,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "is_important = #{isImportant,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR},",
          "fax = #{fax,jdbcType=VARCHAR},",
          "area_code = #{areaCode,jdbcType=VARCHAR},",
          "extension = #{extension,jdbcType=VARCHAR}",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IcSmsCustomerContact record);
}