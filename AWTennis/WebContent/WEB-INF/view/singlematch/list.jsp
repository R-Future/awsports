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
<title>单打比赛</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<form:form class="form-inline" action="list" method="post" modelAttribute="singlematchQuery">
			<div class="col-md-12">
				<div class="form-group">
					<label for="user1">主场选手</label>
					<form:input path="user1.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="user2">客场选手</label>
					<form:input path="user2.name" class="form-control"/>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="tournamentName">赛事名称</label>
					<form:input path="tournament.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="arenaName">比赛地点</label>
					<form:input path="arena.name" class="form-control"/>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="startedAt">比赛时间</label>
					<form:input type="date" path="singlematch.startedat" class="form-control"/>
					-
					<label for="endedAt"></label>
					<form:input type="date" path="singlematch.endedat" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</div>
		</form:form>
	</div>
	
	<a href="<%=request.getContextPath()%>/singlematch/add">添加赛事</a>
	
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
			<c:forEach items="${singlematchs}" var="item">
				<tr>	
				<td>${ item.arena.name }</td>
				<td><spring:eval expression="item.singlematch.matchtime"/></td>
				<td>${ item.tournament.name }</td>
				<td>${ entryTypes.get(item.singlematch.entry) }</td>
				<td>${ roundTypes.get(item.singlematch.round) }</td>
				<td>${ item.singlematch.sets }</td>
				<td>${ item.user1.name } vs ${ item.user2.name }</td>
				<td>
					<c:forEach items="${ item.singlematchscores }" var="singlematchscore">
						<c:choose>
						<c:when test="${ singlematchscore.hctiescore.intValue()>0||singlematchscore.aptiescore.intValue()>0 }">
							${ singlematchscore.hcscore }(${ singlematchscore.hctiescore }):${ singlematchscore.apscore }(${ singlematchscore.aptiescore })
						</c:when>
						<c:otherwise>
							${ singlematchscore.hcscore }:${ singlematchscore.apscore }
						</c:otherwise>
						</c:choose>
					</c:forEach>
				</td>
				<td>${ item.singlematch.note }</td>
				<td>
					<a href="<%=request.getContextPath()%>/singlematch/update?id=${item.singlematch.id}">修改</a>
					<a href="<%=request.getContextPath()%>/singlematch/delete?id=${item.singlematch.id}">删除</a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>