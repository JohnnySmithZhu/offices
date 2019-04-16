<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>社員明細</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>


</head>
<body>
	<script>
	$(function() {
		$("#back_btn").click(function() {
		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/社員back");
		    $("#fbean").submit();
		});

		$("#save_btn").click(function() {
			if("${モード}" == "編集"){
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/社員update");
			    $("#fbean").submit();

			}else{
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/社員save");
			    $("#fbean").submit();
			}
		});

	});



	</script>

	<form id ="fbean" name="fbean" method="post">

	<h1>${titleName}</h1>


	<input type="text" value="${employeeID}" name="employeeID"/>

	<br>
	<div>
		<label>名前</label>
		<input type="text" value="${employeeName}" name="employeeName" />
		<input type="hidden" value="${employeeName}" name="old_employeeName" />
	</div>
	<br>
	<div>
		<label>電話番号</label>
		<input type="text" value="${phoneNumber}" name="phoneNumber" />
		<input type="hidden" value="${phoneNumber}" name="old_phoneNumber" />
	</div>
	<br>
	<div>
		<label>性別</label> <select style="width:60px" name="sex" >
			<option value="" ${性別 == '' ? 'selected' : ''}></option>
			<option value="女" ${性別 == '女' ? 'selected' : ''}>女</option>
			<option value="男" ${性別 == '男' ? 'selected' : ''}>男</option>
			<option value="ほか" ${性別 == 'ほか' ? 'selected' : ''}>ほか</option>
		</select>
		<input type="hidden" value="${sex}" name="old_sex" />
	</div>
	<br>
	<div>
		<label>年齢</label>
		<input type="text" value="${age}" name="age" />
		<input type="hidden" value="${age}" name="old_age" />
	</div>
	<br>
	<div>
		<label>生年月日</label>
		<input type="text" value="${birthday}"
			placeholder="YYYY/MM/DD"
			type="text" name="birthday"/>
		<input type="hidden" value="${birthday}" name="old_birthday" />
	</div>
	<br>
	<div>
		<label>入社年月日</label>
		<input type="text" Value="${hireDate}" name="hireDate"
			placeholder="YYYY/MM/DD"
			type="text"/>
		<input type="hidden" value="${hireDate}" name="old_hireDate" />
	</div>
	<br>
	<div>
		<label>住所</label>
		<input type="text" value="${address}" name="address" />
		<input type="hidden" value="${address}" name="old_address" />
	</div>
	<br>
	<div>
		<label>郵便番号</label>
		<input type="text" value="${postCode}" name="postCode" />
		<input type="hidden" value="${postCode}" name="old_postCode" />
	</div>
	<br>
	<div>
		<input type="button" id="back_btn" Value="戻る">
	</div>
	<br>

	<div>
		<input type="button" id="save_btn" Value="登録">
	</div>

	<h1>${errorMsg}</h1>
</form>
</body>
</html>
