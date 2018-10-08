
<%--
  Created by IntelliJ IDEA.
  User: luqian1000
  Date: 2018/8/29
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖</title>

    <script type="text/javascript" src="/static/js/axios.min.js"></script>
    <script type="text/javascript" src="/static/js/vue.js"></script>
    <script type="text/javascript" src="/static/js/wangEditor.js"></script>
</head>
<body>
    <div id="app">
        ${sessionScope.userId}
        <%--在session域里取userId--%>
        <form action=" ${pageContext.request.contextPath}/contorl/insert/essay?userId=${sessionScope.userId}" method="post">
            <span>贴名</span>
            ${requestScope.userId}
            <div>
                <input type="text" value="" name="essayname" />
            </div>
            <span>内容</span>
            <div>
                <input type="text" value="" name="essaytext" style="height: 200px;" />
                <span>{{essaytext}}</span>
            </div>
            <div>
                <input type="submit" value="发布" />
            </div>
        </form>

            <div id="editor">
                <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
            </div>

            <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
            <script type="text/javascript" src="/wangEditor.min.js"></script>
            <script type="text/javascript">
                var E = window.wangEditor
                var editor = new E('#editor')
                // 或者 var editor = new E( document.getElementById('editor') )
                editor.create()
            </script>
    </div>
</body>
<script>
    var vue=new Vue({
        el:"#app",
        data:{
            essayname:"",
            essaytext:"",
        },
        created:function(){
            this.init()
        },
        methods:{
            init:function () {

            },
            insert:function () {

            }
        }
    })
</script>
</html>
