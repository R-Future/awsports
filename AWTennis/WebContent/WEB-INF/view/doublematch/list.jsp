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
<title>双打比赛</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<form:form class="form-inline" action="list" method="post" modelAttribute="doublematchQuery">
			<div class="col-md-12">
				<div class="form-group">
					<label for="hcTeamName">主场选手</label>
					<form:input path="hcTeamQuery.team.name" id="hcTeamName" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="apTeamName">客场选手</label>
					<form:input path="apTeamQuery.team.name" id="apTeamName" class="form-control"/>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="tournamentName">赛事名称</label>
					<form:input path="tournament.name" id="tournamentName" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="arenaName">比赛地点</label>
					<form:input path="arena.name" id="arenaName" class="form-control"/>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="startedAt">比赛时间</label>
					<form:input type="date" path="doublematch.startedat" id="startedAt" class="form-control"/>
					-
					<label for="endedAt"></label>
					<form:input type="date" path="doublematch.endedat" id="" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</div>
		</form:form>
	</div>
	
	<a href="<%=request.getContextPath()%>/doublematch/add">添加赛事</a>
	
	<div class="row">
	 	<table class="table table-striped table-responsive">
			<tr>
			<th>比赛地点</th>
			<th>比赛时间</th>
			<th>赛事名称</th>
			<th>参赛类型</th>
			<th>轮次</th>
			<th>盘数</th>
			<th>主vs客</th>
			<th>比分</th>
			<th>注释</th>
			<th>操作</th>
			</tr>
			<c:forEach items="${doublematchQuerys}" var="doublematchQuery">
				<tr>	
				<td>${ doublematchQuery.arena.name }</td>
				<td><spring:eval expression="doublematchQuery.doublematch.matchtime"/></td>
				<td>${ doublematchQuery.tournament.name }</td>
				<td>${ entryTypes.get(doublematchQuery.doublematch.entry) }</td>
				<td>${ roundTypes.get(doublematchQuery.doublematch.round) }</td>
				<td>${ doublematchQuery.doublematch.sets }</td>
				<td>${ doublematchQuery.hcTeamQuery.user1.name }&${ doublematchQuery.hcTeamQuery.user2.name } vs ${ doublematchQuery.apTeamQuery.user1.name }&${ doublematchQuery.apTeamQuery.user2.name }</td>
				<td>
					<c:forEach items="${ doublematchQuery.doublematchscores }" var="doublematchscore">
						<c:choose>
						<c:when test="${ doublematchscore.hctiescore.intValue()>0||doublematchscore.aptiescore.intValue()>0 }">
							${ doublematchscore.hcscore }(${ doublematchscore.hctiescore }):${ doublematchscore.apscore }(${ doublematchscore.aptiescore })
						</c:when>
						<c:otherwise>
							${ doublematchscore.hcscore }:${ doublematchscore.apscore }
						</c:otherwise>
						</c:choose>
					</c:forEach>
				</td>
				<td>${ doublematchQuery.doublematch.note }</td>
				<td>
					<a href="<%=request.getContextPath()%>/doublematch/update?id=${doublematchQuery.doublematch.id}">修改</a>
					<a href="<%=request.getContextPath()%>/doublematch/delete?id=${doublematchQuery.doublematch.id}">删除</a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>