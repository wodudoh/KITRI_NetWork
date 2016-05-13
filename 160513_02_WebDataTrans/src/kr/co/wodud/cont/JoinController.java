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
		
		request.setAttribute("userId", userId);
		request.setAttribute("userPw", userPw);
		request.setAttribute("userName", userName);
		request.setAttribute("userPhoneNumber", userPhoneNumber);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("userZipcode", userZipcode);
		request.setAttribute("userAddress", userAddress);
		
		RequestDispatcher dis = request.getRequestDispatcher("/jsp/join_result.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
