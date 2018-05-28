<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>首页</title>
	<link rel="stylesheet" type="text/css" href="/css/index.css"/>
	  <%--<script type="text/javascript" src="js/jquery-3.3.1.js"></script>--%>
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
	  <%@include file="/WEB-INF/jsp/zujian/top1.jsp"%>
	  <%@include file="/WEB-INF/jsp/zujian/top2.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/top1.jsp"/>--%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/top2.jsp"/>--%>
	  <div id="main">
		  <%@include file="/WEB-INF/jsp/zujian/left.jsp"%>
		  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/left.jsp"/>--%>
		  <div class="b_2" style="width: 1310px;height: 650px">
			  <table class="table table-hover table-bordered">
				  <caption><h1 align="center">宿舍信息</h1></caption>
				  <thead>
					  <tr class="active">
						  <th>序号</th>
						  <th>房间号</th>
						  <th>状态</th>
						  <th>操作</th>
					  </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${pageInfo.list}" var="dorm" varStatus="x">
					  <tr class="success">
						  <td>${x.index+1}</td>
						  <td>${dorm.dormName}</td>
						  <td>
							  <c:choose>
								  <c:when test="${dorm.dormState==1}">
									  正常
								  </c:when>
								  <c:when test="${dorm.dormState==2}">
									  已满
								  </c:when>
								  <c:when test="${dorm.dormState==3}">
									  不正常
								  </c:when>
							  </c:choose>

						  </td>
						  <td>
							  <c:choose>
								  <c:when test="${dorm.dormState==1}">
									  <%--<button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">--%>
										  <%--<span class="glyphicon glyphicon-off"></span> <a href="/che/delete?checkId=${tblCheck.checkId}">删除</a>--%>
									  <%--</button>--%>
									  <a href="">查看</a>
									  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
										  <span class="glyphicon glyphicon-pencil"></span> <a href="/dorm/update?dormId=${dorm.dormId}&dormState=2">修改为已满</a>
									  </button>
									  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
										  <span class="glyphicon glyphicon-pencil"></span> <a href="/dorm/update?dormId=${dorm.dormId}&dormState=3">修改为不正常</a>
									  </button>
								  </c:when>
								  <c:when test="${dorm.dormState==2}">
									  <a href="">查看</a>
									  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
										  <span class="glyphicon glyphicon-pencil"></span> <a href="/dorm/update?dormId=${dorm.dormId}&dormState=1">修改为正常</a>
									  </button>
									  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
										  <span class="glyphicon glyphicon-trash"></span> <a href="/dorm/delete?dormId=${dorm.dormId}">删除</a>
									  </button>
								  </c:when>
								  <c:when test="${dorm.dormState==3}">
									  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
										  <span class="glyphicon glyphicon-pencil"></span> <a href="/dorm/update?dormId=${dorm.dormId}&dormState=1">修改为正常</a>
									  </button>
									  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
										  <span class="glyphicon glyphicon-trash"></span> <a href="/dorm/delete?dormId=${dorm.dormId}">删除</a>
									  </button>
								  </c:when>
							  </c:choose>

						  </td>
					  </tr>
				  </c:forEach>
				  </tbody>
			  </table>
			  <div style="text-align:center">
				  <ul class="pagination">
					  <li class="previous"><a href="/dorm/selectPage?pn=1">首  页</a></li>
				  <c:if test="${pageInfo.hasPreviousPage}">
					  <li><a href="/dorm/selectPage?pn=${pageInfo.pageNum-1}">&laquo;</a></li>
				  </c:if>
				  <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
					  <c:if test="${page_Num== pageInfo.pageNum}">
						  <%--高量--%>
						  <li class="active"><a href="/dorm/selectPage?pn=${page_Num}">${page_Num}</a></li>
					  </c:if>
					  <c:if test="${page_Num != pageInfo.pageNum}">
						  <li><a href="/dorm/selectPage?pn=${page_Num}">${page_Num}</a></li>
					  </c:if>
				  </c:forEach>
				  <c:if test="${pageInfo.hasNextPage}">
					  <li><a href="/dorm/selectPage?pn=${pageInfo.pageNum+1}">&raquo;</a></li>
				  </c:if>
					  <li class="next"><a href="/dorm/selectPage?pn=${pageInfo.pages}">末  页</a></li>
				  </ul>
				  <br>
				  <span>当前${pageInfo.pageNum}页 | 总${pageInfo.pages}页 | 总${pageInfo.total}条记录 |</span>
			  </div>
		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
