package com.mybatis.dy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.dy.model.service.EmpService;
import com.mybatis.dy.model.service.EmpServiceImpl;
import com.mybatis.dy.model.vo.Employee;

/**
 * Servlet implementation class SelectAllEmpServlet
 */
@WebServlet("/emp/selectAll.do")
public class SelectAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private EmpService service;
    public SelectAllEmpServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service=new EmpServiceImpl();
		List<Employee> list=service.selectAllEmp();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
