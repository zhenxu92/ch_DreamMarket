<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML">
<html>
  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>DreamMarket Homepage</title>
	<meta name="renderer" content="webkit">
	<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/ch_DreamMarket/css/marketstyle.css" />
	<script>
			function GoingToGoodsDetails(url) {
				window.open(url, "_top");
			}
		</script>
	</head>
  <body style="padding-top:10px;">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body ">
					<p class="bg-success">
						<font size=6 color="red">Trending<font />
					</p>
					<hr>
					<font size=3 color="black"><font />
					 <s:iterator value="#session.selectGoods" var="goods" status="st">
							<div class="col-md-3">
								<table class="table table-bordered" border="5">
									<tr>
										<td align="center">
												<img onclick="GoingToGoodsDetails('/ch_DreamMarket/market/selectGoodsDetails.action?gno=<s:property value="#goods.gno"/>');" src='<s:property value="#goods.gpicture"/>' width=200 height=300 />
										</td>
									</tr>
									<tr>
										<td align="left" style="padding-left:70px;">
											Name:&nbsp;&nbsp;&nbsp;<s:property value="#goods.gname"/>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding-left:70px;">
											Price:&nbsp;&nbsp;&nbsp;<s:property value="#goods.goprice"/>
										</td>
									</tr>
									<tr>
										<td align="left" style="padding-left:70px;">
											Discount:&nbsp;&nbsp;&nbsp;<s:property value="#goods.grprice"/>
										</td>
									</tr>
								</table>
								<br><br><br><br>
							</div>
						</s:iterator>
				</div>
			</div>
			<br>
			<jsp:include page="fenye.jsp"></jsp:include>
		</div>
	</div>
	<!-- <div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-6" align="left">
							<font style="font-size: 14px; line-height: 29px;">快捷入口</font> <br>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3">
							<a class="navbar-brand" href="#">
								<b>1年售后派单响应</b>
							</a>
						</div>
						<div class="col-md-3">
							<a class="navbar-brand" href="#">
								<b>7分钟无理由退货</b>
							</a>
						</div>
						<div class="col-md-3">
							<a class="navbar-brand" href="#">
								<b>30分钟换货保障</b>
							</a>
						</div>
						<div class="col-md-3">
							<a class="navbar-brand" href="#">
								<b>15分钟退货保障</b>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script>
  </body>
</html>
