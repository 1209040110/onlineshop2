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
    <link rel="stylesheet" type="text/css" href="css/adminManage.css">
    <style>

    </style>
    <script>
        function selectUserInfo(uid) {
            $.ajax({
                url : "selectAUserInfo.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'uname':uid
                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                    var user=json.parse(data);
                    $(".uname").html(user.u_id);
                    $(".truename").html(user.truename);
                    $(".addr").html(user.address);
                    $(".phone").html(user.phone);
                    $(".regtime").html(user.regtime);
                    $(".credit").html(user.regtime);
                    $(".qus1").html(user.securityqu1);
                    $(".qus2").html(user.securityqu2);
                    $(".rank").html(user.rank);
                    $(".lastlogintime").html(user.lastlogintime);
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
<body >
    <div class="container">
        <div></div>
        <div id="main">

            <div class="userInfo">

                    <h3 >用户个人信息</h3>
                    <ul>
                        <li>用户名:<span class="uname"><s:property value="u.u_id" /></span></li>
                        <li>真实姓名:<span class="truename"><s:property value="u.truename" /></span></li>
                        <li>邮件地址:<span class="email"><s:property value="u.email" /></span></li>
                        <li>联系方式:<span class="phone"><s:property value="u.phone" /></span></li>
                        <li>地址:<span class="addr"><s:property value="u.address" /></span></li>
                        <li>注册时间:<span class="regtime"><s:property value="u.regtime" /></span></li>
                        <li>积分:<span class="credit"><s:property value="u.credit" /></span></li>
                        <li>用户等级:<span class="rank"><s:property value="u.rank" /></span></li>
                        <li>安全问题1:<span class="qus1"><s:property value="u.securityqu1" /></span></li>
                        <li>安全问题2:<span class="qus2"><s:property value="u.securityqu2" /></span></li>
                        <li>最后一次登录时间:<span class="lastlogintime"><s:property value="u.lastlogintime" /></span></li>
                    </ul>
                    <table border="1">
                        <caption>未付款订单</caption>
                        <tr>
                            <th>订单药品</th>
                            <th>订单总金额</th>
                            <th>订单运费</th>
                            <th>订单支付方式</th>
                            <th>发货地址</th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                </table>
                 <table border="1">
                        <caption>我的收藏</caption>
                        <tr>
                            <th>收藏药品名</th>
                            <th>药品金额</th>
                            <th>药品图片</th>
                            <th>药品适应症</th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                </table>
            </div>





        </div>
    </div>
</body>
</html>