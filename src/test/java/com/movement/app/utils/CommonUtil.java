package com.movement.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class CommonUtil {

	private static Logger logger = Logger.getLogger(CommonUtil.class.getName());

    public static String setParameterValue(String defaultValue, String passedValue) {
        String parameterValue = StringUtils.isNotBlank(passedValue) ? passedValue : defaultValue;
        return parameterValue;
    }

    public static void staticWaitFor(Long milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * This method will convert date string from one format to another format
     * @param inputDateString
     * @param formatIn
     * @param formatOut
     * @return formated date
     */
    public static String dateFormatConvertor(String inputDateString,String formatIn, String formatOut) {

        SimpleDateFormat inputFormat = new SimpleDateFormat(formatIn);
        SimpleDateFormat outputFormat = new SimpleDateFormat(formatOut);
        Date inputDate = null;

        try {
            inputDate = inputFormat.parse(inputDateString);
        } catch (ParseException e) {
            logger.severe("Parse Exception occurred while parsing the date : "+inputDateString+"to the format:"+formatIn);
            return inputDateString;
        }

        String outputDateString = outputFormat.format(inputDate);

        return outputDateString;
    }

    public static String generateNineDigitNumber() {
        String nowString = new java.text.SimpleDateFormat("yyMMdd").format(DateTime.now().toDate());
        String id = nowString.concat(String.valueOf(100 + (int)(Math.random()*((999-100)+1))));

        return id;
    }
    
    public static String generatetwelveDigitNumber() {
        String nowString = new java.text.SimpleDateFormat("yyyyMMdd").format(DateTime.now().toDate());
        String id = nowString.concat(String.valueOf(10000 + (int)(Math.random()*((999-100)+1))));

        return id;
    }
}
