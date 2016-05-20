package kr.co.mskim.cont;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class JSonGetCont
 */
@WebServlet("/getJson.do")
public class JSonGetCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String jsonInfo = request.getParameter("jsonValue");
		//URLEncoder.encode(jsonInfo , "UTF-8");
		
		try {
			 
            JSONParser jsonParser = new JSONParser();
             
            //JSON�����͸� �־� JSON Object �� ����� �ش�.
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
             
            //books�� �迭�� ����
            JSONArray bookInfoArray = (JSONArray) jsonObject.get("books");
 
            System.out.println("* BOOKS *");
 
            for(int i=0; i<bookInfoArray.size(); i++){
 
                System.out.println("=BOOK_"+i+" ===========================================");
                 
                //�迭 �ȿ� �ִ°͵� JSON���� �̱� ������ JSON Object �� ����
                JSONObject bookObject = (JSONObject) bookInfoArray.get(i);
                 
                //JSON name���� ����
                System.out.println("bookInfo: name==>"+bookObject.get("name"));
                System.out.println("bookInfo: writer==>"+bookObject.get("writer"));
                System.out.println("bookInfo: price==>"+bookObject.get("price"));
                System.out.println("bookInfo: genre==>"+bookObject.get("genre"));
                System.out.println("bookInfo: publisher==>"+bookObject.get("publisher"));
 
            }
 
            JSONArray personInfoArray = (JSONArray) jsonObject.get("persons");
 
            System.out.println("\r\n* PERSONS *");
 
            PrintWriter out = response.getWriter();
            ServletOutputStream out2 = response.getOutputStream();
            
            out.print("PrintWriter 호출");
            out2.print("ServletOutputStream 호출");
            
            for(int i=0; i<personInfoArray.size(); i++){
            	
                System.out.println("=PERSON_"+i+" ===========================================");
                JSONObject personObject = (JSONObject) personInfoArray.get(i);
                System.out.println("personInfo: name==>"+personObject.get("name"));
                System.out.println("personInfo: age==>"+personObject.get("age"));
                System.out.println("personInfo: gender==>"+personObject.get("gender"));
                System.out.println("personInfo: nickname==>"+personObject.get("nickname"));
 
            }
 
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
