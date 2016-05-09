package kr.co.wodud.cont;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/** Client 프로그래밍 
 * @author Administrator
 *
 */
public class MainRun {

	public static void main(String[] args) {
		InetAddress _ia = null; // 내가 지정한 변수구나 아는 방법 _언더바를 활용.
		String _clientData = "클라이언트의 데이터 입니다.";

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
			//생성자를 이용한 접속방법
//			_socket = new Socket(_serverIP, _serverPort);
			//메소드를 이용한 접속방법
			_socket = new Socket();
			_socket.connect(new InetSocketAddress(_serverIP, _serverPort));
			System.out.println("서버 접속 성공");
			// 서버에 OutputStream 에 있는 값을 가져오기
			InputStream _is = _socket.getInputStream();
			byte[] _bytes = new byte[100];
			int _i = _is.read(_bytes);
			String _serverData = new String(_bytes, 0, _i);
			System.out.println("서버에서 부터 받은 값 : "+_serverData);
			// 서버의 데이터 받는 스트림 닫기
			
			// 다시 서버 쪽에서 데이터 받아 오기
			OutputStream _os = _socket.getOutputStream();
			_bytes = _clientData.getBytes();
			_os.write(_bytes);
			_os.flush();
			// 클라이언트의 전송 스트림 닫기
			_is.close();
			_os.close();
			_socket.close();
			//TODO 콘솔에서 하는 하는 채팅 프로그램
			//mskim@kitri.re.kr
			
			
			
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
