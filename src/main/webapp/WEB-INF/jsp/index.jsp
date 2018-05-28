<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>首页</title>
      <link rel="stylesheet" type="text/css" href="/css/index.css"/>
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
          <div class="b_2" style="width: 1310px;height: 650px">
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
