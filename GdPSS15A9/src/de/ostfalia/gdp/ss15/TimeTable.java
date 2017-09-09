package de.ostfalia.gdp.ss15;

/**
 * Created by Maxi on 17.05.2015.
 * @author Maxi Henrik
 */
public class TimeTable {
    public final int oneHundred = 100;
    private Lecture[] slots = new Lecture[oneHundred];
    private int numberOfEntries;

    public TimeTable() {
    }

    private TimeTable(Lecture[] slots, int numberOfEntries) {
        this.slots = slots;
        this.numberOfEntries = numberOfEntries;
    }

    public void add(Lecture lecture) {
        if (numberOfEntries == oneHundred) {
            System.out.println("Fehler!");
        }
        slots[numberOfEntries] = lecture;
        numberOfEntries++;
    }

    public String allBetween(DateTime start, DateTime end) {
        String allBetween = "";
        for (Lecture lect : slots) {
            if (lect != null) {
                if (lect.getStart().isAfter(start, true) && lect.getEnd().isBefore(end, true)) {
                    allBetween = allBetween + lect.toString();
                }
            }
        }
        return allBetween;
    }

    public String allDay(DateTime day) {
        String allDay = "";
        for (Lecture lect : slots) {
            if (lect != null) {
                if (lect.getStart().dayOfWeekInt() == day.dayOfWeekInt()) {
                    allDay = allDay + lect.toString() + "\n";
                }
            }
        }
        return allDay;
    }

    public String allinRoom(Room room) {
        String allinRoom = "";
        for (Lecture lect : slots) {
            if (lect != null) {
                if (lect.getRoom().equals(room)) {
                    allinRoom = allinRoom + lect.toString() + "\n";
                }
            }
        }
        return allinRoom;
    }

    public double fractionLab(DateTime start, DateTime end) {
        double allLects = 0;
        double labs = 0;
        for (Lecture lect : slots) {
            if (lect != null) {
                long lectLength = lect.getDuration();
                if (start.isBefore(lect.getStart())) {
                    allLects = allLects + lectLength;
                    if (lect.getRoom().isLab()) {
                        labs = labs + lectLength;
                    }
                }
                allLects = allLects + lect.getStart().getDuration(end) / DateTime.WEEKS_TO_MILLISEC * lectLength;
                if (lect.getRoom().isLab()) {
                    labs = labs + lect.getStart().getDuration(end) / DateTime.WEEKS_TO_MILLISEC * lectLength;
                }
                if (end.isBefore(lect.getEnd())) {
                    allLects = allLects - lectLength;
                    if (lect.getRoom().isLab()) {
                        labs = labs - lectLength;
                    }
                }
            }
        }
        return labs / allLects;
    }
}
