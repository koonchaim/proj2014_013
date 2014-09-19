<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" media="all"
	href="css/jsDatePick_ltr.min.css" />
<!-- 
	OR if you want to use the calendar in a right-to-left website
	just use the other CSS file instead and don't forget to switch g_jsDatePickDirectionality variable to "rtl"!
	
	<link rel="stylesheet" type="text/css" media="all" href="jsDatePick_ltr.css" />
-->
<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
<!-- 
	After you copied those 2 lines of code , make sure you take also the files into the same folder :-)
    Next step will be to set the appropriate statement to "start-up" the calendar on the needed HTML element.
    
    The first example of Javascript snippet is for the most basic use , as a popup calendar
    for a text field input.
-->
<script type="text/javascript">
	window.onload = function() {
		new JsDatePick({
			useMode : 2,
			target : "inputField",
			dateFormat : "%d/%M/%Y"
		/*selectedDate:{				This is an example of what the full configuration offers.
			day:5,						For full documentation about these settings please see the full version of the code.
			month:9,
			year:2006
		},
		yearsRange:[1978,2020],
		limitToToday:false,
		cellColorScheme:"beige",
		dateFormat:"%m-%d-%Y",
		imgPath:"img/",
		weekStartDay:1*/
		});

		new JsDatePick({
			useMode : 2,
			target : "inputField2",
			dateFormat : "%d/%M/%Y"
		/*selectedDate:{				This is an example of what the full configuration offers.
			day:5,						For full documentation about these settings please see the full version of the code.
			month:9,
			year:2006
		},
		yearsRange:[1978,2020],
		limitToToday:false,
		cellColorScheme:"beige",
		dateFormat:"%m-%d-%Y",
		imgPath:"img/",
		weekStartDay:1*/
		});
	};
</script>
<form id="modal-form" accept-charset="UTF-8" data-remote="true"
	action="AddHolidayServlet" method="post" name="addHolidayfrm"
	onSubmit="JavaScript:return addHolidaychk();" class="form-horizontal">

	<div class="form-group">
		<label class="col-lg-3 control-label">ตั้งแต่ วัน/เดือน/ปี :</label>
		<div class="col-lg-8">
<!-- 			<input type="text" class="form-control" id="inputField" name="StartDate" /> -->
				<input type="text" class="form-control" value="" id="dpd1" name="StartDate">
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-3 control-label">ถึง วัน/เดือน/ปี :</label>
		<div class="col-lg-8">
<!-- 			<input type="text" class="form-control" id="inputField2" name="EndDate" /> -->
				<input type="text" class="form-control" value="" id="dpd2" name="EndDate">
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-3 control-label">รายละเอียด :</label>
		<div class="col-lg-8">
			<input type="text" name="detail" class="form-control">
		</div>
	</div>
</form>


<div class="container">
	<div class="row">
		<div class="span9 columns"></div>
	</div>
</div>
<div class="datepicker dropdown-menu"
	style="display: none; top: 58px; left: 307.890625px;">
	<div class="datepicker-days" style="display: block;">
		<table class=" table-condensed">
			<thead>
				<tr>
					<th class="prev">‹</th>
					<th colspan="5" class="switch">กันยายน 2014</th>
					<th class="next">›</th>
				</tr>
				<tr>
					<th class="dow">อา</th>
					<th class="dow">จ</th>
					<th class="dow">อ</th>
					<th class="dow">พ</th>
					<th class="dow">พฤ</th>
					<th class="dow">ศ</th>
					<th class="dow">ส</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="day disabled old">31</td>
					<td class="day disabled">1</td>
					<td class="day disabled">2</td>
					<td class="day disabled">3</td>
					<td class="day disabled">4</td>
					<td class="day disabled">5</td>
					<td class="day disabled">6</td>
				</tr>
				<tr>
					<td class="day disabled">7</td>
					<td class="day disabled">8</td>
					<td class="day  active">9</td>
					<td class="day ">10</td>
					<td class="day ">11</td>
					<td class="day ">12</td>
					<td class="day ">13</td>
				</tr>
				<tr>
					<td class="day ">14</td>
					<td class="day ">15</td>
					<td class="day ">16</td>
					<td class="day ">17</td>
					<td class="day ">18</td>
					<td class="day ">19</td>
					<td class="day ">20</td>
				</tr>
				<tr>
					<td class="day ">21</td>
					<td class="day ">22</td>
					<td class="day ">23</td>
					<td class="day ">24</td>
					<td class="day ">25</td>
					<td class="day ">26</td>
					<td class="day ">27</td>
				</tr>
				<tr>
					<td class="day ">28</td>
					<td class="day ">29</td>
					<td class="day ">30</td>
					<td class="day  new">1</td>
					<td class="day  new">2</td>
					<td class="day  new">3</td>
					<td class="day  new">4</td>
				</tr>
				<tr>
					<td class="day  new">5</td>
					<td class="day  new">6</td>
					<td class="day  new">7</td>
					<td class="day  new">8</td>
					<td class="day  new">9</td>
					<td class="day  new">10</td>
					<td class="day  new">11</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="datepicker-months" style="display: none;">
		<table class="table-condensed">
			<thead>
				<tr>
					<th class="prev">‹</th>
					<th colspan="5" class="switch">2014</th>
					<th class="next">›</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7"><span class="month">ม.ค.</span><span
						class="month">ก.พ.</span><span class="month">มี.ค.</span><span
						class="month">เม.ย.</span><span class="month">พ.ค.</span><span
						class="month">มิ.ย.</span><span class="month">ก.ค.</span><span
						class="month">ส.ค.</span><span class="month active">ก.ย.</span><span
						class="month">ต.ค.</span><span class="month">พ.ย</span><span
						class="month">ธ.ค.</span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="datepicker-years" style="display: none;">
		<table class="table-condensed">
			<thead>
				<tr>
					<th class="prev">‹</th>
					<th colspan="5" class="switch">2010-2019</th>
					<th class="next">›</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7"><span class="year old">2009</span><span
						class="year">2010</span><span class="year">2011</span><span
						class="year">2012</span><span class="year">2013</span><span
						class="year active">2014</span><span class="year">2015</span><span
						class="year">2016</span><span class="year">2017</span><span
						class="year">2018</span><span class="year">2019</span><span
						class="year old">2020</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="datepicker dropdown-menu"
	style="display: none; top: 58px; left: 639.21875px;">
	<div class="datepicker-days" style="display: block;">
		<table class=" table-condensed">
			<thead>
				<tr>
					<th class="prev">‹</th>
					<th colspan="5" class="switch">กันยายน 2015</th>
					<th class="next">›</th>
				</tr>
				<tr>
					<th class="dow">อา</th>
					<th class="dow">จ</th>
					<th class="dow">อ</th>
					<th class="dow">พ</th>
					<th class="dow">พฤ</th>
					<th class="dow">ศ</th>
					<th class="dow">ส</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="day disabled old">30</td>
					<td class="day disabled old">31</td>
					<td class="day disabled">1</td>
					<td class="day ">2</td>
					<td class="day  active">3</td>
					<td class="day ">4</td>
					<td class="day ">5</td>
				</tr>
				<tr>
					<td class="day ">6</td>
					<td class="day ">7</td>
					<td class="day ">8</td>
					<td class="day ">9</td>
					<td class="day ">10</td>
					<td class="day ">11</td>
					<td class="day ">12</td>
				</tr>
				<tr>
					<td class="day ">13</td>
					<td class="day ">14</td>
					<td class="day ">15</td>
					<td class="day ">16</td>
					<td class="day ">17</td>
					<td class="day ">18</td>
					<td class="day ">19</td>
				</tr>
				<tr>
					<td class="day ">20</td>
					<td class="day ">21</td>
					<td class="day ">22</td>
					<td class="day ">23</td>
					<td class="day ">24</td>
					<td class="day ">25</td>
					<td class="day ">26</td>
				</tr>
				<tr>
					<td class="day ">27</td>
					<td class="day ">28</td>
					<td class="day ">29</td>
					<td class="day ">30</td>
					<td class="day  new">1</td>
					<td class="day  new">2</td>
					<td class="day  new">3</td>
				</tr>
				<tr>
					<td class="day  new">4</td>
					<td class="day  new">5</td>
					<td class="day  new">6</td>
					<td class="day  new">7</td>
					<td class="day  new">8</td>
					<td class="day  new">9</td>
					<td class="day  new">10</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="datepicker-months" style="display: none;">
		<table class="table-condensed">
			<thead>
				<tr>
					<th class="prev">‹</th>
					<th colspan="5" class="switch">2015</th>
					<th class="next">›</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7"><span class="month">ม.ค.</span><span
						class="month">ก.พ.</span><span class="month">มี.ค.</span><span
						class="month">เม.ย.</span><span class="month">พ.ค.</span><span
						class="month">มิ.ย.</span><span class="month">ก.ค.</span><span
						class="month">ส.ค.</span><span class="month active">ก.ย.</span><span
						class="month">ต.ค.</span><span class="month">พ.ย.</span><span
						class="month">ธ.ค.</span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="datepicker-years" style="display: none;">
		<table class="table-condensed">
			<thead>
				<tr>
					<th class="prev">‹</th>
					<th colspan="5" class="switch">2010-2019</th>
					<th class="next">›</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7"><span class="year old">2009</span><span
						class="year">2010</span><span class="year">2011</span><span
						class="year">2012</span><span class="year">2013</span><span
						class="year">2014</span><span class="year active">2015</span><span
						class="year">2016</span><span class="year">2017</span><span
						class="year">2018</span><span class="year">2019</span><span
						class="year old">2020</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>