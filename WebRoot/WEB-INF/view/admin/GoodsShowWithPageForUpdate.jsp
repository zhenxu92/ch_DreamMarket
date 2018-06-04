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
			function GoingToGoodsDetails(url) {
				window.open(url, "_top");
			}
		</script>
	</head>
  <body style="padding-top:10px;">
							<table class="table table-hover">
								<thead>
									<tr>
										<th align="center">商品ID</th>
										<th align="center">商品名称</th>
										<th align="center">商品类型</th>
										<th align="center">修改</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="#session.selectGoods" var="goods" status="st">
										<tr>
											<td align="left"><s:property value="#goods.gno" /></td>
											<td align="left"><s:property value="#goods.gname" /></td>
											<td align="left"><s:property value="#goods.goodsType.typename" /></td>
											<td align="left"><a href='/ch_DreamMarket/admin/goodsdetailsForUpdate.action?gno=<s:property value="#goods.gno"/>');" src='<s:property value="#goods.gpicture"/>'
													style="border:0;cursor:pointer;background-color:white;">修改</a></td>

										</tr>
									</s:iterator>
								</tbody>
							</table>
<%
int begin=0,end=0;
int zong_page=0;//总共多少页
int in_page=0;//当前第几页
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
							<div style="position: absolute;margin-left:300px;">
								<nav class="page">
									<ul class="pagination">
										<s:if test="#session.pageResult.page.hasPrePage">
											<li><a href="pageOnChangeForUpdate.action?currentPage=1">«</a></li>
							                <li><a href="pageOnChangeForUpdate.action?currentPage=${pageResult.page.currentPage-1 }"><</a></li>
										</s:if>
										<s:else>
								            <li class="disabled"><span aria-hidden="true">«</span></li>
								            <li class="disabled"><span aria-hidden="true"><</span></li>
						                </s:else>
						                <!-- 循环显示页码 -->
						                <%
										for(int i=begin;i<=end;i++){
										     if(i==in_page){
									     %>
										        <li class="active"><a href="#"><%=i%></a></li><!--当前页就不需要超链接，字体变红  -->
									     <% 
										     }
										     else{
									     %>
									           <li><a href='pageOnChangeForUpdate.action?currentPage=<%=i%>'><%=i%></font></a></li>   
									     <%	  
										     }
										}
									     %>
									     <s:if test="#session.pageResult.page.hasNextPage">
											<li><a href="pageOnChangeForUpdate.action?currentPage=${pageResult.page.currentPage+1 }">></a></li>
							                <li><a href="pageOnChangeForUpdate.action?currentPage=${pageResult.page.totalPage }">»</a><li>
										</s:if>
										
										<s:else>
											<li class="disabled">
												<span aria-hidden="true">></span>
											</li>
							              	<li class="disabled">
												<span aria-hidden="true">»</span>
											</li>
						                </s:else> 
									</ul>
								</nav>
							</div>
	<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script>
  </body>
</html>
