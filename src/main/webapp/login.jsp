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
	${requestScope.LoginError}
</body>
</html>