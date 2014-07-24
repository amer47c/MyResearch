//================================================ Java code sample ================================================//

import java.net.*;
import java.io.*;

public class SendSms {

	public String sendMMS() {
		try {
			// Construct data
			System.out.print("Hello");
			String user = "username=" + "psdhillon111@gmail.com";
			String hash = "&hash=" + "UjhMPiaYt3g-wzSeg2uhn5NY2DrF0z77q4tjP3fP8W";
			String numbers = "&numbers=" + "12105733017";
			String message = "&message=" + "Ajeet Barbara Test Demo SMS";
			String MMSURL = "&url=" + "www.funnycats.com/pic1.jpg";
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL(
					"https://api.txtlocal.com/send_mms/?").openConnection();
			String data = user + hash + numbers + message + MMSURL;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length",
					Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			return stringBuffer.toString();
		
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	static public void main(String[] args) {
		SendSms s = new SendSms();
		s.sendMMS();
	}
}
