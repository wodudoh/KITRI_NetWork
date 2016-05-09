package kr.co.wodud.cont;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * Server Client 프로그래밍
 * 
 * @author Administrator
 *
 */
public class MainRun {

	/**
	 * Socket 프로그래밍
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ip 주소값 세팅
		InetAddress _ia = null; // 내가 지정한 변수구나 아는 방법 _언더바를 활용.

		try {
			_ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		System.out.println(_ia.getHostName());
		System.out.println(_ia.getHostAddress());

		// Port 번호 생성
		// port : 같은 내부 아이피로부터 어떤 작업을 수행할지 번호로써 구분해줄수 있는 구분 값. 0~65535 설정 가능
		// well-known port : 일반적으로 예약되어있는 포트 번호
		// 60606 숫자 타입
		int _userPort = 60606;

		// Server Socket 구성
		// 1057page
		ServerSocket _userSS = null;
		try {
			_userSS = new ServerSocket();
			// Socket 구성시 필요 요소 : IP, Port
			// 1058page Server Socket.bind
			_userSS.bind(new InetSocketAddress(_ia.getHostAddress(), _userPort)); // endpoint 는 inetSockAdress
			
			int count =0;
			boolean a = true;
			while(a){
			//구성된 ServerSocket Open
			_userSS.accept();
			count++;
			if(count >= 10){
				 a = false;
				}
			System.out.println(count+"번째 누군가 접근 함");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
