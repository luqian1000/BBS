<%--
  Created by IntelliJ IDEA.
  User: luqian1000
  Date: 2018/9/10
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <title>注册</title>

    <link rel="stylesheet" href="/static/css/style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css'  href='/static/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css'  href='/static/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css'  href='/static/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css'  href='/static/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css'  href='/static/css/custom5152.html?ver=1.0' type='text/css' media='all' />
    <script type="text/javascript" src="js/wangEditor.js" ></script>
    <script src="/static/js/vue.js" type="text/javascript"></script>
    <script src="/static/js/axios.min.js" type="text/javascript"></script>
    <script type='text/javascript' src='/static/js/jquery-1.8.3.min.js'></script>
    <script src="/static/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script></script>
    <![endif]-->

</head>

<body>
<jsp:include page="WEB-INF/jsp/header1.jsp"></jsp:include>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">
            <!-- start of page content -->
            <div id="app" class="span8 page-content">
                <article class="type-page hentry clearfix">
                    <h1 class="post-title">
                        <a href="#">注册</a>
                    </h1>
                    <hr>
                    <%--<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>--%>
                </article>

                <!--贴子内容-->
                <form style="margin-left: 200px" class="regiter" action="${pageContext.request.contextPath}/control/user/register" method="post">

                    <div class="span2">
                        <label for="name">用户名 <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="username" datatype="s6-8" nullmsg="请填写用户名！" errormsg="密码为6-10为非中文字符类型" id="name" class="required input-xlarge" value="" >
                    </div>
                    <div class="span2">
                        <label for="name">上传头像 <span>*</span> </label>
                    </div>
                        <div class="span6">
                            <input style="width: 198px" type="file"  v-on:change="filechange"  />
                            <input type="text" style="display: none" name="photo"  v-model="photoname" value="">
                            <img style="width: 30px;height: 30px;" v-bind:src="'http://localhost:8080/image/'+photoname"/><!--上传图片-->
                            <button type="button" v-on:click="upload" >上传</button>
                        </div>

                    <div class="span2">
                        <label >密码<span>*</span></label>
                    </div>
                    <div class="span6">
                        <input type="text" name="password" datatype="hu" nullmsg="密码不能为空！" errormsg="密码为4-6字母、数字或下划线"  class="email required input-xlarge" value="" >
                    </div>
                    <div class="span2">
                        <label>手机号 <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="telphone" datatype="m" errormsg="输入手机格式有误！" ignore="ignore" ig  class="email required input-xlarge" value="" >
                    </div>
                    <div class="span6 offset2 bm30" style="margin-left:30px ;margin-top: 5px;">
                        <input type="submit"  value="注册" class="btn btn-inverse">
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

<div id="footer-bottom-wrapper">
    <div id="footer-bottom" class="container">
        <div class="row">
            <div class="span6">
                <p class="copyright">
                    Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
                </p>
            </div>
            <div class="span6">
                <!-- Social Navigation -->
                <ul class="social-nav clearfix">
                    <li class="linkedin"><a target="_blank" href="#"></a></li>
                    <li class="stumble"><a target="_blank" href="#"></a></li>
                    <li class="google"><a target="_blank" href="#"></a></li>
                    <li class="deviantart"><a target="_blank" href="#"></a></li>
                    <li class="flickr"><a target="_blank" href="#"></a></li>
                    <li class="skype"><a target="_blank" href="skype:#?call"></a></li>
                    <li class="rss"><a target="_blank" href="#"></a></li>
                    <li class="twitter"><a target="_blank" href="#"></a></li>
                    <li class="facebook"><a target="_blank" href="#"></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End of Footer Bottom -->

</footer>
<!-- End of Footer -->

<a href="#top" id="scroll-top"></a>

<!-- script -->


<script type='text/javascript' src='/static/js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='/static/js/prettyphoto/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='/static/js/jflickrfeed.js'></script>
<script type='text/javascript' src='/static/js/jquery.liveSearch.js'></script>
<script type='text/javascript' src='/static/js/jquery.form.js'></script>
<script type='text/javascript' src='/static/js/jquery.validate.min.js'></script>
<script type='text/javascript' src='/static/js/custom.js'></script>

</body>


<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->

<script type="text/javascript">
    $(function () {
        var valid_rule = $(".regiter").Validform({
            tiptype: 3,
            datatype:{
    "hu":/^[0-9a-zA-Z_]{4,6}$/
    }
        });
    })
    var vue=new Vue({
        el:"#app",
        data:{
            photoname:"",
            uploadFile:""
        },
        methods:{
            filechange:function(e){
                var files=e.target.files||e.dataTransfer.files;
                if(!files.length){
                    return;
                }
                this.uploadFile=files[0];
            },
            upload:function(){
                var self=this;
                var params =new FormData();
                params.append("file",self.uploadFile)
                alert(params)
                axios.post("http://localhost:8080/api/common/upload",params).then(function(res){
                    alert("5")
                    var result=res.data;

                    if(result.status==200){
                        var a=JSON.stringify(res);
                        console.log(a)
                        self.photoname=result.data;
                        console.log(self.photoname)
                    }
                })

            }
        }

    })
</script>

</html>

