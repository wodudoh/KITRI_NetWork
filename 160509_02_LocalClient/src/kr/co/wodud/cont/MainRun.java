package kr.co.wodud.cont;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/** Client 프로그래밍 
 * @author Administrator
 *
 */
public class MainRun {

	public static void main(String[] args) {
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
		int _userPort = 60600;
		// Socket API 서버에 접근할 수 있도록 구성
		// 서버 주소 및 포트 값 지정
		String _serverIP = "192.168.14.31";
		int _serverPort  = 60606;
		
		Socket _socket = null; 
		
		try {
			//접근하고자 하는 Server IP, Port 세팅
			_socket = new Socket(_serverIP, _serverPort);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
