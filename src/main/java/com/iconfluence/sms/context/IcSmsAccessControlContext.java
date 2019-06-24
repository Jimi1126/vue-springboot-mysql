package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsAccessControl;
import com.iconfluence.sms.model.IcSmsAccessControlExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accessControl")
public class IcSmsAccessControlContext extends BaseContext<IcSmsAccessControl, IcSmsAccessControlExample> {
}
