<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	document.modForm.submit();
</script>

<meta charset="UTF-8">
<title>Modify Employee</title>
</head>
<body>

	<form action="emp.do" method="post" name="modForm">
		<table>
			<tr>
				<td>사원 번호</td>
				<td><input type="text" name="p_empno" value="${eb.employee_id}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>사원 성</td>
				<td><input type="text" name="p_fname" value="${eb.first_name}" /></td>
			</tr>
			<tr>
				<td>사원 이름</td>
				<td><input type="text" name="p_lname" value="${eb.last_name}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="p_email" value="${eb.email}" /></td>
			</tr>
			<tr>
				<td>Job ID</td>
				<td><input type="text" name="p_jobid" value="${eb.job_id}" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="p_pnum" value="${eb.phone_number}" /></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="text" name="p_hiredate" value="${eb.hire_date}" /></td>
			</tr>
			<tr>
				<td>급여</td>
				<td><input type="text" name="p_salary" value="${eb.salary}" /></td>
			</tr>
			<tr>
				<td>상여금(%)</td>
				<td><input type="text" name="p_compct" value="${eb.commission_pct}%" /></td>
			</tr>
			<tr>
				<td>매니저 ID</td>
				<td><input type="text" name="p_mgr" value="${eb.manager_id}" /></td>
			</tr>
			<tr>
				<td><input type="button" value="수정" onclick="mod_ok()" /></td>
			</tr>
		</table>
		
		<input type="hidden" value="emp_update" name="p_code">
			
	</form>

</body>
</html>