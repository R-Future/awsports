<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
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
	<form class="form" action="<%=request.getContextPath()%>/individualrank/save" method="post">
		<input type="hidden" name="id" id="id" value="${individualrank.id}" class="form-control"/>
		<div class="form-group">
			<label for="userName">用户名</label>
			<select name="name" id="userName" class="form-control">
				<option>-请选择-</option>
				<c:forEach items="${ users }" var="user">
					<c:choose>
						<c:when test="${ user.id.equals(individualrank.userid) }">
							<option value="${ user.id }" selected>${ user.name }</option>
						</c:when>
						<c:otherwise>
							<option value="${ user.id }">${ user.name }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="entry">参赛类型</label>
			<select id="entry" name="entry" class="form-control">
				<option>-请选择-</option>
				<c:forEach items="${individualEntryTypes}" var="individualEntryType">
					<c:choose>
						<c:when test="${individualEntryType.key.equals(individualrank.entry)}">
							<option value="${individualEntryType.key}" selected="selected">${individualEntryType.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${individualEntryType.key}">${individualEntryType.value}</option>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="year">当前排名</label>
			<input type="number" name="year" id="year" value="${individualrank.currentrank}" class="form-control"/>
		</div>
<!-- 		<div class="form-group"> -->
<!-- 			<label for="year">年份</label> -->
<%-- 			<input type="number" name="year" id="year" value="${individualrank.year}" class="form-control"/> --%>
<!-- 		</div> -->
<!-- 		<div class="form-group"> -->
<!-- 			<label for="week">周</label> -->
<%-- 			<input type="number" name="week" id="week" value="${individualrank.week}" class="form-control"/> --%>
<!-- 		</div> -->
		<div class="form-group">
			<label for="matchs">总场数</label>
			<input type="number" name="matchs" id="matchs" value="${individualrank.totalmatchs}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="wins">胜场数</label>
			<input type="number" name="wins" id="wins" value="${individualrank.wins}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="marginbureau">总净胜局</label>
			<input type="number" name="marginbureau" id="marginbureau" value="${individualrank.totalmarginbureau}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="points">总积分</label>
			<input type="number" name="points" id="points" value="${individualrank.totalpoint}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="invalid">记录是否无效</label>
			<c:choose>
				<c:when test="${!individualrank.invalid}">
					<input type="radio" name="invalid" id="F" value="false" checked class=""/>有效
					<input type="radio" name="invalid" id="T" value="true" class=""/>无效
				</c:when>
				<c:otherwise>
					<input type="radio" name="invalid" id="F" value="false" class=""/>有效
					<input type="radio" name="invalid" id="T" value="true" checked class=""/>无效
				</c:otherwise>
			</c:choose>		
		</div>
		<div class="form-group">
			<label for="note">注释</label>
			<input type="text" name="note" id="note" value="${individualrank.note}" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">提交</button>
	</form>
</div>
</body>
</html>