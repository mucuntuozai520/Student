<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="jq/jquery-3.4.1.js" >
    </script>
    <script type="text/javascript" >
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
    	function xxx(){
    		var data =getFormJson($("#form1"));
    		$.ajax({
    			url:'Userservlet',
    			type:'post',
    			cache:false,
    			data:data,
    			cache:false,
    			dataType:'json',
    			contentType:'application/x-www-form-urlencoded;charset=utf-8',
    			success:function(data){
    				if(data.result=="win"){
    					$(window).attr('location','StudentPageservlet');
    				}else if(data.result=="lost"){
    					alert("用户名或密码错误!");
    				}else{
    					reloadCheckImg();
    					alert("验证码错误!");
    				}
    			}
    		});
    	}
    	function check(){
    		var name=$("#name").val();
    		var pwd=$("#pwd").val();
    		var checkid=$("#checkcodeId").val();
    		if(name==null|name==""){
    			alert("名字不能为空!");
    			return false;
    		}
    		if(pwd==null|pwd==""){
    			alert("密码不能为空!");
    			return false;
    		}
    		if(checkid==null|checkid==""){
    			alert("验证码不能为空!");
    			return false;
    		}
    		xxx();
    		return true;
    	}
      function reloadCheckImg()
      {
          $("img").attr("src", "CheckCode/img.jsp?t="+(new Date().getTime()));//强制刷新
          $("#checkcodeId").val("");
          $("#checkcodeId").focus();
      }

      $(document).ready(function(){
        $("#checkcodeId").blur(function(){
          var $checkcode = $("#checkcodeId").val();
          $.post(
                  "CheckCodeServlet",//服务端地址
                  "checkcode="+$checkcode ,
                  function(result){//图片地址（imgs/right.jpg   imgs/wrong.jpg）
                    //result:  imgs/right.jpg
                    if($checkcode==""){
                    	$("#tip").html("");
                    }else{
                    	 var resultHtml =  $("<img src='"+result+"' height='15' width='15px'/>") ;
                    		 $("#tip").html(resultHtml);
                    }
                  }
          );
        });
      });
    </script>
<head>
<meta charset="UTF-8">
<title>管理登录页</title>
<link href="css/login.css" rel="stylesheet" />
</head>
<body>
		<div id="div0"><p>${requestScope.result}</p></div>
		<article>
			<div id="div1">
				<h2>管理员登录</h2>
				<a id="a1" href="AddUser.jsp">立即注册</a>
			</div>
			<form id="form1" method="post">
			<div id="div2">
				<label id="lab1" for="name"></label>
				<input id="name" name="uname" type="text" placeholder="请输入用户名" required="required" />
			</div>
			<div id="div3">
				<label id="lab2" for="pwd"></label>
				<input id="pwd" name="upwd" type="password" placeholder="请输入密码" required="required" />
			</div>
			<div id="div4">
				<input id="checkcodeId" name="checkcode" type="text" placeholder="验证码" size="4" required="required" />
				<a  href="javascript:reloadCheckImg();"><img src="CheckCode/img.jsp"/></a>
				<span id="tip"></span>
				
			</div>
			<div id="div5">
				<input id="sub" name="sub" type="button" value="登录" onclick="check()">
			</div>
			</form>
		</article>
</body>
</html>