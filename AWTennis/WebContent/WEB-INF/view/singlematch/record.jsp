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
<script type="text/javascript">
// 	$(document).ready(function(){
// 		var TotalSets=document.getElementsByClassName("setth");
// 		var matches=document.getElementsByTagName("tbody");
// 		var setsPerMatch=TotalSets.length/matches.length;
// 		for(var i=0;i<TotalSets.length;i++){
// 			TotalSets[i].setAttribute("value",(i%setsPerMatch+1));
// 		}
// 	});
</script>
</head>
<body>

<table class="table table-condensed">
	<c:forEach var="i" begin="0" end="${ singlematchQuerys.size()-1 }" step="1">
		<tbody>
			<tr>
				<th>主场选手vs客场选手</th>
				<td>
					<select name="singlematchQuerys[${i}].singlematch.homecontestant" class="">
						<option value="default">-请选择-</option>
						<c:forEach items="${ users }" var="user">
						<option value="${ user.id }">${ user.name }</option>
					</c:forEach>
				</select>
				vs
				<select name="singlematchQuerys[${i}].singlematch.awayplayer" class="">
					<option value="default">-请选择-</option>
					<c:forEach items="${ users }" var="user">
						<option value="${ user.id }">${ user.name }</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<!-- 比分 -->
			<c:forEach var="j" begin="0" end="${ singlematchQuerys[i].singlematchscores.size()-1 }" step="1">
				<tr>
					<th>
						第<input type="number" name="singlematchQuerys[${i}].singlematchscores[${j}].setth" value="${j+1}" class="setth"/>盘
					</th>
					<td>
						<input type="number" name="singlematchQuerys[${i}].singlematchscores[${j}].hcscore" class=""/>									
						<input type="number" name="singlematchQuerys[${i}].singlematchscores[${j}].hctiescore" value="0" class=""/>
						:
						<input type="number" name="singlematchQuerys[${i}].singlematchscores[${j}].apscore" class=""/>
						<input type="number" name="singlematchQuerys[${i}].singlematchscores[${j}].aptiescore" value="0" class=""/>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<th>挑战者</th>
				<td>
					<label>主场选手:</label>
					<input type="radio" name="singlematchQuerys[${i}].singlematch.ishcchallenger" id="HCChallengerF" value="false" checked/>不是
					<input type="radio" name="singlematchQuerys[${i}].singlematch.ishcchallenger" id="HCChallengerT" value="true"/>是
					<label>客场选手:</label>
					<input type="radio" name="singlematchQuerys[${i}].singlematch.isapchallenger" id="APChallengerF" value="false" checked/>不是
					<input type="radio" name="singlematchQuerys[${i}].singlematch.isapchallenger" id="APChallengerT" value="true"/>是
				</td>
			</tr>
			<tr>
				<th>是否退赛</th>
				<td>
					<label>主场选手:</label>
					<input type="radio" name="singlematchQuerys[${i}].singlematch.hcretired" id="HCRetiredF" value="false" checked/>未退赛
					<input type="radio" name="singlematchQuerys[${i}].singlematch.hcretired" id="HCRetiredT" value="true"/>退赛
					<label>客场选手:</label>
					<input type="radio" name="singlematchQuerys[${i}].singlematch.apretired" id="APRetiredF" value="false" checked/>未退赛
					<input type="radio" name="singlematchQuerys[${i}].singlematch.apretired" id="APRetiredT" value="true"/>退赛
				</td>
			</tr>
			<tr>								
				<th>注释</th>
				<td>
					<input type="text" name="singlematchQuerys[${i}].singlematch.note" class=""/>
				</td>							
			</tr>
		</tbody>
	</c:forEach>
</table>

</body>
</html>