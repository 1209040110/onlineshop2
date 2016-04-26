<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta content="zh-CN" http-equiv="Content-Language" />
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" />
    <title>网上医药馆</title>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="js/jquery-1.11.0.js"></script>
    <!--<script src="js/sha1.js"></script>-->
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/commonheader.css">
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
<script>
        function login() {
       
        
            var uname=$("#uname").val();
            var pwd=$("#pwd").val();
            $.ajax({
                url : "adminLogin.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'uname':uname,
                    'pwd':pwd
                    
                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                if(data=='ok'){
                   alert('登录成功!');
                   window.location.href="showAllOrders.action";
                 }
                if(data=='fail')
					alert('登录失败!');
                },
                complete: function() {
                    //请求完成的处理
                },
                error: function() {
                    //请求出错处理
                }
            });
           
        }
    </script>
</head>

<body>

<h2>后台登录</h2>

      用户名：<input type="text"  id="uname" required/>
      <p></p>
      密&nbsp;&nbsp;&nbsp;码：<input type="password"  id="pwd" required="required"/>
    <p></p>
      <br/>
     <button onclick="login()">登录</button>
		
</body>
</html>
