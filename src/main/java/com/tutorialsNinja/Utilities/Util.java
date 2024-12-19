package com.tutorialsNinja.Utilities;

import java.util.Date;

public class Util {

	public static String emailWithDateTimeStamp() {
		Date d = new Date();
		String em = d.toString().replace(" ", "_").replace(":", "_");
		return "selenium" + em + "@gmail.com";
		
	}
	
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGWLOAD_TIME_WAIT = 100;
	public static final int SCRIPT_TIME_WAIT = 1000;
}
