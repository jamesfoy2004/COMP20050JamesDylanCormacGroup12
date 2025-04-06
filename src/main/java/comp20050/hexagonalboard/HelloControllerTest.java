package comp20050.hexagonalboard;
// NOTE: Issues with JUnit dependencies as well as incomplete game logic prevent these tests from working
// in their current state. Currently exist as a model for unit tests in Sprint 4
// Unknown what is causing JUnit conflict; perfomed clean install of JUnit 5.8.1 multiple times in IntelliJ
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

    @BeforeEach
    public void setup() {
        controller = new HelloController();
        app = new HelloApplication();
        controller.setApp(app);

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
}
