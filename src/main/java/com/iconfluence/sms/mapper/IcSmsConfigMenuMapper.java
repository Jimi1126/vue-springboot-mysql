package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsConfigMenu;
import com.iconfluence.sms.model.IcSmsConfigMenuExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IcSmsConfigMenuMapper extends BaseMapper<IcSmsConfigMenu, IcSmsConfigMenuExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsConfigMenuSqlProvider.class, method="countByExample")
    long countByExample(IcSmsConfigMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @DeleteProvider(type=IcSmsConfigMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(IcSmsConfigMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ic_sms_config_menu",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ic_sms_config_menu (gid, pid, ",
        "name, code, description)",
        "values (#{gid,jdbcType=VARCHAR}, #{pid,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})"
    })
    int insert(IcSmsConfigMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @InsertProvider(type=IcSmsConfigMenuSqlProvider.class, method="insertSelective")
    int insertSelective(IcSmsConfigMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @SelectProvider(type=IcSmsConfigMenuSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="pid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<IcSmsConfigMenu> selectByExample(IcSmsConfigMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "gid, pid, name, code, description",
        "from ic_sms_config_menu",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="gid", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="pid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    IcSmsConfigMenu selectByPrimaryKey(String gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsConfigMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IcSmsConfigMenu record, @Param("example") IcSmsConfigMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsConfigMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IcSmsConfigMenu record, @Param("example") IcSmsConfigMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @UpdateProvider(type=IcSmsConfigMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IcSmsConfigMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_config_menu
     *
     * @mbg.generated
     */
    @Update({
        "update ic_sms_config_menu",
        "set pid = #{pid,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where gid = #{gid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IcSmsConfigMenu record);
}