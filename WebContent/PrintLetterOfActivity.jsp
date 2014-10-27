<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/leaflet.css" />
<link rel="stylesheet" href="css/main.css">
<script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/icomoon-social.css">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${contextPath}/js/customScript.js"></script>
<title>Print</title>
</head>
<body>
	<!--------------Header--------------->
	<jsp:include page="Header.jsp" />
	<!---------------Menu---------------->
<%-- 	<jsp:include page="Menu.jsp" /> --%>
	<%@include file="Menu.jsp" %>
	<div class="section">
		<div class="container-fluid">
			<div id="page-wrapper">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="panel panel-default">


							<div class="panel-heading">พิมพ์รายชื่อนักศึกษา</div>
							<div class="panel-body">

								<!-- /.Search Education -->
								<div class="row form-group" align="center">
									<form class="form-inline" role="form" action="PrintLetterOfParent" method="post">
										<div class="form-group">
											<input class="form-control" id="majorStudent" type="text"
												placeholder="${majorPrintStudent}" disabled> <input
												type="hidden" name="majorStudent" id="majorStudent"
												value="${majorPrintStudent}">
										</div>
										<div class="form-group">
											<select id="level" name="selectLevelEdu" class="form-control">
												<c:forEach items="${listEducationLevel}" var="item">
													<c:choose>
														<c:when
															test="${item.educationLevel.educationalBackground == selectEducation && item.educationLevel.educationLevel == selectEducation1}">
															<option
																value="${item.educationLevel.educationalBackground} ${item.educationLevel.educationLevel}"
																selected="selected">${item.educationLevel.educationalBackground}&nbsp;&nbsp;${item.educationLevel.educationLevel}</option>
														</c:when>
														<c:otherwise>
															<option
																value="${item.educationLevel.educationalBackground} ${item.educationLevel.educationLevel}">${item.educationLevel.educationalBackground}&nbsp;&nbsp;${item.educationLevel.educationLevel}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>

										<div class=" form-group">
											<select class="form-control" name="selectPrintTerm">
												<c:forEach items="${listTerm}" var="item">
													<c:choose>
														<c:when test="${item == chkTerm}">
															<option value="${item}" selected="selected">${item}</option>
														</c:when>
														<c:otherwise>
															<option value="${item}">${item}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<button class="btn btn-success" type="submit">
												<i class="glyphicon glyphicon-search"></i>&nbsp;&nbsp;ค้นหา
											</button>
										</div>
									</form>
								</div>

								<table class="table table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th>ลำดับ</th>
											<th>รหัสประจำตัวนักศึกษา</th>
											<th colspan="3" align="center">ชื่อ - นามสกุล</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listStudent}" var="item"
											varStatus="theCount">
											<tr>
												<td class="TextCenter">${theCount.count}</td>
												<td class="TextCenter">${item.studentID}</td>
												<td class="TextCenter" width="5%">${item.antecedent}</td>
												<td class="TextCenter">${item.firstName}</td>
												<td class="TextCenter">${item.lastName}</td>
												<td class="TextCenter">
													<a class="btn btn-primary btn-circle" target="_blank"
														href="PrintLetterOfParent?studentID=${item.studentID}&term=${term}">
														<i class="fa fa-print" Title="พิมพ์"></i>
													</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--------------Footer--------------->
	<jsp:include page="Footer.jsp" />

	<!-- Javascripts -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.9.1.min.js"><\/script>');
	</script>
	<script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
	<script src="js/jquery.fitvids.js"></script>
	<script src="js/jquery.sequence-min.js"></script>
	<script src="js/jquery.bxslider.js"></script>
	<script src="js/main-menu.js"></script>
	<script src="js/template.js"></script>
</body>
</html>