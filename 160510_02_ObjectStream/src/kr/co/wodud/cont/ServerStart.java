package kr.co.wodud.cont;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import kr.co.arpark.domain.EmpBean;

/** Server로 Socket을 생성해서 대기
 * @author Administrator
 *
 */
public class ServerStart {
	//Server Socket 생성 메소드
	public void startServer(EmpBean eb){
		ServerSocket ss = null;
		Socket socket = null;
		ObjectOutputStream oos =null;
		try {
			// Server 구축으로 클라이언트로 부터 요청대기
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.31", 50000));
			System.out.println("서버 대기중");
			socket = ss.accept();
			//클라이언트로 부터 요청 오면, 자료 전송
			// EmpBean
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(eb);
			System.out.println("oos 세팅 완료");
			oos.flush();
			System.out.println("oos 전달 완료");
			oos.close();
			socket.close();
			ss.close();
			System.out.println("서버 소켓 종료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Client가 서버에 접속하는 모듈
	 */
	public List<EmpBean> conServer(String ip, int port) {
		Socket socket = new Socket();
		InetSocketAddress isa = new InetSocketAddress(ip, port);
		ObjectInputStream ois = null;
		List<EmpBean> list = new ArrayList<EmpBean>();
		
		try {
			// Client가 server socket에 연결 시킴...
			socket.connect(isa);
			// Server OutputStream 전달된 자료
			// InputStream 통해서 받아오기
			ois = new ObjectInputStream(socket.getInputStream());
			
			// eb에 서버에 접근한 데이터 받아오기
			// EmpBean eb = (EmpBean)ois.readObject();
			list = (List)ois.readObject();
			
			ois.close();
			socket.close();
			
			return list;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void startServerDB(){
		ServerSocket ss = null;
		Socket socket = null;
		ObjectOutputStream oos =null;
		try {
			// Server 구축으로 클라이언트로 부터 요청대기
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.31", 50000));
			System.out.println("서버 대기중");
			socket = ss.accept();
			// 클라이언트로 부터 요청 오면, 자료 전송
			// EmpBean
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			// 차이점은 Database에서 부터 받아온 값을 입력
			// oos.writeObject(eb);
			System.out.println("oos 세팅 완료");
			oos.flush();
			System.out.println("oos 전달 완료");
			oos.close();
			socket.close();
			ss.close();
			System.out.println("서버 소켓 종료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
