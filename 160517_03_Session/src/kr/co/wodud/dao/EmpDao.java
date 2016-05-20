package kr.co.wodud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.wodud.Model.EmpDto;

/**
 * Emp 자료 접근용 Data Access Object
 * 
 * @author Administrator
 *
 */
public class EmpDao {

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// DB ID 값 비교하여 접근하기
	public int chk_id(String empno, String ename) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM employees");
		sql.append(" WHERE");
		sql.append(" 1=1");
		sql.append(" AND first_name='");
		sql.append(ename + "'");
		sql.append(" AND employee_id=");
		sql.append(empno);
		System.out.println(sql.toString());
		
		rs = select(sql);
		int login_chk = 0;

		try {
			if (rs.next()) {
				login_chk = rs.getInt(1);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login_chk;
	}

	// Connection 생성 메소드
	private Connection getCon() {
		// driver 호출
		// Connection con = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("core.log.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// Statment 생성 1.RS, 2.RS(X)
	private ResultSet select(StringBuilder sql) {
		// ResultSet rs=null;

		// Statement stmt = null;
		try {
			stmt = getCon().createStatement();
			rs = stmt.executeQuery(sql.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	private void closeDB() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public EmpDto getEmp(String empno) {
		StringBuilder sql = new StringBuilder();
		sql.append("select employee_id, First_name, Last_name, Email, Phone_number,hire_date, job_id, salary, commission_pct*100, manager_id from employees");
		sql.append(" where employee_id = ?");
		EmpDto ed = new EmpDto();
		try {
			pstmt = getCon().prepareStatement(sql.toString());
			pstmt.setInt(1,  Integer.parseInt(empno));
			rs =pstmt.executeQuery();
			
			if(rs.next()){
				ed.setEmployee_id(rs.getInt(1));
				ed.setFirst_name(rs.getString(2));
				ed.setLast_name(rs.getString(3));
				ed.setEmail(rs.getString(4));
				ed.setPhone_number(rs.getString(5));
				ed.setHire_date(rs.getString(6));
				ed.setJob_id(rs.getString(7));
				ed.setSalary(rs.getInt(8));
				ed.setCommission_pct(rs.getInt(9));
				ed.setManager_id(rs.getInt(10));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return ed;
	}

	public int modEmp(EmpDto ed) {
		// preparedStatement update문 실행
		
		String sql ="update employees set employee_id, first_name=?, last_name=?, email=?,phone_number=?,To_CHAR(hire_date,'YYYY-MM-DD')=?,job_id=?, salary=?,commission_pct=?,manager_id=? where employee_id=?";
		int cnt =0;
		try {
			pstmt = getCon().prepareStatement(sql);
			pstmt.setString(1, ed.getFirst_name());
			pstmt.setString(2, ed.getLast_name());
			pstmt.setString(3, ed.getEmail());
			pstmt.setString(4, ed.getPhone_number());
			pstmt.setString(5, ed.getHire_date());
			pstmt.setString(6, ed.getJob_id());
			pstmt.setInt(7, ed.getSalary());
			pstmt.setDouble(8, (double)ed.getCommission_pct()/100);
			pstmt.setInt(9, ed.getManager_id());
			pstmt.setInt(10, ed.getEmployee_id());
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		
		
		
		return cnt;
	}

}
