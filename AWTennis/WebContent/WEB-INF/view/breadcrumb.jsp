<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test='<%=(request.getParameter("id")!=null)%>'>更新记录</c:when>
	<c:otherwise>新增记录</c:otherwise>
</c:choose>