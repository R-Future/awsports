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
			
<%-- 			<form class="form" action="<%=request.getContextPath()%>/adjustment/adjust" method="post"> --%>
			
				<fieldset>
					<legend style="color:#3c8dbc">常规调整</legend>
					
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="number"><i class="fa fa-warning"></i>需调整的人数</label>
						<input type="number" name="number" id="number" min="1" class="form-control"/>
						<span class="help-block" id="nullNumber"></span>
					</div>
					
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="highLevel"><i class="fa fa-warning"></i>降级组别</label>
						<select id="highLevel" name="highLevel" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="nullHighLevel"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="lowLevel"><i class="fa fa-warning"></i>升级组别</label>
						<select id="lowLevel" name="lowLevel" class="form-control">
							<option value="0">-请选择-</option>
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
				
				<fieldset><legend style="color:#3c8dbc">资格赛调整</legend></fieldset>
				<fieldset>
					<legend>降级</legend>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_down_number"><i class="fa fa-warning"></i>降级人数</label>
						<input type="number" name="qh_down_number" id="qh_down_number" min="0" class="form-control"/>
						<span class="help-block" id="null_qh_down_number"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_highLevel"><i class="fa fa-warning"></i>降级前的组别</label>
						<select id="qh_highLevel" name="qh_highLevel" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_highLevel"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_lowLevel"><i class="fa fa-warning"></i>降级后的组别</label>
						<select id="qh_lowLevel" name="qh_lowLevel" class="form-control">
							<option value="0">-请选择-</option>
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
						<input type="number" name="qh_up_number" id="qh_up_number" min="1" class="form-control"/>
						<span class="help-block" id="null_qh_up_number"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_tournament"><i class="fa fa-warning"></i>赛事类型</label>
						<select id="qh_tournament" name="qh_tournament" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${tournamentQuerys}" var="tournamentQuery">
								<option value="${tournamentQuery.tournament.id}">${tournamentQuery.tournament.name}</option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_tournament"></span>
					</div>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="qh_upto_level"><i class="fa fa-warning"></i>升级后的组别</label>
						<select id="qh_upto_level" name="qh_upto_level" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_qh_upto_level"></span>
					</div>
					<div class="form-group col-md-3" style="padding-top:25px">
						<a href="javascript:void(0)" id="qh_up" class="btn btn-danger">确定</a>
					</div>
				</fieldset>
				
				<fieldset>
					<legend style="color:#3c8dbc">强制调整</legend>
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="force_member"><i class="fa fa-warning"></i>用户列表</label>
						<select multiple id="force_member" name="force_member" class="form-control">
							<c:forEach items="${ userQuerys }" var="userQuery">
								<option value="${ userQuery.user.id }">${ userQuery.user.name }</option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_force_member"></span>
					</div>
					
					<div class="form-group has-warning col-md-3">
                 	 	<label class="control-label" for="force_level"><i class="fa fa-warning"></i>调整后的组别</label>
						<select id="force_level" name="force_level" class="form-control">
							<option value="0">-请选择-</option>
							<c:forEach items="${levels}" var="level">
								<option value="${level.id}">${level.chinese}<c:out value="${ level.english }" default=""/></option>
							</c:forEach>
						</select>
						<span class="help-block" id="null_force_level"></span>
					</div>
					<div class="form-group col-md-3" style="padding-top:25px">
						<a href="javascript:void(0)" id="force" class="btn btn-danger">确定</a>
					</div>
					<div class="form-group has-warning col-md-12" id="userSelected"></div>
				</fieldset>
				
<!-- 			</form> -->
		</div>
	</section><!-- /.Main content -->
</div>
<script>
	$(function(){
		//routine
		$("#routine").mouseover(function(){
			var number = Number($("#number").val());
			var highLevel = Number($("#highLevel option:selected").val());
			var lowLevel = Number($("#lowLevel option:selected").val());
			
			var isNumber;
			var isHighLevel;
			var isLowLevel;
			if(number == null || number <= 0){
				$("#nullNumber").html("请输入要调整 的人数(人数不得小于1)");
				isNumber = false;
			}else{
				$("#nullNumber").html("");
				isNumber = true;
			}
			if(highLevel == null || highLevel == 0){
				$("#nullHighLevel").html("请选择需降级的组别");
				isHighLevel = false;
			}else{
				$("#nullHighLevel").html("");
				isHighLevel = true;
			}
			if(lowLevel == null || lowLevel == 0){
				$("#nullLowLevel").html("请选择需升级的组别");
				isLowLevel = false;
			}else{
				$("#nullLowLevel").html("");
				isLowLevel = true;
			}
			
			if(isNumber && isHighLevel && isLowLevel){
				$(this).removeAttr("disabled");
			}else{
				$(this).attr("disabled","disabled");
			}
		}).click(function(){
			var number = Number($("#number").val());
			var highLevel = Number($("#highLevel option:selected").val());
			var lowLevel = Number($("#lowLevel option:selected").val());
			var isConfirm = confirm("请确定提交吗?");
			if(isConfirm){
				$.ajax({
					type: "post",
					url: "routine",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {number:number,highLevel:highLevel,lowLevel:lowLevel},
					dataType: "html",
					success:function(data){
						$("#hint").html(data);
					}
				});
			}
		});
		//qualification
		$("#qh_down").mouseover(function(){
			var qh_down_number = Number($("#qh_down_number").val());
			var qh_highLevel = Number($("#qh_highLevel option:selected").val());
			var qh_lowLevel = Number($("#qh_lowLevel option:selected").val());
			
			var isQhDownNumber;
			var isQhHighLevel;
			var isQhLowLevel;
			if(qh_down_number == null || qh_down_number <= 0){
				$("#null_qh_down_number").html("请输入 降级人数(人数不得小于1)");
				isQhDownNumber = false;
			}else{
				$("#null_qh_down_number").html("");
				isQhDownNumber = true;
			}
			if(qh_highLevel == null || qh_highLevel <= 0){
				$("#null_qh_highLevel").html("请输入用户降级前所属组别");
				isQhHighLevel = false;
			}else{
				$("#null_qh_highLevel").html("");
				isQhHighLevel = true;
			}
			if(qh_lowLevel == null || qh_lowLevel <= 0){
				$("#null_qh_lowLevel").html("请输入用户降级后所属组别");
				isQhLowLevel = false;
			}else{
				$("#null_qh_lowLevel").html("");
				isQhLowLevel = true;
			}
			
			if(isQhDownNumber && isQhHighLevel && isQhLowLevel){
				$(this).removeAttr("disabled");
			}else{
				$(this).attr("disabled","disabled");
			}
		}).click(function(){
			var qh_down_number = Number($("#qh_down_number").val());
			var qh_highLevel = Number($("#qh_highLevel option:selected").val());
			var qh_lowLevel = Number($("#qh_lowLevel option:selected").val());
			var isConfirm = confirm("请确定提交吗?");
			if(isConfirm){
				$.ajax({
					type: "post",
					url: "qualificationDowngrade",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {qhDownNumber:qh_down_number,qhHighLevel:qh_highLevel,qhLowLevel:qh_lowLevel},
					dataType: "html",
					success:function(data){
						$("#hint").html(data);
					}
				});
			}
		});
		$("#qh_up").mouseover(function(){
			var qh_up_number = Number($("#qh_up_number").val());
			var qh_tournament = Number($("#qh_tournament option:selected").val());
			var qh_upto_level = Number($("#qh_upto_level option:selected").val());
			
			var isQhUpNumber;
			var isQhTournament;
			var isQhUptoLevel;
			if(qh_up_number == null || qh_up_number <= 0){
				$("#null_qh_up_number").html("请输入升级人数(人数不得小于1)");
				isQhUpNumber = false;
			}else{
				$("#null_qh_up_number").html("");
				isQhUpNumber = true;
			}
			if(qh_tournament == null || qh_tournament <= 0){
				$("#null_qh_tournament").html("请输入所参加的赛事类型");
				isQhTournament = false;
			}else{
				$("#null_qh_tournament").html("");
				isQhTournament = true;
			}
			if(qh_upto_level == null || qh_upto_level <= 0){
				$("#null_qh_upto_level").html("请输入用户升级后所属组别");
				isQhUptoLevel = false;
			}else{
				$("#null_qh_upto_level").html("");
				isQhUptoLevel = true;
			}
			
			if(isQhUpNumber && isQhTournament && isQhUptoLevel){
				$(this).removeAttr("disabled");
			}else{
				$(this).attr("disabled","disabled");
			}
		}).click(function(){
			var qh_up_number = Number($("#qh_up_number").val());
			var qh_tournament = Number($("#qh_tournament option:selected").val());
			var qh_upto_level = Number($("#qh_upto_level option:selected").val());
			var isConfirm = confirm("请确定提交吗?");
			if(isConfirm){
				$.ajax({
					type: "post",
					url: "qualificationUpgrade",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {qhUpNumber:qh_up_number,qhTournament:qh_tournament,qhUptoLevel:qh_upto_level},
					dataType: "html",
					success:function(data){
						$("#hint").html(data);
					}
				});
			}
		});
		
		//force
		function clearSpan(){
			$("#userSelected").children("span").remove();
		}
		$("#force_member").click(function(){
			clearSpan();//clear all users selected at last time
			var selectList = [];
			$("#force_member option:selected").each(function(){
				selectList.push($(this).text());
			});
// 			console.log(selectList);
			if(selectList != null){
				var title = document.createElement("span");
				$(title).html("已选用户:&nbsp;");
				$("#userSelected").append(title);
				selectList.forEach(function(d){
					var span = document.createElement("span");
					$(span).addClass("bg-red color-palette").html(d+",");
					$("#userSelected").append(span);
				})
			}else{
				clearSpan();
			}
		});
		
		$("#force").mouseover(function(){
			var selectList = $("#force_member").val();
			var level = Number($("#force_level option:selected").val());
			//convert string to int
			var userSelect = selectList.map(function(d){return +d;});
 			//console.log(userSelect);
			var isUserSelected;
			var isLevelInput;
			if(userSelect == null || userSelect.length == 0){
				$("#null_force_member").html("请选择用户");
				isUserSelected = false;
			}else{
				$("#null_force_member").html("");
				isUserSelected = true;
			}
			if(level === 0){
				$("#null_force_level").html("请选择调整后所属组别");
				isLevelInput = false;
			}else{
				$("#null_force_level").html("");
				isLevelInput = true;
			}
			if(isUserSelected && isLevelInput){
				$(this).removeAttr("disabled");
			}else{
				$(this).attr("disabled","disabled");
			}
		}).click(function(){
			var selectList = $("#force_member").val();
			var level = Number($("#force_level option:selected").val());
			//convert string to int
			var userSelect = selectList.map(function(d){return +d;});
			console.log(selectList);
			var isConfirm = confirm("请确定提交吗?");
			if(isConfirm){
				$.ajax({
					type: "post",
					url: "force",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: {userIds:userSelect,level:level},
					traditional: true,
					dataType: "html",
					success:function(data){
						$("#hint").html(data);
					}
				});
			}
		});
	});
</script>
<jsp:include page="../footer.jsp"/>
