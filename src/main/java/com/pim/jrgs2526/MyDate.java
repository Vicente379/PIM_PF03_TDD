package com.pim.jrgs2526;

import java.time.LocalDate;
import java.time.YearMonth;

public class MyDate {

    private int day;
    private Months month;
    private int year;

    public MyDate(int day, Months month, int year) {
        if (year < 0) throw new IllegalArgumentException(Errors.ERR_INVALID_DATE);

        int maxDaysInMonth = YearMonth.of(year, month.monthNumber).lengthOfMonth();
        if (day > maxDaysInMonth) throw new IllegalArgumentException(Errors.ERR_INVALID_DATE);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate() {

    }

    public void setMonth(Months month) {
        if (this.year < 1 || this.day < 1) throw new IllegalArgumentException(Errors.ERR_INVALID_MONTH);

        if (this.day > getLastDayOfTheMonth(month) ) throw new IllegalArgumentException(Errors.ERR_INVALID_MONTH);

        this.month = month;
    }

    private int getLastDayOfTheMonth(Months month) {
        if (this.year != 0) return 0;

        return YearMonth.of(year, month.monthNumber).lengthOfMonth();
    }

    public void setYear(int year) {

<<<<<<< HEAD
        if (year <= 0 || year > LocalDate.now().getYear() || !Year.isLeap(year)) {
            throw new IllegalArgumentException(Errors.ERR_INVALID_YEAR);
=======
        if (year <= 0 || year > LocalDate.now().getYear() || !isLeapYear(year)) {
            throw new IllegalArgumentException(ERR_INVALID_YEAR);
>>>>>>> parent of 2328289 (Update MyDate.java)
        }
        this.year = year;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public void setDay(int day) {

        if (day <= 0 || day > LocalDate.now().getDayOfMonth()) {
            throw new IllegalArgumentException(Errors.ERR_INVALID_DAY);
        }
        this.day = day;
    }


    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        public final int monthNumber;

        private Months(int monthNumber) {
            this.monthNumber = monthNumber;
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }
}
