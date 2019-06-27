package com.iconfluence.sms.context;

import com.iconfluence.sms.exception.BusinessException;
import com.iconfluence.sms.exception.ErrorEnum;
import com.iconfluence.sms.model.IcSmsPurchase;
import com.iconfluence.sms.model.IcSmsPurchaseExample;
import com.iconfluence.sms.model.IcSmsPwd;
import com.iconfluence.sms.returnType.CommonReturnType;
import com.iconfluence.sms.util.CommonUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Controller
@RequestMapping("purchase")
public class IcSmsPurchaseContext extends BaseContext<IcSmsPurchase, IcSmsPurchaseExample> {

  @Autowired
  IcSmsPwdContext icSmsPwdContext;

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

  @RequestMapping(value="insert", method = RequestMethod.POST)
  @ResponseBody
  @Override
  public CommonReturnType insert(IcSmsPurchase purchase) {
    IcSmsPwd pwd = new IcSmsPwd();
    pwd.setGid(UUID.randomUUID().toString().replace("-", ""));
    pwd.setRid(purchase.getGid());
    pwd.setPwd(purchase.getPassword());
    try {
      pwd.setType("MD5");
      purchase.setPassword(CommonUtil.encodeByMd5(purchase.getPassword()));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    icSmsPwdContext.insert(pwd);
    return CommonReturnType.create(service.insert(purchase));
  }

  @ResponseBody
  @RequestMapping(value = "updateByPrimaryKey", method = RequestMethod.POST)
  @Override
  public CommonReturnType updateByPrimaryKey(IcSmsPurchase record) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    try {
      icSmsPwdContext.updatePwdByRid(record.getPassword(), record.getGid());
      record.setPassword(CommonUtil.encodeByMd5(record.getPassword()));
      return CommonReturnType.create(service.updateByPrimaryKey(record));
    } catch (Exception e) {
      throw e;
    }
  }
}
