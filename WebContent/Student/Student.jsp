<%@page import="cn.Model.haha.Student"%>
<%@page import="cn.Model.haha.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理系统</title>
<script type="text/javascript" src="jq/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function checkall(){
		$("input[name=check2]:checkbox").prop("checked","checked");
	}
	function delall(){
		var msg="你确定要删除吗?";
		var str="";
		if($("#check1").is(":checked")){
			if(confirm(msg)==true){
				$("input[name=check2]:checkbox:checked").each(function(){
					str=str+","+$(this).val();
				});
				$.ajax({
					url:"DelAllStudentservlet",
					type:"post",
					data:"str="+str,
					success:function(result){
						if(result=="win"){
							$(window).attr("location","StudentPageservlet");
						}else{
							alter("删除失败!");
						}
					}
				});
			}
		}
	}

</script>
<link href="css/student.css" rel="stylesheet" />
</head>
<body>	
		<p id="head">欢迎光临学生信息管理系统!</p>
		<div id="nav"><p>欢迎${sessionScope.User}!</p><a id="up" href="Student/UpdateUser.jsp">修改密码</a><a id="exit" href="Exitservlet">退出</a></div>
		<div id="del">
		<%
			String delete=(String)request.getAttribute("Delete");
			if(delete!=null){
				out.print(delete);
			}
		%>
		</div>
		<div id="add">
		<%
			String add=(String)request.getAttribute("Add");
			if(add!=null){
				out.print(add);
			}
		%>
		</div>
		<div id="update">
		<%
			String update=(String)request.getAttribute("Update");
			if(update!=null){
				out.print(update);
			}
		%>
		</div>
		<article>
			<table border="1">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>年龄</th>
						<th colspan="2"><a href="javascript:delall();">删除</a><input type="checkbox" id="check1" name="check1" onclick="checkall()"></th>
						
					</tr>
				</thead>
				<tbody>
				<%
					Page p=(Page)request.getAttribute("Page");
					for(Student student:p.getStudents()){
				%>		<tr>
						<td><a href="StudentQueryservlet?uid=<%=student.getId() %>"><%=student.getId() %></a></td>
						<td><%=student.getName() %></td>
						<td><%=student.getAge() %></td>
						<td><a href="DelStudentServlet?uid=<%=student.getId() %>">删除</a></td>
						<td><input type="checkbox" id="check2" name="check2" value="<%=student.getId()%>"></td>
						</tr>
				<%
					}
				%>
				</tbody>
			</table>
			<div id="Page">
			<%
			if(p.getCurrentPage()==0){
		%>		<a href="StudentPageservlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
				<a href="StudentPageservlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
			<% 	}else if(p.getCurrentPage()==p.getTotalPage()-1){
		%>		<a href="StudentPageservlet?currentPage=0">首页</a>
				<a href="StudentPageservlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
		<% 	}else{
			%><a href="StudentPageservlet?currentPage=0">首页</a>
			<a href="StudentPageservlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
			<a href="StudentPageservlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
			<a href="StudentPageservlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
	<% 		
			}
	 %>
			
			
			
			</div>
			<a id="ADD" href="Student/AddStudent.jsp">添加</a>
			<a id="updown" href="Student/UploadDownload.jsp">导入/导出</a>
			<a id="UPDATE" href="Student/UpdateStudent.jsp">修改</a>
		
		</article>
		<div id="div10">
		<p><a href="DownLoadservlet?filename=本帅b的联系方式.txt">怎么联系我?</a></p>
		</div>
		
</body>
</html>