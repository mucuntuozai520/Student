package cn.User.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Model.haha.User;
import cn.User.service.Userservice;
import cn.User.util.MD5Utils;

public class AddUserservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		String md5 = MD5Utils.md5(pwd);
		Userservice service=new Userservice();
		User user=new User(name,md5);
		int result = service.Add(user);
		if(result==1) {
			request.setAttribute("result", "×¢²á³É¹¦!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
