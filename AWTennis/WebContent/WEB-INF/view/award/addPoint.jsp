<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>俱乐部奖励</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <!-- 标题 -->
	  <h1>比赛积分奖励</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">比赛积分奖励</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="" id="hint" style="color:red"><c:out value="${ hint }" default=""/></div>
			
			<form class="form" action="<%=request.getContextPath()%>/award/addPoint" method="post">
				<div class="row">
					<div class="form-group has-warning col-md-3">
	                	 	<label class="control-label" for="tournamentId"><i class="fa fa-warning"></i>赛事</label>
						<select id="tournamentId" name="tournamentId" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${tournamentQuerys}" var="tournamentQuery">
								<option value="${tournamentQuery.tournament.id}">${tournamentQuery.tournament.name}</option>
							</c:forEach>
						</select>
						<span class="help-block" id="nullTournament"></span>
					</div>
					<div class="form-group has-warning col-md-3">
	                	 	<label class="control-label" for="entry"><i class="fa fa-warning"></i>参赛类型</label>
						<select id="entry" name="entry" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${individualEntrys}" var="individualEntry">
								<option value="${individualEntry.key}">${individualEntry.value}</option>
							</c:forEach>
						</select>
						<span class="help-block" id="nullEntry"></span>
					</div>
					<div class="form-group has-warning col-md-3">
						<label class="control-label" for="matchTime"><i class="fa fa-warning"></i>比赛时间</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-clock-o"></i>
							</div>
							<input type="date" name="matchTime" id="matchTime" class="form-control date" readonly data-date-format="yyyy-mm-dd"/>
						</div>
						<span class="help-block" id="nullMatchTime"></span>
					</div>
				</div>
				<div class="row">
					<div class="form-group has-warning col-md-3">
	                	 	<label class="control-label" for="userId"><i class="fa fa-warning"></i>用户</label>
						<select id="userId" name="userId" class="form-control select-chosen">
							<option value="0">-请选择-</option>
							<c:forEach items="${userQuerys}" var="userQuery">
								<option value="${userQuery.user.id}">${userQuery.user.name}</option>
							</c:forEach>
						</select>
						<span class="help-block" id="nullUser"></span>
					</div>
					<div class="form-group has-warning col-md-3">
						<label class="control-label" for="point"><i class="fa fa-warning"></i>奖励积分</label>
						<input type="number" name="point" id="point" value="0" class="form-control"/>
						<span class="help-block" id="nullPoint"></span>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-3">
						<button type="submit" id="submitbtn" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
					</div>
				</div>
			</form>
		</div>
	</section><!-- /.Main content -->
</div>
<script>
$(function(){
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

	$("button#submitbtn").mouseover(function(){
		var user = Number($("select#userId").find("option:selected").val());
		var tournament = Number($("select#tournamentId").find("option:selected").val());
		var entry = Number($("select#entry").find("option:selected").val());
		var matchTime = $("input#matchTime").val();
		var point = Number($("input#point").val());
		
		var hasUser;
		var hasTournament;
		var hasEntry;
		var hasMatchTime;
		var hasPoint;
		if(user === 0){
			$("span#nullUser").html("请选择用户");
			hasUser = false;
		}else{
			$("span#nullUser").html("");
			hasUser = true;
		}
		if(tournament === 0){
			$("span#nullTournament").html("请选择赛事");
			hasTournament = false;
		}else{
			$("span#nullTournament").html("");
			hasTournament = true;
		}
		if(entry === 0){
			$("span#nullEntry").html("请选择参赛类型");
			hasEntry = false;
		}else{
			$("span#nullEntry").html("");
			hasEntry = true;
		}
		if("" === matchTime){
			$("span#nullMatchTime").html("请输入比赛时间");
			hasMatchTime = false;
		}else{
			$("span#nullMatchTime").html("");
			hasMatchTime = true;
		}
		if(point <= 0){
			$("span#nullPoint").html("比分不能为空且大于0");
			hasPoint = false;
		}else{
			$("span#nullPoint").html("");
			hasPoint = true;
		}
		
		if(hasUser && hasTournament && hasEntry && hasMatchTime && hasPoint){
			$(this).removeAttr("disabled");
		}else{
			$(this).attr("disabled","disabled");
		}
	})
})
</script>
<jsp:include page="../footer.jsp"/>
