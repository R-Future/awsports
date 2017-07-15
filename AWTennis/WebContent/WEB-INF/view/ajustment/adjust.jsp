<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>俱乐部级别调整</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <!-- 标题 -->
	  <h1>俱乐部级别调整</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">俱乐部级别调整</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="" id="hint" style="color:red"></div>
			
			<form class="form" action="<%=request.getContextPath()%>/adjustment/adjust" method="post">
			
				<fieldset>
					<legend>常规调整</legend>
					
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="number"><i class="fa fa-warning"></i>需调整的人数</label>
						<input type="number" name="number" id="number" class="form-control"/>
						<span class="help-block" id="nullNumber"></span>
					</div>
					
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="highLevel"><i class="fa fa-warning"></i>降级组别</label>
						<select id="highLevel" name="highLevel" class="form-control">
							<option>-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="nullHighLevel"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="lowLevel"><i class="fa fa-warning"></i>升级组别</label>
						<select id="lowLevel" name="lowLevel" class="form-control">
							<option>-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="nullLowLevel"></span>
					</div>
					<div class="form-group col-md-3" style="padding-top:25px">
						<a href="javascript:void(0)" id="routine" class="btn btn-danger">确定</a>
					</div>
				</fieldset>
				
				<fieldset><legend>资格赛调整</legend></fieldset>
				<fieldset>
					<legend>降级</legend>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_down_number"><i class="fa fa-warning"></i>降级人数</label>
						<input type="number" name="qh_down_number" id="qh_down_number" class="form-control"/>
						<span class="help-block" id="null_qh_down_number"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_highLevel"><i class="fa fa-warning"></i>降级前的组别</label>
						<select id="qh_highLevel" name="qh_highLevel" class="form-control">
							<option>-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_highLevel"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_lowLevel"><i class="fa fa-warning"></i>降级后的组别</label>
						<select id="qh_lowLevel" name="qh_lowLevel" class="form-control">
							<option>-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_lowLevel"></span>
					</div>
					<div class="form-group col-md-3" style="padding-top:25px">
						<a href="javascript:void(0)" id="qh_down" class="btn btn-danger">确定</a>
					</div>
				</fieldset>
				
				
				<fieldset>
					<legend>资格赛选手升级</legend>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_up_number"><i class="fa fa-warning"></i>升级人数</label>
						<input type="number" name="qh_up_number" id="qh_up_number" class="form-control"/>
						<span class="help-block" id="null_qh_up_number"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_tournament"><i class="fa fa-warning"></i>赛事类型</label>
						<select id="qh_tournament" name="qh_tournament" class="form-control">
							<option>-请选择-</option>
							<c:forEach items="${tournamentQuerys}" var="tournamentQuery">
								<option value="${tournamentQuery.tournament.id}">${tournamentQuery.tournament.name}</option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_tournament"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_upto_Level"><i class="fa fa-warning"></i>升级后的组别</label>
						<select id="qh_upto_Level" name="qh_upto_Level" class="form-control">
							<option>-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_upto_Level"></span>
					</div>
					<div class="form-group col-md-3" style="padding-top:25px">
						<a href="javascript:void(0)" id="qh_up" class="btn btn-danger">确定</a>
					</div>
				</fieldset>
			</form>
		</div>
	</section><!-- /.Main content -->
</div>
<script>
	$(function(){

		$("input#number").blur(function(){
			var number = $("input#number").val();
			if(number == null || number == ''){
				$("span#nullNumber").html("请输入要调整 的人数");
			}else{
				$("span#nullNumber").html("");
			}
		});
		$("select#highLevel").blur(function(){	
			var highLevel = $("select#highLevel").val();
			if(highLevel == null || highLevel == ''){
				$("span#nullHighLevel").html("请选择需降级的组别");
			}else{
				$("span#nullHighLevel").html("");
			}
		});
		$("select#lowLevel").blur(function(){
			var lowLevel = $("select#lowLevel").val();
			if(lowLevel == null || lowLevel == ''){
				$("span#nullLowLevel").html("请选择需升级的组别");
			}else{
				$("span#nullLowLevel").html("");
			}
		});
		$("a#routine").click(function(){
			var number = $("input#number").val();
			var highLevel = $("select#highLevel").val();
			var lowLevel = $("select#lowLevel").val();
			if(number == null || highLevel == null || lowLevel == null){
				alert("请输入调整信息");
			}else{
				$.ajax({
					type: "post",
					url: "routine",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {number:number,highLevel:highLevel,lowLevel:lowLevel},
					dataType: "html",
					success:function(data){
						$("div#hint").html(data);
					}
				});
			}
		});
		/* 资格赛前金组降级的人员 */
		$("a#qh_down").click(function(){
			var qh_down_number = $("input#qh_down_number").val();
			var qh_highlevel = $("select#qh_highlevel").val();
			var qh_lowLevel = $("selelct#qh_lowLevel").val();
			if(qh_down_number == null || qh_highlevel == null){
				alert("请输入调整信息");
			}else{
				$.ajax({
					type: "post",
					url: "qualificationDowngrade",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {qhDownNumber:qh_down_number,qhHighLevel:qh_highlevel,qhLowLevel:qh_lowLevel},
					dataType: "html",
					success:function(data){
						$("div#hint").html(data);
					}
				});
			}
		});
		$("a#qh_up").click(function(){
			var qh_up_number = $("input#qh_up_number").val();
			var qh_tournament = $("select#qh_tournament").val();
			var qh_upto_Level = $("select#qh_upto_Level").val();
			if(qh_up_number == null || qh_tournament == null){
				alert("请输入调整信息");
			}else{
				$.ajax({
					type: "post",
					url: "qualificationUpgrade",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {qhUpNumber:qh_up_number,qhTournament:qh_tournament,qhUptoLevel:qh_upto_Level},
					dataType: "html",
					success:function(data){
						$("div#hint").html(data);
					}
				});
			}
		});
	});
</script>
<jsp:include page="../footer.jsp"/>
