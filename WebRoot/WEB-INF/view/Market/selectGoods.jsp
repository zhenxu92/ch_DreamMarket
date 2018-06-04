<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Search</title>
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/marketstyle.css" />

<link rel="stylesheet" href="/ch_DreamMarket/css/datetimepicker/bootstrap-datetimepicker.min.css"
	media="screen" />

</head>
<script>
	function GoingToSelectPage(url) {
		 var currentPage=$("#currentPage").val();
		 var gname=document.getElementById("GN_1").value;
		 var typeid=document.getElementById("GTY_1").value;
		  if(currentPage==""){
		      layer.alert('Page# cannot be null', {
					icon : 0,
					title : '警告'
				});	
			   return false;
		  }
		  else{
		     window.location.href='vagueGetGoods.action?currentPage='+currentPage+'&goods.gname='+gname+'&goodsType.typeid='+typeid+'';
		  }
	}
	function GoingToGoodsDetails(url) {
		window.location.href=url;
	}
</script>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<s:if test="%{#session.target}">
	<div class="row">
		<div class="col-md-12">
			<p class="bg-success">
				<font size=6 color="red">>>Your results:</font><font />
			</p>
			<div class="panel panel-default">
				<div class="panel-body">
					<s:iterator value="#session.vagueselectGoods" var="goods" status="st">
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
<%
	int begin=0,end=0;
	int zong_page=0;
	int in_page=0;
	if(request.getSession().getAttribute("totalPage")!=null){
	    zong_page=Integer.parseInt(request.getSession().getAttribute("totalPage").toString());
	    in_page=Integer.parseInt(request.getSession().getAttribute("currentPage").toString());
	}
	if(zong_page<=10){
	     begin=1;
	     end=zong_page;
	}
	else{
	    begin=in_page-5;
	    end=in_page+4;
	    if(begin<1){
	        begin=1;
	        end=10;
	    }
	    if(end>zong_page){
	         end=zong_page;
	         begin=zong_page-9;
	    }
	}
%> 
			 <div style="float:right;margin-top:6px;">
               <font size='4'>Page<font size='4' color='red'>${pageResult.page.currentPage}</font>
				/ <font size='4' color='red'>${pageResult.page.totalPage}</font>,
				<font size='4' color='red'>${pageResult.page.pageRecord}</font>results per page,
				<font size='4' color='red'>${pageResult.page.totalRecord }</font> total, </font>
				<s:if test="#session.pageResult.page.hasPrePage">
					<a href="vagueGetGoods.action?currentPage=1&goods.gname=${gname}&goodsType.typeid=${typeid}"><font size='4'>Home</font></a> | 
	                <a href="vagueGetGoods.action?currentPage=${pageResult.page.currentPage-1 }&goods.gname=${gname}&goodsType.typeid=${typeid}"><font size='4'>last</font></a>
				</s:if>
				<s:else>
		             <font size='4'>Home | last</font>
                </s:else>
                <%
				for(int i=begin;i<=end;i++){
				     if(i==in_page){
			     %>
				        <font color='red' size='4'> [<%=i%>]</font>
			     <% 
				     }
				     else{
			     %>
			           <a href='vagueGetGoods.action?currentPage=<%=i%>&goods.gname=${gname}&goodsType.typeid=${typeid}'><font size='4'>[<%=i%>]</font></a>   
			     <%	  
				     }
				}
			     %> 
				<s:if test="#session.pageResult.page.hasNextPage">
					<a href="vagueGetGoods.action?currentPage=${pageResult.page.currentPage+1}&goods.gname=${gname}&goodsType.typeid=${typeid}"><font size='4'>next</font></a> | 
	                <a href="vagueGetGoods.action?currentPage=${pageResult.page.totalPage }&goods.gname=${gname}&goodsType.typeid=${typeid}"><font size='4'>end</font></a>
				</s:if>
				
				<s:else>
	              <font size='4'>next | end</font>
                </s:else>
                &nbsp;<font size='4'>Page</font>
				<select style="height:20px;width:50px;font-size:12px;" name="currentPage" id="currentPage">
				    <%for(int i=1;i<=zong_page;i++){
				     %>
				        <option value="<%=i%>"><%=i%></option>
				     <%
				      }
				     %>
				</select>
			    <button class="btn btn-primary btn-sm" style="height:28px;" onclick="GoingToSelectPage()">Go</button>
		  </div>  
		</div>
	</div>
	<br><br>
	</s:if>
	<s:else>
	<br><br><br>
		<div style="margin-tpo:60px;text-align:center">
			<h1 style="font-family:加粗;"><font color="red">No results ~(>_<)~ </font></h1>
		</div>
	</s:else>
	<input type="hidden" id="GN_1" value='<s:property value="#session.gname"/>'/>
	<input type="hidden" id="GTY_1" value='<s:property value="#session.typeid"/>'/>
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


