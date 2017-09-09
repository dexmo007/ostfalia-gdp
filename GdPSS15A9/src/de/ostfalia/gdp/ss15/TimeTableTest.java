package de.ostfalia.gdp.ss15.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.ostfalia.gdp.ss15.Room;
import de.ostfalia.gdp.ss15.DateTime;
import de.ostfalia.gdp.ss15.TimeTable;
import de.ostfalia.gdp.ss15.Lecture;

public class TimeTableTest {

    DateTime d1,d2, d3, d4;

    Lecture ts1;
    Lecture ts2;

    Room hs252, rzP1;

    TimeTable timeTable;

    @Before
    public void setUp() throws Exception {
        Room.addRoom("HS 252",false);
        Room.addRoom("RZ P1",true);

        d1 = new DateTime(4, 3, 2015, 8, 15);
        d2 = new DateTime(4, 3, 2015, 9, 45);
        d3 = new DateTime(10, 3, 2015, 8, 15);
        d4 = new DateTime(10, 3, 2015, 11, 30);

        hs252 = Room.getRoom("HS 252");
        rzP1 = Room.getRoom("RZ P1");

        ts1 = new Lecture(d1, d2, hs252, "Grundlagen des Programmierens", "Weimar");
        ts2 = new Lecture(d3, d4, rzP1, "Grundlagen des Programmierens (Labor) ", "Weimar");

        // timeTable = new TimeTable(new DateTime(13, 6, 2015, 0, 0));
        timeTable = new TimeTable();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(timeout=300)
    public void testTimeTable() {
        assertNotNull("timetable sollte nicht null sein!",timeTable);
    }

    @Test(timeout=300)
    public void testAdd() {
        timeTable.add(ts1);
    }

    @Test(timeout=300)
    public void testAllBetween() {
        timeTable.add(ts1);
        timeTable.add(ts2);

        DateTime dtstart = new DateTime(4, 3, 2015, 00, 05);
        DateTime dtend = new DateTime(4, 3, 2015, 23, 59);

        String res = timeTable.allBetween(dtstart, dtend);
        assertTrue("timeTable.allBetween ist "+res+" aber sollte Grundlagen ... Mittwoch.. 1:30 .. enthalten",
                res.contains("Mittwoch") && res.contains("Grundlagen")
                        && res.contains("1:30")
        );

        assertFalse("diary.allBetween ist "+res+" aber sollte nicht das Labor enthalten",
                res.contains("Labor") || res.contains("3:15")
        );


    }

    @Test(timeout=300)
    public void testAllDay() {
        timeTable.add(ts1);
        timeTable.add(ts2);

        DateTime dtday = new DateTime(4, 3, 2015, 0, 05);

        String res = timeTable.allDay(dtday);
        assertTrue("timeTable.allDay ist "+res+" aber sollte Grundlagen des Programmierens und Mittwoch enthalten",
                res.contains("Grundlagen")
        );

        assertTrue("timeTable.allDay ist "+res+" aber sollte Mittwoch enthalten",
                res.contains("Mittwoch")
        );

        assertTrue("timeTable.allDay ist "+res+" aber sollte die Dauer 1:30 enthalten",
                res.contains("1:30")
        );

        assertFalse("timeTable.allDay ist "+res+" aber sollte Labor und 3:15 nicht enthalten",
                res.contains("Labor") ||res.contains("3:15")
        );

    }

    @Test(timeout=300)
    public void testAllinRoom() {
        timeTable.add(ts1);
        timeTable.add(ts2);

        String res = timeTable.allinRoom(hs252);

        assertTrue("diary.allinRoom() ist "+res+" aber sollte Grundlagen des Programmierens und 1:30 enthalten",
                res.contains("Mittwoch") && res.contains("Grundlagen")
                        && res.contains("1:30")
        );

        assertFalse("diary.allinRoom() ist "+res+" aber sollte nicht das Labor enthalten",
                res.contains("Labor") ||res.contains("3:15")
        );

    }

    @Test(timeout=300)
    public void testFractionLab() {
        timeTable.add(ts1);
        timeTable.add(ts2);

        DateTime dtstart = new DateTime(9, 3, 2015, 00, 05);
        DateTime dtend = new DateTime(15, 3, 2015, 23, 00);


        double res = timeTable.fractionLab(dtstart, dtend);
        assertEquals("fractionLab false", (195.0/(90+195)), res, 0.01);
    }

    @Test(timeout=300)
    public void testFractionLab2() {
        timeTable.add(ts1);
        timeTable.add(ts2);
        DateTime d5 = new DateTime(10, 3, 2015, 12, 30);

        Lecture ts3 = new Lecture(d4, d5, rzP1, "Nachsitzen", "Dick-Anwander");
        timeTable.add(ts3);

        DateTime dtstart = new DateTime(9, 3, 2015, 00, 05);
        DateTime dtend = new DateTime(15, 3, 2015, 23, 00);


        double res = timeTable.fractionLab(dtstart, dtend);
        assertEquals("fractionLab false", ((195.0+60)/(90+195+60)), res, 0.01);
    }

}
