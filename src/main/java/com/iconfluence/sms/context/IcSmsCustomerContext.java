package com.iconfluence.sms.context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iconfluence.sms.model.IcSmsCustomer;
import com.iconfluence.sms.model.IcSmsCustomerActivity;
import com.iconfluence.sms.model.IcSmsCustomerContact;
import com.iconfluence.sms.model.IcSmsCustomerExample;
import com.iconfluence.sms.returnType.CommonReturnType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class IcSmsCustomerContext extends BaseContext<IcSmsCustomer, IcSmsCustomerExample> {

  @Autowired
  IcSmsCustomerContactContext contactContext;

  @Autowired
  IcSmsCustomerActivityContext activityContext;

  @ResponseBody
  @RequestMapping("importExcel")
  public CommonReturnType importExcel(MultipartFile file) {
    try {
      List<String> fields = Arrays.asList(new String[]{"name", "stffName", "-", "site", "address", "-", "remark"});
      Map<String, Object> resMap = this.service.importExcel(file, IcSmsCustomer.class, fields);
      return CommonReturnType.create(resMap);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "selectByExampleAndPage", method = RequestMethod.POST)
  public CommonReturnType selectByExampleAndPage(@RequestBody String paramItem) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    try {
      JSONObject jsonObject = JSON.parseObject((String) JSON.parse(paramItem));
      String jcls = (String) jsonObject.get("jcls");
      if (StringUtils.isEmpty(jcls)) {
        return CommonReturnType.create(null);
      }
      Class tarCls =  Class.forName(jcls);
      IcSmsCustomer entity = (IcSmsCustomer) jsonObject.getJSONObject("entity").toJavaObject(tarCls);
      List<IcSmsCustomer> list = service.selectByExampleAndPage(entity2example(entity),
              Integer.parseInt(jsonObject.get("pageNum").toString()), Integer.parseInt(jsonObject.get("size").toString()));
      for (IcSmsCustomer customer: list) {
        IcSmsCustomerContact cc = new IcSmsCustomerContact();
        IcSmsCustomerActivity ac = new IcSmsCustomerActivity();
        cc.setCid(customer.getGid());
        ac.setCid(customer.getGid());
        List<IcSmsCustomerContact> cList = (List<IcSmsCustomerContact>) contactContext.selectByExample(cc).getData();
        List<IcSmsCustomerActivity> aList = (List<IcSmsCustomerActivity>) activityContext.selectByExample(ac).getData();
        String last_time = customer.getLastTime();
        for (IcSmsCustomerContact icc : cList) {
          if (StringUtils.isEmpty(last_time) || dateToLong(icc.getLastTime()) > dateToLong(last_time)) {
            last_time = icc.getLastTime();
          }
        }
        String next_time = customer.getNextTime();
        for (IcSmsCustomerActivity ica : aList) {
          if (StringUtils.isEmpty(next_time) || dateToLong(ica.getNextTime()) < dateToLong(next_time)) {
            next_time = ica.getNextTime();
          }
        }
        customer.setLastTime(last_time);
        customer.setNextTime(next_time);
      }
      return CommonReturnType.create(list);
    } catch (Exception e) {
      throw e;
    }
  }

  public long dateToLong(String str) {
    if ("Invalid date".equals(str)) {
      return 0;
    }
    try {
      str = str.replaceAll(" ", "");
      str = str.replaceAll("-", "");
      str = str.replaceAll(":", "");
      return Long.parseLong(str);
    } catch (Exception e) {
      //TODO: handle exception
      return 0;
    }
  }

}
