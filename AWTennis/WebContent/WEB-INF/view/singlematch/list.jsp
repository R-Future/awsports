<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用注解的方式格式化输出数据 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单打比赛</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>单打比赛</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">单打比赛</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="row">
		<form:form class="form-inline" action="list" method="post" modelAttribute="singlematchQuery">
			<div class="col-md-12">
				<div class="form-group">
					<label for="user1">主场选手</label>
					<form:input path="user1.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="user2">客场选手</label>
					<form:input path="user2.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="tournamentName">赛事名称</label>
					<form:input path="tournament.name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="arenaName">比赛地点</label>
					<form:input path="arena.name" class="form-control"/>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="startedAt">比赛时间</label>
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<form:input type="input" path="singlematch.startedat" class="form-control date" data-date-format="yyyy-mm-dd"/>
					</div>
					-
					<label for="endedAt"></label>
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<form:input type="input" path="singlematch.endedat" class="form-control date" data-date-format="yyyy-mm-dd"/>
					</div>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</div>
		</form:form>
		</div>
		
		<hr class="hrStyle"/>
		
		<a href="<%=request.getContextPath()%>/singlematch/add" title="添加赛事" class="btn btn-primary"><i class="fa fa-plus"></i></a>
		
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">单打比赛列表</h3>
			</div>
			<div class="box-body">
		 	<table id="singlematch_list" class="table table-striped table-bordered">
		 		<thead>
				<tr>
				<th>#</th>
				<th>比赛地点</th>
				<th>比赛时间</th>
				<th>赛事名称</th>
				<th>参赛类型</th>
				<th>轮次</th>
				<th>盘数</th>
				<th>主vs客</th>
				<th>比分</th>
				<th>注释</th>
				<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${ singlematchs.size()>0 }">
					<c:forEach var="i" begin="0" end="${ singlematchs.size()-1 }" step="1">
						<tr>
						<td>${ i+1 }</td>
						<td>${ singlematchs[i].arena.name }</td>
						<td><spring:eval expression="singlematchs[${i}].singlematch.matchtime"/></td>
						<td>${ singlematchs[i].tournament.name }</td>
						<td>${ entryTypes.get(singlematchs[i].singlematch.entry) }</td>
						<td>${ roundTypes.get(singlematchs[i].singlematch.round) }</td>
						<td>${ singlematchs[i].singlematch.sets }</td>
						<td>${ singlematchs[i].user1.name } <b>VS</b> ${ singlematchs[i].user2.name }</td>
						<td>
							<c:forEach items="${ singlematchs[i].singlematchscores }" var="singlematchscore">
								<c:choose>
								<c:when test="${ singlematchscore.hctiescore.intValue()>0||singlematchscore.aptiescore.intValue()>0 }">
									${ singlematchscore.hcscore }(${ singlematchscore.hctiescore }):${ singlematchscore.apscore }(${ singlematchscore.aptiescore })
								</c:when>
								<c:otherwise>
									${ singlematchscore.hcscore }:${ singlematchscore.apscore }
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</td>
						<td>${ singlematchs[i].singlematch.note }</td>
						<td>
							<a href="<%=request.getContextPath()%>/singlematch/update?id=${singlematchs[i].singlematch.id}" title="修改" onclick="return updateConfirm();"><i class="fa fa-edit"></i></a>
							<a href="<%=request.getContextPath()%>/singlematch/delete?id=${singlematchs[i].singlematch.id}" title="删除" onclick="return deleteConfirm();"><i class="fa fa-trash"></i></a>
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
		$("table#singlematch_list").DataTable();
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
		/* startDate:date, */
		/* 当前日期按钮 */
		todayBtn: true,
		/* 当天日期高亮 */
		todayHighlight: true,
		/* 显示语言 */
		language: 'zh-CN'
	});
</script>
<jsp:include page="../footer.jsp"/>