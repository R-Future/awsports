<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退赛扣分</title>
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
        <li><a href="<%=request.getContextPath()%>/punishment/list">退赛扣分列表</a></li>
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
			<form class="form" action="<%=request.getContextPath()%>/punishment/save" method="post">
				<input type="hidden" name="id" id="id" value="${punishment.id}" class="form-control"/>
				
				<div class="form-group">
					<label for="userid">用户名</label>
					<select name="userid" id="userid" class="form-control select-chosen">
						<option value="default">-请选择-</option>
						<c:forEach items="${ userQuerys }" var="userQuery">
							<c:choose>
								<c:when test="${ userQuery.user.id.equals(punishment.userid) }">
									<option value="${ userQuery.user.id }" selected>${ userQuery.user.name }</option>
								</c:when>
								<c:otherwise>
									<option value="${ userQuery.user.id }">${ userQuery.user.name }</option>
								</c:otherwise>
							</c:choose>						
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="tournamentid">赛事类型</label>
					<select name="tournamentid" id="tournamentid" class="form-control select-chosen">
						<option value="default">-请选择-</option>
						<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
							<c:choose>
								<c:when test="${ tournamentQuery.tournament.id.equals(punishment.tournamentid) }">
									<option value="${ tournamentQuery.tournament.id }" selected>${ tournamentQuery.tournament.name }</option>
								</c:when>
								<c:otherwise>
									<option value="${ tournamentQuery.tournament.id }">${ tournamentQuery.tournament.name }</option>
								</c:otherwise>
							</c:choose>						
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="matchtime">比赛时间</label>
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</div>
						<input type="date" name="matchtime" id="matchtime" value="<fmt:formatDate value="${ punishment.matchtime }" pattern="yyyy-MM-dd"/>" class="form-control date" readonly data-date-format="yyyy-mm-dd"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="entry">参赛类型</label>
					<select name="entry" id="entry" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ individualEntryTypes }" var="individualEntryType">
							<c:choose>
								<c:when test="${ individualEntryType.key.equals(punishment.entry) }">
									<option value="${ individualEntryType.key }" selected>${ individualEntryType.value }</option>
								</c:when>
								<c:otherwise>
									<option value="${ individualEntryType.key }">${ individualEntryType.value }</option>
								</c:otherwise>
							</c:choose>						
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="points">扣除分数</label>
					<input type="number" name="points" id="points" value="${punishment.points}" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="invalid">是否有效</label>
					<c:choose>
						<c:when test="${ punishment.invalid.booleanValue() }">
							<input type="radio" name="invalid" id="invalidF" value="false"/>有效
							<input type="radio" name="invalid" id="invalidT" value="true" checked/>无效						
						</c:when>
						<c:otherwise>
							<input type="radio" name="invalid" id="invalidF" value="false" checked/>有效
							<input type="radio" name="invalid" id="invalidT" value="true"/>无效
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="form-group">
					<label for="note">注释</label>
					<input type="text" name="note" id="note" value="${punishment.note}" class="form-control"/>
				</div>
				
				<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
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