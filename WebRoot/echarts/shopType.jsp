<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query.jsp' starting page</title>
    
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
 	//初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));
	
	//指定图表的配置和数据
	var option = {
		//图表标题
		title : {
			text : '商品分类统计图'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		//X轴数据
		xAxis : {
				data : []
		},
		//Y轴数据
		yAxis : {
			
		},
		//系列列表
		series : [ {
			name : '数量',
			type : 'bar',
			label : {
				normal : {
					show : true
				}
			},
			data : []
		} ]
	};
	//使用制定的配置项和数据显示图表
	myChart.setOption(option);
	
	//数据加载完之前先显示一段简单的loading动画
	myChart.showLoading();
	
	var categories = []; //类别数组（实际用来盛放X轴坐标值）
		var nums = []; //销量数组（实际用来盛放Y坐标值）
	
		$.ajax({
			url : 'barServlet',
			type : 'post',
			dataType:'json',
			success : function(data) {
				
				for(var i=0;i<data.length;i++){
					categories.push(data[i].name);
					nums.push(data[i].value);
				}
				 
				myChart.hideLoading(); //隐藏加载动画
				myChart.setOption({ //加载数据图表
					xAxis : {
						data : categories
					},
					series : [ {
						// 根据名字对应到相应的系列
						name : '数量',
						data : nums
					} ]
				});
			},
			error : function() {
				alert('柱状图初始化失败')
			}
		});
 </script>
 </body>
</html>
