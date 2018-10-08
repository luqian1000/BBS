<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: luqian1000
  Date: 2018/9/1
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/static/js/vue.js" type="text/javascript"></script>
    <script src="/static/js/axios.min.js" type="text/javascript"></script>
    <title>Title</title>
</head>
<body>
    <div id="app">

            <form action="${pageContext.request.contextPath}/control/user/register" method="post" >
                    <div>
                        <span>上传头像</span>
                        <input type="file"  v-on:change="filechange"  />
                        <input type="hidden " name="photo" v-model="photoname">
                        <img v-bind:src="'http://localhost:8080/image/'+photoname"/><!--上传图片-->
                        <button type="button" v-on:click="upload" >上传</button>
                    </div>
                    <div>
                        <span>用户名</span>
                        <input type="text" name="username"/>
                    </div>
                    <div>
                        <span>密码</span>
                        <input type="text" name="password"/>
                    </div>

                    <div>
                        <span>手机号</span>
                        <input type="text" name="telphone"/>
                    </div>
                <input type="submit" value="注册"/>
            </form>
    </div>
</body>
<script>
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
