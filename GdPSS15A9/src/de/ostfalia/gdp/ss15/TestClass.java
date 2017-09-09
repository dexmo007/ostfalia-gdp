package de.ostfalia.gdp.ss15;

/**
 * Created by Henrik on 5/19/2015.
 */
public class TestClass {
    public static void main(String[] args) {

        TimeTable timeTable = new TimeTable();

        Room.addRoom("HS 252", false);
        Room.addRoom("RZ P1", true);
        Room.addRoom("Pool 132", true);
        Room kirche = Room.getRoom("HS 252");
        System.out.println("kirche ist: "+kirche);
        DateTime ersterErster1975 =
                new DateTime(1, 1, 1975, 0, 0);
        // Erzeugen und dann Attribute füllen
        Lecture lect = new Lecture();
        lect.setStart(new DateTime(18, 5, 2015, 19, 0));
        lect.setEnd(new DateTime(19, 5, 2015, 8, 0));
        lect.setRoom(kirche);
        lect.setTitle("Freizeit");
        System.out.println("Lecture: " + lect);
        timeTable.add(lect);
        // erzeugen mit Konstruktor
        Lecture lect2 = new Lecture(DateTime.today(8, 15), DateTime.today(9, 45),
                Room.getRoom("RZ P1"), "Grundlagen des Programmmierens (Labor)", "Weimar");
        timeTable.add(lect2);
        // Alle ausdrucken
        System.out.println(timeTable.allBetween(
                ersterErster1975, new DateTime()));


    }

}
