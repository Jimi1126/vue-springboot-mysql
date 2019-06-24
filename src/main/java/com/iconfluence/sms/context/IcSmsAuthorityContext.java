package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsAuthority;
import com.iconfluence.sms.model.IcSmsAuthorityExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("authority")
public class IcSmsAuthorityContext extends BaseContext<IcSmsAuthority, IcSmsAuthorityExample> {
}
