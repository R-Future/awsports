<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组合信息</title>
</head>
<jsp:include page="../header.jsp"/>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
	
		<!-- Content Header (Page header) -->
		<section class="content-header">
		  <h1>组合信息</h1>
		  <!-- 面包屑 -->
		  <ol class="breadcrumb">
	        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
	        <li class="active">组合信息</li>
	      </ol>
		</section>
		
		<!-- Main content -->
		<section class="content">
			<!-- team list -->
			<div class="container-fluid">
				<form:form class="form-inline" action="list" method="post" modelAttribute="teamQuery">
					<div class="form-group">
						<label for="user1Name">队员1</label>
						<form:input path="user1.name" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="user2Name">队员2</label>
						<form:input path="user2.name" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="entry">组合类型</label>
						<form:select path="team.entry" id="entry" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${ teamEntryTypes }" var="teamEntryType">
								<option value="${ teamEntryType.key }">${ teamEntryType.value }</option>
							</c:forEach>
						</form:select>
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form:form>
				
				<hr class="hrStyle"/>
				
				<a href="<%=request.getContextPath()%>/team/update" title="添加组合" class="btn btn-primary"><i class="fa fa-user-plus"></i></a>
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">组合列表</h3>
					</div>
					<div class="box-body">
				 	<table id="team_list" class="table table-striped table-bordered">
				 		<thead>
						<tr>
						<th>#</th>
						<th>队员1</th>
						<th>队员2</th>
						<th>组合类型</th>
						<th>开始时间</th>
						<th>注释</th>
						<th>操作</th>
						</tr>
						</thead>
						<tbody>
						<c:if test="${ teams.size()>0 }">
							<c:forEach var="i" begin="0" end="${ teams.size()-1 }" step="1">
								<tr>
								<td>${ i+1 }</td>
								<td>${ teams[i].user1.name }</td>
								<td>${ teams[i].user2.name }</td>
								<td>${ teamEntryTypes.get(teams[i].team.entry) }</td>
								<td><spring:eval expression="teams[${i}].team.startedat"/></td>
								<td>${ teams[i].team.note }</td>
								<td>
									<a href="<%=request.getContextPath()%>/team/update?id=${teams[i].team.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
									<a href="<%=request.getContextPath()%>/team/delete?id=${teams[i].team.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
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
		$("table#team_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>