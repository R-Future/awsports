<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
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
	        <li><a href="<%=request.getContextPath()%>/user/list">个人信息</a></li>
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
			<form:form action="save" method="post" modelAttribute="user">
				<input type="hidden" name="id" id="id" value="${user.id}" class="form-control"/>
				<fieldset>
					<legend><font>基本信息</font></legend>
					<div class="row">
						<div class="form-group col-md-3">
							<label for="name">用户名</label>
							<input type="text" name="name" id="name" value="${user.name}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="password">密码</label>
							<input type="text" name="password" id="password" value="${user.password}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="nickname">昵称</label>
							<input type="text" name="nickname" id="nickname" value="${user.nickname}" class="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-3">
							<label for="realname">真实姓名</label>
							<input type="text" name="realname" id="realname" value="${user.realname}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="idcard">身份证号</label>
							<input type="text" name="idcard" id="idcard" value="${user.idcard}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="phone">电话号码</label>
							<input type="text" name="phone" id="phone" value="${user.phone}" class="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-3">
							<label for="email">邮箱</label>
							<input type="text" name="email" id="email" value="${user.email}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="address">住址</label>
							<input type="text" name="address" id="address" value="${user.address}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="portrait">头像</label>
							<input type="text" name="portrait" id="portrait" value="${user.portrait}" class="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-3">
							<label for="sex">性别</label>
							<!-- Boolean比较用compareTo()方法，相等则返回0，不想等若参数为false则返回1，参数为true则返回-1 -->
							<c:forEach items="${ sexTypes }" var="sexType">
								<c:choose>
									<c:when test="${ sexType.key.equals(user.sex) }">
										<form:radiobutton path="sex" value="${ sexType.key }" check="true"/>${ sexType.value }
									</c:when>
									<c:otherwise>
										<form:radiobutton path="sex" value="${ sexType.key }"/>${ sexType.value }
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend><font>球员信息</font></legend>

					<div class="row">
						<div class="form-group col-md-3">
							<label for="height">身高(cm)</label>
							<input type="text" name="height" id="height" value="${user.height}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="weight">体重(kg)</label>
							<input type="text" name="weight" id="weight" value="${user.weight}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="playedyears">球龄(年)</label>
							<input type="text" name="playedyears" id="playedyears" value="${user.playedyears}" class="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-3">
							<label for="level">网球水平</label>
							<input type="text" name="level" id="level" value="${user.level}" class="form-control"/>
						</div>
						
						<div class="form-group col-md-3">
							<label for="forehand">正手</label>
							<select id="forehand" name="forehand" class="form-control">
								<option value="default">-请选择-</option>
								<c:forEach items="${ forehandTypes }" var="forehandType">
									<c:choose>
										<c:when test="${ forehandType.key.equals(user.forehand) }">
											<option value="${ forehandType.key }" selected="selected">${ forehandType.value }</option>
										</c:when>
										<c:otherwise>
											<option value="${ forehandType.key }">${ forehandType.value }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="backhand">反手</label>
							<select id="backhand" name="backhand" class="form-control">
								<option value="default">-请选择-</option>
								<c:forEach items="${ backhandTypes }" var="backhandType">
									<c:choose>
										<c:when test="${ backhandType.key.equals(user.backhand) }">
											<option value="${ backhandType.key }" selected>${ backhandType.value }</option>
<%-- 											<form:radiobutton path="backhand" value="${ backhandType.key }" check="true"/>${ backhandType.value } --%>
										</c:when>
										<c:otherwise>
											<option value="${ backhandType.key }">${ backhandType.value }</option>
<%-- 											<form:radiobutton path="backhand" value="${ backhandType.key }" />${ backhandType.value } --%>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-3">
							<label for="grade">俱乐部等级</label>
							<select name="grade" id="grade" class="form-control">
								<option value="default">-请选择-</option>
								<c:forEach items="${ levels }" var="level">
									<c:choose>
										<c:when test="${ level.id.equals(user.grade) }">
											<option value="${ level.id }" selected>${ level.chinese }</option>
										</c:when>
										<c:otherwise>
											<option value="${ level.id }">${ level.chinese }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="singletitles">单打冠军数</label>
							<input type="number" name="singletitles" id="singletitles" value="${user.singletitles}" class="form-control"/>
						</div>
						<div class="form-group col-md-3">
							<label for="doubletitles">双打冠军数</label>
							<input type="number" name="doubletitles" id="doubletitles" value="${user.doubletitles}" class="form-control"/>
						</div>
					</div>
				</fieldset>
				<button type="submit" class="btn btn-default">提交</button>
			</form:form>
		</div>
		</section>
	</div>
<jsp:include page="../footer.jsp"/>