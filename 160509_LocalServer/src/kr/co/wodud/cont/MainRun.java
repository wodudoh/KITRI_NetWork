package kr.co.wodud.cont;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server 프로그래밍
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
		String _serverData = "서버에 있는 데이터 값 입니다.";
		Socket _socket = null;

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

			int count = 0;
			boolean a = true;
			
			while (a) {
				// 구성된 ServerSocket Open
				_socket = _userSS.accept();
				count++;
				if (count >= 10) {
					a = false;
				}
				System.out.println(count + "번째 누군가 접근 함");
				// 스트림이라는 것은? 순차 없는 데이터를 순차적으로 만들어 재정렬해서 내보낼수 있게 셋팅해주는 역할 직렬화
				// Server -> client = 원본 서버 자료를 클라이언트에 전달
				// OutputStream 데이터를 외부에 전달 시킴.
				// Socket 객체를 통해 OutputStream 연결
				OutputStream _os = _socket.getOutputStream();
				//byte 타입으로 변환하는 이유는 stream에서 유일하게 사용할 수 있는 데이터 타입이므로.( 그 이유는 기계어에 가까운 코드가 byte 코드이므로 다른 기계에도 처리하기 위해서이다.)
				byte[] _bytes = new byte[100];
				_bytes = _serverData.getBytes();
				_os.write(_bytes);
				_os.flush();
				// buffer 에 담겨있는 데이터를 최종 전송을 수행후 버퍼에 내용을 비운다.
				
				// Client의 데이터 받아오기
				InputStream _is = _socket.getInputStream();
				String _clientData = new String(_bytes, 0, _is.read(_bytes));
				System.out.println("클라이언트로부터의 data : " +_clientData);
				_is.close();
				
				if(_os != null){
					_os.close();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(_socket != null){
				try {
					_socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (_userSS != null) {
				try {
					_userSS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
