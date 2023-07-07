package com.mybatis.dy.model.service;

import static com.mybatis.dy.common.SessionTemplate.getWebSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.dao.WebDao;
import com.mybatis.dy.model.dao.WebDaoImpl;
import com.mybatis.dy.model.vo.Board;
public class WebServiceImpl implements WebService {
	private WebDao dao=new WebDaoImpl();
	@Override
	public Board selectBoardDetail(int no) {
		SqlSession session=getWebSession();
		Board result=dao.selectBoardDetail(session,no);
		session.close();
		return result;
	}


}
