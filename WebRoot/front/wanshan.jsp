<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>U闲交易平台</title>
	<link rel="stylesheet" type="text/css" href="front/css/publish.css">
	<link rel="icon" href="front/images/icon.ico">
</head>
<body>
	<!-- header -->
    <div class="header">
        <div class="header_main wrap">
            <h1><a href="index.html" target="_blank"></a><img src="front/images/logo-2.png"></h1>
            <h2>让你的闲置游起来!</h2>
            <ul class="header_menu clearfix">
                <li><a href="front/index.jsp">首页</a></li>
                <li><a href="#">手机二手</a></li>
                <li><a href="#">二手车估价</a></li>
                <li><a href="#">降降降</a></li>
                <li><a href="#" class="active">发布闲置</a></li>
                <li class="header_wdxz">
                    <a href="list.html" target="_blank">我的闲置</a>
                    <ul class="header_xz">  
                        <li><a href="#">出售中：<span>0</span></a></li>  
                        <li><a href="#">交易中：<span>0</span></a></li>  
                        <li><a href="#">新留言：<span>0</span></a></li>
                        <li><a href="#">新会话：<span>0</span></a></li>    
                    </ul> 
                </li>
                <li class="header_mycenter">
                    <a href="#">个人中心</a>
                    <ul class="header_center">  
                        <li><a href="front/wanshan.jsp">完善个人信息</a></li>  
                        <li><a href="front/UpdatePwd.jsp">修改密码</a></li>  
                        <li><a href="#">我的收藏</a></li>  
                    </ul> 
                </li>
                <li class="quit"><a href="ExitServlet_front">退出</a></li>
            </ul>
        </div>
    </div>

	<div><span><a href="front/login.jsp"><font color="orange" size="5">登录</font></a></span></div>
    <!-- 宝贝信息 -->
    <form action="UpdateUserServlet_front" method="get">
    <div class="bbxx wrap">
    	<div class="biaodan"><span>手机号：</span><input name="u_phonenum" type="text" readonly="readonly" value="${u_map.u_phonenum}"></div>
    	<div class="biaodan"><span>昵&nbsp;&nbsp;&nbsp;称：</span><input name="u_nickname" type="text" value="${u_map.u_nickname}"></div>
    	<div class="biaodan"><span>账&nbsp;&nbsp;&nbsp;号：</span><input name="u_account" type="text" value="${u_map.u_account}"></div>
    	<div class="biaodan"><span>生&nbsp;&nbsp;&nbsp;日：</span><input name="u_birthday" type="text" value="${u_map.u_birthday}"></div>
    	<div id="u_headimg" class="tutu"><span>宝贝图片：</span><input type="file" name="xdaTanFileImg" onchange="xmTanUploadImg(this)" accept="image/*"/></div>
        <img id="xmTanImg"/>
        <div id="xmTanDiv"></div>
        <input type="submit" class="qqfb" value="确认修改">  
    </div>
    </form>
    <script type="text/javascript">            
        //判断浏览器是否支持FileReader接口
        if (typeof FileReader == 'undefined') {
            document.getElementById("xmTanDiv").InnerHTML = "<h1>当前浏览器不支持FileReader接口</h1>";
            //使选择控件不可操作
            document.getElementById("xdaTanFileImg").setAttribute("disabled", "disabled");
        }

        //选择图片，马上预览
        function xmTanUploadImg(obj) {
            var file = obj.files[0];
            
            console.log(obj);console.log(file);
            console.log("file.size = " + file.size);  //file.size 单位为byte

            var reader = new FileReader();

            //读取文件过程方法
            reader.onloadstart = function (e) {
                console.log("开始读取....");
            }
            reader.onprogress = function (e) {
                console.log("正在读取中....");
            }
            reader.onabort = function (e) {
                console.log("中断读取....");
            }
            reader.onerror = function (e) {
                console.log("读取异常....");
            }
            reader.onload = function (e) {
                console.log("成功读取....");

                var img = document.getElementById("xmTanImg");
                img.src = e.target.result;
            }

            reader.readAsDataURL(file)
        }
    </script>
    <!-- 底部一堆 -->
    <div class="footer_1 wrap">
        <a href="#" target="_blank">关于我们</a>
        <a href="#" target="_blank">合作伙伴</a>
        <a href="#" target="_blank">营销中心</a>
        <a href="#" target="_blank">廉正举报</a>
        <a href="#" target="_blank">联系客服</a>
        <a href="#" target="_blank">开放平台</a>
        <a href="#" target="_blank">诚征英才</a>
        <a href="#" target="_blank">联系我们</a>
        <a href="#" target="_blank">网站地图</a>
        <a href="#" target="_blank">法律声明及隐私权政策</a>
        <a href="#" target="_blank">知识产权</a>
        <span>1999-<i id="year"></i> ujiuye.com 版权所有</span>
        <script type="text/javascript">
            var day = new Date();
            var year = day.getFullYear();
            document.getElementById('year').innerHTML=year;
        </script>
    </div>
    <div class="footer_2 wrap">
        <a href="#" target="_blank"><img src="front/images/ft1.gif"></a>
        <a href="#" target="_blank"><img src="front/images/ft_01.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_03.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_05.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_07.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_09.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_11.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_13.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_15.jpg"></a>
    </div>
</body>
</html>
