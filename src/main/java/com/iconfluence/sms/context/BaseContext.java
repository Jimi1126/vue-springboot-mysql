package com.iconfluence.sms.context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iconfluence.sms.exception.BusinessException;
import com.iconfluence.sms.exception.ErrorEnum;
import com.iconfluence.sms.model.BaseEntity;
import com.iconfluence.sms.returnType.CommonReturnType;
import com.iconfluence.sms.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseContext<E extends BaseEntity, T> {

  @Autowired
  protected BaseService<E, T> service;
  Logger log = LoggerFactory.getLogger(BaseContext.class);

  @ResponseBody
  @RequestMapping(value = "insert", method = RequestMethod.POST)
  public CommonReturnType insert(E entity) {
    try {
      int insertRow = service.insert(entity);
      return CommonReturnType.create(insertRow);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "selectByExample", method = RequestMethod.POST)
  public CommonReturnType selectByExample(E entity) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    try {
      List<E> list = service.selectByExample(entity2example(entity));
      return CommonReturnType.create(list);
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
      E entity = (E) jsonObject.getJSONObject("entity").toJavaObject(tarCls);
      List<E> list = service.selectByExampleAndPage(entity2example(entity),
              Integer.parseInt(jsonObject.get("pageNum").toString()), Integer.parseInt(jsonObject.get("size").toString()));
      return CommonReturnType.create(list);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "countByExample", method = RequestMethod.POST)
  public CommonReturnType countByExample(E entity) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    try {
      Long result = service.countByExample(entity2example(entity));
      return CommonReturnType.create(result);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "deleteByExample", method = RequestMethod.POST)
  public CommonReturnType deleteByExample(E entity) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    try {
      int result = service.deleteByExample(entity2example(entity));
      return CommonReturnType.create(result);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST)
  public CommonReturnType deleteByPrimaryKey(@RequestParam String gid) {
    try {
      int result = service.deleteByPrimaryKey(gid);
      return CommonReturnType.create(result);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "selectByPrimaryKey")
  public CommonReturnType selectByPrimaryKey(String gid) {
    try {
      E result = service.selectByPrimaryKey(gid);
      return CommonReturnType.create(result);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "updateByExample", method = RequestMethod.POST)
  public CommonReturnType updateByExample(E record, E entity) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    try {
      int result = service.updateByExample(record, entity2example(entity));
      return CommonReturnType.create(result);
    } catch (Exception e) {
      throw e;
    }
  }

  @ResponseBody
  @RequestMapping(value = "updateByPrimaryKey", method = RequestMethod.POST)
  public CommonReturnType updateByPrimaryKey(E record) {
    try {
      int result = service.updateByPrimaryKey(record);
      return CommonReturnType.create(result);
    } catch (Exception e) {
      throw e;
    }
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public CommonReturnType exceptionHendler(HttpServletRequest request, Exception ex) {
    log.error(ex.getMessage());
    Map returnMap = new HashMap<String, Object>();
    if (ex instanceof BusinessException) {
      BusinessException bex = (BusinessException) ex;
      returnMap.put("errCode", bex.getErrCode());
      returnMap.put("errMsg", bex.getErrMsg());
    } else {
      returnMap.put("errCode", ErrorEnum.SYSTEM_ERROR.getErrCode());
      returnMap.put("errMsg", ErrorEnum.SYSTEM_ERROR.getErrMsg());
      returnMap.put("detail", ex.getMessage());
    }
    return CommonReturnType.create("fail", returnMap);
  }

  /**
   * 将条件实体转换为对应实体的example对象.
   * @param entity
   * @return example对象
   * @throws ClassNotFoundException
   * @throws IllegalAccessException
   * @throws InstantiationException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   */
  public T entity2example(E entity) throws
          ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    Class ecls = entity.getClass();
    String name = ecls.getName();
    Class excls = Class.forName(name + "Example");
    Class exccls = Class.forName(name + "Example$Criteria");
    T example = (T) excls.newInstance();
    Method exclsMethod = excls.getMethod("createCriteria", null);
    Object criterion = exclsMethod.invoke(example);

    Field[] eFields = ecls.getDeclaredFields();
    Field.setAccessible(eFields, true);
    Method eclsMethod;
    Method excclsMethod;
    String key;
    String val;
    for (Field ef : eFields) {
      key = ef.getName();
      eclsMethod = ecls.getMethod("get" + key.substring(0, 1).toUpperCase() + key.substring(1));
      if (eclsMethod == null) continue;
      val = (String) eclsMethod.invoke(entity);
      if (StringUtils.isEmpty(val)) {
        continue;
      }
      if (val.startsWith("%") && val.endsWith("%")) {
        excclsMethod = exccls.getMethod("and" + key.substring(0, 1).toUpperCase() + key.substring(1) + "Like", String.class);
      } else {
        excclsMethod = exccls.getMethod("and" + key.substring(0, 1).toUpperCase() + key.substring(1) + "EqualTo", String.class);
      }
      excclsMethod.invoke(criterion, val);
    }
    return example;
  }

}
