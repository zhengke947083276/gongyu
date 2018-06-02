<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<script type="text/javascript">
			function setLoginDivCenter(){
				//获得浏览器的宽度
				var x = document.body.offsetWidth;
				//获得浏览器的高度
				var y = document.body.offsetHeight;
				//使用浏览器的宽度和高度计算loginDiv顶端的距离和左边的距离
				var left = (x-parseInt(document.getElementById("loginDiv").style.width))/2;
				var top = (y-parseInt(document.getElementById("loginDiv").style.height))/2;

				document.getElementById("loginDiv").style.left = left+"px";
				document.getElementById("loginDiv").style.top = top+"px";
			}
			function setBgDiv(){
				//获得浏览器的宽度
				var x = document.body.offsetWidth;
				//获得浏览器的高度
				var y = document.body.offsetHeight;
				document.getElementById("bgDiv").style.width=x;
				document.getElementById("bgDiv").style.height=y;
				//设置滚动条消失
				document.body.style.overflow="hidden";
			}
			function showDiv(){
				setLoginDivCenter();
				setBgDiv();
				document.getElementById("bgDiv").style.display="block";
				document.getElementById("loginDiv").style.display="block";
			}
			function closeDiv(){
				document.getElementById("bgDiv").style.display="none";
				document.getElementById("loginDiv").style.display="none";
				//设置滚动条消失
				document.body.style.overflow="scroll";
			}
	</script>
  	<div id="bgDiv" style="display:none;position: absolute;left:0;top:0;width: 1000px;height: 600px;filter:alpha(opacity=10,style=3,finishopacity=80);z-index: 9999;"></div>
	<div id="loginDiv" 
		style="display:none; background-color:azure;padding-top:0px;position: absolute;width: 500px;height: 300px;border: 1px solid red;z-index: 10000;">
		<div style="margin-top:0px;margin-left:350px;">
			<button type="button" class="close" aria-hidden="true" onclick="javaScript:closeDiv()" >&times;</button>
		</div>
		<h3 class="text-center">管理员登录</h3>
		<div style="padding: 20px 100px 20px;">
			<form action="/adm/login" method="post"  class="bs-example bs-example-form" role="form" >
				<div class="input-group">
					<span class="input-group-addon">账&nbsp;&nbsp;号</span>
					<input type="text" class="form-control" placeholder="请输入用户名" name="admUser">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">密&nbsp;&nbsp;码</span>
					<input type="password" class="form-control" placeholder="请输入密码" name="admPass">
				</div>
				<div style="text-align: center;padding: 15px 10px 15px;">
					<label class="checkbox-inline">
					<input type="checkbox" name="day" value="7"/>自动登录
					</label><br><br>

					<input class="btn btn-primary" type="submit" value="登      录" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-primary" type="reset" value="重      置" />
				</div>
			</form>
		</div>
	</div>