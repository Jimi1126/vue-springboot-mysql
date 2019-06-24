package com.iconfluence.sms.context;

import com.iconfluence.sms.exception.BusinessException;
import com.iconfluence.sms.exception.ErrorEnum;
import com.iconfluence.sms.model.IcSmsUser;
import com.iconfluence.sms.model.IcSmsUserExample;
import com.iconfluence.sms.returnType.CommonReturnType;
import com.iconfluence.sms.util.CommonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("user")
public class IcSmsUserContext extends BaseContext<IcSmsUser, IcSmsUserExample> {

  @RequestMapping(value = "login", method = RequestMethod.POST)
  @ResponseBody
  private CommonReturnType login(@RequestBody JSONObject requestJson) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
    if (requestJson == null) {
      throw new BusinessException(ErrorEnum.PARAM_VERIFICATION_ERROR);
    }
    String code = requestJson.getString("code");
    String password = requestJson.getString("password");
    password = CommonUtil.encodeByMd5(password);
    IcSmsUserExample example = new IcSmsUserExample();
    IcSmsUserExample.Criteria criteria1  = example.createCriteria();
    criteria1.andCodeEqualTo(code);
    criteria1.andPasswordEqualTo(password);
    return CommonReturnType.create(this.service.countByExample(example));
  }

  @RequestMapping(value="insert", method = RequestMethod.POST)
  @ResponseBody
  @Override
  public CommonReturnType insert(IcSmsUser user) {
    try {
      user.setPassword(CommonUtil.encodeByMd5(user.getPassword()));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return CommonReturnType.create(service.insert(user));
  }

}
