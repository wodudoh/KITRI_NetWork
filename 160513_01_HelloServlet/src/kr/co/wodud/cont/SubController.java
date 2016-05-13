package kr.co.wodud.cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/now")
public class SubController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		Date now = new Date();
		PrintWriter writter = resp.getWriter();
		writter.println("<html>");
		writter.println("<head>");
		writter.println("<title> 현재시간</title>");
		writter.println("</head>");
		writter.println("<body>");
		writter.println(now.toString());
		writter.println("</body>");
		writter.println("</html>");
		writter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writter = resp.getWriter();
		writter.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><title>회원가입 결과</title></head><body>");
		writter.println("입력받은 결과값<table><tr><td>입력된 아이디</td><td>");
		writter.println(req.getParameter("userId"));
		writter.println("</td></tr><tr><td>입력된 이름</td><td>");
		writter.println(req.getParameter("userName"));
		writter.println("</td><tr><td>입력된 이메일</td><td>");
		writter.println(req.getParameter("userEmail1"));
		writter.print("@");
		writter.println(req.getParameter("userEmail2"));
		writter.println("</td></tr><tr><td>입력된 핸드폰 번호</td><td>");
		writter.println(req.getParameter("userPhoneNumber"));
		writter.println("</td></tr><tr><td>입력된 우편번호</td><td>");
		writter.println(req.getParameter("userZipcode1"));
		writter.println("&nbsp; - &nbsp; ");
		writter.println(req.getParameter("userZipcode2"));
		writter.println("</tr><tr><td>입력된 주소</td><td>");
		writter.println(req.getParameter("userAddress"));
		writter.println("</td></tr>");
		writter.println("</table></body></html>");
		writter.close();
	}
	

}
