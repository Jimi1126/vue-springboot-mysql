package com.iconfluence.sms.context;

import com.iconfluence.sms.model.IcSmsCustomer;
import com.iconfluence.sms.model.IcSmsCustomerExample;
import com.iconfluence.sms.returnType.CommonReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class IcSmsCustomerContext extends BaseContext<IcSmsCustomer, IcSmsCustomerExample> {

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
}
