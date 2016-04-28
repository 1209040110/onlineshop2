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



    <script>
        function checkuname() {
            var uname=$("#uname").val();
            var $unamenotice=$("#unamenotice");
            $.ajax({
                url : "checkUname.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'uname':uname

                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                    if(data=='ok'){
                        $unamenotice.html('该用户名可用！');
                    }
                    if(data=='hasRes'){
                        $unamenotice.html('该用户名已被注册！');
                        $("#uname").val('');
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




        function check() {
            var pwd=$("#pwd").val();
            var truename=$("#truename").val();
            var sex=$("input[name='u.sex']:checked").val();
            var addr=$("#addr").val();
            var qus1=$("#qus1").val();
            var ans1=$("#ans1").val();
            var qus2=$("#qus2").val();
            var ans2=$("#ans2").val();
            var phone=$("#phone").val();
            var email=$("#email").val();
            var str=[pwd,truename,sex,addr,qus1,ans1,qus2,ans2,phone,email];
            for(var i=0;i<str.length;i++){
                if(str[i]==null||str[i].length<1){
                    alert('请正确填写表单！');
                    return false;
                }
            }
            if(pwd.length<6){
                alert('密码小于6位');
                return false;
            }
            if(phone.length!=11){
                alert('电话格式不正确');
                return false;
            }
            if(email.indexOf('@')==-1){
                alert('邮件格式不正确');
                return false;
            }
            return true;
        }


    </script>
</head>


<body>
<div class="container">
    <div id="main">
        <h1 style="letter-spacing: 70px; margin-left:120px;" >注册</h1>
        <form action="Register.action" method="post" onsubmit="return check()">
            <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" >

                <tr>
                    <td width="13%" height="35" >用户名：&nbsp;&nbsp;</td>
                    <td height="35" colspan="2" >
                        <input type="text" name="u.u_id" id="uname" size="20" onblur="checkuname()"/><span id="unamenotice"></span>
                    </td>
                </tr>
                <tr>
                    <td width="13%" height="35"> 密 码： &nbsp;&nbsp;</td>
                    <td height="35" colspan="2" >
                        <input type="password"  size="20" name="u.pwd" id="pwd"/>
                    </td>
                </tr>
                <tr>
                    <td width="13%" height="35"> 真实姓名： &nbsp;&nbsp;</td>
                    <td height="35" colspan="2" >
                        <input type="text"  size="20" name="u.truename" id="truename"/>
                    </td>
                </tr>
                <tr><td>性别：</td>
                    <td>	<label><input name="u.sex" type="radio" value="male" />男 </label>
                        <label><input name="u.sex" type="radio" value="female" />女 </label></td>
                </tr>


                <tr>
                    <td width="13%" height="35"> 地 址： &nbsp;&nbsp;</td>
                    <td height="35" colspan="2" >
                        <input type="text"  size="20" name="u.address" id="addr"/>
                    </td>
                </tr>
                <tr><td>
                    安全问题1:</td><td>  <select name="u.securityqu1" id="qus1">
                    <option value ="你父亲姓名">你父亲名字</option>
                    <option value ="你母亲姓名">你母亲名字</option>
                    <option value="你出生地">你出生地</option>
                    <option value="你高中学校名字">你高中学校名字</option>
                </select></td>
                </tr>
                <tr>
                    <td>安全答案1：
                    </td>
                    <td><input name="u.securityans1" type="text" id="ans1"/>
                    </td>
                </tr>
                <tr>      <td> 安全问题2：</td>
                    <td>  <select name="u.securityqu2" id="qus2">
                        <option value ="你父亲姓名">你父亲名字</option>
                        <option value ="你母亲姓名" selected="selected">你母亲名字</option>
                        <option value="你出生地">你出生地</option>
                        <option value="你高中学校名字">你高中学校名字</option>
                    </select></td>
                </tr>
                <tr>
                    <td>安全答案2：
                    </td>
                    <td><input name="u.securityans2" type="text" id="ans2"/>
                    </td>
                </tr>
                <tr>
                    <td width="13%" height="35"> 手机号： &nbsp;&nbsp;</td>
                    <td height="35" colspan="2" >
                        <input type="text"  size="20" name="u.phone" id="phone"/>

                        <font style="color:red"></font>



                    </td>
                </tr>
                <tr>
                    <td width="13%" height="35"> 邮 箱： &nbsp;&nbsp;</td>
                    <td height="35" colspan="2" >
                        <input type="text"  size="20" name="u.email" id="email"/>

                        <font style="color:red"></font>


                    </td>
                </tr>



                <tr>
                    <td width="20%" height="35" >
                        <input type="submit" id="Submit" value="注册" class="button button-pill button-primary" /> </td>

                    <td width="67%" >
                        <input type="reset" class="button button-pill button-primary" id="cs" value="取 消"/></td>
                </tr>
            </table>
            <br />
        </form>
    </div>
</div>
</body>
</html>