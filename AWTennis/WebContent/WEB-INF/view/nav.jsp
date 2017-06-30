<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	  <!-- Left side column. contains the logo and sidebar -->
	  <aside class="main-sidebar">
	  
	    <!-- sidebar: style can be found in sidebar.less -->
	    <section class="sidebar">
	    
	      <!-- Sidebar user panel -->
	      <div class="user-panel">
	        <div class="pull-left image">
	          <img src="<%= request.getContextPath() %>/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
	        </div>
	        <div class="pull-left info">
	          <p>${ username }</p>
	          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
	        </div>
	      </div>

	      <!-- sidebar menu: : style can be found in sidebar.less -->
	      <ul class="sidebar-menu" data-widget="tree">  
	          
			<li class="treeview">
			  <a href="#" onclick="activeMenu(this)">
			    <i class="fa fa-users"></i> <span>用户信息</span>
			    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			  </a>
			  <ul class="treeview-menu">
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/user/list"><i class="fa fa-circle-o"></i> 个人信息</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/team/list"><i class="fa fa-circle-o"></i> 组合信息</a></li>
			  </ul>
			</li>
				        
			<li class="treeview">
			  <a href="#" onclick="activeMenu(this)">
			    <i class="fa fa-gamepad"></i> <span>俱乐部活动</span>
			    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			  </a>
			  <ul class="treeview-menu">
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/tournament/list"><i class="fa fa-circle-o"></i> 赛事信息</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/activity/list"><i class="fa fa-circle-o"></i> 活动信息</a></li>
			  </ul>
			</li>
			
			<li class="treeview">
			  <a href="#" onclick="activeMenu(this)">
			    <i class="fa fa-file-text-o"></i> <span>比赛记录</span>
			    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			  </a>
			  <ul class="treeview-menu">
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/singlematch/list"><i class="fa fa-circle-o"></i> 单打比赛</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/doublematch/list"><i class="fa fa-circle-o"></i> 双打比赛</a></li>
			  </ul>
			</li>
			
			<li class="treeview">
			  <a href="#" onclick="activeMenu(this)">
			    <i class="fa fa-cubes"></i> <span>用户积分</span>
			    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			  </a>
			  <ul class="treeview-menu">
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/individualpoint/list"><i class="fa fa-circle-o"></i> 个人积分</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/teampoint/list"><i class="fa fa-circle-o"></i> 组合积分</a></li>
			  </ul>
			</li>
			
			<li class="treeview">
			  <a href="#" onclick="activeMenu(this)">
			    <i class="fa fa-line-chart"></i> <span>俱乐部排名</span>
			    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			  </a>
			  <ul class="treeview-menu">
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/individualrank/list"><i class="fa fa-circle-o"></i> 个人排名</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/teamrank/list"><i class="fa fa-circle-o"></i> 组合排名</a></li>
			  </ul>
			</li>
			
			 <li class="treeview">
			  <a href="#" onclick="activeMenu(this)">
			    <i class="fa fa-dashboard"></i> <span>其它信息</span>
			    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			  </a>
			  <ul class="treeview-menu">
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/arena/list"><i class="fa fa-circle-o"></i> 场馆信息</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/level/list"><i class="fa fa-circle-o"></i> 俱乐部等级</a></li>
			    <li onclick="activeChildMenu(this)"><a href="<%=request.getContextPath()%>/punishment/list"><i class="fa fa-circle-o"></i> 退赛扣分</a></li>
			  </ul>
			</li>
			    
	      </ul>
	      
	    </section>
	    <!-- /.sidebar -->
	  </aside>