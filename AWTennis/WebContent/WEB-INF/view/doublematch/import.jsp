<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量导入比赛</title>
</head>
<jsp:include page="../header.jsp"/>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>双打比赛</h1>
	  <!-- 面包屑 -->
	  <ol class="breadcrumb">
        <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="<%=request.getContextPath()%>/doublematch/list">双打比赛列表</a></li>
        <li class="active">双打比赛</li>
      </ol>
	</section>
	
	<!-- Main content -->
	<section class="content">
	<div class="container-fluid">
		<div class="row" style="color:red">
			<c:out value="${ success }" default="" />
		</div>
		<div class="row">
			<span style="color:gray">必须是<i style="color:red">.xls</i>文件!!!</span>
			<form class="form" action="<%=request.getContextPath()%>/doublematch/importFromExcel" enctype="multipart/form-data" method="post">
				<div class="form-group">
					<input type="file" name="file" class=""/>
				</div>
				<button type="submit" id="submit" class="btn btn-danger" onclick="return confirm('您确定导入吗?')">批量导入</button>
			</form>
		</div>
	</div>
	</section>
</div>
<jsp:include page="../footer.jsp"/>
<script>
$(function(){
	$("button#submit").click(function(){
		$(this).addAttr("disabled","disabled");
	})
})
</script>