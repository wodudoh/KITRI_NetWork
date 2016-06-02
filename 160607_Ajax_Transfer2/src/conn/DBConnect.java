package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DBConnect {
	
	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private DBConnect() {

	}

	public static DBConnect getInstance() {
		return db;
	}
	public Connection getConnection(){
		try {
			Class.forName(jdbc_driver);
			Calendar time = Calendar.getInstance();
			Calendar date = Calendar.getInstance();
			date.add(Calendar.DATE, 1);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			StringBuilder sb = new StringBuilder();
			sb.append(format1.format(date.getTime()));
			sb.append(" "+time.get(Calendar.HOUR));
			sb.append(":" + time.get(Calendar.MINUTE));
			sb.append(":" + time.get(Calendar.SECOND));
			
			System.out.println(sb.toString()+" 현재 Connection 상태"+conn);
			conn = DriverManager.getConnection(jdbc_url, "kitri04", "kitri04");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
