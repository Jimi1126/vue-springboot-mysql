package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsBusinessVisit;
import com.iconfluence.sms.model.IcSmsBusinessVisitExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("businessVisit")
public class IcSmsBusinessVisitContext extends BaseContext<IcSmsBusinessVisit, IcSmsBusinessVisitExample> {
}