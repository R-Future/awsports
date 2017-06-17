<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>	
</head>
<body>
<div class="container-fluid">
	<div class="row" style="color:red">
		<c:if test="${errors!=null}">
			<c:forEach items="${errors.allErrors}" var="error">
				${error.defaultMessage}<br/>
			</c:forEach>
		</c:if>
	</div>
	<div class="row">
		<form class="form" action="<%=request.getContextPath()%>/doublematch/saveOld" method="post">
			<div id="basicInformation">
				<input type="hidden" name="doublematch.id" id="doublematchid" value="${ doublematchQuery.doublematch.id }" class="form-control"/>		
				<div class="form-group">
					<label for="doublematchMatchtime">比赛时间</label>
					<input type="date" name="doublematch.matchtime" id="doublematchMatchtime" value="<fmt:formatDate value="${ doublematchQuery.doublematch.matchtime }" pattern="yyyy-MM-dd"/>" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="doublematchMatchplace">比赛地点</label>
					<select name="doublematch.matchplace" id="doublematchMatchplace" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ arenas }" var="arena">
							<c:choose>
								<c:when test="${ arena.id.equals(doublematchQuery.doublematch.matchplace) }">
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
					<label for="doublematchTournamentid">赛事类型</label>
					<select name="doublematch.tournamentid" id="doublematchTournamentid" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
							<c:choose>
								<c:when test="${ tournamentQuery.tournament.id.equals(doublematchQuery.doublematch.tournamentid) }">
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
					<label for="doublematchRound">比赛轮次</label>
					<select name="doublematch.round" id="doublematchRound" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ roundTypes }" var="roundType">
							<c:choose>
								<c:when test="${ roundType.key.equals(doublematchQuery.doublematch.round) }">
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
					<label for="doublematchSets">比赛盘数</label>
					<input type="number" name="doublematch.sets" id="doublematchSets" value="${ doublematchQuery.doublematch.sets }" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="doublematchNote">比赛注释</label>
					<input type="text" name="doublematch.note" id="doublematchNote" value="${ doublematchQuery.doublematch.note }" class="form-control"/>
				</div>
			</div>
			
			<div id="matchRecord">
				<table class="table table-condensed">
					<tbody>
						<tr>
							<th>主场选手vs客场选手</th>
							<td>
							<select name="doublematch.homecontestant" class="">
								<option value="default">-请选择-</option>
								<c:forEach items="${ teamQuerys }" var="teamQuery">
									<c:choose>
										<c:when test="${ teamQuery.team.id.equals(doublematchQuery.doublematch.homecontestant) }">
											<option value="${ teamQuery.team.id }" selected>${ teamQuery.team.name }</option>
										</c:when>
										<c:otherwise>
											<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
										</c:otherwise>
									</c:choose>										
								</c:forEach>
							</select>
							vs
							<select name="doublematch.awayplayer" class="">
								<option value="default">-请选择-</option>
								<c:forEach items="${ teamQuerys }" var="teamQuery">
									<c:choose>
										<c:when test="${ teamQuery.team.id.equals(doublematchQuery.doublematch.awayplayer) }">
											<option value="${ teamQuery.team.id }" selected>${ teamQuery.team.name }</option>
										</c:when>
										<c:otherwise>
											<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
							</select>
							</td>
						</tr>
						<!-- 比分 -->
						<c:forEach var="i" begin="0" end="${ doublematchQuery.doublematchscores.size()-1 }" step="1">
							<input type="hidden" name="doublematchscores[${i}].id" id="doublematchscoreid" value="${ doublematchQuery.doublematchscores[i].id }" class="form-control"/>
							<tr>
								<th>
									第<input type="number" name="doublematchscores[${i}].setth" value="${ doublematchQuery.doublematchscores[i].setth }" class=""/>盘
								</th>
								<th>注释</th>
								<th>比分是否有效</th>
							</tr>
							<tr>
								<td>
									<input type="number" name="doublematchscores[${i}].hcscore" value="${ doublematchQuery.doublematchscores[i].hcscore }" class=""/>									
									<input type="number" name="doublematchscores[${i}].hctiescore" value="${ doublematchQuery.doublematchscores[i].hctiescore }" class=""/>
									:
									<input type="number" name="doublematchscores[${i}].apscore" value="${ doublematchQuery.doublematchscores[i].apscore }" class=""/>
									<input type="number" name="doublematchscores[${i}].aptiescore" value="${ doublematchQuery.doublematchscores[i].aptiescore }" class=""/>
								</td>
								
								<td><input type="text" name="doublematchscores[${i}].note" value="${ doublematchQuery.doublematchscores[i].note }" class=""/></td>
								
								<td>
								<c:choose>
									<c:when test="${ !doublematchQuery.doublematchscores[i].invalid }">
										<input type="radio" name="doublematchscores[${i}].invalid" id="scoreinvalidF" value="false" checked/>有效
										<input type="radio" name="doublematchscores[${i}].invalid" id="scoreinvalidT" value="true"/>无效
									</c:when>
									<c:otherwise>
										<input type="radio" name="doublematchscores[${i}].invalid" id="scoreinvalidF" value="false"/>有效
										<input type="radio" name="doublematchscores[${i}].invalid" id="scoreinvalidT" value="true"  checked/>无效
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
					<c:when test="${ !doublematchQuery.doublematch.ishcchallenger }">
						<input type="radio" name="doublematch.ishcchallenger" id="HCChallengerF" value="false" checked/>不是挑战者
						<input type="radio" name="doublematch.ishcchallenger" id="HCChallengerT" value="true"/>是挑战者
					</c:when>
					<c:otherwise>
						<input type="radio" name="doublematch.ishcchallenger" id="HCChallengerF" value="false"/>不是挑战者
						<input type="radio" name="doublematch.ishcchallenger" id="HCChallengerT" value="true" checked/>是挑战者
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-group">
				<label>客场选手:</label>
				<c:choose>
					<c:when test="${ !doublematchQuery.doublematch.isapchallenger }">
						<input type="radio" name="doublematch.isapchallenger" id="APChallengerF" value="false" checked/>不是挑战者
						<input type="radio" name="doublematch.isapchallenger" id="APChallengerT" value="true"/>是挑战者
					</c:when>
					<c:otherwise>
						<input type="radio" name="doublematch.isapchallenger" id="APChallengerF" value="false"/>不是挑战者
						<input type="radio" name="doublematch.isapchallenger" id="APChallengerT" value="true" checked/>是挑战者
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="form-group">
				<label>主场选手:</label>
				<c:choose>
					<c:when test="${ !doublematchQuery.doublematch.hcretired }">
						<input type="radio" name="doublematch.hcretired" id="HCRetiredF" value="false" checked/>未退赛
						<input type="radio" name="doublematch.hcretired" id="HCRetiredT" value="true"/>退赛
					</c:when>
					<c:otherwise>
						<input type="radio" name="doublematch.hcretired" id="HCRetiredF" value="false"/>未退赛
						<input type="radio" name="doublematch.hcretired" id="HCRetiredT" value="true" checked/>退赛
					</c:otherwise>
				</c:choose>
			</div>
			
			<div>
				<label>客场选手:</label>
				<c:choose>
					<c:when test="${ !doublematchQuery.doublematch.apretired }">
						<input type="radio" name="doublematch.apretired" id="APRetiredF" value="false" checked/>未退赛
						<input type="radio" name="doublematch.apretired" id="APRetiredT" value="true"/>退赛
					</c:when>
					<c:otherwise>
						<input type="radio" name="doublematch.apretired" id="APRetiredF" value="false"/>未退赛
						<input type="radio" name="doublematch.apretired" id="APRetiredT" value="true"  checked/>退赛
					</c:otherwise>
				</c:choose>	
		 	</div>
		 	
		 	<div>
				<label>比赛是否有效</label>
				<c:choose>
					<c:when test="${ !doublematchQuery.doublematch.invalid }">
						<input type="radio" name="doublematch.invalid" id="matchinvalidF" value="false" checked/>有效
						<input type="radio" name="doublematch.invalid" id="matchinvalidT" value="true"/>无效
					</c:when>
					<c:otherwise>
						<input type="radio" name="doublematch.invalid" id="matchinvalidF" value="false"/>有效
						<input type="radio" name="doublematch.invalid" id="matchinvalidT" value="true" checked/>无效
					</c:otherwise>
				</c:choose>
		 	</div>
			
			<button type="submit" id="submit" class="btn btn-default">提交</button>
		</form>
	</div>
</div>
</body>
</html>