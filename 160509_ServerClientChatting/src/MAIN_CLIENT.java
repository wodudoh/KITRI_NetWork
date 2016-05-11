import java.io.*;
import java.net.*;
 
public class MAIN_CLIENT {

    public static void main(String[] args) {
        BufferedWriter bw= null;
        BufferedReader br = null;
        BufferedReader User_br = null;
		Socket socket = null;
		int userPort = 60606;
		
    	try{
    		socket = new Socket("localHost", userPort);  
    		System.out.println("연결에 성공했습니다.");
    		InputStream _is = socket.getInputStream(); 
    		OutputStream _os = socket.getOutputStream(); 
    		
    		String send_msg = null;
    		String receive_msg = null;
    		
    		br = new BufferedReader(new InputStreamReader(System.in));  
    		User_br = new BufferedReader(new InputStreamReader(_is)); 
    		bw = new BufferedWriter(new OutputStreamWriter(_os));   
    		System.out.println("채팅을 시작합니다");
    		
    		while(true){
    			send_msg = br.readLine();
    			bw.write(send_msg+"\n");
    			if(send_msg.equals("/q")){
    				break;
    			} else {
        			bw.flush();
    			}
    			receive_msg = User_br.readLine();
    			System.out.println("서버 : "+ receive_msg);
    		}
    	} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
}