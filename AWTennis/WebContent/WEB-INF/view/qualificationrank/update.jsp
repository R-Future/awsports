<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资格赛个人排名</title>
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
        <li><a href="<%=request.getContextPath()%>/qualificationrank/list">资格赛个人排名列表</a></li>
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
		<form class="form" action="<%=request.getContextPath()%>/qualificationrank/save" method="post">
			<input type="hidden" name="id" id="id" value="${qualificationrank.id}" class="form-control"/>
			<div class="form-group">
				<label for="userName">用户名</label>
				<select name="name" id="userName" class="form-control">
					<option>-请选择-</option>
					<c:forEach items="${ userQuerys }" var="userQuery">
						<c:choose>
							<c:when test="${ userQuery.user.id.equals(qualificationrank.userid) }">
								<option value="${ userQuery.user.id }" selected>${ userQuery.user.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${ userQuery.user.id }">${ userQuery.user.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="tournamentid">参赛类型</label>
				<select id="tournamentid" name="tournamentid" class="form-control">
					<option>-请选择-</option>
					<c:forEach items="${tournamentQuerys}" var="tournamentQuery">
						<c:choose>
							<c:when test="${tournamentQuery.tournament.id.equals(qualificationrank.tournamentid)}">
								<option value="${tournamentQuery.tournament.id}" selected="selected">${tournamentQuery.tournament.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${tournamentQuery.tournament.id}">${tournamentQuery.tournament.name}</option>
							</c:otherwise>
						</c:choose>	
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="currentrank">当前排名</label>
				<input type="number" name="currentrank" id="currentrank" value="${qualificationrank.currentrank}" class="form-control"/>
			</div>
	<!-- 		<div class="form-group"> -->
	<!-- 			<label for="year">年份</label> -->
	<%-- 			<input type="number" name="year" id="year" value="${qualificationrank.year}" class="form-control"/> --%>
	<!-- 		</div> -->
	<!-- 		<div class="form-group"> -->
	<!-- 			<label for="week">周</label> -->
	<%-- 			<input type="number" name="week" id="week" value="${qualificationrank.week}" class="form-control"/> --%>
	<!-- 		</div> -->
			<div class="form-group">
				<label for="totalmatchs">总场数</label>
				<input type="number" name="totalmatchs" id="totalmatchs" value="${qualificationrank.totalmatchs}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="totalwins">胜场数</label>
				<input type="number" name="totalwins" id="totalwins" value="${qualificationrank.totalwins}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="totalmarginbureau">总净胜局</label>
				<input type="number" name="totalmarginbureau" id="totalmarginbureau" value="${qualificationrank.totalmarginbureau}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="totalpoint">总积分</label>
				<input type="number" name="totalpoint" id="totalpoint" value="${qualificationrank.totalpoint}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="invalid">记录是否无效</label>
				<c:choose>
					<c:when test="${!qualificationrank.invalid}">
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
				<input type="text" name="note" id="note" value="${qualificationrank.note}" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
		</form>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>