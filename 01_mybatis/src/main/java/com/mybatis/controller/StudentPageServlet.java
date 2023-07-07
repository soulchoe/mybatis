package com.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentPageServlet
 */
@WebServlet("/student/studentPage.do")
public class StudentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(list.size());
//		list.stream().forEach(System.out::println);
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
		List<Student> list=new StudentService().selectStudentPage(cPage,numPerPage);
		request.setAttribute("students",list);
		int totalData=new StudentService().selectStudentCount();
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
		request.getRequestDispatcher("/views/studentPage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
