import java.util.Properties;

import org.marre.sms.SmsAddress;
import org.marre.sms.SmsTextMessage;
import org.marre.sms.transport.SmsTransport;
import org.marre.sms.transport.SmsTransportManager;

public class ClickaTell {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// The username, password and apiid is sent to the clickatell transport
		// in a Properties				
		Properties props = new Properties();

		props.setProperty("smsj.clickatell.username", "akumar");
		props.setProperty("smsj.clickatell.password", "BHdCTHNRZFAOFQ");
		props.setProperty("smsj.clickatell.apiid", "3485686");

		// Load the clickatell transport
		SmsTransport transport = SmsTransportManager.getTransport("org.marre.sms.transport.clickatell.ClickatellTransport", props);

		// Connect to clickatell
		transport.connect();

		// Create the sms message
		SmsTextMessage textMessage = new SmsTextMessage("A sample SMS from AJEET. Sir if you recieved this Text, Please let me know. Thanks.");

		// Send the sms to "1" from "2"
		transport.send(textMessage, new SmsAddress("12142800553"), new SmsAddress("12142800553"));
						
		// Disconnect from clickatell
		transport.disconnect();
	}
}
