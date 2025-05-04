package comp20050.hexagonalboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.*;
import java.util.List;

/**
 * Utility class for saving and loading the state of a hexagonal board game.
 */
public class SaveAndLoad {

    /**
     * Saves the current board state to the specified save slot, only if it's Player One's turn.
     *
     * @param hexagons the list of hexagon tiles
     * @param slot     the save slot number (1–4)
     */
    public static void saveBoardState(List<Polygon> hexagons, int slot) {
        String fileName = getSaveFileName(slot);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            HexState[] states = new HexState[hexagons.size()];
            for (int i = 0; i < hexagons.size(); i++) {
                states[i] = (HexState) hexagons.get(i).getUserData();
            }
            oos.writeObject(states);
            System.out.println("Board state saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the board state from a specific save slot.
     *
     * @param slot the save slot number
     * @return an array of HexState objects representing the saved state, or null if not found
     */
    public static HexState[] loadBoardState(int slot) {
        String filename = "Save" + slot + ".ser";
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("Save file not found: " + filename);
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (HexState[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns the filename corresponding to the given slot number.
     *
     * @param slot the slot number (1–4)
     * @return the filename for the slot
     */
    public static String getSaveFileName(int slot) {
        return switch (slot) {
            case 1 -> "Save1.ser";
            case 2 -> "Save2.ser";
            case 3 -> "Save3.ser";
            default -> "Save4.ser";
        };
    }

    /**
     * Clears the board to the initial state and resets to Player One's turn.
     *
     * @param controller the HelloController managing the UI and game state
     */
    public static void clearBoard(HelloController controller) {
        List<Polygon> hexagons = controller.getHexagons();
        for (Polygon hex : hexagons) {
            hex.setUserData(HexState.OFF);
            hex.setFill(Color.GREY); // or whatever default "OFF" color is
        }
        controller.getApp().setPlayerOneTurn(true); // reset to player one's turn
    }
}
