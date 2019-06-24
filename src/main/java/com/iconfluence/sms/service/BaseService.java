package com.iconfluence.sms.service;

import com.github.pagehelper.PageHelper;
import com.iconfluence.sms.mapper.BaseMapper;
import com.iconfluence.sms.model.BaseEntity;
import com.iconfluence.sms.util.CommonUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class BaseService<E extends BaseEntity, T> {

  Logger log = LoggerFactory.getLogger(BaseService.class);

  @Autowired
  protected BaseMapper<E, T> mapper;

  public long countByExample(T example) {
    return mapper.countByExample(example);
  }
	public int deleteByExample(T example) {
    return mapper.deleteByExample(example);
  }
	public int deleteByPrimaryKey(String gid) {
    return mapper.deleteByPrimaryKey(gid);
  }
	public int insert(E record) {
    return mapper.insert(record);
  }
	public List<E> selectByExample(T example) {
    return mapper.selectByExample(example);
  }
	public E selectByPrimaryKey(String gid) {
    return mapper.selectByPrimaryKey(gid);
  }
	public int updateByExample(@Param("record") E record, @Param("example") T example) {
    return mapper.updateByExample(record, example);
  }
	public int updateByPrimaryKey(E record) {
    return mapper.updateByPrimaryKey(record);
  }

  public List<E> selectByExampleAndPage(T example, Integer pageNum, Integer size) {
    PageHelper.startPage(pageNum, size);
    List<E> res = mapper.selectByExample(example);
    return res;
  }

  /**
   * 通用导入excel
   * @param file 文件流
   * @param cls 持久化对象类对象
   * @param entityFields excel单元格对应持久化对象的字段，以“-”跳过匹配
   * @return 导入情况
   */
  public Map<String, Object> importExcel(MultipartFile file, Class<E> cls, List<String> entityFields) {
    List<E> resList = new ArrayList<E>();
    Map<String, Object> resMap = new HashMap<String, Object>();
    int total = 0; //总数
    int success = 0; //成功导入
    int fail = 0; //导入失败
    List<Integer> failList = new ArrayList<Integer>(); //失败行数

    resMap.put("status", "success");
    if (file == null || entityFields == null || cls == null) {
      resMap.put("status", "fail");
      resMap.put("msg", "文件为空或文件损坏");
      return resMap;
    }
    try {
      String fileName = file.getOriginalFilename();
      File uploadFile = CommonUtil.saveFile(fileName, file);
      InputStream ins = new FileInputStream(uploadFile);
      Workbook wb = new XSSFWorkbook(ins);
      Sheet sheet1 = wb.getSheetAt(0);
      Row s_row = null;
      Cell r_col = null;
      String fieldName = "";
      Method method = null;
      Method setGid = cls.getMethod("setGid", String.class);
      int r_num = sheet1.getLastRowNum();
      total = r_num - 1;
      for (int i = 1; i < r_num; i++) {
        s_row = sheet1.getRow(i);
        E entity = cls.newInstance();
        setGid.invoke(entity, UUID.randomUUID().toString().replace("-", ""));
        int c_num = s_row.getLastCellNum();
        int length = c_num > entityFields.size() ? entityFields.size() : c_num;
        boolean insert = true;
        for (int j = 0; j < length; j++) {
          fieldName = entityFields.get(j);
          if ("-".equals(fieldName)) {
            continue;
          }
          method = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase() + fieldName.substring(1), String.class);
          method.invoke(entity, "");
          r_col = s_row.getCell(j);
          if (r_col == null) {
            continue;
          }
          r_col.setCellType(Cell.CELL_TYPE_STRING);
          try{
            method.invoke(entity, r_col.getStringCellValue());
          } catch (Exception err) {
            log.error(err.getMessage());
            insert = false;
            fail++;
            failList.add(i+1);
            break;
          }
        }
        if (insert) {
          success += this.insert(entity);
        }
      }
    } catch (IOException | InstantiationException | IllegalAccessException |NoSuchMethodException | InvocationTargetException e) {
      e.printStackTrace();
    }
    resMap.put("total", total);
    resMap.put("success", success);
    resMap.put("fail", fail);
    resMap.put("failList", failList);
    return resMap;
  }
}
