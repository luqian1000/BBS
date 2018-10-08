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

    <title>发帖</title>

    <link rel="stylesheet" href="/static/css/style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css' href='/static/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css' href='/static/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css' href='/static/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css' href='/static/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css' href='/static/css/custom5152.html?ver=1.0' type='text/css' media='all' />

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
<%--包含jsp文件--%>
<jsp:include page="WEB-INF/jsp/header1.jsp"></jsp:include>
<!-- Start of Page Container -->
<div class="page-container" style="min-height: 700px;">
    <div class="container">
        <div class="row">
            <!-- start of page content -->
            <div class="span8 page-content">
                <article class="type-page hentry clearfix">
                    <h1 class="post-title">
                        <a href="#">发帖</a>
                    </h1>
                    <hr>

                </article>
                <!--贴子内容-->
                <form action="${pageContext.request.contextPath}/control/insert/essay?userId=${sessionScope.userId}" method="post">

                    <div class="span2">
                        <label for="name">贴子名称 <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="essayname" id="name" class="required input-xlarge" value="" >
                    </div>

                    <div class="span2">
                        <label >贴子类别<span>*</span></label>
                    </div>
                    <div class="span6">
                        <select name="cateid" class="required input-xlarge" style="width: 283px;height: 31px" >
                            <option value="1" >c语言</option>
                            <option value="2" >c++</option>
                            <option value="3" >java</option>
                            <option value="4" >提问</option>
                            <option value="5" >技术讨论</option>
                            <option value="6" >求职</option>
                        </select>
                    </div>
                    <div class="span2">
                        <label >贴子内容 <span>*</span> </label>
                    </div>
                    <div class="span6" style="width: 1000px;">
                        <%--富文本编辑器--%>
                        <%--div1与div2 隔离标题栏和内容区--%>
                        <div id="div1" class="toolbar">
                        </div>
                        <div style="padding: 5px 0; color: #ccc">请输入内容</div>
                        <div id="div2" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
                        </div>
                        <%--绑定文本域  默认隐藏富文本编辑器的内容会进到下面的文本域，并用name传到form表单--%>
                        <textarea name="essaytext" id="text1" style="display: none" class="required span6" rows="6" ></textarea>
                    </div>

                    <div class="span6 offset2 bm30" style="margin-left:30px ;margin-top: 5px;">
                        <input type="submit"  value="发帖" class="btn btn-inverse">
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
<script type='text/javascript' src='/static/js/jquery-1.8.3.min.js'></script>
<script type='text/javascript' src='/static/js/custom.js'></script>
<script type="text/javascript" src="/static/js/wangEditor.js"></script>
<script type='text/javascript' src='/static/js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='/static/js/prettyphoto/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='/static/js/jflickrfeed.js'></script>
<script type='text/javascript' src='/static/js/jquery.liveSearch.js'></script>
<script type='text/javascript' src='/static/js/jquery.form.js'></script>
<script type='text/javascript' src='/static/js/jquery.validate.min.js'></script>

</body>


<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript">
var E = window.wangEditor
var editor = new E('#div1','#div2')// 两个参数也可以传入 elem 对象，class 选择器
var $text1 = $('#text1')

editor.customConfig.zIndex = 100
editor.customConfig.onchange = function (html) {
// 监控变化，同步更新到 textarea
$text1.val(html)
}

editor.create()

// 初始化 textarea 的值
$text1.val(editor.txt.html())

</script>

</html>

