<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登陆</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page" style="height:auto">
<div class="login-box">
  <div class="login-logo">
    <b>爱网</b>体育
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
  	
   	<p id="errorHint" class="login-box-msg">
   	<c:if test="${ error!=null }">${ error }</c:if>
   	</p>
    
    <form action="<%= request.getContextPath() %>/login" method="post">
      <div class="form-group has-feedback">
        <input type="text" name="username" id="username" class="form-control" placeholder="Username">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" id="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="validationCode" id="validationCode" class="form-control" style="width:67.5%;height:34px;display:inline;" placeholder="validation code">
        <img id="vcImage" style="margin-top:-3px" width="100" height="34" alt="点击更换" title="点击更换" src="getValidationPicture" onclick="changeValidationCode(this)"/>
      </div>
      <div class="row">
<!--         <div class="col-xs-8"> -->
<!--           <div class="checkbox icheck"> -->
<!--             <label> -->
<!--               <input type="checkbox" name="rememberMe"> 记住我 -->
<!--             </label> -->
<!--           </div> -->
<!--         </div> -->
        <!-- /.col -->
        <div class="col-xs-12">
          <button type="submit" id="btnSubmit" class="btn btn-primary btn-block btn-flat">登陆</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

<!--     <div class="social-auth-links text-center"> -->
<!--       <p>- OR -</p> -->
<!--       <a href="#" class="btn btn-qq btn-flat bg-light-blue" title="QQ登陆"> -->
<!--       	<i class="fa fa-qq"></i> -->
<!--       </a> -->
<!--       <a href="#" class="btn btn-weixin btn-flat bg-green" title="微信登陆"> -->
<!--       	<i class="fa fa-weixin"></i> -->
<!--       </a> -->
<!--     </div> -->
<!--     /.social-auth-links -->

<!--     <a href="#">忘记密码?</a><br> -->
<!--     <a href="register.html" class="text-center">注册</a> -->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<!-- footer -->
<footer style="width:100%;height:50px;text-align:center;background-color:white;padding-top:5px;position:absolute;bottom:0;">
  <div class="container">
	  <strong>Copyright &copy; 2014-<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %> <a href="<%=request.getContextPath() %>">AiWangSports</a>.</strong> All rights reserved.
	  <div class="pull-center">
	  	<a href="http://www.miitbeian.gov.cn/publish/query/indexFirst.action"><img src="<%= request.getContextPath() %>/resources/images/ghs.png">沪ICP备17031414号</a>
	  </div>
  </div>
</footer>
<!-- jQuery 3..1 -->
<script src="<%= request.getContextPath() %>/resources/plugins/jQuery/jquery-3.1.1.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<%= request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<!-- iCheck -->
<script src="<%= request.getContextPath() %>/resources/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function() {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    
    $("input#username").blur(function(){
    	var username = $("input#username").val();
    	if(username==''){
    		$("p#errorHint").html("用户名不能空");
    	}else{
    		$("p#errorHint").html("");
    	}
    });
    $("input#password").blur(function(){
    	var password = $("input#password").val();
    	if(password==''){
    		$("p#errorHint").html("密码不能空");
    	}else{
    		$("p#errorHint").html("");
    	}
    });
    $("input#validationCode").blur(function(){
    	var validationCode = $("input#validationCode").val();
    	if(validationCode==''){
    		$("p#errorHint").html("验证码不能空");
    	}else{
    		$("p#errorHint").html("");
    	}
    });
  });
  function changeValidationCode(obj){
	  var now = new Date().getTime();
	  obj.src="getValidationPicture?t="+now;
  }
</script>
</body>
</html>