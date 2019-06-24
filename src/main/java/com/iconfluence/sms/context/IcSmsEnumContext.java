package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsEnum;
import com.iconfluence.sms.model.IcSmsEnumExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("enum")
public class IcSmsEnumContext extends BaseContext<IcSmsEnum, IcSmsEnumExample>{
}
