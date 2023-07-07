package com.mybatis.dy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.dy.model.service.WebService;
import com.mybatis.dy.model.service.WebServiceImpl;
import com.mybatis.dy.model.vo.Board;

/**
 * Servlet implementation class GetBoardDetailServlet
 */
@WebServlet("/board.do")
public class GetBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebService service=new WebServiceImpl();
		int no=Integer.parseInt(request.getParameter("no"));
		Board post=service.selectBoardDetail(no);
		request.setAttribute("post", post);
		request.getRequestDispatcher("/views/boardView.jsp").forward(request, response);
		System.out.println(post);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
