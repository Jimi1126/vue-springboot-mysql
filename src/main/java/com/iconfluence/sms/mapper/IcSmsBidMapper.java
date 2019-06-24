package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsBid;
import com.iconfluence.sms.model.IcSmsBidExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IcSmsBidMapper extends BaseMapper<IcSmsBid, IcSmsBidExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsBidSqlProvider.class, method="countByExample")
    long countByExample(IcSmsBidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @DeleteProvider(type=IcSmsBidSqlProvider.class, method="deleteByExample")
    int deleteByExample(IcSmsBidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ic_sms_bid",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ic_sms_bid (gid, year, ",
        "bid_time, name, trade, ",
        "project, attend_company, ",
        "hl_name, result, ",
        "remark)",
        "values (#{gid,jdbcType=VARCHAR}, #{year,jdbcType=VARCHAR}, ",
        "#{bidTime,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{trade,jdbcType=VARCHAR}, ",
        "#{project,jdbcType=VARCHAR}, #{attendCompany,jdbcType=VARCHAR}, ",
        "#{hlName,jdbcType=VARCHAR}, #{result,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(IcSmsBid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @InsertProvider(type=IcSmsBidSqlProvider.class, method="insertSelective")
    int insertSelective(IcSmsBid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsBidSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="year", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="bid_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trade", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="project", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="attend_company", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="hl_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="result", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<IcSmsBid> selectByExample(IcSmsBidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "gid, year, bid_time, name, trade, project, attend_company, hl_name, result, ",
        "remark",
        "from ic_sms_bid",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="year", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="bid_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trade", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="project", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="attend_company", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="hl_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="result", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    IcSmsBid selectByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsBidSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IcSmsBid record, @Param("example") IcSmsBidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsBidSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IcSmsBid record, @Param("example") IcSmsBidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsBidSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IcSmsBid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_bid
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_bid",
        "set year = #{year,jdbcType=VARCHAR},",
          "bid_time = #{bidTime,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "trade = #{trade,jdbcType=VARCHAR},",
          "project = #{project,jdbcType=VARCHAR},",
          "attend_company = #{attendCompany,jdbcType=VARCHAR},",
          "hl_name = #{hlName,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IcSmsBid record);
}