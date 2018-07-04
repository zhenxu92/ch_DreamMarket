<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>

<title>后台管理</title>

<!-- Meta-Tags -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- //Meta-Tags -->

<!-- Style -->
<link rel="stylesheet" href="/ch_DreamMarket/css/style4.css" type="text/css" media="all">
<link href="/ch_DreamMarket/css/bootstrap.min34.css" rel="stylesheet">
<script type="text/javascript">
		function submitcommit(){
			alert('Sure to add this？');
			var formObj = document.getElementById("goodsAdminForm");
			formObj.submit();
		}
		function confirmdelete(){
			alert('Sure to delete this？');
			var formObj = document.getElementById("DeleteNoticeAdminForm2");
			formObj.submit();
		}
		function submitcommit2(){
			alert('Sure to add this？');
			var formObj = document.getElementById("NoticeAdminForm2");
			formObj.submit();
		}
		function deletegoodssubmitcommit(){
			alert('Sure to delete selected goods？');
			var formObj = document.getElementById("DeleteGoodsAdminForm2");
			formObj.submit();
		}
		function deletebusersubmitcommit(){
			alert('Sure to delete selected user？');
			var formObj = document.getElementById("DeleteBuserAdminForm2");
			formObj.submit();
		}
		
		function deleteordersubmitcommit(){
			alert('Sure to delete selected order？');
			var formObj = document.getElementById("DeleteOrderAdminForm2");
			formObj.submit();
		}
	</script>
<link href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">

</head>
<!-- //Head -->

<!-- Body -->
<body>
	<br />
	<br />
	<br />
	<font color=white size=8>后台管理系统已登录</font>
	<br />
	<br />
	<br />
	<div class="row">
		<div class="col-md-1"></div>
		<div class="container col-md-10">
			<div class="login col-md-6">
				<font color=white size=5>商品管理</font> <br />
				<br />
				<br />
				<div class="send-button w3layouts agileits">
					<input type="button" value="添加商品" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#addGoodsModal">
					<br />
				</div>
				<div class="send-button w3layouts agileits">
					<input type="button" value="查询商品" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#selectGoodsModal">
				</div>
				<div class="send-button w3layouts agileits">
					<input type="button" value="修改商品" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#updateGoodsModal">
				</div>
				<div class="send-button w3layouts agileits">
					<input type="button" value="删除商品" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#deleteGoodsModal">
				</div>
				<div class="clear"></div>
			</div>

			<div class="register w3layouts agileits col-md-6">

				<font color=white size=5>系统管理</font> <br />
				<br />
				<br />
				<div class="send-button w3layouts agileits">
					<input type="button" value="订单管理" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#orderManagerModal">
				</div>
				<div class="send-button w3layouts agileits">
					<input type="button" value="用户管理" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#userManagerModal">
				</div>
				<div class="send-button w3layouts agileits">
					<input type="button" value="公告管理" class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#noticeManagerModal">
				</div>
				<div class="send-button w3layouts agileits">
					<input type="submit" value="退出系统"
						onclick="window.location.href='/ch_DreamMarket/market/indexPage.action'">
				</div>

			</div>
			<div class="clear"></div>
		</div>

		<div class="col-md-1"></div>
	</div>
	<div class="footer w3layouts agileits">
		<p>已登录中国好商城管理员信息，版权归中国好商户所有!</p>
	</div>


	<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script>


	<!--弹出添加商品DIV-->
	<s:form action="/admin/addGoodsAction.action" id="goodsAdminForm" theme="simple"
		enctype="multipart/form-data">
		<div class="modal fade bs-example-modal-lg" id="addGoodsModal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">商品添加</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<td colspan="4"><span style="color: red;"><s:actionerror /></span></td>
										</tr>
										<tr>
											<td align="center" valign="middle" colspan="2">添加商品</td>
											<td align="center" valign="middle" colspan="2">商品图片</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td></td>
											<td></td>
											<td colspan="3" rowspan="8" align="center">
												<div id="preview">
													<img id="imghead" width=200 height=300 border=0
														src='<%=request.getContextPath()%>/images/defaul.jpg'>
												</div>
											</td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">商品编号*</td>
											<td align="left"><s:textfield id="gno" name="gno" required="required" /></td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">商品名称*</td>
											<td align="left"><s:textfield id="gname" name="gname" required="required" /></td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">商品原价*</td>
											<td align="left"><s:textfield id="goprice" name="goprice" required="required" /></td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">折扣价格*</td>
											<td align="left"><s:textfield id="grprice" name="grprice" required="required" /></td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">商品数量*</td>
											<td align="left"><s:textfield id="gstore" name="gstore" required="required" /></td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">商品图片*</td>
											<td align="left"><s:file id="goodsImage" name="goodsImage"
													onchange="previewImage(this)" required="required" /></td>
										</tr>
										<tr>
											<td style="font-size:20px; font-family:幼圆;">商品类型*</td>
											<td align="left"><s:select cssClass="form-control" id="goodsType.typeid"
													name="goodsType.typeid" listKey="typeid" listValue="typename" headerKey=""
													headerValue="全部" list="#session.allGoodsTypes" /></td>
										</tr>
									</tbody>
								</table>

							</div>
						</div>

					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-md-4" align="left">
								<div class="input-group">
									<span class="input-group-addon">商品编号</span>
									<input type="text" class="form-control" readonly>
								</div>
							</div>
							<div class="col-md-4" align="left">
								<div class="input-group">
									<span class="input-group-addon">期望卖出数量</span>
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="col-md-4" align="right">
								<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal"
									onclick="submitcommit();">确认</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</s:form>
	<!--弹出查询商品-->
	<div class="modal fade bs-example-modal-lg" id="selectGoodsModal" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">商品查询</h4>
				</div>
				<div class="modal-body">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-4" align="left">
									<div class="input-group">
										<span class="input-group-addon">商品名：</span>
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-4" align="left">
									<div class="input-group">
										<span class="input-group-addon">商品类型：</span>
										<s:select cssClass="form-control" id="goodsType.typeid" name="goodsType.typeid"
											listKey="typeid" listValue="typename" headerKey="" headerValue="全部"
											list="#session.allGoodsTypes" />
									</div>
								</div>
								<div class="col-md-4" align="right">
									<button type="submit" class="btn btn-primary btn-sm">搜索</button>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<iframe width="100%" height="460px" frameborder="no" scrolling="no" src="pageOnChangeForSelect.action"></iframe>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="row">
						<div class="col-md-4" align="left">
							<div class="input-group">
								<span class="input-group-addon">商品コード</span>
								<input type="text" class="form-control" readonly>
							</div>
						</div>
						<div class="col-md-4" align="left">
							<div class="input-group">
								<span class="input-group-addon">売上数量</span>
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-4" align="right">
							<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal">確認</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- 弹出修改商品 -->
	<div class="modal fade bs-example-modal-lg" id="updateGoodsModal" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">商品修改</h4>
				</div>
				<div class="modal-body">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-4" align="left">
									<div class="input-group">
										<span class="input-group-addon">商品名：</span>
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-4" align="left">
									<div class="input-group">
										<span class="input-group-addon">商品类型：</span>
										<s:select cssClass="form-control" id="goodsType.typeid" name="goodsType.typeid"
											listKey="typeid" listValue="typename" headerKey="" headerValue="全部"
											list="#session.allGoodsTypes" />
									</div>
								</div>
								<div class="col-md-4" align="right">
									<button type="submit" class="btn btn-primary btn-sm">搜索</button>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<iframe width="100%" height="460px" frameborder="no" scrolling="no" src="pageOnChangeForUpdate.action"></iframe>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="row">
						<div class="col-md-4" align="left">
							<div class="input-group">
								<span class="input-group-addon">商品コード</span>
								<input type="text" class="form-control" readonly>
							</div>
						</div>
						<div class="col-md-4" align="left">
							<div class="input-group">
								<span class="input-group-addon">売上数量</span>
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-4" align="right">
							<button type="button" id="btn_update" class="btn btn-primary btn-sm" data-dismiss="modal">確認</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 弹出删除商品信息 -->
	<s:form action="/admin/deleteGoodsAction.action" id="DeleteGoodsAdminForm2">

		<div class="modal fade bs-example-modal-lg" id="deleteGoodsModal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel">

			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">商品删除</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th align="center">选择商品</th>
											<th align="center">商品编号</th>
											<th align="center">商品名称</th>
											<th align="center">删除商品</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.selectGoods" var="goods" status="st">
											<tr>
												<td align="left"><s:property value="#goods.gno" /></td>
												<td align="left"><s:property value="#goods.gname" /></td>
												<td align="left"><s:property value="#goods.goodsType.typename" /></td>
												<td align="left"><input type="checkbox" name="gnoList"
														value="<s:property value="#goods.gno"/>"></td>


											</tr>
										</s:iterator>
									</tbody>
								</table>
								<nav class="page">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous">
												<span aria-hidden="true">«</span>
											</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" aria-label="Next">
												<span aria-hidden="true">»</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-md-4" align="left">
								<div class="input-group">
									<span class="input-group-addon">选中商品数量</span>
									<input type="text" class="form-control" value="6" />
								</div>
							</div>
							<div class="col-md-4" align="right">
								<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal"
									onclick="deletegoodssubmitcommit();">确认删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<!-- 弹出订单管理 -->
	<s:form action="/admin/deleteOrderAction.action" id="DeleteOrderAdminForm2">

		<div class="modal fade bs-example-modal-lg" id="orderManagerModal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel">

			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">订单管理</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr algin="center">
											<th align="center">订单编号</th>
											<th align="center">用户E-mail</th>
											<th align="center">订单金额</th>
											<th align="center">订单状态</th>
											<th align="center">订单日期</th>
											<th align="center">操作</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.allOrder" var="order" status="st">
											<tr>
												<td align="left"><s:property value="#order.ordersn" /></td>
												<td align="left"><s:property value="#order.buser.bemail" /></td>
												<td align="left"><s:property value="#order.amount" /></td>
												<td align="left"><s:property value="#order.status" /></td>
												<td align="left"><s:property value="#order.orderdate" /></td>

												<td align="left"><input type="checkbox" name="ordersnList"
														value="<s:property value="#order.ordersn"/>"></td>

											</tr>
										</s:iterator>
									</tbody>
								</table>
								<nav class="page">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous">
												<span aria-hidden="true">«</span>
											</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" aria-label="Next">
												<span aria-hidden="true">»</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-md-4" align="left">
								<div class="input-group">
									<span class="input-group-addon">选中商品数量</span>
									<input type="text" class="form-control" value="6" />
								</div>
							</div>
							<div class="col-md-4" align="right">
								<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal"
									onclick="deleteordersubmitcommit()">确认删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<!-- 弹出用户管理-->
	<s:form action="/admin/deleteBusersAction.action" id="DeleteBuserAdminForm2">
		<div class="modal fade bs-example-modal-lg" id="userManagerModal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel">

			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">用户管理</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr algin="center">
											<th align="center">用户ID</th>
											<th align="center">用户E-mail</th>
											<th align="center">用户密码</th>
											<th align="center">删除</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.allBuser" var="busers" status="st">
											<tr>
												<td align="left"><s:property value="#busers.bid" /></td>
												<td align="left"><s:property value="#busers.bemail" /></td>
												<td align="left"><input type="password" value=<s:property value="#busers.bpwd"/>
														readonly /></td>
												<td align="left"><input type="checkbox" name="bidList"
														value="<s:property value="#busers.bid"/>"></td>
											</tr>

										</s:iterator>
									</tbody>
								</table>
								<nav class="page">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous">
												<span aria-hidden="true">«</span>
											</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" aria-label="Next">
												<span aria-hidden="true">»</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-md-4" align="right">
								<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal"
									onclick="deletebusersubmitcommit();">确认删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<!-- 弹出公告管理-->
	<s:form action="/admin/deleteNotice.action" id="DeleteNoticeAdminForm2">
		<div class="modal fade bs-example-modal-lg" id="noticeManagerModal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel">

			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">公告管理</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr algin="center">
											<th align="center">公告ID</th>
											<th align="center">公告标题</th>
											<th align="center">公告时间</th>
											<th align="center">查看详情</th>
											<th align="center">删除公告</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.allNotice" var="notice" status="st">
											<tr>
												<td align="left"><s:property value="#notice.nid" /></td>
												<td align="left"><s:property value="#notice.ntitle" /></td>
												<td align="left"><s:property value="#notice.ntime" /></td>
												<td align="left"><a data-toggle="modal"
														href='#noticeDetailsModal<s:property value="#st.index"/>'
														style="border:0;cursor:pointer;background-color:white;">详情</a> &nbsp;</td>
												<td align="left"><input type="checkbox" name="nidList"
														value="<s:property value="#notice.nid"/>"></td>
											</tr>
										</s:iterator>
										<tr>
											<td colspan="5">
												<p class="bg-danger">
													<a data-toggle="modal" href="#addnoticeManagerModal"
														style="border:0;cursor:pointer;background-color:white;">添加公告</a>
												</p>
											</td>
										</tr>
									</tbody>
								</table>
								<nav class="page">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous">
												<span aria-hidden="true">«</span>
											</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" aria-label="Next">
												<span aria-hidden="true">»</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-md-4" align="left">
								<div class="input-group">
									<span class="input-group-addon">选中商品数量</span>
									<input type="text" class="form-control" value="6" />
								</div>
							</div>
							<div class="col-md-4" align="right">
								<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal"
									onclick="confirmdelete()">确认删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<!-- 弹出公告添加-->
	<s:form action="/admin/addNotice.action" id="NoticeAdminForm2">
		<div class="modal fade bs-example-modal-lg" id="addnoticeManagerModal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">添加公告</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th align="center" colspan="2">公告添加</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td align="left">公告标题</td>
											<td align="left"><input type="text" id="ntitle" name="ntitle" /></td>

										</tr>
										<tr>
											<td align="left">公告内容</td>
											<td align="left"><s:textarea id="ncontent" name="ncontent" rows="10" cols="30" /></td>
										</tr>
										<tr>
											<td align="left"><input type="submit" value="提交" onclick="submitcommit2();" /></td>
											<td align="left"><input type="reset" value="重置" /></td>
										</tr>
									</tbody>
								</table>
								<nav class="page">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous">
												<span aria-hidden="true">«</span>
											</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" aria-label="Next">
												<span aria-hidden="true">»</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<!-- 弹出公告详情-->
	<s:iterator value="#session.allNotice" var="notice" status="st">
		<div class="modal fade bs-example-modal-lg" id='noticeDetailsModal<s:property value="#st.index"/>'
			tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">公告详情</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table table-hover">
									<tbody>
										<tr>
											<td align="center" colspan="4">
												<p align="center">
													<font sice=3 color=red;><s:property value="#notice.ntitle" /></font>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="4">
												<p align="left">

													<font size=6 color=red;><s:property value="#notice.ncontent" /></font>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="4">r
												<p align="right">
													<font size=3 color=red;><s:property value="#notice.ntime" /></font>
											</td>

										</tr>
									</tbody>
								</table>
								<nav class="page">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous">
												<span aria-hidden="true">«</span>
											</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" aria-label="Next">
												<span aria-hidden="true">»</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-md-4" align="left">
								<div class="input-group">
									<span class="input-group-addon">选中商品数量</span>
									<input type="text" class="form-control" value="6" />
								</div>
							</div>
							<div class="col-md-4" align="right">
								<button type="submit" class="btn btn-primary btn-sm" data-dismiss="modal"
									onclick="confirmdelete();">确认删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:iterator>
	<script type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/image.js"></script>
</body>

<!-- //Body -->

</html>
