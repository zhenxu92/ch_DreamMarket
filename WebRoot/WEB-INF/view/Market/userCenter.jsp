<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>My Account</title>
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/usercenterstyle.css" />

<link rel="stylesheet" href="/ch_DreamMarket/css/datetimepicker/bootstrap-datetimepicker.min.css"
	media="screen" />

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>

	<font size=6 color="red"> >>Orders<font /> <br />
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<td>
										<p>
											<font size=4 color="blue">Order number<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Total<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Date<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Status<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Details<font />
										</p>
									</td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.selectOrderdetail" var="Orderdetail" status="st">
									<tr>
										<td><font size=3 color="black"><s:property
													value="#Orderdetail.orderBase.ordersn" /><font /></td>
										<td><font size=3 color="black"><s:property
													value="#Orderdetail.orderBase.amount" /><font /></td>
										<td><font size=3 color="black"><s:property
													value="#Orderdetail.orderBase.orderdate" /><font /></td>
										<td><font size=3 color="black"><s:property
													value="#Orderdetail.orderBase.status" /></td>
										<td><font size=3 color="black"> <a data-user="张三" data-toggle="modal"
													href='#orderdetailMessageModal<s:property value="#st.index"/>'
													style="border:0;cursor:pointer;background-color:white;">Details</a></td>
										</font>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div> <s:iterator value="#session.selectOrderdetail" var="Orderdetail" status="st">
			<tr>
				<div class="modal fade" id='orderdetailMessageModal<s:property value="#st.index"/>'
					tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
					<div class="modal-dialog modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Details</h4>
							</div>
							<div class="modal-body">
								<div class="panel panel-default">
									<div class="panel-body">
										<table class="table table-hover">
											<thead>
												<tr>
													<td align="center" valign="middle" colspan="2"><font size=3 color="black">Details<font /></td>
													<td align="center" valign="middle" colspan="2"><font size=3 color="black">Picture<font /></td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td></td>
													<td></td>
													<td colspan="3" rowspan="5">
														<div id="preview">
															<img id="imghead" width=200 height=300 border=0
																src='<s:property value="#Orderdetail.goods.gpicture"/>'>
														</div>
													</td>
												</tr>
												<tr>
													<td style="font-size:20px; font-color:black; font-family:幼圆;"><font size=3
														color="black">Number*<font /></td>
													<td align="left"><font size=3 color="black"><input type="text" width="20"
																id="gno" name="gno" value=<s:property value="#Orderdetail.goods.gno"/> readonly><font /></td>

												</tr>
												<tr>
													<td style="font-size:20px; font-family:幼圆;"><font size=3 color="black">Name*<font /></td>
													<td align="left"><font size=3 color="black"><input type="text" width="20"
																id="gname" name="gname" value=<s:property value="#Orderdetail.goods.gname"/>
																readonly><font /></td>
												</tr>
												<tr>
													<td style="font-size:20px; font-family:幼圆;"><font size=3 color="black">Price*<font /></td>
													<td align="left"><font size=3 color="black"><input type="text" width="20"
																id="goprice" name="goprice" value=<s:property value="#Orderdetail.goods.goprice"/>
																readonly><font /></td>
												</tr>
												<tr>
													<td style="font-size:20px; font-family:幼圆;"><font size=3 color="black">Amount*<font /></td>
													<td align="left"><font size=3 color="black"><input type="text" width="20"
																id="gstore" name="gstore" value=<s:property value="#Orderdetail.shoppingnum"/>
																readonly><font /></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</tr>
		</s:iterator>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<p class="bg-danger">
										<font size=6 color="red"> >>Watch </font>
									</p>
								</tr>
								<tr>
									<td>
										<p>
											<font size=4 color="blue">Your number<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Name<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Picture<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Price<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Explore<font />
										</p>
									</td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.FocusGoods" var="FocusGoods" status="st">
									<tr>
										<td><font size=3 color="black"><s:property value="#FocusGoods.goods.gno" /><font /></td>
										<td><font size=3 color="black"><s:property value="#FocusGoods.goods.gname" /><font /></td>
										<td><img src='<s:property value="#FocusGoods.goods.gpicture"/>' width=60 height=70 /></td>
										<td><font size=3 color="black"><s:property value="#FocusGoods.goods.goprice" /></td>
										<td><a
												href='/ch_DreamMarket/market/selectGoodsDetails.action?gno=<s:property value="#FocusGoods.goods.gno"/>'>
												<font size=3 color="black">Explore<font />
											</a></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script> <script
			type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script> <script
			type="text/javascript" src="/ch_DreamMarket/js/datetimepicker/bootstrap-datetimepicker.js"
			charset="UTF-8"></script> <script type="text/javascript"
			src="/ch_DreamMarket/js/datetimepicker/locales/bootstrap-datetimepicker.ja.js" charset="UTF-8"></script>

		<script type="text/javascript">
			//init datetimepicker
			$(".form_date").datetimepicker({
				language : 'ja',//i18N
				autoclose : true,//autoclose
				todayHighlight : true,//todayHighlight
				todayBtn : true,//todayBtn
				minView : "month",//minView
				format : "yyyy-mm-dd",//format
				pickerPosition : "bottom-left"//pickerPosition:bottom-left
			});
		</script>
</body>
</html>

