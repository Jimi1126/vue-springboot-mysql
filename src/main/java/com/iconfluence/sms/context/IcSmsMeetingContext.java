package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsMeeting;
import com.iconfluence.sms.model.IcSmsMeetingExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("meeting")
public class IcSmsMeetingContext extends BaseContext<IcSmsMeeting, IcSmsMeetingExample> {
}
