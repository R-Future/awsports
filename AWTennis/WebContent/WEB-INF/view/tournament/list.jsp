<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛事信息</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<form:form class="form-inline" action="list" method="post" modelAttribute="tournamentQuery">
		<div class="form-group">
			<label for="tournamentName">赛事名称</label>
			<form:input path="tournament.name" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="arenaName">赛事地点</label>
			<form:input path="arena.name" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="startedAt">时间</label>
			<form:input type="datetime-local" path="tournament.startedat" class="form-control"/>
			-
			<label for="endedAt"></label>
			<form:input type="datetime-local" path="tournament.endedat" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form:form>
	<a href="<%=request.getContextPath()%>/tournament/update">添加赛事</a>
 	<table class="table table-striped table-responsive">
		<tr>
		<td>赛事名称</td>
		<td>赛事级别</td>
		<td>赛事地点</td>
		<td>开始时间</td>
		<td>结束时间</td>
		<td>奖金</td>
		<td>费用</td>
		<td>注释</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${tournaments}" var="item">
			<tr>
			<td><a href="<%=request.getContextPath()%>/tournament/detail?id=${item.tournament.id}">${ item.tournament.name }</a></td>
			<td>${ item.tournament.level }</td>
			<td>${ item.arena.name }</td>
			<td><spring:eval expression="item.tournament.startedat" /></td>
			<td><spring:eval expression="item.tournament.endedat" /></td>
			<td><spring:eval expression="item.tournament.prize" /></td>
			<td><spring:eval expression="item.tournament.cost" /></td>
			<td>${ item.tournament.note }</td>
			<td>
				<a href="<%=request.getContextPath()%>/tournament/update?id=${item.tournament.id}">修改</a>
				<a href="<%=request.getContextPath()%>/tournament/delete?id=${item.tournament.id}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>