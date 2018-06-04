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
<script>
	function addGoodsInCart(){
		if(window.navigator.onLine==true){
			var gno = "<s:property value="#request.goods.gno"/>";
			var bid = <s:property value="#session.buser.bid"/>;
			var cip = returnCitySN['cip'];
			var action = "/ch_DreamMarket/market/addInCart.action?goods.gno="+gno+"&buser.bid="+bid+"&ip="+cip; 
			document.getElementById("goodsDetails").action=action;
			document.getElementById("goodsDetails").submit();
		}else{
			alert("You are not connected to internet.");
		}
	}
</script>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>

	<font size=4 color="red"> Details<font />
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<s:form method="post" id="goodsDetails">
							<table class="table table-hover">
								<tbody>
									<tr>
										<td rowspan="6"><img src='<s:property value="#request.goods.gpicture"/>' width=200
											height=300 /></td>
										<td><font size=3 color="black">Name：<s:property value="#request.goods.gname" /><font /></td>
									</tr>

									<tr>
										<td><font size=3 color="black">Price：<s:property value="#request.goods.goprice" /><font /></td>
									</tr>
									<tr>
										<td><font size=3 color="black">Discount：<s:property value="#request.goods.grprice" /><font /></td>
									</tr>
									<tr>
										<td><font size=3 color="black">Type：<s:property
													value="#request.goods.goodsType.typename" /><font /></td>
									</tr>
									<tr>
										<td><font size=3 color="black">Qty：<input type="number" name="shoppingnum" required="required"
													value='1' min="1" max='<s:property value="#request.goods.gstore"/>'>(In Storage：<s:property
													value="#request.goods.gstore"/>)<font /></td>
									</tr>
									<tr>
										<td>
											<input type="button" onclick="addGoodsInCart();" class="btn btn-danger" value="Add to Cart" />
											<input type="submit" value="Add to List"
												formaction="/ch_DreamMarket/market/addFocusGoodsAction.action?bid=<s:property value="#session.buser.bid"/>&gno=<s:property value="#request.goods.gno"/>"
												class="btn btn-warning" /> 
											<input type="submit" value="Buy now" class="btn btn-info"
												formaction="/ch_DreamMarket/market/orderconfirmAction.action?gno=<s:property value="#request.goods.gno"/>&amount=<s:property value="#request.goods.grprice"/>" />

										</td>
									</tr>
								</tbody>
							</table>
						</s:form>
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

