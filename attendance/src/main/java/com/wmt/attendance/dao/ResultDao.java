package com.wmt.attendance.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.wmt.attendance.model.Result;

import tk.mybatis.mapper.common.Mapper;
@Repository
public interface ResultDao extends Mapper<Result>{
	
	@Delete(" delete from result ")
	public int deleInitEmpName();
	
	@Select(" insert into result(emp_name) SELECT distinct(emp_name) FROM work a union select distinct(emp_name) from holiday b ")
	public int initEmpName();
}
