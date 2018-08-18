<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>俱乐部等级</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>俱乐部等级</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">俱乐部等级</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<form class="form-inline" action="<%=request.getContextPath()%>/level/list" method="post">
			<div class="form-group">
				<label for="chinese">中文描述</label>
				<input type="text" name="chinese" id="chinese" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="english">英文描述</label>
				<input type="text" name="english" id="english" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form>
		
		<hr class="hrStyle">
		<a href="<%=request.getContextPath()%>/level/update" title="添加等级" class="btn btn-primary"><i class="fa fa-plus"></i></a>
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">俱乐部等级列表</h3>
			</div>
			<div class="box-body">
		 	<table id="level_list" class="table table-striped table-bordered">
		 		<thead>
				<tr>
				<th>#</th>
				<th>所属类别</th>
				<th>中文描述</th>
				<th>英文描述</th>
				<th>注释</th>
				<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${levels.size()>0}">
					<c:forEach  var="i" begin="0" end="${levels.size()-1}" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>
							<c:choose>
								<c:when test="${ levels[i].parent.intValue()==0 }">无</c:when>
								<c:otherwise>
									<c:forEach items="${ levels }" var="parent">
										<c:if test="${ parent.id.equals(level.parent) }">${ parent.chinese }(${ parent.english })</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</td>
						<td>${ levels[i].chinese }</td>
						<td>${ levels[i].english }</td>
						<td>${ levels[i].note }</td>
						<td>
							<a href="<%=request.getContextPath()%>/level/update?id=${levels[i].id}" title="修改"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/level/delete?id=${levels[i].id}" title="删除"><i class="fa fa-trash"></i></a>
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
		$("table#level_list").DataTable();
	});
</script>
<jsp:include page="../footer.jsp"/>