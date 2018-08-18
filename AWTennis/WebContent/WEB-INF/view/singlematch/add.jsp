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
					<div id="matchtimeDIV" class="form-group">
						<label for="matchtime"><i style="color:red">*</i> 比赛时间 </label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-clock-o"></i>
							</div>
							<input type="text" name="matchtime" id="matchtime" class="form-control date" readonly data-date-format="yyyy-mm-dd"/>
						</div>
						<span id="matchtime_error" class="help-block"></span>
					</div>
					
					<div class="form-group">
						<label for="matchplace"><i style="color:red">*</i> 比赛地点</label>
						<select name="matchplace" id="matchplace" class="form-control select-chosen">
							<option value="0">-请选择-</option>
							<c:forEach items="${ arenas }" var="arena">
								<option value="${ arena.id }">${ arena.name }</option>
							</c:forEach>
						</select>
						<span id="matchplace_error" class="help-block"></span>
					</div>
					
					<div class="form-group">
						<label for="tournamentid"><i style="color:red">*</i> 赛事类型</label>
						<select name="tournamentid" id="tournamentid" class="form-control select-chosen">
							<option value="0">-请选择-</option>
							<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
								<option value="${ tournamentQuery.tournament.id }">${ tournamentQuery.tournament.name }</option>
							</c:forEach>
						</select>
						<span id="tournamentid_error" class="help-block"></span>
					</div>
					
					<div class="form-group">
						<label for="round"><i style="color:red">*</i> 比赛轮次</label>
						<select name="round" id="round" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${ roundTypes }" var="roundType">
								<option value="${ roundType.key }">${ roundType.value }</option>
							</c:forEach>
						</select>
						<span id="round_error" class="help-block"></span>
					</div>
					
					<div class="form-group">
						<label for="isQualification"><i style="color:red">*</i> 是否资格赛(<i style="color:red">用于计算资格赛积分，非常重要！！！</i>)</label>
						<br/>
						<input type="radio" name="isQualification" id="isNotQualification" value="false" checked/>不是
						<input type="radio" name="isQualification" id="isQualification" value="true">是
					</div>
					
					<div class="form-group">
						<label for="setsOfMatch"><i style="color:red">*</i> 比赛盘数</label>
						<input type="number" name="sets" id="setsOfMatch" value="1" class="form-control"/>
						<span id="setsOfMatch_error" class="help-block"></span>
					</div>
				</div>
				
				<div id="addMatch">
					<label for="numberOfMatches">需要记录的比赛数:</label>
					<input type="number" name="numberOfMatches" id="numberOfMatches" value="1" class=""/>
					<a id="add" class="btn btn-primary">确定</a>
				</div>
				<div id="matchRecord"></div>
				<button type="submit" id="submit" class="btn btn-danger hidden" onclick="return confirm('您确定提交吗?')">提交</button>
			</form>
		</div>
	</div>
	</section>
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
	
	/* verify if you input the match time */
	function verifyMatchtime(){
		var matchTime = $("#matchtime").val().trim();
		var error = $("#matchtime_error");
		var div = $(this).parent().parent();//$("div#matchtimeDIV");
		if("" == matchTime){
			div.addClass("has-error");
			error.html("请输入比赛时间");
		}else{
			div.removeClass("has-error");
			error.html("");
		}
	}
	
	$("#matchtime").focus(function(){
		$(this).parent().parent().removeClass("has-error");
		$("#matchtime_error").html("");
	}).blur(verifyMatchtime).change(verifyMatchtime);
	
	/* verify if you input the match place */
	$("#matchplace").siblings("#matchplace_chosen").click(function(){
		var matchPlace = $("#matchplace").find("option:selected").val();
		var matchPlace_error = $("#matchplace_error");
		if("0" == matchPlace){
			$(this).parent().addClass("has-error");
			matchPlace_error.html("请输入比赛地点");
		}else{
			$(this).parent().removeClass("has-error");
			matchPlace_error.html("");
		}
	});

	/* verify if you input the tournament */
	$("#tournamentid").siblings("#tournamentid_chosen").click(function(){
		var matchPlace = $("#tournamentid").find("option:selected").val();
		var tournament_error = $("#tournamentid_error");
		if("0" == matchPlace){
			$(this).parent().addClass("has-error");
			tournament_error.html("请选择赛事类型");
		}else{
			$(this).parent().removeClass("has-error");
			tournament_error.html("");
		}
	});
	
	/* verify if you input the match round */
	$("#round").siblings("#round_chosen").click(function(){
		var matchPlace = $("#round").find("option:selected").val();
		var round_error = $("#round_error");
		if("0" == matchPlace){
			$(this).parent().addClass("has-error");
			round_error.html("请选择比赛轮次");
		}else{
			$(this).parent().removeClass("has-error");
			round_error.html("");
		}
	});
	
	/* the number of matches and the sets of match must be more than 0 */
	$("#setsOfMatch").change(function(){
		var setsOfMatch = Number($(this).val().trim());
		var numberOfMatches = Number($("#numberOfMatches").val());
		var setsOfMatch_error = $("#setsOfMatch_error");
		if(isNaN(setsOfMatch) || setsOfMatch <= 0){
			$("#add").addClass("disabled");
			$(this).parent().addClass("has-error");
			setsOfMatch_error.html("比赛盘数必须为数字且大于0");
		}else{
			if(isNaN(numberOfMatches) || numberOfMatches <= 0){
				$("#add").addClass("disabled");
			}else{
				$("#add").removeClass("disabled");
			}
			$(this).parent().removeClass("has-error");
			setsOfMatch_error.html("");
		}
	});
	
	$("#numberOfMatches").change(function(){
		var numberOfMatches = Number($(this).val());
		var setsOfMatch = Number($("#setsOfMatch").val().trim());
		if(isNaN(numberOfMatches) || numberOfMatches <= 0){
			$("#add").addClass("disabled");
		}else{
			if(setsOfMatch == NaN || setsOfMatch <= 0){
				$("#add").addClass("disabled");
			}else{
				$("#add").removeClass("disabled");
			}
		}
	});
	
});
</script>
<jsp:include page="../footer.jsp"/>