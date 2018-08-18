<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<hr>
<table class="table table-condensed">
	<c:if test="${ doublematchQuerys.size()>0 }">
		<c:forEach var="i" begin="0" end="${ doublematchQuerys.size()-1 }" step="1">
			<tbody>
				<tr>
					<th><i style="color:red">*</i> 主场选手vs客场选手</th>
					<td>
					<select name="doublematchQuerys[${i}].doublematch.homecontestant" class="" onchange="verifyPlayer(this)">
						<option value="0">-请选择-</option>
						<c:forEach items="${ teamQuerys }" var="teamQuery">
							<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
						</c:forEach>
					</select>
					vs
					<select name="doublematchQuerys[${i}].doublematch.awayplayer" class="" onchange="verifyPlayer(this)">
						<option value="0">-请选择-</option>
						<c:forEach items="${ teamQuerys }" var="teamQuery">
							<option value="${ teamQuery.team.id }">${ teamQuery.team.name }</option>
						</c:forEach>
					</select>
					<span style="color:red"></span>
					</td>
				</tr>
				<!-- 比分 -->
				<c:forEach var="j" begin="0" end="${ doublematchQuerys[i].doublematchscores.size()-1 }" step="1">
					<tr>
						<th>
							<i style="color:red">*</i> 
							第<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].setth" value="${j+1}" class="" readonly/>盘
						</th>
						<td>
							<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].hcscore"  class="score" onfocus="verifyScoreOn(this)" onblur="verifyScoreOff(this)" onchange="verifyScoreOff(this)"/>									
							<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].hctiescore" value="0" readonly class="tieScore" onfocus="verifyTieScoreOn(this)" onblur="verifyTieScoreOff(this)" onchange="verifyTieScoreOff(this)"/>
							:
							<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].apscore"  class="score" onfocus="verifyScoreOn(this)" onblur="verifyScoreOff(this)" onchange="verifyScoreOff(this)"/>
							<input type="number" name="doublematchQuerys[${i}].doublematchscores[${j}].aptiescore" value="0" readonly class="tieScore" onfocus="verifyTieScoreOn(this)" onblur="verifyTieScoreOff(this)" onchange="verifyTieScoreOff(this)"/>
							<span style="color:red"></span>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<th><i style="color:red">*</i> 挑战者</th>
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
					<th><i style="color:red">*</i> 是否退赛</th>
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
	</c:if>
</table>
<script>
/* select with search */
$(function(){
	$("select").chosen();
});

//console.log($("td.players"));
/* verify if you input players */
function verifyPlayer(select){
	var playerId = $(select).find("option:selected").val();
	var opponentId = $(select).siblings("select").find("option:selected").val();
	var self = $(select);
	var opponent = $(select).siblings("select");
	var error = $(select).siblings("span");
	if("0" == playerId){
		self.css("border","1px solid red");
		error.html("请选择球员");
		//console.log("test");
	}else if(playerId == opponentId){
		self.css("border","1px solid red");
		opponent.css("border","1px solid red");
		error.html("比赛双方不能为同一人");
	}else{
		self.css("border","1px solid black");
		opponent.css("border","1px solid black");
		error.html("");
	}
}

/* verify match score */
function verifyScoreOn(input){
	$(input).css("border","1px solid black");
	$(input).siblings("span").html("");
}

function verifyScoreOff(input){
	var self = $(input);
	var opponent = self.siblings("input.score");
	var tieBreak = self.siblings("input.tieScore");
	var selfScore = Number(self.val());
	var opponentScore = Number(opponent.val());
	var error = self.siblings("span");
	if(self.val().trim() == ""){
		self.css("border","1px solid red");
		error.html("请输入比分");
	}else{
		if(isNaN(selfScore) || selfScore < 0){
			self.css("border","1px solid red");
			error.html("输入的比分必须为数字且大于等于0");
		}else{
			if(opponent.val().trim() != "" && !isNaN(opponentScore) && opponentScore >=0){
				if(Math.abs(selfScore-opponentScore)==1){
					//tie break
					tieBreak.removeAttr("readonly","readonly");
					tieBreak.css("border","1px solid red");
					error.html("请输入抢七比分");
				}else{
					tieBreak.css("border","1px solid black");
					tieBreak.attr("readonly","readonly");
					error.html("");
				}
			}else{
				self.css("border","1px solid black");
				error.html("");
			}
		}
	}
}

/* verify tie break score */

function clearCSS(element){
	element.css("border","1px solid black");
	element.attr("readonly","readonly");
}

function verifyTieScoreOn(input){
	$(input).css("border","1px solid black");
	$(input).siblings("span").html("");
}

function verifyTieScoreOff(input){
	var self = $(input);
	var opponent = self.siblings("input.tieScore");
	var selfScore = Number(self.prev().val());
	var opponentScore = Number(opponent.prev().val());
	var selfTieScore = Number(self.val());
	var opponentTieScore = Number(opponent.val());
	var error = self.siblings("span");
	//console.log(selfScore+":"+opponentScore);
	/* if the match scores are not input, you can't input tie break scores */
	if(self.prev().val()==""||opponent.prev().val()==""){
		clearCSS(self);
		clearCSS(opponent);
		error.html("");
	}else{
		/* you can't input tie break scores until the match was played into tie break*/
		if(Math.abs(selfScore - opponentScore)!=1){
			clearCSS(self);
			clearCSS(opponent);
			error.html("");
		}else{
			if(self.val().trim() == "" || isNaN(selfTieScore) || selfTieScore < 0){
				self.css("border", "1px solid red");
				error.html("输入的比分必须为数字且大于等于0");
			}else{
				opponent.css("border", "1px solid black");
				if(opponent.val().trim() != "" && !isNaN(opponentTieScore) && opponentTieScore >= 0){
					if((selfScore - opponentScore) * (selfTieScore - opponentTieScore) <= 0){
						self.css("border", "1px solid red");
						error.html("抢七比分输入错误");
					}else{
						if(selfScore > opponentScore && selfTieScore < 7){
							self.css("border", "1px solid red");
							error.html("抢七比分输入错误");
						}else{
							self.css("border","1px solid black");
							error.html("");
						}
					}
				}else{
					self.css("border","1px solid black");
					error.html("");
				}
			}
		}
	}
}
</script>