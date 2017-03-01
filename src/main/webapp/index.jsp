<%@page import="com.ailk.eaap.o2p.common.cache.CacheKey"%>
<%@page import="org.springframework.util.StringUtils"%>
<%@page import="com.ailk.eaap.o2p.common.cache.CacheFactory"%>
<%@page import="com.asiainfo.integration.o2p.session.web.http.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@page import=" java.util.concurrent.TimeoutException" %>
<%@page import=" com.ailk.eaap.op2.bo.TaskCacheFlag" %>
<%
String tenantIdStr = CookieUtil.getTenantId(request);
Integer tenantId = null;
if(tenantIdStr != null && StringUtils.hasText(tenantIdStr)) {
	tenantId = Integer.valueOf(tenantIdStr.toString());
}
System.out.println("tenant_id="+tenantId);
if(tenantId == null) {
	System.out.println("use default tenant!");
	return;
}
ApplicationContext context = WebApplicationContextUtils. getWebApplicationContext(application);
CacheFactory cacheFactory = (CacheFactory)context.getBean("cacheFactory");
Map<String,String> taskMap = (Map<String,String>) cacheFactory.getCacheClient().get(tenantId+"TASK_MAP_FLAG");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="resources/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/jquery.js" type="text/javascript"></script>
<script type="text/javascript">	
	function deleteAction(key){
	$.ajax({
		type: "POST",
		async:true,
	    url: "${pageContext.request.contextPath}/DeleteKeyServlet",
	    dataType:'text',
	    data:{key_name:key},
		success:function(msg){
			window.location.href='index.jsp';
          }
     });
}

	function deleteAllAction(){
	$.ajax({
		type: "POST",
		async:true,
	    url: "${pageContext.request.contextPath}/DeleteAllKeyServlet",
	    dataType:'text',
		success:function(msg){
			window.location.href='index.jsp';
          }
     });
}
	</script>
  </head>
  
  <body>
  <form>
     <table border="1" >
                 <tr>
                  <td> key </td>
                  <td> readyDate</td>
                  <td> receiveDate</td>
                  <td> modifyDate</td>
                  <td> status</td>
                  <td> currentRunningNum</td>
                  <td> runNumDetail</td>
                  <td> op </td>
                 </tr>
                   <%
                   if(taskMap != null) { 
	                   for(String key : taskMap.keySet()){
	                	   TaskCacheFlag taskCacheFlag = (TaskCacheFlag)cacheFactory.getCacheClient().get(key);
	                	   if(taskCacheFlag!=null){
	               	   %>	
	                	   <tr>
	                        <td><%=taskCacheFlag.getTaskCode() %></td>
	                        <td><%=taskCacheFlag.getReadyDate()==null?"":taskCacheFlag.getReadyDate()%></td>
	                        <td><%=taskCacheFlag.getReceiveDate()==null?"":taskCacheFlag.getReceiveDate() %></td>
	                        <td><%=taskCacheFlag.getModifyDate()==null?"":taskCacheFlag.getModifyDate() %></td>
	                      	<%if(taskCacheFlag.getTaskStatus() == null) {%>
	                      		<td></td>
	                      	<%} else {%>
		                      	<%if(taskCacheFlag.getTaskStatus()==3){ %>
									<td>COMPLETED</td>
								<%}else if(taskCacheFlag.getTaskStatus()==2){ %>
									<td>EXCEPTION</td>
								<%}else if(taskCacheFlag.getTaskStatus()==1){ %>
									<td>RUNNING</td>
								<%}else if(taskCacheFlag.getTaskStatus()==0){ %>
									<td>READY</td>
								<%}%>
							<%}%>
							<td><%=taskCacheFlag.getTaskRunningCount()==null?"":taskCacheFlag.getTaskRunningCount()%></td>
							<td><% 
								if(taskCacheFlag.getRunCountDetail() != null && taskCacheFlag.getRunCountDetail().size() > 0) {
								for(String numKey:taskCacheFlag.getRunCountDetail().keySet()) {
							%>
									<%=taskCacheFlag.getRunCountDetail().get(numKey)%>
							<%} }%>
							</td>
	                       <td><button type="button" class="btn btn-warning btn-xs" onclick="javascript:deleteAction('<%=taskCacheFlag.getTaskCode()  %>');">reset task</button></td>
	                	   </tr>
	               		<%  
	                	   }
                   		}
                   }
                   %>
                </tbody>
                </table>
                <button type="button" class="btn btn-warning btn-xs" onclick="javascript:deleteAllAction();">reset all task </button>
          </form>
  </body>
</html>
