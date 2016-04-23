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
    <title>网上医药馆-订单结算页</title>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="js/jquery-1.11.0.js"></script>
    <!--<script src="js/sha1.js"></script>-->
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
    <style>
        a:hover,a:link,a:visited{
            text-decoration: none;
        }

    </style>
    <script>
        function amountChange(command,amount,i,pid) {
        	console.log($(".pamount").eq(i).val());
            mypid=pid.toString().substr(0,5);
            console.log(mypid);
            $.ajax({
                url : "amountChange.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'pid':mypid,
                    'command':command
                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                    if(command=='reduce'){
                      //  $(".pamount").eq(i).html(amount-1);
                    }
                    if(command=='add'){
                       // $(".pamount").eq(i).html(amount+1);
                    }
                    
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
<div class="container" style="width:1270px;">
	<s:include value="commonheader.jsp"/>
    <form action="SubmitOrderAction.action">
        <div class="main">
			
            <h2>选择收货地址:</h2>
            <%int i=0; %>
            <s:iterator value="user.sendAddrs" var="sa">
                <p>	<input name="userOrder.sendaddrId" type="radio" value="<s:property value="#sa.addrId"/>" />
                    地址<%=++i%>:<s:property value="#sa.addrName"/>&nbsp;&nbsp;&nbsp;邮编：<s:property value="#sa.postcode"/>
                    &nbsp;&nbsp;&nbsp; 收货人：<s:property value="#sa.cnee"/>&nbsp;&nbsp;&nbsp;收货人联系方式：<s:property value="#sa.cnee_tel"/>
                </p>
            </s:iterator>
            支付方式：
            <label><input name="userOrder.paymentmode" type="radio" value="cash" />货到付款 </label>
            <label><input name="userOrder.paymentmode" type="radio" value="onlinepay" />在线支付 </label>
            <h2>确认订单信息：</h2>
            <table border="0"  >
                <tr>
                    <td>商品名</td>
                    <td>单价（元）</td>
                    <td>数量</td>
                    <td>折扣价</td>
                    <td>小计（元）</td>

                </tr>
                <tr>
                	<td height="20px;"></td>
                </tr>
                <%int j=0;%>
                <s:iterator value="shopCarts" var="s">

                    <tr >
                        <td width="35%"><s:property value="#s.pname"/></td>
                        <td width="10%"><s:property value="#s.price"/></td>
                        <td width="10%" >
                          <s:property value="#s.amount"/>
                        </td>
                        <td width="10%" class="discount"><s:property value="%{formatDouble(#s.discountprice)}"/></td>
                        <td width="10%" class="finalprice" ><s:property value="%{formatDouble(#s.discountprice*#s.amount)}"/></td>
                        <%j++;%>
                    </tr>

                    <tr>
                        <td height="20px;"></td>
                    </tr>
                </s:iterator>
            </table>

            <p>运费：<s:property value="freight"/></p>
            <div>店铺合计(不含运费）：<s:property value="%{formatDouble(moneysum)}"/></div>
            <p>总计：<s:property value="%{formatDouble(moneysum+freight)}"/></p>
            <input type="submit" value="提交订单" class="button button-pill button-primary">
        </div>

</form>
</div>






</body>
</html>