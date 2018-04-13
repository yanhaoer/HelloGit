<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按照地区统计平台用户分布情况（饼状图）</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
    <div id="main" style="width: 600px; height: 400px;"></div>
    <script type="text/javascript" src="front/js/echarts.min.js"></script>
    <script type="text/javascript" src="front/js/jquery1.42.min.js"></script>
    <script type="text/javascript">
    $(function(){
			$.ajax({
			url:'PieServlet',
			type : 'post',
			dataType:'json',
			success:function(data){
				//初始化echarts实例   		 'main'是上面div的id
				var myChart = echarts.init(document.getElementById('main'));
				//指定图标的配置和数据
				var option = {
							title : {
								text : '地区统计平台用户分布情况'
						},
						series : [ {
							name : '访问量',
							type : 'pie',
							//设定图表的缩放比例
							radius : '70%',
							data : data
					} ]
			};
				//使用制定的配置项和数据显示图表
				myChart.setOption(option);
			},
			error:function(){
				alert('饼状图初始化失败')
			}
		});
		})
    </script>
</body>
</html>
