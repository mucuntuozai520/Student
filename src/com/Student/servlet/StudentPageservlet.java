package com.Student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.service.Studentservice;

import cn.Model.haha.Page;
import cn.Model.haha.Student;


public class StudentPageservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		Studentservice service=new Studentservice();
		Page p=new Page();
		int count = service.count();
		p.setCount(count);
		int PageSize=3;
		p.setPageSize(PageSize);
		String a=request.getParameter("currentPage");
		if(a==null) {
			a="0";
		}
		int currentPage = Integer.parseInt(a);
		p.setCurrentPage(currentPage);
		List<Student> students = service.querybypage(currentPage, PageSize);
		p.setStudents(students);
		request.setAttribute("Page", p);
		request.getRequestDispatcher("Student/Student.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
