package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<E extends BaseEntity, T> {
	long countByExample(T example);
	int deleteByExample(T example);
	int deleteByPrimaryKey(String gid);
	int insert(E record);
	List<E> selectByExample(T example);
	E selectByPrimaryKey(String gid);
	int updateByExample(@Param("record") E record, @Param("example") T example);
	int updateByPrimaryKey(E record);
}