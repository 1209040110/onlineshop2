<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta content="zh-CN" http-equiv="Content-Language" />
    <meta name="viewport"
          content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" />
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
        function  check() {
            var uname=$("#uname").val();
            var pwd=$("#pwd").val();
            if(uname==null||uname.length<1||pwd==null||pwd.length<1){
                alert('请输入用户名和密码');
                return false;
            }return true;
        }
        
    </script>
</head>

<body>
<div class="container">

    <div id="main" style="margin-top: 300px; margin-left: 300px;">
        <h2 style="letter-spacing: 100px;margin: 20px 70px;">登录</h2>
        <form action="login.action" onsubmit="return check()">
            用户名：<input type="text" name="username" id="uname"><span id="unamenotice"></span>
            <p></p>
            密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd" id="pwd">
            <p></p>
            <div style="margin-left:80px"><input  type="submit" value="Go"
                                                 class="button button-pill button-primary"></div>
        </form>
    </div>
</div>

</body>
</html>