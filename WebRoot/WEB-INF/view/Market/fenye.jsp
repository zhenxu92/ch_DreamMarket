<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
function GoingToSelectPage(url) {
	 var currentPage=$("#currentPage").val();
	  if(currentPage==""){
	      layer.alert('Page# cannot be null', {
				icon : 0,
				title : 'Warning'
			});	
		   return false;
	  }
	  else{
	     window.location.href='pageOnChange.action?currentPage='+currentPage+'';
	  }
}
</script>
<%
int begin=0,end=0;
int zong_page=0;// total# of pages
int in_page=0;// current page
if (request.getSession().getAttribute("totalPage")!=null) {
    zong_page=Integer.parseInt(request.getSession().getAttribute("totalPage").toString());
    in_page=Integer.parseInt(request.getSession().getAttribute("currentPage").toString());
}
if (zong_page<=10){
     begin=1;
     end=zong_page;
} else {
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
<!-- Page number -->
	    <tr>
	      <td>
            <div style="float:right;margin-top:6px;">
               <font size='4'>Page<font size='4' color='red'>${pageResult.page.currentPage}</font>
				/ <font size='4' color='red'>${pageResult.page.totalPage}</font>,
				<font size='4' color='red'>${pageResult.page.pageRecord}</font> results per page,
				<font size='4' color='red'>${pageResult.page.totalRecord }</font> total,</font>
				<s:if test="#session.pageResult.page.hasPrePage">
					<a href="pageOnChange.action?currentPage=1"><font size='4'>Home</font></a> | 
	                <a href="pageOnChange.action?currentPage=${pageResult.page.currentPage-1 }"><font size='4'>last</font></a>
				</s:if>
				<s:else>
		             <font size='4'>Home | last</font>
                </s:else>
                <!-- iteratively show pages -->
                <%
				for(int i=begin;i<=end;i++){
				     if(i==in_page){
			     %>
				        <font color='red' size='4'> [<%=i%>]</font><!--font turn red, if it's current page  -->
			     <% 
				     }
				     else{
			     %>
			           <a href='pageOnChange.action?currentPage=<%=i%>'><font size='4'>[<%=i%>]</font></a>   
			     <%	  
				     }
				}
			     %> 
				<s:if test="#session.pageResult.page.hasNextPage">
					<a href="pageOnChange.action?currentPage=${pageResult.page.currentPage+1 }"><font size='4'>next</font></a> | 
	                <a href="pageOnChange.action?currentPage=${pageResult.page.totalPage }"><font size='4'>end</font></a>
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
          </td>
	    </tr>
<!-- End of Page# -->   
