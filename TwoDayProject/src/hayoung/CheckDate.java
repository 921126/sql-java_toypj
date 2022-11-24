package hayoung;

import java.text.SimpleDateFormat;

public class CheckDate {
	
	public static boolean checDate(String date) {
		
		try {
			SimpleDateFormat dfp = new SimpleDateFormat("yy-mm-dd");
			dfp.setLenient(false);
			dfp.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
