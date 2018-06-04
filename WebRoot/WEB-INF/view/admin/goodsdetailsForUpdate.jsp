<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML">
<html>
  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>DreamMarket商城首页</title>
	<meta name="renderer" content="webkit">
	<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/ch_DreamMarket/css/marketstyle.css" />
	<script>
			function updateGoods() {
				var formObj = document.getElementById("UG_1");
				var oBtn = window.parent.document.getElementById("btn_update");
				 oBtn.click();
				formObj.submit();
			}
		</script>
	</head>
  
  <body style="padding-top:0px;">
  		<s:form action="/admin/updateGoodsAction.action" method="post" id="UG_1">
  									<table class="table table-border">
										<thead>
											<tr>
												<td align="center" valign="middle" colspan="2">商品详情</td>
												<td align="center" valign="middle" colspan="2">商品图片</td>
											</tr>
										</thead>
										<tbody>
											<tr align="center">
												<td></td>
												<td></td>
												<td colspan="3" rowspan="7"><img src='<s:property value="#request.goods.gpicture"/>'
													width=260 height=360 /></td>
											</tr>
											<tr>
												<td style="font-size:20px; font-family:幼圆;">商品编号*</td>
												<td align="left"><input type="text" width="20" name="gno" value=<s:property value="#request.goods.gno"/> readonly /></td>

											</tr>
											<tr>
												<td style="font-size:20px; font-family:幼圆;">商品名称*</td>
												<td align="left"><input type="text" width="20" name="gname" value=<s:property value="#request.goods.gname"/>></td>
											</tr>
											<tr>
												<td style="font-size:20px; font-family:幼圆;">商品原价*</td>
												<td align="left"><input type="text" width="20" name="goprice"
														value=<s:property value="#request.goods.goprice"/>></td>
											</tr>
											<tr>
												<td style="font-size:20px; font-family:幼圆;">商品折扣*</td>
												<td align="left"><input type="text" width="20" name="grprice"
														value=<s:property value="#request.goods.grprice"/>></td>
											</tr>
											<tr>
												<td style="font-size:20px; font-family:幼圆;">商品数量*</td>
												<td align="left"><input type="text" width="20" name="gstore"
														value=<s:property value="#request.goods.gstore"/>></td>
											</tr>

											<tr>
												<td style="font-size:20px; font-family:幼圆;">商品类型*</td>
												<td align="left">
													<s:select cssClass="form-control" id="goodsType.typeid"
															name="goodsType.typeid" listKey="typeid" listValue="typename" headerKey=""
															headerValue="全部" list="#session.allGoodsTypes" value="#request.goods.goodsType.typeid"/>
												</td>

											</tr>
											<tr align="right">
												<td colspan="4">
													  <input style="margin-right:30px;width:85px;" class="btn btn-primary btn-sm" type="button" value="修改" onclick="updateGoods()"/>
													  <input style="margin-right:30px;" class="btn btn-primary btn-sm" type="button" name="Submit" value="返回上一页" onclick="javascript:window.history.back(-1);">
												</td>
											</tr>
										</tbody>
									</table>
								</s:form>
  	<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script>
  </body>
</html>
