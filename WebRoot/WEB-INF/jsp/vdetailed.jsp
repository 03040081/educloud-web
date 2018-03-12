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
    
    <title>My JSP 'vdetailed.jsp' starting page</title>
   

  </head>
  
  <body>
    <table border="2px">
    	<tr>
			<th>课程名称</th>
			<th>课程介绍</th>
			<th>学习人数</th>
			<th>价格</th>
			<th>图片</th>
		</tr>
		
			<c:forEach items="${videoInfo.listChapter}" var="ch">
			<tr>
			<td><input type="text" value="${ch.chapterId}">${ch.chapterName} </td>
				<td>
				<c:forEach varStatus="s" items="${ch.listChapterDetailed}" var="de">
					
					<button onclick="getVideo(this)" value="${pageContext.request.contextPath}/${de.videoUrl}">${de.detailedTile}</button>
				</c:forEach>
				</td>
			</tr>
			</c:forEach>
		
    </table>
    <section id="player">
    <video id="media" controls="controls">
    	<source id="svideo" src="demo.mp4" type="video/mp4">
    </video>
    </section>
    <button id="play" onclick="vidplay()">播放</button>
  </body>
  <script type="text/javascript">
  		function getVideo(obj){
  			var svideo = document.getElementById("svideo");
  			var media =document.getElementById("media");
  			var fileURL = obj.value;
  			alert(fileURL);
  			svideo.src = fileURL;
  			media.load();
  			media.play();
  			
  		}
  		function vidplay(){
  			var video = document.getElementById("media");
  			var button = document.getElementById("play");
  			if(video.paused){
  				video.play();
  			}
  		}
  		
  		/* var btn = document.getElementsByTagName("button");
		 document = function bbb(){    //冒泡处理
            
            var fileURL = event.target.value;
            alert(fileURL);
            video.src = fileURL;
            video.load();
            video.play();
        } */
  </script>
</html>
