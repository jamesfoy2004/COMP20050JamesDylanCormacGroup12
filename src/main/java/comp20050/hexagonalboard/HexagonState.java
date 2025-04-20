package comp20050.hexagonalboard;

import java.io.Serializable;

public class HexagonState implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hexID;
    private HexState state;

    public HexagonState(String hexID, HexState state) {
        this.hexID = hexID;
        this.state = state;
    }

    public String getHexID() {
        return hexID;
    }

    public void setHexID(String hexID) {
        this.hexID = hexID;
    }

    public HexState getState() {
        return state;
    }

    public void setState(HexState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Hexagon ID: " + hexID + " | State: " + state;
    }

}
