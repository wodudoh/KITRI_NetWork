package kr.co.wodud.cont;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.wodud.Model.EmpBean;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao ed = new EmpDao();
		List<EmpBean> list = ed.getEmpList();
		// Excel 로 해당 list에 있는 값들 저장하기
		String root = getServletContext().getRealPath("/");
		ed.setExcel(list, root);

		try{
		byte b[] = new byte[4096];
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename = " + "workbook.xlsx");
		FileInputStream in = new FileInputStream(root+"workbook.xlsx");
		ServletOutputStream out2 = response.getOutputStream();
			int numRead;
			while ((numRead = in.read(b, 0, b.length)) != -1) {
				out2.write(b, 0, numRead);
			}
			out2.flush();
			out2.close();
			in.close();
		
		}catch(IOException e){
			e.printStackTrace();
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
