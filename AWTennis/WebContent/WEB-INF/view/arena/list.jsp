<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>场馆信息</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>场馆信息</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">场馆信息</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<form class="form-inline" action="<%=request.getContextPath()%>/arena/list" method="post">
			<div class="form-group">
				<label for="name">场馆名称</label>
				<input type="text" name="name" id="name" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="address">场馆地址</label>
				<input type="text" name="address" id="address" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="type">场馆类型</label>
				<select name="type" id="type" class="form-control">
					<option value="default">-请选择-</option>
					<c:forEach items="${arenaTypes}" var="arenaType">
						<option value="${arenaType.key}">${arenaType.value}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form>
		<hr class="hrStyle">
		<a href="<%=request.getContextPath()%>/arena/update" title="添加活动" class="btn btn-primary"><i class="fa fa-plus"></i></a>
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">场馆列表</h3>
			</div>
			<div class="box-body">
		 	<table id="arena_list" class="table table-striped table-bordered">
		 		<thead>
				<tr>
				<th>#</th>
				<th>场馆名称</th>
				<th>场馆地址</th>
				<th>场馆类型</th>
				<th>室内场地数</th>
				<th>室外场地数</th>
				<th>注释</th>
				<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${arenas.size()>0}">
					<c:forEach var="i" begin="0" end="${arenas.size()-1}" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>${ arenas[i].name }</td>
						<td>${ arenas[i].address }</td>
						<td>${ arenaTypes.get(arenas[i].type) }</td>
						<td>${ arenas[i].indoornumber }</td>
						<td>${ arenas[i].outdoornumber }</td>
						<td>${ arenas[i].note }</td>
						<td>
							<a href="<%=request.getContextPath()%>/arena/update?id=${arenas[i].id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/arena/delete?id=${arenas[i].id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
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
		$("table#arena_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>