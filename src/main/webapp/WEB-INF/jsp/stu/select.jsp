<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title></title>
	<link rel="stylesheet" type="text/css" href="/css/index.css"/>
	<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
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
				  <caption><h1 align="center">学生信息</h1></caption>
				  <thead>
				  	<tr class="active">
						<th>序号</th>
						<th>学号</th>
						<th>级</th>
						<th>姓名</th>
						<th>图片</th>
						<th>学院</th>
						<th>专业</th>
						<th>生日</th>
						<th>性别</th>
						<th>电话</th>
						<th>地址</th>
						<th>状态</th>
						<th>操作</th>
				  	</tr>
				  </thead>

				  <tbody>
				  <c:forEach items="${pageInfo.list}" var="tblStudent" varStatus="x">
					  <tr class="success">
						  <td>${x.index+1}</td>
						  <td>${tblStudent.stuNo}</td>
						  <td>${tblStudent.stuPeriod}</td>
						  <td>${tblStudent.stuName}</td>
						  <td><img src="${contextPath}/student/picture/${tblStudent.stuPicture}" width="40px" height="50px" class="img-rounded"></td>
						  <td>${tblStudent.tblSpecialty.tblFaculty.facName}</td>
						  <td>
							  ${tblStudent.tblSpecialty.speName}
						  </td>


						  <td><fmt:formatDate value="${tblStudent.stuBirthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						  <td>${tblStudent.stuSex?"男":"女"}</td>
						  <td>${tblStudent.stuPhone}</td>
						  <td>${tblStudent.stuAddress}</td>
						  <td>
							  <%--1入校--%>
							  <%--2入住--%>
							  <%--3毕业--%>
							  <c:choose>
								  <c:when test="${tblStudent.stuState==1}">入校</c:when>
								  <c:when test="${tblStudent.stuState==2}">入住</c:when>
								  <c:when test="${tblStudent.stuState==3}">毕业</c:when>
							  </c:choose>
						  </td>
						  <%--<a href="/stu/updateByStuState?stuId=${tblStudent.stuId}&stuState=${tblStudent.stuState}">毕业</a>--%>
						  <td>
								   <c:choose>
									  <c:when test="${tblStudent.stuState==1}">
										  <%--<a href="/stu/update?stuId=${tblStudent.stuId}"></a>入校--%>

										  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
											  <span class="glyphicon glyphicon-pencil"></span>
											  <a href="${contextPath}/stu/update?stuId=${tblStudent.stuId}&stuState=${tblStudent.stuState}&state=3" style="color: white;text-decoration: none; ">毕业</a>
										  </button>
									  </c:when>
									  <c:when test="${tblStudent.stuState==2}">
										  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
											  <span class="glyphicon glyphicon-pencil"></span> <a href="${contextPath}/stu/update?stuId=${tblStudent.stuId}&stuState=${tblStudent.stuState}&state=3" style="color: white;text-decoration: none; ">毕业</a>
										  </button>
										  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
											  <span class="glyphicon glyphicon-pencil"></span> <a href="${contextPath}/stu/update?stuId=${tblStudent.stuId}&stuState=${tblStudent.stuState}&state=1" style="color: white;text-decoration: none; ">入校</a>
										  </button>

									  </c:when>
									  <c:when test="${tblStudent.stuState==3}">
										  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
											  <span class="glyphicon glyphicon-pencil"></span> <a href="${contextPath}/stu/update?stuId=${tblStudent.stuId}&stuState=${tblStudent.stuState}&state=1" style="color: white;text-decoration: none; ">入校</a>
										  </button>
										  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
											  <span class="glyphicon glyphicon-trash"></span> <a href="${contextPath}/stu/delete?stuId=${tblStudent.stuId}" style="color: white;text-decoration: none; ">删除</a>
										  </button>
									  </c:when>
								  </c:choose>
							  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
								  <span class="glyphicon glyphicon-pencil"></span> <a href="${contextPath}/stu/updateAll?stuId=${tblStudent.stuId}" style="color: white;text-decoration: none; ">信息完善</a>
							  </button>
						  </td>
					  </tr>
				  </c:forEach>
				  </tbody>
			  </table>
			  <div style="text-align:center">

				  <ul class="pagination">
					  <li class="previous"><a href="${contextPath}/stu/select?pn=1">首  页</a></li>
					  <c:if test="${pageInfo.hasPreviousPage}">
						  <li><a href="${contextPath}/stu/select?pn=${pageInfo.pageNum-1}">&laquo;</a></li>
					  </c:if>
					  <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
						  <c:if test="${page_Num== pageInfo.pageNum}">
							  <%--高量--%>
							  <li class="active"><a href="${contextPath}/stu/select?pn=${page_Num}">${page_Num}</a></li>
						  </c:if>
						  <c:if test="${page_Num != pageInfo.pageNum}">
							  <li><a href="${contextPath}/stu/select?pn=${page_Num}">${page_Num}</a></li>
						  </c:if>
					  </c:forEach>
					  <c:if test="${pageInfo.hasNextPage}">
						  <li><a href="${contextPath}/stu/select?pn=${pageInfo.pageNum+1}">&raquo;</a></li>
					  </c:if>
					  <li class="next"><a href="${contextPath}/stu/select?pn=${pageInfo.pages}">末  页</a></li>
				  </ul>
				  <br>
				  <span>当前${pageInfo.pageNum}页 | 总${pageInfo.pages}页 | 总${pageInfo.total}条记录 |</span>
			  </div>
			  <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
				  <span class="glyphicon glyphicon-floppy-save"></span> <a href="${contextPath}/stu/exportStudent" style="color: white;text-decoration: none; ">导出</a>
			  </button>

		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
