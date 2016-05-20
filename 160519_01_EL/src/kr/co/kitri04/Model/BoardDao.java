package kr.co.kitri04.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 보드관련한
 * 
 * @author Administrator
 *
 */
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
			sql.append("select BOARD_ID, TITLE, CONTENTS, WRITER, PASSWORD, READ_CNT, to_char(WDATE,'yy-mm-dd'), CONT_LIKE from kitri_board");
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

	public BoardDto getContents(String b_id) {
		// TODO Auto-generated method stub
		
		SetupDB sb = new SetupDB();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BOARD_ID, TITLE, CONTENTS, WRITER, READ_CNT, to_char(WDATE, 'yy-mm-dd'), PDS_LINK, CONT_LIKE, CONT_UNLIKE FROM KITRI_BOARD");
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
	
	

}
