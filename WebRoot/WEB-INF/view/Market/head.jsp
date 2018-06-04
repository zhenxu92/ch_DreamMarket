<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script type="text/javascript" charset="gbk">
	function getGoodsInCart(){
		if(window.navigator.onLine==true) {
			var cip = returnCitySN['cip'];
			var bemail = "<s:property value="#session.buser.bemail" escape="false"/>";
			var href = "/ch_DreamMarket/market/Cart.action?bemail="+bemail+"&sessionid="+cip; 
			window.location.href=href;
		}else{
			alert("You are not connected to Internet.");
		}
	}
</script>
<!DOCTYPE HTML>
<!-- Top Begin -->

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Menu Begin -->
		<div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">
						<font>Welcome  <s:property value="#session.buser.bemail" /></font>
					</a></li>
				<li><a href="/ch_DreamMarket/market/registerPage.action">
						<font>Sign Up</font>
					</a></li>
				<li><a
						href='/ch_DreamMarket/market/usercenter.action?bemail=<s:property value="#session.buser.bemail"/>&bid=<s:property value="#session.buser.bid"/>'>
						<font>My Account</font>
					</a></li>
				<li><a href="javascript:getGoodsInCart();">
						<font>Cart</font>
					</a></li>
				<li><a href='<s:url action="manage.action" />'>
						<font>Admin</font>
					</a></li>
				<li><a href='<s:url action="logoutAction.action" />'>
						<font>Log out</font>
					</a></li>
			</ul>
		</div>
		<!-- Menu End -->
	</div>
</div>
<!-- Body Begin -->
<div class="row">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="col-md-12">
				<div class="col-md-5" align="right">
					<img src="/ch_DreamMarket/images/Logo.gif" width=228 height=183>
				</div>
				<div class="col-md-7" align="left">
					<s:form method="post" action="/market/vagueGetGoods.action">
						<table class="table table-hover">
							<thead>
								<br />
								<br />
								<br />
								<tr>
									<td><input class="form-control input-lg" id="gname" name="gname" type="text"
											placeholder="What do you want?"></td>
									<td><s:select cssClass="form-control input-lg" id="goodsType.typeid"
											name="goodsType.typeid" listKey="typeid" listValue="typename" headerKey=""
											headerValue="All" list="#session.allGoodsTypes" /></td>
									<td><input type="submit" class="btn btn-primary btn-lg btn btn-danger" value="Search"></td>
								</tr>
							</thead>
						</table>
					</s:form>
				</div>
			</div>

			<div class="col-md-12">
				<table class="table table-responsive">
					<thead>
					</thead>
					<tbody>
						<br />
						<br />
						<tr Bgcolor=#990033 height=10>
							<td height="50px"><a href="homepage.action" style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Home</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=1"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Food</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=2"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Appliance</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=3"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Books</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=4"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Video</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=5"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Women</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=6"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Baby</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=7"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Child</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=8"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Sports</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=9"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Clothes</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=10"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >MakeUp</font>
								</a></td>
							<td height="50px"><a
									href="/ch_DreamMarket/market/vagueGetGoods.action?goodsType.typeid=11"
									style="border:0;cursor:pointer;color:white;">
									<font size=5 color="white" >Others</font>
								</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
