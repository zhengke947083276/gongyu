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
	  <script type="text/javascript">
          //加载学院
          $(function () {
              $.ajax({
                  url:"/fac/selectAll",
                  type:"get",
                  success:function (result) {
                      //2.解析学院信息
                      build_fac(result);
                  }
              });
          });
          function build_fac(result) {
              var facs = result;
              $.each(facs, function (index, item) {
                  // alert(item.facName);
                  $("#facId")
                      .append(
                          $("<option></option>").val(item.facId).text(item.facName).attr("style", "color: blue")
                      );
              });
          }
          //点击获取专业
          function build_Spe(facId){
              $.ajax({
                  url:"/spe/selectByFacId?facId="+facId,
                  type:"get",
                  success:function (result) {
                      //2.解析专业信息
                      build_spes(result);
                  }
              });
          }
          function build_spes(result) {
              $("#speId").find("option").remove();
              $("#speId").append("<option>---请选择专业---</option>");
              var Spes = result;
              $.each(Spes, function (index, item) {
                  // alert(item.facName);
                  $("#speId")
                      .append(
                          $("<option></option>").val(item.speId).text(item.speName).attr("style", "color: red")
                      );
              });
          }
          //点击获取学生
		  function build_Stu(speId) {
              $.ajax({
                  url:"/stu/selectByStuState2AndSpeId?speId="+speId,
                  type:"get",
                  success:function (result) {
                      //2.解析学生信息
                      build_stus(result);
                  }
			  });
          }
          function build_stus(result) {
              $("#stuId").find("option").remove();
              $("#stuId").append("<option>---请选择学生---</option>");
              var Stus = result;
              $.each(Stus, function (index, item) {
                  // alert(item.facName);
                  $("#stuId")
                      .append(
                          $("<option></option>").val(item.stuId).text(item.stuName).attr("style", "color: darkgreen")
                      );
              });
          }
          //点击获取宿舍
          function build_Dorm(stuId) {
              $.ajax({
                  url:"/che/selectWithDormByCheckState1AndStuId?stuId="+stuId,
                  type:"get",
                  success:function (result) {
                      //2.解析入住信息
                      build_check(result);
                  }
              });
          }
          function build_check(result) {
              var dorm = result;
              $("#dormName").empty();
              $("#dormID").empty();
              $("#dormName").val(dorm.tblDorm.dormName);
              $("#dormID").val(dorm.tblDorm.dormId);
          }
	  </script>
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
			  <h2 class="text-center">添加来访人员信息</h2>
			  <div style="padding: 0px 540px 0px;text-align: center">
				  <form action="/vis/insert" class="bs-example bs-example-form" role="form" method="post">
					  <div class="input-group">
						  <span class="input-group-addon">姓名</span>
						  <input type="text" name="visName" class="form-control" placeholder="请输入来访姓名">
					  </div>
					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">身份证</span>
						  <input type="text" name="visCard" class="form-control" placeholder="请输入来访身份证">
					  </div>
					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">学院</span>
						  <select name="facId" id="facId" onchange="build_Spe(value)" class="form-control">
							  <option>---请选择学院---</option>
						  </select>
					  </div>
					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">专业</span>
						  <select name="speId" id="speId" class="form-control" onchange="build_Stu(value)">
							  <option >---请选择专业---</option>
						  </select>
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">学生</span>
						  <select name="stuId" id="stuId" class="form-control" onchange="build_Dorm(value)">
							  <option >---请选择学生---</option>
						  </select>
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">宿舍号</span>
						  <input type="text" id="dormName"  disabled="disabled" class="form-control" value="">
						  <input type="hidden" id="dormID"  value="" />
					  </div>
					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">备注</span>
						  <input type="text" name="visDescription" class="form-control">
					  </div>
					  <br>
					  <input type="submit"   value="添加" class="btn btn-primary">
					  <input type="reset"   value="重置" class="btn btn-primary">
				  </form>
			  </div>
		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
