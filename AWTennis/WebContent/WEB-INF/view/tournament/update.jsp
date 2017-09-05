<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛事信息</title>
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
        <li><a href="<%=request.getContextPath()%>/tournament/list">赛事信息</a></li>
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
		</div>
		
		<form class="form" action="<%=request.getContextPath()%>/tournament/save" method="post">
			<input type="hidden" name="id" id="id" value="${tournament.id}" class="form-control"/>
			
			<div class="form-group">
				<label for="name">赛事名称</label>
				<input type="text" name="name" id="name" value="${tournament.name}" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="level">赛事级别</label>
				<input type="text" name="level" id="level" value="${tournament.level}" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="arenaid">赛事地点</label>
				<select name="arenaid" id="arenaid" class="form-control">
					<option>-请选择-</option>
					<c:forEach items="${arenas}" var="arena">
						<c:choose>
							<c:when test="${arena.id.equals(tournament.arenaid)}">
								<option value="${arena.id}" selected="selected">${arena.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${arena.id}">${arena.name}</option>
							</c:otherwise>
						</c:choose>	
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="mode">赛事模式(用于计算积分)</label>
				<select name="mode" id="mode" class="form-control">
					<option>-请选择-</option>
					<c:forEach items="${ tournamentModes }" var="tournamentMode">
						<c:choose>
							<c:when test="${ tournamentMode.getKey().equals(tournament.mode) }">
								<option value="${ tournamentMode.getKey() }" selected="selected">${ tournamentMode.getValue() }</option>
							</c:when>
							<c:otherwise>
								<option value="${ tournamentMode.getKey() }">${ tournamentMode.getValue() }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="startedat">开始时间</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-clock-o"></i>
							</div>
							<input type="text" name="startedat" id="startedat" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${tournament.startedat}"/>" class="form-control datetime" readonly data-date-format="yyyy-mm-dd hh:ii:ss"/>
						</div>
					</div>
					<div class="col-md-6">
						<label for="endedat">结束时间</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-clock-o"></i>
							</div>
							<input type="text" name="endedat" id="endedat" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${tournament.endedat}"/>" class="form-control datetime" readonly data-date-format="yyyy-mm-dd hh:ii:ss"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="prize">赛事奖金</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-rmb"></i>
					</div>
					<input type="number" name="prize" id="prize" value="${tournament.prize}" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="cost">参赛费用(每人)</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-rmb"></i>
					</div>
					<input type="number" name="cost" id="cost" value="${tournament.cost}" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="note">注释</label>
				<input type="text" name="note" id="note" value="${tournament.note}" class="form-control"/>
			</div>
			
			<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button>
		</form>
		
	</div>
	</section>
</div>
<script>
	var date=new Date();
	$("input.datetime").datetimepicker({
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
		format:'yyyy-mm-dd hh:ii:ss',
		/* 开始时间，该时间前的所有时间不能选择 */
		startDate:date,
		/* 当前日期按钮 */
		todayBtn: true,
		/* 当天日期高亮 */
		todayHighlight: true,
		/* 显示语言 */
		language: 'zh-CN'
	});
</script>
<jsp:include page="../footer.jsp"/>