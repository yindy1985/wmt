package com.wmt.attendance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.wmt.attendance.model.Holiday;

import tk.mybatis.mapper.common.Mapper;
@Repository
public interface HolidayDao  extends Mapper<Holiday>{
	
	public void holidayBatch(List list);
	
	@Delete(" delete from holiday ")
	public void delHoliday();
}
