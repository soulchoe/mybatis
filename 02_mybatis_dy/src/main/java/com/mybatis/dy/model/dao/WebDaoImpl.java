package com.mybatis.dy.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.vo.Board;

public class WebDaoImpl implements WebDao {

	@Override
	public Board selectBoardDetail(SqlSession session, int no) {
		return session.selectOne("member.selectBoardDetail", no);
	}

}
