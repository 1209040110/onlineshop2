<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
request.setCharacterEncoding("utf-8");
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
    <style>
        .container{
            width:1270px;
            margin: 0 auto;
        }
    </style>
    <script>
        function submitreview() {
        <%if(session.getAttribute("onlineUser")==null){%>
        	alert('请先登录!');
        <%}else{%>
        
            var score=$("#score").val();
            var content=encodeURI($("#content").val(),"UTF-8");
            $.ajax({
                url : "AddRe.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'r.score':score,
                    'r.r_content':content,
                    'r.p_id':'<%=(String)request.getParameter("pid")%>'
                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                if(data=='nologin')
                	alert('请先登录!');
                if(data=='ok')
                   alert('评论成功!');
                if(data=='fail')
					alert('评论失败!');
                },
                complete: function() {
                    //请求完成的处理
                },
                error: function() {
                    //请求出错处理
                }
            });
            <%}%>
        }
    </script>
</head>
<body>
<div class="container">
    <div></div>
    <div id="main">
    	<h2>商品评论:</h2>
    	<%String pname = new String(request.getParameter("pname").getBytes("iso-8859-1"), "utf-8"); %>
        <p>商品名：<%=pname%></p>
        <p>打分：
            <select  id="score">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </p>
        <p>评论内容:</p>
            <textarea  style="width: 300px; height: 150px;" id="content">

            </textarea>
         <br/>
        <button onclick="submitreview()">提交</button>
    </div>
</div>
</body>
</html>