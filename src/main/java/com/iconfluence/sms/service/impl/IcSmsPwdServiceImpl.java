package com.iconfluence.sms.service.impl;

import com.iconfluence.sms.mapper.IcSmsPwdMapper;
import com.iconfluence.sms.service.IcSmsPwdService;
import org.springframework.stereotype.Service;

@Service
public class IcSmsPwdServiceImpl extends IcSmsPwdService {

  @Override
  public int updatePwdByRid(String pwd, String rid) {
    IcSmsPwdMapper mapper = (IcSmsPwdMapper) this.mapper;
    return mapper.updatePwdByRid(pwd, rid);
  }
}
