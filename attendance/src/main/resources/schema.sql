CREATE TABLE work(
	id INTEGER not null auto_increment primary key,
	approve_id varchar(32),
	commit_time TIMESTAMP,
	emp_name varchar(50),
	emp_org_name varchar(50),
	emp_account varchar(50),
	start_time TIMESTAMP,
	end_time TIMESTAMP,
	work_time REAL,
);

CREATE TABLE holiday(
	id INTEGER not null auto_increment primary key,
	approve_id varchar(32),
	commit_time TIMESTAMP,
	emp_name varchar(50),
	emp_org_name varchar(50),
	emp_account varchar(50),
	holiday_type varchar(50),
	start_time TIMESTAMP,
	end_time TIMESTAMP,
	holiday_time varchar(20),
);

CREATE TABLE result(
	id INTEGER not null auto_increment primary key,
	emp_name varchar(50),
	work_num INT,
	work_time DOUBLE,
	exchange_vacation DOUBLE,
	leave_num INT,
	leave_time DOUBLE,
	vacation_leave DOUBLE,
	thing_leave DOUBLE,
	sick_leave DOUBLE,
	other_leave DOUBLE,
	year_leave DOUBLE,
	lunch_subsidy INT,
	remainder_leave DOUBLE
);

