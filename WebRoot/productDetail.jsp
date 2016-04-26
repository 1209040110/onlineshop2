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
	<style>
        #middleright p{
            line-height: 200%;
        }
    </style>
</head>

<body>
    <div class="container">
      <s:include value="commonheader.jsp"/>
       
        <div class="main">
            <div >
                <div class="clearfix" style="margin:0 auto;width:800px;">
                    <div style="float:left;">
                    <img src="images/prodetailimg/<s:property value="productDetail.detailimg"/>"> </div>
                    <div style="float:left; margin-left: 50px; " id="middleright" >
                        <h2><s:property value="product.p_name"/></h2>
                        <p>￥<s:property value="product.unitprice"/></p>
                        <p>运费:10</p>
                        <p>销量:<s:property value="product.salesvolume"/></p>
                        <p>累计评价：<s:property value="product.evaluationsum"/></p>
                        <p>数量：<select name="count" style="width:70px;">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p><button   onclick="addAFav()">收藏商品</button>(<span id="rq"><s:property value="product.rq"/></span>人气)</p>
                        <p><button onclick="gosettle()">立即购买</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button Onclick="addAShopCart()">加入购物车</button></p>
                        
        <script>
  
    function gosettle(){
    	
    	  <s:if test="#session.get('onlineUser')==null">alert('请先登录!')</s:if>;
    <s:else>
     	var amount=$("select").val();
    	$.ajax({
		url : "AddAShopcart.action",
		async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		type : "GET",
		data : {
			'amount':amount,
			'uid':'<s:property value="#session.get('onlineUser').u_id"/>',
			'pid':'<s:property value="product.p_id"/>',
			'price':<s:property value="product.unitprice"/>
		},
		beforeSend: function() {
        //请求前的处理
   	 	},
    	success : function(data, textStatus) {
			//alert(data);
			//alert(textStatus);
			//$("#result").text(data);
			location.href="goSettle.action";
		},
    	complete: function() {
        //请求完成的处理
    	},
    	error: function() {
        //请求出错处理
    	}
	});
	</s:else>
    }
    
    function addAShopCart(){
    <s:if test="#session.get('onlineUser')==null">alert('请先登录!')</s:if>;
    <s:else>
     	var amount=$("select").val();
    	$.ajax({
		url : "AddAShopcart.action",
		async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		type : "GET",
		data : {
			'amount':amount,
			'uid':'<s:property value="#session.get('onlineUser').u_id"/>',
			'pid':'<s:property value="product.p_id"/>',
			'price':<s:property value="product.unitprice"/>
		},
		beforeSend: function() {
        //请求前的处理
   	 	},
    	success : function(data, textStatus) {
			//alert(data);
			//alert(textStatus);
			//$("#result").text(data);
			alert("添加成功");
		},
    	complete: function() {
        //请求完成的处理
    	},
    	error: function() {
        //请求出错处理
    	}
	});
	</s:else>
    }
    
    function addAFav(){
    <s:if test="#session.get('onlineUser')==null">alert('请先登录!');</s:if>;
    <s:else>
    
    	$.ajax({
		url : "addf.action",
		async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		type : "GET",
		data : {
			'pid':'<s:property value="product.p_id"/>',
		},
		beforeSend: function() {
        //请求前的处理
   	 	},
    	success : function(data, textStatus) {
			//alert(data);
			//alert(textStatus);
			//$("#result").text(data);
			//console.log(data);
			if(data=='ok')
			{
				alert('收藏成功！');
				var rq=<s:property value="product.rq"/>;
				$("#rq").html(rq+1);
			}
			if(data=='fail'){
				alert('收藏失败！');
			}
			if(data=='nologin'){
				alert('请登录！');
			}
		},
    	complete: function() {
        //请求完成的处理
    	},
    	error: function() {
        //请求出错处理
        console.log('error');
    	}
	});
	</s:else>
    }
    </script>
                    </div>
                </div>
                <h3>商品详情</h3>
                <div style="height: auto;" class="clearfix">
                    <h4>产品参数</h4>
                    <div>
                        <table border="1">
                            <tr>
                                <td width="400px;">产品名称:<s:property value="product.p_name"/></td>
                                <td width="400px;">产品剂型:<s:property value="productDetail.cpjx"/></td>
                                <td>使用剂量:<s:property value="productDetail.syjl"/></td>
                            </tr>
                            <tr>
                                <td>品牌:<s:property value="productDetail.brand"/></td>
                                <td>有效期:<s:property value="productDetail.expire"/></td>
                                <td>用法:<s:property value="productDetail.yf"/></td>
                            </tr>
                            <tr>
                                <td>药品分类:<s:property value="productDetail.ypfl"/></td>
                                <td>药品名称:<s:property value="product.p_name"/></td>
                                <td>药品通用名:<s:property value="product.p_name"/></td>
                            </tr>
                            <tr>
                                <td>批准文号:<s:property value="productDetail.pzwh"/> </td>
                                <td>生产企业: <s:property value="productDetail.manufacturer"/></td>
                                <td>规格:<s:property value="productDetail.size"/> </td>
                            </tr>
                            <tr>
                               
                                <td>适应症：<s:property value="productDetail.syz"/></td>
                                <td></td>
                                <td></td>
                            </tr>

                        </table>
                    </div>
                    <div>
                    <%int i=1;for(;i<=5;i++){ %>
                        <img src="images/prodetailimg/<s:property value="product.p_id"/>d<%=i%>.jpg">
                        
                     <%} %>
                    </div>
                    <h3>累计评价用户数：<s:property value="product.evaluationsum"/> </h3>
                    <div>得分:<s:property value="product.score"/></div>
                    <a href="addReview.jsp?pid=<s:property value="product.p_id"/>&&pname=<s:property value="product.p_name"/>">增加评论</a>
                    <div class="clearfix">
                    	<table border="1">
                    	<s:iterator value="product.previews" var="rv">
                        	<tr>
                            	<td width="60%" class="" ><s:property value="#rv.r_content"/></td>
                            	<td width="20%" class="" >打分：<s:property value="#rv.score"/></td>
                            	<td width="20%" class="" >（匿名）</td>
                        	</tr>
                        </s:iterator>
                        </table>
                    </div>
                </div>

            </div>
        </div>
        <div class="bottom"></div>
    </div>
</body>
</html>