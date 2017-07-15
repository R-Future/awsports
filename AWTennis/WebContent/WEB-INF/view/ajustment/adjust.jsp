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
					
				</fieldset>
				<a href="javascript:void(0)" id="routine" class="btn btn-danger">确定</a>
<!-- 				<button type="submit" class="btn btn-danger">提交</button> -->
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
		})
	});
</script>
<jsp:include page="../footer.jsp"/>
