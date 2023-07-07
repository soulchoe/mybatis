package com.mybatis.dy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.vo.Department;
import com.mybatis.dy.model.vo.Employee;

public interface EmpDao {
//	public List<Employee> selectAllEmp(SqlSession session){
//		return session.selectList("employee.selectAllEmployee");
//	}
	List<Employee> selectAllEmp(SqlSession session);
	List<Employee> searchEmp(SqlSession session, Map<String,Object> param);
	List<Department> selectAllDept(SqlSession session);

//	public List<Employee> selectEmployeePage(SqlSession session, int cPage, int numPerPage) {
//		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
//		return session.selectList("employee.selectAllEmployee",null,rb);
//	}
}
