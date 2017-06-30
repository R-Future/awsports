<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组合排名</title>
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
        <li><a href="<%=request.getContextPath()%>/teamrank/list">组合排名列表</a></li>
        <li class="active"><jsp:include page="../breadcrumb.jsp"/></li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="" style="color:red">
			<c:if test="${errors!=null}">
				<c:forEach items="${errors.allErrors}" var="error">
					${error.defaultMessage}<br/>
				</c:forEach>
			</c:if>
		</div>
		<form class="form" action="<%=request.getContextPath()%>/teamrank/save" method="post">
			<input type="hidden" name="id" id="id" value="${teamrank.id}" class="form-control"/>
			<div class="form-group">
				<label for="teamName">用户名</label>
				<select name="name" id="teamName" class="form-control">
					<option>-请选择-</option>
					<c:forEach items="${ teamQuerys }" var="teamQuery">
						<c:choose>
							<c:when test="${ teamQuery.team.id.equals(teamrank.teamid) }">
								<option value="${ teamQuery.team.id }" selected>${ teamQuery.team.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="entry">参赛类型</label>
				<select id="entry" name="entry" class="form-control">
					<option>-请选择-</option>
					<c:forEach items="${teamEntryTypes}" var="teamEntryType">
						<c:choose>
							<c:when test="${teamEntryType.key.equals(teamrank.entry)}">
								<option value="${teamEntryType.key}" selected="selected">${teamEntryType.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${teamEntryType.key}">${teamEntryType.value}</option>
							</c:otherwise>
						</c:choose>	
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="year">当前排名</label>
				<input type="number" name="year" id="year" value="${teamrank.currentrank}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="matchs">总场数</label>
				<input type="number" name="matchs" id="matchs" value="${teamrank.totalmatchs}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="wins">胜场数</label>
				<input type="number" name="wins" id="wins" value="${teamrank.wins}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="marginbureau">总净胜局</label>
				<input type="number" name="marginbureau" id="marginbureau" value="${teamrank.totalmarginbureau}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="points">总积分</label>
				<input type="number" name="points" id="points" value="${teamrank.totalpoint}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="invalid">记录是否无效</label>
				<c:choose>
					<c:when test="${!teamrank.invalid}">
						<input type="radio" name="invalid" id="F" value="false" checked class=""/>有效
						<input type="radio" name="invalid" id="T" value="true" class=""/>无效
					</c:when>
					<c:otherwise>
						<input type="radio" name="invalid" id="F" value="false" class=""/>有效
						<input type="radio" name="invalid" id="T" value="true" checked class=""/>无效
					</c:otherwise>
				</c:choose>		
			</div>
			<div class="form-group">
				<label for="note">注释</label>
				<input type="text" name="note" id="note" value="${teamrank.note}" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>