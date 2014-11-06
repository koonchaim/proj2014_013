$('#modal-form-submit-editadd-holiday').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-editadd-holiday').submit();
});

$('#modal-form-submitEditTeacher').on('click', function(e) {
	e.preventDefault();
	$('#modal-formEditTeacher').submit();
});

$('#modal-form-submit-register-teacher').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-regis-teacher').submit();
});

$('#modal-submit-regis-student').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-regis-student').submit();
});

$('#modal-submit-editregis-student').on('click', function(e) {
	e.preventDefault();
	$('#edit-studentForm').submit();
});

$('#modal-form-edit-teacher-submit').on('click', function(e) {
	e.preventDefault();
	$('#formEditTeacher').submit();
});

$('#btnImportTeacher').attr('href','ImportTeacherServlet');


$('#modal-cancel-regis-student').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-regis-student').each (function(){
		  this.reset();
		});
});

$('#modal-cancel-editregis-student').on('click', function(e) {
	e.preventDefault();
	$('#edit-studentForm').each (function(){
		  this.reset();
		});
});

$('#resetEditTeacherFrom').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-regis-teacher').each (function(){
		  this.reset();
		});
});

$('#resetEditFromTeacher').on('click', function(e) {
	e.preventDefault();
	$('#formEditTeacher').each (function(){
		  this.reset();
		});
});

$('#resetAddHoliday').on('click', function(e) {
	e.preventDefault();
	$('#form-add-holiday').each (function(){
		  this.reset();
		});
});

$('#addHoliday-form-submit').click(function() {
	$('#form-add-holiday').submit();
});

$('#form-submit-addTerm').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-add-term').submit();
});

$('#reset-form-addTerm').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-add-term').each (function(){
		  this.reset();
		});
});

$('#form-submit-editterm').on('click', function(e) {
	e.preventDefault();
	$('#modal-form-editterm').submit();
});



function confirm_delete() {
	if (confirm(urldecode('Confirm Delete!!!'))) {
		return true;
	} else {
		return false;
	}
}

function remove_student(id) {
	if (confirm(urldecode('Confirm Delete!!!'))) {
		$.get('ListStudentServlet', {
			'id' : id
		}, function(data) {
			history.go(0);
		});
		return true;
	} else {
		return false;
	}
}

function remove_teacher(id) {
	if (confirm(urldecode('Confirm Delete!!!'))) {
		$.get('ListTeacherServlet', {
			'id' : id
		}, function(data) {
			history.go(0);
		});
		return true;
	} else {
		return false;
	}
}

function editHoliday(date, month, year) {
	$.get('EditHolidayServlet', {
		'date' : date,
		'month' : month,
		'year' : year
	}, function(data) {
		var tmp = data.date + "/" + data.month + "/" + data.year;
		$('#EditHolidaydate').val(tmp);
		$('#Editdetail').val(data.detail);

		$('#Editdates').val(data.date);
		$('#Editmonths').val(data.month);
		$('#Edityears').val(data.year);
	});
}

function editAttendance(majorName, eduBackground, eduLevel, term,
		dateAttendance) {
	$.post('EditAttendanceServlet', {
		'majorName' : majorName,
		'eduBackground' : eduBackground,
		'eduLevel' : eduLevel,
		'term' : term,
		'dateAttendance' : dateAttendance
	}, function(data) {
		var dShow = "วันที่ - " + dateAttendance;
		var eShow = eduBackground + " " + eduLevel;
		var tShow = "เทอม " + term;
		$('#DateShow').val(dShow);
		$('#EducationShow').val(eShow);
		$('#TermShow').val(tShow);
		
		$('#EditDateShow').val(dateAttendance);
		$('#EditEduBackground').val(eduBackground);
		$('#EditEduLevel').val(eduLevel);
		$('#EditTermShow').val(term);

		var counter = 1;
		var count = 1;
		$.each(data, function(i, item) {
			var name = item.attendance.student.antecedent + ' '
					+ item.attendance.student.firstName;
			
			if (item.attendance.statusActivity == 'มา') {
				var t = $('#modal-table').DataTable().row.add(
						[ counter, item.attendance.student.studentID+'<input name="stuID[]" type="hidden" value="'+item.attendance.student.studentID+'">' , name,
								item.attendance.student.lastName,								
								'<div class="radiocheckbox"><input id="radio'+count+'" type="radio" name="status_'+counter+'" value="มา" checked="checked"><label for="radio'+count+++'">มา</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="สาย"><label for="radio'+count+++'">สาย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ขาด"><label for="radio'+count+++'">ขาด</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลาป่วย"><label for="radio'+count+++'">ลาป่วย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลากิจ"><label for="radio'+count+++'">ลากิจ</label>'
								+'</div>']).draw();
			}else if (item.attendance.statusActivity == 'สาย') {
				var t = $('#modal-table').DataTable().row.add(
						[ counter, item.attendance.student.studentID+'<input name="stuID[]" type="hidden" value="'+item.attendance.student.studentID+'">', name,
								item.attendance.student.lastName,					
								'<div class="radiocheckbox"><input id="radio'+count+'" type="radio" name="status_'+counter+'" value="มา"><label for="radio'+count+++'">มา</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="สาย"  checked="checked"><label for="radio'+count+++'">สาย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ขาด"><label for="radio'+count+++'">ขาด</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลาป่วย"><label for="radio'+count+++'">ลาป่วย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลากิจ"><label for="radio'+count+++'">ลากิจ</label>'
								+'</div>']).draw();
			}else if (item.attendance.statusActivity == 'ขาด') {
				var t = $('#modal-table').DataTable().row.add(
						[ counter, item.attendance.student.studentID+'<input name="stuID[]" type="hidden" value="'+item.attendance.student.studentID+'">', name,
								item.attendance.student.lastName,					
								'<div class="radiocheckbox"><input id="radio'+count+'" type="radio" name="status_'+counter+'" value="มา"><label for="radio'+count+++'">มา</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="สาย"><label for="radio'+count+++'">สาย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ขาด" checked="checked"><label for="radio'+count+++'">ขาด</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลาป่วย"><label for="radio'+count+++'">ลาป่วย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลากิจ"><label for="radio'+count+++'">ลากิจ</label>'
								+'</div>']).draw();
			}else if (item.attendance.statusActivity == 'ลาป่วย') {
				var t = $('#modal-table').DataTable().row.add(
						[ counter, item.attendance.student.studentID+'<input name="stuID[]" type="hidden" value="'+item.attendance.student.studentID+'">', name,
								item.attendance.student.lastName,					
								'<div class="radiocheckbox"><input id="radio'+count+'" type="radio" name="status_'+counter+'" value="มา"><label for="radio'+count+++'">มา</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="สาย"><label for="radio'+count+++'">สาย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ขาด"><label for="radio'+count+++'">ขาด</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลาป่วย" checked="checked"><label for="radio'+count+++'">ลาป่วย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลากิจ"><label for="radio'+count+++'">ลากิจ</label>'
								+'</div>']).draw();
			}else if (item.attendance.statusActivity == 'ลากิจ') {
				var t = $('#modal-table').DataTable().row.add(
						[ counter, item.attendance.student.studentID+'<input name="stuID[]" type="hidden" value="'+item.attendance.student.studentID+'">', name,
								item.attendance.student.lastName,					
								'<div class="radiocheckbox"><input id="radio'+count+'" type="radio" name="status_'+counter+'" value="มา"><label for="radio'+count+++'">มา</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="สาย"><label for="radio'+count+++'">สาย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ขาด"><label for="radio'+count+++'">ขาด</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลาป่วย"><label for="radio'+count+++'">ลาป่วย</label>'
								+'<input id="radio'+count+'" type="radio" name="status_'+counter+'" value="ลากิจ" checked="checked"><label for="radio'+count+++'">ลากิจ</label>'
								+'</div>']).draw();
			}
			counter++;
		});
	});
}

function cancelEdit() {
	var table = $('#modal-table').DataTable();	 
	table.clear().draw();
}

function editStudentByID(id) {
	$.get('EditStudentServlet', {
		'id' : id
	}, function(data) {
		var data1 = data[0], data2 = data[1];
		$('#EditStudentID').val(data1.studentID);
		$('#EditStudentIDs').val(data1.studentID);
		$('#EditStudentAntecedent').val(data1.antecedent);
		$('#EditStudentFirstName').val(data1.firstName);
		$('#EditStudentLastName').val(data1.lastName);
		$('#EditStudentAntecedentParent').val(data1.parent.antecedent);
		$('#EditStudentFirstNameParent').val(data1.parent.firstName);
		$('#EditStudentLastNameParent').val(data1.parent.lastName);
		$('#EditStudentAddNoParent').val(data1.parent.address.addNo);
		$('#EditStudentMooParent').val(data1.parent.address.moo);
		$('#EditStudentStreetParent').val(data1.parent.address.street);
		$('#EditStudentSubDistrictParent').val(data1.parent.address.subDistrict);
		$('#EditStudentDistrictParent').val(data1.parent.address.district);
		$('#EditStudentProvinceParent').val(data1.parent.address.province);
		$('#EditStudentZipCodeParent').val(data1.parent.address.zipCode);

		

		$('#selectMajorNameEdit').empty();
		$('#selectMajorNameEdit').append($("<option></option>").attr("value", "กรุณาเลือกแผนกวิชา").text("กรุณาเลือกแผนกวิชา"));
		
		$.each(data2, function(i, item) {
			$('#selectMajorNameEdit').append($("<option></option>").attr("value", item.majorName).text(item.majorName));
		});
		
		var antecedentToSelect = data1.antecedent;
		$("#EditStudentAntecedent option").each(function(a, b) {
			if ($(this).html() == antecedentToSelect)
				$(this).attr("selected", "selected");
		});
	});	
}

function editTeacherByIdCard(id) {
	$.get('EditTeacherServlet', {
		'id' : id
	}, function(data) {
		$('#EditTeacherIdCard').val(data.idCard);
		$('#EditTeacherIdCards').val(data.idCard);
		$('#EditTeacherAntecedent').val(data.antecedent);
		$('#EditTeacherFirstName').val(data.firstName);
		$('#EditTeacherLastName').val(data.lastName);
		$('#EditTeacherEducationalBackground').val(data.education.educationalBackground);
		$('#EditTeacherEducationalInstitution').val(data.education.educationalInstitution);
		$('#EditTeacherEducationalMajor').val(data.education.educationalMajor);
		$('#EditTeacherVacancy').val(data.vacancy);

		var majorNameToSelect = data.major.majorName;
		$("#user_department option").each(function(a, b) {
			if ($(this).html() == majorNameToSelect)
				$(this).attr("selected", "selected");
		});
		var antecedentToSelect = data.antecedent;
		$("#EditTeacherAntecedent option").each(function(a, b) {
			if ($(this).html() == antecedentToSelect)
				$(this).attr("selected", "selected");
		});
	});
}

function ListEducationEdit() {
	var selectMajorNames = $('#selectMajorNameEdit').find(":selected").val();
	if (selectMajorNames == "กรุณาเลือกแผนกวิชา") {
		$('#selectEducationEdit').append(
				$("<option></option>").attr("value", "").text(""));
	} else {
		$.post('EditStudentServlet', {
			'selectMajorNameEdit' : selectMajorNames,
		}, function(data) {
			$('#selectEducationEdit').empty();
			$('#selectEducationEdit').append(
					$("<option></option>").attr("value", "กรุณาเลือกชั้นปี")
							.text("กรุณาเลือกชั้นปี"));
			$.each(data, function(i, item) {
				var tmp = item.educationLevel.educationalBackground + " "
						+ item.educationLevel.educationLevel;
				$('#selectEducationEdit').append(
						$("<option></option>").attr("value", tmp).text(tmp));
			});
		});
	}
}

function editProfileTeacherModal(id) {
	$.get('EditProfileTeacherServlet', {
		'id' : id
	}, function(data) {
		$('#EditProfileAntecedent').val(data.antecedent);
		$('#EditProfileFirstName').val(data.firstName);
		$('#EditProfileLastName').val(data.lastName);
		$('#EditProfileEmail').val(data.email);
		$('#EditProfilePhone').val(data.phone);
		$('#EditProfileIdCard').val(data.idCard);
		$('#EditProfileIdCards').val(data.idCard);
		
		var antecedentToSelect = data.antecedent;
		$("#EditProfileAntecedent option").each(function(a, b) {
			if ($(this).html() == antecedentToSelect)
				$(this).attr("selected", "selected");
		});
	});
	
}

function editTermByTermName(termName) {
	$.get('EditTermServlet', {
		'termName' : termName
	}, function(data) {
		$('#sDate2').val(data.startDate);
		$('#eDate2').val(data.endDate);

		var str = data.termName;
		var res = str.split("/"); 
		$("#editTermName option").each(function(a, b) {
			if ($(this).html() == res[0])
				$(this).attr("selected", "selected");
		});
		
		$("#editYear option").each(function(a, b) {
			if ($(this).html() == res[1])
				$(this).attr("selected", "selected");
		});
	});
}

function urldecode(str) {
	return decodeURIComponent((str + '').replace(/\+/g, '%20'));
}