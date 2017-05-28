<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
	<form class="form" action="<%=request.getContextPath()%>/tournament/save" method="post">
		<input type="hidden" name="id" id="id" value="${tournament.id}" class="form-control"/>
		
		<div class="form-group">
			<label for="name">赛事名称</label>
			<input type="text" name="name" id="name" value="${tournament.name}" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="level">赛事级别</label>
			<input type="text" name="level" id="level" value="${tournament.level}" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="arenaId">赛事地点</label>
			<select name="arenaId" id="arenaId">
				<option>-请选择-</option>
				<c:forEach items="${arenas}" var="arena">
					<c:choose>
						<c:when test="${arena.id.equals(tournament.arenaid)}">
							<option value="${arena.id}" selected="selected">${arena.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${arena.id}">${arena.name}</option>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
			</select>
		</div>
		
		<div class="form-group">
			<label for="startedat">开始时间</label>
			<input type="text" name="startedat" id="startedat" value="${tournament.startedat}" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="endedat">结束时间</label>
			<input type="text" name="endedat" id="endedat" value="${tournament.endedat}" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="prize">赛事奖金</label>
			<input type="text" name="prize" id="prize" value="${tournament.prize}" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="cost">比赛费用(每人)</label>
			<input type="text" name="cost" id="cost" value="${tournament.cost}" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="note">注释</label>
			<input type="text" name="note" id="note" value="${tournament.note}" class="form-control"/>
		</div>
		
		<button type="submit" class="btn btn-default">提交</button>
	</form>
	
</div>
</body>
</html>