package com.ht.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static String convertDateToString(Date date) {
		return df.format(date);
	}

	public static Date convertStringToDate(String strDate) throws Exception {
		return df.parse(strDate);
	}
}
