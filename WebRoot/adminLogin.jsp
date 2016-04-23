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
    	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>后台登录</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">

</head>

<body>
<h2>后台登录</h2>
 <form action="adminLogin.action" method="post" >
      用户名：<input type="text"  name="username" required/>
      <p></p>
      密&nbsp;&nbsp;&nbsp;码：<input type="password"  name="pwd" required="required"/>
    <p></p>
      <br/>
      <input type="submit" value="Go" class="button button-pill button-primary">
    </form>
</body>
</html>
