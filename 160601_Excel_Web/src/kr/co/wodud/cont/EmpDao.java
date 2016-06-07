package kr.co.wodud.cont;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.co.wodud.Model.EmpBean;

public class EmpDao {

	public List<EmpBean> getEmpList() {
		
		SetupDB sd = new SetupDB();
		StringBuilder sql = new StringBuilder("SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, TO_CHAR(HIRE_DATE, 'YYYY-MM-DD')");
		sql.append("FROM EMPLOYEES");
		
		ResultSet rs = null;
		rs =sd.select(sql);
		List<EmpBean> list = new ArrayList<EmpBean>();
		
		
		
		try {
			while(rs.next()){
			EmpBean eb = new EmpBean();
			eb.setEmployee_id(rs.getInt(1));
			eb.setFirst_name(rs.getString(2));
			eb.setSalary(rs.getInt(3));
			eb.setHire_date(rs.getString(4));
			list.add(eb);
			}
		} catch (SQLException e) {
			
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			sd.closeDB();
		}
		
		return list;
	}

	public void setExcel(List<EmpBean> list, String root) {
		System.out.println("set excel 호출");
		// 2007 이상 형식의 엑셀
		Workbook wb = new XSSFWorkbook();
		// 파일로 생성
	    FileOutputStream fileOut=null;
	    Iterator<EmpBean> lis = list.iterator();
		try {
			 fileOut = new FileOutputStream(new File(root+"workbook.xlsx"));
			 Sheet sh1 = wb.createSheet("testsheet1");
			 
			 int i = 0;
			 while(lis.hasNext()){
				 EmpBean eb = lis.next();
				 Row row1 = sh1.createRow(i);
				 Cell cell1 = row1.createCell((short)0);
				 Cell cell2 = row1.createCell((short)1);
				 Cell cell3 = row1.createCell((short)2);
				 Cell cell4 = row1.createCell((short)3);
				 cell1.setCellValue(eb.getEmployee_id());
				 cell2.setCellValue(eb.getFirst_name());
				 cell3.setCellValue(eb.getSalary());
				 cell4.setCellValue(eb.getHire_date());
				 i++;
			 }

			 wb.write(fileOut);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}finally{
			if(wb != null){
				try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fileOut != null){
			try {
				fileOut.close();
			} catch (IOException e) {
			}
			}
		}

		
	}
	
	

}
