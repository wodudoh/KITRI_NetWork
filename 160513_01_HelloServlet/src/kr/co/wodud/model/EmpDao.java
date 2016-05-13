package kr.co.wodud.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.arpark.domain.EmpBean;

/** DB 접속 관련된 모든 자료값
 * @author Administrator
 *
 */
public class EmpDao {
	
	// Database 연결 및 Emptable 자료 가져오기
	public List<EmpBean> getEmpAll(){
		//Driver load
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<EmpBean> list = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracl:thin:@127.0.0.1:1521:XE","hr","hr");
			String sql = "select Employee_id, First_name, Manager_id, Job_id, Hire_date, Salary, Commission_pct, Department_id from employees";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//result set 에 있는 값.
			//ResultSet 객체를 Java에서 사용하는
			//empBean 객체에 복사
			list=new ArrayList<EmpBean>();
			while(rs.next()){
				EmpBean eb = new EmpBean();
				eb.setEmpno(rs.getInt("Employee_id"));
				eb.setEname(rs.getString("First_name"));
				eb.setMgr(rs.getInt("Manager_id"));
				eb.setJob(rs.getString("Job_id"));
				eb.setHiredate(rs.getString("Hire_date"));
				eb.setSal(rs.getInt("Salary"));
				double comm= rs.getDouble("Commission_pct")*100;
				eb.setComm((int)comm);
				eb.setDeptno(rs.getInt("Department_id"));
				list.add(eb);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null){
				
			try{
				rs.close();
			}catch(SQLException e){
				
				}
			}
			if(stmt!=null){
				
			try{
				stmt.close();
			}catch(SQLException e){
				
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
					
				}
			
			}
		}
		
		return list;
	}

}
