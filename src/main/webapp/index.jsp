<%--
  Created by IntelliJ IDEA.
  User: luqian1000
  Date: 2018/9/7
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<%--主页--%>
<%--主页--%>
<%--主页--%>
<html lang="en-US"> <!--<![endif]-->
<head>
    <!-- META TAGS -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Coder社区</title>
    <link rel="shortcut icon" href="/static/images/favicon.png" />
    <!-- Style Sheet-->
    <link rel="stylesheet" href="/static/css/style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css'  href='/static/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css'  href='/static/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css'  href='/static/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css'  href='/static/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css'  href='/static/css/custom5152.html?ver=1.0' type='text/css' media='all' />
    <script type='text/javascript' src='/static/js/jquery-1.8.3.min.js'></script>

    <script type='text/javascript' src='/static/js/jquery.easing.1.3.js'></script>
    <script type='text/javascript' src='/static/js/prettyphoto/jquery.prettyPhoto.js'></script>
    <script type='text/javascript' src='/static/js/jflickrfeed.js'></script>
    <script type='text/javascript' src='/static/js/jquery.liveSearch.js'></script>
    <script type='text/javascript' src='/static/js/jquery.form.js'></script>
    <script type='text/javascript' src='/static/js/jquery.validate.min.js'></script>
    <script type='text/javascript' src='/static/js/custom.js'></script>
</head>

<body>
<%--<!-- End of Search Wrapper -->--%>
<jsp:include page="WEB-INF/jsp/header.jsp"></jsp:include>

<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">
                <!-- Basic Home Page Template -->
                <div class="row separator">
                    <section class="span4 articles-list">
                        <h3>热度排行</h3>
                        <ul class="articles">
                <c:forEach items="${requestScope.list1.list}" var="map" >
                            <li class="article-entry standard">
                                    <%--查询该贴子详情，查之前先更新点击量--%>
                                    <%--查询该贴子详情，查之前先更新点击量--%>
                                    <%--查询该贴子详情，查之前先更新点击量--%>
                                <h4><a href="${pageContext.request.contextPath}/control/update/click?essayId=${map.getEssayid()}&userId=${userId}">
                                        ${map.getEssayname()}</a></h4>
                                <span class="like-count">浏览${map.getEssayclicked()}</span>
                                <span class="article-meta">发帖人：${map.getUser().getUsername()}&nbsp&nbsp&nbsp时间：${map.getEssaydatatime()}</span>
                            </li>
                </c:forEach>
                        </ul>
                    </section>

                    <section class="span4 articles-list">
                        <h3>最新帖子</h3>
                        <ul class="articles">
                            <c:forEach items="${requestScope.list2.list}" var="map" >
                                <li class="article-entry standard">
                                    <%--查询该贴子详情，查之前先更新点击量--%>
                                    <h4><a href="${pageContext.request.contextPath}/control/update/click?essayId=${map.getEssayid()}&userId=${userId}">
                                            ${map.getEssayname()}</a></h4>
                                    <span class="like-count">浏览${map.getEssayclicked()}</span>
                                    <span class="article-meta">发帖人：${map.getUser().getUsername()}&nbsp&nbsp&nbsp时间：${map.getEssaydatatime()}</span>
                                </li>
                            </c:forEach>

                        </ul>
                    </section>
                </div>

                <div class="row home-category-list-area">
                    <div class="span8">
                        <h2>Categories</h2>
                    </div>
                </div>

                <div class="row-fluid top-cats">

                    <section class="span4">
                        <h4 class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=1">c语言专区</a></h4>
                        <div class="category-description">
                            <p>为何C语言如此经久不衰？答案是“小身材，大功能。”因为C语音占用的空间很小，但是处理速度和功能却很强大。</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=2">C++专区</a></h4>
                        <div class="category-description">
                            <p>当你需要直接访问硬件获得最大的处理能力时，C++是不二选择。它是开发强大的桌面软件、硬件加速的游戏，以及开发在桌面、控制端和移动设备上的内容密集型应用的最佳编程语言。</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=3">java专区</a></h4>
                        <div class="category-description">
                            <p>Java作为构建现代企业Web应用后端的最常用编程语言之一，是一门必须了解（掌握）的编程语言。网站开发人员凭借Java和基于Java的框架可以为各种用户创建可扩展性的Web应用</p>
                        </div>
                    </section>
                </div>
                <div class="row-fluid top-cats">

                    <section class="span4">
                        <h4 class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=4">提问区</a></h4>
                        <div class="category-description">
                            <p>说出你的疑问，大牛帮你解答</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category">
                            <a href="${pageContext.request.contextPath}/control/select/cate?eid=5">技术讨论</a></h4>
                        <div class="category-description">
                            <p>技术讨论助你成长</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="${pageContext.request.contextPath}/control/select/cate?eid=6">求职</a></h4>
                        <div class="category-description" ><p>最新求职信息，充分实现自己的价值</p>
                        </div>
                    </section>
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


            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->

<!-- Start of Footer -->
<footer id="footer-wrapper">

    <!-- end of #footer -->

    <%--<!-- Footer Bottom -->--%>
    <%--<div id="footer-bottom-wrapper">--%>
        <%--<div id="footer-bottom" class="container">--%>
            <%--<div class="row">--%>
                <%--<div class="span6">--%>
                    <%--<p class="copyright">--%>
                        <%--Copyright &copy; 2018.<a target="_blank" href="home-categories-description.html">程序猿之家</a>--%>
                    <%--</p>--%>
                <%--</div>--%>
                <%--<div class="span6">--%>
                    <%--<!-- Social Navigation -->--%>
                    <%--<ul class="social-nav clearfix">--%>
                        <%--<li class="linkedin"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="stumble"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="google"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="deviantart"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="flickr"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="skype"><a target="_blank" href="skype:#?call"></a></li>--%>
                        <%--<li class="rss"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="twitter"><a target="_blank" href="#"></a></li>--%>
                        <%--<li class="facebook"><a target="_blank" href="#"></a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<!-- End of Footer Bottom -->--%>

<%--</footer>--%>
<%--<!-- End of Footer -->--%>
    <%--包含尾部--%>
<jsp:include page="WEB-INF/jsp/foot.jsp"></jsp:include>
<%--<a href="#top" id="scroll-top"></a>--%>

<!-- script -->


<!-- <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>-->
</body>
</html>
