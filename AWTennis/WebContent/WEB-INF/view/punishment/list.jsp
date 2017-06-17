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
<title>个人扣分信息</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<form:form class="form-inline" action="list" method="post" modelAttribute="punishmentQuery">
		<div class="form-group">
			<label for="userName">用户名</label>
			<form:input path="user.name" id="userName" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="entry">参赛类型</label>
			<form:select path="punishment.entry" id="entry" class="form-control">
				<form:option value="0">-请选择-</form:option>
				<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
					<form:option value="${ individualEntryType.key }">${ individualEntryType.value }</form:option>
				</c:forEach>
			</form:select>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form:form>
	<a href="<%=request.getContextPath()%>/punishment/update">添加个人扣分</a>
 	<table class="table table-striped table-responsive">
		<tr>
		<td>用户名</td>
		<td>赛事类型</td>
		<td>比赛时间</td>
		<td>参赛类型</td>
		<td>扣除分数</td>
		<td>注释</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${punishmentQuerys}" var="punishmentQuery">
			<tr>
			<td>${ punishmentQuery.user.name }</td>
			<td>${ punishmentQuery.tournament.name }</td>
			<td><spring:eval expression="punishmentQuery.punishment.matchtime" /></td>
			<td>${ individualEntryTypes.get(punishmentQuery.punishment.entry) }</td>
			<td>${ punishmentQuery.punishment.points }</td>
			<td>${ item.tournament.note }</td>
			<td>
				<a href="<%=request.getContextPath()%>/punishment/update?id=${punishmentQuery.punishment.id}">修改</a>
				<a href="<%=request.getContextPath()%>/punishment/delete?id=${punishmentQuery.punishment.id}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>