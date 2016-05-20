package kr.co.wodud.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.wodud.dao.EmpDao;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주 로그인 커트롤러
		System.out.println("컨트롤러 호출");
		String key = null;
		System.out.println(request.getParameter("p_code"));
		HttpSession hs = request.getSession();

		// 로그인이 안되있는 상태 였을 때 처리 방법
		if (request.getParameter("p_code") == null) {
			key = "def";
		} else {
			//login form에서 로그인 버튼 눌렀을시 처리
			key = request.getParameter("p_code");
		}
		
		if (key.equals("def")) {
			// 로그인 화면 출력해주기
			String url = "login_form.jsp";
			move(request, response, url);
		} else if (key.equals("login_chk")) {
			// 로그인 체크하기
			// login_form에서 부터 p_empno, p_name 값 가져오기
			String empno = request.getParameter("p_empno");
			String ename = request.getParameter("p_ename");

			// DB 와 비교할 수 있도록 구성
			EmpDao ed = new EmpDao();
			int chk_id = ed.chk_id(empno, ename);
			if (chk_id == 1) {
				// 로그인 성공 페이지 출력
				// Session 값을 두고 empno 를 세션에 삽입
				hs.setAttribute("empno", empno);
				hs.setAttribute("ename", ename);
				hs.setAttribute("code", "login_chk");
				
	 			move(request, response, "login_ok.jsp");
			} else if (chk_id == 0) {
				move(request, response, "login_form.jsp");
			}
		} else if (key.equals("log_out")) {
			System.out.println("로그아웃 호출 되었다!!!!!");
			// 로그아웃 처리
			// 세션 삭제 종료
			hs.invalidate();
			move(request, response, "login_form.jsp");
		}
		// 로그인이 되었을 시에 처리 방법
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * forward를 위한 메소드
	 * 
	 * @param request
	 * @param response
	 * @param url
	 */
	private void move(HttpServletRequest request, HttpServletResponse response, String url) {
		RequestDispatcher dis = request.getRequestDispatcher(url);
		try {
			dis.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
