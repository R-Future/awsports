<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
		<!-- footer -->
		<footer class="main-footer">
		  <div class="pull-right hidden-xs">
		    <b>Version</b> 1.0.0
		  </div>
		  <strong>Copyright &copy; 2014-<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %> <a href="<%=request.getContextPath() %>">爱网体育</a>.</strong> All rights
		  reserved.
		</footer>
	</div>
	
	<!-- add match records -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/addMatchRecord.js"></script>
	<!-- update rank -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/updateRank.js"></script>
	
</body>
</html>