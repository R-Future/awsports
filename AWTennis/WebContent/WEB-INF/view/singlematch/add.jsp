<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  <h1><jsp:include page="../breadcrumb.jsp"/></h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="<%=request.getContextPath()%>/singlematch/list">单打比赛列表</a></li>
        <li class="active"><jsp:include page="../breadcrumb.jsp"/></li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="row" style="color:red">
			<c:if test="${errors!=null}">
				<c:forEach items="${errors.allErrors}" var="error">
					${error.defaultMessage}<br/>
				</c:forEach>
			</c:if>
		</div>
		<div class="row">
			<form class="form" action="<%=request.getContextPath()%>/singlematch/saveNew" method="post">
				<div id="basicInformation">
	<!-- 				<input type="hidden" name="singlematch.id" id="singlematchid" class="form-control"/> -->		
					<div class="form-group">
						<label for="singlematchMatchtime">比赛时间</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-clock-o"></i>
							</div>
							<input type="text" name="matchtime" id="singlematchMatchtime" class="form-control date" readonly data-date-format="yyyy-mm-dd"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="singlematchMatchplace">比赛地点</label>
						<select name="matchplace" id="singlematchMatchplace" class="form-control">
							<option value="default">-请选择-</option>
							<c:forEach items="${ arenas }" var="arena">
								<option value="${ arena.id }">${ arena.name }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="singlematchTournamentid">赛事类型</label>
						<select name="tournamentid" id="singlematchTournamentid" class="form-control">
							<option value="default">-请选择-</option>
							<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
								<option value="${ tournamentQuery.tournament.id }">${ tournamentQuery.tournament.name }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="singlematchRound">比赛轮次</label>
						<select name="round" id="singlematchRound" class="form-control">
							<option value="default">-请选择-</option>
							<c:forEach items="${ roundTypes }" var="roundType">
								<option value="${ roundType.key }">${ roundType.value }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="singlematchSets">比赛盘数</label>
						<input type="number" name="sets" id="singlematchSets" value="1" class="form-control"/>
					</div>
				</div>
				
				<div id="addMatch">
					<label for="numberOfMatches">需要记录的比赛数:</label>
					<input type="number" name="numberOfMatches" id="numberOfMatches" value="1" class=""/>
					<a id="add">确定</a>
				</div>
				
				<div id="matchRecord"></div>
				<button type="submit" id="submit" class="btn btn-default">提交</button>
			</form>
		</div>
	</div>
	</section>
</div>
<script>
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