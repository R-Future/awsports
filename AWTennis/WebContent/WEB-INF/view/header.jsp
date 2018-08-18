<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱网体育</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/dist/css/skins/_all-skins.min.css">
<!-- Morris chart -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker.css">
<!-- Datetime picker -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-datetimepicker.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- customized css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/base.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/loader.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/loaderAnimation.css">
<!-- select with search -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/chosen.css">

<!-- jQuery 3.1.1 -->
<script src="<%=request.getContextPath()%>/resources/plugins/jQuery/jquery-3.1.1.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>$.widget.bridge('uibutton', $.ui.button);</script>
<!-- Morris.js charts -->
<script src="<%=request.getContextPath()%>/resources/js/raphael-min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="<%=request.getContextPath()%>/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/resources/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/resources/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="<%=request.getContextPath()%>/resources/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- datetimepicker -->
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<%=request.getContextPath()%>/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="<%=request.getContextPath()%>/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=request.getContextPath()%>/resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
<!-- select with search -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/selectChosen.js"></script>
<!-- table to excel -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.table2excel.min.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	
	<div class="wrapper">
	
		<header class="main-header">
		  <!-- Logo -->
		  <a href="<%= request.getContextPath() %>" class="logo">
		    <!-- mini logo for sidebar mini 50x50 pixels -->
		    <span class="logo-mini"><b>爱网</b></span>
		    <!-- logo for regular state and mobile devices -->
		    <span class="logo-lg"><b>爱网</b>体育</span>
		  </a>
		  <!-- Header Navbar: style can be found in header.less -->
		  <nav class="navbar navbar-static-top">
		    <!-- Sidebar toggle button-->
		    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
		      <span class="sr-only">Toggle navigation</span>
		    </a>
		
		    <div class="navbar-custom-menu">
		      <ul class="nav navbar-nav">
		        <!-- User Account: style can be found in dropdown.less -->
		        <li class="dropdown user user-menu">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		            <c:choose>
		           		<c:when test="${ currentUser.portrait!=null  and !currentUser.portrait.isEmpty() }">
		           			<img src="/pic/${ currentUser.portrait }" class="user-image" alt="User Image">
		           		</c:when>
		           		<c:otherwise>
		           			<c:choose>
			           			<c:when test="${ currentUser.sex.booleanValue() }">
			           				<img src="/pic/femaleDefault.jpg" class="user-image" alt="User Image">
			           			</c:when>
			           			<c:otherwise>
			           				<img src="/pic/maleDefault.jpg" class="user-image" alt="User Image">
			           			</c:otherwise>
		           			</c:choose>
		           		</c:otherwise>
		           	</c:choose>
		            <span class="hidden-xs">${ currentUser.name }</span>
		          </a>
		          <ul class="dropdown-menu">
					<!-- User image -->
		            <li class="user-header">
			          <c:choose>
		         		<c:when test="${ currentUser.portrait!=null  and !currentUser.portrait.isEmpty() }">
		         			<img src="/pic/${ currentUser.portrait }" class="img-circle" alt="User Image">
		         		</c:when>
		         		<c:otherwise>
		         			<c:choose>
			         			<c:when test="${ currentUser.sex.booleanValue() }">
			         				<img src="/pic/femaleDefault.jpg" class="img-circle" alt="User Image">
			         			</c:when>
			         			<c:otherwise>
			         				<img src="/pic/maleDefault.jpg" class="img-circle" alt="User Image">
			         			</c:otherwise>
		         			</c:choose>
		         		</c:otherwise>
			          </c:choose>
		              <p>
		                ${ currentUser.name } - 俱乐部管理
		                <small>Member since Nov. 2014</small>
		              </p>
		            </li>
		            <!-- Menu Footer-->
		            <li class="user-footer">
		              <div class="pull-left">
		                <a href="<%=request.getContextPath()%>/user/profile?id=${currentUser.id}" class="btn btn-default btn-flat">个人资料</a>
		              </div>
		              <div class="pull-right">
		                <a href="<%= request.getContextPath() %>/logout" class="btn btn-default btn-flat">退出</a>
		              </div>
		            </li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </nav>
		</header>
		
		<jsp:include page="nav.jsp"/>