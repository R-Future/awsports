<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- spring自带的form表单 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组合排名</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>组合排名</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">组合排名</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="">
		<fieldset>
			<legend>查询</legend>
			<form:form class="form-inline" action="list" method="post" modelAttribute="teamrankQuery">
				<div class="form-group">
					<label for="teamName">用户名</label>
					<form:input type="text" path="team.name" id="teamName" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="entry">参赛类型</label>
					<form:select path="teamrank.entry" id="entry" class="form-control">
						<form:option value="0">-请选择-</form:option>
						<c:forEach items="${ teamEntryTypes }" var="teamEntryType">
							<form:option value="${ teamEntryType.key }">${ teamEntryType.value }</form:option>
						</c:forEach>
					</form:select>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form:form>
		</fieldset>
		</div>
		
		<div class="entry">
			<fieldset>
				<legend><font>更新排名</font></legend>
				<c:forEach items="${ teamEntryTypes }" var="teamEntryType">
					<input type="checkbox" name="entrys" value="${ teamEntryType.key }" checked>${ teamEntryType.value }
				</c:forEach>
				<a href="javascript:void(0)" id="update" title="更新排名" class="btn btn-primary"><i class="fa fa-refresh"></i></a>
			</fieldset>
		</div>
		<hr class="hrStyle"/>
		<div class="add">
			<a href="<%=request.getContextPath()%>/teamrank/update" title="添加组合排名" class="btn btn-primary"><i class="fa fa-plus"></i></a>
		</div>
		
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">组合排名列表</h3>
			</div>
			<div class="box-body">
			 	<table id="teamrank_list" class="table table-striped table-bordered">
			 		<thead>
					<tr>
					<th>#</th>
					<th>参赛类型</th>
					<th>当前排名</th>
					<th>选手</th>
					<th>总积分</th>
					<th>总场数</th>
					<th>胜场数</th>
					<th>胜率</th>
					<th>净胜局</th>	
					<th>年份</th>
					<th>周</th>
					<th>注释</th>
					<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<c:if test="${teamrankQuerys.size()>0}">
						<c:forEach var="i" begin="0" end="${ teamrankQuerys.size()-1 }" step="1">
							<tr>
							<td>${ i+1 }</td>
							<td>${ teamEntryTypes.get(teamrankQuerys[i].teamrank.entry) }</td>
							<td>${ teamrankQuerys[i].teamrank.currentrank }</td>
							<td>${ teamrankQuerys[i].team.name }</td>
							<td>${ teamrankQuerys[i].teamrank.totalpoint }</td>
							<td>${ teamrankQuerys[i].teamrank.totalmatchs }</td>
							<td>${ teamrankQuerys[i].teamrank.wins }</td>
							<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${ teamrankQuerys[i].teamrank.wins/teamrankQuerys[i].teamrank.totalmatchs }"/></td>
							<td>${ teamrankQuerys[i].teamrank.totalmarginbureau }</td>
							<td>${ teamrankQuerys[i].teamrank.year }</td>
							<td>${ teamrankQuerys[i].teamrank.week }</td>
							<td>${ teamrankQuerys[i].teamrank.note }</td>
							<td>
								<a href="<%=request.getContextPath()%>/teamrank/update?id=${teamrankQuerys[i].teamrank.id}" title="修改"><i class="fa fa-edit"></i></a>
								<a href="<%=request.getContextPath()%>/teamrank/delete?id=${teamrankQuerys[i].teamrank.id}" title="删除"><i class="fa fa-trash"></i></a>
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
		$("table#teamrank_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>