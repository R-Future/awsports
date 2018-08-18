<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<jsp:include page="../header.jsp"/>
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <h1>个人信息</h1>
	      <!-- 面包屑 -->
		  <ol class="breadcrumb">
	        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
	        <li class="active">个人信息</li>
	      </ol>
	    </section>
	
	    <!-- Main content -->
	    <section class="content">
	       	 <!-- user list -->
	       	 <div class="container-fluid">
				<form class="form-inline" action="<%=request.getContextPath()%>/user/list" method="post">
					<div class="form-group">
						<label for="username">用户名</label>
						<input type="text" name="user.name" id="username" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="address">住址</label>
						<input type="text" name="user.address" id="address" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="level">网球水平</label>
						<input type="text" name="user.level" id="level" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form>
				<hr class="hrStyle"/>
				<a href="<%=request.getContextPath()%>/user/update" title="添加用户" class="btn btn-primary"><i class="fa fa-user-plus"></i></a>
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">用户列表</h3>
					</div>
					<div class="box-body">
					 	<table id="user_list" class="table table-striped table-bordered">
					 		<thead>
								<tr>
								<th>#</th>
								<th>用户名</th>
								<th>俱乐部等级</th>
								<th>性别</th>
								<th>手机号</th>
								<th>邮箱</th>
								<th>住址</th>
								<th>技术水平</th>
								<th>球龄(年)</th>
								<th>正手</th>
								<th>反手</th>
								<th>单打冠军数</th>
								<th>双打冠军数</th>
								<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${ userQuerys.size()>0 }">
									<c:forEach var="i" begin="0" end="${ userQuerys.size()-1 }" step="1">
										<tr>
											<td>${ i+1 }</td>
											<td><a href="<%= request.getContextPath()%>/user/profile?id=${userQuerys[i].user.id}">${ userQuerys[i].user.name }</a></td>
											<td>${ userQuerys[i].level.chinese }</td>
											<td>${ sexTypes.get(userQuerys[i].user.sex) }</td>
											<td>${ userQuerys[i].user.phone }</td>
											<td>${ userQuerys[i].user.email }</td>
											<td>${ userQuerys[i].user.address }</td>
											<td>${ userQuerys[i].user.level }</td>
											<td>${ userQuerys[i].user.playedyears }</td>
											<td>${ forehandTypes.get(userQuerys[i].user.forehand) }</td>
											<td>${ backhandTypes.get(userQuerys[i].user.backhand) }</td>
											<td>${ userQuerys[i].user.singletitles }</td>
											<td>${ userQuerys[i].user.doubletitles }</td>
											<td>
												<a href="<%=request.getContextPath()%>/user/update?id=${userQuerys[i].user.id}" title="修改"><i class="fa fa-edit"></i></a>
												<a href="<%=request.getContextPath()%>/user/delete?id=${userQuerys[i].user.id}" title="删除"><i class="fa fa-trash"></i></a>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div><!-- /。box-body  -->
				</div><!-- /。box -->
			</div>
		</section>
	</div>
<script>
	$(function(){
		$("table#user_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>