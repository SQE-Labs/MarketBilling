package CommonMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
	public static String date1;

	public static String DateTimeGenerator() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		date1 = dateFormat.format(date);
		System.out.println(date1);
		return date1;
	}
	public static String DateGenerator() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		date1 = dateFormat.format(date);
		System.out.println(date1);
		return date1;
	}
}