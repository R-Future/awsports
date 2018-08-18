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
<title>资格赛个人排名</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>资格赛个人排名</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">资格赛个人排名</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="">
		<fieldset>
			<legend>查询</legend>
			<form:form class="form-inline" action="list" method="post" modelAttribute="qualificationrankQuery">
				<div class="form-group">
					<label for="userName">用户名</label>
					<form:input type="text" path="userQuery.user.name" id="userName" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="tournamentName">赛事名称</label>
					<form:input type="text" path="tournament.name" id="tournamentName" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form:form>
		</fieldset>
		</div>

		<div class="entrys">
		<fieldset>
			<legend>更新排名</legend>
			<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
				<input type="checkbox" name="tournamentids" value="${ tournamentQuery.tournament.id }" >${ tournamentQuery.tournament.name }
			</c:forEach>
			<a href="javascript:void(0)" id="update" title="更新排名" class="btn btn-primary"><i class="fa fa-refresh"></i></a>
		</fieldset>
		</div>
		
		<hr class="hrStyle"/>
		<div class="addActive">
			<a href="<%=request.getContextPath()%>/qualificationrank/update" title="添加个人排名" class="btn btn-primary"><i class="fa fa-plus"></i></a>
		</div>
		
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">个人排名列表</h3>
			</div>
			<div class="box-body">
		 	<table id="qualificationrank_list" class="table table-striped table-bordered">
		 		<thead>
				<tr>
				<th>#</th>
				<th>赛事名称</th>
				<th>当前排名</th>
				<th>选手</th>
				<th>俱乐部等级</th>
				<th>性别</th>
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
				<c:if test="${qualificationrankQuerys.size()>0}">
					<c:forEach var="i" begin="0" end="${qualificationrankQuerys.size()-1}" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>${ qualificationrankQuerys[i].tournament.name }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.currentrank }</td>
						<td>${ qualificationrankQuerys[i].userQuery.user.name }</td>
						<td>${ qualificationrankQuerys[i].userQuery.level.chinese }</td>
						<td>${ sexTypes.get(qualificationrankQuerys[i].userQuery.user.sex) }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.totalpoint }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.totalmatchs }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.totalwins }</td>
						<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${ qualificationrankQuerys[i].qualificationrank.wins/qualificationrankQuerys[i].qualificationrank.totalmatchs }"/></td>
						<td>${ qualificationrankQuerys[i].qualificationrank.totalmarginbureau }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.year }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.week }</td>
						<td>${ qualificationrankQuerys[i].qualificationrank.note }</td>
						<td>
							<a href="<%=request.getContextPath()%>/qualificationrank/update?id=${qualificationrankQuerys[i].qualificationrank.id}" title="修改"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/qualificationrank/delete?id=${qualificationrankQuerys[i].qualificationrank.id}" title="删除"><i class="fa fa-trash"></i></a>
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
		$("table#qualificationrank_list").DataTable();
		$("a#update").click(function(){
			var entrys=$("input[name='tournamentids']:checked").serialize();
			$.ajax({
				type:"post",
				url:"updateRank",
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				data: tournamentids,
				success:function(){
					alert("更新成功！");
				}
			});
		});
	});
	
</script>
<jsp:include page="../footer.jsp"/>