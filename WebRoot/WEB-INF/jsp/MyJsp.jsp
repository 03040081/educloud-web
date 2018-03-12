<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

</head>

<body>
	This is my JSP page. WYHWYHWYHWWHWYHWYHWYHWYHWYHWYHWYH
	<br>

	<table border="1">
		<tr>
			<th>序号</th>
			<th>课程名称</th>
			<th>课程介绍</th>
			<th>学习人数</th>
			<th>价格</th>
			<th>图片</th>
		</tr>
		<c:forEach varStatus="s" items="${videoList}" var="v">
			<tr>
				<td>${s.count}</td>
				<td><a href="getVideoDetailed?videoId=${v.videoId}">${v.videoTile}</a></td>
				<td>${v.videoDiscript}</td>
				<td>${v.studySum}</td>
				<td>${v.prices}</td>
				<td><img src="${pageContext.request.contextPath}/${v.picUrl}"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
