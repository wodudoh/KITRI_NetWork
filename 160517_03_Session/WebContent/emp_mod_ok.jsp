<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
function redirect(a) {
	alert(a+"���� �ڷᰡ �����Ǿ����ϴ�.");
	location.href = "login.do?p_code=login_chk";
	
}
</script>
<title>Emp Modify Check Page</title>
</head>
<body onload="redirect('${cnt}')">

</body>
</html>