package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsContract;
import com.iconfluence.sms.model.IcSmsContractExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IcSmsContractMapper extends BaseMapper<IcSmsContract, IcSmsContractExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsContractSqlProvider.class, method="countByExample")
    long countByExample(IcSmsContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @DeleteProvider(type=IcSmsContractSqlProvider.class, method="deleteByExample")
    int deleteByExample(IcSmsContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ic_sms_contract",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ic_sms_contract (gid, customer_name, ",
        "name, type, trade, ",
        "term, contract_time, ",
        "over_time, status, ",
        "cooperation_type, return_time, ",
        "quality, remark, ",
        "uid)",
        "values (#{gid,jdbcType=VARCHAR}, #{customerName,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{trade,jdbcType=VARCHAR}, ",
        "#{term,jdbcType=VARCHAR}, #{contractTime,jdbcType=VARCHAR}, ",
        "#{overTime,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{cooperationType,jdbcType=VARCHAR}, #{returnTime,jdbcType=VARCHAR}, ",
        "#{quality,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=VARCHAR})"
    })
    int insert(IcSmsContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @InsertProvider(type=IcSmsContractSqlProvider.class, method="insertSelective")
    int insertSelective(IcSmsContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsContractSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="customer_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trade", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="term", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="contract_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="over_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cooperation_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="return_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="quality", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uid", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<IcSmsContract> selectByExample(IcSmsContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "gid, customer_name, name, type, trade, term, contract_time, over_time, status, ",
        "cooperation_type, return_time, quality, remark, uid",
        "from ic_sms_contract",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="customer_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trade", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="term", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="contract_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="over_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cooperation_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="return_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="quality", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uid", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    IcSmsContract selectByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsContractSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IcSmsContract record, @Param("example") IcSmsContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsContractSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IcSmsContract record, @Param("example") IcSmsContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsContractSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IcSmsContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_contract",
        "set customer_name = #{customerName,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "trade = #{trade,jdbcType=VARCHAR},",
          "term = #{term,jdbcType=VARCHAR},",
          "contract_time = #{contractTime,jdbcType=VARCHAR},",
          "over_time = #{overTime,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "cooperation_type = #{cooperationType,jdbcType=VARCHAR},",
          "return_time = #{returnTime,jdbcType=VARCHAR},",
          "quality = #{quality,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=VARCHAR}",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IcSmsContract record);
}