package dao.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetOrdersnOrCurrentTime {
	public static String GetOrdersn(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		StringBuffer time2 = new StringBuffer(time);
		time2.replace(4, 5, "");
		time2.replace(6, 7, "");
		time2.replace(8, 9, "");
		time2.replace(10,11, "");
		time2.replace(12, 13, "");
		time = time2.toString();
		return time;
	}
	public static String GetCurrentTime(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		return time;
	}
	
	
}
