$(document)
		.ready(
				function() {
					$("#btnsubmitgenform")
							.click(
									function() {
										var isValid = true;
										var chkValid = true;
										var chkSDate = true;
										var chkEDate = true;
										var dpd1 = $('#dpd1');
										var dpd2 = $('#dpd2');

										dateNow = new Date();
										var dd = dateNow.getDate();
										var mm = dateNow.getMonth() + 1;
										var yyyy = dateNow.getFullYear();
										// alert(dd+"/"+mm+"/"+yyyy);

										$('input[datatype=textEvaluation]').each(function() {
											var datatype = $.trim($(this).val());

											if ($.trim($(this).val()) == '') {
												isValid = false;
												$(this).css({"border" : "1px solid red","background" : "#FFCECE"});

											} else {
												if (/[~`!#$%\^&*+=\-\[\]\\';,/{}|\\":<>\?]/
																		.test(datatype)) {
																	isValid = false;
																	$(this)
																			.css(
																					{
																						"border" : "1px solid red",
																						"background" : "#FFCECE"
																					});
																	alert("ห้ามเป็นอักขระพิเศษ");

																} else {
																	$(this)
																			.css(
																					{
																						"border" : "",
																						"background" : ""
																					});
																}
															}

														});

										if (isValid == false
												|| chkValid == false
												|| chkSDate == false
												|| chkEDate == false) {
											return false;
										}

									});

				});