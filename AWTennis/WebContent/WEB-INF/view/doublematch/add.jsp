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
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){		
		//动态添加比赛记录
		$("a#add").click(function(){
			$.ajax({
				type:"post",
				url:"addRecord",
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				data:{matches:$("input#numberOfMatches").val(),sets:$("input#setsOfMatch").val()},
				dataType:"html",
				success: function(data){
					$("div#matchRecord").html(data);
				}
			});
		});
		
	});
</script>
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
		<form class="form" action="<%=request.getContextPath()%>/doublematch/saveNew" method="post">
			<div id="basicInformation">
				<div class="form-group">
					<label for="matchtime">比赛时间</label>
					<input type="date" name="matchtime" id="matchtime"class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="matchplace">比赛地点</label>
					<select name="matchplace" id="matchplace" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ arenas }" var="arena">
							<option value="${ arena.id }">${ arena.name }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="tournamentid">赛事类型</label>
					<select name="tournamentid" id="tournamentid" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
							<option value="${ tournamentQuery.tournament.id }">${ tournamentQuery.tournament.name }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="round">比赛轮次</label>
					<select name="round" id="round" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ roundTypes }" var="roundType">
							<option value="${ roundType.key }">${ roundType.value }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="setsOfMatch">比赛盘数</label>
					<input type="number" name="sets" id="setsOfMatch" value="1" class="form-control"/>
				</div>
			</div>
			
			<div id="addMatch">
				<label for="numberOfMatches">需要记录的比赛数:</label>
				<input type="number" name="numberOfMatches" id="numberOfMatches" value="1" class=""/>
				<a id="add">确定</a>
			</div>
			
			<div id="matchRecord"></div>
			<button type="submit" id="submit" class="btn btn-default">提交</button>
		</form>
	</div>
</div>
</body>
</html>