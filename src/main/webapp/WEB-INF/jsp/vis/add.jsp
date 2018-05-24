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
	  <style type="text/css">
		  table{
			  border:solid 1px;
			  border-color: burlywood;
			  margin: auto;
			  text-align: center;

		  }
		  td{
			  border:solid 1px;
			  border-color: burlywood;
			  padding-top: 5px;
			  padding-bottom:5px;
			  font-size: 15px;
			  font-weight: 500;
		  }
		  fieldset{
			  margin: auto;
		  }
		  .tdd{
			  color: brown;
			  font-size: 20px;
			  font-family: "楷体";
			  font-style: italic;
		  }
		  .b_2{
			  /*margin-top: 200px;*/
			  width: 800px;
		  }
		  .submit{
			  margin-left: 35px;
			  padding-left: 25px;
			  padding-right: 25px;
		  }
		  input{
			  height: 23px;
		  }

	  </style>


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
              $("#dorm").empty();
              $("#dorm").append("<span></span>").val(dorm.tblDorm.dormId).text(dorm.tblDorm.dormName).attr("style", "color: darkgreen");
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

		  <fieldset style="border-color: green;padding: 10px;width: 50%">
				  <legend style="color: brown; font-size: 30px;font-family:黑体">公寓来访记录</legend>

				  <form method="post" action="/vis/insert">
					  <table cellspacing="0px">
						  <tbody><tr><td class="tdd" colspan="2">添加来访人员信息</td></tr>

						  <tr><td>姓 名</td><td><input type="text" name="visName"></td></tr>
						  <tr><td>身份信息</td><td><input type="text" name="visCard"></td></tr>
						  <tr>
							  <td>学院</td>
							  <td>
								  <select name="facId" id="facId" onchange="build_Spe(value)">
									  <option>---请选择学院---</option>
								  </select>
							  </td>
						  </tr>
						  <tr>
							  <td>专业</td>
							  <td>
								  <select name="speId" id="speId" onchange="build_Stu(value)">
									  <option>---请选择专业---</option>
								  </select>

							  </td>
						  </tr>
						  <tr>
							  <td>学生</td>
							  <td>
								  <select name="stuId" id="stuId" onchange="build_Dorm(value)">
									  <option>---请选择学生---</option>
								  </select>
							  </td>
						  </tr>

						  <tr><td>宿舍号</td><td id="dorm"></td></tr>

						  <tr><td>备 注</td><td><input type="text" name="visDescription"></td></tr>
						  <tr><td colspan="2">
							  <input type="submit" name="submit" class="submit"  value="添加">
							  <input type="reset" name="submit" class="submit" value="重置">
						  </td></tr>
						  </tbody></table>
				  </form></fieldset>
		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
