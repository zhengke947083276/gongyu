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

		  <%--*****************************--%>
		  // $(function () {
		  //     $.ajax({
			// 	  url:"/fac/selectFacultyWithSpecialty",
           //        type:"get",
           //        success:function (result) {
           //            // console.log(result);
           //            //2.解析专业信息
           //            build_facWithSpe(result);
           //        }
          //
			//   });
          // });
          //
          //
          //
		  // function build_facWithSpe(result) {
           //    var facWithSpes = result;
           //    $.each(facWithSpes, function (index, item) {
           //        // alert(item.facName);
           //        $("#facId")
           //            .append(
           //                $("<option></option>").val(item.facId).text(item.facName).attr("style", "color: blue")
           //            );
           //    });
          // }
          //
          //
          // function build_Spe(id) {
           //    //获取流
           //    $.ajax({
           //        url: "/fac/selectFacultyWithSpecialty",
           //        type: "get",
           //        success: function (result) {
           //            var spe = result;
           //            alert(spe);
           //        }
          //
           //    });
          // }



              // var Spes=result;
              // if (Spes==){
              //     for(var j=0;j<Spes[i].length;j++) {
              //         $("#facId").append($("<option onclick='build_Spe()'></option>").addClass(facWithSpes[i].facId).attr('id',facWithSpes[i].facId).val(facWithSpes[i].facId).text(facWithSpes[i].facName));
              //     }
              // }
		      // for (var i=0;i<facWithSpes.length;i++){
              // //.attr('onchange',build_Spe(fac_id))
               //    $("#facId").append("<option></option>");
              // // attr("onchange","build_Spe(facWithSpes[i].facName)".attr("onchange","build_Spe(1)");
               //    $("#facId:first").val(facWithSpes[i].facId).text(facWithSpes[i].facName);
		      // }
		      // // $.each(facWithSpes ,function (index,item) {
               // //    $("#facId").append($("<option onclick='build_Spe()'></option>").addClass(item.facId).attr('id',item.facId).val(item.facId).text(item.facName));
          <%--*****************************--%>
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
		  <h1 style="text-align:center;">添加学生</h1>
			  <form action="/stu/insert" method="post" enctype="multipart/form-data">
				  <table border="1" cellspacing="0" cellpadding="10" align="center" style="text-align: center;">
					  <tr>
						  <td>学号</td>
						  <td><input type="text" name="stuNo"/></td>
					  </tr>
					  <tr>
						  <td>年级</td>
						  <td>
							  <select name="stuPeriod">
								  <option>---请选择年级---</option>
								  <option value="2015">2015级</option>
								  <option value="2016">2016级</option>
								  <option value="2017">2017级</option>
								  <option value="2018">2018级</option>
								  <option value="2019">2019级</option>
								  <option value="2020">2020级</option>
							  </select>
						  </td>
					  </tr>
					  <tr>
						  <td>姓名</td>
						  <td><input type="text" name="stuName"/></td>
					  </tr>
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
							  <%--<input type="text" name="speId"  />--%>
							  <select name="speId" id="speId">
								  <option>---请选择专业---</option>
							  </select>
						  </td>
					  </tr>

					  <tr>
						  <td>出生日期</td>
						  <td><input type="date" name="stuBirthday"></td>
					  </tr>
					  <tr>
						  <td>性别</td>
						  <td>
							  <input type="radio" name="stuSex" value="true" checked="checked"> 男
							  <input type="radio" name="stuSex" value="false"> 女
						  </td>
					  </tr>
					  <tr>
						  <td>电话</td>
						  <td><input type="text" name="stuPhone"/></td>
					  </tr>
					  <tr>
						  <td>照片</td>
						  <td>
							  <%--<form action="/stu/upload" method="post" enctype="multipart/form-data">--%>
							  <%--<tr>--%>
							  <%--<td>上传</td>--%>
							  <%--<td><input type="file" name="file" />--%>
							  <%--<input type="submit" value="文件上传"></td>--%>
							  <%--</tr>--%>
							  <%--</form>--%>
							  <input type="file" name="file" id="file"/>
							  <input type="button" onclick="upload()" value="文件上传"></td>
						  <script type="text/javascript">
							  function upload() {
								 var file =  $("#file").val();
								  alert(file);
								  $.ajax({
									  url:"/stu/upload",
                                      type:"post",
                                      contentType : "application/x-www-form-urlencoded; charset=utf-8",
                                      // data:"file="+file,
                                      success:function (result) {
                                          //2.解析学院信息
                                          alert("成功！！！")
                                      }
								  });
                              }
							  
						  </script>

							  <%--<input type="hidden" name="stuPicture" />--%>
							  <%--<img src="/student/picture/logo.jpg">--%>
						  </td>
					  </tr>
					  <tr>
						  <td>地址</td>
						  <td><input type="text" name="stuAddress"></td>
					  </tr>
					  <tr>
						  <td colspan="2"><input type="submit" value="提交" /></td>
					  </tr>
				  </table>
			  </form>





		  </div>
	  </div>
	  <%@include file="/WEB-INF/jsp/zujian/foot.jsp"%>
	  <%--<jsp:include page="${pageContext.servletContext.contextPath}/WEB-INF/jsp/zujian/foot.jsp"/>--%>
  </div>
  </body>
</html>
