<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title></title>
	  <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
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
                 url:"${contextPath}/fac/selectAll",
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
                  url:"${contextPath}/spe/selectByFacId?facId="+facId,
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
			  <h2 class="text-center">修改学生</h2>
			  <div style="padding: 0px 540px 0px;text-align: center">
				  <form action="${contextPath}/stu/updateUpload" class="bs-example bs-example-form" role="form" method="post" enctype="multipart/form-data">
					  <input type="hidden" class="form-control"  name="stuId" value="${tblStudent.stuId}">

					  <div class="input-group">
						  <span class="input-group-addon">学号</span>
						  <input type="text" class="form-control" readonly="readonly" name="stuNo" value="${tblStudent.stuNo}">
					  </div>
					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">年级</span>
						  <select name="stuPeriod" class="form-control">
							  <option>---请选择年级---</option>
							  <option value="2015">2015级</option>
							  <option value="2016">2016级</option>
							  <option value="2017">2017级</option>
							  <option value="2018">2018级</option>
							  <option value="2019">2019级</option>
							  <option value="2020">2020级</option>
						  </select>
					  </div>

					  <br>
					  <div class="input-group">
						  <span class="input-group-addon">姓名</span>
						  <input type="text" class="form-control" readonly="readonly" name="stuName" value="${tblStudent.stuName}">
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
						  <select name="speId" id="speId" class="form-control">
							  <option >---请选择专业---</option>
						  </select>
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">出生日期</span>
						  <input type="date" class="form-control"  name="stuBirthday">
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">性别</span>
						  <label class="radio-inline">
						  <input type="radio"   value="true" name="stuSex" checked="checked" >男
						  </label>
						  <label class="radio-inline">
						  <input type="radio"   value="false" name="stuSex">女
						  </label>
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">电话</span>
						  <input type="text" class="form-control"  name="stuPhone" placeholder="请输入电话">
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">照片</span>
						  <input type="file" class="form-control"  name="file" id="file">
					  </div>
					  <br>

					  <div class="input-group">
						  <span class="input-group-addon">地址</span>
						  <input type="text" class="form-control"  name="stuAddress" placeholder="请输入地址">
					  </div>
					  <br>
					  <input class="btn btn-primary" type="submit" value="提交" />

				  </form>
		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
