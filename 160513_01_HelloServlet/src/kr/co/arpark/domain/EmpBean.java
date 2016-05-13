package kr.co.arpark.domain;

import java.io.Serializable;

/** 형식을 만들어서 사용만 하기위한 Bean 객체
 * @author 오재영
 *
 */

public class EmpBean implements Serializable {
	private static final long serialVersionUID = 10000L;
	//직접적인 객체를 접근 하지 못하도록 함.
	private int empno;
	private String ename;
	private int mgr;
	private String job;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmpBean [empno=" + empno + ", ename=" + ename + ", mgr=" + mgr + ", job=" + job + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	

}
