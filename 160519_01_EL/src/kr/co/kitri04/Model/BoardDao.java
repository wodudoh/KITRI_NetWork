package kr.co.kitri04.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BoardDao {
	SetupDB sdb = new SetupDB();

	public List<BoardDto> getList() {
		// DB값에서 게시글 목록 불러오기
		// private int board_id ;
		// private String title;
		// private String writer;
		// private String wdate;
		// private int read_cnt;
		// private int con_like;

		List<BoardDto> boardList = new ArrayList<BoardDto>();
		try {
			StringBuilder sql = new StringBuilder();
			ResultSet rs;
			sql.append("select BOARD_ID, TITLE, CONTENTS, WRITER, PASSWORD, READ_CNT, to_char(WDATE,'yy-mm-dd'), CONT_LIKE, USE_YN from kitri_board");
			sql.append(" ORDER BY BOARD_ID DESC");
			rs = sdb.select(sql);
			while (rs.next()) {
				BoardDto bd = new BoardDto();
				bd.setBoard_id(rs.getInt(1));
				bd.setTitle(rs.getString(2));
				bd.setContents(rs.getString(3));
				bd.setWriter(rs.getString(4));
				bd.setPassword(rs.getString(5));
				bd.setRead_cnt(rs.getInt(6));
				bd.setWdate(rs.getString(7));
				bd.setCon_like(rs.getInt(8));
				bd.setUse_yn(rs.getString(9));
				boardList.add(bd);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sdb.closeDB();
		}

		return boardList;
	}
	/**
	 *  DB 에 접속해서 BOARD_ID, TITLE, CONTENTS, WRITER, READ_CNT, to_char(WDATE, 'yy-mm-dd'), PDS_LINK, CONT_LIKE, CONT_UNLIKE 값을 가져온다.
	 * @param b_id
	 * @return BoardDto
	 */
	public BoardDto getContents(String b_id) {
		// TODO Auto-generated method stub
		
		SetupDB sb = new SetupDB();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BOARD_ID, TITLE, CONTENTS, WRITER, READ_CNT, to_char(WDATE, 'yy-mm-dd'), PDS_LINK, CONT_LIKE, CONT_UNLIKE, PASSWORD FROM KITRI_BOARD");
		sql.append(" WHERE board_id='");
		sql.append(b_id);
		sql.append("'");
		ResultSet rs= sb.select(sql);
		BoardDto bDto = new BoardDto();
		try{
			if(rs.next()){
				bDto.setBoard_id(rs.getInt(1));
				bDto.setTitle(rs.getString(2));
				bDto.setContents(rs.getString(3));
				bDto.setWriter(rs.getString(4));
				bDto.setRead_cnt(rs.getInt(5));
				bDto.setWdate(rs.getString(6));
				bDto.setPds_link(rs.getString(7));
				bDto.setCon_like(rs.getInt(8));
				bDto.setCon_unlike(rs.getInt(9));
				bDto.setPassword(rs.getString(10));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			sdb.closeDB();
		}

		return bDto;
		
	}

	public int writeContents(BoardDto bDto) {

		// Insert 문을 통해 bDto 값 Database에 작성
//		bDto.setTitle(request.getParameter("title"));
//		bDto.setWriter(request.getParameter("writer"));
//		bDto.setPassword(request.getParameter("password"));
//		bDto.setPds_link(request.getParameter("pds_link"));
//		bDto.setContents(request.getParameter("contents"));
		
		StringBuilder sql = new StringBuilder("INSERT INTO KITRI_BOARD (BOARD_ID, TITLE, CONTENTS, WRITER, PASSWORD, WDATE, PDS_LINK, REPLY_LEVEL) VALUES (SEQ_KITRI_BOARD_BOARD_ID.nextval, ?, ?,?,?,sysdate,?,0)");
		SetupDB sdb = new SetupDB();
		PreparedStatement pstmt = sdb.pstmt;
		int chk=0;
		try {
			pstmt = sdb.getCon().prepareStatement(sql.toString());
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContents());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setString(4, bDto.getPassword());
			pstmt.setString(5, bDto.getPds_link());
			chk=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sdb.closeDB();
		}
		return chk;
	}
	public int modifyContents(BoardDto bDto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE KITRI_BOARD SET TITLE=?, CONTENTS= ?, WRITER=?, Password=?, Pds_link=?");
		sql.append(" Where board_id=?");
		SetupDB sdb = new SetupDB();
		PreparedStatement pstmt = sdb.pstmt;
		int chk=0;
		try {
			pstmt = sdb.getCon().prepareStatement(sql.toString());
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContents());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setString(4, bDto.getPassword());
			pstmt.setString(5, bDto.getPds_link());
			pstmt.setString(6, Integer.toString(bDto.getBoard_id()));
			chk=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sdb.closeDB();
		}
		return chk;
	}
	/**
	 * DB에 게시글이 지워졌음을 USE_YN 상태를 N으로 변경 해주는 메소드
	 * @param b_id
	 * @return 변경 완료 되면 1 안되면 0
	 */
	public int deleteContents(String b_id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE KITRI_BOARD SET USE_YN='N'");
		sql.append(" Where board_id="+b_id);
		SetupDB sdb = new SetupDB();
//		PreparedStatement pstmt = sdb.pstmt;
		int chk=0;
		try {
			chk =sdb.update(sql);
		}finally{
			sdb.closeDB();
		}
		return chk;
	}
	/**
	 * 게시글 수정을 위해 DB와 비밀번호를 체크하는 메소드
	 * @param pass
	 * @param b_id
	 * @return int 타입으로 1이면 패스워드 맞음 0이면 패스워드 맞음.
	 */
	public int chkPass(String pass, int b_id) {
		
		StringBuilder sql = new StringBuilder("select count(*) from kitri_board");
		sql.append(" WHERE board_id=? and password=?");
		PreparedStatement pstmt = sdb.pstmt;
		ResultSet rs=null;
		int chk=0;
		try{
			pstmt = sdb.getCon().prepareStatement(sql.toString());
			pstmt.setInt(1, b_id);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			//검색된 resultset 여부에 따라 chk 값 리턴
			rs.next();
			chk=rs.getInt(1);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return chk;
	}
	
	

}
