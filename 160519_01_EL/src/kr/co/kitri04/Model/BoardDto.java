package kr.co.kitri04.Model;

/**
 * board DTO BOARD_ID TITLE CONTENTS WRITER PASSWORD WDATE READ_CNT PDS_LINK
 * CON_LIKE CON_UNLIKE REPLY_LELVEL REF_ID 
 * 
 * @author Administrator
 *
 */
public class BoardDto {

	private int board_id ;
	private String title;
	private  String contents;
	private String writer;
	private String password;
	private String wdate;
	private int read_cnt;
	private String pds_link;
	private int con_like;
	private int con_unlike;
	private int reply_lelvel;
	private int ref_id;
	private String use_yn;

	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}
	public String getPds_link() {
		return pds_link;
	}
	public void setPds_link(String pds_link) {
		this.pds_link = pds_link;
	}
	public int getCon_like() {
		return con_like;
	}
	public void setCon_like(int con_like) {
		this.con_like = con_like;
	}
	public int getCon_unlike() {
		return con_unlike;
	}
	public void setCon_unlike(int con_unlike) {
		this.con_unlike = con_unlike;
	}
	public int getReply_lelvel() {
		return reply_lelvel;
	}
	public void setReply_lelvel(int reply_lelvel) {
		this.reply_lelvel = reply_lelvel;
	}
	public int getRef_id() {
		return ref_id;
	}
	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
}
