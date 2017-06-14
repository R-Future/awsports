<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- spring自带的form表单 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人积分</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<form:form class="form-inline" action="list" method="post" modelAttribute="teampointQuery">
		<div class="form-group">
			<label for="teamName">用户名</label>
			<form:input type="text" path="team.name" id="teamName" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="entry">参赛类型</label>
			<select name="teampoint.entry" id="entry" class="form-control">
				<option value="0">-请选择-</option>
				<c:forEach items="${ teamTypes }" var="teamType">
					<option value="${ teamType.key }">${ teamType.value }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="year">年份</label>
			<form:input type="number" path="teampoint.year" id="year" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="week">周</label>
			<form:input type="number" path="teampoint.week" id="week" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form:form>
<%-- 	<a href="<%=request.getContextPath()%>/teampoint/update">添加活动</a> --%>
 	<table class="table table-striped table-responsive">
		<tr>
		<td>参赛类型</td>
		<td>选手</td>
		<td>年份</td>
		<td>周</td>
		<td>总场数</td>
		<td>胜场数</td>
		<td>净胜局</td>
		<td>积分</td>
		<td>注释</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${teampointQuerys}" var="teampointQuery">
			<tr>
			<td>${ teamTypes.get(teampointQuery.teampoint.entry) }</td>
			<td>${ teampointQuery.team.name }</td>
			<td>${ teampointQuery.teampoint.year }</td>
			<td>${ teampointQuery.teampoint.week }</td>
			<td>${ teampointQuery.teampoint.matchs }</td>
			<td>${ teampointQuery.teampoint.wins }</td>
			<td>${ teampointQuery.teampoint.marginbureau }</td>
			<td>${ teampointQuery.teampoint.points }</td>
			<td>${ teampointQuery.teampoint.note }</td>
			<td>
				<a href="<%=request.getContextPath()%>/teampoint/update?id=${teampointQuery.teampoint.id}">修改</a>
				<a href="<%=request.getContextPath()%>/teampoint/delete?id=${teampointQuery.teampoint.id}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>