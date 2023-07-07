package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SessionTemplate;
import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.vo.Student;

public class StudentService {
	private StudentDao dao=new StudentDao();
	
	public int insertStudent() {
		SqlSession session=SessionTemplate.getSession();
		int result=dao.insertStudent(session);
		
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentbyName(String name) {
		SqlSession session=getSession();
		int result=dao.insertStudentbyName(session,name);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentAll(Student s) {
		SqlSession session=getSession();
		int result=dao.insertStudentAll(session,s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int updateStudent(Student s) {
		SqlSession session=getSession();
		int result=dao.updateStudent(session,s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int deleteStudent(int no) {
		SqlSession session=getSession();
		int result=dao.deleteStudent(session,no);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int selectStudentCount() {
		SqlSession session=getSession();
		int result=dao.selectStudentCount(session);
		session.close();
		return result;
	}
	
	
	public Student selectStudent(int no) {
		SqlSession session=getSession();
		Student s=dao.selectStudent(session, no);
		session.close();
		return s;
	}
	
	public List<Student> selectStudentAll(){
		SqlSession session=getSession();
		List<Student> students=dao.selectStudentAll(session);
		session.close();
		return students;
	}

	public List<Student> selectStudentByName(String keyword) {
		SqlSession session=getSession();
		List<Student> result=dao.selectStudentByName(session,keyword);
		session.close();
		return result;
	}

	public int selectCountWithKeyword(String keyword) {
		SqlSession session=getSession();
		int result=dao.selectCountWithKeyword(session,keyword);
		session.close();
		return result;
	}
	public Map selectStudentMap(int no) {
		SqlSession session=getSession();
		Map result=dao.selectStudentMap(session,no);
		session.close();
		return result;
		
	}
	public List<Map> selectStudentListMap(){
		SqlSession session=getSession();
		List<Map> result=dao.selectStudentListMap(session);
		session.close();
		return result;
	}
	
	public List<Student> selectStudentPage(int cPage, int numPerPage) {
		SqlSession session=getSession();
		List<Student> result=dao.selectStudentPage(session, cPage, numPerPage);
		session.close();
		return result;
	}
}
