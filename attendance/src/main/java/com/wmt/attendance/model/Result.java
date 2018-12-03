package com.wmt.attendance.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="result")
public class Result {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="work_num")
	private String workNum;
	
	@Column(name="work_time")
	private String workTime;
	
	@Column(name="exchange_vacation")
	private String exchangeVacation;
	
	@Column(name="leave_num")
	private Integer leaveNum;
	
	@Column(name="leave_time")
	private Double leaveTime;
	
	@Column(name="vacation_leave")
	private Double vacationLeave;
	
	@Column(name="thing_leave")
	private Double thingLeave;
	
	@Column(name="sick_leave")
	private Double sickLeave;
	
	@Column(name="other_leave")
	private Double otherLeave;
	
	@Column(name="year_leave")
	private String yearLeave;
	
	@Column(name="lunch_subsidy")
	private Integer lunchSubsidy;
	
	@Column(name="remainder_leave")
	private Double remainderLeave;
}
