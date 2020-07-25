package com.Student.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Student.Dao.StudentDao;

import cn.Model.haha.Student;
import net.sf.json.JSONObject;



public class UpdateDownservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean multipartContent = ServletFileUpload.isMultipartContent(request);
		if(multipartContent) {
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			int id=-1;
			String name=null;
			try {
				//设置上传文件的大小,并且必须在文件解析之前
				upload.setSizeMax(1024*100*100);//单位b
				JSONObject js=new JSONObject();
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while(iterator.hasNext()) {
					FileItem item = iterator.next();
						String fileName = item.getName();
						//限制上传文件的类型
						String fileName1=fileName.substring(fileName.indexOf(".")+1);
						if(!(fileName1.equals("xls")| fileName1.equals("xlsx"))) {
							js.put("result", "lost");
						}else {
							//加上名字
							File file=new File("D:\\java se\\Student\\WebContent\\upload\\",fileName);
							item.write(file);
							 //获取Excel表单数据
			                List<Student> list= ExcelStudent.getInstance().ExcelData(fileName);
			                //批量插入BookInfo表
			                StudentDao.addStudentBatch(list);
							js.put("result", "success");
						}
				}
				response.setContentType("application/json;utf-8");
				PrintWriter out = response.getWriter();
					out.print(js);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
