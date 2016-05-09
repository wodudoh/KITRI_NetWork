package ke.pe.theeye.webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.activation.MimetypesFileTypeMap;

/**
 * <pre>
 * �����ϴ� Ŭ���̾�Ʈ���� ���� ó���� ���� ������ Ŭ����
 * </pre>
 * 
 * @author eye
 * @since 2010.11.15
 */
public class ServerThread extends Thread
{
	// ���� ��û�� ���� ����� �⺻ ����
	private static final String DEFAULT_FILE_PATH = "index.html";
	
	// Ŭ���̾�Ʈ���� ���� ����
	private Socket connectionSocket;
	
	/**
	 * <pre>
	 * �⺻ ������
	 * </pre>
	 * 
	 * @param connectionSocket Ŭ���̾�Ʈ���� ����� ���� ����
	 */
	public ServerThread(Socket connectionSocket)
	{
		this.connectionSocket = connectionSocket;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		System.out.println("WebServer Thread Created");
		BufferedReader inFromClient = null;
		DataOutputStream outToClient = null;
		
		try
		{
			// Ŭ���̾�Ʈ�� ����� ���� ��/��� 2���� ��Ʈ���� �����Ѵ�.
			inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			// Ŭ���̾�Ʈ���� �޽����� ù��° ���� �о���δ�.
			String requestMessageLine = inFromClient.readLine();
			
			// �Ľ��� ���� ��ū�� �����Ѵ�.
			StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

			// ù��° ��ū�� GET���� �����ϴ°�? ex) GET /green.jpg
			if(tokenizedLine.nextToken().equals("GET"))
			{
				// ������ ��ū�� ���ϸ��̴�.
				String fileName = tokenizedLine.nextToken();

				// �⺻������ ��Ʈ(/)�κ��� �ּҰ� �����ϹǷ� �����Ѵ�.
				if(fileName.startsWith("/") == true)
				{
					if(fileName.length() > 1)
					{
						fileName = fileName.substring(1);
					}
					// ���ϸ��� ���� �Է����� �ʾ��� ��� �⺻ ������ ����Ѵ�.
					else
					{
						fileName = DEFAULT_FILE_PATH;
					}
				}

				File file = new File(fileName);
				
				// ��û�� ������ �����ϴ°�?
				if(file.exists())
				{
					// �����ϴ� ������ MIMEŸ���� �м��Ѵ�.
					String mimeType = new MimetypesFileTypeMap().getContentType(file);
					System.out.println("Requested File Name : " + fileName + ", Mime Type : " + mimeType);
					
					// ������ ����Ʈ���� ã�ƿ´�.
					int numOfBytes = (int) file.length();

					// ������ ��Ʈ���� �о���� �غ� �Ѵ�.
					FileInputStream inFile = new FileInputStream(fileName);
					byte[] fileInBytes = new byte[numOfBytes];
					inFile.read(fileInBytes);

					// ���������� ó���� �Ǿ����� ��Ÿ���� 200 �ڵ带 ����Ѵ�.
					outToClient.writeBytes("HTTP/1.0 200 Document Follows \r\n");
					outToClient.writeBytes("Content-Type: " + mimeType + "\r\n");

					// ����� �������� ���̸� ���
					outToClient.writeBytes("Content-Length: " + numOfBytes + "\r\n");
					outToClient.writeBytes("\r\n");
					
					// ��û ������ ����Ѵ�.
					outToClient.write(fileInBytes, 0, numOfBytes);
				}
				else
				{
					// ������ �������� �ʴ´ٴ� ������ 404 ������ ����ϰ� ������ �����Ѵ�.
					System.out.println("Requested File Not Found : " + fileName);
					
					outToClient.writeBytes("HTTP/1.0 404 Not Found \r\n");
					outToClient.writeBytes("Connection: close\r\n");
					outToClient.writeBytes("\r\n");
				}
			}
			else
			{
				// �߸��� ��û���� ��Ÿ���� 400 ������ ����ϰ� ������ �����Ѵ�.
				System.out.println("Bad Request");
				
				outToClient.writeBytes("HTTP/1.0 400 Bad Request Message \r\n");
				outToClient.writeBytes("Connection: close\r\n");
				outToClient.writeBytes("\r\n");
			}
			
			connectionSocket.close();
			System.out.println("Connection Closed");
		}
		// ���� ó��
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
