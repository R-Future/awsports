<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<jsp:include page="../header.jsp"/>
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <h1>个人简介</h1>
	      <!-- 面包屑 -->
		  <ol class="breadcrumb">
	        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
	        <li><a href="<%=request.getContextPath()%>/user/list">用户列表</a></li>
	        <li class="active">个人简介</li>
	      </ol>
	    </section>
	
		<!-- Main content -->
	    <section class="content">
	
	      <div class="row">
	        <div class="col-md-3">
	
	          <!-- Profile Image -->
	          <div class="box box-primary">
	            <div class="box-body box-profile">
 	            	<c:choose>
	            		<c:when test="${ user.portrait!=null and !user.portrait.isEmpty() }">
	            			<img class="profile-user-img img-responsive img-circle" src="/pic/${ user.portrait }" alt="User profile picture">
	            		</c:when>
	            		<c:otherwise>
	            			<c:choose>
		            			<c:when test="${ user.sex.booleanValue() }">
		            				<img class="profile-user-img img-responsive img-circle" src="/pic/femaleDefault.jpg" alt="User profile picture">
		            			</c:when>
		            			<c:otherwise>
	 	            				<img class="profile-user-img img-responsive img-circle" src="/pic/maleDefault.jpg" alt="User profile picture">
		            			</c:otherwise>
	            			</c:choose>
	            		</c:otherwise>
	            	</c:choose>
	              
	
	              <h3 class="profile-username text-center">
	              	${ user.name }
	              	<c:choose>
	              		<c:when test="${ user.sex.booleanValue() }">
	              			<i class="fa fa-venus"></i>
	              		</c:when>
	              		<c:otherwise>
	              			<i class="fa fa-mars"></i>
	              		</c:otherwise>
	              	</c:choose>
	              </h3>
	
	              <p class="text-muted text-center">${ level.chinese }(${ level.english })</p>
	              <p class="text-muted text-center">单打冠军(${ user.singletitles })</p>
	              <p class="text-muted text-center">双打冠军(${ user.doubletitles })</p>
	
	              <ul class="list-group list-group-unbordered">
	                <li class="list-group-item">
	                  <b>昵称</b> <a class="pull-right">${ user.nickname }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>真实姓名</b> <a class="pull-right">${ user.realname }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>身份证号</b> <a class="pull-right">${ user.idcard }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>手机号</b> <a class="pull-right">${ user.phone }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>Email</b> <a class="pull-right">${ user.email }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>身高</b> <a class="pull-right">${ user.height }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>体重</b> <a class="pull-right">${ user.weight }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>网球水平</b> <a class="pull-right">${ user.level }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>球龄</b> <a class="pull-right">${ user.playedyears }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>正手</b> <a class="pull-right">${ forehandTypes.get(user.forehand) }</a>
	                </li>
	                <li class="list-group-item">
	                  <b>反手</b> <a class="pull-right">${ backhandTypes.get(user.backhand) }</a>
	                </li>
	              </ul>
	
<!-- 	              <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a> -->
	            </div>
	            <!-- /.box-body -->
	          </div>
	          <!-- /.box -->
	        </div>
	        <!-- /.col -->
	        
	        <div class="col-md-9">
	          <div class="nav-tabs-custom">
	            <ul class="nav nav-tabs">
	              <li class="active"><a href="#aboutme" data-toggle="tab">关于我</a></li>
	              <li><a href="#activity" data-toggle="tab">活动</a></li>
	              <li><a href="#singlematchrecord" data-toggle="tab">单打比赛</a></li>
	              <li><a href="#doublematchrecord" data-toggle="tab">双打比赛</a></li>
	              <li><a href="#settings" data-toggle="tab">修改资料</a></li>
	              <li><a href="#changepassword" data-toggle="tab">修改密码</a></li>
	            </ul>
	            <div class="tab-content">
	            	
	              <div class="active tab-pane" id="aboutme">
	              	  <!-- About Me Box -->
			          <div class="box box-primary">
			            <div class="box-body">
			              <strong><i class="fa fa-book margin-r-5"></i> 个人排名最高记录</strong>
			              <c:if test="${ individualrankests != null && individualrankests.size() > 0 }">
							  <c:forEach items="${ individualrankests }" var="individualrankest">
								  <h4>${ entryTypes.get(individualrankest.entry) }</h4>
								  <p class="text-muted">
					              	最高排名: ${ individualrankest.highestranking } (始于 <spring:eval expression="individualrankest.hrstartedat"/>)
					              </p>
								  <c:if test="${ individualrankest.highestranking.intValue() == 1 }">
									<p class="text-muted">排名第一周数: ${ individualrankest.no1weeks }</p>
									<p class="text-muted">当前连续第一周数: ${ individualrankest.no1continuousweeks }</p>
									<p class="text-muted">最长连续第一周数: ${ individualrankest.no1longestcontinuousweeks }</p>
								  </c:if>
							  </c:forEach>
						  </c:if>
						  <hr>
			
			              <strong><i class="fa fa-pencil margin-r-5"></i> 组合排名最高记录</strong>
						  <c:if test="${ teamrankestRecords != null && teamrankestRecords.size() > 0 }">
						  	<c:forEach items="${ teamrankestRecords }" var="teamrankestRecord">
						  		<c:if test="${ teamrankestRecord.getValue() != null && teamrankestRecord.getValue().size() > 0 }">
						  			<h4>${ teamrankestRecord.getKey().name }</h4>
							  		<c:forEach items="${ teamrankestRecord.getValue() }" var="teamrankest">
							  			<p class="text-muted">${ entryTypes.get(teamrankest.entry) }</p>
							  			<p class="text-muted">
							  				最高排名: ${ teamrankest.highestranking } (始于 <spring:eval expression="teamrankest.hrstartedat"/>)
							  			</p>
							  			<c:if test="${ teamrankest.highestranking.intValue() == 1 }">
											<p class="text-muted">排名第一周数: ${ teamrankest.no1weeks }</p>
											<p class="text-muted">当前连续第一周数: ${ teamrankest.no1continuousweeks }</p>
											<p class="text-muted">最长连续第一周数: ${ teamrankest.no1longestcontinuousweeks }</p>
										</c:if>
							  		</c:forEach>
						  		</c:if>
						  	</c:forEach>
						  </c:if>
			              
			              <hr>
			
			              <strong><i class="fa fa-map-marker margin-r-5"></i> 位置</strong>
			
			              <p class="text-muted">${ user.address }</p>
			
			              

			            </div>
			            <!-- /.box-body -->
			          </div>
			          <!-- /.box -->
	              </div>
	              <!-- /.tab-pane -->
	              
	              <div class="tab-pane" id="activity">
	              	未参加过俱乐部活动！
	              </div>
	              <!-- /.tab-pane -->
	              
	              <div class="tab-pane" id="singlematchrecord">
	                <c:choose>	               			
		                <c:when test="${ singlematchs!=null && singlematchs.size()>0 }">
	                		<!-- The timeline -->
                			<ul class="timeline timeline-inverse">
				                <c:forEach items="${ singlematchs }" var="singlematch">
									<!-- timeline time label -->
									<li class="time-label">
										<span class="bg-red">
										  <spring:eval expression="singlematch.matchTime"/>
										</span>
									</li>
									<!-- /.timeline-label -->
									<!-- timeline item -->
									<li>
										<i class="fa fa-futbol-o bg-blue"></i>
										
										<div class="timeline-item">
			<!-- 							  <span class="time"><i class="fa fa-clock-o"></i> 12:05</span> -->
										
										  <h3 class="timeline-header"><a href="#">${ singlematch.tournament }</a></h3>
										
										  <div class="timeline-body">
<!-- 										    <div class="box"> -->
<!-- 									            <div class="box-body no-padding"> -->
									              <table class="table table-condensed">
									                <tr>
									                  <th>对手</th>
									                  <th>参赛类型</th>
									                  <th>比赛地点</th>
									                  <th>轮次</th>
									                  <th>盘数</th>
									                  <th>比分</th>
									                  <th>比赛结果</th>
									                </tr>
									                <tr>
									                  <td>${ singlematch.opponent }</td>
									                  <td>${ singlematch.entry }</td>
									                  <td>${ singlematch.place }</td>
									                  <td>${ singlematch.round }</td>
									                  <td>${ singlematch.sets }</td>
									                  <td>${ singlematch.matchScore }</td>
													  <td>${ singlematch.winLose }</td>
									                </tr> 
									              </table>
<!-- 									            </div> -->
<!-- 									            /.box-body -->
<!-- 									          </div> -->
<!-- 									          /.box -->
										  </div>
										  <div class="timeline-footer"></div>
										</div>
									</li>
									<!-- END timeline item -->
				                  </c:forEach>
				                  <li>
				                    <i class="fa fa-clock-o bg-gray"></i>
				                  </li>
			                  </ul>
		                  </c:when>
		                  <c:otherwise>
		                  	未参加过单打比赛！
		                  </c:otherwise>
	                  </c:choose>        
	              </div>
	              <!-- /.tab-pane -->
	              
	              <div class="tab-pane" id="doublematchrecord">
	                <c:choose>	               			
		                <c:when test="${ doublematchs!=null && doublematchs.size()>0 }">
	                		<!-- The timeline -->
                			<ul class="timeline timeline-inverse">
				                <c:forEach items="${ doublematchs }" var="doublematch">
									<!-- timeline time label -->
									<li class="time-label">
										<span class="bg-red">
										  <spring:eval expression="doublematch.matchTime"/>
										</span>
									</li>
									<!-- /.timeline-label -->
									<!-- timeline item -->
									<li>
										<i class="fa fa-futbol-o bg-blue"></i>
										
										<div class="timeline-item">
			<!-- 							  <span class="time"><i class="fa fa-clock-o"></i> 12:05</span> -->
										
										  <h3 class="timeline-header"><a href="#">${ doublematch.tournament }</a></h3>
										
										  <div class="timeline-body">
<!-- 										    <div class="box"> -->
<!-- 									            <div class="box-body no-padding"> -->
									              <table class="table table-condensed">
									                <tr>
									                  <th>队友</th>
									                  <th>对手</th>
									                  <th>参赛类型</th>
									                  <th>比赛地点</th>
									                  <th>轮次</th>
									                  <th>盘数</th>
									                  <th>比分</th>
									                  <th>比赛结果</th>
									                </tr>
									                <tr>
									                  <td>${ doublematch.partner }</td>
									                  <td>${ doublematch.opponent }</td>
									                  <td>${ doublematch.entry }</td>
									                  <td>${ doublematch.place }</td>
									                  <td>${ doublematch.round }</td>
									                  <td>${ doublematch.sets }</td>
									                  <td>${ doublematch.matchScore }</td>
													  <td>${ doublematch.winLose }</td>
									                </tr> 
									              </table>
<!-- 									            </div> -->
<!-- 									            /.box-body -->
<!-- 									          </div> -->
<!-- 									          /.box -->
										  </div>
										  <div class="timeline-footer"></div>
										</div>
									</li>
									<!-- END timeline item -->
				                  </c:forEach>
				                  <li>
				                    <i class="fa fa-clock-o bg-gray"></i>
				                  </li>
			                  </ul>
		                  </c:when>
		                  <c:otherwise>
		                  	未参加过双打比赛！
		                  </c:otherwise>
	                  </c:choose>        
	              </div>
	              <!-- /.tab-pane -->
	
	              <div class="tab-pane" id="settings">
	                <form class="form-horizontal" action="<%= request.getContextPath() %>/user/save" method="post">
	                  <input type="hidden" name="id" id="id" value="${user.id}" class="form-control"/>
	                  <div class="form-group">
	                    <label for="name" class="col-sm-2 control-label">用户名</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="name" id="name" placeholder="Name" value="${user.name}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="nickname" class="col-sm-2 control-label">昵称</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="nickname" id="nickname" placeholder="Nickname" value="${user.nickname}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="email" class="col-sm-2 control-label">Email</label>
	                    <div class="col-sm-10">
	                      <input type="email" class="form-control" name="email" id="email" placeholder="Email" value="${user.email}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="phone" class="col-sm-2 control-label">手机号</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="phone" id="phone" placeholder="Phone" value="${user.phone}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="realname" class="col-sm-2 control-label">真实姓名</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="realname" id="realname" placeholder="Real Name" value="${user.realname}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="idcard" class="col-sm-2 control-label">身份证号</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="idcard" id="idcard" placeholder="ID Card" value="${user.idcard}">
	                    </div>
	                  </div>
	                  <div class="form-group">
							<label for="userPic" class="col-sm-2 control-label">头像</label>
							<input type="file" style="padding-left:14px" name="userPic" id="userPic"/>
							<c:if test="${ user.portrait!=null and !user.portrait.isEmpty() }"><img src="/pic/${ user.portrait }" width="128" height="128" style="padding-left:14px"/></c:if>
						</div>
	                  <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                      <button type="submit" class="btn btn-danger">提交</button>
	                    </div>
	                  </div>
	                </form>
	              </div>
	              <!-- /.tab-pane -->
	              
	              <div class="tab-pane form-horizontal" id="changepassword">
	                  <input type="hidden" name="password" id="password" value="${user.password}" class="form-control"/>
	                  <div class="form-group"><div class="col-sm-10 col-sm-offset-2" id="errorHint"></div></div>
	                  <div class="form-group">
	                    <label for="oldPassword" class="col-sm-2 control-label">原密码</label>
	                    <div class="col-sm-10">
	                      <input type="password" class="form-control" name="oldPassword" id="oldPassword" placeholder="Old Password">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="newPassword" class="col-sm-2 control-label">新密码</label>
	                    <div class="col-sm-10">
	                      <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="New Password">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="newPasswordConfirmation" class="col-sm-2 control-label">新密码确认</label>
	                    <div class="col-sm-10">
	                      <input type="password" class="form-control" name="newPasswordConfirmation" id="newPasswordConfirmation" placeholder="New Password">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                      <a href="javascript:void(0)" class="btn btn-danger" id="pwchangingSubmit">提交</a>
	                    </div>
	                  </div>
	              </div>
	            </div>
	            <!-- /.tab-content -->
	          </div>
	          <!-- /.nav-tabs-custom -->
	        </div>
	        <!-- /.col -->
	      </div>
	      <!-- /.row -->
	
	    </section>
	    <!-- /.content -->
	    
	  </div>
	  <!-- /.content-wrapper -->
<script src="https://cdn.bootcss.com/blueimp-md5/2.7.0/js/md5.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("a#pwchangingSubmit").click(function(){
			var password=$("input#password").val();
			var oldPassword=$("input#oldpassword").val();
			var newPassword=$("input#newPassword").val();
			var newPasswordConfirmation=$("input#newPasswordConfirmation").val();
			$("div#changepassword").addClass("active");
			if(oldPassword==''||newPassword==''||newPasswordConfirmation==''){
				$("div#errorHint").html("密码不能为空");
			}else{
				var oldPasswordHash=md5(oldPassword);
				if(oldPasswordHash!=password){
					$("div#errorHint").html("原密码输入错误");
				}else{
					if(newPassword!=newPasswordConfirmation){
						$("div#errorHint").html("新密码输入不一致");
					}else{
						$.ajax({
							type:"post",
							url:"changePassword",
							contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							data:{id:$("input#id").val(),oldPassword:oldPasswordHash,newPassword:md5(newPassword),newPasswordConfirmation:md5(newPasswordConfirmation)},
							dataType: "json",
							success:function(data){
								$("div#errorHint").html(data);
							},                         
						});
					}
				}
			}
		});
	});
</script>
<jsp:include page="../footer.jsp"/>