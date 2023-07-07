package com.mybatis.dy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.dy.model.service.EmpService;
import com.mybatis.dy.model.vo.Employee;



/**
 * Servlet implementation class SelectEmployeeInPagesServlet
 */
@WebServlet("/emp/selectEmpPage.do")
public class SelectEmployeeInPagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEmployeeInPagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage,numPerPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}catch(Exception e) {
			numPerPage=5;
		}
		List<Employee> list=new EmpService().selectEmployeePage(cPage,numPerPage);
		request.setAttribute("employees",list);
		int totalData=new EmpService().selectEmployeeCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerPage);
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="<ul= class='pagination justify-content pagination-sm'>";
		if(cPage==1) {
			//15버전 이상에서만 사용가능
			pageBar+="""
					<li class='page-item disabled'>
					<a class='page-link' href='#'>이전</a>
					</li>
					""";
		}else {
			pageBar+="<li class='page-item'>";
			pageBar+="<a class='page-link' href='"+request.getRequestURI()+"?cPage="+(cPage-1)+"'>이전</a>";
			pageBar+="</li>";
		}
		pageBar+="</ul>";
		
		  while(!(pageNo>pageEnd||pageNo>totalPage)) {
		         if(cPage==pageNo) {
		            pageBar+="<li class='page-item disabled'>";
		            pageBar+="<a class='page-link' href='#'>"+pageNo+"</a>";
		            pageBar+="</li>";
		         }else {
		            pageBar+="<li class='page-item'>";
		            pageBar+="<a class='page-link' href='"+request.getRequestURI()
		                  +"?cPage="+(pageNo)+"'>"+pageNo+"</a>";
		            pageBar+="</li>";
		         }
		         pageNo++;
		      }
		      
		      if(pageNo>totalPage) {
		         pageBar+="""
		               <li class='page-item disabled'>
		                  <a class='page-link' href='#'>다음</a>
		               </li>
		               """;
		      }else {
		         pageBar+="<li class='page-item'>";
		         pageBar+="<a class='page-link' href='"+request.getRequestURI()
		               +"?cPage="+(pageNo)+"'>다음</a>";
		         pageBar+="</li>";
		      }

		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/employeePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
