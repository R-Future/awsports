<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="../resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<form class="form-inline" action="<%=request.getContextPath()%>/user/show" method="post">
		<div class="form-group">
			<label for="username">用户名</label>
			<input type="text" name="name" id="username" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="address">地址</label>
			<input type="text" name="address" id="address" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="level">网球水平</label>
			<input type="text" name="level" id="level" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form>
	
 	<table class="table table-striped table-responsive">
		<tr>
		<td>用户名</td>
<!-- 		<td>密码</td> -->
		<td>性别</td>
		<td>手机号</td>
		<td>邮箱</td>
		<td>技术水平</td>
		<td>球龄</td>
		<td>正手</td>
		<td>反手</td>
		<td>单打冠军数</td>
		<td>双打冠军数</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${ user.name }</td>
<%-- 			<td>${ user.password }</td> --%>
			<td>
				<c:choose>
					<c:when test="${ user.sex==false }">男</c:when>
					<c:otherwise>女</c:otherwise>
				</c:choose>
			</td>
			<td>${ user.phone }</td>
			<td>${ user.email }</td>
			<td>${ user.level }</td>
			<td>${ user.playedyears }</td>
			<td>
				<c:choose>
					<c:when test="${ user.forehand==0 }">右手</c:when>
					<c:when test="${ user.forehand==1 }">左手</c:when>
					<c:otherwise>双手</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${ user.backhand==false }">双反</c:when>
					<c:otherwise>单反</c:otherwise>
				</c:choose>
			</td>
			<td>${ user.singletitles }</td>
			<td>${ user.doubletitles }</td>
			<td><a href="<%=request.getContextPath()%>/user/update?id=${user.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>