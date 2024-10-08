package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsAddress;
import com.iconfluence.sms.model.IcSmsAddressExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IcSmsAddressMapper extends BaseMapper<IcSmsAddress, IcSmsAddressExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsAddressSqlProvider.class, method="countByExample")
    long countByExample(IcSmsAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @DeleteProvider(type=IcSmsAddressSqlProvider.class, method="deleteByExample")
    int deleteByExample(IcSmsAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ic_sms_address",
        "where areaId = #{areaid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer areaid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ic_sms_address (areaId, areaCode, ",
        "areaName, level, ",
        "cityCode, center, ",
        "parentId)",
        "values (#{areaid,jdbcType=INTEGER}, #{areacode,jdbcType=VARCHAR}, ",
        "#{areaname,jdbcType=VARCHAR}, #{level,jdbcType=TINYINT}, ",
        "#{citycode,jdbcType=VARCHAR}, #{center,jdbcType=VARCHAR}, ",
        "#{parentid,jdbcType=INTEGER})"
    })
    int insert(IcSmsAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @InsertProvider(type=IcSmsAddressSqlProvider.class, method="insertSelective")
    int insertSelective(IcSmsAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsAddressSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="areaId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="areaCode", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="areaName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="level", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="cityCode", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="center", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parentId", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<IcSmsAddress> selectByExample(IcSmsAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "areaId, areaCode, areaName, level, cityCode, center, parentId",
        "from ic_sms_address",
        "where areaId = #{areaid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="areaId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="areaCode", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="areaName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="level", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="cityCode", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="center", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parentId", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    IcSmsAddress selectByPrimaryKey(Integer areaid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsAddressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IcSmsAddress record, @Param("example") IcSmsAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsAddressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IcSmsAddress record, @Param("example") IcSmsAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IcSmsAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_address
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_address",
        "set areaCode = #{areacode,jdbcType=VARCHAR},",
          "areaName = #{areaname,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=TINYINT},",
          "cityCode = #{citycode,jdbcType=VARCHAR},",
          "center = #{center,jdbcType=VARCHAR},",
          "parentId = #{parentid,jdbcType=INTEGER}",
        "where areaId = #{areaid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IcSmsAddress record);
}