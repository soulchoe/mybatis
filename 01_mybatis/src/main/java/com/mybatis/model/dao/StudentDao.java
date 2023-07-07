package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class StudentDao {
	public int insertStudent(SqlSession session) {
		//sql문을 실행할 때는 session이 제공하는 메소드를 호출하면됨
		//selectOne(), selectList(), insert(), update(), delete()
		//statement인수는 "mapper's namespace.sql tag's id"
		int result=session.insert("student.insertStudent");
		return result;
	}
	
	public int insertStudentbyName(SqlSession session, String name) {
		int result=session.insert("student.insertStudentbyName",name);
		return result;
	}
	
	public int insertStudentAll(SqlSession session, Student s) {
		return session.insert("student.insertStudentAll",s);
	}
	
	public int updateStudent(SqlSession session, Student s) {
		return session.update("student.updateStudent",s);
	}
	
	//delete와 count해
	public int deleteStudent(SqlSession session, int no) {
		return session.delete("student.deleteStudent",no);
	}
	
	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}
	
	
	public Student selectStudent(SqlSession session, int no) {
		return session.selectOne("student.selectStudent",no);
	}
	
	public List<Student> selectStudentAll(SqlSession session){
		return session.selectList("student.selectStudentAll");
	}

	public List<Student> selectStudentByName(SqlSession session, String keyword) {
		return session.selectList("student.selectStudentByName", keyword);
	}

	public int selectCountWithKeyword(SqlSession session, String keyword) {
		return session.selectOne("student.selectCountWithKeyword", keyword);
	}
	
	public Map selectStudentMap(SqlSession session, int no) {
		return session.selectOne("student.selectStudentMap", no);
	}
	
	public List<Map> selectStudentListMap(SqlSession session){
		return session.selectList("student.selectStudentListMap");
	}
	
	public List<Student> selectStudentPage(SqlSession session, int cPage, int numPerPage){
		//페이지 처리할 때는 마이바티스가 제공하는 페이징처리 클래스를 생성해서 이용한다
		//RowBounds클래스 이용
		//selectList호출시 세번째 매개변수에 RowBounds 클래스를 생성해서 전달해줌녀 된다
		//매개변수 있는 생성자이용
		//매개변수 1 : 시작 row번호 (cPage-1)*numPerPage
		//매개변수 2 : 범위 numPerPage
		//new RowBounds((cPage-1)*numPerPage,numPerPage)
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return session.selectList("student.selectStudentPage", null, rb);
	}
}
