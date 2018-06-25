<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title></title>
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
	<script type="text/javascript" src="${contextPath}/js/jquery-3.3.1.js"></script>
	  <script type="text/javascript">
		  //1.页面加载完成执行js，ajax请求
		  $(function () {
              $.ajax({
                  url:"${contextPath}/dorm/selectByDormState1",
                  type:"get",
                  success:function (result) {
                      // console.log(result);
                      //2.解析宿舍信息
                      build_dorm(result);
                  }
              });
          });

		  function build_dorm(result) {
			  var dorms = result;
			  $.each(dorms,function (index,item) {
				  // alert(item.dormName)
				  $("#dorm").append($("<option></option>").val(item.dormId).text(item.dormName));
              });
          }

          $(document).ready(function () {
              $.ajax({
                  url:"${contextPath}/stu/selectTblStudentByStuState1",
                  type:"get",
                  success:function (result) {
                      // console.log(result);
                      //2.解析学生信息
                      build_student(result);
                  }
              });
          });

          function build_student(result) {
              var students = result;
              $.each(students,function (index,item) {
                  // alert(item.stuNo)
                  $("#student").append($("<option></option>").val(item.stuId).text(item.stuNo));
              });
          }
	  </script>
  </head>
  <body>

  <jsp:include page="/WEB-INF/jsp/adm/login.jsp"/>
  <%@include file="/WEB-INF/jsp/adm/update.jsp"%>
  <%--<%@include file="/WEB-INF/jsp/adm/login.jsp"%>--%>
  <div id="all">
	  <%@include file="/WEB-INF/jsp/zujian/top1.jsp"%>
	  <%@include file="/WEB-INF/jsp/zujian/top2.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/top1.jsp"/>--%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/top2.jsp"/>--%>
	  <div id="main">
		  <%@include file="/WEB-INF/jsp/zujian/left.jsp"%>
		  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/left.jsp"/>--%>
		  <div class="b_2" style="width: 1310px;height: 650px">
			  <h2 class="text-center">添加入住信息</h2>
			  <div style="padding: 0px 540px 0px;text-align: center">
				  <form action="${contextPath}/che/insert" method="post"  class="bs-example bs-example-form" role="form" >
					  <div class="input-group">
						  <span class="input-group-addon">宿舍</span>
						  <select id="dorm" name="dormId" class="form-control">
							  <option>---请选择宿舍---</option>
						  </select>
					  </div>
					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">学生</span>
						  <select id="student"   name="stuId" class="form-control">
							  <option>---请选择学生---</option>
						  </select>
					  </div>
					  <br>
					  <input type="submit" value="入住" class="btn btn-primary"/>
				  </form>
			  </div>
		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>

	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
