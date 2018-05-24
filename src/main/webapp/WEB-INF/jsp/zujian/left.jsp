<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="b_1" style="width: 100px;height: 650px">

	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
				data-toggle="dropdown">
			宿舍管理
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			<li role="presentation">
				<a href="/dorm/add">宿舍信息添加</a>
			</li>

			<li role="presentation">
				<a href="/dorm/selectPage">宿舍信息查询</a>
			</li>
		</ul>
	</div>

	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu2"
				data-toggle="dropdown">
			学生管理
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
			<li role="presentation">
				<a href="/stu/add">学生信息添加</a>
			</li>

			<li role="presentation">
				<a href="#">学生信息修改</a>
			</li>

			<li role="presentation">
				<a href="/stu/select">学生信息查询</a>
			</li>
		</ul>
	</div>

	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu3"
				data-toggle="dropdown">
			入住管理
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu3">
			<li role="presentation">
				<a href="/che/add">入住信息添加</a>
			</li>

			<li role="presentation">
				<a href="#">入住信息修改</a>
			</li>
			<li role="presentation">
				<a href="#">入住信息更新</a>
			</li>

			<li role="presentation">
				<a href="/che/selectAll">入住信息查询</a>
			</li>
		</ul>
	</div>



	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu4"
				data-toggle="dropdown">
			来访管理
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
			<li role="presentation">
				<a href="/vis/add">来访信息添加</a>
			</li>

			<li role="presentation">
				<a href="/vis/select">来访信息查询</a>
			</li>
		</ul>
	</div>
	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu5"
				data-toggle="dropdown">
			门禁管理
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu5">
			<li role="presentation">
				<a href="/reg/jinChu">进出验证</a>
			</li>

			<li role="presentation">
				<a href="/reg/select">查看记录</a>
			</li>
		</ul>
	</div>
</div>