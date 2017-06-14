<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="../resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../resources/js/conjunction.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="" style="color:red">
		<c:if test="${errors!=null}">
			<c:forEach items="${errors.allErrors}" var="error">
				${error.defaultMessage}<br/>
			</c:forEach>
		</c:if>
	</div>
	
	<form class="form" action="<%=request.getContextPath()%>/team/save" method="post">
		<input type="hidden" name="id" id="id" value="${team.id}" class="form-control"/>
		
		<div class="form-group">
			<label for="user1">队员1</label>
<!-- 			<input type="text" name="team.user1id" id="user1" onkeyup="getLinkData(this)" class="form-control"/> -->
<!-- 			<div id="popup" class=""> -->
<!-- 				<table class=""> -->
<!-- 					<tbody id="popupBody"></tbody> -->
<!-- 				</table> -->
<!-- 			</div> -->
			<select name="user1id" id="user1" class="form-control">
				<c:forEach items="${ users }" var="user">
					<c:choose>
						<c:when test="${ user.getId().equals(team.user1id) }">
							<option value="${ user.getId() }" selected="selected">${ user.getName() }</option>
						</c:when>
						<c:otherwise>
							<option value="${ user.getId() }">${ user.getName() }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>				
			</select>
		</div>
		
		<div class="form-group">
			<label for="user2">队员2</label>
<!-- 			<input type="text" name="team.user2id" id="user2" onkeyup="getLinkData(this)" class="form-control"/> -->
<!-- 			<div class=""><table class=""><tbody></tbody></table></div> -->
			<select name="user2id" id="user2" class="form-control">
				<c:forEach items="${ users }" var="user">
					<c:choose>
						<c:when test="${ user.getId().equals(team.user2id) }">
							<option value="${ user.getId() }" selected="selected">${ user.getName() }</option>
						</c:when>
						<c:otherwise>
							<option value="${ user.getId() }">${ user.getName() }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>				
			</select>
		</div>		
		
		<div class="form-group">
			<label for="startedat">开始时间</label>
			<input type="date" name="startedat" id="startedat" value="<fmt:formatDate value="${ team.startedat }" pattern="yyyy-MM-dd"/>" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="note">注释</label>
			<input type="text" name="note" id="note" value="${team.note}" class="form-control"/>
		</div>
		
		<button type="submit" class="btn btn-default">提交</button>
	</form>
	
</div>
</body>
</html>