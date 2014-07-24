import java.sql.Timestamp;
import java.util.Date;


public class DaysDiff {

	public static void main(String[] args) {
		
		String sdate = "02/02/2014";
		String edate = "02/05/2014";
		
		Date d1 = JJUtils.formatStr2Date(sdate);
		Date d2 = JJUtils.formatStr2Date(edate);
		
		long diff = JJUtils.daysBetween(d1, d2);
		
		System.out.println("Date Difference: "+diff);

		
		Date inc = JJUtils.getIncrementOrDecrementDate(new Date(), 10);
		System.out.println("Incremented Date: "+inc);
	}

}
