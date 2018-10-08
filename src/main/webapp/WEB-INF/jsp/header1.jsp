<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<%--主页--%>
<%--主页--%>
<%--主页--%>
<%--<html lang="en-US"> <!--<![endif]-->--%>
<%--<head>--%>
<%--<!-- META TAGS -->--%>
<%--<meta charset="UTF-8" />--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--</head>--%>
<%--<body>--%>
<!-- Start of Header -->
<div class="header-wrapper">
    <header>
        <div class="container">
            <div class="logo-container">
                <!-- Website Logo -->
                <a href="index-2.html"  title="Coder社区">
                    <img src="/static/images/coder.png" alt="Coder社区">
                </a>

            </div>
            <!-- Start of Main Navigation -->
            <nav class="main-nav">
                <div class="menu-top-menu-container">
                    <ul id="menu-top-menu" class="clearfix">
                        <li><a href="${pageContext.request.contextPath}/control/select/cd">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/insetessay.jsp">发帖</a></li>
                        <li><a href="${pageContext.request.contextPath}/control/select/col?userid=${userId}">我的收藏</a></li>
                        <li><a href="#">分类浏览</a>
                            <ul class="sub-menu">
                                <li><a href="${pageContext.request.contextPath}/control/select/cate?eid=1">C语言专区</a></li>
                                <li><a href="${pageContext.request.contextPath}/control/select/cate?eid=2">C++专区</a></li>
                                <li><a href="${pageContext.request.contextPath}/control/select/cate?eid=3">Java专区</a></li>
                                <li><a href="${pageContext.request.contextPath}/control/select/cate?eid=4">提问区</a></li>
                                <li><a href="${pageContext.request.contextPath}/control/select/cate?eid=5">技术讨论</a></li>
                                <li><a href="${pageContext.request.contextPath}/control/select/cate?eid=6">求职</a></li>
                            </ul>
                        </li>
                        <c:if test="${sessionScope.userName==null}">
                            <li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
                        </c:if>
                        <c:if test="${sessionScope.userName!=null}">
                            <li><a href="${pageContext.request.contextPath}/control/select/user?userid=${sessionScope.userId}"><img src="${pageContext.request.contextPath}/image/${sessionScope.userPhoto}" style="width: 30px;height: 30px;"/> ${sessionScope.userName}</a>
                                <ul class="sub-menu">
                                    <li><a href="${pageContext.request.contextPath}/control/select/user?userid=${sessionScope.userId}">个人中心</a></li>
                                    <li><a href="${pageContext.request.contextPath}/control/login/out">退出登录</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li><a href="${pageContext.request.contextPath}/control/register/bridge">注册</a></li>
                    </ul>
                </div>
            </nav>
            <!-- End of Main Navigation -->
        </div>
    </header>
</div>
<!-- End of Header -->

