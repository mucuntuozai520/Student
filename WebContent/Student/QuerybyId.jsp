<%@page import="cn.Model.haha.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完整信息</title>
<style>
			body{
			background:url(/Student/img/demo-1-bg.jpg)  no-repeat center center;
			background-size:cover;
			background-attachment:fixed;
			background-color:#CCCCCC;
		}
			*{
	margin: 0px;
	padding: 0px;
	
}
a{
	text-decoration: none;
}
article{
	width: 450px;
	height: 420px;
	background: transparent;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-top: -150px;
	margin-left: -225px;
	
}
#div1{
	height: 55px;
}
#div1 h2{
	float: left;
	margin-top: 10px;
	margin-left: 10px;
	color: white;
}
#div2{
	height:38px ;
	width: 370px;
	margin-top: 20px;
	margin-left: 28px;
}
#div2 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div3{
	height:38px ;
	width: 370px;
	margin-top: 20px;
	margin-left: 28px;
}
#div3 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div4{
	height:38px ;
	width: 370px;
	margin-top: 20px;
	margin-left: 28px;
}
#div4 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div7{
	height:38px ;
	width: 370px;
	margin-top: 20px;
	margin-left: 28px;
}
#div7 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div6 a{
	float:left;
		color: white;
		background: transparent;
		border: none;
		text-align: center;
		margin-top: 20px;
		font-size: 30px;
		margin-left: 194px;
}
#div5{
	height:38px ;
	width: 370px;
	margin-top: 20px;
	margin-left: 28px;
}
#div5 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div8{
	height:38px ;
	width: 408px;
	margin-top: 20px;
	margin-left: -3px;
}
#div8 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
		</style>
	</head>
	<body>
		<%
			Student stu=(Student)request.getAttribute("student");
		%>
		<article>
			<div id="div1">
				<h2>完整信息</h2>
			</div>
			<div id="div2">
				<font color="white">学号</font><input id="id" name="uid" type="text" value="<%=stu.getId() %>" readonly="readonly"   />
			</div>
			<div id="div7">
				<font color="white">姓名</font><input id="name" name="uname" type="text"  value="<%=stu.getName() %>" readonly="readonly" />
			</div>
			<div id="div3">
				<font color="white">年龄</font><input id="age" name="uage" type="text" value="<%=stu.getAge() %>" readonly="readonly"  />
			</div>
			<div id="div4">
				<font color="white">地址</font><input id="address" name="uaddress" type="text" value="<%=stu.getAddress() %>" readonly="readonly"  />
			</div>
			<div id="div5">
				<font color="white">生日</font><input id="birthday" name="birthday" type="text" value="<%=stu.getTime2()%>" readonly="readonly"  />
			</div>
			<div id="div8">
				<font color="white">录入时间</font><input id="timestamp" name="timestamp" type="text" value="<%=stu.getTime1()%>" readonly="readonly"  />
			</div>
			<div id="div6">
				<a href="/Student/StudentPageservlet">返回</a>
			</div>
		</article>
	</body>
</html>
