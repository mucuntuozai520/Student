package cn.CheckCode.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String resultTip = "img/wrong.jpg";
        //��ȡ�û�������֤��
       String checkcodeClient =  request.getParameter("checkcode");

       //��ʵ����֤��ֵ
       String checkcodeServer = (String) request.getSession().getAttribute("CKECKCODE");
       if(checkcodeServer.equals(checkcodeClient)){
           resultTip = "img/right.jpg";
       }
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(resultTip);
        writer.flush();
        writer.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
