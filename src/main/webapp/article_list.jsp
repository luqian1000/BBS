<%@ page import="com.taru.bbs.pojo.Essay" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
<%--查询列表页--%>
<head>
    <style type="text/css" >
        li {
            float:left;
            list-style:none;
            margin-left: 8px;
        }
    </style>
    <!-- META TAGS -->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>贴子列表</title>

	<!-- Style Sheet-->
	<link rel="stylesheet" href="/static/css/style.css"/>
	<link rel='stylesheet' id='bootstrap-css-css'  href='/static/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
	<link rel='stylesheet' id='responsive-css-css'  href='/static/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
	<link rel='stylesheet' id='pretty-photo-css-css'  href='/static/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
	<link rel='stylesheet' id='main-css-css'  href='/static/css/main5152.css?ver=1.0' type='text/css' media='all' />
	<link rel='stylesheet' id='custom-css-css'  href='/static/css/custom5152.html?ver=1.0' type='text/css' media='all' />
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	<script src="js/html5.js"></script></script>
	<![endif]-->

</head>

<body>
<%--<!-- End of Search Wrapper -->--%>
<jsp:include page="WEB-INF/jsp/header.jsp"></jsp:include>
<!-- Start of Page Container -->
<div class="page-container">
	<div class="container" style="padding: 0 0 0 0;">
		<div class="row">

			<!-- start of page content -->
			<div class="span8 main-listing">

				<article class="format-standard type-post hentry clearfix">
<%--需要贴子和类的信息--%>
					<header class="clearfix" style="min-height: 600px;" >
							<c:forEach items="${requestScope.list.list}" var="map" >

								<h3 class="post-title">
									<%--进入贴子，进入时更新点击量--%>
									<a  href="${pageContext.request.contextPath}/control/update/click?essayId=${map.get("essay_id")}&userId=${userId}">${map.get("essay_name")}</a>
								</h3>
								<div class="post-meta clearfix">
									<%--发帖人--%>
									<span class="date"  style="float: left;"><img style="width: 30px;height: 30px;" src="${pageContext.request.contextPath}/image/${map.get("user_photo")}"/>${map.get("user_name")}</span>
									<%--发帖时间--%>
									<span class="date" style="line-height: 30px">${map.get("essay_data_time")}</span>
										<%--贴子类型--%>

									<span class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=${map.get("category_id")}"  title="View all posts in Server &amp; Database">${map.get("category_name")}</a></span>
									<%--<span class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=${map.get("category_id")}" title="View all posts in Server &amp; Database">${map.get("")}</a></span>--%>
									<%--<span class="like-count">${map.get("essay_clicked")}</span>--%>
									<span style="float: right;">浏览${map.get("essay_clicked")}</span>
								</div><!-- end of post meta -->
							</c:forEach>
					</header>

				</article>
				<%--<div id="pagination">--%>
					<%--<a href="#" class="btn active">1</a>--%>
					<%--<a href="#" class="btn">2</a>--%>
					<%--<a href="#" class="btn">3</a>--%>
					<%--<a href="#" class="btn">Next »</a>--%>
					<%--<a href="#" class="btn">Last »</a>--%>
				<%--</div>--%>
                <div id="pagination" >
                    <%--中间页--%>
                    <%--显示6页中间页[begin=起始页,end=最大页]--%>
                    <%--总页数没有6页--%>
                    <c:choose>
                        <c:when test="${requestScope.list.pages <= 6}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="${requestScope.list.pages}"/>
                        </c:when>
                        <%--页数超过了6页--%>
                        <c:otherwise>
                            <c:set var="begin" value="${requestScope.list.pageNum - 1}"/>
                            <c:set var="end" value="${requestScope.list.pageNum+3}"/>
                            <%--如果begin减1后为0,设置起始页为1,最大页为6--%>
                            <c:if test="${begin -1 <= 0}">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="6"/>
                            </c:if>
                            <%--如果end超过最大页,设置起始页=最大页-5--%>
                            <c:if test="${end>requestScope.list.pages}">
                                <c:set var="begin" value="${requestScope.list.pages-5}"/>
                                <c:set var="end" value="${requestScope.list.pages}"/>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="i" begin="${begin}" end="${end}">
                        <%--当前页,选中--%>
                        <c:choose>
                            <c:when test="${i == requestScope.list.pageNum}">
                                <li >${i}</li>
                            </c:when>
                            <%--不是当前页--%>
                            <c:otherwise>
								<%--如果request域的flag=0进分类查询--%>
								<c:if test="${requestScope.flag==1}">
                                	<li ><a  href="${pageContext.request.contextPath}/control/select/fuzzy?essayname=${requestScope.essayname}&pagenum=${i}">${i}</a></li>
								</c:if>
								<%--如果request域的flag=0进分类查询--%>
								<c:if test="${requestScope.flag==0}">
									<li ><a href="${pageContext.request.contextPath}/control/select/cate?eid=${requestScope.list.list.get(0).get("category_id")}&pagenum=${i}">${i}</a></li>
								</c:if>
								<c:if test="${requestScope.flag==3}">
									<li ><a href="${pageContext.request.contextPath}/control/select/col?userid=${userId}&pagenum=${i}">${i}</a></li>
								</c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
			</div>
			<!-- end of page content -->
			<!-- start of sidebar -->
			<aside class="span4 page-sidebar">
				<section class="widget">
					<div class="support-widget">
						<h3 class="title">求助</h3>
						<p class="intro">需要帮助吗？如果你遇到问题Please call one one zero！ </p>
					</div>
				</section>
			</aside >
				<!-- end of sidebar -->
		</div>
	</div>
</div>
<!-- End of Page Container -->
<%--包含尾部--%>
<jsp:include page="WEB-INF/jsp/foot.jsp"></jsp:include>
<!-- script -->
<script type='text/javascript' src='/static/js/jquery-1.8.3.min.js'></script>
<script type='text/javascript' src='/static/js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='/static/js/prettyphoto/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='/static/js/jflickrfeed.js'></script>
<script type='text/javascript' src='/static/js/jquery.liveSearch.js'></script>
<script type='text/javascript' src='/static/js/jquery.form.js'></script>
<script type='text/javascript' src='/static/js/jquery.validate.min.js'></script>
<script type='text/javascript' src='/static/js/custom.js'></script>


</body>
</html>
</html>