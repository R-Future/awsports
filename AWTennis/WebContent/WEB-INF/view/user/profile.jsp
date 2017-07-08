<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	              <img class="profile-user-img img-responsive img-circle" src="<%=request.getContextPath()%>/resources/dist/img/user4-128x128.jpg" alt="User profile picture">
	
	              <h3 class="profile-username text-center">
	              	${ user.name }
	              	<c:choose>
	              		<c:when test="${ user.sex.booleanValue()==false }">
	              			<i class="fa fa-mars"></i>
	              		</c:when>
	              		<c:otherwise>
	              			<i class="fa  fa-venus"></i>
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
	                  <b>反手</b> <a class="pull-right">${ forehandTypes.get(userQuerys.user.backhand) }</a>
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
	              <li><a href="#timeline" data-toggle="tab">比赛</a></li>
	              <li><a href="#settings" data-toggle="tab">修改资料</a></li>
	              <li><a href="#changepassword" data-toggle="tab">修改密码</a></li>
	            </ul>
	            <div class="tab-content">
	            	
	              <div class="active tab-pane" id="aboutme">
	              	  <!-- About Me Box -->
			          <div class="box box-primary">
			            <div class="box-body">
			              <strong><i class="fa fa-book margin-r-5"></i> Education</strong>
			
			              <p class="text-muted">
			                B.S. in Computer Science from the University of Tennessee at Knoxville
			              </p>
			
			              <hr>
			
			              <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>
			
			              <p class="text-muted">${ user.address }</p>
			
			              <hr>
			
			              <strong><i class="fa fa-pencil margin-r-5"></i> Skills</strong>
			
			              <p>
			                <span class="label label-danger">UI Design</span>
			                <span class="label label-success">Coding</span>
			                <span class="label label-info">Javascript</span>
			                <span class="label label-warning">PHP</span>
			                <span class="label label-primary">Node.js</span>
			              </p>
			
			              <hr>
			
			              <strong><i class="fa fa-file-text-o margin-r-5"></i> Notes</strong>
			
			              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
			            </div>
			            <!-- /.box-body -->
			          </div>
			          <!-- /.box -->
	              </div>
	              <!-- /.tab-pane -->
	              
	              <div class="tab-pane" id="activity">
	                <!-- Post -->
	                <div class="post">
	                  <div class="user-block">
	                    <img class="img-circle img-bordered-sm" src="<%=request.getContextPath()%>/resources/dist/img/user1-128x128.jpg" alt="user image">
	                        <span class="username">
	                          <a href="#">Jonathan Burke Jr.</a>
	                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
	                        </span>
	                    <span class="description">Shared publicly - 7:30 PM today</span>
	                  </div>
	                  <!-- /.user-block -->
	                  <p>
	                    Lorem ipsum represents a long-held tradition for designers,
	                    typographers and the like. Some people hate it and argue for
	                    its demise, but others ignore the hate as they create awesome
	                    tools to help create filler text for everyone from bacon lovers
	                    to Charlie Sheen fans.
	                  </p>
	                  <ul class="list-inline">
	                    <li><a href="#" class="link-black text-sm"><i class="fa fa-share margin-r-5"></i> Share</a></li>
	                    <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a>
	                    </li>
	                    <li class="pull-right">
	                      <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
	                        (5)</a></li>
	                  </ul>
	
	                  <input class="form-control input-sm" type="text" placeholder="Type a comment">
	                </div>
	                <!-- /.post -->
	
	                <!-- Post -->
	                <div class="post clearfix">
	                  <div class="user-block">
	                    <img class="img-circle img-bordered-sm" src="<%=request.getContextPath()%>/resources/dist/img/user7-128x128.jpg" alt="User Image">
	                        <span class="username">
	                          <a href="#">Sarah Ross</a>
	                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
	                        </span>
	                    <span class="description">Sent you a message - 3 days ago</span>
	                  </div>
	                  <!-- /.user-block -->
	                  <p>
	                    Lorem ipsum represents a long-held tradition for designers,
	                    typographers and the like. Some people hate it and argue for
	                    its demise, but others ignore the hate as they create awesome
	                    tools to help create filler text for everyone from bacon lovers
	                    to Charlie Sheen fans.
	                  </p>
	
	                  <form class="form-horizontal">
	                    <div class="form-group margin-bottom-none">
	                      <div class="col-sm-9">
	                        <input class="form-control input-sm" placeholder="Response">
	                      </div>
	                      <div class="col-sm-3">
	                        <button type="submit" class="btn btn-danger pull-right btn-block btn-sm">Send</button>
	                      </div>
	                    </div>
	                  </form>
	                </div>
	                <!-- /.post -->
	
	                <!-- Post -->
	                <div class="post">
	                  <div class="user-block">
	                    <img class="img-circle img-bordered-sm" src="<%=request.getContextPath()%>/resources/dist/img/user6-128x128.jpg" alt="User Image">
	                        <span class="username">
	                          <a href="#">Adam Jones</a>
	                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
	                        </span>
	                    <span class="description">Posted 5 photos - 5 days ago</span>
	                  </div>
	                  <!-- /.user-block -->
	                  <div class="row margin-bottom">
	                    <div class="col-sm-6">
	                      <img class="img-responsive" src="<%=request.getContextPath()%>/resources/dist/img/photo1.png" alt="Photo">
	                    </div>
	                    <!-- /.col -->
	                    <div class="col-sm-6">
	                      <div class="row">
	                        <div class="col-sm-6">
	                          <img class="img-responsive" src="<%=request.getContextPath()%>/resources/dist/img/photo2.png" alt="Photo">
	                          <br>
	                          <img class="img-responsive" src="<%=request.getContextPath()%>/resources/dist/img/photo3.jpg" alt="Photo">
	                        </div>
	                        <!-- /.col -->
	                        <div class="col-sm-6">
	                          <img class="img-responsive" src="<%=request.getContextPath()%>/resources/dist/img/photo4.jpg" alt="Photo">
	                          <br>
	                          <img class="img-responsive" src="<%=request.getContextPath()%>/resources/dist/img/photo1.png" alt="Photo">
	                        </div>
	                        <!-- /.col -->
	                      </div>
	                      <!-- /.row -->
	                    </div>
	                    <!-- /.col -->
	                  </div>
	                  <!-- /.row -->
	
	                  <ul class="list-inline">
	                    <li><a href="#" class="link-black text-sm"><i class="fa fa-share margin-r-5"></i> Share</a></li>
	                    <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a>
	                    </li>
	                    <li class="pull-right">
	                      <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
	                        (5)</a></li>
	                  </ul>
	
	                  <input class="form-control input-sm" type="text" placeholder="Type a comment">
	                </div>
	                <!-- /.post -->
	              </div>
	              <!-- /.tab-pane -->
	              
	              <div class="tab-pane" id="timeline">
	                <!-- The timeline -->
	                <ul class="timeline timeline-inverse">
	                  <!-- timeline time label -->
	                  <li class="time-label">
	                        <span class="bg-red">
	                          10 Feb. 2014
	                        </span>
	                  </li>
	                  <!-- /.timeline-label -->
	                  <!-- timeline item -->
	                  <li>
	                    <i class="fa fa-envelope bg-blue"></i>
	
	                    <div class="timeline-item">
	                      <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>
	
	                      <h3 class="timeline-header"><a href="#">Support Team</a> sent you an email</h3>
	
	                      <div class="timeline-body">
	                        Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles,
	                        weebly ning heekya handango imeem plugg dopplr jibjab, movity
	                        jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle
	                        quora plaxo ideeli hulu weebly balihoo...
	                      </div>
	                      <div class="timeline-footer">
	                        <a class="btn btn-primary btn-xs">Read more</a>
	                        <a class="btn btn-danger btn-xs">Delete</a>
	                      </div>
	                    </div>
	                  </li>
	                  <!-- END timeline item -->
	                  <!-- timeline item -->
	                  <li>
	                    <i class="fa fa-user bg-aqua"></i>
	
	                    <div class="timeline-item">
	                      <span class="time"><i class="fa fa-clock-o"></i> 5 mins ago</span>
	
	                      <h3 class="timeline-header no-border"><a href="#">Sarah Young</a> accepted your friend request
	                      </h3>
	                    </div>
	                  </li>
	                  <!-- END timeline item -->
	                  <!-- timeline item -->
	                  <li>
	                    <i class="fa fa-comments bg-yellow"></i>
	
	                    <div class="timeline-item">
	                      <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>
	
	                      <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post</h3>
	
	                      <div class="timeline-body">
	                        Take me to your leader!
	                        Switzerland is small and neutral!
	                        We are more like Germany, ambitious and misunderstood!
	                      </div>
	                      <div class="timeline-footer">
	                        <a class="btn btn-warning btn-flat btn-xs">View comment</a>
	                      </div>
	                    </div>
	                  </li>
	                  <!-- END timeline item -->
	                  <!-- timeline time label -->
	                  <li class="time-label">
	                        <span class="bg-green">
	                          3 Jan. 2014
	                        </span>
	                  </li>
	                  <!-- /.timeline-label -->
	                  <!-- timeline item -->
	                  <li>
	                    <i class="fa fa-camera bg-purple"></i>
	
	                    <div class="timeline-item">
	                      <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
	
	                      <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos</h3>
	
	                      <div class="timeline-body">
	                        <img src="http://placehold.it/150x100" alt="..." class="margin">
	                        <img src="http://placehold.it/150x100" alt="..." class="margin">
	                        <img src="http://placehold.it/150x100" alt="..." class="margin">
	                        <img src="http://placehold.it/150x100" alt="..." class="margin">
	                      </div>
	                    </div>
	                  </li>
	                  <!-- END timeline item -->
	                  <li>
	                    <i class="fa fa-clock-o bg-gray"></i>
	                  </li>
	                </ul>
	              </div>
	              <!-- /.tab-pane -->
	
	              <div class="tab-pane" id="settings">
	                <form class="form-horizontal" action="<%= request.getContextPath() %>/user/save" method="post">
	                  <input type="hidden" name="id" id="id" value="${user.id}" class="form-control"/>
	                  <div class="form-group">
	                    <label for="name" class="col-sm-2 control-label">Name</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="name" id="name" placeholder="Name" value="${user.name}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="nickname" class="col-sm-2 control-label">Nickname</label>
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
	                    <label for="phone" class="col-sm-2 control-label">Phone</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="phone" id="phone" placeholder="Phone" value="${user.phone}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="realname" class="col-sm-2 control-label">Real Name</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="realname" id="realname" placeholder="Real Name" value="${user.realname}">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <label for="idcard" class="col-sm-2 control-label">ID Card</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="idcard" id="idcard" placeholder="ID Card" value="${user.idcard}">
	                    </div>
	                  </div>
<!-- 	                  <div class="form-group"> -->
<!-- 	                    <label for="inputExperience" class="col-sm-2 control-label">Experience</label> -->
	
<!-- 	                    <div class="col-sm-10"> -->
<!-- 	                      <textarea class="form-control" id="inputExperience" placeholder="Experience"></textarea> -->
<!-- 	                    </div> -->
<!-- 	                  </div> -->
<!-- 	                  <div class="form-group"> -->
<!-- 	                    <label for="inputSkills" class="col-sm-2 control-label">Skills</label> -->
	
<!-- 	                    <div class="col-sm-10"> -->
<!-- 	                      <input type="text" class="form-control" id="inputSkills" placeholder="Skills"> -->
<!-- 	                    </div> -->
<!-- 	                  </div> -->
<!-- 	                  <div class="form-group"> -->
<!-- 	                    <div class="col-sm-offset-2 col-sm-10"> -->
<!-- 	                      <div class="checkbox"> -->
<!-- 	                        <label> -->
<!-- 	                          <input type="checkbox"> I agree to the <a href="#">terms and conditions</a> -->
<!-- 	                        </label> -->
<!-- 	                      </div> -->
<!-- 	                    </div> -->
<!-- 	                  </div> -->
	                  <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                      <button type="submit" class="btn btn-danger">Submit</button>
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
	                    <label for="newPasswordConfirmation" class="col-sm-2 control-label">确认</label>
	                    <div class="col-sm-10">
	                      <input type="password" class="form-control" name="newPasswordConfirmation" id="newPasswordConfirmation" placeholder="New Password">
	                    </div>
	                  </div>
	                  <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                      <a href="javascript:void(0)" class="btn btn-danger" id="pwchangingSubmit">submit</a>
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