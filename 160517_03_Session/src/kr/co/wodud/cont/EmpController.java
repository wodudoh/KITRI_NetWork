package kr.co.wodud.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.wodud.Model.EmpDto;
import kr.co.wodud.dao.EmpDao;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/emp.do")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. Session - > empno
		HttpSession hs = request.getSession();
		
		if(hs.getAttribute("empno") == null){
			//세션에 empno가 없으면
			//로그인 할 수 있는 페이지로 전달
			response.sendRedirect("login.do");
		}else{
			
			String code = "def";
			if(request.getParameter("p_code")!=null){
				code = request.getParameter("p_code");
				System.out.println("p코드에 대입");
				System.out.println("code : "+code);
			}
			//세션값이 존재함
			//code값에 따라 controller실행될 수 있도록 수성
			System.out.println(code);
			if(code.equals("def")){
				System.out.println("modify_emp_jsp 탈예정");
				//회원정보 수정 할 수 있도록 함
				String empno = hs.getAttribute("empno").toString();
				//empno 값을 통해 해야할것!
				// DB접속해서 update 할 수 있도록 구성
				EmpDao ed = new EmpDao();
				//Empno 사원의 자료값을 받아올 수 있게끔 구성
				EmpDto eb = new EmpDto();
				eb = ed.getEmp(empno);
				//eb -> JSP 에 전달
				request.setAttribute("eb", eb);
				RequestDispatcher rd= request.getRequestDispatcher("modify_emp.jsp");
				rd.forward(request, response);
			
			}else if(code.equals("emp_update")){
			
			EmpDto eb = new EmpDto();
			eb.setFirst_name(request.getParameter("p_fname"));
			eb.setLast_name(request.getParameter("p_lname"));
			eb.setPhone_number(request.getParameter("p_num"));
			eb.setEmail(request.getParameter("p_email"));
			eb.setHire_date(request.getParameter(""));
			eb.setSalary(Integer.parseInt(request.getParameter("p_sal")));
			eb.setCommission_pct(Integer.parseInt(request.getParameter("p_comm")));
			eb.setManager_id(Integer.parseInt(request.getParameter("p_mgr")));
			//변경된 ed값 세팅
			//dao => update문
			EmpDao edao = new EmpDao();
			int cnt = edao.modEmp(eb);
			//몇건의 데이터가 수정되었습니다.
			request.setAttribute("cnt", cnt);
			RequestDispatcher dis = request.getRequestDispatcher("emp_mod_ok.jsp");
			dis.forward(request, response);
			
			}
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
