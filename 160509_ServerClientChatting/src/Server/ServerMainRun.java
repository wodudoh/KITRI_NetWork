package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**	서버 프로그램 mainThread로는 message를 전송, 새로울 thread에서는 client의 message를 받는다.
 * @author Administrator
 *
 */
public class ServerMainRun implements Runnable {

	//서버 소켓
	ServerSocket _serverSS = null;
	InputStream _is;
	//클라이언트로 메시지 전송을 위한 소켓
	Socket _socket = null;
	//서버 소켓 포트/host_ip
	int _port = 50403;
	String _ip = "192.168.14.31";
	// client 메세지 처리를 위한 byte 배열
	byte[] _bytes;
	//클라이언트에게서 받은 메세지
	String _clientMessage = null;
	//서버에서 보낼 메세지
	String _serverMessage = null;
	
	
	/**
	 * 클라이언트에 보내는 main Thread
	 */
	private void ServerMainrun() {
	
		try {
			_serverSS = new ServerSocket(_port);
			while(true){
				_socket=_serverSS.accept();
				
				ServerMainRun _smr=new ServerMainRun();
				new Thread(_smr).start();
				
				//server 메시지 client로 전송
				Scanner _sc = new Scanner(System.in);
				_serverMessage = _sc.nextLine();
				_bytes = _serverMessage.getBytes();
				
				OutputStream _os = _socket.getOutputStream();
				_os.write(_bytes);
				_os.flush();
				
				//TODO quit 이라는 메시지가 도착했을 때 종료.
				if(_clientMessage.equals("quit")||_serverMessage.equals("quit")){
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
						
			if(_socket!=null){
				try {
					_socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(_serverSS!=null){
				try {
					_serverSS.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	/**
	 * 클라이언트의 메세지를 받아서 출력한다.
	 */
	@Override
	public void run() {
		
		try {
			_is = _socket.getInputStream();
			String _clientData = new String(_bytes, 0, _is.read(_bytes));
			System.out.println("클라이언트 메세지 : " +_clientData);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new ServerMainRun();
		
	}


}
