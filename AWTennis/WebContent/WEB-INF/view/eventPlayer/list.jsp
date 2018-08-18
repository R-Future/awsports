<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../header.jsp"/>
<div class="container-fluid">
	<form:form class="form-inline" action="list" method="post" modelAttribute="tournamentQuery">
		<div class="form-group">
			<label for="activityName">赛事名称</label>
			<form:input path="tournament.name" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="arenaName">赛事地点</label>
			<form:input path="arena.name" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="startedAt">时间</label>
			<form:input path="tournament.startedat" class="form-control"/>
			-
			<label for="endedAt"></label>
			<form:input path="tournament.endedat" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-default">查询</button>
	</form:form>
	<a href="<%=request.getContextPath()%>/tournament/update">添加赛事</a>
 	<table class="table table-striped table-responsive">
		<tr>
		<td>赛事名称</td>
		<td>赛事级别</td>
		<td>赛事地点</td>
		<td>开始时间</td>
		<td>结束时间</td>
		<td>费用</td>
		<td>奖金</td>
		<td>注释</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${tournaments}" var="item">
			<tr>
			<td><a href="<%=request.getContextPath()%>/tournament/detail?id=${item.tournament.id}">${ item.tournament.name }</a></td>
			<td>${ item.tournament.level }</td>
			<td>${ item.arena.name }</td>
			<td><spring:eval expression="item.tournament.startedat" /></td>
			<td><spring:eval expression="item.tournament.endedat" /></td>
			<td><spring:eval expression="item.tournament.prize" /></td>
			<td><spring:eval expression="item.tournament.cost" /></td>
			<td>${ item.tournament.note }</td>
			<td>
				<a href="<%=request.getContextPath()%>/tournament/update?id=${item.tournament.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
				<a href="<%=request.getContextPath()%>/tournament/delete?id=${item.tournament.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
			</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="../footer.jsp"/>