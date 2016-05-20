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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Code값 호출
		System.out.println("컨트롤러에 들어왔다.");
		String p_code = request.getParameter("p_code");
		System.out.println(p_code);
		String url = "";
		// 1. 글 목록 호출(list)
		if(p_code.equals("list")){
			//1. 글 목록 호출(list)
			// DB 접근하여 Database에 접체 값 받아오기
			BoardDao bd = new BoardDao();
			
			//쿼리문을 통해 board table에 값을 받아오기
			//전체 Board Table 글번호, 제목, 작성자, 작성시간,추천수, 조회수
			List<BoardDto> board_list = bd.getList();
			url="jsp/board_list.jsp";
			//값을 보내주기
			//보통 변수명은 대문자로 
			request.setAttribute("BL", board_list);
			move(request, response, url);
		
		//해당 게시글 출력할 수 있도록 구성
		// 선택된 게시글의 b_id 불러오기
		}else if(p_code.equals("contents")){
			String b_id = request.getParameter("b_id");
			// DB 접근해서 게시글 내용 받아오기
			BoardDto bDto = null;
			BoardDao bd = new BoardDao();
			bDto = bd.getContents(b_id);
			
			url="jsp/board_view.jsp";
			request.setAttribute("BV", bDto);
			move(request, response, url);
		}else if(p_code.equals("write")){
			System.out.println("write 실행되었습니다.");
			//글 작성 할 수 있는 페이지 호출
			move(request, response, "jsp/board_input.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void move(HttpServletRequest req, HttpServletResponse resp, String url){
		RequestDispatcher rd = req.getRequestDispatcher(url);
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
