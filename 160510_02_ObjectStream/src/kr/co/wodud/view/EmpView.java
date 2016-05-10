package kr.co.wodud.view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kr.co.arpark.domain.EmpBean;

/** empview 화면 구성 객체
 * @author Administrator
 *
 */
public class EmpView {
	/**
	 * 기본 메뉴 출력 부분
	 */
	public void printMenu(){
		System.out.println("EMP 테스트 프로그램");
		System.out.println("원하는 메뉴를 선택하세요 )");
		System.out.println("1.사원입력\n2.사원출력\n3.서버구동\n4.서버연결\nq.프로그램종료");
	}
	/**
	 * 메뉴 입력 메소드
	 */
	public String inputMenu(){
		//reader 객체로 업 캐스팅이 되서 가능한것.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String inputMenu = br.readLine();
			return inputMenu;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 사원 추가 메뉴.
	 */
	public List<EmpBean> addEmp() {
		System.out.println("사원번호를 입력하세요.");
		int empno = Integer.parseInt(inputMenu());
		String s_empno = Integer.toString(empno);
//		String s_empno = String.valueOf(empno);
		System.out.println("사원이름을 입력하세요.");
		String ename = inputMenu();
		System.out.println("매니저 번호를 입력하시오.");
		int mgr = Integer.parseInt(inputMenu());
		System.out.println("직무를 입력하세요.");
		String job = inputMenu();
		System.out.println("입사일을 입력하세요.");
		String hiredate = inputMenu();
		System.out.println("연봉을 입력하세요.");
		int sal = Integer.parseInt(inputMenu());
		System.out.println("수당을 입력하세요.");
		int comm = Integer.parseInt(inputMenu());
		System.out.println("부서번호를 입력하세요.");
		int deptno = Integer.parseInt(inputMenu());
		
		
		//EmpBean을 통해 3가지 값 입력
		EmpBean eb = new EmpBean();
			eb.setEmpno(empno);
			eb.setEname(ename);
			eb.setMgr(mgr);
			eb.setJob(job);
			eb.setHiredate(hiredate);
			eb.setSal(sal);
			eb.setComm(comm);
			eb.setDeptno(deptno);
		List<EmpBean> list = new ArrayList<EmpBean>();
		list.add(eb);
		System.out.println("입력이 완료되었습니다.");
		System.out.println("계속 입력하시려면 1을 입력하시고 초기화면으로 가시려면 2를 입력하세요.");
		
		return list;
		
	}
	
	/**
	 * 객체 프린트 메소드
	 * @param EmpBean
	 */
	public void printEmp(EmpBean eb) {
		System.out.println("사원번호 : "+eb.getEmpno());
		System.out.println("사원 이름 : "+eb.getEname());
		System.out.println("매니저 번호 : "+eb.getMgr());
		System.out.println("직무 : "+eb.getJob());
		System.out.println("입사일 : "+eb.getHiredate());
		System.out.println("연봉 :"+eb.getSal());
		System.out.println("수당 : "+eb.getComm());
		System.out.println("부서번호 : "+eb.getDeptno());
	}
	
	
}
