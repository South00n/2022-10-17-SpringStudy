<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 800px;
}
h1 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>��� ���</h1>
		<div class="row">
			<table class="table">
				<tr class="success">
					<th class="text-cneter">���</th>
					<th class="text-cneter">�̸�</th>
					<th class="text-cneter">����</th>
					<th class="text-cneter">�Ի���</th>
					<th class="text-cneter">�޿�</th>
				</tr>
				<c:forEach var="vo" items="${list }">
				<tr>
					<td class="text-cneter">${vo.empno }</td>
					<td class="text-cneter">${vo.ename }</td>
					<td class="text-cneter">${vo.job }</td>
					<td class="text-cneter">${vo.dbday }</td>
					<td class="text-cneter">${vo.sal }</td>
				</tr>
				
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>