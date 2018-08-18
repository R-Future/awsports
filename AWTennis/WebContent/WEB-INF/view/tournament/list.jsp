<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛事信息</title>
</head>
<jsp:include page="../header.jsp"/>

 <!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>赛事信息</h1>
      <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">赛事信息</li>
      </ol>
    </section>
	
    <!-- Main content -->
    <section class="content">
	<div class="container-fluid">
		<form:form class="form-inline" action="list" method="post" modelAttribute="tournamentQuery">
			<div class="form-group">
				<label for="tournamentName">赛事名称</label>
				<form:input path="tournament.name" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="arenaName">赛事地点</label>
				<form:input path="arena.name" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="startTime">时间</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-clock-o"></i>
					</div>
					<form:input type="text" path="tournament.startTime" class="form-control date" data-date-format="yyyy-mm-dd"/>
				</div>
				-
				<label for="endTime"></label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-clock-o"></i>
					</div>
					<form:input type="text" path="tournament.endTime" class="form-control date" data-date-format="yyyy-mm-dd"/>
				</div>
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form:form>
		<hr class="hrStyle"/>
		<a href="<%=request.getContextPath()%>/tournament/update" title="添加赛事" class="btn btn-primary"><i class="fa fa-plus"></i></a>
	 	<div class="box">
			<div class="box-header">
				<h3 class="box-title">赛事列表</h3>
			</div>
			<div class="box-body">
			 	<table id="tournament_list" class="table table-striped table-bordered">
			 		<thead>
					<tr>
					<th>#</th>
					<th>赛事名称</th>
					<th>赛事级别</th>
					<th>赛事地点</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>奖金</th>
					<th>费用</th>
					<th>注释</th>
					<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<c:if test="${tournaments.size()>0}">
						<c:forEach var="i" begin="0" end="${ tournaments.size()-1 }" step="1">
							<tr>
							<td>${ i+1 }</td>
							<td><a href="<%=request.getContextPath()%>/tournament/detail?id=${tournaments[i].tournament.id}">${ tournaments[i].tournament.name }</a></td>
							<td>${ tournaments[i].tournament.level }</td>
							<td>${ tournaments[i].arena.name }</td>
							<td><spring:eval expression="tournaments[${i}].tournament.startedat" /></td>
							<td><spring:eval expression="tournaments[${i}].tournament.endedat" /></td>
							<td><spring:eval expression="tournaments[${i}].tournament.prize" /></td>
							<td><spring:eval expression="tournaments[${i}].tournament.cost" /></td>
							<td>${ tournaments[i].tournament.note }</td>
							<td>
								<a href="<%=request.getContextPath()%>/tournament/update?id=${tournaments[i].tournament.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
								<a href="<%=request.getContextPath()%>/tournament/delete?id=${tournaments[i].tournament.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
							</td>
							</tr>
						</c:forEach>
					</c:if>
					</tbody>
				</table>
			</div><!-- /。box-body -->
		</div><!-- /.box -->
	</div>
	</section>
</div>
<script>
	$(function(){
		$("table#tournament_list").DataTable();
	});
	var date=new Date();
	$("input.date").datepicker({
		/* 当选择一个日期之后是否立即关闭此日期时间选择器 */
		autoclose:true,
		/* 日期时间选择器打开之后首先显示的视图。 可接受的值：
	    0 or 'hour' for the hour view
	    1 or 'day' for the day view
	    2 or 'month' for month view (the default)
	    3 or 'year' for the 12-month overview
	    4 or 'decade' for the 10-year overview. Useful for date-of-birth datetimepickers. */
		startView:2,
		/* 一周从哪天开始0（星期日）到6（星期六） */
		weekStart:1,
		/* 是否允许通过方向键改变日期 */
		keyboardNavigation:true,
		/* 时间格式 */
		format:'yyyy-mm-dd',
		/* 开始时间，该时间前的所有时间不能选择 */
// 		startDate:date,
		/* 当前日期按钮 */
		todayBtn: true,
		/* 当天日期高亮 */
		todayHighlight: true,
		/* 显示语言 */
		language: 'zh-CN'
	});
</script>
<jsp:include page="../footer.jsp"/>