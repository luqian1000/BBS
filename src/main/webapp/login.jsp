<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <%--<link rel="stylesheet" href="/static/css/京东登录.css">--%>
    <link rel="stylesheet" href="/static/css/login.css">
</head>
<body>
	<%--<form action="${pageContext.request.contextPath}/contorl/login/in" method="post" class="body">--%>
		<%--<span>用户名</span>--%>
		<%--<input name="username" type="text" value="ea">--%>
		<%--<span>密码</span>--%>
		<%--<input name="password" type="text" value="546">--%>
		<%--<input value="login" type="submit">--%>
	<%--</form>--%>
    <div class="top center">
        <div class="logo center">
            <a href="./index.html" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/control/login/in" method="post" class="body" class="form center">
        <div class="login">
            <div class="login_center">
                <div class="login_top">
                    <div class="left fl">会员登录</div>

                    <div class="clear"></div>
                    <div class="xian center"></div>
                </div>
                <div class="login_main center">
                    <div class="username">用户名:&nbsp;<input class="shurukuang" type ="text" name ="username" value=""placeholder="请输入你的用户名" /></div>
                    <div class="username">密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <input type ="text"  class="shurukuang" name ="password" value=""  placeholder="请输入你的密码"/></div>
                </div>
                <div class="login_submit">
                    <input class="submit" type="submit"  value="立即登录" >
                </div>
                <div class="right fr">您还不是我们的会员？<a href="${pageContext.request.contextPath}/control/register/bridge">立即注册</a></div>
            </div>
        </div>
    </form>

    <%--<form action="${pageContext.request.contextPath}/contorl/login/in" method="post" class="body">--%>
    <%--<div class="c1" style="border:1px solid orange;">--%>
        <%--<div class="user"></div>--%>
        <%--<div class="user1">--%>
            <%--<label>用户名</label>--%>
            <%--<input type ="text" name ="username" value=""   class="input-box" id="user"/>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="c2" style="border:1px solid orange;">--%>
        <%--<div class="pass"></div>--%>
        <%--<div class="pass1">--%>
            <%--<label>密码</label>--%>
            <%--<input type ="text" name ="password" value=""  class="input-box" id="password"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--&lt;%&ndash;<!-- 二维码-->&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div style="margin-top:50px ;margin-left:750px">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<img v-bind:src="checkcode" v-on:click="codeClick" />&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type ="text" name ="二维码" value="" v-model="barcode" class="input-box" id="code"style="width:10%"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<button class="button" id="btn" v-on:click="login" style="width:10%">登录</button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--<input value="登录" type="submit" class="button" id="btn" style="border:1px solid orange; width:5%;float:left;margin-left: 500px;">--%>
    <%--</form>--%>
   <%--<a href="${pageContext.request.contextPath}/contorl/register/bridge">注册</a>--%>

	${requestScope.LoginError}
</body>
</html>