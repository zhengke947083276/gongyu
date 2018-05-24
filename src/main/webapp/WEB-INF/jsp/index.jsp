<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>首页</title>
      <link rel="stylesheet" type="text/css" href="/css/index.css"/>
      <!-- 新 Bootstrap 核心 CSS 文件 -->
      <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <!-- 可选的Bootstrap主题文件（一般不使用） -->
      <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
      <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
      <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
      <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
      <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
  <%@include file="adm/login.jsp"%>
  <%@include file="adm/update.jsp"%>
  <div id="all">
      <%@include file="zujian/top1.jsp"%>
      <jsp:include page="zujian/top2.jsp"/>
	  <div id="main">
          <%@include file="zujian/left.jsp"%>
          <div class="b_2" style="width: 1310px;height: 650px">
		  </div>
	  </div>
      <%@include file="zujian/foot.jsp"%>
  </div>
  </body>
</html>
