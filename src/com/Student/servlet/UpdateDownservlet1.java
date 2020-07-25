package com.Student.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tomcat.util.codec.binary.Base64;

import com.Student.Dao.StudentDao;

import cn.Model.haha.Student;

public class UpdateDownservlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文件名
				String filename = "";
				//获取客户端要保存的文件类型
				String fileType=request.getParameter("fileType");
				  if (fileType.equals("xls")) {  
					  filename="Student.xls";
			        }  
			        else if(fileType.equals("xlsx"))  
			        {  
			        	filename="Student.xlsx";
			        } 
			        else 
			        {
			        	filename="Student.xls";
			        	fileType="xls";
			        }

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		List<Student> list=StudentDao.QueryAllStuden();
		//Excel工作工作簿
		Workbook workBook = ExcelStudent.getInstance().DataToExcel(list, fileType);
		FileOutputStream os1 = new FileOutputStream("D:\\java se\\Student\\WebContent\\upload\\"+filename);
		workBook.write(os1);//将文档对象写入Excel文件输出流
		os1.close();//关闭文件输出流
		//设置响应头
		response.addHeader("content-Type", "application/octet-stream");
		response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+   new String(  Base64.encodeBase64(filename.getBytes("UTF-8"))  ) +"?=" );
		InputStream in = new FileInputStream("D:\\java se\\Student\\WebContent\\upload\\"+filename);
		// 获得输出流--通过response获得的输出流 用于向客户端写内容
		ServletOutputStream out = response.getOutputStream();
		// 文件拷贝代码
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
