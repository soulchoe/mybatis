package com.mybatis.dy.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dy.model.vo.Board;

public interface WebDao {

	Board selectBoardDetail(SqlSession session, int no);

}
