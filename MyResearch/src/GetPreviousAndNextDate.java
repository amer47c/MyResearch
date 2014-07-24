import java.text.SimpleDateFormat;
import java.util.Date;

public class GetPreviousAndNextDate {

	public static void main(String[] args) {
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
		String currDate = dateFormat.format(date.getTime());
		String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);
		System.out.println("Previous date: " + prevDate);
		System.out.println("Currnent date: " + currDate);
		System.out.println("Next date: " + nextDate);
	}

}
