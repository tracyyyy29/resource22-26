# Vue中使用echarts

## 安装echarts

```shell
npm install echarts
```

## UseEchars.vue

### vue项目

```vue
<template>
	<div id="app">
		  <div id="myChart" :style="{width: '300px', height: '300px'}"></div>
	</div>
</template>

<script>
  export default {
	 mounted() {
	 	// 引入基本模板
	 	let echarts = require('echarts')
	 	let myChart =  echarts.init(document.getElementById('myChart'))
	 	// 绘制图表
	 	myChart.setOption({
			  title: { text: '在Vue中使用echarts' },
			  tooltip: {},
			  xAxis: {
				  data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
			  },
			  yAxis: {},
			  series: [{
				  name: '销量',
				  type: 'bar',
				  data: [5, 20, 36, 10, 10, 20]
			  }]
	 	});
	 }
  } 
</script>
```

### 普通html

``` html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="../js/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function loadechars(){
				var chartDom = document.getElementById('main');
				var myChart = echarts.init(chartDom);
				var option = {
			  title: { text: '在Vue中使用echarts' },
			  tooltip: {},
			  xAxis: {
				  data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
			  },
			  yAxis: {},
			  series: [{
				  name: '销量',
				  type: 'bar',
				  data: [5, 20, 36, 10, 10, 20]
			  }]
	 	}
				myChart.setOption(option);
			}
		</script>
	</head>
	<body onload="loadechars()">
	   <div id="main" style="width: 100%;height:300px;"></div>
	</body>
</html>

```



## 整合 vue 异步加载数据

``` html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="js/echarts.js" type="text/javascript" charset="utf-8"></script>
	    <script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
	    <script src="js/axios.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		
	   <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
		   <div id="app">
			   <button @click="loaddata1">loaddata1</button>
			   <button @click="loaddata2">loaddata2</button>
				<div id="main" style="width: 600px;height:400px;"></div>
		   </div>
		<script type="text/javascript">
			new Vue({
				el:"#app",
				data:{
				   option: {
				     title: {
				       text: 'ECharts 入门示例'
				     },
				     tooltip: {},
				     legend: {
				       data: ['销量']
				     },
				     xAxis: {
				       data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
				     },
				     yAxis: {},
				     series: [
				       {
				         name: '销量',
				         type: 'bar',
				         data: []
				       }
				     ]
				   }
				},
				methods:{
					loaddata1(){
						let myChart = echarts.init(document.getElementById('main'));
						this.option.series[0].data=[5, 20, 36, 10, 10, 20]
						myChart.setOption(this.option)
					},
					loaddata2(){
						let myChart = echarts.init(document.getElementById('main'));
						this.option.series[0].data=[5, 20, 36, 10, 10, 201]
						myChart.setOption(this.option)
					}
				}
			})
		</script>
	</body>
</html>

```



## K线图

``` html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="../js/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function loadechars(){
				var chartDom = document.getElementById('main');
				var myChart = echarts.init(chartDom);
				var option = {
				  xAxis: {
				    data: ['2017-10-24', '2017-10-25', '2017-10-26', '2017-10-27']
				  },
				  yAxis: {},
				  series: [
				    {
				      type: 'candlestick',
				      data: [
				        [20, 34, 10, 38],
				        [40, 35, 30, 50],
				        [31, 38, 33, 44],
				        [38, 15, 5, 42]
				      ]
				    }
				  ]
				};
				myChart.setOption(option);
			}
		</script>
	</head>
	<body onload="loadechars()">
	   <div id="main" style="width: 100%;height:300px;"></div>
	</body>
</html>

```

