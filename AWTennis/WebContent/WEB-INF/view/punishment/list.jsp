<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退赛扣分</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>退赛扣分</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">退赛扣分</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<form:form class="form-inline" action="list" method="post" modelAttribute="punishmentQuery">
			<div class="form-group">
				<label for="userName">用户名</label>
				<form:input path="user.name" id="userName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="entry">参赛类型</label>
				<form:select path="punishment.entry" id="entry" class="form-control">
					<form:option value="0">-请选择-</form:option>
					<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
						<form:option value="${ individualEntryType.key }">${ individualEntryType.value }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form:form>
		<hr class="hrStyle">
		<a href="<%=request.getContextPath()%>/punishment/update" title="添加个人扣分" class="btn btn-primary"><i class="fa fa-plus"></i></a>
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">个人扣分列表</h3>
			</div>
			<div class="box-body">
		 	<table id="punishment_list" class="table table-striped table-bordered">
		 		<thead>
				<tr>
				<th>#</th>
				<th>用户名</th>
				<th>赛事类型</th>
				<th>比赛时间</th>
				<th>参赛类型</th>
				<th>扣除分数</th>
				<th>注释</th>
				<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${punishmentQuerys.size()>0}">
					<c:forEach var="i" begin="0" end="${punishmentQuerys.size()-1}" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>${ punishmentQuerys[i].user.name }</td>
						<td>${ punishmentQuerys[i].tournament.name }</td>
						<td><spring:eval expression="punishmentQuerys[${i}].punishment.matchtime" /></td>
						<td>${ individualEntryTypes.get(punishmentQuerys[i].punishment.entry) }</td>
						<td>${ punishmentQuerys[i].punishment.points }</td>
						<td>${ punishmentQuerys[i].punishment.note }</td>
						<td>
							<a href="<%=request.getContextPath()%>/punishment/update?id=${punishmentQuerys[i].punishment.id}" title="修改"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/punishment/delete?id=${punishmentQuerys[i].punishment.id}" title="删除"><i class="fa fa-trash"></i></a>
						</td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
			</div><!-- /.box-body -->
		</div><!-- /.box -->
	</div>
	</section>
</div>
<script>
	$(function(){
		$("table#punishment_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>