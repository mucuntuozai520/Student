package cn.User.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.Model.haha.User;
import cn.User.service.Userservice;
import cn.User.util.MD5Utils;
import net.sf.json.JSONObject;


public class Userservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		String checkcode = request.getParameter("checkcode");
		String md5 = MD5Utils.md5(pwd);
		User user=new User(name,md5);
		Userservice service=new Userservice();
		int result = service.QueryUser(user);
		HttpSession session = request.getSession();
		String Code = (String)session.getAttribute("CKECKCODE");
		JSONObject js=new JSONObject();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
			if(result==1&Code.equals(checkcode)) {
				js.put("result", "win");
				session.setAttribute("User", user.getName());
			}else{
				if(!(checkcode.equals(Code))) {
					js.put("result", "code");
				}else {
					js.put("result", "lost");
				}
			}
		
		out.print(js.toString());
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
