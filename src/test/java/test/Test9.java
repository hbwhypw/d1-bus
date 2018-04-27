package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test9 {

	
	public static void main(String[] args) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse("2015-12-23");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		boolean before = date.before(new Date());
		
		System.out.println(before);
		
	}
	
}
