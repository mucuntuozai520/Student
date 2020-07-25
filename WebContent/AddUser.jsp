<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html>
	<head>
		<meta charset="utf-8">
		<title>注册</title>
		<style>
			body{
			background:url(img/bgImg.jpg)  no-repeat center center;
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
#sub{
	float:left;
	color: white;
	background: red;
	height: 40px;
	width: 300px;
	border: none;
	margin-left:76px;
	text-align: center;
}
article{
	width: 450px;
	height: 320px;
	background: white;
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
}
#div2{
	border: solid 1px #666;
	height:38px ;
	width: 368px;
	margin-left: 40px;
	margin-top: 20px;
}
#lab1{
	float: left;
	height: 38px;
	width: 38px;
	background:url(img/icon1.jpg) no-repeat ;
	border-right: solid 1px #666;
	
}
#div2 input{
	float: left;
	padding: 10px 160px 10px 0px;
	border: none;
	
}
#div3{
	border: solid 1px #666;
	height:38px ;
	width: 368px;
	margin-left: 40px;
	margin-top: 30px;
	margin-bottom: 20px;
}
#lab2{
	float: left;
	height: 38px;
	width: 38px;
	background:url(img/icon2.jpg) no-repeat ;
	border-right: solid 1px #666;
	
}
#div3 input{
	float: left;
	padding: 10px 160px 10px 0px;
	border: none;
}
#div6 a{
	float:left;
	color: white;
	background: red;
	height: 40px;
	width: 300px;
	border: none;
	margin-left:76px;
	text-align: center;
	margin-top: 15px;
	line-height: 40px;
	font-size: 14px;
}


		</style>
	</head>
	<body>
		<article>
			<div id="div1">
				<h2>注册</h2>
			</div>
			<div id="div2">
				<label id="lab1" for="name"></label>
				<form action="AddUserservlet" method="post">
				<input id="name" name="uname" type="text" placeholder="请输入用户名" required="required" />
			</div>
			<div id="div3">
				<label id="lab2" for="pwd"></label>
				<input id="pwd" name="upwd" type="password" placeholder="请输入密码" required="required" />
			</div>
			<div id="div5">
				<input id="sub" type="submit" value="注册">
			</div>
			</form>
			<div id="div6">
				<a href="login.jsp">返回</a>
			</div>
		</article>
	</body>
</html>
