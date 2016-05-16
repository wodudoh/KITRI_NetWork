

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = "/cont.do")
public class MainController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Code 값에 따라 서브 컨트롤러가 실행 될 수 있도록 구성
		//main 컨트롤러 가 있고 서브 컨트롤러를 불러 올수 있도록 하는 구조.
	
		String m_code = null;
		String adm_id = null;
		String adm_pass = null;
		if(request.getParameter("m_code").equals("")){
			m_code = "index";
		}else{
			m_code = request.getParameter("m_code");
			adm_id=request.getParameter("adm_id");
			adm_pass=request.getParameter("adm_pass");
		}
		
		//Controller 분배하여 세팅하기
		System.out.println("MainController 실행");
		if(m_code.equals("adm_login")){
//			response.sendRedirect(request.getContextPath() + "/admin.do");
			RequestDispatcher dis = request.getRequestDispatcher("/admin.do");
			request.setAttribute("m_code", m_code);
			request.setAttribute("adm_id", adm_id);
			request.setAttribute("adm_pass", adm_pass);
			dis.forward(request, response);
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
