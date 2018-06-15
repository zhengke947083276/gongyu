<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<script type="text/javascript">
			function setUpdateDivCenter(){
				//获得浏览器的宽度
				var x = document.body.offsetWidth;
				//获得浏览器的高度
				var y = document.body.offsetHeight;
				//使用浏览器的宽度和高度计算loginDiv顶端的距离和左边的距离
				var left = (x-parseInt(document.getElementById("updateDiv").style.width))/2;
				var top = (y-parseInt(document.getElementById("updateDiv").style.height))/2;

				document.getElementById("updateDiv").style.left = left+"px";
				document.getElementById("updateDiv").style.top = top+"px";
			}
			function setBgDiv1(){
				//获得浏览器的宽度
				var x = document.body.offsetWidth;
				//获得浏览器的高度
				var y = document.body.offsetHeight;
				document.getElementById("bgDiv").style.width=x;
				document.getElementById("bgDiv").style.height=y;
				//设置滚动条消失
				document.body.style.overflow="hidden";
			}
			function showDiv1(){
                setUpdateDivCenter();
				setBgDiv1();
				document.getElementById("bgDiv").style.display="block";
				document.getElementById("updateDiv").style.display="block";
			}
			function closeDiv1(){
				document.getElementById("bgDiv").style.display="none";
				document.getElementById("updateDiv").style.display="none";
				//设置滚动条消失
				document.body.style.overflow="scroll";
			}
	</script>
  	<div id="bgDiv" style="display:none;position: absolute;left:0;top:0;width: 1000px;height: 600px;filter:alpha(opacity=10,style=3,finishopacity=80);z-index: 9999;"></div>
	<div id="updateDiv"
		style="display:none; background-color:azure;padding-top:0px;position: absolute;width: 500px;height: 300px;border: 1px solid red;z-index: 10000;">
		<div>
			<button type="button" class="close" aria-hidden="true" onclick="javaScript:closeDiv1()" >&times;</button>
		</div>
		<h3 class="text-center">管理员修改</h3>
		<div style="padding: 20px 100px 20px;">
			<form action="${contextPath}/adm/update" method="post"  class="bs-example bs-example-form" role="form" >
				<div class="input-group">
					<span class="input-group-addon">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</span>
					<input type="text" class="form-control" disabled="disabled"  name="admId" value="${user.admUser}">
					<input type="hidden" name="admId" value="${user.admId}"/>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">新&nbsp;&nbsp;密&nbsp;&nbsp;码</span>
					<input type="text" class="form-control" placeholder="请输入新密码" name="admPass">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">确认密码</span>
					<input type="password" class="form-control" placeholder="请输入确认密码" name="XinAdmPass">
				</div>
				<div style="text-align: center;padding: 15px 10px 15px;">

					<input class="btn btn-primary" type="submit" value="修      改" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-primary" type="reset" value="重      置" />
				</div>
			</form>
		</div>
</div>