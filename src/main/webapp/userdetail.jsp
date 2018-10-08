<%--
  Created by IntelliJ IDEA.
  User: luqian1000
  Date: 2018/9/9
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<%--<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->--%>
<%--<!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->--%>
<%--<!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->--%>
<!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
<head>
    <!-- META TAGS -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>用户信息</title>

    <link rel="stylesheet" href="/static/css/style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css' href='/static/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css' href='/static/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css' href='/static/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css' href='/static/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css' href='/static/css/custom5152.html?ver=1.0' type='text/css' media='all' />
    <script type='text/javascript' src='/static/js/jquery-1.8.3.min.js'></script>
    <script src="/static/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <!--<script src="js/html5.js"></script></script>-->

    <style type="text/css">
        .toolbar {
            border: 1px solid #ccc;
            width: 70%;
        }
        .text {
            border: 1px solid #ccc;
            min-height: 100px;
            width: 70%;
        }
    </style>
</head>

<body>

<%--<div class="header-wrapper">--%>
<%--<header>--%>
<%--<div class="container">--%>
<%--<div class="logo-container">--%>
<%--<!-- Website Logo -->--%>
<%--<a href="index-2.html"  title="Knowledge Base Theme">--%>
<%--<img src="/static/images/logo.png" alt="Knowledge Base Theme">--%>
<%--</a>--%>
<%--<span class="tag-line">Premium WordPress Theme</span>--%>
<%--</div>--%>
<%--<!-- Start of Main Navigation -->--%>
<%--<nav class="main-nav">--%>
<%--<div class="menu-top-menu-container">--%>
<%--<ul id="menu-top-menu" class="clearfix">--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cd">首页</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/insetessay.jsp">发帖</a></li>--%>
<%--<li><a href="#">分类浏览</a>--%>
<%--<ul class="sub-menu">--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=1">C语言专区</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=2">C++专区</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=3">Java专区</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=4">提问区</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=5">技术讨论</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=6">求职</a></li>--%>
<%--</ul>--%>
<%--</li>--%>
<%--<c:if test="${sessionScope.userName==null}">--%>
<%--<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>--%>
<%--</c:if>--%>
<%--<c:if test="${sessionScope.userName!=null}">--%>
<%--<li><img src="${pageContext.request.contextPath}/image/${sessionScope.userPhoto}" style="width: 30px;height: 30px;"/> ${sessionScope.userName}--%>
<%--<ul class="sub-menu">--%>
<%--<li><a href="${pageContext.request.contextPath}/control/select/cate?eid=1">个人中心</a></li>--%>
<%--<li><a href="${pageContext.request.contextPath}/control/login/out">退出登录</a></li>--%>
<%--</ul>--%>
<%--</li>--%>
<%--</c:if>--%>
<%--<li><a href="${pageContext.request.contextPath}/login.jsp">注册</a></li>--%>
<%--<li><a href="faq.html">个人中心</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</nav>--%>
<%--<!-- End of Main Navigation -->--%>
<%--</div>--%>
<%--</header>--%>
<%--</div>--%>
<%--包含jsp文件--%>
<jsp:include page="WEB-INF/jsp/header1.jsp"></jsp:include>
<!-- Start of Page Container -->

<div id="app" class="page-container" style="min-height: 700px;">
    <div class="container">
        <div class="row">
            <!-- start of page content -->
            <div class="span8 page-content">
                <article class="type-page hentry clearfix" style="margin-bottom: 60px;">
                    <h1 class="post-title">
                        <a href="#">用户信息</a>
                    </h1>
                    <%--<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>--%>
                </article>

                <!--贴子内容-->
                <form style="margin-left: 200px" class="update" action="${pageContext.request.contextPath}/control/update/user?id=${sessionScope.userId}" method="post">

                    <div class="span2">
                        <%--<lable style="width: 200px">用户名:${requestScope.user.getUsername()} </lable>--%>
                    </div>
                    <div class="span6" style="margin-bottom: 18px;">
                        <span style="width: 200px">用户:<img style="width: 30px;height: 30px;" v-bind:src="'http://localhost:8080/image/'+photoname"/>${requestScope.user.getUsername()} </span>
                        <%--<input type="text" name="username" id="name" class="required input-xlarge" value="${requestScope.user.getUsername()}" >--%>
                   </div>
                    <div class="span2">
                        <label >用户密码<span>*</span></label>
                    </div>
                    <div class="span6" style="margin-bottom: 10px;">
                        <%--//6到10位字符类型--%>
                        <input type="text" name="password" datatype="s6-10" nullmsg="请输入密码" errormsg="密码为6-10为非中文字符类型"  class="required input-xlarge" value="" >

                    </div>
                    <div class="span2">
                      <span>上传头像 </span>
                    </div>
                    <div class="span6" style="margin-bottom: 18px;">
                        <input style="width: 198px" type="file"  v-on:change="filechange"  />
                        <input type="text" style="display: none" name="photo"  v-model="photoname" value="">
                        <img style="width: 30px;height: 30px;" v-bind:src="'http://localhost:8080/image/'+photoname"/><!--上传图片-->
                        <button type="button" v-on:click="upload" >上传</button>
                    </div>
                    <div class="span2">
                        <label >手机号 <span>*</span> </label>
                    </div>
                    <div class="span6" style="margin-bottom: 18px;">
                        <input type="text" name="telphone" datatype="m" errormsg="输入手机格式有误！" id="telphone"  class="required input-xlarge" value="${requestScope.user.getTelphone()}" >

                    </div>
                    <div class="span2">
                        <label  style="width: 200px">注册时间: ${requestScope.user.getUserdatatime()}  </label>
                    </div>
                    <%--<div class="span6">--%>
                        <%--<div  class="required input-xlarge" value="" >${requestScope.user.getUserdatatime()}</div>--%>
                    <%--</div>--%>
                    <div class="span6 offset2 bm30" style="margin-left:30px ;margin-top: 5px;">
                        <input type="submit"  value="更改信息" class="btn btn-inverse">
                        <img src="images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>
                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>

                </form>
            </div>
            <!-- end of page content -->

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

<script type='text/javascript' src='/static/js/custom.js'></script>
<script type='text/javascript' src='/static/js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='/static/js/prettyphoto/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='/static/js/jflickrfeed.js'></script>
<script type='text/javascript' src='/static/js/jquery.liveSearch.js'></script>
<script type='text/javascript' src='/static/js/jquery.form.js'></script>
<script type='text/javascript' src='/static/js/jquery.validate.min.js'></script>
<script src="/static/js/vue.js" type="text/javascript"></script>
<script src="/static/js/axios.min.js" type="text/javascript"></script>

</body>


<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript">
    $(function () {
        var valid_rule = $(".update").Validform({

            tiptype: 3
        });
    })
    var vue=new Vue({
        el:"#app",
        data:{
            photoname:"${requestScope.user.getPhoto()}",
            uploadFile:"",
            photonameinit:"${requestScope.user.getPhoto()}"

        },
        methods:{
            filechange:function(e){
                var files=e.target.files||e.dataTransfer.files;
                if(!files.length){
                    return;
                }
                this.uploadFile=files[0];
                // 检测是否选择图片
                this.sta=1;
            },
            upload:function() {
                var self = this;
                if (self.sta == null) {
                    alert("请选择图片")
                } else {

                    var params = new FormData();
                    params.append("file", self.uploadFile)
                    alert(params)
                    axios.post("http://localhost:8080/api/common/upload", params).then(function (res) {
                        alert("5")
                        var result = res.data;

                        if (result.status == 200) {
                            var a = JSON.stringify(res);
                            console.log(a)
                            self.photoname = result.data;
                            console.log(self.photoname)
                        }
                    })

                }
            }
        }

    })

</script>

</html>




