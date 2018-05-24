<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="top2" style="height: 50px;padding: 1px">
	<div class="time" style="float: left;margin-left: 30px;padding-top: 0px;font-size: 30px">
		<span id="time" class="label label-info"></span>
		<script type="text/javascript">
            window.onload = function(){
                showTime();
            }
            function showTime(){
                var myDate = new Date();
                var year = myDate.getFullYear();
                var month = myDate.getMonth() + 1;
                var date = myDate.getDate();
                var dayArray = new Array(7);
                dayArray[0] = "星期日";
                dayArray[1] = "星期一";
                dayArray[2] = "星期二";
                dayArray[3] = "星期三";
                dayArray[4] = "星期四";
                dayArray[5] = "星期五";
                dayArray[6] = "星期六";
                var day1 = myDate.getDay();
                var day = dayArray[day1];
                var hour = myDate.getHours();
                var minute = myDate.getMinutes();
                var second = myDate.getSeconds();
                var min = checkTime(minute);
                var sec = checkTime(second);
                var time1 = year + "年" + month + "月" + date + "日";
                var time2 = hour + "：" + min + "：" + sec;
                // document.write(time1+day+time2);
                //用js方法
                // document.getElementById("time").innerHTML = time1+day+time2;
                //用jquery方法
                $('#time').text(time1+day+time2);
                setTimeout("showTime()",500);
            }
            function checkTime(i){
                if(i<10){
                    i = "0" + i;
                }
                return i;
            }
		</script>
	</div>
	<div class="daohang">
		<c:choose>
			<c:when test="${user==null}">
				<button type="button" onclick="javaScript:showDiv()" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
					<span class="glyphicon glyphicon-user"></span> 登录
				</button>
			</c:when>
			<c:when test="${user!=null}">
				<span style="font-size: 22px;">欢迎</span><span style="font-size: 22px;" class="label label-success">${user.admUser}</span><span style="font-size: 22px;">进入</span>
				<button type="button" onclick="javaScript:showDiv1()" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
					<span class="glyphicon glyphicon-user"></span> 修改
				</button>
				<button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
					<span class="glyphicon glyphicon-off"></span> <a href="/adm/exit" style="color: white;text-decoration: none; ">退出</a>
				</button>
			</c:when>
		</c:choose>
	</div>
</div>