package comp20050.hexagonalboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.*;
import java.util.List;

public class SaveAndLoad {

    public static void saveBoardState(List<Polygon> hexagons, int slot) {
        String FILE_NAME = getSaveFileName(slot);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
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

    public static String getSaveFileName(int slot) {
        return switch (slot) {
            case 1 -> "Save1.ser";
            case 2 -> "Save2.ser";
            case 3 -> "Save3.ser";
            default -> "Save4.ser";
        };
    }

    public static void clearBoard(HelloController controller) {
        List<Polygon> hexagons = controller.getHexagons();
        for (Polygon hex : hexagons) {
            hex.setUserData(HexState.OFF);
            hex.setFill(Color.GREY); // or whatever default "OFF" color is
        }
        controller.getApp().setPlayerOneTurn(true); // reset to player one's turn
    }
}
