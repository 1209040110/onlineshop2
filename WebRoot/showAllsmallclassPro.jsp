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
    <link rel="stylesheet" type="text/css" href="css/commonheader.css">
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
	<link rel="stylesheet" type="text/css" href="css/smallclass.css">
</head>

<body>
    <div class="container">
       <s:include value="commonheader.jsp"/>
        
        <div class="main">
            <div class="maintop clearfix">
                <ul>
                    <li>综合</li>
                    <li>人气</li>
                    <li>销量</li>
                    <li>价格</li>
                </ul>
            </div>
            <div class="maincontent clearfix">
               <%int i=0; %>
                     <s:iterator value="products" var="p">
                     <%i++; %>
                    <%if((i-1)%5==0){%><ul><%}%>
                        <li>
                            <p><img src="images/productimg/<s:property value="#p.smallimg"/>"></p>
                            <p><a href="ShowProDetail.action?p_id=<s:property value="#p.p_id" />"><s:property value="#p.p_name"/></a></p>
                            <p>￥<s:property value="#p.unitprice"/></p>
                            <p>该款月成交<s:property value="#p.salesvolume"/>笔</p>
                        </li>
                        
                  <%if(i%5==0){%>  </ul><%}%>
                   </s:iterator>
              
            </div>
            <div class="">上一页  1  2  3...下一页 </div>
        </div>
        <div class="bottom"></div>
    </div>
</body>
</html>