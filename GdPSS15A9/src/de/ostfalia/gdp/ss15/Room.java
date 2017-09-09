package de.ostfalia.gdp.ss15;

/**
 * Created by Maxi on 17.05.2015.
 *
 * @author Maxi Henrik
 */
public class Room {

    private String name;
    private boolean isLab;
    public static final int ONE_HUNDRED = 100;
    static Room[] rooms = new Room[ONE_HUNDRED];
    static int roomCounter;

    public Room() {
    }

    private Room(String name, boolean isLab) {
        this.name = name;
        this.isLab = isLab;
    }

    /**
     * liefert einen Raum zurück, wenn es ihn gibt, sonst null.
     * @param name name of the Room
     * @return <li>the fitting room</li>
     * <li>null, if the Room does not exist</li>
     */
    public static Room getRoom(String name) {
        for (Room room : rooms) {
            if (room != null) {
                if (room.getName().equals(name)) {
                    return room;
                }
            }
        }
        return null;
    }

    /**
     * Fügt einen neuen Raum zur Liste dazu und liefert ihn gleich zurück. Wenn der Raum schon existiert, wird der
     * existierende Raum zurückgeliefert und nicht erneut eingefügt. Wenn kein weiterer Raum eingefügt
     * werden kann, soll als Fehler null geliefert werden.
     *
     * @param name  name of the Room
     * @param labor true if the Room is a lab
     * @return <li> the created Room</li>
     * <li>null, if there is no more space</li>
     * <li>the old Room, if the Room already exists</li>
     */
    public static Room addRoom(String name, boolean labor) {
        if (getRoom(name) != null) {
            return getRoom(name);
        }
        if (roomCounter == ONE_HUNDRED) {
            return null;
        }
        rooms[roomCounter] = new Room(name, labor);
        roomCounter++;
        return rooms[roomCounter - 1];
    }

    /**
     * Raum als Zeichenkette ausgegeben. Labor: mit *, sonst mit -.
     * Beispiel: HS 252- oder P1*
     * @return String of the Room
     */
    public String toString() {
        if (isLab) {
            return name + "*";
        } else {
            return name + "-";
        }
    }

    /**
     * Ist der Raum ein Labor?
     *
     * @return boolean if the Room is a lab
     */
    public boolean isLab() {
        return isLab;
    }

    /**
     * getter für den Name
     * @return the name of the Room
     */
    public String getName() {
        return name;
    }
}
