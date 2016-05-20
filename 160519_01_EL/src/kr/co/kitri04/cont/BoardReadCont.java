package kr.co.kitri04.cont;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kitri04.Model.BoardDao;
import kr.co.kitri04.Model.BoardDto;

/**
 * Servlet implementation class BoardReadCont
 */
@WebServlet("/read.do")
public class BoardReadCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Code값 호출
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String p_code = request.getParameter("p_code");
		System.out.println(p_code);
		String url = "";
		// 1. 글 목록 호출(list)
		if (p_code.equals("list")) {
			// 1. 글 목록 호출(list)
			// DB 접근하여 Database에 접체 값 받아오기
			BoardDao bd = new BoardDao();

			// 쿼리문을 통해 board table에 값을 받아오기
			// 전체 Board Table 글번호, 제목, 작성자, 작성시간,추천수, 조회수
			List<BoardDto> board_list = bd.getList();
			url = "jsp/board_list.jsp";
			// 값을 보내주기
			// 보통 변수명은 대문자로
			request.setAttribute("BL", board_list);
			move(request, response, url);

			// 해당 게시글 출력할 수 있도록 구성
			// 선택된 게시글의 b_id 불러오기
		} else if (p_code.equals("contents")) {
			String b_id = request.getParameter("b_id");
			// DB 접근해서 게시글 내용 받아오기
			BoardDto bDto = null;
			BoardDao bd = new BoardDao();
			bDto = bd.getContents(b_id);

			url = "jsp/board_view.jsp";
			request.setAttribute("BV", bDto);
			move(request, response, url);
		} else if (p_code.equals("write")) {
			// 글 작성 할 수 있는 페이지 호출
			move(request, response, "jsp/board_input.jsp");
		} else if (p_code.equals("modify")) {
			String b_id = request.getParameter("p_bid");
			// DB에 접근해서 b_id를 통한 값 받아오기
			BoardDao bDao = new BoardDao();
			BoardDto bDto = bDao.getContents(b_id);
			// DB에서 가져온 bDto 값을 수정페이지에 전달.
			request.setAttribute("BDTO", bDto);
			request.setAttribute("b_id", b_id);
			// View Page에서 수정/입력 인지 선택을 위한 값
			// request.setAttribute("MODIFY", "modify");
			move(request, response, "jsp/board_input.jsp");
			// 패스워드 체크 페이지 호출
		} else if (p_code.equals("chk_pass")) {
			move(request, response, "jsp/chk_pass.jsp");
			
			// password 불러와서 검사한다.
		} else if (p_code.equals("chk_pass_input")) {
			String pass = request.getParameter("p_chk");
			int b_id = Integer.parseInt(request.getParameter("p_bid"));
			// 체크로 받아와서 Write로 이동
			BoardDao bDao = new BoardDao();
			int chk = bDao.chkPass(pass, b_id);
			if (chk == 1) {
				move(request, response, "write.do?p_code=chk_pass_ok");
			} else {
				move(request, response, "jsp/chk_pass.jsp?state=fail");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
