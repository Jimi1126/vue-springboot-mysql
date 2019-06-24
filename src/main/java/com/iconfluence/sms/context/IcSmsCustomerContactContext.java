package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsCustomerContact;
import com.iconfluence.sms.model.IcSmsCustomerContactExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contact")
public class IcSmsCustomerContactContext extends BaseContext<IcSmsCustomerContact, IcSmsCustomerContactExample> {
}
