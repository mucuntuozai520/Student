package com.Student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.service.Studentservice;

import cn.Model.haha.Student;


public class AddStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("uage"));
		String address = request.getParameter("uaddress");
		String birthday = request.getParameter("ubirthday");
		Studentservice service=new Studentservice();
		Student stu=new Student(id,name,age,address,birthday);
		int result = service.Add(stu);
		if(result==1) {
			request.setAttribute("Add","添加成功!" );
		}else {
			request.setAttribute("Add", "添加失败!");
		}
		request.getRequestDispatcher("StudentPageservlet").forward(request, response);
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
