<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户密码</title>
<script type="text/javascript" src="../jq/jquery-3.4.1.js"></script>
<script type="text/javascript">
function getFormJson(frm) {
	  var o = {};
	  var a = $(frm).serializeArray();
	  $.each(a, function () {
	    if (o[this.name] !== undefined) {
	      if (!o[this.name].push) {
	        o[this.name] = [o[this.name]];
	      }
	      o[this.name].push(this.value || '');
	    } else {
	      o[this.name] = this.value || '';
	    }
	  });
	  return o;
	}
	
	function xxx() {
		var data =getFormJson($("#form1"));
		$.ajax({
			url:"/Student/Updateservlet",
			type:"post",
			data:data,
			success: function (result) {
				if(result=="win"){
					alert("修改成功!");
				}else if(result=="lost"){
					alert("修改失败!");
				}else if(result=="pwd"){
					alert("原密码输入错误!");
				}else{
					alert("两次输入的新密码不一致!");
				}
			}
		});
	}
	
	function password(){
		var pwd=$("#pwd").val();
		var newpwd=$("#newpwd").val();
		var newpwd1=$("#newpwd1").val();
		if(pwd==null|pwd==""){
			alert("原密码不能为空!");
			return false;
		}
		if(newpwd==null|newpwd==""){
			alert("新密码不能为空!");
			return false;
		}
		if(newpwd1==null|newpwd1==""){
			alert("再次确认密码框不能为空!");
			return false;
		}
		xxx();
		return true;
	}
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
	width: 400px;
	margin-top: 20px;
	margin-left: 28px;
}
#div2 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div3{
	height:38px ;
	width: 400px;
	margin-top: 20px;
	margin-left: 28px;
}
#div3 input{
	padding: 10px 160px 10px 0px;
	margin-left: 5px;
}
#div7{
	height:38px ;
	width: 400px;
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


		</style>
	</head>
	<body>
		<article>
			<div id="div1">
				<h2>修改密码</h2>
			</div>
			<form id="form1" action="/Student/Updateservlet" method="post">
			<div id="div2">
				<font color="white">原密码</font><input id="pwd" name="pwd" type="password" placeholder="请输入原密码" required="required" />
			</div>
			<div id="div7">
				<font color="white">新密码</font><input id="newpwd" name="newpwd" type="password" placeholder="请输入新密码" required="required" />
			</div>
			<div id="div3">
				<font color="white">请确认</font><input id="newpwd1" name="newpwd1" type="password" placeholder="请再次输入新密码" required="required" />
			</div>	
			<div id="div5">
				<input id="sub" type="button" onclick="password()"   value="修改">
			</div>
			</form>
			<div id="div6">
				<a href="/Student/StudentPageservlet">返回</a>
			</div>
		</article>
	</body>
</html>
