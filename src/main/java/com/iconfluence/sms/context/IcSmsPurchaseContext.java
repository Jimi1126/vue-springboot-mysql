package com.iconfluence.sms.context;

import com.iconfluence.sms.exception.BusinessException;
import com.iconfluence.sms.exception.ErrorEnum;
import com.iconfluence.sms.model.IcSmsPurchase;
import com.iconfluence.sms.model.IcSmsPurchaseExample;
import com.iconfluence.sms.returnType.CommonReturnType;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
@RequestMapping("purchase")
public class IcSmsPurchaseContext extends BaseContext<IcSmsPurchase, IcSmsPurchaseExample> {

  @RequestMapping(value = "selectByParam", method = RequestMethod.POST)
  @ResponseBody
  public CommonReturnType selectByParam(@RequestBody JSONObject jsonObject) throws BusinessException {
    if (jsonObject == null) {
      throw new BusinessException(ErrorEnum.PARAM_VERIFICATION_ERROR);
    }
    IcSmsPurchaseExample example = new IcSmsPurchaseExample();
    IcSmsPurchaseExample.Criteria criteria1  = example.createCriteria();
    String name = jsonObject.getString("name");
    if (StringUtils.isNotEmpty(name)) {
      criteria1.andNameLike(jsonObject.getString("name"));
    }
    return CommonReturnType.create(this.service.selectByExample(example));
  }

  @RequestMapping("insert11")
  @ResponseBody
  public CommonReturnType insert() throws ParseException {
    IcSmsPurchase icSmsPurchase = new IcSmsPurchase();
    icSmsPurchase.setGid("1");
    icSmsPurchase.setName("test");
    icSmsPurchase.setUsercode("test");
    icSmsPurchase.setRegTime("");
    return CommonReturnType.create(service.insert(icSmsPurchase));
  }
}
