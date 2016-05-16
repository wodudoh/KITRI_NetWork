import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin.do")
public class AdminController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("adminController 실행중");
		String m_code = (String)request.getAttribute("m_code");
		if(m_code==null){
			m_code=request.getParameter("m_code");
		}
		String adm_id = (String) request.getAttribute("adm_id");
		String adm_pass = (String) request.getAttribute("adm_pass");
		
		
		
		if(m_code.equals("adm_login")){
			if(!(adm_id.equals("admin"))){
				response.sendRedirect(request.getContextPath()+"/jsp/admin/admin_login_check.jsp?adm_id="+adm_id+"&adm_pass="+adm_pass);
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_login_check.jsp");
				request.setAttribute("adm_id", adm_id);
				request.setAttribute("adm_pass", adm_pass);
				dispatcher.forward(request, response);
				}
		}else if(m_code.equals("adm_login_ok")){
			System.out.println("로그인 성공 Controller");
			RequestDispatcher dis = request.getRequestDispatcher("jsp/admin/admin_submit.jsp");
			request.setAttribute("adm_id", request.getParameter("adm_id"));
			request.setAttribute("adm_pass", request.getParameter("adm_pass"));
			dis.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
