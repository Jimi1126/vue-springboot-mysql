package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsCustomerActivity;
import com.iconfluence.sms.model.IcSmsCustomerActivityExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("activity")
public class IcSmsCustomerActivityContext extends BaseContext<IcSmsCustomerActivity, IcSmsCustomerActivityExample> {
}
