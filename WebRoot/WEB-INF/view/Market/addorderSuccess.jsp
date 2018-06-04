<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>DreamMarket商品详情</title>
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/usercenterstyle.css" />

<link rel="stylesheet" href="/ch_DreamMarket/css/datetimepicker/bootstrap-datetimepicker.min.css"
	media="screen" />

<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	   function sum()
		{
		  var input1 = document.getElementById('input1').value;
		  var input2 = document.getElementById('input2').value;
		  var sum = parseInt(input1) * parseInt(input2);
		  document.getElementById('sum').value = sum;
		}

</script>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>

	<font size=4 color="red"> 首页>>确认订单信息<font />

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<h1>
							您的商品订单为
							<s:property value="#request.ordersn" />
						</h1>
						<br />
						<h1>请尽快至用户中心确认是否付款。我们将尽快安排发货</h1>
					</div>
				</div>
			</div>

		</div> <script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script> <script
			type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script> <script
			type="text/javascript" src="/ch_DreamMarket/js/datetimepicker/bootstrap-datetimepicker.js"
			charset="UTF-8"></script> <script type="text/javascript"
			src="/ch_DreamMarket/js/datetimepicker/locales/bootstrap-datetimepicker.ja.js" charset="UTF-8"></script>

		<script type="text/javascript">
//init datetimepicker
$(".form_date").datetimepicker({
	language:  'ja',//i18N
	autoclose: true,//autoclose
	todayHighlight: true,//todayHighlight
	todayBtn: true,//todayBtn
	minView: "month",//minView
	format : "yyyy-mm-dd",//format
	pickerPosition: "bottom-left"//pickerPosition:bottom-left
});
</script>
</body>
</html>

