package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;

public class DaoImpl implements Dao {
	private DBConnect db;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;
	public DaoImpl(){
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		//���̵� �ߺ�Ȯ���ؾ���.
		System.out.println("��:"+conn);
		conn = db.getConnection();
		System.out.println("��:"+conn);
		String sql = "INSERT INTO member(num, name, tel, email, dept, type) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getNum());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getDept());
			pstmt.setInt(6, m.getType());
			int chk = pstmt.executeUpdate();
			if(chk==1){
				System.out.println("���ԿϷ�");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeDB();
		}

	}

	@Override
	public Member select(int num) {
		conn = db.getConnection();
		String sql = "SELECT num, name, tel, email, dept, type FROM member WHERE num=?";
		Member mb = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				mb = new Member();
				mb.setNum(rs.getInt("num"));
				mb.setName(rs.getString("name"));
				mb.setTel(rs.getString("tel"));
				mb.setEmail(rs.getString("email"));
				mb.setDept(rs.getString("dept"));
				mb.setType(rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			closeDB();
		}
		return mb;
	}
	
	public List<Member> selectALL() {
		conn = db.getConnection();
		String sql = "SELECT num, name, tel, email, dept, type FROM member";
		Member mb = null;
		List<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				mb = new Member();
				mb.setNum(rs.getInt("num"));
				mb.setName(rs.getString("name"));
				mb.setTel(rs.getString("tel"));
				mb.setEmail(rs.getString("email"));
				mb.setDept(rs.getString("dept"));
				mb.setType(rs.getInt("type"));
				
				list.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeDB();
		}
		return list;
	}

	@Override
	public void update(Member m) {
		conn = db.getConnection();
		String sql = "UPDATE member SET tel=?, email=? WHERE num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTel());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getNum());
			int chk = pstmt.executeUpdate();
			if(chk==1){
				System.out.println("�����Ϸ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeDB();
		}
	}

	@Override
	public void delete(int num) {
		conn = db.getConnection();
		String sql = "DELETE FROM member WHERE num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int chk = pstmt.executeUpdate();
			if(chk==1){
				System.out.println("��������");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeDB();
		}
		
	}
	
	public void closeDB(){
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
				System.out.println("ddddd:" +conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
