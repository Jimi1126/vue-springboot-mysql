package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsBusinessVisit;
import com.iconfluence.sms.model.IcSmsBusinessVisitExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IcSmsBusinessVisitMapper extends BaseMapper<IcSmsBusinessVisit, IcSmsBusinessVisitExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsBusinessVisitSqlProvider.class, method="countByExample")
    long countByExample(IcSmsBusinessVisitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @DeleteProvider(type=IcSmsBusinessVisitSqlProvider.class, method="deleteByExample")
    int deleteByExample(IcSmsBusinessVisitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ic_sms_business_visit",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ic_sms_business_visit (gid, year, ",
        "visit_time, visit_unit, ",
        "province, city, ",
        "objective, c_user, ",
        "hl_user, result, ",
        "remark, uid)",
        "values (#{gid,jdbcType=VARCHAR}, #{year,jdbcType=VARCHAR}, ",
        "#{visitTime,jdbcType=VARCHAR}, #{visitUnit,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{objective,jdbcType=VARCHAR}, #{cUser,jdbcType=VARCHAR}, ",
        "#{hlUser,jdbcType=VARCHAR}, #{result,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{uid,jdbcType=VARCHAR})"
    })
    int insert(IcSmsBusinessVisit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @InsertProvider(type=IcSmsBusinessVisitSqlProvider.class, method="insertSelective")
    int insertSelective(IcSmsBusinessVisit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsBusinessVisitSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="year", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="visit_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="visit_unit", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="objective", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="c_user", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="hl_user", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="result", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uid", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<IcSmsBusinessVisit> selectByExample(IcSmsBusinessVisitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "gid, year, visit_time, visit_unit, province, city, objective, c_user, hl_user, ",
        "result, remark, uid",
        "from ic_sms_business_visit",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="year", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="visit_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="visit_unit", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="objective", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="c_user", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="hl_user", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="result", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uid", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    IcSmsBusinessVisit selectByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsBusinessVisitSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IcSmsBusinessVisit record, @Param("example") IcSmsBusinessVisitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsBusinessVisitSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IcSmsBusinessVisit record, @Param("example") IcSmsBusinessVisitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsBusinessVisitSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IcSmsBusinessVisit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_business_visit
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_business_visit",
        "set year = #{year,jdbcType=VARCHAR},",
          "visit_time = #{visitTime,jdbcType=VARCHAR},",
          "visit_unit = #{visitUnit,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "objective = #{objective,jdbcType=VARCHAR},",
          "c_user = #{cUser,jdbcType=VARCHAR},",
          "hl_user = #{hlUser,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=VARCHAR}",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IcSmsBusinessVisit record);
}