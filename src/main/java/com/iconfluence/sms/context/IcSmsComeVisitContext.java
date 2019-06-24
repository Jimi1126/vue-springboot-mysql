package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsComeVisit;
import com.iconfluence.sms.model.IcSmsComeVisitExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comeVisit")
public class IcSmsComeVisitContext extends BaseContext<IcSmsComeVisit, IcSmsComeVisitExample>{
}
