<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<title>社員ログイン</title>
<link rel="stylesheet" href="css/tabulator.css">
<link href="css/tabulator_midnight.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<script type="text/javascript" src="js/tabulator.min.js"></script>
<script type="text/javascript" src="js/tabulator.js"></script>
</head>

<body>
	<script>
		$(function() {
			$("#response").html("Response Values");
			// Ajax通信テスト ボタンクリック
			$("#ajax_btn").click(function() {
				// outputDataを空に初期化
				//$("#output_data").text("");

				/*
				var url = $("url_post").val();
				var JSONdata = {
					name_input : $("#name_input").val(),
					maleFemale_input : $("#maleFemale_input").val(),
					birthDate_input : $("#birthDate_input").val(),
					joinDate_input : $("#joinDate_input").val()
				
				};
				*/

				//alert(JSON.stringify(JSONdata));

				$.ajax({
					type : "GET",
					url : "",
					dataType : "json", 
					data : JSON.stringify(JSONdata),
					scriptCharset : 'utf-8',
					success : function(data) {
						success(data);
					},

					error : function() {

						alert("AJAXの返す処理はERRORがあり by Yan");
					}
				});
			});

			/*
			$("#add_btn").click(function() {
				window.status = "処理中です。しばらくお待ちください。";
			});
			*/

			$("#login_btn").click(function() {
				
			//var url = $("url_post").val();
				var JSONdata = {
			
				};

				alert(JSON.stringify(JSONdata));

				$.ajax({
					type : 'POST',
					url : "",
					dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
					contentType : "application/json",

					data : JSON.stringify(JSONdata),
					success : function(data) {
						success(data);
					},
					error : function(e) {
						console.log(e);
						alert("AJAXの検索処理はERRORがあり");
					}
				});
			});

		});

		// Ajax通信成功時処理
		function success(data) {
			/* 			$("#emlist").empty();
			 buildHtmlTable(data,$("#emlist")); */
			$("#example-table").tabulator({
				height : "311px",
				layout : "fitColumns",
				placeholder : "No Data Set",
				columns :
				[ {
					title : "employeeNo",
					field : "employeeNo",
					sorter : "string",
					sorter : "boolean",
					cellClick : function(e, cell) {
					    var row = cell.getRow();
					    var data = row.getData();
						oneRowClick(data.employeeNo)
					}
				},{
					title : "Password",
					field : "Password",
					sorter : "string",
					align : "left"
						,
						cellClick : function(e, cell) {
						    var row = cell.getRow()
						    var data = row.getData();
							oneRowDeleteClick(data.契约ID);
						}
				} 
				/*,{
					title : "契约CD",
					field : "契约CD",
					sorter : "string",
					sorter : "boolean",
					cellClick : function(e, cell) {
					    var row = cell.getRow();
					    var data = row.getData();
						oneRowClick(data.契约ID)
					}
				
				{
					title : "单价",
					field : "单价",
					sorter : "string",
					//width : 200,
					sorter : "boolean"
				}, {
					title : "开始日期",
					field : "开始日期",
					sorter : "date",
					//width : 100,
					sorter : "boolean"
				}, {
					title : "契约期",
					field : "契约期",
					sorter : "date",
					sorter : "boolean"
				}, {
					title : "契约种别",
					field : "契约种别",
					sorter : "string",
					align : "left"
				},{
					title : "结算币种",
					field : "结算币种",
					sorter : "string",
					align : "left"
				},{
					title : "契约实际终了日",
					field : "契约实际终了日",
					sorter : "string",
					align : "left"
				},{
					title : "含交通费",
					field : "含交通费",
					sorter : "string",
					align : "left"
				},}*/
				],
				rowClick : function(e, row) {
					/* alert("Row " + row.getIndex() + " Clicked!!!!"); */

				},
			});
			$("#example-table").tabulator("setData", data);
		}/*
		function oneRowClick(selected契约ID) {
						alert(selected番号);
			 alert("oneRowClick IS RUN HERE!!");
			 
			var JSONdata = {
				契约ID : selected契约ID
			};
			 */

			$.ajax({
				type : 'POST',
				url : "", //url
				dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
				contentType : "application/json",

				data : JSON.stringify(JSONdata),
				success : function(data) {
					/* 					var obj = eval("("+data+")");
					 if(obj.success==undefined){//查询成功，跳转到详情页面 */
				if(data[0]){
					$("#employeeNo").val(data[0].employeeNo);
					$("#employeeName").val(data[0].employeeName);
					$("#sex").val(data[0].sex);
					$("#birthday").val(data[0].birthday);
					$("#age").val(data[0].age);
					$("#hireDate").val(data[0].hireDate);
					$("#lengthofSurvice").val(data[0].lengthofSurvice);
					$("#postCode").val(data[0].postCode);
					$("#address").val(data[0].address);
					$("#phoneNumber").val(data[0].phoneNumber);
					$("#authority").val(data[0].authority);
					$("#deleteFlg").val(data[0].deleteFlg);
					$("#insertDate").val(data[0].insertDate);
					$("#updateDate").val(data[0].updateDate);
					$("#theForm").attr("action",""/*url*/);
					$("#theForm").submit();

				}else if(!obj.success){//查询失败，弹出提示信息
					 alert("検索失敗 by Yan");
				}
				},
				error : function(e) {
					alert("AJAXの編集処理はERRORがあり by Yan");
				}
			});
		}
/*
		function oneRowDeleteClick(selected番号) {

			var JSONdata = {
					番号 : selected番号
			};
*/
			alert(JSON.stringify(JSONdata));

			$.ajax({
				type : 'POST',
				url : "", //url
				dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
				contentType : "application/json",

				data : JSON.stringify(JSONdata),
				success : function(data) {

					$("#theForm").attr("action",
							"");//url
					$("#theForm").submit();
				},
				error : function(e) {
					alert("AJAXの削除処理はERRORがあり by Yan");
				}
			});
		

		// Ajax通信失敗時処理
		function error(XMLHttpRequest, textStatus, errorThrown) {
			alert("error:" + XMLHttpRequest);
				alert("status:" + textStatus);
			alert("errorThrown:" + errorThrown);
		}
	</script>
	<form:form name="theForm" id="theForm" modelAttribute="employeeForm"
		method="get">
		<h1>ソフトテク株式会社</h1>
		<h2>社内管理システム</h2>
		<br>
		<div>
			<label>社員ID：</label> <input id="employeeID" name="employeeID"
				type="text" Value="">
		</div>
		<br>
		<div>
			<label>パスワード：</label> <input id="Password" name="Password"
				type="text" Value="">
		</div>
		<div>
			<input type="button" id="login_btn" Value="ログイン">
		</div>
	</form:form>
</body>

</html>