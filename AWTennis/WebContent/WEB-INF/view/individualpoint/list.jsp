<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- spring自带的form表单 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人积分</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>个人积分</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">个人积分</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<form:form class="form-inline" action="list" method="post" modelAttribute="individualpointQuery">
			<div class="form-group">
				<label for="userName">用户名</label>
				<form:input type="text" path="user.name" id="userName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="entry">参赛类型</label>
				<select name="individualpoint.entry" id="entry" class="form-control">
					<option value="0">-请选择-</option>
					<c:forEach items="${ entryTypes }" var="entryType">
						<option value="${ entryType.key }">${ entryType.value }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="year">年份</label>
				<form:input type="number" path="individualpoint.year" id="year" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="week">周</label>
				<form:input type="number" path="individualpoint.week" id="week" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form:form>
		<hr class="hrStyle">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">个人积分列表</h3>
			</div>
			<div class="box-body">
		 	<table id="individualpoint_list" class="table table-striped table-bordered">
				<thead>
				<tr>
				<th>#</th>
				<th>参赛类型</th>
				<th>选手</th>
				<th>年份</th>
				<th>周</th>
				<th>总场数</th>
				<th>胜场数</th>
				<th>净胜局</th>
				<th>积分</th>
				<th>注释</th>
				<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${individualpointQuerys.size()>0}">
					<c:forEach var="i" begin="0" end="${individualpointQuerys.size()-1}" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>${ entryTypes.get(individualpointQuerys[i].individualpoint.entry) }</td>
						<td>${ individualpointQuerys[i].user.name }</td>
						<td>${ individualpointQuerys[i].individualpoint.year }</td>
						<td>${ individualpointQuerys[i].individualpoint.week }</td>
						<td>${ individualpointQuerys[i].individualpoint.matchs }</td>
						<td>${ individualpointQuerys[i].individualpoint.wins }</td>
						<td>${ individualpointQuerys[i].individualpoint.marginbureau }</td>
						<td>${ individualpointQuerys[i].individualpoint.points }</td>
						<td>${ individualpointQuerys[i].individualpoint.note }</td>
						<td>
							<a href="<%=request.getContextPath()%>/individualpoint/update?id=${individualpointQuerys[i].individualpoint.id}" title="修改"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/individualpoint/delete?id=${individualpointQuerys[i].individualpoint.id}" title="删除"><i class="fa fa-trash"></i></a>
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
		$("table#individualpoint_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>