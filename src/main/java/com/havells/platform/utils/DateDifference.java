package com.havells.platform.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
  
public class DateDifference  {
  
	
    public DateDifference() {
		super();
	}

	public static long findDifferenceInMinutes(String start_date,String end_date)
    {
  
         SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try {
  
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
  
            long differenceInTime = d2.getTime() - d1.getTime();
  
            long differenceInMinutes = (differenceInTime / (1000 * 60)) % 60;
            return differenceInMinutes;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
		return 0;
    }
	public static long findDifferenceInHours(String start_date,String end_date)
    {
  
         SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try {
  
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
  
            long differenceInTime = d2.getTime() - d1.getTime();
  
            long differenceInHours = (differenceInTime / (1000 * 60 * 60)) % 24;
            return differenceInHours;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
		return 0;
    }
	public static long findDifferenceInDays(String start_date,String end_date)
    {
  
         SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try {
  
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
  
            long differenceInTime = d2.getTime() - d1.getTime();
            long differenceInDays  = (differenceInTime/ (1000 * 60 * 60 * 24)) % 365;
            return differenceInDays;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
		return 0;
    }
	public static long findDifferenceInYears(String start_date,String end_date)
    {
  
         SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try {
  
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
  
            long differenceInTime = d2.getTime() - d1.getTime();
  
            long differenceInYears = (differenceInTime / (1000l * 60 * 60 * 24 * 365));
            return differenceInYears;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
		return 0;
    }
	
  
 }