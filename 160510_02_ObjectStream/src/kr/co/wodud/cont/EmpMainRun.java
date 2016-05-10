package kr.co.wodud.cont;

import java.util.List;

import kr.co.arpark.domain.EmpBean;
import kr.co.wodud.model.EmpDao;
import kr.co.wodud.view.EmpView;

/** 실행을 위한 객체
 * @author Administrator
 *
 */
public class EmpMainRun {

	public static void main(String[] args) {
		EmpView ev = new EmpView();
		String input = null;
		List<EmpBean> list;
		EmpBean eb = new EmpBean();
		ServerStart ss = new ServerStart();
		
		do{
			//Menu 출력하기.
			ev.printMenu();
			// Menu 입력하기.
			input = ev.inputMenu();
			// 해당 메뉴에 따라서 처리하기
			if(input.equals("1")){
				//사원 입력할 수 있는 메뉴 출력
				list = ev.addEmp();
			}else if(input.equals("2")){
				//입력된 사원 출력하기
				// eb => EmpView 사원 정보 출력 메소드
				// ev.printEmp(eb);
				ev.printEmp(eb);
			}else if(input.equals("3")){
				// Server로 Socket을 생성해서 대기
				// Client 에게 입력한 Emp 정보를 제공
				ss.startServer(eb);
			}else if(input.equals("4")){
				// 4 = 해당 서버에 접근하여
				// 서버 Output Stream 에 있는 값을
				// InputStream을 통해서 받아오기
				String ip = ev.inputMenu();
				int port = Integer.parseInt(ev.inputMenu());
				
				list = ss.conServer(ip, port);
				ev.printEmp(eb);
			}else if(input.equals("5")){
				//DB에 접속해서 employees 정보 가져오기
				EmpDao empDao = new EmpDao();
				list = empDao.getEmpAll();
				for(EmpBean dao : list){
					System.out.println(dao);
				}
				
			}
				
			
		}while(!input.equals("q"));
		
		
	}

}
