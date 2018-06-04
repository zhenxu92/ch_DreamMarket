<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Details</title>
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/usercenterstyle.css" />

<link rel="stylesheet" href="/ch_DreamMarket/css/datetimepicker/bootstrap-datetimepicker.min.css"
	media="screen" />

<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
			function submitcommit(){
		   	window.onbeforeunload = null;
			var formObj = document.getElementById("orderconfirm");
			document.getElementById("orderconfirm").action=formaction="/ch_DreamMarket/market/OrderAction.action?bid=<s:property value="#session.buser.bid"/>&amount=<s:property value="#session.sum"/>" ;
			formObj.submit();
		}
			function text(){
				return "Orders will be deleted，sure?;"
			}
</script>

</head>
<body onbeforeunload="return text();">
	<jsp:include page="head.jsp"></jsp:include>
	<font size=4 color="red"> Order confirmation<font /> 
		<s:form id="orderconfirm" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">

							<table class="table table-hover">
								<thead>
									<tr>
										<td><font size=3 color="blue">Current Price</font></td>
										<td><font size=3 color="blue">Market Price</font></td>
										<td><font size=3 color="blue">Qty</font></td>
										<td><font size=3 color="blue">Select</font></td>
									</tr>

								</thead>
								<tbody>
									<s:iterator value="#session.goods" var="goods" status="st">
										<tr>
											<td><br />
											<font size=3 color="black"><s:property value="#goods.gname" /></font></td>
											<td><br />
											<font size=3 color="black"><s:property value="#goods.grprice" /></font></td>
											<td><br />
											<font size=3 color="black"><input type="text" name="shoppingnumList"
														value='<s:property value="#goods.shoppingnum"/>' readonly></font></td>
											<td align="left"><br /> <input type="checkbox" name="goods.gnoList"
													value='<s:property value="#goods.gno"/>' checked="checked" onclick="return false">
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td colspan="2" align="right" style="padding-right:115px"><font size=6 color="red">Your total:<s:property
													value="#session.sum" />￥
										</font></td>
										<td colspan="2" align="right" style="padding-right:115px"><input type="button"
												class="btn btn-danger" value="Confirm" data-toggle="modal" data-target="#myModal" /></td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>

			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Enter check out info</h4>
						</div>
						<div class="modal-body">
							<div class="panel panel-default">
								<div class="panel-body">
									<table class="table table-bordered">
										<font size=3 color="black" family="幼圆"></font>
										<tbody>
											<tr>
												<td>Card Number</td>
												<td><input type="text" name="account" cssClass="form-control" width="10" /></td>
											</tr>
											<tr>
												<td>Password</td>
												<td><input type="password" name="password" cssClass="form-control" width="10" /></td>
											</tr>
											<tr>
												<td colspan=2 align=right>
													<input type="submit" value="Confirm" class="btn btn-danger" onclick="submitcommit()"/>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</s:form> 
			<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script> <script
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

