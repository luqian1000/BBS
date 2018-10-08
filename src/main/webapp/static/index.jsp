<%@ page import="com.taru.bbs.pojo.Essay" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/static/css/style.css">
    <script type="text/javascript" src="/static/js/vue.js"></script>
    <script type="text/javascript" src="/static/js/axios.min.js"></script>
</head>
<body>
<jsp:include page="/static/header.jsp"></jsp:include>
<div id="app" >
	<% List<Essay> list=(List<Essay>)request.getAttribute("list");
	out.write(list.get(0).getEssayname().toString());
	%>
		<table class="body">
			<tr>
				<th>贴名</th>

                ${requestScope.userId}
				<th>发帖人</th>
				<th>发帖时间</th>
			</tr>
			<c:forEach items="${list}" var="map" >
				<tr>
				<!-- 通过essayId查询贴子 -->
					<%--<td><a href="${pageContext.request.contextPath}/contorl/SelectOne?essayId=${map.get('essayId')}--%>
					<%--&userId=${requestScope.userId}">${map.get("essayName")}</a></td>--%>
					<%--<td>${map.get("userName")}</td>--%>
					<%--<td>${map.get("essayDataTime")}</td>--%>
						<td><a href="${pageContext.request.contextPath}/contorl/SelectOne?essayId=${map.getEssayid()}
						&userId=${requestScope.userId}">${map.getEssayname()}</a></td>
						<td>${map.getUser().getUsername()}</td>
						<td>${map.getEssaydatatime()}</td>
				</tr>
			</c:forEach>

		</table>
	<%--//不能直接点击跳到web-inf内部jsp页面通过controller转一下--%>
  <a href="${pageContext.request.contextPath}/contorl/api/insertbridge?userId=${requestScope.userId}">发帖</a>
</div>
</body>
<%--<script>--%>
<%--var vue=new Vue({--%>
    <%--el:"#app",--%>
    <%--data:{--%>
		<%--userId:"1"--%>
    <%--},--%>
    <%--methods:{--%>
        <%--insert:function () {--%>
            <%--var self=this;--%>
            <%--//alert(self.userId);--%>
            <%--var params=new URLSearchParams();--%>
            <%--params.append("userId",self.userId);--%>
			<%--axios.post("/api/insertbridge",params).then(function (res) {--%>

			   <%--alert(self.userId)--%>
			<%--})--%>
        <%--}--%>
    <%--}--%>
<%--})--%>
<%--</script>--%>
</html>