import java.sql.Timestamp;
import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JJUtils {
	
	private static final long ONE_HOUR = 60 * 60 * 1000L;
	private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	
	@SuppressWarnings("unchecked")
	public static ArrayList replaceStringByWords(String original) {
		 ArrayList aListToken = new ArrayList();
	    String currentToken="";
	    StringTokenizer token = new StringTokenizer(original, ";"); //use a semicolon as a string delimiter
	    while (token.hasMoreTokens()) {
	         currentToken = token.nextToken();
	         aListToken.add(currentToken);
	         }
	    return aListToken;
	}
	
	public static String showRandomInteger(){
		    int aStart = 10000000;
		    int aEnd = 99999999;
		    int randomNumber =0;
		    Random random = new Random();
		    for (int idx = 1; idx <= 10; ++idx){
	    if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	      }
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	     long fraction = (long)(range * random.nextDouble());
	     randomNumber =  (int)(fraction + aStart);    
	  }
		return Integer.toString(randomNumber);    
	}
	
	

	public static String RandomIntegerfour(){
		    int aStart = 10000;
		    int aEnd = 99999;
		    int randomNumber =0;
		    Random random = new Random();
		    for (int idx = 1; idx <= 10; ++idx){
	    if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	      }
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	     long fraction = (long)(range * random.nextDouble());
	     randomNumber =  (int)(fraction + aStart);    
	  }
		return Integer.toString(randomNumber);    
	}
	
	public static String getGenerateUUID() {
		
	    String idOne = (String.valueOf(UUID.randomUUID()));
	    //UUID idTwo = UUID.randomUUID();
	    //UtilityDao.PrintData(String.valueOf(idOne).toUpperCase());
	    return idOne;
	  
	} 

	
	public static String nullCheck(String value) {
		

		if (value == null) {
			value = "";
		}
		return value;
	} 
	
	public static java.sql.Date formatDBDate(String strDate)throws ParseException {	
		
		java.util.Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			date =  (java.util.Date)formatter.parse(strDate);
			
		}catch (ParseException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return new java.sql.Date(date.getTime());		
	}
	

	public static Timestamp  formatTimeStamp(String strDate)throws ParseException {	
		
		try {
			  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			  java.util.Date parsedDate = dateFormat.parse(strDate);
			  java.sql.Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			  return timestamp;
					
		}catch (ParseException ex) {
			ex.printStackTrace();
			throw ex;
		}
				
	}
public static java.sql.Date formatTimeStampToSqlDate(Timestamp ts) {
		try {			 
			 return new java.sql.Date(ts.getTime());
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return null;
				
	}
	

public static java.util.Date formatTimeStampToJavaUtilDate(Timestamp ts) {
	try {			 
		 return new java.util.Date(ts.getTime());
	}catch (Exception ex) {
		ex.printStackTrace();
		
	}
	return null;
			
}

	  
	public static java.sql.Date formatDBDateNEW(String strDate)throws ParseException {	
		
		java.util.Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			date =  (java.util.Date)formatter.parse(strDate);
			
		}catch (ParseException ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		//UtilityDao.PrintData("Date>>>"+ date);
		
		return new java.sql.Date(date.getTime());		
	}
	
	public static Date formatStr2Date(String strDate, String format)throws ParseException {
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(false);
			date =  (Date)formatter.parse(strDate);
		}catch (ParseException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return date;
	}
	
	public static boolean isFutureDate(String strDate){
		boolean isFutureDate = false;
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			formatter.setLenient(false);
			date =  (Date)formatter.parse(strDate);
			if (date.getTime() >  new Date().getTime() ){				
				isFutureDate = true;
			}
		}catch (ParseException ex) {
			ex.printStackTrace();			
		}
		return isFutureDate;
	}
	
	
	public static boolean isValidDate(String strDate) {	
		boolean isValid = false;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			formatter.setLenient(false);
			formatter.parse(strDate);
			isValid = true;
		}catch (ParseException ex) {
			ex.printStackTrace();			
		}
		return isValid;		
	}

	public static String formatUIDate(Date date)throws ParseException {
	
		String strDate = "";
		if (date != null)
		{	
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			return formatter.format(date);
		}		
		return strDate;
		
	}
	
	
	public static String formatDBStringDate(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{	
			DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
			return formatter.format(date);
		}		
		return strDate;
		
	}
	
	
	public static String formatUITimeStamp(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{		
			DateFormat formatter = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
			strDate =  formatter.format(date);
		}
		
		return strDate;
	}


  public static String formatUITimeStamp2(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{		
			DateFormat formatter = new SimpleDateFormat("MMM dd - HH:mm");
			strDate =  formatter.format(date);
		}
		
		return strDate;
	}
  
  
  public static String formatUIdateTimeStamp(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{		
			DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy - HH:mm");
			strDate =  formatter.format(date);
		}
		
		return strDate;
	}
  
  public static String formatUIdateTimeStampMs(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{		
			DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy - HH:mm:ss");
			strDate =  formatter.format(date);
		}
		
		return strDate;
	}

	public static String formatTimeStampToDate(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{		
			DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
			strDate =  formatter.format(date);
		}
		
		return strDate;
	}


  public static String formatDBDateToDayMonth(Date date)throws ParseException {
		
		String strDate = "";
		if (date != null)
		{		
			DateFormat formatter = new SimpleDateFormat("MMM dd");
			strDate =  formatter.format(date);
		}
		
		return strDate;
	}



	public static String formatCurrency(float amount) {
		
		DecimalFormat dc = new DecimalFormat("#,##0.00");
		return dc.format(amount);
		
	}
	
	public static boolean isValidSSN(String SSN) {		
		boolean isValid = false;		
		//String pattern_1 =  "[0-9]{3}-[0-9]{2}-[0-9]{4}";		
		//String pattern_2 =  "[0-0]{3}-[0-9]{2}-[0-9]{4}";
		String pattern_1 =  "[0-9]{3}[0-9]{2}[0-9]{4}";
		String pattern_2 =  "[0-0]{3}[0-9]{2}[0-9]{4}";
		
		//if ( (SSN.matches(pattern_1) && !SSN.matches(pattern_2) ) ||  (SSN.matches(pattern_3) && !SSN.matches(pattern_4)) ){
		if ( (SSN.matches(pattern_1) && !SSN.matches(pattern_2)) ){
			isValid = true;
		}		
		return isValid;		
	}
	
	public static boolean isValidEmail(String email) {
		boolean isValid = false;
		String emailPattern = ".+@.+\\.[a-z]+";
		
		if ( email.matches(emailPattern)) {
			isValid = true;
		}		
		return isValid;
	}
	
	public static boolean isValidString(String name) {
		try {
			if(name == null || name.trim().length() == 0){return false;}
			
	        Pattern p = Pattern.compile("[^A-Za-z_0-9\\-\\.\\s]+");
		    Matcher m = p.matcher(name);
			return (!m.find());
            
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static boolean compare2Dates(Date adate , Date bdate, String type) throws ParseException {
		   boolean check =  false;
		   
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		    // Get Date 1
		    Date c1 = df.parse(JJUtils.formatDBStringDate(adate));

		    // Get Date 2
		    Date c2 = df.parse(JJUtils.formatDBStringDate(bdate));
		    
		   
		    if(type.equals("B")){
			    if (c1.before(c2)) {
			    	check = true;
			       }
		    }
		    if(type.equals("A")){
			    if (c1.after(c2)) {
			    	check = true;			    	     
			      }  
		    }
		    if(type.equals("E")){
			    if (c1.equals(c2)) {
			    	check = true;			    	
			    }
		    }			    
		    return check;
	}
		

	
	
	
	
	public static boolean isValidNumber(String number) {
		boolean isValid = true;
		try
		{
			Integer.parseInt(number);
		}
		catch(NumberFormatException ex)
		{
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isValidDoubleNumber(String number) {
		boolean isValid = true;
		try
		{
			Double.parseDouble(number);
		}
		catch(NumberFormatException ex)
		{
			isValid = false;
		}
		return isValid;
	}
	public static int calculateAgeOn(String  strDOB){	
		
		return calculateAgeOn(formatStr2Date(strDOB), new Date());		
	}
	
	


	
	public static long datediffInMinutes(Date d1 , Date d2) throws ParseException {
		   
		    //SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		    //Date d1=df.parse(sD1);
		    //Date d2=df.parse(sD2);
		   
		    long d1Ms=d1.getTime();
		    long d2Ms=d2.getTime();
		    return Math.abs((d1Ms-d2Ms)/60000);
		    
	}
		



	  
	   
	  

	
	public static int calculateAgeOn(Date dob){	
		
		return calculateAgeOn( dob, new Date());
		
	}
	
	
	public static int calculateAgeOn(Date dob, String strOnDate){	
		
		return calculateAgeOn( dob, formatStr2Date (strOnDate));
		
	}
	
	
	public static int calculateAgeOn(Date dob, Date onDate){	
		
		int age = 0;
		
		Date enrollmentDate = onDate ;
		
		Calendar calendarBirth = Calendar.getInstance();
		calendarBirth.setTime(dob);

		Calendar calendarDateOfEnrollment = Calendar.getInstance();
		calendarDateOfEnrollment.setTime(enrollmentDate);
		
		age = calendarDateOfEnrollment.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);
		
		// if that date has not occurred yet, subtract one from age
		calendarBirth.set(Calendar.YEAR, calendarDateOfEnrollment
				.get(Calendar.YEAR));
		if (calendarDateOfEnrollment.before(calendarBirth)) {
			age = age - 1;
		}
//	UtilityDao.PrintData("age >>>>> : " + age)	;	
        return age;
	}
	
	
	
	public static int getYear(Date thisDate)	
    {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(thisDate);		 
        return calendar.get(Calendar.YEAR);        
    }
	
	public static Date formatStr2Date(String strDate) 
	{
		Date date = null;
		try {
			date = formatStr2Date( strDate , "MM/dd/yyyy");
		} catch (ParseException ex) {
			ex.printStackTrace();
			
		}
		return date;		
	}
	
	public static boolean isNewEmployee(Date doj){		
		
		boolean isNewEmployee = false; 
		
		if ( daysBetween( doj, new java.util.Date()) <= 30 ) {
			isNewEmployee = true;
		}
		
		return isNewEmployee;
		
	}
   
	
	
	public static long daysBetween(Date d1, Date d2){
		return ( (d2.getTime() - d1.getTime() + ONE_HOUR) / 
                  (ONE_HOUR * 24));
    }
		
	public  static Date  getIncrementOrDecrementDate(Date _date, int i) {			   
	    Calendar cal = Calendar.getInstance();
	  	cal.setTime(_date);
        cal.add(Calendar.DATE, i);
        //java.util.Date Value = cal.getTime();
		java.sql.Date _day = new java.sql.Date(cal.getTimeInMillis());
		return _day;
     }

	
	public static String getFileDate() {

		String date = "";
		try {

			//DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
			DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
			date = formatter.format(new Date());

		} catch (Exception ex) {

		}
		return date;
	}
	
	public static Date curentDate() {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    Date currentDate = null;
	    	   // SImpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	    String sDate  = sdf.format(cal.getTime());
	   try
	   {
		   currentDate = sdf.parse(sDate);
	   }
	   catch(Exception e)
	   {
		   
	   }
	     return currentDate;

	  }

	public static Date curentDate(String format) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    Date currentDate = null;	    	  
	    String sDate  = sdf.format(cal.getTime());
	   try
	   {
		   currentDate = sdf.parse(sDate);
	   }
	   catch(Exception e)
	   {
		   
	   }
	     return currentDate;

	  }
	
	public static Date JSFUIDate(Date dte) {

		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		try {
			dte = sdf.parse(sdf.format(dte));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dte;

	}
	
	/* JSF returns date -1 . To correct it adding one day to the Date */
			public static Date correctJSFUI(Date date)	
		    {	
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);		 
				calendar.add(Calendar.DATE, 1);        
		        return calendar.getTime();
		    }
		
		
		public	static String replaceAllWords(String original, String find, String replacement) {
			    String result = "";
			    String delimiters = "+-*/(),. ";
			    StringTokenizer st = new StringTokenizer(original, delimiters, true);
			    while (st.hasMoreTokens()) {
			        String w = st.nextToken();
			        if (w.equals(find)) {
			            result = result + replacement;
			        } else {
			            result = result + w;
			        }
			    }
			    return result;
			}
		public static String formatNumber(float amount , String Type) {
				
				DecimalFormat dc = new DecimalFormat(Type);
				return  dc.format(amount);
				
			}
		
		public static String formatNumberInt(float amount) {
			
			DecimalFormat dc = new DecimalFormat("#########");
			return  dc.format(amount);
			
		}

				public static String formatStringTo2char(int amount) {
					
					DecimalFormat dc = new DecimalFormat("00");
					return  dc.format(amount);
					
				}
				
				
				public static String CurrencyFormat(float amount) {
				Double currency = new Double(amount);
				NumberFormat currencyFormatter;
				String currencyOut;
				Locale currentLocale = Locale.US;
				
				currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
				currencyOut = currencyFormatter.format(currency);
				//UtilityDao.PrintData(currencyOut + " " +    currentLocale.toString());
				
				return currencyOut;
				}
					
				
				public static boolean isStrContainNumber(String str) {				    
					  
					boolean valid = false;
					  
				    if (str == null || str.isEmpty()) {
				         return false;
				    }

				    StringBuffer strBuff = new StringBuffer();
				    char c;
				    int occurance = 0;
				    
				    for (int i = 0; i < str.length() ; i++) {
				        c = str.charAt(i);
				        
				        if (Character.isDigit(c)) {
				        	occurance++;
				        	//strBuff.append(c);			            
				        }
				    }
				    if(occurance < 3){
				    	valid = false;
				    }else{				    	
				    	valid = true;
				    }
				    return valid;
				   // return strBuff.toString();
				}
			  

				public static int findOccOfFirstDigit(String str) {				    
					
					char c;
				    int occurance = 0;
				    
				    
				    for (int i = 0; i < str.length() ; i++) {
				        c = str.charAt(i);
				        
				        if (Character.isDigit(c)) {
				        	occurance = i;				        	
				        	return i;				        				            
				        }
				    }
				    
				    return occurance;
				   // return strBuff.toString();
				}
			  


				public static StringBuffer  splitStringByNewLine(String message) {
					StringBuffer sb = new StringBuffer(); 
						 try{
							 String lines[] = message.split("\\r?\\n");
							 for (int i=0 ; i <lines.length ;i++) {
								 sb.append("<TR><TD>"+lines[i]+"</TD></TR>");
							}				
							
						  }catch (Exception ex){
							 ex.printStackTrace();		 
					      }
				  return sb;
				}	    

}
