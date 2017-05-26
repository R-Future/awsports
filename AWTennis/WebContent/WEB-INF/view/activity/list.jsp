<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>俱乐部活动</title>
</head>
<body>
<div class="container-fluid">
	<form class="form-inline" action="<%=request.getContextPath()%>/activity/list" method="post">
		<div class="form-group">
			<label for="activityName">活动名称</label>
			<input type="text" name="name" id="activityName" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="arenaName">活动地点</label>
			<input type="text" name="arenaName" id="arenaName" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="startedAt">时间</label>
			<input type="text" name="startedat" id="startedAt" class="form-control"/>
			-
			<label for="endedAt"></label>
			<input type="text" name="endedat" id="endedAt" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form>
	<a href="<%=request.getContextPath()%>/activity/update">添加活动</a>
 	<table class="table table-striped table-responsive">
		<tr>
		<td>活动名称</td>
		<td>活动地点</td>
		<td>开始时间</td>
		<td>结束时间</td>
		<td>费用</td>
		<td>活动详情</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${activities}" var="item">
			<tr>
			<td>${ item.activity.name }</td>
			<td>${ item.arena.name }</td>
			<td><spring:eval expression="item.activity.startedat" /></td>
			<td><spring:eval expression="item.activity.endedat" /></td>
			<td><spring:eval expression="item.activity.cost" /></td>
			<td>${ item.activity.detail }</td>
			<td>
				<a href="<%=request.getContextPath()%>/activity/update?id=${item.activity.id}">修改</a>
				<a href="<%=request.getContextPath()%>/activity/delete?id=${item.activity.id}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>