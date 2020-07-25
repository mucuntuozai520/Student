package com.Student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.service.Studentservice;

import cn.Model.haha.Student;

public class StudentQueryservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("uid"));
		Studentservice service=new Studentservice();
		Student stu = service.querybyid(id);
		request.setAttribute("student", stu);
		request.getRequestDispatcher("/Student/QuerybyId.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
