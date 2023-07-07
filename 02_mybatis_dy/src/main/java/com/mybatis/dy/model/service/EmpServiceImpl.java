package com.mybatis.dy.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.dao.EmpDao;
import com.mybatis.dy.model.dao.EmpDaoImpl;
import com.mybatis.dy.model.vo.Department;
import com.mybatis.dy.model.vo.Employee;
import static com.mybatis.dy.common.SessionTemplate.getSession;
public class EmpServiceImpl implements EmpService {
	private EmpDao dao=new EmpDaoImpl();
	@Override
	public List<Employee> selectAllEmp() {
		SqlSession session=getSession();
		List<Employee> list=dao.selectAllEmp(session);
		session.close();
		return list;
	}

	@Override
	public List<Employee> searchEmp(Map<String, Object> param) {
		SqlSession session=getSession();
		List<Employee> list=dao.searchEmp(session, param);
		session.close();
		return list;
	}
	@Override
	public List<Department> selectAllDept(){
		SqlSession session=getSession();
		List<Department> list=dao.selectAllDept(session);
		return list;
	}

}
