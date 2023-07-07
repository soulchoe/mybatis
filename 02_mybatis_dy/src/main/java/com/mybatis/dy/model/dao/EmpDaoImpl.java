package com.mybatis.dy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.vo.Department;
import com.mybatis.dy.model.vo.Employee;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Employee> selectAllEmp(SqlSession session) {
		return session.selectList("employee.selectAllEmp");
	}

	@Override
	public List<Employee> searchEmp(SqlSession session, Map<String, Object> param) {
		return session.selectList("employee.searchEmp", param);
	}
	@Override
	public List<Department> selectAllDept(SqlSession session){
		return session.selectList("employee.selectAllDept");
	}

}
