package com.iconfluence.sms.service;

import com.iconfluence.sms.model.IcSmsPwd;
import com.iconfluence.sms.model.IcSmsPwdExample;

public abstract class IcSmsPwdService extends BaseService<IcSmsPwd, IcSmsPwdExample>{
  public abstract int updatePwdByRid(String pwd, String rid);
}
