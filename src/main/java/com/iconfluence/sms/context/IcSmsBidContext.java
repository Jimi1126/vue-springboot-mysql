package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsBid;
import com.iconfluence.sms.model.IcSmsBidExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bid")
public class IcSmsBidContext extends BaseContext<IcSmsBid, IcSmsBidExample> {
//  @ResponseBody
//  @RequestMapping(value="selectAll", method = RequestMethod.GET)
//  @Override
//  public CommonReturnType selectByExample(IcSmsBidExample example) {
//    try {
//      List<IcSmsBid> list = new ArrayList<>();
//      list.add(new IcSmsBid());
//      return CommonReturnType.create(list);
//    } catch (Exception e) {
//      throw e;
//    }
//  }
}