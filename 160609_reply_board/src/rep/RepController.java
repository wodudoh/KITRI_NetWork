package rep;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RepController
 */
@WebServlet("/RepController")
public class RepController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		
		rq.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		Service service = new ServiceImple();
		
		//결과페이지 주소 담는곳
		String result = "";
		ArrayList<Reply> list = null;
		
		String code = rq.getParameter("code");
		
		if(code.equals("addReply")){
			Reply r = new Reply();
			r.setName(rq.getParameter("name"));
			r.setContent(rq.getParameter("content"));
			int resultFlag = service.addRep(r);
			if (resultFlag ==1){
				r = service.getRep(resultFlag);
				rq.setAttribute("r", r);
			}
			result = "rep/getRep.jsp";
			
		} else if(code.equals("deleteReply")){
			
			
		} else if(code.equals("updateReply")){
			
			
		} else if(code.equals("getReply")){
			
		} else if(code.equals("getList")){
			list = (ArrayList<Reply>) service.getAll();
			rq.setAttribute("list", list);
			result = "rep/list.jsp";
			moveFoward(rq, res, result);
		}
			
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		doGet(rq, res);
	}
	
	private void moveFoward(HttpServletRequest rq, HttpServletResponse res, String url) throws ServletException{
		
		RequestDispatcher rd = rq.getRequestDispatcher(url);
		
		try {
			rd.forward(rq, res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
