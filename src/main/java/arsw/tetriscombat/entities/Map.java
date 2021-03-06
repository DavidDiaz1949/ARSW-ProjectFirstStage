package arsw.tetriscombat.entities;

import java.io.Serializable;

/**
 * Class Map that defines the
 * Maps used by a Player
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class Map implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String type;
    private String difficulty;
    private int time;
    private String remainingTime;
    private boolean endgameStatus;
    private Room room;

    //Constructors

    public Map() {
    }

    public Map(int id) {
        this.id = id;
    }

    public Map(int id, String name, String type, String difficulty) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.difficulty = difficulty;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isEndgameStatus() {
        return endgameStatus;
    }

    public void setEndgameStatus(boolean endgameStatus) {
        this.endgameStatus = endgameStatus;
    }
    
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    
    //To String

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", time=" + time +
                ", remainingTime='" + remainingTime + '\'' +
                ", endgameStatus=" + endgameStatus +
                ", room=" + room +
                '}';
    }
}
