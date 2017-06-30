<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛事详细</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>${ tournamentQuery.tournament.name }</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="<%=request.getContextPath()%>/tournament/list">赛事信息</a></li>
        <li class="active">${ tournamentQuery.tournament.name }</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div id="tournamentDetail" class="row">
			<table class="table table-striped table-responsive">
				<tbody>
					<tr>
					<th>赛事名称</th>
					<td>${ tournamentQuery.tournament.name }</td>
					</tr>
					<tr>
					<th>赛事开始时间</th>
					<td><spring:eval expression="tournamentQuery.tournament.startedat"/></td>
					</tr>
					<tr>
					<th>赛事结束时间</th>
					<td><spring:eval expression="tournamentQuery.tournament.endedat"/></td>
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
			<div class="col-md-1">
				<a href="<%=request.getContextPath()%>/pointrule/update?tournamentid=${tournamentQuery.tournament.id}" title="添加积分规则" class="btn btn-info">
				添加积分规则
				</a>
			</div>
		</div>
		<div id="pointruleDetail" class="row">
			<table class="table table-striped table-responsive">
				<tbody>
					<tr>
					<th>#</th>
					<th>轮次</th>
					<th>胜者得分</th>
					<th>败者得分</th>
					<th>无故退赛扣分</th>
					<th>注释</th>
					<th>操作</th>
					</tr>
					<c:if test="${ pointrules.size()>0 }">
						<c:forEach var="i" begin="0" end="${ pointrules.size()-1 }" step="1">
							<tr>
							<td>${ i+1 }</td>
							<td>${ roundTypes.get(pointrules[i].round) }</td>
							<td>${ pointrules[i].winner }</td>
							<td>${ pointrules[i].loser }</td>
							<td>${ pointrules[i].penalty }</td>
							<td>${ pointrules[i].note }</td>
							<td>
								<a href="<%=request.getContextPath()%>/pointrule/update?id=${pointrules[i].id}" title="修改"><i class="fa fa-edit"></i></a>
								<a href="<%=request.getContextPath()%>/pointrule/delete?id=${pointrules[i].id}&tournamentid=${tournamentQuery.tournament.id}" title="删除"><i class="fa fa-trash"></i></a>
							</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>