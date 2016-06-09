package rep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;

public class DaoImple implements Dao {

	private DBConnect db;
	private Connection conn;
	
	public DaoImple(){
		db = new DBConnect();
		this.conn = db.getCon();
	}
	
	@Override
	public int insert(Reply r) {
		PreparedStatement pstmt = null;
		int resultFlag = 0;
		int num=0;
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("insert into rep values(?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			num = makeNum();
			pstmt.setInt(1, num);
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getContent());
			resultFlag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!= null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			db.closeDB();
		}
		
		return num;
	}

	@Override
	public Reply select(int num) {
		PreparedStatement pstmt = null;
		Reply r = null;
		ResultSet rs = null;
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select * from rep where num=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				r = new Reply();
				r.setNum(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setContent(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!= null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			db.closeDB();
		}
		
		return r;
	}

	@Override
	public List<Reply> selectAll() {
		
		List<Reply> list = new ArrayList<Reply>();
		Statement stmt = null;
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		try {
			sql.append("select num, name, content from rep order by num desc");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			
			while(rs.next()){
				Reply rep = new Reply();
				rep.setNum(rs.getInt(1));
				rep.setName(rs.getString(2));
				rep.setContent(rs.getString(3));
				list.add(rep);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public int update(Reply r) {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		int resultFlag = 0;
		try {
			sql.append("update rep set name=?,content=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getContent());
			resultFlag = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
			
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultFlag;
	}

	@Override
	public int delete(int num) {
		return 0;
	}

	@Override
	public int makeNum() {
		int num = 0;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder("select seq_rep.nextval from dual");
		conn = db.getCon();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1);
			}
		}catch(SQLException e){
			return 0;
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return num;
	}

}
