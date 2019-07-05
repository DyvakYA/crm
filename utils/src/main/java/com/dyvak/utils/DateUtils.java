package com.dyvak.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    private static final String XML_DATE_PATTERN = "dd-MM-yyyy";
    private static final String XML_DATE_ALTERNATIVE_PATTERN = "yyyy-MM-dd";
    private static final String XML_DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";
    private static final String EPOLICY_XML_DATE_PATTERN = "yyyyMMdd";
    private static final String EPOLICY_XML_DATE_TIME_PATTERN = "yyyyMMdd HH:mm:ss";
    private static final String XML_REVERSE_DATE_PATTERN = "yyyy-MM-dd";
    private static final String XML_REVERSE_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String XML_VIDI_DATE_TIME_PATTERN = "dd.MM.yyyy HH:mm:ss";

    public static Date asAnyDate(String get, String format) {
        if (get == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(get);
        } catch (ParseException e) {
        }
        return asDate(get);
    }

    public static Date asEPolicyDate(String get) {
        if (get == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(get);
        } catch (ParseException e) {
        }
        return asDate(get);
    }

    public static Date asReversedDate(String get) {
        if (get == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(get);
        } catch (ParseException e) {
        }
        return asDate(get);
    }

    public static Date asReversedDateTime(String get) {
        if (get == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(get);
        } catch (ParseException e) {
        }
        return asDate(get);
    }

    public static Date asDateTime(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(dateStr);
        } catch (ParseException e) {
        }
        return asDate(dateStr);
    }

    public static Date asDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
        } catch (ParseException e) {
        }
        return asDateAlternative(dateStr);
    }

    private static Date asDateAlternative(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
        }
        return null;
    }

    public static String asString(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    public static String asStringAnyFormat(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static String asStringWithTime(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
    }

    public static long differenceInMonths(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        long diff = 0L;
        if (c2.after(c1)) {
            while (c2.after(c1)) {
                c1.add(2, 1);
                if (c2.after(c1)) {
                    diff += 1L;
                }
            }
        }
        if (c2.before(c1)) {
            while (c2.before(c1)) {
                c1.add(2, -1);
                if (c1.before(c2)) {
                    diff -= 1L;
                }
            }
        }
        return diff;
    }

    public static long differenceInDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / 86400000L;

        return diffDays;
    }

    public static int differenceInYears(Date d1, Date d2) {
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(d1);
        Calendar secondCalendar = Calendar.getInstance();
        secondCalendar.setTime(d2);

        int year = 1;
        int month = 2;
        int difference = secondCalendar.get(year) - firstCalendar.get(year);
        if ((difference > 0) && (secondCalendar.get(month) < firstCalendar.get(month))) {
            difference--;
        }
        return difference;
    }
}


