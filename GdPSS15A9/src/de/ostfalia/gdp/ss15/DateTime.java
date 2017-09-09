package de.ostfalia.gdp.ss15;

/**
 * Created by Maxi on 11.05.2015.
 * @author Henrik Maxi
 */
public class DateTime {
    public static final int THREE_HUNDRET_SIXTYSIX = 366;
    public static final int TEN = 10;
    private long milliseconds;

    public final int daysInYear = 365;
    public static final int YEAR_1969 = 1969;
    public static final int MONTHS_IN_YEAR = 12;
    public final int year1970 = 1970;
    public static final long THOUSAND = 1000L;
    public static final int SIXTY = 60;
    public static final int TWENTY_FOUR = 24;
    private static final long DAYS_TO_MILLISEC = TWENTY_FOUR * SIXTY * SIXTY * THOUSAND;
    private static final long HOURS_TO_MILLISEC = SIXTY * SIXTY * THOUSAND;
    private static final long MINUTES_TO_MILLISEC = SIXTY * THOUSAND;
    public static final long WEEKS_TO_MILLISEC = 7 * DAYS_TO_MILLISEC;
    public static final int DAYS_IN_MONTH = 30;
    public static final int THIRTY_ONE = 31;
    private static final int[] TAGE_IM_MONAT
            = {0, THIRTY_ONE, 28, THIRTY_ONE, DAYS_IN_MONTH, THIRTY_ONE, DAYS_IN_MONTH, THIRTY_ONE,
            THIRTY_ONE, DAYS_IN_MONTH, THIRTY_ONE, DAYS_IN_MONTH, THIRTY_ONE};
    private static final int HUNDRED = 100;
    private static final int FOURHUNDRED = 400;

    public DateTime() {
        milliseconds = System.currentTimeMillis();
        //erzeugt ein Objekt, das den aktuellen Zeitpunkt repräsentiert
        // (Hinweis: Verwenden Sie System.currentTimeMillis())
    }

    public DateTime(int day, int month, int year, int hour, int minute) {
//        erzeugt ein Objekt, das den angebenen Zeitpunkt, repräsentiert.
        int leapYearCounter = 0;
        int yearCounter = 0;
        int dayCounter = day - 1 + (month - 1) * DAYS_IN_MONTH;
        boolean leapYear = year % 4 == 0 && (year % HUNDRED != 0 || year % FOURHUNDRED == 0);

        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == TEN || i == MONTHS_IN_YEAR) {
                dayCounter++;
            } else if (i == 2 && leapYear) {
                dayCounter--;
            } else if (i == 2 && !leapYear) {
                dayCounter = dayCounter - 2;
            }
        }

//        int result = 0;
//        if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
//            result = -1;
//        } else if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
//            result = -1;
//        } else if (day > 29 && leapYear && month == 2 || day > 28 && !leapYear && month == 2) {
//            result = -1;
//        } else if (year < 1970) {
//            result = -1;
//        } else if (hour > 23) {
//            result = -1;
//        } else if (minute > 59) {
//            result = -1;
//        }
//        if (result == -1) {
//            milliseconds = 0;
//        }

        for (int i = year1970; i < year; i++) {
            if (i % 4 == 0 && (i % HUNDRED != 0 || i % FOURHUNDRED == 0)) {
                leapYearCounter++;
            } else {
                yearCounter++;
            }
        }
        long yearToMillisec = daysInYear * TWENTY_FOUR * SIXTY * SIXTY * THOUSAND;
        long leapyearToMillisec = THREE_HUNDRET_SIXTYSIX * TWENTY_FOUR * SIXTY * SIXTY * THOUSAND;
        milliseconds = dayCounter * DAYS_TO_MILLISEC + leapYearCounter
                * leapyearToMillisec + yearCounter * yearToMillisec;
        milliseconds = milliseconds + hour * HOURS_TO_MILLISEC + minute * MINUTES_TO_MILLISEC;
    }

    private static boolean istSchaltJahr(int jahr) {
        return (jahr % 4 == 0 &&
                !(jahr % HUNDRED == 0 &&
                        !(jahr % FOURHUNDRED == 0)));
    }
    private static int tageImMonat(int monat, boolean schaltjahr) {
        return TAGE_IM_MONAT[monat] + ((schaltjahr && monat == 2) ? 1 : 0);
    }
    /**
     *  erzeugt ein neues Object mit dem selben Tag wie day, aber Stunde und Minute neu gesetzt.
     * @param day DateTime in Millisekunden
     * @param hour Tageszeit Stunde
     * @param minute Tageszeit Minute
     */
    public DateTime(DateTime day, int hour, int minute) {
        long dayInDays = day.milliseconds / DAYS_TO_MILLISEC;
        milliseconds = dayInDays * DAYS_TO_MILLISEC + (hour) * HOURS_TO_MILLISEC
                + (minute) * MINUTES_TO_MILLISEC;
    }

    /**
     * Heute, mit Stunde, Minute.
     * @param hour Stunde heute
     * @param minute Minute in der Stunde
     * @return DateTime in millisec
     */
    public static DateTime today(int hour, int minute) {
        long ms = System.currentTimeMillis() / DAYS_TO_MILLISEC;
        ms = ms * DAYS_TO_MILLISEC + (hour) * HOURS_TO_MILLISEC + (minute) * MINUTES_TO_MILLISEC;
        DateTime out = new DateTime();
        out.milliseconds = ms;
        return out;
    }

    /**
     * erzeut ein neues DateTime Objekt, wobei der Zeitpunkt um number Tage verschoben ist (früher, wenn anzahl < 0)
     * @param number Tage um die verschoben werden soll
     * @return DateTime mit number Tagen später
     */
    public DateTime daysLater(int number) {
        long laterMs = milliseconds + number * DAYS_TO_MILLISEC;
        DateTime out = new DateTime();
        out.milliseconds = laterMs;
        return out;
    }

    private static int monat(int tage, boolean schaltjahr) {
        int x = 0;
        for (int i = 1; i <= MONTHS_IN_YEAR; i++) {
            x += tageImMonat(i, schaltjahr);
            if (tage < x) {
                return i;
            }
        }
        return 0;
    }

    private static int schaltJahreSeitBeginn(int jahr) {
        return (jahr - YEAR_1969) / 4;
    }

    private static int tageInVormonaten(int monat, boolean schaltjahr) {
        int out = 0;
        for (int i = 1; i < monat; i++) {
            out = out + TAGE_IM_MONAT[i];
        }
        return out + ((schaltjahr && monat == 2) ? 1 : 0);
    }

    /**
     * Datum als String liefern
     * @return Datum als String
     */
    public String getDate() {
        int tage = (int) (milliseconds / DAYS_TO_MILLISEC);
        int jahrSchaetzung = tage / daysInYear + year1970;
        int jahre = (tage - schaltJahreSeitBeginn(jahrSchaetzung))
                / daysInYear;
        int jahreszahl = year1970 + jahre;
        int restTage = tage - jahre * daysInYear
                - schaltJahreSeitBeginn(jahreszahl);
        int monat = monat(restTage, istSchaltJahr(jahreszahl));
        int tag = restTage + 1 - tageInVormonaten(monat, istSchaltJahr(jahreszahl));
        return tag + "." + monat + "." + jahreszahl;
    }

    /**
     * Zeit als String liefern
     * @return String der Uhrzeit
     */
    public String getTime() {
        long hours = (milliseconds % DAYS_TO_MILLISEC) / HOURS_TO_MILLISEC;
        long minutes = ((milliseconds % DAYS_TO_MILLISEC) % HOURS_TO_MILLISEC) / MINUTES_TO_MILLISEC;
        return hours + ":" + minutes;
    }

    /**
     * Wochentag als Integer liefern (1=Montag, .. 7=Sonntag)
     * @return Wochentag als int
     */
    public int dayOfWeekInt() {
        int wochentag = 4;
        int tageSeitStart = (int) (milliseconds / DAYS_TO_MILLISEC);
        wochentag = wochentag + (tageSeitStart % 7);
        if (wochentag % 7 == 0) {
            return 7;
        } else {
            return wochentag % 7;
        }
    }

    /**
     * Wochentag als String liefern
     * @return ausgeschriebener Wochentag
     */
    public String dayOfWeek() {
        String out;
        switch (dayOfWeekInt()) {
            case 1:
                out = "Montag";
                break;
            case 2:
                out = "Dienstag";
                break;
            case 3:
                out = "Mittwoch";
                break;
            case 4:
                out = "Donnerstag";
                break;
            case 5:
                out = "Freitag";
                break;
            case 6:
                out = "Samstag";
                break;
            case 7:
                out = "Sonntag";
                break;
            default:
                return "Fehler!";
        }
        return out;
    }

    /**
     * Zeitdifferenz zu start in Millisekunden
     * @param start Start DateTime
     * @return Differenz in millisek
     */
    public long getDuration(DateTime start) {
        return Math.abs(milliseconds - start.milliseconds);
    }

    /**
     * Zeitdifferenz als Zeichenkette(Wochen,Tage,Zeit)
     * @param start Start DateTime
     * @return Zeitdifferenz als Zeichenkette(Wochen,Tage,Zeit)
     */
    public String getDurationString(DateTime start) {
        long duration = getDuration(start);
        long weeks = duration / WEEKS_TO_MILLISEC;
        int days = (int) ((duration % WEEKS_TO_MILLISEC) / DAYS_TO_MILLISEC);
        int hours = (int) (((duration % WEEKS_TO_MILLISEC) % DAYS_TO_MILLISEC) / HOURS_TO_MILLISEC);
        int minutes = (int) ((((duration % WEEKS_TO_MILLISEC) % DAYS_TO_MILLISEC)
                % HOURS_TO_MILLISEC) / MINUTES_TO_MILLISEC);
        if (weeks == 0 && days == 0) {
            return hours + ":" + minutes;
        } else if (weeks == 0) {
            return days + " Tag(e), " + hours + ":" + minutes;
        } else {
            return weeks + " Woche(n), " + days + " Tag(e), " + hours + ":" + minutes;
        }
    }

    public boolean isWeekday() {
        int weekday = dayOfWeekInt();
        return weekday == 1 || weekday == 2 || weekday == 3 || weekday == 4 || weekday == 5;
        //    wahr, wenn Montag-Freitag
    }


    public String toString() {
        return dayOfWeek() + ", " + getDate() + " " + getTime();
//    Datum als Zeichenkette, Beispiel: Dienstag, 3.12.2013 15:30
    }


    public boolean isAfter(DateTime other) {
        return milliseconds > other.milliseconds;
//    liegt das aktuelle Objekt hinter other?
    }


    public boolean isBefore(DateTime other) {
        return milliseconds < other.milliseconds;
//    liegt das aktuelle Objekt vor other?
    }


    public boolean isAfter(DateTime other, boolean ignoreWeek) {
        long time = milliseconds % DAYS_TO_MILLISEC;
        long oTime = other.milliseconds % DAYS_TO_MILLISEC;
        if (ignoreWeek) {
            if (dayOfWeekInt() == other.dayOfWeekInt()) {
                return time > oTime;
            } else {
                return dayOfWeekInt() > other.dayOfWeekInt();
            }
        } else {
            return isAfter(other);
        }
//    liegt das aktuelle
//    Objekt hinter other, wenn man die Woche ignoriert (wird für einen Stundenplan benötigt)?
    }


    public boolean isBefore(DateTime other, boolean ignoreWeek) {
        long time = milliseconds % DAYS_TO_MILLISEC;
        long oTime = other.milliseconds % DAYS_TO_MILLISEC;
        if (ignoreWeek) {
            if (dayOfWeekInt() == other.dayOfWeekInt()) {
                return time < oTime;
            }
            return dayOfWeekInt() < other.dayOfWeekInt();
        } else {
            return isBefore(other);
        }
//    liegt das
//    aktuelle Objekt vor other, wenn man die Woche ignoriert (wird für einen Stundenplan benötigt)?
    }
}
