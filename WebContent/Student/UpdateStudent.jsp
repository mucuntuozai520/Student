<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
<script type="text/javascript" src="../jq/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../jq/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function() {
	$("form").submit(function(){
		var b=$("#name").val();
		var c=$("#age").val();
		if(b.length<2||b.length>6){
			alert("姓名必须为2至6位");
			return false;
		}
		if(c<0||c>120){
			alert("年龄不正确");
			return false;
		}
	});
});
</script>
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
#sub {
	float:left;
	color: white;
	background: transparent;
	border: none;
	text-align: center;
	margin-top: 20px;
	font-size: 30px;
	margin-left: 110px;
}
#div6 a{
	float:left;
		color: white;
		background: transparent;
		border: none;
		text-align: center;
		margin-top: 20px;
		font-size: 30px;
		margin-left: 110px;
}
#div8{
	height:38px ;
	width: 370px;
	margin-top: 20px;
	margin-left: 28px;
}
#div8 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}


		</style>
	</head>
	<body>
		<article>
			<div id="div1">
				<h2>修改学生信息</h2>
			</div>
			<form action="/Student/UpdateStudentservlet" method="post">
			<div id="div2">
				<font color="white">学号</font><input id="id" name="uid" type="text" placeholder="请输入需修改学生的学号" required="required" />
			</div>
			<div id="div7">
				<font color="white">姓名</font><input id="name" name="uname" type="text" placeholder="请输入新的名字" required="required" />
			</div>
			<div id="div3">
				<font color="white">年龄</font><input id="age" name="uage" type="text" placeholder="请输入新的年龄" required="required" />
			</div>
			<div id="div4">
				<font color="white">地址</font><input id="address" name="uaddress" type="text" placeholder="请输入新的地址" required="required" />
			</div>
			<div id="div8">
				<font color="white">生日</font><input id="birthday" name="ubirthday" type="text" placeholder="请输入新的生日日期"  onFocus="WdatePicker()" required="required" />
			</div>
			<div id="div5">
				<input id="sub" type="submit" value="修改">
			</div>
			</form>
			<div id="div6">
				<a href="/Student/StudentPageservlet">返回</a>
			</div>
		</article>
	</body>
</html>
