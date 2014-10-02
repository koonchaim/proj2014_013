if (top.location != location) {
	top.location.href = document.location.href;
}
$(function() {
	window.prettyPrint && prettyPrint();
	$('#dp1').datepicker({
		format : 'mm-dd-yyyy'
	});
	$('#dp2').datepicker();

	$('#sDate1').datepicker();
	$('#eDate1').datepicker();
	$('#sDate2').datepicker();
	$('#eDate2').datepicker();

	$('#dpYears').datepicker();
	$('#dpMonths').datepicker();

	// disabling dates
	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp
			.getDate(), 0, 0, 0, 0);

	var checkin = $('#dpd1').datepicker({
		onRender : function(date) {
			return date.valueOf() < now.valueOf() ? 'disabled' : '';
		}
	}).on('changeDate', function(ev) {
		if (ev.date.valueOf() > checkout.date.valueOf()) {
			var newDate = new Date(ev.date)
			newDate.setDate(newDate.getDate() + 1);
			checkout.setValue(newDate);
		}
		checkin.hide();
		$('#dpd2')[0].focus();
	}).data('datepicker');
	var checkout = $('#dpd2').datepicker({
		onRender : function(date) {
			return date.valueOf() < checkin.date.valueOf() ? 'disabled' : '';
		}
	}).on('changeDate', function(ev) {
		checkout.hide();
	}).data('datepicker');

	/*
	 * *********************************************************
	 */
	var checkStart = $('#sDate1').datepicker({
		onRender : function(date) {
			return date.valueOf();
		}
	}).on('changeDate', function(ev) {
		if (ev.date.valueOf() > checkEnd.date.valueOf()) {
			var newDate = new Date(ev.date)
			newDate.setDate(newDate.getDate() + 1);
			checkEnd.setValue(newDate);
		}
		checkStart.hide();
		$('#eDate1')[0].focus();
	}).data('datepicker');
	var checkEnd = $('#eDate1')
			.datepicker(
					{
						onRender : function(date) {
							return date.valueOf() <= checkStart.date.valueOf() ? 'disabled'
									: '';
						}
					}).on('changeDate', function(ev) {
				checkEnd.hide();
			}).data('datepicker');

	/*
	 * *********************************************************
	 */
	var checkStart2 = $('#sDate2').datepicker({
		onRender : function(date) {
			return date.valueOf();
		}
	}).on('changeDate', function(ev) {
		if (ev.date.valueOf() > checkEnd2.date.valueOf()) {
			var newDate = new Date(ev.date)
			newDate.setDate(newDate.getDate() + 1);
			checkEnd2.setValue(newDate);
		}
		checkStart2.hide();
		$('#eDate2')[0].focus();
	}).data('datepicker');
	var checkEnd2 = $('#eDate2')
			.datepicker(
					{
						onRender : function(date) {
							return date.valueOf() <= checkStart2.date.valueOf() ? 'disabled'
									: '';
						}
					}).on('changeDate', function(ev) {
				checkEnd2.hide();
			}).data('datepicker');
});