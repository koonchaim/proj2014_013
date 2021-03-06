<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Teacher</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="Admin/css/bootstrap.min.css" rel="stylesheet" />
<link href="Admin/css/font-awesome.min.css" rel="stylesheet" />
<link href="Admin/css/ionicons.min.css" rel="stylesheet" />
<link href="Admin/css/morris/morris.css" rel="stylesheet" />
<link href="Admin/css/jvectormap/jquery-jvectormap-1.2.2.css" />
<link href="Admin/css/fullcalendar/fullcalendar.css" rel="stylesheet" />
<link href="Admin/css/daterangepicker/daterangepicker-bs3.css" />
<link href="Admin/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" />
<link href="Admin/css/AdminLTE.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jasny-bootstrap.css">
</head>
<body class="skin-blue">
	<!--------------Header--------------->
	<jsp:include page="Admin/Header.jsp" />

	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!---------------Menu---------------->
		<%@include file="Admin/Menu.jsp" %>
		<aside class="right-side">
		<section class="content-header">
		<h1>
			<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;List Teacher <small>Control
				panel</small>
		</h1>
		</section> <section class="content">
		<div class="form-group">
			<table class="span9 table table-hover">
				<thead>
					<tr>
						<th>ลำดับที่</th>
						<th colspan="2">ชื่อ - นามสกุล</th>
						<th>แผนกวิชาที่รับผิดชอบ</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
<input type="hidden" value="${message}" id="message">
					<c:forEach items="${listTeacher}" var="item" varStatus="theCount">
						<tr>
							<td class="TextCenter">${theCount.count}</td>
							<td class="TextCenter">${item.antecedent}&nbsp;&nbsp;${item.firstName}</td>
							<td class="TextCenter">${item.lastName}</td>
							<td class="TextCenter">${item.major.majorName}</td>
							<td class="TextCenter">
								<button type="button" class="btn btn-primary btn-circle"
									data-toggle="modal" data-target="#editTeacher"
									onclick="editTeacherByIdCard(${item.idCard})">
									<i class="fa fa-wrench"  Title="แก้ไข"></i>
								</button>
								
								<a onclick="return remove_teacher(${item.idCard});">
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
									data-target="#addTeacher">
									<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;เพิ่มอาจารย์
								</button>
								<a id="btnImportTeacher" class='btn btn-primary btn-lg'><i class="ion ion-upload"></i>&nbsp;&nbsp;อัพโหลดไฟล์</a>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</section> </aside>
	</div>
	<!-- Modal addTeacher -->
	<div class="modal fade" id="addTeacher">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">เพิ่มอาจารย์</h4>
				</div>
				<div class="modal-body">
					<jsp:include page="Admin/RegisterTeacherPage.jsp" flush="false" />
				</div>
				<div class="modal-footer">
					<button id="resetEditTeacherFrom"  type="button" class="btn btn-default" data-dismiss="modal">ยกเลิก</button>
					<a id="modal-form-submit-register-teacher" class='btn btn-primary'>เพิ่ม</a>
				</div>				
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<!-- Modal editTeacher-->
	<div class="modal fade" id="editTeacher">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">แก้ไขข้อมูลอาจารย์</h4>
				</div>
				<div class="modal-body">
					<jsp:include page="Admin/EditTeacherPage.jsp" flush="false" />
				</div>
				<div class="modal-footer">
					<button id="resetEditFromTeacher" type="button" class="btn btn-default" data-dismiss="modal">ยกเลิก</button>
					<a id="modal-form-edit-teacher-submit" class='btn btn-primary'>แก้ไข</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="modalMessage.jsp" />
	<!-- /.modal -->

	<!-- script -->
	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="Admin/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
	<script src="Admin/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="Admin/js/AdminLTE/app.js" type="text/javascript"></script>
	<script src="jasny-bootstrap.js" type="text/javascript"></script>
	<script src="js/jasny-bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/customScript.js"></script>
	<script type="text/javascript" src="js/validateScript.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    var message = $('#message').val();
	    
	    if (message != '') {
	    	$('#MessageAlert').text(message);
			$('#danger').modal('show');
		}else{
			
		}
	});
	</script>
</body>
</html>