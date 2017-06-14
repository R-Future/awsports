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
		var tbodys=document.getElementsByClassName("interimScores");
		//根据比赛盘数动态添加比分记录，默认一盘
		$("input#singlematchSets").change(function(){
			var sets=$("input#singlematchSets").val();
			clear(tbodys);//清空之前创建的表格
			for(var k=0;k<tbodys.length;k++){
				for(var i=1;i<sets;i++){
					var tr=document.createElement("tr");
					var th=document.createElement("th");
					var td=document.createElement("td");
					var text1=document.createTextNode("第");
					var text2=document.createTextNode("盘");
					var inputSetth=document.createElement("input");
					var inputHCScore=document.createElement("input");
					var inputHCTieScore=document.createElement("input");
					var inputAPScore=document.createElement("input");
					var inputAPTieScore=document.createElement("input");
					var text3=document.createTextNode(":");
					inputSetth.setAttribute("name","singlematchscore.setth");
					inputSetth.setAttribute("type","number");
					th.appendChild(text1);
					th.appendChild(inputSetth);
					th.appendChild(text2);
					inputHCScore.setAttribute("name","singlematchscore.hcscore");
					inputHCScore.setAttribute("type","number");
					inputHCTieScore.setAttribute("name","singlematchscore.hctiescore");
					inputHCTieScore.setAttribute("type","number");
					inputAPScore.setAttribute("name","singlematchscore.apscore");
					inputAPScore.setAttribute("type","number");
					inputAPTieScore.setAttribute("name","singlematchscore.aptiescore");
					inputAPTieScore.setAttribute("type","number");
					td.appendChild(inputHCScore);
					td.appendChild(inputHCTieScore);
					td.appendChild(text3);
					td.appendChild(inputAPScore);
					td.appendChild(inputAPTieScore);
					tr.appendChild(th);
					tr.appendChild(td);
					tbodys[k].appendChild(tr);
				}	
			}
		});
		//动态添加比赛记录
		$("a#add").click(function(){
			$.ajax({
				type:"post",
				url:"addRecord",
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				data:{matches:$("input#numberOfMatches").val(),sets:$("input#singlematchSets").val()},
				dataType:"html",
				success: function(data){
					$("div#matchRecord").html(data);
				}
			});
		});
		
	});
	
	function clear(tbodys){
		for(var i=0;i<tbodys.length;i++){
			while(tbodys[i].childNodes.length>0){
				tbodys[i].removeChild(tbodys[i].firstChild)
			}
		}
	}
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
		<form class="form" action="<%=request.getContextPath()%>/singlematch/saveNew" method="post">
			<div id="basicInformation">
<!-- 				<input type="hidden" name="singlematch.id" id="singlematchid" class="form-control"/> -->		
				<div class="form-group">
					<label for="singlematchMatchtime">比赛时间</label>
					<input type="date" name="matchtime" id="singlematchMatchtime"class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="singlematchMatchplace">比赛地点</label>
					<select name="matchplace" id="singlematchMatchplace" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ arenas }" var="arena">
							<option value="${ arena.id }">${ arena.name }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="singlematchTournamentid">赛事类型</label>
					<select name="tournamentid" id="singlematchTournamentid" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ tournamentQuerys }" var="tournamentQuery">
							<option value="${ tournamentQuery.tournament.id }">${ tournamentQuery.tournament.name }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="singlematchRound">比赛轮次</label>
					<select name="round" id="singlematchRound" class="form-control">
						<option value="default">-请选择-</option>
						<c:forEach items="${ roundTypes }" var="roundType">
							<option value="${ roundType.key }">${ roundType.value }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="singlematchSets">比赛盘数</label>
					<input type="number" name="sets" id="singlematchSets" value="1" class="form-control"/>
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