package cn.User.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.User.service.Userservice;
import cn.User.util.MD5Utils;

public class Updateservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Userservice service=new Userservice();
		HttpSession session = request.getSession();
		 String name=(String)session.getAttribute("User");
		String pwd1 = service.pwd(name);
		String pwd = request.getParameter("pwd");
		String md5 = MD5Utils.md5(pwd);
		String newpwd = request.getParameter("newpwd");
		String newpwd1 = request.getParameter("newpwd1");
		String md51 = MD5Utils.md5(newpwd);
		if(md5.equals(pwd1)) {
			if(newpwd.equals(newpwd1)) {
				int result = service.Updatepwd(md51, name);
				if(result==1) {
					out.print("win");
				}else {
					out.print("lost");
				}
			}else {
				out.print("newpwd");
			}
		}else {
			out.print("pwd");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
