<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<!-- Basic Page Needs
  ================================================== -->
<title>รายชื่อเทอมการศึกษา</title>
<meta name="description" content="Staff Main Page">
<meta name="author" content="www.zerotheme.com">

<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- CSS
  ================================================== -->
<link href="Admin/css/bootstrap.min.css" rel="stylesheet">
<link href="Admin/css/font-awesome.min.css" rel="stylesheet">
<link href="Admin/css/ionicons.min.css" rel="stylesheet">

<link href="Admin/css/bootstrap-select.min.css" rel="stylesheet">
<link href="Admin/css/bootstrap-select.css" rel="stylesheet">
<link href="Admin/css/AdminLTE.css" rel="stylesheet">
<link href="css/datepicker.css" rel="stylesheet">

</head>
<body class="skin-blue">
	<!--------------Header--------------->
	<jsp:include page="Admin/Header.jsp" />
	<fmt:setLocale value="th_TH"/>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!---------------Menu---------------->
		<%-- 		<jsp:include page="Admin/Menu.jsp" /> --%>
		<%@include file="Admin/Menu.jsp"%>
		<aside class="right-side"> <!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			<i class="fa fa-calendar-o"></i>&nbsp;&nbsp;List Term <small>Control
				panel</small>
		</h1>
		</section> <section class="content">

		<div class="form-group">
			<table class="span9 table table-hover" id="table-holiday">
				<thead>
					<tr>
						<th>ลำดับที่</th>
						<th>เทอม</th>
						<th>วันเปิดภาคการศึกษา</th>
						<th>วันปิดภาคการศึกษา</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listTerm}" var="item" varStatus="theCount">
						<tr>
							<td>${theCount.count}</td>
							<td>${listTermName[theCount.index]}</td>
							<td><fmt:formatDate pattern="dd MMMM YYYY"  value="${item.startDate}" /></td>
							<td><fmt:formatDate pattern="dd MMMM YYYY"  value="${item.endDate}" /></td>
<%-- 							<td><fmt:formatDate type="date" dateStyle="long" value="${item.startDate}"  /></td> --%>
<%-- 							<td><fmt:formatDate type="date" dateStyle="long" value="${item.endDate}" /></td> --%>
							<td>
<!-- 							<button type="button" class="btn btn-primary btn-circle" -->
<!-- 									data-toggle="modal" data-target="#editTerm" -->
<%-- 									onclick="editTermByTermName('${item.termName}')">									 --%>
<!-- 									<i class="fa fa-wrench"  Title="แก้ไข"></i> -->
<!-- 							</button> -->
							
							<a
										href="ListTermServlet?termName=${item.termName}"
										OnClick="return confirm_delete();">
								<button type="button" class="btn btn-danger btn-circle">
									<i class="glyphicon glyphicon-trash" Title="ลบ"></i>
								</button>
								</a>
							</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="5" align="right">
							<div class="form-group">
								<button class="btn btn-primary btn-lg" data-toggle="modal"
									data-target="#addTerm">
									<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;เพิ่มเทอมการศึกษา
								</button>
								
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /.row -->
	</div>
	<!-- top row -->
	</section>
	</aside>

	<!-- Modal -->
	<div class="modal fade" id="addTerm">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">เพิ่มเทอมการศึกษา</h4>
				</div>
				<div class="modal-body">
					<jsp:include page="Admin/AddTermPage.jsp" flush="false" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="reset-form-addTerm">ยกเลิก</button>
					<button type="button" class="btn btn-primary" id="form-submit-addTerm" >เพิ่ม</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<div class="modal fade" id="editTerm">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">แก้ไขเทอมการศึกษา</h4>
				</div>
				<div class="modal-body">
					<jsp:include page="Admin/EditTermPage.jsp" flush="false" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">ยกเลิก</button>
					<button type="button" class="btn btn-primary" id="form-submit-editterm" >แก้ไข</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<jsp:include page="modalMessage.jsp" />
	<!-- /.modal -->

	<!-- script -->

	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="Admin/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
	<script src="Admin/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="Admin/js/AdminLTE/app.js" type="text/javascript"></script>
	
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/scriptdate.js"></script>
	<script type="text/javascript" src="Admin/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="Admin/js/bootstrap-select.min.js"></script>
	
	<script type="text/javascript" src="js/customScript.js"></script>
	<script type="text/javascript" src="js/validateScript.js"></script>
</body>
</html>