<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<table border="2">
		<form action="publishVideo" method="post"
			enctype="multipart/form-data">
			标题：<input type="text" name="videoTile"><br> 介绍：<input
				type="text" name="videoDiscript"><br> 价格：<input
				type="text" name="prices"><br> 图片：<input type="file"
				name="picUrl"><br> 级别：<input type="text" name="rankId"><br>
			专业：<input type="text" name="majorId"><br> 类别：<input
				type="text" name="categoryId"><br> 详细类别：<input
				type="text" name="cgdetailedId"><br> 第？章<input
				type="text" name="chapterName"><br> 第？章<input
				type="text" name="chapterName"><br> 第？章<input
				type="text" name="chapterName"><br> 第？章<input
				type="text" name="chapterName"><br> <input
				type="submit" value="提交">
		</form>
	</table>
	<hr size="2px" color="red">
	<form action="publishChapter" method="post"
		enctype="multipart/form-data">
					
				videoId <input type="text" name="videoId"><br/>
				添加课程章数 <input type="text" name="chapterName">
		<table border="2" id="chapter">
			<tr>
				<th>章节描叙</th>
				<th>课程视频</th>
				<th>操作</th>
			</tr>
			<tr>
				<td><input type="text" name="detailedTile"></td>
				<td><input type="file" name="videoUrl"></td>
				<td><button type="button" id="reC" value="1" onclick="addRows(this)">增加行</button></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function addRows(){
	//alert("有响应");
		document.getElementById("reC").value = parseInt(document.getElementById("reC").value) + 1;
		var chapter = document.getElementById("chapter");
		var i=parseInt(chapter.rows.length);
		
		var newTr=chapter.insertRow();
		var newTd0=newTr.insertCell();
		var newTd1=newTr.insertCell();
		var newTd2=newTr.insertCell();
		newTd0.innerHTML='<input type="text" name="detailedTile">';
		newTd1.innerHTML='<input type="file" name="videoUrl">';
		newTd2.innerHTML='';
		return true;
	}
</script>
</html>
