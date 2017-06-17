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
<title>组合信息</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="../resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form:form class="form-inline" action="list" method="post" modelAttribute="teamQuery">
				<div class="form-group">
					<label for="user1Name">队员1</label>
					<form:input path="user1.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="user2Name">队员2</label>
					<form:input path="user2.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="entry">组合类型</label>
					<form:select path="team.entry" id="entry" class="form-control">
						<option value="0">-请选择-</option>
						<c:forEach items="${ teamEntryTypes }" var="teamEntryType">
							<option value="${ teamEntryType.key }">${ teamEntryType.value }</option>
						</c:forEach>
					</form:select>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form:form>
		</div>
		<div class="col-md-1 col-md-offset-3">
			<a href="<%=request.getContextPath()%>/team/update" title="添加">
				<button type="button" class="btn btn-default">添加
<!-- 					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> -->
				</button>
			</a>
		</div>
	</div>
	
 	<table class="table table-striped table-responsive">
		<tr>
		<th>队员1</th>
		<th>队员2</th>
		<th>组合类型</th>
		<th>开始时间</th>
		<th>注释</th>
		<th>操作</th>
		</tr>
		<c:forEach items="${teams}" var="item">
			<tr>
			<td>${ item.user1.name }</td>
			<td>${ item.user2.name }</td>
			<td>${ teamEntryTypes.get(item.team.entry) }</td>
			<td><spring:eval expression="item.team.startedat"/></td>
			<td>${ item.team.note }</td>
			<td>
				<a href="<%=request.getContextPath()%>/team/update?id=${item.team.id}" title="修改"><span class="glyphicon glyphicon-pencil"></span></a>
				<a href="<%=request.getContextPath()%>/team/delete?id=${item.team.id}" title="删除"><span class="glyphicon glyphicon-minus"></span></a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>