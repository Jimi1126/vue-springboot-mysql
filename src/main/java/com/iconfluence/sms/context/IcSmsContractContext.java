package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsContract;
import com.iconfluence.sms.model.IcSmsContractExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contract")
public class IcSmsContractContext extends BaseContext<IcSmsContract, IcSmsContractExample> {
}
