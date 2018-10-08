<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贴子详情</title>
    <script type="text/javascript" src="/static/js/axios.min.js"></script>
    <script type="text/javascript" src="/static/js/vue.js"></script>
</head>
<body>
<div id="app">
	<%--${map.get('comment_fa_id')}==${map.comment_fa_id}--%>
	<%--<% List<HashMap<String,Object>> list=(List<HashMap<String,Object>>)request.getAttribute("list");--%>
	<%--out.write(list.get(0).toString());--%>
	<%--%>--%>
	<%=request.getAttribute("userId") %>
	<a href="${pageContext.request.contextPath}/contorl/back?userId=${requestScope.userId}">返回首页</a>
 <h1 style="text-align: center;border: 1px solid;">${requestScope.list.get(0).get("essay_name")}</h1><!--标题-->
	<div style="border: 1px solid;">
	<div style="float:left; border: 1px solid;"><h5><img src="http://localhost:8080/image/${requestScope.list.get(0).get("user_photo")}"style="width: 30px;height: 30px;"/>发帖人：${requestScope.list.get(0).get("user_name")}</h5></div>
	<div style=" border: 1px solid;"><h5>&nbsp&nbsp&nbsp&nbsp时间：${requestScope.list.get(0).get("user_data_time")}</h5></div>
	</div>
	<div style="border: 1px solid;"><p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp贴子内容${requestScope.list.get(0).get("essay_text")}</p></div>
	<!-- 回复 -->
		<%--由于mybatis框架且指定返回类型是HashMap所以返回值属性值的格式是数据库格式为user_id--%>
	 <form action="${pageContext.request.contextPath}/contorl/comment?userid=${requestScope.userId}&essayid=${requestScope.list.get(0).get('essay_id')}" method="post" style="border: 1px solid;">
		<input type="text" name="text"/> 
		<input type="submit" value="评论">
	</form>
	<c:forEach items="${requestScope.list}" var ="map">
		<div style="border: 1px solid;">
               <c:out value=" ${map.comment_fa_id}"></c:out>
            <c:if test="${map.comment_fa_id==null}">
			    <h4><img style="width: 20px;height: 20px;"src="http://localhost:8080/image/${requestScope.list.get(0).comment_user_photo}"/>${map.comment_user_name }:${map.comment_text }</h4>
            </c:if>
            <form action=${pageContext.request.contextPath}/contorl/comment?userid=${requestScope.userId}&essayid=${map.get('essayId')}&fatherid=${map.get('commentId')}" method="post"/>
                    <span onclick='reply()'>回复</span>
                    <input   name="text" />
                    <input type="submit" value="回复" />
               </form>
		</div>
	</c:forEach>
</div>
</body>
    <script>
        function reply() {
            document.getElementById("reply").style.display = 'block';
            document.getElementById("repl").style.display = 'block';
        }
    </script>
</html>