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
<title>个人排名</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>个人排名</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">个人排名</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="">
		<fieldset>
			<legend>查询</legend>
			<form:form class="form-inline" action="list" method="post" modelAttribute="individualrankQuery">
				<div class="form-group">
					<label for="userName">用户名</label>
					<form:input type="text" path="userQuery.user.name" id="userName" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="entry">参赛类型</label>
					<form:select path="individualrank.entry" id="entry" class="form-control">
						<form:option value="0">-请选择-</form:option>
						<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
							<form:option value="${ individualEntryType.key }">${ individualEntryType.value }</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="year">年份</label>
					<form:input type="number" path="individualrank.year" id="year" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form:form>
		</fieldset>
		</div>

		<div class="entrys">
			<fieldset>
				<legend>更新排名</legend>
				<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
					<input type="checkbox" name="entrys" value="${ individualEntryType.key }" checked>${ individualEntryType.value }
				</c:forEach>
				<a href="javascript:void(0)" id="update" title="更新排名" class="btn btn-primary"><i class="fa fa-refresh"></i></a>
				<span style="color:red">(每周更新一次)</span>
				<div class="loader inlineBlock hidden">正在更新中，请耐心等待<div class="loader-inner ball-pulse inlineBlock"><div></div><div></div><div></div></div></div>
			</fieldset>
			
		</div>
		
		<hr class="hrStyle"/>
		<div class="addActive">
<%-- 			<a href="<%=request.getContextPath()%>/individualrank/update" title="添加个人排名" class="btn btn-primary"><i class="fa fa-plus"></i></a> --%>
			<a href="javascript:void(0)" id="t2e" class="btn btn-primary" title="导出到excel"><i class="fa fa-file-excel-o"></i></a>
		</div>
		
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">个人排名列表</h3>
			</div>
			<div class="box-body">
		 	<table id="individualrank_list" class="table table-striped table-bordered">
		 		<thead>
				<tr>
				<th>#</th>
				<th>参赛类型</th>
				<th>排名升降</th>
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
				<th class="excludeOption">操作</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${individualrankQuerys.size()>0}">
					<c:forEach var="i" begin="0" end="${individualrankQuerys.size()-1}" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>${ individualEntryTypes.get(individualrankQuerys[i].individualrank.entry) }</td>
						<td>${ individualrankQuerys[i].individualrank.rankingchange }</td>
						<td>${ individualrankQuerys[i].individualrank.currentrank }</td>
						<td>${ individualrankQuerys[i].userQuery.user.name }</td>
						<td>${ individualrankQuerys[i].userQuery.level.chinese }</td>
						<td>${ sexTypes.get(individualrankQuerys[i].userQuery.user.sex) }</td>
						<td>${ individualrankQuerys[i].individualrank.totalpoint }</td>
						<td>${ individualrankQuerys[i].individualrank.totalmatchs }</td>
						<td>${ individualrankQuerys[i].individualrank.wins }</td>
						<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${ individualrankQuerys[i].individualrank.wins/individualrankQuerys[i].individualrank.totalmatchs }"/></td>
						<td>${ individualrankQuerys[i].individualrank.totalmarginbureau }</td>
						<td>${ individualrankQuerys[i].individualrank.year }</td>
						<td>${ individualrankQuerys[i].individualrank.week }</td>
						<td>${ individualrankQuerys[i].individualrank.note }</td>
						<td class="excludeOption">
							<a href="<%=request.getContextPath()%>/individualrank/update?id=${individualrankQuerys[i].individualrank.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/individualrank/delete?id=${individualrankQuerys[i].individualrank.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
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
	$("#t2e").click(function(){
		$("#individualrank_list").table2excel({
			exclude: ".excludeOption",
			name: "individualRank",
			filename: "individualRank.xls",
			exclude_img: true,
			exclude_links: true,
			exclude_inputs: true
		});
	});
	$("#individualrank_list").DataTable();
});
</script>
<jsp:include page="../footer.jsp"/>