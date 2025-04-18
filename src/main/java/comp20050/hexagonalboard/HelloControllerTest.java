package comp20050.hexagonalboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HelloControllerTest {

    private HelloController controller;
    private HelloApplication app;
    ArrayList<HexCube> hexCubes;

    @BeforeEach
    public void setup() {
        controller = new HelloController();
        app = new HelloApplication();
        hexCubes = new ArrayList<HexCube>();
        controller.setApp(app, hexCubes);

        // Setup fake board
        List<Polygon> hexagons = new ArrayList<>();
        for (int i = 0; i < 7 * 7; i++) {
            Polygon hex = new Polygon();
            hex.setFill(Color.GREY);
            hexagons.add(hex);
        }
        controller.getHexagons().addAll(hexagons);
    }

    @Test
    public void testValidNonCapturingMove_NoNeighbors() {
        app.setRedTurn(true);
        Polygon testHex = controller.getHexagons().get(24); // middle of board

        // All neighbors are GREY by default
        boolean result = callNonCapturingMove(testHex);
        assertTrue(result);
    }

    @Test
    public void testInvalidNonCapturingMove_HasFriendlyNeighbor() {
        app.setRedTurn(true);
        Polygon center = controller.getHexagons().get(24);
        Polygon neighbor = controller.getHexagons().get(25);
        neighbor.setFill(Color.RED); // friendly neighbor

        boolean result = callNonCapturingMove(center);
        assertFalse(result);
    }

    @Test
    public void testCaptureSingleOpponentHex() {
        app.setRedTurn(true);

        Polygon center = controller.getHexagons().get(24);
        center.setFill(Color.RED);

        Polygon target = controller.getHexagons().get(17); // pretend this is a neighbor
        target.setFill(Color.BLUE); // opponent piece

        // Surround it with RED
        for (Polygon neighbor : controller.getHexagons()) {
            neighbor.setFill(Color.RED);
        }

        controller.checkCaptures(center);
        assertEquals(Color.GREY, target.getFill()); // captured
    }

    // Helper for calling the non-capturing method directly
    private boolean callNonCapturingMove(Polygon hex) {
        try {
            var method = HelloController.class.getDeclaredMethod("isValidNonCapturingMove", Polygon.class);
            method.setAccessible(true);
            return (boolean) method.invoke(controller, hex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
