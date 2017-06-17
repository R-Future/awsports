<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- 引入bootstrap，由于bootstrap依赖jQuery,jquery.js必须在bootstrap.js之前引用 -->
<%-- <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script> --%>
</head>
<body>

<table class="table table-condensed">
	<c:forEach var="i" begin="0" end="${ doublematchQuerys.size()-1 }" step="1">
		<tbody>
			<tr>
				<th>主场选手vs客场选手</th>
				<td>
					<select name="doublematchQuerys[${i}].doublematch.homecontestant" class="">
						<option value="default">-请选择-</option>
						<c:forEach items="${ teamQuerys }" var="teamQuery">
						<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
					</c:forEach>
				</select>
				vs
				<select name="doublematchQuerys[${i}].doublematch.awayplayer" class="">
					<option value="default">-请选择-</option>
					<c:forEach items="${ teamQuerys }" var="teamQuery">
						<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<!-- 比分 -->
			<c:forEach var="j" begin="0" end="${ doublematchQuerys[i].doublematchscores.size()-1 }" step="1">
				<tr>
					<th>
						第<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].setth" value="${j+1}" class=""/>盘
					</th>
					<td>
						<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].hcscore" class=""/>									
						<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].hctiescore" value="0" class=""/>
						:
						<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].apscore" class=""/>
						<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].aptiescore" value="0" class=""/>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<th>挑战者</th>
				<td>
					<label>主场选手:</label>
					<input type="radio" name="doublematchQuerys[${i}].doublematch.ishcchallenger" id="HCChallengerF" value="false" checked/>不是
					<input type="radio" name="doublematchQuerys[${i}].doublematch.ishcchallenger" id="HCChallengerT" value="true"/>是
					<label>客场选手:</label>
					<input type="radio" name="doublematchQuerys[${i}].doublematch.isapchallenger" id="APChallengerF" value="false" checked/>不是
					<input type="radio" name="doublematchQuerys[${i}].doublematch.isapchallenger" id="APChallengerT" value="true"/>是
				</td>
			</tr>
			<tr>
				<th>是否退赛</th>
				<td>
					<label>主场选手:</label>
					<input type="radio" name="doublematchQuerys[${i}].doublematch.hcretired" id="HCRetiredF" value="false" checked/>未退赛
					<input type="radio" name="doublematchQuerys[${i}].doublematch.hcretired" id="HCRetiredT" value="true"/>退赛
					<label>客场选手:</label>
					<input type="radio" name="doublematchQuerys[${i}].doublematch.apretired" id="APRetiredF" value="false" checked/>未退赛
					<input type="radio" name="doublematchQuerys[${i}].doublematch.apretired" id="APRetiredT" value="true"/>退赛
				</td>
			</tr>
			<tr>								
				<th>注释</th>
				<td>
					<input type="text" name="doublematchQuerys[${i}].doublematch.note" class=""/>
				</td>							
			</tr>
		</tbody>
	</c:forEach>
</table>

</body>
</html>