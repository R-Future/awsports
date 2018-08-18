<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比赛数据统计</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>${ homeStatistic.user.name } vs ${ guestStatistic.user.name }</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="<%=request.getContextPath()%>/event/detail?id=${eventId}">活动信息</a></li>
<%--         <li class="active">${ event.name }</li> --%>
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
		<form class="form" action="<%=request.getContextPath()%>/statistic/save?eventId=${eventId}" method="post">
          	<table class="table table-striped table-responsive" style="text-align:center;">
          		<tbody>
          			<tr>
          				<td>${ homeStatistic.user.name }</td>
          				<td>vs</td>
          				<td>${ guestStatistic.user.name }</td>
          			</tr>
          			<tr>
          				<td colspan="3" style="font-weight: bold;">发球数据</td>
          			</tr>
          			<tr>
          				<td><input type="number" class="form-control" name="homeStatistic.statistic.services" id="homeStatistic.statistic.services" value="${ homeStatistic.statistic.services }"/></td>
          				<td>发球局</td>
          				<td><input type="number" class="form-control" name="guestStatistic.statistic.services" id="guestStatistic.statistic.services" value="${ guestStatistic.statistic.services }"/></td>
          			</tr>
          			<tr>
          				<td><input type ="number" class="form-control" name="homeStatistic.statistic.aces" id="homeStatistic.statistic.aces" value="${ homeStatistic.statistic.aces }"/></td>
          				<td>ACE球</td>
          				<td><input type ="number" class="form-control" name="guestStatistic.statistic.aces" id="guestStatistic.statistic.aces" value="${ guestStatistic.statistic.aces }"/></td>
          			</tr>
          			<tr>
          				<td><input type ="number" class="form-control" name="homeStatistic.statistic.doublefaults" id="homeStatistic.statistic.doublefaults" value="${ homeStatistic.statistic.doublefaults }"/></td>
						<td>双误</td>
						<td><input type ="number" class="form-control" name="guestStatistic.statistic.doublefaults" id="guestStatistic.statistic.doublefaults" value="${ guestStatistic.statistic.doublefaults }"/></td>		          				
          			</tr>
          			<tr>
          				<td>
          				<input type ="number" class="form-control" name="homeStatistic.statistic.firstservices" id="homeStatistic.statistic.firstservices" value="${ homeStatistic.statistic.firstservices}"/>
          				(${ homeStatistic.statistic.firstservices/(homeStatistic.statistic.firstservices+homeStatistic.statistic.secondservices+homeStatistic.statistic.doublefaults)*100 }%)
          				</td>
          				<td>一发成功率</td>
          				<td>
          				<input type ="number" class="form-control" name="guestStatistic.statistic.firstservices" id="guestStatistic.statistic.firstservices" value="${ guestStatistic.statistic.firstservices}"/>
          				(${ guestStatistic.statistic.firstservices/(guestStatistic.statistic.firstservices+guestStatistic.statistic.secondservices+guestStatistic.statistic.doublefaults)*100 }%)
          				</td>
          			</tr>
          			<tr>
          				<td>
          				<input type ="number" class="form-control" name="homeStatistic.statistic.firstgoals" id="homeStatistic.statistic.firstgoals" value="${ homeStatistic.statistic.firstgoals }"/>/<input type ="number" class="form-control" name="homeStatistic.statistic.firstservices" id="homeStatistic.statistic.firstservices" value="${ homeStatistic.statistic.firstservices }"/>
          				</td>
          				<td>一发得分</td>
          				<td>
          				<input type ="number" class="form-control" name="guestStatistic.statistic.firstgoals" id="guestStatistic.statistic.firstgoals" value="${ guestStatistic.statistic.firstgoals }"/>/<input type ="number" class="form-control" name="guestStatistic.statistic.firstservices" id="guestStatistic.statistic.firstservices" value="${ guestStatistic.statistic.firstservices }"/>
          				</td>
          			</tr>
          			<tr>
          				<td>
          				<input type ="number" class="form-control" name="homeStatistic.statistic.secondgoals" id="homeStatistic.statistic.secondgoals" value="${ homeStatistic.statistic.secondgoals }"/>/<input type ="number" class="form-control" name="homeStatistic.statistic.secondservices" id="homeStatistic.statistic.secondservices" value="${ homeStatistic.statistic.secondservices }"/>
          				</td>
          				<td>二发得分</td>
          				<td>
          				<input type ="number" class="form-control" name="guestStatistic.statistic.secondgoals" id="guestStatistic.statistic.secondgoals" value="${ guestStatistic.statistic.secondgoals }"/>/<input type ="number" class="form-control" name="guestStatistic.statistic.secondservices" id="guestStatistic.statistic.secondservices" value="${ guestStatistic.statistic.secondservices }"/>
          				</td>
          			</tr>
          			<tr>
          				<td>
	          				<input type ="number" class="form-control" name="homeStatistic.statistic.savebreakpoints" id="homeStatistic.statistic.savebreakpoints" value="${ homeStatistic.statistic.savebreakpoints }"/>/<input type ="number" class="form-control" name="homeStatistic.statistic.servicebreakpoints" id="homeStatistic.statistic.servicebreakpoints" value="${ homeStatistic.statistic.servicebreakpoints }"/>
          				</td>
          				<td>挽回破发点</td>
          				<td>
	          				<input type ="number" class="form-control" name="guestStatistic.statistic.savebreakpoints" id="guestStatistic.statistic.savebreakpoints" value="${ guestStatistic.statistic.savebreakpoints }"/>/<input type ="number" class="form-control" name="guestStatistic.statistic.servicebreakpoints" id="guestStatistic.statistic.servicebreakpoints" value="${ guestStatistic.statistic.servicebreakpoints }"/>
          				</td>
          			</tr>
          			<tr>
          				<td colspan="3" style="font-weight: bold;">接发数据</td>
          			</tr>		          			
          			<tr>
          				<td>${ guestStatistic.statistic.services }</td>
          				<td>接发局</td>
          				<td>${ homeStatistic.statistic.services }</td>
          			</tr>
          			<tr>
          				<td>
          				<input type ="number" class="form-control" name="homeStatistic.statistic.firstreturngoals" id="homeStatistic.statistic.firstreturngoals" value="${ homeStatistic.statistic.firstreturngoals }"/>/${ guestStatistic.statistic.firstservices }
          				</td>
          				<td>接一发得分</td>
          				<td>
          				<input type ="number" class="form-control" name="guestStatistic.statistic.firstreturngoals" id="guestStatistic.statistic.firstreturngoals" value="${ guestStatistic.statistic.firstreturngoals }"/>/${ homeStatistic.statistic.firstservices }
          				</td>
          			</tr>
          			<tr>
          				<td>
          				<input type ="number" class="form-control" name="homeStatistic.statistic.secondreturngoals" id="homeStatistic.statistic.secondreturngoals" value="${ homeStatistic.statistic.secondreturngoals }"/>/${ guestStatistic.statistic.secondservices }
          				</td>
          				<td>接二发得分</td>
          				<td>
          				<input type ="number" class="form-control" name="guestStatistic.statistic.secondreturngoals" id="guestStatistic.statistic.secondreturngoals" value="${ guestStatistic.statistic.secondreturngoals }"/>/${ homeStatistic.statistic.secondservices }
          				</td>
          			</tr>
          			<tr>
          				<td>
          				<input type ="number" class="form-control" name="homeStatistic.statistic.breakpoints" id="homeStatistic.statistic.breakpoints" value="${ homeStatistic.statistic.breakpoints }"/>/<input type ="number" class="form-control" name="homeStatistic.statistic.receivebreakpoints" id="homeStatistic.statistic.receivebreakpoints" value="${ homeStatistic.statistic.receivebreakpoints }"/>
          				</td>
          				<td>成功破发</td>
          				<td>
          				<input type ="number" class="form-control" name="guestStatistic.statistic.breakpoints" id="guestStatistic.statistic.breakpoints" value="${ guestStatistic.statistic.breakpoints }"/>/<input type ="number" class="form-control" name="guestStatistic.statistic.receivebreakpoints" id="guestStatistic.statistic.receivebreakpoints" value="${ guestStatistic.statistic.receivebreakpoints }"/>
          				</td>
          			</tr>
          			<tr>
          				<td colspan="3" style="font-weight: bold;">得分数据</td>
          			</tr>
          			<tr>
          				<td>${ homeStatistic.statistic.firstgoals+homeStatistic.statistic.secondgoals }/${ homeStatistic.statistic.firstservices+homeStatistic.statistic.secondservices+homeStatistic.statistic.doublefaults }</td>
          				<td>发球总得分</td>
          				<td>${ guestStatistic.statistic.firstgoals+guestStatistic.statistic.secondgoals }/${ guestStatistic.statistic.firstservices+guestStatistic.statistic.secondservices+guestStatistic.statistic.doublefaults }</td>
          			</tr>
          			<tr>
          				<td>${ homeStatistic.statistic.firstreturngoals+homeStatistic.statistic.secondreturngoals }/${ guestStatistic.statistic.firstservices+guestStatistic.statistic.secondservices+guestStatistic.statistic.doublefaults }</td>
          				<td>回发总得分</td>
          				<td>${ guestStatistic.statistic.firstreturngoals+guestStatistic.statistic.secondreturngoals }/${ homeStatistic.statistic.firstservices+homeStatistic.statistic.secondservices+homeStatistic.statistic.doublefaults }</td>
          			</tr>
          			<tr>
          				<td>
          				${ homeStatistic.statistic.firstgoals+homeStatistic.statistic.secondgoals+homeStatistic.statistic.firstreturngoals+homeStatistic.statistic.secondreturngoals }/
          				${ homeStatistic.statistic.firstservices+homeStatistic.statistic.secondservices+homeStatistic.statistic.doublefaults+guestStatistic.statistic.firstservices+guestStatistic.statistic.secondservices+guestStatistic.statistic.doublefaults }
          				</td>
          				<td>总得分</td>
          				<td>
          				${ guestStatistic.statistic.firstgoals+guestStatistic.statistic.secondgoals+guestStatistic.statistic.firstreturngoals+guestStatistic.statistic.secondreturngoals }/
          				${ homeStatistic.statistic.firstservices+homeStatistic.statistic.secondservices+homeStatistic.statistic.doublefaults+guestStatistic.statistic.firstservices+guestStatistic.statistic.secondservices+guestStatistic.statistic.doublefaults }
          				</td>
          			</tr>
          		</tbody>
          	</table>
			<button type="submit" class="btn btn-danger" onclick="return confirm('您确定提交吗?')">提交</button> 			
		</form>
	    </div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>