package kr.co.wodud.cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.arpark.domain.EmpBean;
import kr.co.wodud.model.EmpDao;

@WebServlet(urlPatterns="/subcont.do")
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 2308085568609759220L;
	
	@Override
	public void init() throws ServletException {
		// 서블릿 초기화 메소드(시작할 때 1번만 구동)
		System.out.println("서블릿 1회 실행");
		super.init();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Client 가 요청했을 때 구동되는 메소드
		//누가 접근하는가?
		System.out.println(req.getRemoteHost() + "접근");
		System.out.println("Service 실행");
		PrintWriter out = resp.getWriter();
		EmpDao ed = new EmpDao();
		List<EmpBean> al = ed.getEmpAll();
		out.print("<html><head></head><body>"+ req.getRemoteHost());
		for(EmpBean i:al){
			out.print("<br>"+i);
		}
		out.print("</body></html>");
		
	}
	@Override
	public void destroy() {
		//Servlet 종료 시에 한번 구동
		//Was 가 종료될 시 메모리에서 해제됨.
		System.out.println("Servlet 종료");
		
		super.destroy();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
