package kr.co.kitri04.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kitri04.Model.BoardDao;
import kr.co.kitri04.Model.BoardDto;

/**
 * Servlet implementation class BoardWriteCont
 */
@WebServlet("/write.do")
public class BoardWriteCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB 에 실제 값을 입력할 수 있는 기능의 컨트롤러
		// DML 문 실행 시 접근할 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String p_code = request.getParameter("p_code");
		if (p_code.equals("write_ok")) {
			// board_input.jsp 에서 받아 올 파라미터 값을 세팅
			// Dao 실행
			BoardDto bDto = new BoardDto();
			bDto.setTitle(request.getParameter("title"));
			bDto.setWriter(request.getParameter("writer"));
			bDto.setPassword(request.getParameter("password"));
			bDto.setPds_link(request.getParameter("pds_link"));
			bDto.setContents(request.getParameter("contents"));

			// bDto를 DAO에 전달한 후 DB 전송

			BoardDao bd = new BoardDao();
			int chk = bd.writeContents(bDto);
			// 글 목록으로 갈수 있도록
			if (chk == 1) {
				move(request, response, "read.do?p_code=list");
			} else {

			}
		} else if (p_code.equals("modify_ok")) {
			// 수정 작업 완료 시키기
			BoardDto bDto = new BoardDto();
			System.out.println(request.getParameter("b_id"));
			bDto.setBoard_id(Integer.parseInt(request.getParameter("b_id")));
			bDto.setTitle(request.getParameter("title"));
			bDto.setWriter(request.getParameter("writer"));
			bDto.setPassword(request.getParameter("password"));
			bDto.setPds_link(request.getParameter("pds_link"));
			bDto.setContents(request.getParameter("contents"));
			BoardDao bd = new BoardDao();
			int chk = bd.modifyContents(bDto);
			if (chk == 1) {
				move(request, response, "read.do?p_code=list");
			} else {

			}
		}else if(p_code.equals("chk_pass_ok")){
			// 삭제는 update 문으로 DB 접속
			// p_bid
			String b_id = request.getParameter("p_bid");
			BoardDao bDao = new BoardDao();
			int chk =  bDao.deleteContents(b_id);
			if (chk == 1) {
				move(request, response, "read.do?p_code=list");
			} else {

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void move(HttpServletRequest req, HttpServletResponse resp, String url) {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
