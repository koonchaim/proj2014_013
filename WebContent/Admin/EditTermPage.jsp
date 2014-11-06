<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="modal-form-editterm" accept-charset="UTF-8" 
	action="EditTermServlet" method="post" class="form-horizontal">

	<div class="form-group">
		<label class="col-lg-3 control-label">ตั้งแต่ วัน/เดือน/ปี :</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" value="" id="sDate2"
				name="StartDate2">
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-3 control-label">ถึง วัน/เดือน/ปี :</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" value="" id="eDate2" name="EndDate2">
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-3 control-label">เทอมการศึกษาที่ :</label>
		<div class="col-lg-8">
			<select class="selectpicker show-tick show-menu-arrow" data-width="25%" data-size="auto" name="editTermName" id="editTermName">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
			</select>
		</div>
	</div>	
	<div class="form-group">
		<label class="col-lg-3 control-label">ปีการศึกษา :</label>
		<div class="col-lg-8">
			<select class="selectpicker show-tick show-menu-arrow" data-width="25%" data-size="auto" name="editYear" name="editYear">
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
			</select>
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