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
	<form class="form" action="<%=request.getContextPath()%>/arena/save" method="post">
		<input type="hidden" name="id" id="id" value="${arena.id}" class="form-control"/>
		<div class="form-group">
			<label for="name">场馆名称</label>
			<input type="text" name="name" id="name" value="${arena.name}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="address">场馆地址</label>
			<input type="text" name="address" id="address" value="${arena.address}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="type">场馆类型</label>
			<select name="type" id="type">
				<option value="default">-请选择-</option>
				<c:forEach items="${ arenaTypes }" var="arenaType">
					<c:choose>
						<c:when test="${ arenaType.key。equals(arena.type) }">
							<option value="${ arenaType.key }" selected="selected">${ arenaType.value }</option>
						</c:when>
						<c:otherwise>
							<option value="${ arenaType.key }">${ arenaType.value }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="indoornumber">室内场地数</label>
			<input type="text" name="indoornumber" id="indoornumber" value="${arena.indoornumber}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="outdoornumber">室外场地数</label>
			<input type="text" name="outdoornumber" id="outdoornumber" value="${arena.outdoornumber}" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="note">注释</label>
			<input type="text" name="note" id="note" value="${arena.note}" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">提交</button>
	</form>
</div>
</body>
</html>