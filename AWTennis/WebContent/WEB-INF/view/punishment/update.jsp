<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="row" style="color:red">
		<c:if test="${errors!=null}">
			<c:forEach items="${errors.allErrors}" var="error">
				${error.defaultMessage}<br/>
			</c:forEach>
		</c:if>
	</div>
	
	<div class="row">
		<form class="form" action="<%=request.getContextPath()%>/punishment/save" method="post">
			<input type="hidden" name="id" id="id" value="${punishment.id}" class="form-control"/>
			
			<div class="form-group">
				<label for="userid">用户名</label>
				<select name="userid" id="userid" class="form-control">
					<option value="default">-请选择-</option>
					<c:forEach items="${ users }" var="user">
						<c:choose>
							<c:when test="${ user.id.equals(punishment.userid) }">
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
				<label for="tournamentid">赛事类型</label>
				<select name="tournamentid" id="tournamentid" class="form-control">
					<option value="default">-请选择-</option>
					<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
						<c:choose>
							<c:when test="${ tournamentQuery.tournament.id.equals(punishment.tournamentid) }">
								<option value="${ tournamentQuery.tournament.id }" selected>${ tournamentQuery.tournament.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${ tournamentQuery.tournament.id }">${ tournamentQuery.tournament.name }</option>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="matchtime">比赛时间</label>
				<input type="date" name="matchtime" id="matchtime" value="<fmt:formatDate value="${ punishment.matchtime }" pattern="yyyy-MM-dd"/>" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="entry">参赛类型</label>
				<select name="entry" id="entry" class="form-control">
					<option value="default">-请选择-</option>
					<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
						<c:choose>
							<c:when test="${ individualEntryType.key.equals(punishment.entry) }">
								<option value="${ individualEntryType.key }" selected>${ individualEntryType.value }</option>
							</c:when>
							<c:otherwise>
								<option value="${ individualEntryType.key }">${ individualEntryType.value }</option>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="points">扣除分数</label>
				<input type="number" name="points" id="points" value="${punishment.points}" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="invalid">是否有效</label>
				<c:choose>
					<c:when test="${ punishment.invalid.booleanValue() }">
						<input type="radio" name="invalid" id="invalidF" value="false"/>有效
						<input type="radio" name="invalid" id="invalidT" value="true" checked/>无效						
					</c:when>
					<c:otherwise>
						<input type="radio" name="invalid" id="invalidF" value="false" checked/>有效
						<input type="radio" name="invalid" id="invalidT" value="true"/>无效
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="form-group">
				<label for="note">注释</label>
				<input type="text" name="note" id="note" value="${punishment.note}" class="form-control"/>
			</div>
			
			<button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
	
	
</div>
</body>
</html>