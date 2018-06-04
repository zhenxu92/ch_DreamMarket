<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Shopping Cart</title>
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/usercenterstyle.css" />

<link rel="stylesheet" href="/ch_DreamMarket/css/datetimepicker/bootstrap-datetimepicker.min.css"
	media="screen" />

<s:iterator value="#session.selectCartGoods" var="selectCartGoods" status="st">
	<script type="text/javascript">
				function loadXMLDoc<s:property value="#st.index"/>(){
					var shoppingnum = document.getElementById("shoppingnum<s:property value="#st.index"/>").value;
					var cid = <s:property value="#selectCartGoods.cid"/>;
					var bid=  <s:property value="#session.buser.bid"/>;
					var xmlhttp;
					if (window.XMLHttpRequest){
						// code for IE7+, Firefox, Chrome, Opera, Safari
					  	xmlhttp=new XMLHttpRequest();
					  }else{
						  // code for IE6, IE5
					  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					  }
					xmlhttp.onreadystatechange=function(){
					  if (xmlhttp.readyState==4 && xmlhttp.status==200){
					    	var c = <s:property value="#selectCartGoods.shoppingnum"/>;
						  	document.getElementById("mymessage").value =xmlhttp.responseText;
					    }
					  }
					xmlhttp.open("GET","updateShoppingnum.action?shoppingnum="+shoppingnum+"&cid="+cid+"&buser.bid="+bid,true);
					xmlhttp.send();
				}
		</script>
</s:iterator>
	<script>
		function deleteGoodsInCart(cid){
					if(window.navigator.onLine==true) {
						var cip = returnCitySN['cip'];
						var href = "/ch_DreamMarket/market/deleteGoddsInCart.action?cid="+cid+"&ip="+cip; 
						window.location.href=href;
					}else{
						alert("You are not connected to internet.");
					}
				}
	</script>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<s:form action="/market/selectChoisedGoods.action">
						<table class="table table-hover">
							<thead>
								<tr>
									<p class="bg-danger">
										<font size=6 color="red"> My cart </font>
									</p>
								</tr>
								<tr>
									<td>
										<p>
											<font size=4 color="blue">Picture<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Name<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Qty<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Unit Price<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Delete<font />
										</p>
									</td>
									<td>
										<p>
											<font size=4 color="blue">Select<font />
										</p>
									</td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.selectCartGoods" var="selectCartGoods" status="st">
									<tr>
										<td><img src='<s:property value="#selectCartGoods.goods.gpicture"/>' width=60
											height=70 /></td>
										<td><br /> <font size=3 color="black"> <s:property
													value="#selectCartGoods.goods.gname" /> <font /></td>
										<td><br /> <font size=3 color="black"> <input type="number"
													id='shoppingnum<s:property value="#st.index"/>' onMouseOut=loadXMLDoc${st.index}();
													name="shoppingnumList" value='<s:property value="#selectCartGoods.shoppingnum"/>'
													min="0" max='<s:property value="#selectCartGoods.goods.gstore"/>' /> <font /></td>
										<td><br /> <font size=3 color="black"> <s:property
													value="#selectCartGoods.goods.goprice" />￥ <font /></td>
										<td><br /> <a href="javascript:deleteGoodsInCart(<s:property value="#selectCartGoods.cid"/>);">Delete</a></td>
										<td align="left"><br /> <input type="checkbox" name="cidList"
												value='<s:property value="#selectCartGoods.cid"/>'></td>
									</tr>
								</s:iterator>
								<tr>
									<td colspan="6" align="right" style="padding-right:115px"><s:submit value="Check out"
											cssClass="btn btn-danger" /></td>
								</tr>
							</tbody>
						</table>
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/datetimepicker/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
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

