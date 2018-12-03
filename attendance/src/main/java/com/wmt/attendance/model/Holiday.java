package com.wmt.attendance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="holiday")
public class Holiday {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="approve_id")
	private String approveId;
	
	@Column(name="commit_time")
	private Date commitTime;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_org_name")
	private String empOrgName;
	
	@Column(name="holiday_type")
	private String holidayType;
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	@Column(name="holiday_time")
	private String holidayTime;
}
