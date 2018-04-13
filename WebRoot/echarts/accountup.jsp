<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index3.jsp' starting page</title>

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
	//初始化echarts实例	 (div id="main")='main'
	var myChart = echarts.init(document.getElementById('main'));

	//指定图表的配置和数据
	var option = {
		title : {
			text : '月份统计用户数量增长情况'
		},
		tooltip : {},
		legend : {
			data : [ '用户来源' ]
		},
		//X轴数据
		xAxis : {
				data : []
		},
		yAxis : {
			
		},
		series : [ {
			name : '访问量',
			type : 'line',
			data : []
		} ]
	};
	
	//数据加载完之前先显示一段简单的loading动画
	myChart.showLoading();
	
	//使用制定的配置项和数据显示图表
	myChart.setOption(option);
	var categories = []; //类别数组（实际用来盛放X轴坐标值）
	var nums = []; //销量数组（实际用来盛放Y坐标值）
	
		$.ajax({
			url:'lineServlet',
			type : 'post',
			dataType:'json',	
			success:function(data){
				for(var i=0;i<data.length;i++){
					categories.push(data[i].month);
					nums.push(data[i].count);
				}	 
				
			myChart.hideLoading(); //隐藏加载动画
			myChart.setOption({ //加载数据图表
					xAxis : {
						data : categories
					},
					series : [ {
						// 根据名字对应到相应的系列
						name : '数量/个',
						data : nums
					} ]
				});
			},
			error:function(){
				alert('失败')
			}
		});
</script>
</body>
</html>
