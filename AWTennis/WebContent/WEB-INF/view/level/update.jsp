<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>俱乐部等级</title>
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
        <li><a href="<%=request.getContextPath()%>/level/list">俱乐部等级列表</a></li>
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
		<form class="form" action="<%=request.getContextPath()%>/level/save" method="post">
			<input type="hidden" name="id" id="id" value="${level.id}" class="form-control"/>
			<div class="form-group">
				<label for="parent">所属类别</label>
				<select name="parent" id="parent" class="form-control">
					<option value="default">-请选择-</option>
					<c:choose>
						<c:when test="${ level.parent.intValue()==0 }">
							<option value="0" selected="selected">无</option>
						</c:when>
						<c:otherwise>
							<option value="0">无</option>
						</c:otherwise>
					</c:choose>
					<c:forEach items="${ levels }" var="parent">
						<c:choose>
							<c:when test="${ parent.id.equals(level.parent) }">
								<option value="${ parent.id }" selected="selected">${ parent.chinese }(${ parent.english })</option>
							</c:when>
							<c:otherwise>
								<option value="${ parent.id }">${ parent.chinese }(${ parent.english })</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="chinese">中文描述</label>
				<input type="text" name="chinese" id="chinese" value="${level.chinese}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="english">英文描述</label>
				<input type="text" name="english" id="english" value="${level.english}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="note">注释</label>
				<input type="text" name="note" id="note" value="${level.note}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="invalid">是否有效:</label>
				<c:choose>
					<c:when test="${ !level.invalid.booleanValue() }">
						<input type="radio" name="invalid" id="F" value="false" checked/>有效
						<input type="radio" name="invalid" id="T" value="true"/>无效
					</c:when>
					<c:otherwise>
						<input type="radio" name="invalid" id="F" value="false"/>有效
						<input type="radio" name="invalid" id="T" value="true" checked/>无效
					</c:otherwise>
				</c:choose>
			</div>
			<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
		</form>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>