<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		  <h1>
		    Dashboard
		    <small>Control panel</small>
		  </h1>
		</section>
		<!-- Main content -->
		<section class="content">
		    <!-- Calendar -->
			<div class="box box-solid bg-green-gradient">
				<div class="box-header">
				  <i class="fa fa-calendar"></i>
				
				  <h3 class="box-title">Calendar</h3>
				  <!-- tools box -->
				  <div class="pull-right box-tools">
				    <!-- button with a dropdown -->
				    <div class="btn-group">
				      <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i></button>
				      <ul class="dropdown-menu pull-right" role="menu">
				        <li><a href="#">Add new event</a></li>
				        <li><a href="#">Clear events</a></li>
				        <li class="divider"></li>
				        <li><a href="#">View calendar</a></li>
				      </ul>
				    </div>
				    <button type="button" class="btn btn-success btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
				    <button type="button" class="btn btn-success btn-sm" data-widget="remove"><i class="fa fa-times"></i></button>
				  </div>
				  <!-- /. tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body no-padding">
				  <!--The calendar -->
				  <div id="calendar" style="width: 100%"></div>
				</div>
			</div>
			<!-- /.box -->
		</section>
        <!-- right col -->    
	</div>
<jsp:include page="footer.jsp"/>