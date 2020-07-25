package cn.DownLoad.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

public class DownLoadservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String filename = request.getParameter("filename");
		response.addHeader("content-Type", "applictaion/octet-stream");
		response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+   new String(  Base64.encodeBase64(filename.getBytes("UTF-8"))  ) +"?=" );
		InputStream is = request.getServletContext().getResourceAsStream("联系/本帅b的联系方式.txt");
		ServletOutputStream os = response.getOutputStream();
		int len=-1;
		byte[] b=new byte[1024];
		while((len=is.read(b))!=-1) {
			os.write(b, 0, len);
		}
		is.close();
		os.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
