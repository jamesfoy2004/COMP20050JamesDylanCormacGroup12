package comp20050.hexagonalboard;

import java.io.*;
import java.util.Random;

class Cell implements Serializable {
    private static final long serialVersionUID = 1L;
    private String position;
    private String state;

    public Cell(String position, String state) {
        this.position = position;
        this.state = state;
    }

    public void display() {
        System.out.println("Position: " + position + ", State: " + state);
    }
}


public class SerialiseObjects {
    private static final String FILE_NAME = "Save1.ser";

    public static void main(String[] args) {
        Cell[] board = new Cell[127];
        String[] states = {"Red", "Blue", "Empty"};
        Random random = new Random();

        for (int i = 0; i < 127; i++) {
            String position = String.valueOf(i + 1);
            String state = states[random.nextInt(3)];
            board[i] = new Cell(position, state);
        }

        saveBoard(board);

        Cell[] loadedBoard = loadBoard();

        if (loadedBoard != null) {
            for (Cell cell : loadedBoard) {
                cell.display();
            }
        }
    }


    private static void saveBoard(Cell[] board) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(board);
            System.out.println("Saving to: " + new File(FILE_NAME).getAbsolutePath());
            System.out.println("Board saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Cell[] loadBoard() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Cell[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
