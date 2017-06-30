<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分规则</title>
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
        <li><a href="<%=request.getContextPath()%>/tournament/list">赛事信息</a></li>
        <li><a href="<%=request.getContextPath()%>/tournament/detail?id=${pointrule.tournamentid}">赛事详细</a></li>
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
			<form class="form" action="<%=request.getContextPath()%>/pointrule/save" method="post">
				<input type="hidden" name="id" id="id" value="${pointrule.id}" class="form-control"/>
				<input type="hidden" name="tournamentid" id="tournamentid" value="${pointrule.tournamentid}" class="form-control"/>
				
				<div class="form-group">
					<label for="round">赛事轮次</label>
					<select name="round" id="round" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ roundTypes }" var="roundType">
							<c:choose>
								<c:when test="${ roungType.key.equals(pointrule.round) }">
									<option value="${ roundType.key }" selected>${ roundType.value }</option>
								</c:when>
								<c:otherwise>
									<option value="${ roundType.key }">${ roundType.value }</option>
								</c:otherwise>
							</c:choose>						
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="winner">胜者得分</label>
					<input type="number" name="winner" id="winner" value="${pointrule.winner}" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="loser">败者得分</label>
					<input type="number" name="loser" id="loser" value="${pointrule.loser}" class="form-control">
				</div>
				
				<div class="form-group">
					<label for="penalty">无故退赛扣分</label>
					<input type="number" name="penalty" id="penalty" value="${pointrule.penalty}" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="note">注释</label>
					<input type="text" name="note" id="note" value="${pointrule.note}" class="form-control"/>
				</div>
				
				<button type="submit" class="btn btn-default">提交</button>
			</form>
		</div>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>