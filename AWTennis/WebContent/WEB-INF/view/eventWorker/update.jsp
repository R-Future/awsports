<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作人员</title>
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
        <li><a href="<%=request.getContextPath()%>/event/detail?id=${eventWorker.eventid}">活动详细</a></li>
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
			<form class="form" action="<%=request.getContextPath()%>/eventWorker/save" method="post">
				<input type="hidden" name="id" id="id" value="${eventWorker.id}" class="form-control"/>
				<input type="hidden" name="eventid" id="eventid" value="${eventWorker.eventid}" class="form-control"/>
				
				<div class="form-group">
					<label for="username">用户名</label>
					<select id="username" name="userid" class="form-control select-chosen">
						<option value="default">-请选择-</option>
						<c:forEach items="${ userQuerys }" var="userQuery">
							<c:choose>
								<c:when test="${ eventWorker.userid.equals(userQuery.user.id) }">
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
					<label for="role">用户角色</label>
					<input type="text" name="role" id="role" value="${ eventWorker.role }" class="form-control">
				</div>
				
<%-- 				<div class="form-group">
					<label for="referee">赛场角色</label>
					<c:if test="${ eventWorker.isreferee }">
						<input type="radio" name="matchRole" id="referee" value="${eventWorker.isreferee}" class="form-control" checked/>主裁
						<input type="radio" name="matchRole" id="lineReferee" value="${ eventWorker.islinereferee }" class="form-control"/>边裁
						<input type="radio" name="matchRole" id="caddy" value="${ eventWorker.iscaddy }" class="form-control"/>球童
					</c:if>
				</div> --%>
				
				<div class="form-group">
					<label for="note">注释</label>
					<input type="text" name="note" id="note" value="${ eventWorker.note }" class="form-control"/>
				</div>
				
				<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
			</form>
		</div>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>