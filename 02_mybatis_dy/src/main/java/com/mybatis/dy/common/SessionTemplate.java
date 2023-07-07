package com.mybatis.dy.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SessionTemplate {
	public static SqlSession getSession() {
		SqlSession session=null;
		String file="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(file);){
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			session=factory.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}return session;
	}
	public static SqlSession getWebSession() {
		SqlSession session=null;
		String file="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(file);){
			session=new SqlSessionFactoryBuilder().build(is,"web").openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}return session;
	}
}
