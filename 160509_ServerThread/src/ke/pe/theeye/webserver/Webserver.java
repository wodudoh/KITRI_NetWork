package ke.pe.theeye.webserver;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * �������� �����ϴ� Ŭ����
 * </pre>
 * 
 * @author eye
 * @since 2010.11.15
 */
class WebServer
{
	public static void main(String argv[]) throws Exception
	{
		// ���������� �����Ѵ�. �������� �⺻������ 80�� ��Ʈ�� ����Ѵ�.
		ServerSocket listenSocket = new ServerSocket(80);
		System.out.println("WebServer Socket Created");

		Socket connectionSocket;
		ServerThread serverThread;
		
		// ��ȯ�� ���鼭 Ŭ���̾�Ʈ�� ������ �޴´�. accept()�� Blocking �޼����̴�.
		while((connectionSocket = listenSocket.accept()) != null)
		{
			// ���� �����带 �����Ͽ� �����Ѵ�.
			serverThread = new ServerThread(connectionSocket);
			serverThread.start();
		}
	}
}
