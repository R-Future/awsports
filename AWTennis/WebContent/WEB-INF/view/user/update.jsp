<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="/WEB-INF/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="/WEB-INF/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/WEB-INF/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="" style="color:red">
		<c:if test="${errors!=null}">
			<c:forEach items="${errors.allErrors}" var="error">
				${error.defaultMessage}<br/>
			</c:forEach>
		</c:if>
	</div>
	<form class="form" action="<%=request.getContextPath()%>/user/save" method="post">
		<input type="hidden" name="id" id="id" value="${user.id}" class="form-control"/>
		<div class="form-group">
			<label for="name">用户名</label>
			<input type="text" name="name" id="name" value="${user.name}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="password">密码</label>
			<input type="text" name="password" id="password" value="${user.password}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="nickname">昵称</label>
			<input type="text" name="nickname" id="nickname" value="${user.nickname}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="portrait">头像</label>
			<input type="text" name="portrait" id="portrait" value="${user.portrait}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="realname">真实姓名</label>
			<input type="text" name="realname" id="realname" value="${user.realname}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="idcard">身份证号</label>
			<input type="text" name="idcard" id="idcard" value="${user.idcard}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="phone">电话号码</label>
			<input type="text" name="phone" id="phone" value="${user.phone}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="email">邮箱</label>
			<input type="text" name="email" id="email" value="${user.email}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="height">身高(cm)</label>
			<input type="text" name="height" id="height" value="${user.height}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="weight">体重(kg)</label>
			<input type="text" name="weight" id="weight" value="${user.weight}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="level">网球水平</label>
			<input type="text" name="level" id="level" value="${user.level}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="playedyears">球龄</label>
			<input type="text" name="playedyears" id="playedyears" value="${user.playedyears}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="forehand">正手</label>
			<input type="text" name="forehand" id="forehand" value="${user.forehand}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="backhand">反手</label>
			<input type="text" name="backhand" id="backhand" value="${user.backhand}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="singletitles">单打冠军数</label>
			<input type="text" name="singletitles" id="singletitles" value="${user.singletitles}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="doubletitles">双打冠军数</label>
			<input type="text" name="doubletitles" id="doubletitles" value="${user.doubletitles}" class="form-control"/>
		</div>
<!-- 		<div class="form-group"> -->
<!-- 			<label for="updatedAt">更新时间</label> -->
<%-- 			<input type="text" name="updatedAt" id="updatedAt" value="${user.updatedAt}" class="form-control"/> --%>
<!-- 		</div> -->
		<button type="submit" class="btn btn-default">提交</button>
	</form>
</div>
</body>
</html>