package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsAddress;
import com.iconfluence.sms.model.IcSmsAddressExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("address")
public class IcSmsAddressContext extends BaseContext<IcSmsAddress, IcSmsAddressExample> {
}
