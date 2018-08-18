<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比赛记录</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1><jsp:include page="../breadcrumb.jsp"/></h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="<%=request.getContextPath()%>/event/list">活动信息</a></li>
        <li><a href="<%=request.getContextPath()%>/event/detail?id=${singlesMatch.eventid}">活动详细</a></li>
        <li class="active"><jsp:include page="../breadcrumb.jsp"/></li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="row" style="color:red">
			<c:if test="${errors!=null}">
				<c:forEach items="${errors.allErrors}" var="error">
					${error.defaultMessage}<br/>
				</c:forEach>
			</c:if>
		</div>
		
		<div class="row">
			<form class="form" action="<%=request.getContextPath()%>/singlesMatch/save" method="post">
				<input type="hidden" name="id" id="id" value="${singlesMatch.id}" class="form-control"/>
				<input type="hidden" name="eventid" id="eventid" value="${singlesMatch.eventid}" class="form-control"/>
				
				<div class="form-group">
					<label for="type">比赛类型</label>
					<input type="text" name="type" id="type" value="singlesmatch" disabled class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="round">比赛轮次</label>
					<select id="round" name="round" class="form-control">
						<option value="group" selected>小组赛</option>
						<option value="last128">1/128</option>
						<option value="last64">1/64</option>
						<option value="last32">1/32</option>
						<option value="last16">1/16</option>
						<option value="quaterfinal">1/8</option>
						<option value="semifinal">半决赛</option>
						<option value="final">决赛</option>
					</select>
				</div>
				
				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="homeid">主场</label>
							<select id="homeid" name="homeid" class="form-control select-chosen">
								<option value="default">-请选择-</option>
								<c:forEach items="${ players }" var="player">
									<c:choose>
										<c:when test="${ singlesMatch.homeid.equals(player.userid) }">
											<option value="${ player.userid }" selected>${ player.username }</option>
										</c:when>
										<c:otherwise>
											<option value="${ player.userid }">${ player.username }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-6">
							<label for="guestid">客场</label>
							<select id="guestid" name="guestid" class="form-control select-chosen">
								<option value="default">-请选择-</option>
								<c:forEach items="${ players }" var="player">
									<c:choose>
										<c:when test="${ singlesMatch.guestid.equals(player.userid) }">
											<option value="${ player.userid }" selected>${ player.username }</option>
										</c:when>
										<c:otherwise>
											<option value="${ player.userid }">${ player.username }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="score">比分</label>
					<input type="text" id="score" name="score" value="${ singlesMatch.score }" class="form-control">
				</div>
				
				<div class="form-group">
					<div class='row'>
						<div class="col-md-6">
							<label for="ishomeretired">主场退赛</label>
							<c:choose>
								<c:when test="${ singlesMatch.ishomeretired }">
									<input type="radio" name="ishomeretired" id="ishomeretiredT" value="true" checked>是
									<input type="radio" name="ishomeretired" id="ishomeretiredF" value="false">否
								</c:when>
								<c:otherwise>
									<input type="radio" name="ishomeretired" id="ishomeretiredT" value="true">是
									<input type="radio" name="ishomeretired" id="ishomeretiredF" value="false" checked>否
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-6">
							<label for="isguestretired">客场退赛</label>
							<c:choose>
								<c:when test="${ singlesMatch.isguestretired }">
									<input type="radio" name="isguestretired" id="isguestretiredT" value="true" checked>是
									<input type="radio" name="isguestretired" id="isguestretiredF" value="false">否
								</c:when>
								<c:otherwise>
									<input type="radio" name="isguestretired" id="isguestretiredT" value="true">是
									<input type="radio" name="isguestretired" id="isguestretiredF" value="false" checked>否
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="homepoint">主场得分</label>
							<input type="number" name="homepoint" id="homepoint" value="${singlesMatch.homepoint}"  min="0" class="form-control"/>
						</div>
						<div class="col-md-6">
							<label for="guestpoint">客场得分</label>
							<input type="number" name="guestpoint" id="guestpoint" value="${singlesMatch.guestpoint}" min="0" class="form-control"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class='row'>
						<div class="col-md-6">
							<div class="form-group">
								<label for="ishomewin">主场胜</label>
								<c:choose>
									<c:when test="${ singlesMatch.ishomewin }">
										<input type="radio" name="ishomewin" id="ishomewinT" value="true" checked>是
										<input type="radio" name="ishomewin" id="ishomewinF" value="false">否
									</c:when>
									<c:otherwise>
										<input type="radio" name="ishomewin" id="ishomewinT" value="true">是
										<input type="radio" name="ishomewin" id="ishomewinF" value="false" checked>否
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="invalid">比赛无效</label>
								<c:choose>
									<c:when test="${ singlesMatch.invalid }">
										<input type="radio" name="invalid" id="invalidT" value="true" checked>是
										<input type="radio" name="invalid" id="invalidF" value="false">否
									</c:when>
									<c:otherwise>
										<input type="radio" name="invalid" id="invalidT" value="true">是
										<input type="radio" name="invalid" id="invalidF" value="false" checked>否
									</c:otherwise>
								</c:choose>
							</div>
						</div>						
					</div>
				</div>
				
				<div class="form-group">
					<label for="note">注释</label>
					<input type="text" name="note" id="note" value="${singlesMatch.note}" class="form-control"/>
				</div>
				
				<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
			</form>
		</div>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>