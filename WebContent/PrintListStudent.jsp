<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/icomoon-social.css">



<title>Print</title>
</head>
<body>
	<!--------------Header--------------->
	<jsp:include page="Header.jsp" />
	<!---------------Menu---------------->
	<%@include file="Menu.jsp" %>
	<div class="section">
		<div class="container">
			<div id="page-wrapper">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="panel panel-default">


							<div class="panel-heading">พิมพ์รายชื่อนักศึกษา</div>
							<div class="panel-body">

								<!-- /.Search Education -->
								<div class="row form-group" align="center">
									<form class="form-inline" role="form" action="PrintListStudentForActivities" method="post" target="_blank">
												<div class="form-group">
													<input class="form-control" id="majorStudent" type="text" placeholder="${majorPrintStudent}"disabled>
													<input type="hidden" name="majorStudent" id="majorStudent" value="${majorPrintStudent}"> 
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
																<c:when	test="${item == chkTerm}">
																	<option	value="${item}"	selected="selected">${item}</option>
																</c:when>
																<c:otherwise>
																	<option	value="${item}">${item}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>												
											</div>
										<div class="form-group">
												<button class="btn btn-success" type="submit">
													<i class="fa fa-print"></i>&nbsp;&nbsp;พิมพ์รายชื่อนักศึกษา
												</button>
										</div>
									</form>
								</div>
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