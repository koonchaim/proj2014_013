function LoginSubmit() {
	if (document.login.username.value == "") {
		$('#MessageAlert').text('กรุณากรอก ชื่อผู้ใข้');
		$('#danger').modal('show');
		return false;
	} else if (document.login.password.value == "") {
		$('#MessageAlert').text('กรุณากรอก รหัสผ่าน');
		$('#danger').modal('show');
		return false;
	}
}

function SearchStudentData() {
	if (document.frmChk.searchStudentID.value.length != 10) {
		$('#MessageAlert').text('รหัสประจำตัวนักศึกษาต้องมี 10 หลักเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (!document.frmChk.searchStudentID.value.match(/^\d*$/)) {
		$('#MessageAlert').text(
				'กรุณา กรอกรหัสประจำตัวนักศึกษาเป็นตัวเลขเท่านั้น');
		$('#danger').modal('show');
		return false;
	}
}

function editProfileTeacher() {
	if (document.editProfileChk.profileFirstName.value == "") {
		$('#MessageAlert').text('กรุณากรอก ชื่อ');
		$('#danger').modal('show');
		return false;
	} else if (document.editProfileChk.profileLastName.value == "") {
		$('#MessageAlert').text('กรุณากรอก นามสกุล');
		$('#danger').modal('show');
		return false;
	} else if (document.editProfileChk.profileEmail.value == "") {
		$('#MessageAlert').text('กรุณากรอก อีเมล');
		$('#danger').modal('show');
		return false;
	} else if (document.editProfileChk.profilePhone.value == "") {
		$('#MessageAlert').text('กรุณากรอก เบอโทรศัพท์');
		$('#danger').modal('show');
		return false;
	} else if (document.editProfileChk.profilePhone.value.length != 10) {
		$('#MessageAlert').text('หมายเลขโทรศัพท์ต้องมี 10 หลักเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (!document.editProfileChk.profilePhone.value.match(/^\d*$/)) {
		$('#MessageAlert').text(
				'กรุณา กรอกหมายหมายเลขโทรศัพท์เป็นตัวเลขเท่านั้น ');
		$('#danger').modal('show');
		return false;
	} else if (!document.editProfileChk.profileEmail.value
			.match(/^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*\@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.([a-zA-Z]){2,4})$/)) {
		$('#MessageAlert').text('รูปแบบ email ไม่ถูกต้อง ');
		$('#danger').modal('show');
		return false;
	}
}

function registerTeacher() {
	if (document.regisTeacherchk.IdCardTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล หมายเลขบัตรประชาชน');
		$('#danger').modal('show');
		return false;
	} else if (!document.regisTeacherchk.IdCardTeacher.value.match(/^\d*$/)) {
		$('#MessageAlert').text(
				'กรุณา กรอกหมายเลขบัตรประชาชนเป็นตัวเลขเท่านั้น ');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.IdCardTeacher.value.length != 13) {
		$('#MessageAlert').text('หมายเลขบัตรประชาชนต้องมี 13 หลักเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.FirstNameTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล ชื่อ');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.LastNameTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล นามสกุล');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.EducationalBackgroundTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล สถาบันการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.EducationalInstitutionTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล วุฒิการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.EducationalMajorTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล สาขาวิชา');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.EmailTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล อีเมล');
		$('#danger').modal('show');
		return false;
	} else if (!document.regisTeacherchk.EmailTeacher.value
			.match(/^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*\@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.([a-zA-Z]){2,4})$/)) {
		$('#MessageAlert').text('รูปแบบ email ไม่ถูกต้อง ');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.PhoneTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล เบอร์โทรศัพท์');
		$('#danger').modal('show');
		return false;
	} else if (!document.regisTeacherchk.PhoneTeacher.value.match(/^\d*$/)) {
		$('#MessageAlert').text(
				'กรุณา กรอกหมายหมายเลขโทรศัพท์เป็นตัวเลขเท่านั้น ');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.PhoneTeacher.value.length != 10) {
		$('#MessageAlert').text('หมายเลขโทรศัพท์ต้องมี 10 หลักเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.VacancyTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล ตำแหน่งงาน');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.UsernameTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล username');
		$('#danger').modal('show');
		return false;
	} else if (!document.regisTeacherchk.UsernameTeacher.value
			.match(/^([a-z0-9\_])+$/i)) {
		$('#MessageAlert').text('ชื่อผู้ใช้ กรอกได้เฉพาะ a-Z, A-Z, 0-9 ');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.UsernameTeacher.value.length > 15) {
		$('#MessageAlert').text('ชื่อผู้ใช้ต้องไม่เกิน 15 ตัวอักษร');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.PasswordTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล password');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.ConfirmPasswordTeacher.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล confirm password');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.PasswordTeacher.value != document.regisTeacherchk.ConfirmPasswordTeacher.value) {
		$('#MessageAlert').text('รหัสผ่านไม่ตรงกัน');
		$('#danger').modal('show');
		return false;
	} else if (!document.regisTeacherchk.PasswordTeacher.value
			.match(/^([a-z0-9\_])+$/i)) {
		$('#MessageAlert').text('รหัสผ่าน กรอกได้เฉพาะ a-Z, A-Z, 0-9 ');
		$('#danger').modal('show');
		return false;
	} else if (document.regisTeacherchk.PasswordTeacher.value.length >= 16
			|| document.regisTeacherchk.PasswordTeacher.value.length <= 5) {
		$('#MessageAlert')
				.text('รหัสผ่านต้องไม่ตำกว่า 5 ตัว และไม่เกิน 16 ตัว');
		$('#danger').modal('show');
		return false;
	}
}

function editTeacherData() {
	if (document.editTeacherDataChk.editTeacherFirstName.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล ชื่อ');
		$('#danger').modal('show');
		return false;
	} else if (document.editTeacherDataChk.editTeacherLastName.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล นามสกุล');
		$('#danger').modal('show');
		return false;
	} else if (document.editTeacherDataChk.editTeacherEducationalInstitution.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล วุฒิการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.editTeacherDataChk.editTeacherEducationalMajor.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล สาขาวิชา');
		$('#danger').modal('show');
		return false;
	} else if (document.editTeacherDataChk.editTeacherEducationalBackground.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล สถาบันการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.editTeacherDataChk.editTeacherVacancy.value == "") {
		$('#MessageAlert').text('กรุณากรอกข้อมูล ตำแหน่งงาน');
		$('#danger').modal('show');
		return false;
	}
}

function registerStudent() {
	if (document.registerStudentchk.studentID_stu.value == "") {
		$('#MessageAlert').text('กรุณากรอก รหัสประจำตัวนักศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (!document.registerStudentchk.studentID_stu.value.match(/^\d*$/)) {
		$('#MessageAlert').text(
				'กรุณา กรอกรหัสประจำตัวนักศึกษาเป็นตัวเลขเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.studentID_stu.value.length != 10) {
		$('#MessageAlert').text('รหัสประจำตัวนักศึกษาต้องมี 10 หลักเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.firstName_stu.value == "") {
		$('#MessageAlert').text('กรุณากรอก ชื่อนักศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.lastName_stu.value == "") {
		$('#MessageAlert').text('กรุณากรอก นามสกุลนักศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.selectMajorName.value == "กรุณาเลือกแผนกวิชา") {
		$('#MessageAlert').text('กรุณาเลือก แผนกวิชา');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.selectEducation.value == "") {
		$('#MessageAlert').text('กรุณาเลือก ชั้นปีการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.selectEducation.value == "กรุณาเลือกชั้นปี") {
		$('#MessageAlert').text('กรุณาเลือก ชั้นปีการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.firstName_par.value == "") {
		$('#MessageAlert').text('กรุณากรอก ชื่อผู้ปกครอง');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.lastName_par.value == "") {
		$('#MessageAlert').text('กรุณากรอก นามสกุลผู้ปกครอง');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.addNo_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก บ้านเลขที่');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.moo_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก หมู่');
		$('#danger').modal('show');
		return false;
	} else if (!document.registerStudentchk.moo_regis.value.match(/^\d*$/)) {
		$('#MessageAlert').text('กรุณากรอก หมู่เป็นตัวเลขเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.street_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก ถนน');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.subDistrict_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก ตำบล');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.district_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก อำเภอ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.province_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก จังหวัด');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.zipCode_regis.value == "") {
		$('#MessageAlert').text('กรุณากรอก รหัสไปรษณีย์');
		$('#danger').modal('show');
		return false;
	} else if (!document.registerStudentchk.zipCode_regis.value.match(/^\d*$/)) {
		$('#MessageAlert').text('กรุณากรอก รหัสไปรษณีย์เป็นตัวเลขเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.firstName_stu.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ชื่อนักศึกษา ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.lastName_stu.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('นามสกุล ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.firstName_par.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ชื่อผู้ปกครอง ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.lastName_par.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('นามสกุลผู้ปกครอง ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.addNo_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('บ้านเลขที่ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.moo_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('หมู่ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.street_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ถนน ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.subDistrict_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ตำบล ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.district_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('อำเภอ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.province_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('จังหวัด ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.registerStudentchk.zipCode_regis.value
			.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('รหัสไปรษณีย์ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	}
}

function editregisterStudent() {
	if (document.editregisterStudentchk.studentFirstName.value == "") {
		$('#MessageAlert').text('กรุณากรอก ชื่อนักศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.studentLastName.value == "") {
		$('#MessageAlert').text('กรุณากรอก นามสกุลนักศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.selectMajorNameEdit.value == "กรุณาเลือกแผนกวิชา") {
		$('#MessageAlert').text('กรุณาเลือก แผนกวิชา');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.selectEducationEdit.value == "") {
		$('#MessageAlert').text('กรุณาเลือก ชั้นปีการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.selectEducationEdit.value == "กรุณาเลือกชั้นปี") {
		$('#MessageAlert').text('กรุณาเลือก ชั้นปีการศึกษา');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentFirstName.value == "") {
		$('#MessageAlert').text('กรุณากรอก ชื่อผู้ปกครอง');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentLastName.value == "") {
		$('#MessageAlert').text('กรุณากรอก นามสกุลผู้ปกครอง');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentAddresss.value == "") {
		$('#MessageAlert').text('กรุณากรอก บ้านเลขที่');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentMoo.value == "") {
		$('#MessageAlert').text('กรุณากรอก หมู่');
		$('#danger').modal('show');
		return false;
	} else if (!document.editregisterStudentchk.parentMoo.value.match(/^\d*$/)) {
		$('#MessageAlert').text('กรุณากรอก หมู่เป็นตัวเลขเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentStreet.value == "") {
		$('#MessageAlert').text('กรุณากรอก ถนน');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentSubDistrict.value == "") {
		$('#MessageAlert').text('กรุณากรอก ตำบล');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentDistrict.value == "") {
		$('#MessageAlert').text('กรุณากรอก อำเภอ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentProvince.value == "") {
		$('#MessageAlert').text('กรุณากรอก จังหวัด');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentZipCode.value == "") {
		$('#MessageAlert').text('กรุณากรอก รหัสไปรษณีย์');
		$('#danger').modal('show');
		return false;
	} else if (!document.editregisterStudentchk.parentZipCode.value.match(/^\d*$/)) {
		$('#MessageAlert').text('กรุณากรอก รหัสไปรษณีย์เป็นตัวเลขเท่านั้น');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.studentFirstName.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ชื่อนักศึกษา ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.studentLastName.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('นามสกุลนักศึกษา ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentFirstName.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ชื่อผู้ปกครอง ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentLastName.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('นามสกุลผู้ปกครอง ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentAddresss.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('บ้านเลขที่ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentMoo.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('หมู่ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentStreet.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()]*$/)) {
		$('#MessageAlert').text('ถนน ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentSubDistrict.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('ตำบล ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentDistrict.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('อำเภอ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentProvince.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('จังหวัด ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	} else if (document.editregisterStudentchk.parentZipCode.value.match(/^[.?!@&#+%:;/<>*$'",\[\]\{\}^()-]*$/)) {
		$('#MessageAlert').text('รหัสไปรษณีย์ ห้ามมีอักขระพิเศษ');
		$('#danger').modal('show');
		return false;
	}
}

function editHolidaychk() {
	 if (document.editHolidayfrm.detail.value == "") {
		 $('#MessageAlert').text('กรุณากรอก รายละเอียด');
		 $('#danger').modal('show');
		 return false;
	 }
}

function addHolidaychk() {	
	 if (document.addHolidayfrm.StartDate.value == "") {
		 $('#MessageAlert').text('กรุณากรอก วัน/เดือน/ปี');
		 $('#danger').modal('show');
		 return false;
	 } else if (document.addHolidayfrm.EndDate.value == "") {
		 $('#MessageAlert').text('กรุณากรอก วัน/เดือน/ปี');
		 $('#danger').modal('show');
		 return false;
	 } else if (document.addHolidayfrm.detail.value == "") {
		 $('#MessageAlert').text('กรุณากรอก รายละเอียด');
		 $('#danger').modal('show');
		 return false;
	 }
}

function addTermchk() {
	 if (document.addTermfrm.StartDate1.value == "") {
		 $('#MessageAlert').text('กรุณากรอก วัน/เดือน/ปี');
		 $('#danger').modal('show');
		 return false;
	 } else if (document.addTermfrm.EndDate1.value == "") {
		 $('#MessageAlert').text('กรุณากรอก วัน/เดือน/ปี');
		 $('#danger').modal('show');
		 return false;
	 } else if (document.addTermfrm.year.value == "") {
		 $('#MessageAlert').text('กรุณากรอก ปีการศึกษา');
		 $('#danger').modal('show');
		 return false;
	 }
}

