<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<form class="form" action="<%=request.getContextPath()%>/singlematch/saveOld" method="post">
				<div id="basicInformation">
					<input type="hidden" name="singlematch.id" id="singlematchid" value="${ singlematchQuery.singlematch.id }" class="form-control"/>		
					<div class="form-group">
						<label for="singlematchMatchtime">比赛时间</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-clock-o"></i>
							</div>
							<input type="text" name="singlematch.matchtime" id="singlematchMatchtime" value="<fmt:formatDate value="${ singlematchQuery.singlematch.matchtime }" pattern="yyyy-MM-dd"/>" class="form-control date" readonly data-date-format="yyyy-mm-dd"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="singlematchMatchplace">比赛地点</label>
						<select name="singlematch.matchplace" id="singlematchMatchplace" class="form-control">
							<option value="default">-请选择-</option>
							<c:forEach items="${ arenas }" var="arena">
								<c:choose>
									<c:when test="${ arena.id.equals(singlematchQuery.singlematch.matchplace) }">
										<option value="${ arena.id }" selected>${ arena.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${ arena.id }">${ arena.name }</option>
									</c:otherwise>
								</c:choose>		
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="singlematchTournamentid">赛事类型</label>
						<select name="singlematch.tournamentid" id="singlematchTournamentid" class="form-control">
							<option value="default">-请选择-</option>
							<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
								<c:choose>
									<c:when test="${ tournamentQuery.tournament.id.equals(singlematchQuery.singlematch.tournamentid) }">
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
						<label for="singlematchRound">比赛轮次</label>
						<select name="singlematch.round" id="singlematchRound" class="form-control">
							<option value="default">-请选择-</option>
							<c:forEach items="${ roundTypes }" var="roundType">
								<c:choose>
									<c:when test="${ roundType.key.equals(singlematchQuery.singlematch.round) }">
										<option value="${ roundType.key }" selected>${ roundType.value }</option>
									</c:when>
									<c:otherwise>
										<option value="${ roundType.key }">${ roundType.value }</option>
									</c:otherwise>
								</c:choose>					
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="singlematchSets">比赛盘数</label>
						<input type="number" name="singlematch.sets" id="singlematchSets" value="${ singlematchQuery.singlematch.sets }" class="form-control"/>
					</div>
					
					<div class="form-group">
						<label for="singlematchNote">比赛注释</label>
						<input type="text" name="singlematch.note" id="singlematchNote" value="${ singlematchQuery.singlematch.note }" class="form-control"/>
					</div>
				</div>
				
				<div id="matchRecord">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<th>主场选手vs客场选手</th>
								<td>
								<select name="singlematch.homecontestant" class="">
									<option value="default">-请选择-</option>
									<c:forEach items="${ userQuerys }" var="userQuery">
										<c:choose>
											<c:when test="${ userQuery.user.id.equals(singlematchQuery.singlematch.homecontestant) }">
												<option value="${ userQuery.user.id }" selected>${ userQuery.user.name }</option>
											</c:when>
											<c:otherwise>
												<option value="${ userQuery.user.id }">${ userQuery.user.name }</option>
											</c:otherwise>
										</c:choose>										
									</c:forEach>
								</select>
								vs
								<select name="singlematch.awayplayer" class="">
									<option value="default">-请选择-</option>
									<c:forEach items="${ userQuerys }" var="userQuery">
										<c:choose>
											<c:when test="${ userQuery.user.id.equals(singlematchQuery.singlematch.awayplayer) }">
												<option value="${ userQuery.user.id }" selected>${ userQuery.user.name }</option>
											</c:when>
											<c:otherwise>
												<option value="${ userQuery.user.id }">${ userQuery.user.name }</option>
											</c:otherwise>
										</c:choose>	
									</c:forEach>
								</select>
								</td>
							</tr>
							<!-- 比分 -->
							<c:forEach var="i" begin="0" end="${ singlematchQuery.singlematchscores.size()-1 }" step="1">
								<input type="hidden" name="singlematchscores[${i}].id" id="singlematchscoreid" value="${ singlematchQuery.singlematchscores[i].id }" class="form-control"/>
								<tr>
									<th>
										第<input type="number" name="singlematchscores[${i}].setth" value="${ singlematchQuery.singlematchscores[i].setth }" class=""/>盘
									</th>
									<th>注释</th>
									<th>比分是否有效</th>
								</tr>
								<tr>
									<td>
										<input type="number" name="singlematchscores[${i}].hcscore" value="${ singlematchQuery.singlematchscores[i].hcscore }" class=""/>									
										<input type="number" name="singlematchscores[${i}].hctiescore" value="${ singlematchQuery.singlematchscores[i].hctiescore }" class=""/>
										:
										<input type="number" name="singlematchscores[${i}].apscore" value="${ singlematchQuery.singlematchscores[i].apscore }" class=""/>
										<input type="number" name="singlematchscores[${i}].aptiescore" value="${ singlematchQuery.singlematchscores[i].aptiescore }" class=""/>
									</td>
									
									<td><input type="text" name="singlematchscores[${i}].note" value="${ singlematchQuery.singlematchscores[i].note }" class=""/></td>
									
									<td>
									<c:choose>
										<c:when test="${ !singlematchQuery.singlematchscores[i].invalid }">
											<input type="radio" name="singlematchscores[${i}].invalid" id="scoreinvalidF" value="false" checked/>有效
											<input type="radio" name="singlematchscores[${i}].invalid" id="scoreinvalidT" value="true"/>无效
										</c:when>
										<c:otherwise>
											<input type="radio" name="singlematchscores[${i}].invalid" id="scoreinvalidF" value="false"/>有效
											<input type="radio" name="singlematchscores[${i}].invalid" id="scoreinvalidT" value="true"  checked/>无效
										</c:otherwise>
									</c:choose>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="form-group">
					<label>主场选手:</label>
					<c:choose>
						<c:when test="${ !singlematchQuery.singlematch.ishcchallenger }">
							<input type="radio" name="singlematch.ishcchallenger" id="HCChallengerF" value="false" checked/>不是挑战者
							<input type="radio" name="singlematch.ishcchallenger" id="HCChallengerT" value="true"/>是挑战者
						</c:when>
						<c:otherwise>
							<input type="radio" name="singlematch.ishcchallenger" id="HCChallengerF" value="false"/>不是挑战者
							<input type="radio" name="singlematch.ishcchallenger" id="HCChallengerT" value="true" checked/>是挑战者
						</c:otherwise>
					</c:choose>
				</div>
				<div class="form-group">
					<label>客场选手:</label>
					<c:choose>
						<c:when test="${ !singlematchQuery.singlematch.isapchallenger }">
							<input type="radio" name="singlematch.isapchallenger" id="APChallengerF" value="false" checked/>不是挑战者
							<input type="radio" name="singlematch.isapchallenger" id="APChallengerT" value="true"/>是挑战者
						</c:when>
						<c:otherwise>
							<input type="radio" name="singlematch.isapchallenger" id="APChallengerF" value="false"/>不是挑战者
							<input type="radio" name="singlematch.isapchallenger" id="APChallengerT" value="true" checked/>是挑战者
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="form-group">
					<label>主场选手:</label>
					<c:choose>
						<c:when test="${ !singlematchQuery.singlematch.hcretired }">
							<input type="radio" name="singlematch.hcretired" id="HCRetiredF" value="false" checked/>未退赛
							<input type="radio" name="singlematch.hcretired" id="HCRetiredT" value="true"/>退赛
						</c:when>
						<c:otherwise>
							<input type="radio" name="singlematch.hcretired" id="HCRetiredF" value="false"/>未退赛
							<input type="radio" name="singlematch.hcretired" id="HCRetiredT" value="true" checked/>退赛
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="form-group">
					<label>客场选手:</label>
					<c:choose>
						<c:when test="${ !singlematchQuery.singlematch.apretired }">
							<input type="radio" name="singlematch.apretired" id="APRetiredF" value="false" checked/>未退赛
							<input type="radio" name="singlematch.apretired" id="APRetiredT" value="true"/>退赛
						</c:when>
						<c:otherwise>
							<input type="radio" name="singlematch.apretired" id="APRetiredF" value="false"/>未退赛
							<input type="radio" name="singlematch.apretired" id="APRetiredT" value="true"  checked/>退赛
						</c:otherwise>
					</c:choose>	
			 	</div>
			 	
			 	<div class="form-group">
					<label>比赛是否有效</label>
					<c:choose>
						<c:when test="${ !singlematchQuery.singlematch.invalid }">
							<input type="radio" name="singlematch.invalid" id="matchinvalidF" value="false" checked/>有效
							<input type="radio" name="singlematch.invalid" id="matchinvalidT" value="true"/>无效
						</c:when>
						<c:otherwise>
							<input type="radio" name="singlematch.invalid" id="matchinvalidF" value="false"/>有效
							<input type="radio" name="singlematch.invalid" id="matchinvalidT" value="true" checked/>无效
						</c:otherwise>
					</c:choose>
			 	</div>
				
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