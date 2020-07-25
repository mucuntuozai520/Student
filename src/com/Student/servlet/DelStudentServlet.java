package com.Student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.service.Studentservice;


public class DelStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("uid"));
		Studentservice service=new Studentservice();
		int result = service.delete(id);
		if(result==1) {
			request.setAttribute("Delete","É¾³ý³É¹¦!" );
		}else {
			request.setAttribute("Delete", "É¾³ýÊ§°Ü!");
		}
		request.getRequestDispatcher("StudentPageservlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
