package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        LocalDate res = LocalDate.parse(date);
        res = res.plusDays(1);
        return String.valueOf(res);
    }

    @Override
    public int getMonthFromDate(String date) throws ParseException {
        Date formatter = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.ENGLISH).parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter);
        return cal.get(Calendar.MONTH) + 1;
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        LocalDateTime first = LocalDateTime.parse(date1.replace(" ", "T"));
        LocalDateTime second = LocalDateTime.parse(date2.replace(" ", "T"));
        LocalDateTime third = LocalDateTime.parse(date3.replace(" ", "T"));
        List<LocalDateTime> res = new ArrayList<>();
        res.add(first);
        res.add(second);
        res.add(third);
        Collections.sort(res);
        LocalDateTime date = res.get(res.size()-1);
        String s = String.valueOf(date);
        s = s.replace("T", " ");
        return s;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate d = LocalDate.parse(date);
        Temporal res = TemporalAdjusters.lastDayOfMonth().adjustInto(d);
        return String.valueOf(res);
    }

    @Override
    public String sumTimes(String time1, String time2) throws ParseException {
        Date format1 = new SimpleDateFormat("HH:mm:ss").parse(time1);
        Date format2 = new SimpleDateFormat("HH:mm:ss").parse(time2);
        return null;
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        return null;
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        return -1;
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        return null;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        return -1;
    }
}
