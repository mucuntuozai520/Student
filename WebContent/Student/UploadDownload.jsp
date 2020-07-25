<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导入/导出</title>
<script type="text/javascript" src="../jq/jquery-3.4.1.js"></script>
<script type="text/javascript">
function upload(){
	var targetUrl = $("#ExcelForm").attr("action");  
    //var form = getFormJson($("#ExcelForm"));
    var form = new FormData($("#ExcelForm")[0]);//序列化文件加数据
    $.ajax({
        url:targetUrl,
        type:"post",
        data:form,
        dataType:'json',
        cache: false,
        processData: false, //processData 默认为true，当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
        contentType: false,//二者缺一不可
    success:function(data){
    	 if(data.result=="success"){
    		 alert("上传成功!");
    	 }
          if(data.result=="lost"){
         	alert("只能上传xls和xlsx格式!");
         }
       },
    error:function(e){
    	alert("请求失败");
     }
    });        
  }

function check(){
if($("#Excel").val()=="")
	{
		alert("请选择文件");
		return false;
	}
		upload();
}
function downLoad(){
	 $('#downform').submit();//表单提交
	 }

</script>

<style type="text/css">
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
	color: white;
}
a:hove{
	color: black;
}
#ExcelForm{
	position: absolute;
	left:130px;
	top:420px;
}
#button{
		background: transparent;
		border: none;
		color: white;
		font-size: 48px;
		
}
#Excel{
		background: transparent;
		border: none;
		color: white;
		font-size: 28px;
		width: 328px;
}
#downform{
	position: absolute;
	right:130px;
	top:420px;
}
#button1{
		background: transparent;
		border: none;
		color: white;
		font-size: 48px;
		
}
select{
	width: 62px;
	height: 45px;
	padding-top: 20px;
	font-size: 20px;
}
option{
	font-size: 20px;	
	
}
#div1{
	position: absolute;
	bottom: 50px;
	left:934px;
	font-size: 40px;
}
</style>
</head>
<body>
	<form enctype="multipart/form-data" id="ExcelForm" action="/Student/UpdateDownservlet" method="post" >
		<font color="white" size="28px">Excel文件:</font><input  id="Excel" name="Excel" type="file" size="20" />
		<a id="button" href="javascript:check()">导入</a>
	</form>
	
	 <form id="downform" action="/Student/UpdateDownservlet1" method="post">
		 <font color="white" size="28px">文件类型</font><select name="fileType">
		<option value="xls">xls</option>
		<option value="xlsx">xlsx</option>
		</select>
		<a id="button1" href="javascript:downLoad()">导出数据到Excel</a>
 	</form>
			<div id="div1">
				<a href="/Student/StudentPageservlet">返回</a>
			</div>
</body>
</html>