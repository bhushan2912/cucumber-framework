package org.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintDateEx {

	public static void main(String[] args) {
			Date d = new Date();
			System.out.println(d);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String date = sdf.format(d);
			System.out.println(date);
			date = date.replaceAll("/", "").replaceAll(" ", "").replaceAll(":", "");
			System.out.println(date);
			
	}
}