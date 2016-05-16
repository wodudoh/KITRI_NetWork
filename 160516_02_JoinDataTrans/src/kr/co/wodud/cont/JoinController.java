package kr.co.wodud.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/Join.do")
public class JoinController extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userPhoneNumber = request.getParameter("userPhoneNumber");
		String userEmail = request.getParameter("userEmail1")+ "@" + request.getParameter("userEmail2");
		String userZipcode = request.getParameter("userZipcode1")+"-"+request.getParameter("userZipcode2");
		String userAddress = request.getParameter("userAddress");
		String joinCheck = request.getParameter("joinCheck");
		
		System.out.println("joinCheck : " + joinCheck);
		
		
//		RequestDispatcher dis = request.getRequestDispatcher("/jsp/join_result.jsp");
//		dis.forward(request, response);
		
//		joinCheck 값이 success 면 join_result에 결과를 보여준다.
//		false 면 checked를 수행한다. 
//		null 이면 404 에러를 강제로 출력해준다. 
		if(joinCheck!=null){
			
			if(joinCheck.equals("success")){
				request.setAttribute("userId", userId);
				RequestDispatcher dis = request.getRequestDispatcher("/jsp/join_result.jsp");
				dis.forward(request, response);
				
			}else if(joinCheck.equals("fail")){
				request.setAttribute("userId", userId);
				request.setAttribute("userPw", userPw);
				request.setAttribute("userName", userName);
				request.setAttribute("userPhoneNumber", userPhoneNumber);
				request.setAttribute("userEmail", userEmail);
				request.setAttribute("userZipcode", userZipcode);
				request.setAttribute("userAddress", userAddress);
								
				RequestDispatcher dis = request.getRequestDispatcher("/jsp/join_Check.jsp");
				dis.forward(request, response);
			}
			
		}else{
			response.sendError(404, "잘못된 접근입니다.");
		}
		
		// JoinController->JoinCheck->JoinController->join_result.jsp로 돌아오도록 하자.
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
