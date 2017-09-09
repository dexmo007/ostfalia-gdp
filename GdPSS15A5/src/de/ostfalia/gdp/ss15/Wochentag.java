package de.ostfalia.gdp.ss15;

/**
 * Created by Henrik on 4/14/2015.
 * @author Henrik und Maximilian
 */
public class Wochentag {
    /**
     * tage in millisec
     */
    public static final int DAYS_TO_MILLISEC = 24 * 60 * 60 * 1000;
    /**
     * jahr in millisec
     */
    public static final long YEAR_TO_MILLISEC = 365 * 24 * 60 * 60 * 1000L;
    /**
     * schaltjahr in millisec
     */
    public static final long LEAPYEAR_TO_MILLISEC = 366 * 24 * 60 * 60 * 1000L;

    /**
     * calculates the weekday
      * @param millisekunden eingabe
     * @return wochentag
     */
    public static int wochentag(long millisekunden) {
        int wochentag = 4;
        int tageSeitStart = (int)(millisekunden / DAYS_TO_MILLISEC);
        wochentag = wochentag + (tageSeitStart % 7);
        if (wochentag % 7 == 0) {
            return 7;
        } else {
            return wochentag % 7;
        }
    }

    /**
     * wochentag als text
     * @param wochentag eingabe zahl
     * @return text
     */
    public static String wochentagString(int wochentag) {
        String result;
        switch (wochentag) {
            case 1:
                result = "Montag";
                break;
            case 2:
                result = "Dienstag";
                break;
            case 3:
                result = "Mittwoch";
                break;
            case 4:
                result = "Donnerstag";
                break;
            case 5:
                result = "Freitag";
                break;
            case 6:
                result = "Samstag";
                break;
            case 7:
                result = "Sonntag";
                break;
            default:
                result = "Fehler!";
                break;
        }
        return result;
    }

    /**
     * wochentag eines tages
     * @param tag tag
     * @param monat monat
     * @param jahr jahr
     * @return wochentag
     */
    public static int wochentag(int tag, int monat, int jahr) {
        int leapYearCounter = 0;
        int yearCounter = 0;
        int dayCounter = tag - 1 + (monat - 1) * 30;
        boolean leapYear = false;

        if (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)) {
            leapYear = true;
            for (int i = 1; i < monat; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    dayCounter++;
                } else if (i == 2) {
                    dayCounter--;
                }
            }
        } else {
            for (int i = 1; i < monat; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    dayCounter++;
                } else if (i == 2) {
                    dayCounter = dayCounter - 2;
                }
            }
        }
        int result = 0;
        if (tag > 31 && (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12)) {
            result = -1;
        } else if (tag > 30 && (monat == 4 || monat == 6 || monat == 9 || monat == 11)) {
            result = -1;
        } else if (tag > 29 && leapYear && monat == 2 || tag > 28 && !leapYear && monat == 2) {
            result = -1;
        } else if (jahr < 1970) {
            result = -1;
        }
        if (result == -1) {
            return -1;
        }


        for (int i = 1970; i < jahr; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                leapYearCounter++;
            } else {
                yearCounter++;
            }
        }
        long millisecs = (long)dayCounter * DAYS_TO_MILLISEC + (long)leapYearCounter
                * LEAPYEAR_TO_MILLISEC + (long)yearCounter * YEAR_TO_MILLISEC;
        return wochentag(millisecs);
    }

    /**
     * main
     * @param args argument
     */
    public static void main(String[] args) {

    }
}
