package kr.co.wodud.cont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/** BufferedOutputStream / BufferedInputStream 사용법
 * @author 오재영
 *
 */
public class MainRun {

	public static void main(String[] args) {
		
		
//	InputStream is = System.in;
//	Reader reader = new InputStreamReader(is);
//	BufferedReader br = new BufferedReader(reader);
	
	Reader r = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(r);
	
	try {
		while(true){
			String str = br.readLine();
			
			System.out.println(str);
		
		if(str.equals("")){
			break;
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
