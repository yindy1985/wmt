package com.wmt.attendance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.wmt.attendance.model.WorkModel;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface WorkDao extends Mapper<WorkModel>{
	public void workBatch(List list);
	
	@Delete(" delete from work ")
	public void delWork();
}
