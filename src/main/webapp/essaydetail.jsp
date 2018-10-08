<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
<head>
	<!-- META TAGS -->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>贴子详情</title>

	<link rel="shortcut icon" href="images/favicon.png" />
	<!-- Style Sheet-->

	<link rel="stylesheet" href="/static/css/style.css"/>
	<link rel='stylesheet' id='bootstrap-css-css'  href='/static/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
	<link rel='stylesheet' id='responsive-css-css'  href='/static/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
	<link rel='stylesheet' id='pretty-photo-css-css'  href='/static/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
	<link rel='stylesheet' id='main-css-css'  href='/static/css/main5152.css?ver=1.0' type='text/css' media='all' />
	<link rel='stylesheet' id='custom-css-css'  href='/static/css/custom5152.html?ver=1.0' type='text/css' media='all' />





	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
	<![endif]-->
	<style type="text/css">
		.toolbar {
			border: 1px solid #ccc;
			width: 60%;
		}
		p{
			margin: 0px 0 20px;
			float: left;
			/*margin-left: 100px;*/

		}
		.text {
			border: 1px solid #ccc;
			height: 100px;
			width: 60%;
		}
	</style>
</head>

<body>
<%--<!-- End of Search Wrapper -->--%>
<jsp:include page="WEB-INF/jsp/header1.jsp"></jsp:include>
<!-- Start of Page Container -->
<div class="page-container" id="app">
	<div class="container">
		<div class="row">
			<!-- start of page content -->
			<div class="span8 page-content">
<%--需要文章及发布者表数据，当前用户表，评论表，--%>
<%--五表联查通过贴子ID查出贴子内容，通过用户ID相同左连接用户表查出发贴人昵称发帖时间，通过贴子ID相同左连接查出该贴子下的评论，通过评论表里的用户ID与User表用户ID相同查出评论者id--%>
				<article class=" type-post format-standard hentry clearfix" style="margin-bottom: 40px;">
					<%--贴子名--%>
					<h1 class="post-title">${requestScope.list.get(0).get("essay_name")}</h1>
					<div class="post-meta clearfix">
						<%--发帖人--%>
						<span class="date"><h5><img src="${pageContext.request.contextPath}/image/${requestScope.list.get(0).get("user_photo")}"style="width: 30px;height: 30px;"/>发帖人：${requestScope.list.get(0).get("user_name")}</h5></span>
					    <%--发帖时间--%>
						<span class="date">&nbsp&nbsp&nbsp&nbsp时间：${requestScope.list.get(0).get("essay_data_time")}</span>
						<%--贴子类别--%>
						<span class="category"><a href="#" title="View all posts in Server &amp; Database">&nbsp&nbsp&nbsp&nbsp类别：${requestScope.list.get(0).get("category_name")}</a></span>
						<%--贴子点击量--%>
						<span id="like-it-form" class="like-it ">&nbsp&nbsp&nbsp&nbsp浏览量：${requestScope.list.get(0).get("essay_clicked")}</span>
							<%--收藏贴子ajax请求--%>
						<span id="like-it-form" class="like-it " v-on:click="m()" style="cursor: pointer;" ><strong > 收藏</strong></span>
					</div><!-- end of post meta -->
						<div style="border-bottom:1px solid #f2f2f2; border-top:#f2f2f2; ">&nbsp&nbsp&nbsp&nbsp${requestScope.list.get(0).get("essay_text")}</div>
				</article>
                <form  style="" action="${pageContext.request.contextPath}/control/comment?userid=${requestScope.userId}&essayid=${requestScope.list.get(0).get("essay_id")}" method="post" style="border: 1px solid;">
					<%--富文本编辑器--%>
					<%--div1与div2 隔离标题栏和内容区--%>
					<div id="div1" class="toolbar">
					</div>
					<div style="padding: 5px 0; color: #ccc">请输入内容</div>
					<div id="div2" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
					</div>
						<%--绑定文本域  默认隐藏富文本编辑器的内容会进到下面的文本域，并用name传到form表单--%>
					<textarea name="text" style="display: none" id="text1" class="required span6" rows="6" ></textarea>
					<input type ="submit" value="评论">
                </form>
                <%--遍历所有评论--%>
                <c:forEach items="${requestScope.list}" var="map">
                    <%--如果父id等于空证明是一级评论--%>
                    <c:if test="${map.get('comment_fa_id')==null&&map.get('comment_text')!=null}">
                        <div style="border-bottom: #2D3A4B solid 2px;margin-bottom: 5px;">
							<div >
								<div >一级评论：<img src="${pageContext.request.contextPath}/image/${map.get("comment_user_photo")}" style="width: 30px;height: 30px;"/>${map.get("comment_user_name")}说：</div>
								<div style="float: left">${map.get('comment_text')}</div>
								<div style="margin-left: 500px">&nbsp&nbsp&nbsp&nbsp&nbsp时间：${map.get('comment_data_time')}</div>
							</div>
                            <form style="margin:0 0 5px" action=${pageContext.request.contextPath}/control/comment?userid=${requestScope.userId}&essayid=${map.get("essay_id")}&fatherid=${map.get("comment_id")} method="post"/>
                                <div>
                                 <a href="javascript:;" class="reply_btn" style="color: blue">回复</a>
								</div>
							<%--<div id='div3' class='toolbar'> </div><div style='padding: 5px 0; color: #ccc'>请输入内容</div><div id='div4' class='text'></div><textarea name='text' style='display: none' id='text2' class='required span6' rows='6'></textarea><input type ='submit' value='提交'/>--%>
                            </form>
                                <%--继续遍历所有评论--%>
                            <c:forEach items="${requestScope.list}" var="maptwo">
                                <%--如果一级的评论id等于二级的父id--%>
                                <c:if test="${map.get('comment_id')==maptwo.get('comment_fa_id')}">
                                    <div  >
                                        <div> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp二级评论:<img style="width: 30px;height: 30px;" src="${pageContext.request.contextPath}/image/${maptwo.get("comment_user_photo")}"/>${maptwo.get("comment_user_name")}回复<img style="width: 30px;height: 30px;" src="${pageContext.request.contextPath}/image/${map.get("comment_user_photo")}"/>${map.get('comment_user_name')}:${map.get('comment_text')}<strong>---&gt;</strong>${maptwo.get("comment_text")}&nbsp&nbsp&nbsp时间：${maptwo.get("comment_data_time")}  </div>
                                        <form style="margin:0 0 5px"  action=${pageContext.request.contextPath}/control/comment?userid=${requestScope.userId}&essayid=${map.get("essay_id")}&fatherid=${maptwo.get("comment_id")} method="post"/>
                                            <a href="javascript:;" class="reply_btn" style="color: blue" > &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp回复</a>
                                        </form>
                                        <c:forEach items="${requestScope.list}" var="mapthree">
                                            <c:if test="${maptwo.get('comment_id')==mapthree.get('comment_fa_id')}">
                                                <div> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp三级评论:<img style="width: 30px;height: 30px;" src="${pageContext.request.contextPath}/image/${mapthree.get("comment_user_photo")}"/>${mapthree.get("comment_user_name")}回复<img style="width: 30px;height: 30px;" src="${pageContext.request.contextPath}/image/${maptwo.get("comment_user_photo")}"/>${maptwo.get('comment_user_name')}:${maptwo.get('comment_text')}<strong>---&gt;</strong>${mapthree.get("comment_text")}&nbsp&nbsp&nbsp时间：${mapthree.get("comment_data_time")}  </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:if>
                 <c:if test="${map.get('comment_text')==null}">
					 无评论！
				 </c:if>
                </c:forEach>
			</div>
			<!-- end of page content -->

			<!-- start of sidebar -->
			<aside class="span4 page-sidebar">
				<section class="widget">
					<div class="support-widget">
						<h3 class="title">求助</h3>
						<p style="float: unset"  class="intro">需要帮助吗？如果你遇到问题Please call one one zero！ </p>
					</div>
				</section>
			</aside>
			<!-- end of sidebar -->
		</div>
	</div>
</div>
<!-- End of Page Container -->

  <%--包含尾部--%>
<jsp:include page="WEB-INF/jsp/foot.jsp"></jsp:include>

<!-- script -->
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
<script type='text/javascript' src='/static/js/vue.js'></script>
<script type='text/javascript' src='/static/js/axios.min.js'></script>


</body>
<script type="text/javascript">
    var vue =new Vue({
        el:"#app",
        data:{
			userid:"${userId}",
			essayid:"${requestScope.list.get(0).get('essay_id')}"

        },
        methods:{
            m:function () {
                var self=this;
                var params =new URLSearchParams();
                eid=self.essayid;
                uid=self.userid;
                alert(uid)
                params.append("essayid",eid)
                params.append("userid",uid)
                axios.post("${pageContext.request.contextPath}/api/insert/col",params).then(function (res) {
                    //把取得的值赋给a；
                    var a=res.data;
                    if(a.status==200){
                        alert("收藏成功")
                    }else if(a.status==300){
                        alert("文章已在收藏列表")
                    }else{
                        alert("插入失败")
                    }
                })
            }
        }

    })
    $(function(){
        //页面加载完毕后开始执行的事件
        $(".reply_btn").click(function(){
            $(".reply_textarea").remove();
            $(this).parent().append("<div class='reply_textarea'><textarea name='text' cols='40' rows='5'></textarea><br/><input type='submit' value='发表' /></div>");
            //$(this).parent().append("<div class='reply_textarea'><div id='div3' class='toolbar'> </div><div style='padding: 5px 0; color: #ccc'>请输入内容</div><div id='div4' class='text'></div><textarea name='text' style='display: none' id='text2' class='required span6' rows='6'></textarea><input type ='submit' value='提交'/></div>");

        });
    });
    var E = window.wangEditor
    var editor = new E('#div1','#div2')// 两个参数也可以传入 elem 对象，class 选择器
    var $text1 = $('#text1')
    var editor1= new E('#div3','#div4')
    var $text2 = $('#text2')
    editor.customConfig.zIndex = 100
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    editor1.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text2.val(html)
    }

    editor.customConfig.menus = [
        'head',
        'bold',
        'italic',
        'underline',
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
    ]
    editor.create()
    editor1.create()
    // 初始化 textarea 的值
    $text1.val(editor.txt.html())
    $text2.val(editor.txt.html())

</script>



</html>
