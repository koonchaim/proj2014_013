<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	<c:set var="login" value="${login }" scope="session" />
<c:if test="${empty sessionScope['login']}">
    <c:redirect url="LoginPage.jsp" />
</c:if>
<%
	int timeout = session.getMaxInactiveInterval();
	response.setHeader("Refresh", timeout + "; URL = LoginPage.jsp");
%>
<aside class="left-side sidebar-offcanvas">
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li><a href="ListTeacherServlet"> <i class="glyphicon glyphicon-user"></i> <span>List Teacher</span></a></li>
			<li><a href="ListStudentServlet"> <i class="fa fa-laptop"></i>	<span>List Student</span></a></li>
			<li><a href="ListHolidayServlet"> <i class="fa fa-calendar"></i> <span>List Holiday</span></a></li>
			<li><a href="ListTermServlet"> <i class="fa fa-calendar-o"></i> <span>List Term</span></a></li>
		</ul>
	</section>
</aside>
