package com.mybatis.dy.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private int empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
//	private String deptCode;
	private Department dept;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
	private int managerId;
	private Date hireDate;
	private Date entDate;
	private char entYn;
	private String gender;
}
