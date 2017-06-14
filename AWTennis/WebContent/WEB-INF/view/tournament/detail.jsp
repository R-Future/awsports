<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<div class="row">
		<a href="<%=request.getContextPath()%>/tournament/list">返回赛事列表</a>
	</div>
	<div id="tournamentDetail" class="row">
		<table class="table table-striped table-responsive">
			<tbody>
				<tr>
				<th>赛事名称</th>
				<td>${ tournamentQuery.tournament.name }</td>
				</tr>
				<tr>
				<th>赛事开始时间</th>
				<td>${ tournamentQuery.tournament.startedat }</td>
				</tr>
				<tr>
				<th>赛事结束时间</th>
				<td>${ tournamentQuery.tournament.endedat }</td>
				</tr>
				<tr>
				<th>赛事地址</th>
				<td>${ tournamentQuery.arena.name }</td>
				</tr>
				<tr>
				<th>赛事级别</th>
				<td>${ tournamentQuery.tournament.level }</td>
				</tr>
				<tr>
				<th>赛事奖金</th>
				<td>${ tournamentQuery.tournament.prize }</td>
				</tr>
				<tr>
				<th>比赛费用(每人)</th>
				<td><spring:eval expression="tournamentQuery.tournament.cost"/></td>
				</tr>
				<tr>
				<th>注释</th>
				<td>${ tournamentQuery.tournament.note }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="addPointrule" class="row">
		<a href="<%=request.getContextPath()%>/pointrule/update?tournamentid=${tournamentQuery.tournament.id}" title="添加积分规则">
		添加积分规则
		</a>
	</div>
	<div id="pointruleDetail" class="row">
		<table class="table table-striped table-responsive">
			<tbody>
				<tr>
				<th>轮次</th>
				<th>胜者得分</th>
				<th>败者得分</th>
				<th>无理由退赛扣分</th>
				<th>注释</th>
				<th>操作</th>
				</tr>
				<c:forEach items="${ pointrules }" var="pointrule">
					<tr>
					<td>${ roundTypes.get(pointrule.round) }</td>
					<td>${ pointrule.winner }</td>
					<td>${ pointrule.loser }</td>
					<td>${ pointrule.penalty }</td>
					<td>${ pointrule.note }</td>
					<td>
						<a href="<%=request.getContextPath()%>/pointrule/update?id=${pointrule.id}" title="修改">修改</a>
						<a href="<%=request.getContextPath()%>/pointrule/delete?id=${pointrule.id}&tournamentid=${tournamentQuery.tournament.id}" title="删除">删除</a>
					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>