package kr.co.kitri04.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Emp 자료 접근용 Data Access Object
 * 
 * @author Administrator
 *
 */
public class SetupDB {

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public PreparedStatement pstmt = null;

	// Connection 생성 메소드
	public Connection getCon() {
		// driver 호출
		// Connection con = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("core.log.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kitri04", "kitri04");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// Statment 생성 1.RS, 2.RS(X)
	public ResultSet select(StringBuilder string) {
		// ResultSet rs=null;

		// Statement stmt = null;
		try {
			stmt = getCon().createStatement();
			rs = stmt.executeQuery(string.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int update(StringBuilder string){
		int chk=0;
		try{
			
			stmt = getCon().createStatement();
			chk = stmt.executeUpdate(string.toString());
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return chk;
		
	}

	public void closeDB() {
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
				System.out.println("pstmt close 완료했음!!!!!!!!!!");
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


}
