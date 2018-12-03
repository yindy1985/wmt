package com.wmt.attendance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="work")
public class WorkModel {
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
	
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	@Column(name="work_time")
	private Float workTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public Date getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpOrgName() {
		return empOrgName;
	}

	public void setEmpOrgName(String empOrgName) {
		this.empOrgName = empOrgName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Float getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Float workTime) {
		this.workTime = workTime;
	}
	
}
