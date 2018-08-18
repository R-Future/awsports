<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动详细</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>${ event.name }</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="<%=request.getContextPath()%>/event/list">活动信息</a></li>
        <li class="active">${ event.name }</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div id="eventDetail" class="row">
			<table class="table table-striped table-responsive">
				<tbody>
					<tr>
					<th>活动名称</th>
					<td>${ event.name }</td>
					</tr>
					<tr>
					<th>发布者</th>
					<td>${ userPublisher.name }</td>
					</tr>
					<tr>
					<th>联系人</th>
					<td>${ userContact.name }</td>
					</tr>
					<tr>
					<th>联系方式</th>
					<td>${ userContact.phone } ${ userContact.email }</td>
					</tr>
					<tr><th>主办方</th><td> ${ event.sponsor } </td></tr>
					<tr>
					<th>活动开始时间</th>
					<td><spring:eval expression="event.starttime"/></td>
					</tr>
					<tr>
					<th>活动结束时间</th>
					<td><spring:eval expression="event.endtime"/></td>
					</tr>
					<tr>
					<th>活动报名开始时间</th>
					<td><spring:eval expression="event.enrollingtime"/></td>
					</tr>
					<tr>
					<th>活动报名结束时间</th>
					<td><spring:eval expression="event.closingtime"/></td>
					</tr>
					<tr>
					<th>活动地址</th>
					<td>${ event.place }</td>
					</tr>
					<tr>
					<th>活动人数</th>
					<td>${ event.numberofplayer }</td>
					</tr>
					<tr>
					<th>活动费用(每人)</th>
					<td><spring:eval expression="event.cost"/></td>
					</tr>
					<tr>
					<th>活动详情</th>
					<td>${ event.detail }</td>
					</tr>
					<tr>
					<th>注释</th>
					<td>${ event.note }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="addEventPlayer" class="row">
			<div class="col-md-1">
				<a href="<%=request.getContextPath()%>/eventPlayer/update?eventId=${event.id}" title="添加参赛选手" class="btn btn-info">
				添加参赛选手
				</a>
			</div>
		</div>
		<div id="eventPlayerDetail" class="row">
			<table class="table table-striped table-responsive">
				<tbody>
					<tr>
					<th>#</th>
					<th>参赛者头像</th>
					<th>参赛者名称</th>
					<th>是否退出</th>
					<th>注释</th>
					<th>操作</th>
					</tr>
					<c:if test="${ eventPlayers.size()>0 }">
						<c:forEach var="i" begin="0" end="${ eventPlayers.size()-1 }" step="1">
							<tr>
							<td>${ i+1 }</td>
							<td>${ eventPlayers[i].useravatar }</td>
							<td>${ eventPlayers[i].username }</td>
							<td>
								<c:if test="${ !eventPlayers[i].isretired }">未</c:if>退赛
							</td>
							<td>${ eventPlayers[i].note }</td>
							<td>
								<a href="<%=request.getContextPath()%>/eventPlayer/update?id=${eventPlayers[i].id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
								<a href="<%=request.getContextPath()%>/eventPlayer/delete?id=${eventPlayers[i].id}&eventId=${event.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
							</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		
		<div id="addEventWorker" class="row">
			<div class="col-md-1">
				<a href="<%=request.getContextPath()%>/eventWorker/update?eventId=${event.id}" title="添加工作人员" class="btn btn-info">
				添加工作人员
				</a>
			</div>
		</div>
		<div id="eventWorkerDetail" class="row">
			<table class="table table-striped table-responsive">
				<tbody>
					<tr>
					<th>#</th>
					<th>工作人员头像</th>
					<th>工作人员名称</th>
					<th>工作人员角色</th>
					<th>注释</th>
					<th>操作</th>
					</tr>
					<c:if test="${ eventWorkers.size()>0 }">
						<c:forEach var="i" begin="0" end="${ eventWorkers.size()-1 }" step="1">
							<tr>
							<td>${ i+1 }</td>
							<td>${ eventWorkers[i].useravatar }</td>
							<td>${ eventWorkers[i].username }</td>
							<td>${ eventWorkers[i].role }</td>
							<td>${ eventWorkers[i].note }</td>
							<td>
								<a href="<%=request.getContextPath()%>/eventWorker/update?id=${eventWorkers[i].id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
								<a href="<%=request.getContextPath()%>/eventWorker/delete?id=${eventWorkers[i].id}&eventId=${event.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
							</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		
		<c:if test='${ !event.type.equals("doublesmatch") }'>
			<div id="addSinglesMatch" class="row">
				<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/singlesMatch/update?eventId=${event.id}" title="添加比赛记录" class="btn btn-info">
					添加单打比赛
					</a>
				</div>
			</div>
			<div id="singlesMatchDetail" class="row">
				<table class="table table-striped table-responsive">
					<tbody>
						<tr>
						<th>#</th>
						<th>主场</th>
						<th>客场</th>
						<th>比分</th>
						<th>注释</th>
						<th>操作</th>
						</tr>
						<c:if test="${ singlesMatchs.size()>0 }">
							<c:forEach var="i" begin="0" end="${ singlesMatchs.size()-1 }" step="1">
								<tr>
								<td>${ i+1 }</td>
								<td>${ singlesMatchs[i].home.name }</td>
								<td>${ singlesMatchs[i].guest.name }</td>
								<td>${ singlesMatchs[i].singlesMatch.score }</td>
								<td>${ singlesMatchs[i].singlesMatch.note }</td>
								<td>
									<a href="<%=request.getContextPath()%>/singlesMatch/update?id=${singlesMatchs[i].singlesMatch.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
									<a href="<%=request.getContextPath()%>/singlesMatch/delete?id=${singlesMatchs[i].singlesMatch.id}&eventId=${event.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
									<a href="<%=request.getContextPath()%>/statistic/update?eventId=${event.id}&matchId=${singlesMatchs[i].singlesMatch.mirror}&homeId=${singlesMatchs[i].singlesMatch.homeid}&guestId=${singlesMatchs[i].singlesMatch.guestid}" title="数据统计"><i class="glyphicon glyphicon-stats"></i></a>
								</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</c:if>
		
		<c:if test='${ !event.type.equals("singlesmatch") }'>
			<div id="addDoublesMatch" class="row">
				<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/doublesMatch/update?eventId=${event.id}" title="添加比赛记录" class="btn btn-info">
					添加双打比赛
					</a>
				</div>
			</div>
			<div id="doublesMatchDetail" class="row">
				<table class="table table-striped table-responsive">
					<tbody>
						<tr>
						<th>#</th>
						<th>主场</th>
						<th>客场</th>
						<th>比分</th>
						<th>注释</th>
						<th>操作</th>
						</tr>
						<c:if test="${ doublesMatchs.size()>0 }">
							<c:forEach var="i" begin="0" end="${ doublesMatchs.size()-1 }" step="1">
								<tr>
								<td>${ i+1 }</td>
								<td>${ doublesMatchs[i].home.name }</td>
								<td>${ doublesMatchs[i].guest.name }</td>
								<td>${ doublesMatchs[i].doublesMatch.score }</td>
								<td>${ doublesMatchs[i].doublesMatch.note }</td>
								<td>
									<a href="<%=request.getContextPath()%>/doublesMatch/update?id=${doublesMatchs[i].doublesMatch.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
									<a href="<%=request.getContextPath()%>/doublesMatch/delete?id=${doublesMatchs[i].doublesMatch.id}&eventId=${event.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
									<a href="<%=request.getContextPath()%>/statistic/update?eventId=${event.id}&matchId=${doublesMatchs[i].doublesMatch.mirror}&homeId=${doublesMatchs[i].doublesMatch.homeid}&guestId=${doublesMatchs[i].doublesMatch.guestid}" title="数据统计"><i class="glyphicon glyphicon-stats"></i></a>
								</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>