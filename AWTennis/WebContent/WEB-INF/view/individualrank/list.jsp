<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- spring自带的form表单 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人排名</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("a#update").click(function(){
			var entrys=$("input[name='entrys']:checked").serialize();
			$.ajax({
				type:"post",
				url:"updateRank",
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				data:entrys,
				success:function(){
					alert("更新成功！");
				}
			});
		});
	});
</script>
</head>
<body>
<div class="container-fluid">
	<div class="">
		<form:form class="form-inline" action="list" method="post" modelAttribute="individualrankQuery">
			<div class="form-group">
				<label for="userName">用户名</label>
				<form:input type="text" path="user.name" id="userName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="entry">参赛类型</label>
				<form:select path="individualrank.entry" id="entry" class="form-control">
					<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
						<form:option value="${ individualEntryType.key }">${ individualEntryType.value }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form:form>
	</div>
	
	<div class="updateRank">
		<div class="entry">
			<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
				<input type="checkbox" name="entrys" value="${ individualEntryType.key }">${ individualEntryType.value }
			</c:forEach>
		</div>
		<div class="updateButton">
			<a id="update">更新排名</a>
		</div>
	</div>
	
	<div class="addActive">
		<a href="<%=request.getContextPath()%>/individualrank/update">添加个人排名</a>
	</div>
	
	<div class="list">
	 	<table class="table table-striped table-responsive">
			<tr>
			<td>参赛类型</td>
			<td>当前排名</td>
			<td>选手</td>
			<td>总积分</td>
			<td>总场数</td>
			<td>胜场数</td>
			<td>净胜局</td>	
			<td>年份</td>
			<td>周</td>
			<td>注释</td>
			<td>操作</td>
			</tr>
			<c:forEach items="${individualrankQuerys}" var="individualrankQuery">
				<tr>
				<td>${ individualEntryTypes.get(individualrankQuery.individualrank.entry) }</td>
				<td>${ individualrankQuery.individualrank.currentrank }</td>
				<td>${ individualrankQuery.user.name }</td>
				<td>${ individualrankQuery.individualrank.totalpoint }</td>
				<td>${ individualrankQuery.individualrank.totalmatchs }</td>
				<td>${ individualrankQuery.individualrank.wins }</td>
				<td>${ individualrankQuery.individualrank.totalmarginbureau }</td>
				<td>${ individualrankQuery.individualrank.year }</td>
				<td>${ individualrankQuery.individualrank.week }</td>
				<td>${ individualrankQuery.individualrank.note }</td>
				<td>
					<a href="<%=request.getContextPath()%>/individualrank/update?id=${individualrankQuery.individualrank.id}">修改</a>
					<a href="<%=request.getContextPath()%>/individualrank/delete?id=${individualrankQuery.individualrank.id}">删除</a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>