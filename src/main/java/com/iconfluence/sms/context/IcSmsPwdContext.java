package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsPwd;
import com.iconfluence.sms.model.IcSmsPwdExample;
import com.iconfluence.sms.service.IcSmsPwdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pwd")
public class IcSmsPwdContext extends BaseContext<IcSmsPwd, IcSmsPwdExample> {
  int updatePwdByRid(String pwd, String rid) {
    IcSmsPwdService service = (IcSmsPwdService) this.service;
    return service.updatePwdByRid(pwd, rid);
  }
}
