package kr.co.wodud.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns = "/submit.do")
public class AdminController extends HttpServlet {
		/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: 어드민 INPUT으로부터 받은 파일들을 받을것.
		//Controller 조작값
		String adm_code = request.getParameter("adm_code");
		if(adm_code.equals("adm_login")){
			String adm_id = request.getParameter("adm_id");
			String adm_pass = request.getParameter("adm_pass");
			//내가 가지고 있는 역할 및 정보들을 다른 페이지에 전달할 수 있도록 하는것. 
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_submit.jsp");
			request.setAttribute("adm_id", adm_id);
			request.setAttribute("adm_pass", adm_pass);
//			dispatcher.forward(request, response);
			response.sendRedirect("/160513_02_WebDataTrans/jsp/admin/admin_submit.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
