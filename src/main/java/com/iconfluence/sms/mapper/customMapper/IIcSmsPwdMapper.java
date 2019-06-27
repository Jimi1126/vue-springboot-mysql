package com.iconfluence.sms.mapper.customMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface IIcSmsPwdMapper {

  @Update({
          "update ic_sms_pwd",
          "set pwd = #{pwd}",
          "where rid = #{rid}"
  })
  int updatePwdByRid(@Param("pwd") String pwd, @Param("rid") String rid);
}
