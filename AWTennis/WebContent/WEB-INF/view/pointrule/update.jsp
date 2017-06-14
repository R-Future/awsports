<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
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
</body>
</html>