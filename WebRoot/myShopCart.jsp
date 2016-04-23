<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
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
    <link rel="stylesheet" type="text/css" href="css/font.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
</head>

<body>
 <div class="container" style="width:1270px;">
  <s:include value="commonheader.jsp"/>
  <h3>我的购物车：</h3>
  <table border="0">
  	<tr>
  		<td>商品名</td>
  		<td>单价</td>
  		<td>数量</td>
  		<td>折扣价</td>
  		<td>小计</td>
 	</tr>
 	<tr>
                        <td height="20px;"></td>
    </tr>
 	<s:iterator value="shopCarts" var="shopcart">
 		<tr>
  		<td width="35%"><s:property value="#shopcart.pname"/></td>
  		<td width="10%"><s:property value="%{formatDouble(#shopcart.price)}"/></td>
  		<td width="10%"><s:property value="#shopcart.amount"/></td>
  		<td width="10%"><s:property value="%{formatDouble(#shopcart.discountprice)}"/></td>
  		<td width="10%"><s:property value="%{formatDouble(#shopcart.discountprice*#shopcart.amount)}"/></td>
 	</tr>
 	<tr>
                        <td height="20px;"></td>
    </tr>
 	</s:iterator>
  </table>
  
  
  
    <a class="button button-primary button-pill button-small" href="goSettle.action">去结算</a>
</div>

</body>
</html>