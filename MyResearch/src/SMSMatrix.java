import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class SMSMatrix {

	public static void main(String[] args){
		try{
			
		 String MATRIXURL = "http://www.smsmatrix.com/matrix";
		 String PHONE = "12105733017";
		 String USERNAME = "amer47c@gmail.com";
		 String PASSWORD = "amer47camer47c";
		 String TXT = "A sample SMS from AJEET. Sir if you recieved this Text, Please let me know. Thanks.";

		 String q = "username=" + URLEncoder.encode (USERNAME, "UTF-8");
		 q += "&" + "password=" + URLEncoder.encode (PASSWORD, "UTF-8");
		 q += "&" + "phone=" + PHONE;
		 q += "&" + "txt=" + URLEncoder.encode (TXT, "UTF-8");

		 URL url = new URL (MATRIXURL);
		 URLConnection conn = url.openConnection();
		 conn.setDoOutput (true);
		 OutputStreamWriter wr = new OutputStreamWriter (conn.getOutputStream());
		 wr.write (q);
		 wr.flush();
		    
		 BufferedReader rd = new BufferedReader (new InputStreamReader (conn.getInputStream()));
		 String line;
		 System.out.println ("Matrix API Response :");
		 while ((line = rd.readLine()) != null) { System.out.println (line); }
		 wr.close();
		 rd.close();
		 
		}catch (Exception e) { } 
	}
}
