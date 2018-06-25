<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>首页</title>
      <link rel="stylesheet" type="text/css" href="${contextPath}/css/index.css"/>
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
  <%@include file="adm/login.jsp"%>
  <%@include file="adm/update.jsp"%>
  <div id="all">
      <%@include file="zujian/top1.jsp"%>
      <jsp:include page="zujian/top2.jsp"/>
	  <div id="main">
          <%@include file="zujian/left.jsp"%>
          <div class="b_2" style="width: 1100px;height: 650px;margin-right:150px;">
              <h1 class="text-center">宝 鸡 文 理 学 院</h1>
              <h1 class="text-center">
                  <%--<%--%>
                      <%--String contextPath = request.getContextPath();--%>
                      <%--out.print(contextPath);--%>
                  <%--%>--%>
              </h1>
              <div style="line-height: 1.5em;font-size: 18px">
              <p class="vsbcontent_img" style="text-justify: inter-ideograph;text-align: justify;text-indent: 28px;margin: 0px auto">宝鸡文理学院是一所省属普通本科高等学校，前身为1958年创办的宝鸡大学（本科），1963年因国家经济困难停办，1975年恢复为陕西师范大学宝鸡分校（本科），1978年经国务院批准定名为宝鸡师范学院，1992年经原国家教委批准，与1984年新设立的宝鸡大学合并，更名为宝鸡文理学院。</p>
              <p style="text-justify: inter-ideograph;text-align: justify;text-indent: 28px;margin: 0px auto">在近60年的奋斗历程中，一代又一代宝鸡文理人筚路蓝缕、栉风沐雨、奋勇开拓，文理精神薪火相传，教泽留芳，学校事业康庄发展、阔步向前。2008年学校荣获教育部“普通高等学校本科教学工作水平评估优秀学校”称号；2013年学校获批为国务院学位委员会“硕士学位授予单位”；2017年学校被陕西省列入新增博士学位授予单位立项建设计划；2017年10月陕西省教育厅、宝鸡市人民政府签署了共同推进学校建成宝鸡大学协议书，使学校站在了新的发展起点上。</p>
              </div>
                  <br>
              <div id="myCarousel" class="carousel slide">
                  <!-- 轮播（Carousel）指标 -->
                  <ol class="carousel-indicators">
                      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                      <li data-target="#myCarousel" data-slide-to="1"></li>
                      <li data-target="#myCarousel" data-slide-to="2"></li>
                  </ol>
                  <!-- 轮播（Carousel）项目 -->
                  <div class="carousel-inner">
                      <div class="item active">
                          <img src="http://www.bjwlxy.cn/images/2017xiaoyuan01.jpg" alt="First slide">
                      </div>
                      <div class="item">
                          <img src="http://www.bjwlxy.cn/images/shzy.jpg" alt="Second slide">
                      </div>
                      <div class="item">
                          <img src="http://www.bjwlxy.cn/images/33.jpg" alt="Third slide">

                      </div>
                  </div>
                  <!-- 轮播（Carousel）导航 -->
                  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a>
              </div>
          </div>
	  </div>
      <%@include file="zujian/foot.jsp"%>

  </div>
  </body>
</html>
