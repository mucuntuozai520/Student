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
				//�����ϴ��ļ��Ĵ�С,���ұ������ļ�����֮ǰ
				upload.setSizeMax(1024*100*100);//��λb
				JSONObject js=new JSONObject();
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while(iterator.hasNext()) {
					FileItem item = iterator.next();
						String fileName = item.getName();
						//�����ϴ��ļ�������
						String fileName1=fileName.substring(fileName.indexOf(".")+1);
						if(!(fileName1.equals("xls")| fileName1.equals("xlsx"))) {
							js.put("result", "lost");
						}else {
							//��������
							File file=new File("D:\\java se\\Student\\WebContent\\upload\\",fileName);
							item.write(file);
							 //��ȡExcel������
			                List<Student> list= ExcelStudent.getInstance().ExcelData(fileName);
			                //��������BookInfo��
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
