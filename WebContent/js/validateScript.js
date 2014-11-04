function LoginSubmit() {
	if (document.login.username.value == "") {
		alert('กรุณากรอก ชื่อผู้ใข้');
		return false;
	} else if (document.login.password.value == "") {
		alert('กรุณากรอก รหัสผ่าน');
		return false;
	}
}

function SearchStudentData() {
	if (document.frmChk.searchStudentID.value.length != 10) {
		alert('รหัสประจำตัวนักศึกษาต้องมี 10 หลักเท่านั้น');
		return false;
	} else if (!document.frmChk.searchStudentID.value.match(/^\d*$/)) {
		alert("กรุณา กรอกรหัสประจำตัวนักศึกษาเป็นตัวเลขเท่านั้น ");
		return false;
	} 
}
function editProfileTeacher() {
	if (document.editProfileChk.profileFirstName.value == "") {
		alert('กรุณากรอก ชื่อ');
		return false;
	} else if (document.editProfileChk.profileLastName.value == "") {
		alert("กรุณากรอก นามสกุล ");
		return false;
	}  else if (document.editProfileChk.profileEmail.value == "") {
		alert("กรุณากรอก อีเมล ");
		return false;
	}  else if (document.editProfileChk.profilePhone.value == "") {
		alert("กรุณากรอก เบอโทรศัพท์ ");
		return false;
	} else if (document.editProfileChk.profilePhone.value.length != 10) {
		alert("หมายเลขโทรศัพท์ต้องมี 10 หลักเท่านั้น");
		return false;
	} else if (!document.editProfileChk.profilePhone.value.match(/^\d*$/)) {
		alert("กรุณา กรอกหมายหมายเลขโทรศัพท์เป็นตัวเลขเท่านั้น ");
		return false;
	}  else if (!document.editProfileChk.profileEmail.value.match(/^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*\@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.([a-zA-Z]){2,4})$/)) {
		alert("รูปแบบ email ไม่ถูกต้อง ");
		return false;
	}
}

function registerTeacher() {
	if (document.regisTeacherchk.IdCardTeacher.value == "") {
		alert('กรุณากรอกข้อมูล หมายเลขบัตรประชาชน');
		return false;
	} else if (!document.regisTeacherchk.IdCardTeacher.value.match(/^\d*$/)) {
		alert("กรุณา กรอกหมายเลขบัตรประชาชนเป็นตัวเลขเท่านั้น ");
		return false;
	} else if (document.regisTeacherchk.IdCardTeacher.value.length != 13) {
		alert("หมายเลขบัตรประชาชนต้องมี 13 หลักเท่านั้น");
		return false;
	} else if (document.regisTeacherchk.FirstNameTeacher.value == "") {
		alert("กรุณากรอกข้อมูล ชื่อ");
		return false;
	} else if (document.regisTeacherchk.LastNameTeacher.value == "") {
		alert("กรุณากรอกข้อมูล นามสกุล");
		return false;
	} else if (document.regisTeacherchk.EducationalBackgroundTeacher.value == "") {
		alert("กรุณากรอกข้อมูล สถาบันการศึกษา");
		return false;
	} else if (document.regisTeacherchk.EducationalInstitutionTeacher.value == "") {
		alert("กรุณากรอกข้อมูล วุฒิการศึกษา");
		return false;
	} else if (document.regisTeacherchk.EducationalMajorTeacher.value == "") {
		alert("กรุณากรอกข้อมูล สาขาวิชา");
		return false;
	} else if (document.regisTeacherchk.EmailTeacher.value == "") {
		alert("กรุณากรอกข้อมูล อีเมล");
		return false;
	}  else if (!document.regisTeacherchk.EmailTeacher.value.match(/^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*\@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.([a-zA-Z]){2,4})$/)) {
		alert("รูปแบบ email ไม่ถูกต้อง ");
		return false;
	} else if (document.regisTeacherchk.PhoneTeacher.value == "") {
		alert("กรุณากรอกข้อมูล เบอร์โทรศัพท์");
		return false;
	} else if (!document.regisTeacherchk.PhoneTeacher.value.match(/^\d*$/)) {
		alert("กรุณา กรอกหมายหมายเลขโทรศัพท์เป็นตัวเลขเท่านั้น ");
		return false;
	} else if (document.regisTeacherchk.PhoneTeacher.value.length != 10) {
		alert("หมายเลขโทรศัพท์ต้องมี 10 หลักเท่านั้น");
		return false;
	} else if (document.regisTeacherchk.VacancyTeacher.value == "") {
		alert("กรุณากรอกข้อมูล ตำแหน่งงาน");
		return false;
	} else if (document.regisTeacherchk.UsernameTeacher.value == "") {
		alert("กรุณากรอกข้อมูล username");
		return false;
	} else if (!document.regisTeacherchk.UsernameTeacher.value.match(/^([a-z0-9\_])+$/i)) {
		alert("ชื่อผู้ใช้ กรอกได้เฉพาะ a-Z, A-Z, 0-9 ");
		return false;
	} else if (document.regisTeacherchk.UsernameTeacher.value.length > 15) {
		alert("ชื่อผู้ใช้ต้องไม่เกิน 15 ตัวอักษร");
		return false;
	} else if (document.regisTeacherchk.PasswordTeacher.value == "") {
		alert("กรุณากรอกข้อมูล password");
		return false;
	} else if (document.regisTeacherchk.ConfirmPasswordTeacher.value == "") {
		alert("กรุณากรอกข้อมูล confirm password");
		return false;
	} else if (document.regisTeacherchk.PasswordTeacher.value != document.regisTeacherchk.ConfirmPasswordTeacher.value) {
		alert('รหัสผ่านไม่ตรงกัน');
		return false;
	} else if (!document.regisTeacherchk.PasswordTeacher.value.match(/^([a-z0-9\_])+$/i)) {
		alert("รหัสผ่าน กรอกได้เฉพาะ a-Z, A-Z, 0-9 ");
		return false;
	} else if (document.regisTeacherchk.PasswordTeacher.value.length >= 16 || document.regisTeacherchk.PasswordTeacher.value.length <= 5) {
		alert("รหัสผ่านต้องไม่ตำกว่า 5 ตัว และไม่เกิน 16 ตัว");
		return false;
	}
}
/*

function addTeacher() {
	if (document.frm.username.value == "") {
		alert('กรุณากรอกข้อมูล ชื่อผู้ใข้');
		return false;
	} else if (document.frm.password.value == "") {
		alert('กรุณากรอกข้อมูล รหัสผ่าน');
		return false;
	} else if (document.frm.confirmPassword.value == "") {
		alert('กรุณากรอกข้อมูล ยืนยันรหัสผ่าน');
		return false;
	} else if (document.frm.firstName.value == "") {
		alert('กรุณากรอกข้อมูล ชื่อ');
		return false;
	} else if (document.frm.lastName.value == "") {
		alert('กรุณากรอกข้อมูล นามสกุล');
		return false;
	} else if (document.frm.idCard.value == "") {
		alert('กรุณากรอกข้อมูล หมายเลขบัตรประชาชน');
		return false;
	} else if (document.frm.vacancy.value == "") {
		alert('กรุณากรอกข้อมูล ตำแหน่ง');
		return false;
	} else if (document.frm.address.value == "") {
		alert('กรุณากรอกข้อมูล ที่อยู่');
		return false;
	} else if (document.frm.phone.value == "") {
		alert('กรุณากรอกข้อมูล หมายเลขโทรศัพ');
		return false;
	} else if (document.frm.email.value == "") {
		alert('กรุณากรอกข้อมูล อีเมล์');
		return false;
	} else if (document.frm.password.value != document.frm.confirmPassword.value) {
		alert('รหัสผ่านไม่ตรงกัน');
		return false;
	} else if (!document.frm.username.value.match(/^([a-z0-9\_])+$/i)) {
		alert("ชื่อผู้ใช้ กรอกได้เฉพาะ a-Z, A-Z, 0-9 ");
		return false;
	} else if (document.frm.username.value.length > 15) {
		alert("ชื่อผู้ใช้ต้องไม่เกิน 15 ตัวอักษร");
		return false;
	} else if (!document.frm.password.value.match(/^([a-z0-9\_])+$/i)) {
		alert(document.frm.password.value);
		alert("รหัสผ่าน กรอกได้เฉพาะ a-Z, A-Z, 0-9 ");
		return false;
	} else if (document.frm.password.value.length >= 16
			|| document.frm.password.value.length <= 8) {
		alert("รหัสผ่านต้องไม่ตำกว่า 8 ตัว และไม่เกิน 16 ตัว");
		return false;
	} else if (document.frm.idCard.value.length != 13) {
		alert("หมายเลขบัตรประชาชนต้องมี 13 หลักเท่านั้น");
		return false;
	} else if (!document.frm.idCard.value.match(/^\d*$/)) {
		alert("กรุณา กรอกหมายเลขบัตรประชาชนเป็นตัวเลขเท่านั้น ");
		return false;
	} else if (document.frm.phone.value.length != 10) {
		alert("หมายเลขโทรศัพท์ต้องมี 13 หลักเท่านั้น");
		return false;
	} else if (!document.frm.phone.value.match(/^\d*$/)) {
		alert("กรุณา กรอกหมายหมายเลขโทรศัพท์เป็นตัวเลขเท่านั้น ");
		return false;
	}
}

function editTeacherchk() {
	if (document.editfrm.firstName.value == "") {
		alert('กรุณากรอกข้อมูล ชื่อ');
		return false;
	} else if (document.editfrm.lastName.value == "") {
		alert('กรุณากรอกข้อมูล นามสกุล');
		return false;
	} else if (document.editfrm.vacancy.value == "") {
		alert('กรุณากรอกข้อมูล ตำแหน่ง');
		return false;
	} else if (document.editfrm.address.value == "") {
		alert('กรุณากรอกข้อมูล ที่อยู่');
		return false;
	} else if (document.editfrm.phone.value == "") {
		alert('กรุณากรอกข้อมูล หมายเลขโทรศัพ');
		return false;
	} else if (document.editfrm.email.value == "") {
		alert('กรุณากรอกข้อมูล อีเมล์');
		return false;
	} else if (!document.editfrm.username.value.match(/^([a-z0-9\_])+$/i)) {
		alert("ชื่อผู้ใช้ กรอกได้เฉพาะ a-Z, A-Z, 0-9 ");
		return false;
	} else if (document.editfrm.username.value.length > 15) {
		alert("ชื่อผู้ใช้ต้องไม่เกิน 15 ตัวอักษร");
		return false;
	} else if (document.editfrm.phone.value.length != 10) {
		alert("หมายเลขโทรศัพท์ต้องมี 13 หลักเท่านั้น");
		return false;
	} else if (!document.editfrm.phone.value.match(/^\d*$/)) {
		alert("กรุณา กรอกหมายหมายเลขโทรศัพท์เป็นตัวเลขเท่านั้น ");
		return false;
	}
	if (!document.editfrm.newpassword.value == "") {
		if (document.editfrm.newpassword.value != document.frm.confirmPassword.value) {
			alert('รหัสผ่านไม่ตรงกัน');
			return false;
		} else if (!document.editfrm.newpassword.value
				.match(/^([a-z0-9\_])+$/i)) {
			alert(document.editfrm.newpassword.value);
			alert("รหัสผ่าน กรอกได้เฉพาะ a-Z, A-Z, 0-9 ");
			return false;
		} else if (document.editfrm.newpassword.value.length >= 16
				|| document.frm.newpassword.value.length <= 8) {
			alert("รหัสผ่านต้องไม่ตำกว่า 8 ตัว และไม่เกิน 16 ตัว");
			return false;
		}
	}
}
function addRoomchk() {
	if (document.addRoom.RoomId.value == "") {
		alert("กรุณากรอกรหัสห้องเรียน");
		return false;
	} else if (document.addRoom.RoomCapacity.value == "") {
		alert("กรุณากรอกความจุของห้อง");
		return false;
	} else if (!document.addRoom.RoomCapacity.value.match(/^\d*$/)) {
		alert("ความจุของห้องต้องเป็นตัวเลขเท่านั้น");
		return false;
	} else if (document.addRoom.Build.value == "") {
		alert("กรุณากรอกอาคาร");
		return false;
	}
}
function editRoomchk() {
	if (document.editRoomfrm.RoomCapacity.value == "") {
		alert("กรุณากรอกความจุของห้อง");
		return false;
	} else if (!document.editRoomfrm.RoomCapacity.value.match(/^\d*$/)) {
		alert("ความจุของห้องต้องเป็นตัวเลขเท่านั้น");
		return false;
	} else if (document.editRoomfrm.Build.value == "") {
		alert("กรุณากรอกอาคาร");
		return false;
	}
}
function addHolidaychk() {
	if (document.addHolidayfrm.StartDate.value == "") {
		alert("กรุณากรอก วัน/เดือน/ปี");
		return false;
	} else if (document.addHolidayfrm.EndDate.value == "") {
		alert("กรุณากรอก วัน/เดือน/ปี");
		return false;
	} else if (document.addHolidayfrm.detail.value == "") {
		alert("กรุณากรอก รายละเอียด");
		return false;
	}
}
function editHolidaychk() {

	if (document.editHolidayfrm.detail.value == "") {
		alert("กรุณากรอก รายละเอียด");
		return false;
	}
}
function addCoursechk() {

	if (document.addCoursefrm.courseId.value == "") {
		alert("กรุณากรอก รหัสวิชา");
		return false;
	} else if (document.addCoursefrm.courseName.value == "") {
		alert("กรุณากรอก ชื่อวิชา");
		return false;
	} else if (document.addCoursefrm.addStartDate.value == "") {
		alert("กรุณากรอก วันเปิดเทอมการศึกษา");
		return false;
	} else if (document.addCoursefrm.addEndDate.value == "") {
		alert("กรุณากรอก วันสิ้นสุดเทอมการศึกษา");
		return false;
	}
}
function editCoursechk() {
	if (document.editCoursefrm.courseName.value == "") {
		alert("กรุณากรอก ชื่อวิชา");
		return false;
	} else if (document.editCoursefrm.startDate.value == "") {
		alert("กรุณากรอก วันเปิดเทอมการศึกษา");
		return false;
	} else if (document.editCoursefrm.endDate.value == "") {
		alert("กรุณากรอก วันสิ้นสุดเทอมการศึกษา");
		return false;
	}
}
function addMakeUpchk() {
	if (document.addMakeUpfrm.a_date.value == "") {
		alert("กรุณากรอก วัน/เดือน/ปี");
		return false;
	}
}
function CancelClasschk() {
	if (document.CancelClassfrm.c_because.value == "") {
		alert("กรุณากรอก หมายเหตุ");
		return false;
	}
}
*/
