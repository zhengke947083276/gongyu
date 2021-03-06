<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>首页</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/index.css"/>
	  <script type="text/javascript" src="${contextPath}/js/jquery-3.3.1.js"></script>
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

  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/adm/login.jsp"/>--%>
  <%@include file="/WEB-INF/jsp/adm/login.jsp"%>
  <%@include file="/WEB-INF/jsp/adm/update.jsp"%>
  <div id="all">
	  <div style="position: absolute;margin-top: 230px;margin-left: 300px;">
		  批量添加
		  <form role="form" action="${contextPath}/dorm/importDorm" method="POST" enctype="multipart/form-data">
			  <div>
				  <label for="file">上传文件</label>
				  <input type="file" id="file" name="file">
			  </div>
			  <input type="submit" value='上传' class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;" />
		  </form>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/top1.jsp"%>
	  <%@include file="/WEB-INF/jsp/zujian/top2.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/top1.jsp"/>--%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/top2.jsp"/>--%>
	  <div id="main">
		  <%@include file="/WEB-INF/jsp/zujian/left.jsp"%>
		  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/left.jsp"/>--%>
		  <div class="b_2" style="width: 1310px;height: 650px">
			  <h2 class="text-center">添加宿舍</h2>
			  <div style="padding: 0px 540px 0px;text-align: center">
				  <form action="${contextPath}/dorm/insert" method="post"  class="bs-example bs-example-form" role="form" >
					  <div class="input-group">
						  <input type="number" class="form-control" placeholder="请输入宿舍楼号" name="d">
						  <span class="input-group-addon">栋</span>
					  </div>
					  <br>
					  <div class="input-group">
						  <input type="number" class="form-control" placeholder="请输入宿舍层数" name="c">
						  <span class="input-group-addon">层</span>
					  </div>
					  <br>
					  <div class="input-group">
						  <input type="number" class="form-control" placeholder="请输入宿舍号" name="h">
						  <span class="input-group-addon">号</span>
					  </div>
					  <br>
					  <input class="btn btn-primary" type="submit" value="单一添加" />

				  </form>
				  <br>
				  <form action="${contextPath}/dorm/insertFor" method="post"  class="bs-example bs-example-form" role="form" >
					  <div class="input-group">
						  <input type="number" class="form-control" placeholder="请输入起始宿舍楼号" name="d1">~
						  <input type="number" class="form-control" placeholder="请输入终止宿舍楼号" name="d2">
						  <span class="input-group-addon">栋</span>
					  </div>
					  <br>
					  <div class="input-group">
						  <input type="number" class="form-control" placeholder="请输入起始宿舍层数" name="c1">~
						  <input type="number" class="form-control" placeholder="请输入终止宿舍层数" name="c2">
						  <span class="input-group-addon">层</span>
					  </div>
					  <br>
					  <div class="input-group">
						  <input type="number" class="form-control" placeholder="请输入起始宿舍号" name="h1">~
						  <input type="number" class="form-control" placeholder="请输入终止宿舍号" name="h2">
						  <span class="input-group-addon">号</span>
					  </div>
					  <br>
					  <input class="btn btn-primary" type="submit" value="批量添加" />
				  </form>
			  </div>
		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
