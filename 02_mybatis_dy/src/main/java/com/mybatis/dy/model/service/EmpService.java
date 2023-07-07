package com.mybatis.dy.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.vo.Department;
import com.mybatis.dy.model.vo.Employee;

public interface EmpService {
	List<Employee> selectAllEmp();
	
	List<Employee> searchEmp(Map<String,Object> param);
	List<Department> selectAllDept();
}
