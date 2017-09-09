package de.ostfalia.gdp.ss15;

/**
 * Created by Maxi on 17.05.2015.
 * @author Maxi Henrik
 */
public class Lecture {

    private DateTime start;
    private DateTime end;
    private Room room;
    private String title;
    private String teacher;

    /**
     * empty constructor
     */
    public Lecture() {
    }

    /**
     * Constructor to directly create an object of lecture
     * @param start start of the lecture
     * @param end end of the lecture
     * @param room room of the lecture
     * @param title name of the lecture
     * @param teacher name of the teacher of the lecture
     */
    public Lecture(DateTime start, DateTime end, Room room, String title, String teacher) {
        this.start = start;
        this.end = end;
        this.room = room;
        this.title = title;
        this.teacher = teacher;
    }

    /**
     * als Zeichenkette ausgeben. Alle Attribute sollen ausgegeben
     * werden (mit ihren jeweiligen toString() Methoden, soweit nötig). Es soll auch die Dauer
     * ausgegeben werden (siehe getDurationString().
     * @return returns all the strings
     */
    public String toString() {
        return "Start of the lecture: " + start.toString() + "\n" +
                "End of the lecture: " + end.toString() + "\n" +
                "Duration of the class: " + getDurationString() + "\n" +
                "Room the lecture takes place: " + room.toString() + "\n" +
                "Name of the lecture: " + title + "\n" +
                "Name of the teacher: " + teacher + "\n";
    }

    /**
     * Dauer der Vorlesung in Millisekunden
     * @return the duration
     */
    public long getDuration() {
        return start.getDuration(end);
    }

    /**
     * Dauer der Vorlesung als Zeichenkette
     * @return the Duration as an String
     */
    public String getDurationString() {
        return start.getDurationString(end);
    }



    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
