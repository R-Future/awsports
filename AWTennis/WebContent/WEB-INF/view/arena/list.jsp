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
	<form class="form-inline" action="<%=request.getContextPath()%>/arena/list" method="post">
		<div class="form-group">
			<label for="name">场馆名称</label>
			<input type="text" name="name" id="name" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="address">场馆地址</label>
			<input type="text" name="address" id="address" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="type">场馆类型</label>
			<select name="type" id="type">
				<option value="default">-请选择-</option>
				<c:forEach items="${arenaTypes}" var="arenaType">
					<option value="${arenaType.key}">${arenaType.value}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form>
	<a href="<%=request.getContextPath()%>/arena/update">添加活动</a>
 	<table class="table table-striped table-responsive">
		<tr>
		<td>场馆名称</td>
		<td>场馆地址</td>
		<td>场馆类型</td>
		<td>室内场地数</td>
		<td>室外场地数</td>
		<td>注释</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${arenas}" var="arena">
			<tr>
			<td>${ arena.name }</td>
			<td>${ arena.address }</td>
			<td>${ arenaTypes.get(arena.type) }</td>
			<td>${ arena.indoornumber }</td>
			<td>${ arena.outdoornumber }</td>
			<td>${ arena.note }</td>
			<td>
				<a href="<%=request.getContextPath()%>/arena/update?id=${arena.id}">修改</a>
				<a href="<%=request.getContextPath()%>/arena/delete?id=${arena.id}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>