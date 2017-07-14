package com.report.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String getDateInFormat(String dateString)
	{
		SimpleDateFormat dateFormat= new SimpleDateFormat("YYYYMMddHHmmss");
		Date date=null;
		try {
			date=dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dateFinal= date.toString();
		return dateFinal;
		
	}
	public static String getDateInFormat(Date dateString)
	{
		SimpleDateFormat dateFormat= new SimpleDateFormat("YYYYMMddHHmmss");
		String	dateFinal=dateFormat.format(dateString);
		return dateFinal;
		
	}

}
