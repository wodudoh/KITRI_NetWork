import java.io.*;
import java.net.*;

public class MAIN_SERVER {
	public static void main(String[] args) {
		ServerSocket server = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		BufferedReader User_br = null;
		int userPort = 60606;
        
        try{
            server = new ServerSocket(userPort); 
            Socket client = server.accept();   
 
            InputStream is = client.getInputStream(); 
            OutputStream os = client.getOutputStream(); 
 
            String receive_msg = "";
            String send_msg = "";

            br = new BufferedReader(new InputStreamReader(is));
            User_br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(os));  
    		System.out.println("ä���� �����մϴ�");
    		
    		while(true){
                send_msg = br.readLine();
                if(send_msg.equals("/q")){
    				break;
    			} else {
        			bw.flush();
    			}
				System.out.println("Ŭ���̾�Ʈ : " + send_msg);
				receive_msg = User_br.readLine();
				bw.write(receive_msg + "\n"); 
				bw.flush();
    		}
        } catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}