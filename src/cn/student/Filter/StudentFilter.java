package cn.student.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest	request=(HttpServletRequest)request1 ;
		HttpServletResponse	response=(HttpServletResponse)response1 ;
		HttpSession session = request.getSession();
		String user=(String)session.getAttribute("User");
		if(request.getServletPath().equals("/login.jsp")|request.getServletPath().equals("/AddUser.jsp")) {
			chain.doFilter(request, response);
		}else {
			if(user==null|user=="") {
				response.sendRedirect("/Student/login.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}
	}
	

}
