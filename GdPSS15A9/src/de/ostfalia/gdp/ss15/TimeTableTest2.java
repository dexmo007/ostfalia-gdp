package de.ostfalia.gdp.ss15.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.ostfalia.gdp.ss15.Room;
import de.ostfalia.gdp.ss15.DateTime;
import de.ostfalia.gdp.ss15.TimeTable;
import de.ostfalia.gdp.ss15.Lecture;

public class TimeTableTest2 {

    DateTime mo1415, mo1545, di815, di1130, di1200, di1330, do815, do945;
    DateTime fr1000, fr1130, fr1200, fr1330, fr1415, fr1545;

    Lecture ds;
    Lecture ds2;
    Lecture gdp;
    Lecture gdp2;
    Lecture gdpLab;
    Lecture tdi;
    Lecture tdi2;

    Room hs252, rzP1, r111;

    TimeTable timeTable;

    @Before
    public void setUp() throws Exception {
        Room.addRoom("HS 252", false);
        Room.addRoom("RZ P1", true);
        Room.addRoom("R 11/1", false);

        mo1415 = new DateTime(18, 5, 2015, 14, 15);
        mo1545 = new DateTime(18, 5, 2015, 15, 45);
        di815 = new DateTime(19, 5, 2015, 8, 15);
        di1130 = new DateTime(19, 5, 2015, 11, 30);
        di1200 = new DateTime(19, 5, 2015, 12, 0);
        di1330 = new DateTime(19, 5, 2015, 13, 30);
        do815 = new DateTime(21, 5, 2015, 8, 15);
        do945 = new DateTime(21, 5, 2015, 9, 45);
        fr1000 = new DateTime(22, 5, 2015, 10, 0);
        fr1130 = new DateTime(22, 5, 2015, 11, 30);
        fr1200 = new DateTime(22, 5, 2015, 12, 0);
        fr1330 = new DateTime(22, 5, 2015, 13, 30);
        fr1415 = new DateTime(22, 5, 2015, 14, 15);
        fr1545 = new DateTime(22, 5, 2015, 15, 45);

        hs252 = Room.getRoom("HS 252");
        rzP1 = Room.getRoom("RZ P1");
        r111 = Room.getRoom("R 11/1");

        gdp = new Lecture(do815, do945, hs252, "Grundlagen des Programmierens", "Weimar");
        gdp2 = new Lecture(fr1000, fr1130, hs252, "Grundlagen des Programmierens", "Weimar");
        gdpLab = new Lecture(di815, di1130, rzP1, "Grundlagen des Programmierens (Labor) ", "Weimar");
        ds = new Lecture(di1200, di1330, hs252, "Diskrete Strukturen", "Mengersen");
        ds2 = new Lecture(fr1200, fr1330, hs252, "Diskrete Strukturen", "Mengersen");
        tdi = new Lecture(mo1415, mo1545, r111, "Technik der Informatik", "Dammann");
        tdi2 = new Lecture(fr1415, fr1545, r111, "Technik der Informatik", "Dammann");


        // timeTable = new TimeTable(new DateTime(13, 6, 2015, 0, 0));
        timeTable = new TimeTable();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(timeout = 300)
    public void testTimeTable() {
        assertNotNull("timetable sollte nicht null sein!", timeTable);
    }

    @Test(timeout = 300)
    public void testAllBetween() {
        timeTable.add(gdp);
        timeTable.add(gdp2);
        timeTable.add(gdpLab);
        timeTable.add(ds);
        timeTable.add(ds2);
        timeTable.add(tdi);
        timeTable.add(tdi2);

        DateTime dtstart = new DateTime(18, 5, 2015, 7, 0);
        DateTime dtend = new DateTime(22, 5, 2015, 16, 0);

        String res = timeTable.allBetween(dtstart, dtend);
        assertTrue("timeTable.allBetween ist " + res + " aber sollte Montag .. Technik enthalten",
                res.contains("Montag") && res.contains("Technik"));
        assertTrue("timeTable.allBetween ist " + res + " aber sollte Dienstag .. Labor .. Diskrete enthalten",
                res.contains("Dienstag") && res.contains("Labor") && res.contains("Diskrete"));

        assertFalse("diary.allBetween ist " + res + " aber sollte nicht Mittwoch enthalten",
                res.contains("Mittwoch"));
    }

    @Test(timeout = 300)
    public void testAllDay() {
        timeTable.add(gdp);
        timeTable.add(gdp2);
        timeTable.add(gdpLab);
        timeTable.add(ds);
        timeTable.add(ds2);
        timeTable.add(tdi);
        timeTable.add(tdi2);

        DateTime dtday = new DateTime(22, 5, 2015, 7, 0);

        String res = timeTable.allDay(dtday);
        assertTrue("timeTable.allDay ist " + res + " aber sollte Grundlagen des Programmierens und Freitag enthalten",
                res.contains("Grundlagen")
        );

        assertTrue("timeTable.allDay ist " + res + " aber sollte Freitag enthalten",
                res.contains("Freitag")
        );

        assertTrue("timeTable.allDay ist " + res + " aber sollte die Dauer 1:30 enthalten",
                res.contains("1:30")
        );

        assertFalse("timeTable.allDay ist " + res + " aber sollte Labor und 3:15 nicht enthalten",
                res.contains("Labor") || res.contains("3:15")
        );

    }

    @Test(timeout = 300)
    public void testAllinRoom() {
        timeTable.add(gdp);
        timeTable.add(gdp2);
        timeTable.add(gdpLab);
        timeTable.add(ds);
        timeTable.add(ds2);
        timeTable.add(tdi);
        timeTable.add(tdi2);

        String res = timeTable.allinRoom(hs252);

        assertTrue("diary.allinRoom() ist " + res + " aber sollte Grundlagen des Programmierens und 1:30 enthalten",
                res.contains("Freitag") && res.contains("Grundlagen")
                        && res.contains("1:30")
        );

        assertTrue("diary.allinRoom() ist " + res + " aber sollte Diskrete Strukturen und Dienstag enthalten",
                res.contains("Diskrete") && res.contains("Dienstag"));

        assertFalse("diary.allinRoom() ist " + res + " aber sollte nicht das Labor enthalten",
                res.contains("Labor") || res.contains("3:15")
        );

        assertFalse("diary.allinRoom() ist " + res + " aber sollte nicht Technik oder Dammann enthalten",
                res.contains("Technik") || res.contains("Dammann"));
    }

    @Test(timeout = 300)
    public void testFractionLab() {
        timeTable.add(gdp);
        timeTable.add(gdp2);
        timeTable.add(gdpLab);
        timeTable.add(ds);
        timeTable.add(ds2);
        timeTable.add(tdi);
        timeTable.add(tdi2);

        DateTime dtstart = new DateTime(18, 5, 2015, 7, 0);
        DateTime dtend = new DateTime(22, 5, 2015, 16, 0);

        double res = timeTable.fractionLab(dtstart, dtend);
        assertEquals("fractionLab false", ((195.0) / (540.0 + 195.0)), res, 0.01);
    }

    @Test(timeout = 300)
    public void testFractionLab2() {
        timeTable.add(gdp);
        timeTable.add(gdp2);
        timeTable.add(gdpLab);
        timeTable.add(ds);
        timeTable.add(ds2);
        timeTable.add(tdi);
        timeTable.add(tdi2);

        DateTime dtstart = new DateTime(18, 5, 2015, 7, 0);
        DateTime dtend = new DateTime(21, 5, 2015, 16, 0);

        double res = timeTable.fractionLab(dtstart, dtend);
        assertEquals("fractionLab false", (195.0 / (270.0 + 195.0)), res, 0.01);
    }
}

