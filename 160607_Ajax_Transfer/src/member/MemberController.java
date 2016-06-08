package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ServiceImpl();
		String type="";
		RequestDispatcher rd = null;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("type")!=null){
			type = request.getParameter("type");
		}
		if(type.equals("join")){
			//ȸ�����Խ�
			Member m = new Member();
			m.setNum(Integer.parseInt(request.getParameter("num")));
			m.setName(request.getParameter("name"));
			m.setTel(request.getParameter("tel"));
			m.setEmail(request.getParameter("email"));
			m.setDept(request.getParameter("dept"));
			m.setType(Integer.parseInt(request.getParameterValues("ty")[0]));
			service.addMember(m);
			String url = "member/loginForm.jsp";
			response.sendRedirect(url);
		}
		else if(type.equals("login")){
			int num = Integer.parseInt(request.getParameter("num"));
			String name = request.getParameter("name");
			boolean chk = service.login(num, name);
			if(chk){
				HttpSession loginSession=request.getSession();
				loginSession.setAttribute("num", num);
				String url = "member/main.jsp";
				move(request, response, url);
			}else{
				response.sendError(500);
			}

		}
		else if(type.equals("editInfo")){
			//ȸ����������
			Member m = new Member();
			int num = Integer.parseInt(request.getParameter("num"));
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			m.setNum(num);
			m.setEmail(email);
			m.setTel(tel);
			service.editInfo(m);
			request.setAttribute("num", num);
			String url = "member/main.jsp";
			move(request, response, url);
		}
		else if(type.equals("logout")){
			System.out.println("logout");
			HttpSession loginSession = request.getSession();
			loginSession.invalidate();
			response.sendRedirect("member/loginForm.jsp");
			
		}
		else if(type.equals("delete")){
			//ȸ��������
			int num = Integer.parseInt(request.getParameter("num"));
			service.delMember(num);
		}
		else if(type.equals("join_ok")){
			String url = "member/join.jsp";
			move(request, response, url);
		}
		else if(type.equals("edit")){
			HttpSession loginSession = request.getSession();
			int login =  (Integer)loginSession.getAttribute("num");
			System.out.println(login);
			Member m = service.getMember(login);
			request.setAttribute("Member", m);
			String url = "member/editInfo.jsp";
			move(request, response, url);
		}
		else if ( type.equals("checkId")){
			int num = 0; 
			num = Integer.parseInt(request.getParameter("num"));
			PrintWriter out = response.getWriter();
			if(num == 0){
				response.sendError(500);
			}else{
				Member m = service.getMember(num);
				if(m != null){
					out.print(false);
				}else{
					out.print(true);
				}
//				move(request, response, "member/check.jsp");
			}
		}else if(type.equals("MemberXMLAll")){
			List<Member>list = service.getMemberAll();
			
			System.out.println(list.toString());
			request.setAttribute("list", list);
			String url = "member/AllSearch.jsp";
			move(request, response, url);
		}else if(type.equals("MemberJSONAll")){
			List<Member>list = service.getMemberAll();
			
			System.out.println(list.toString());
			request.setAttribute("list", list);
			String url = "member/AllSearchJSON.jsp";
			move(request, response, url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void move(HttpServletRequest request, HttpServletResponse response, String url){
		RequestDispatcher rd = request.getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
