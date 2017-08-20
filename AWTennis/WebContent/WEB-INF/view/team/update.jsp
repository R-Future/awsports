<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组合信息</title>
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
        <li><a href="<%=request.getContextPath()%>/team/list">组合信息</a></li>
        <li class="active"><jsp:include page="../breadcrumb.jsp"/></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
	<div class="container-fluid">
	
		<div class="" style="color:red">
			<c:if test="${errors!=null}">
				<c:forEach items="${errors.allErrors}" var="error">
					${error.defaultMessage}<br/>
				</c:forEach>
			</c:if>
			<c:out value="${ teamExisted }<br/>" default=""/>
		</div>
		
		<form class="form" action="<%=request.getContextPath()%>/team/save" method="post">
			<input type="hidden" name="id" id="id" value="${team.id}" class="form-control"/>
			
			<div class="form-group">
				<label for="user1"><i style="color:red">*</i> 队员1</label>
				<select name="user1id" id="user1" class="form-control">
					<option value="0">--请选择--</option>
					<c:forEach items="${ userQuerys }" var="userQuery">
						<c:choose>
							<c:when test="${ userQuery.user.getId().equals(team.user1id) }">
								<option value="${ userQuery.user.getId() }" selected="selected">${ userQuery.user.getName() }</option>
							</c:when>
							<c:otherwise>
								<option value="${ userQuery.user.getId() }">${ userQuery.user.getName() }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>				
				</select>
				<span class="help-block"></span>
			</div>
			
			<div class="form-group">
				<label for="user2"><i style="color:red">*</i> 队员2</label>
				<select name="user2id" id="user2" class="form-control">
					<option value="0">--请选择--</option>
					<c:forEach items="${ userQuerys }" var="userQuery">
						<c:choose>
							<c:when test="${ userQuery.user.getId().equals(team.user2id) }">
								<option value="${ userQuery.user.getId() }" selected="selected">${ userQuery.user.getName() }</option>
							</c:when>
							<c:otherwise>
								<option value="${ userQuery.user.getId() }">${ userQuery.user.getName() }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>				
				</select>
				<span class="help-block"></span>
			</div>		
			
			<div class="form-group">
				<label for="startedat"><i style="color:red">*</i> 开始时间</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-clock-o"></i>
					</div>
					<input type="text" name="startedat" id="startedat" value="<fmt:formatDate value="${ team.startedat }" pattern="yyyy-MM-dd"/>" class="form-control date" readonly data-date-format="yyyy-mm-dd"/>
				</div>
				<span class="help-block"></span>
			</div>
			
			<div class="form-group">
				<label for="note">注释</label>
				<input type="text" name="note" id="note" value="${team.note}" class="form-control"/>
			</div>
			
			<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
		</form>	
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
// 		startDate:date,
		/* 当前日期按钮 */
		todayBtn: true,
		/* 当天日期高亮 */
		todayHighlight: true,
		/* 显示语言 */
		language: 'zh-CN'
	});
	
	/* verify user1 */
	$("select#user1").click(function(){
		var user = Number($(this).find("option:selected").val());
		var partner = Number($("select#user2").find("option:selected").val());
		var parent = $(this).parent();
		var error = $(this).siblings("span");
		if(user === 0){
			parent.addClass("has-error");
			error.html("请选择队友");
		}else{
			if(partner != 0){
				if(user === partner){
					parent.addClass("has-error");
					error.html("请确认队友不是自己");
				}else{
					parent.removeClass("has-error");
					error.html("");
				}
			}else{
				parent.removeClass("has-error");
				error.html("");
			}
		}
	});
	/* verify user2 */
	$("select#user2").click(function(){
		var user = Number($(this).find("option:selected").val());
		var partner = Number($("select#user1").find("option:selected").val());
		var parent = $(this).parent();
		var error = $(this).siblings("span");
		if(user === 0){
			parent.addClass("has-error");
			error.html("请选择队友");
		}else{
			if(partner != 0){
				if(user === partner){
					parent.addClass("has-error");
					error.html("请确认队友不是自己");
				}else{
					parent.removeClass("has-error");
					error.html("");
				}
			}else{
				parent.removeClass("has-error");
				error.html("");
			}
		}
	});
	/* verify start time */
	function getCurrentDate(){
		var current = new Date();
		var year = current.getFullYear();
		var month = current.getMonth()+1;//the range of getMonth() is [0,11]
		var day = current.getDate();//[1,31]
		if(month < 10){
			month = "0"+month;
		}
		if(day < 10){
			day = "0"+day;
		}
		return year+"-"+month+"-"+day;
	}
	$("input#startedat").focus(function(){
		$(this).parent().parent().removeClass("has-error");
		$(this).parent().siblings("span").html("");
	}).blur(function(){
		var time = $(this).val();
		var grandparent = $(this).parent().parent();
		var error = $(this).parent().siblings("span");
		if("" === time){
			grandparent.addClass("has-error");
			error.html("请输入组合开始时间");
		}else{
			var current = getCurrentDate();
			if(time > current){
				grandparent.addClass("has-error");
				error.html("日期不能超过当前日期");
			}else{
				grandparent.removeClass("has-error");
				error.html("");
			}
		}
	}).change(function(){
		var time = $(this).val();
		var grandparent = $(this).parent().parent();
		var error = $(this).parent().siblings("span");
		if("" === time){
			grandparent.addClass("has-error");
			error.html("请输入组合开始时间");
		}else{
			var current = getCurrentDate();
			if(time > current){
				grandparent.addClass("has-error");
				error.html("日期不能超过当前日期");
			}else{
				grandparent.removeClass("has-error");
				error.html("");
			}
		}
	});
})
</script>
<jsp:include page="../footer.jsp"/>