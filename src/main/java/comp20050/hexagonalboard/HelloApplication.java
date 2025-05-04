package comp20050.hexagonalboard;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.List;

/**
 * The main JavaFX application class for the HexOust game.
 * Handles loading the UI, initializing game state, and managing turn-based interactions
 * between two players using animated pop-ups.
 */
public class HelloApplication extends Application {
    Button quitButton;
    VBox menuButton;

    // Red turn and blue turn pop-ups
    Button playerOneButton;
    Button playerTwoButton;

    private List<Polygon> hexagons;

    // Timelines used to control how long a pop-up is visible
    private Timeline playerOneTime;
    private Timeline playerTwoTime;

    private boolean isPlayerOneTurn = true;

    /**
     * Returns whether it's currently Player 1's turn.
     *
     * @return true if it's Player 1's turn; false otherwise.
     */
    public boolean isPlayerOneTurn() {
        return isPlayerOneTurn;
    }

    /**
     * Sets the current turn.
     *
     * @param playerOneTurn true if it's Player 1's turn, false otherwise.
     */
    public void setPlayerOneTurn(boolean playerOneTurn) {
        isPlayerOneTurn = playerOneTurn;
    }

    /**
     * Starts the JavaFX application and displays a splash screen
     * before loading the main game scene.
     *
     * @param stage the primary stage for this application.
     * @throws IOException if the FXML cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));

        new SplashLoadingScreen().show(stage, isNewGame -> {
            if (isNewGame) {
                loadMainScene(stage, null);
            }
        });
    }

    /**
     * Loads the main game scene, initializes buttons, hexagons, and turn mechanics.
     *
     * @param stage the primary window stage.
     * @param filename currently unused; placeholder for future save file loading.
     */
    private void loadMainScene(Stage stage, String filename) {
        try {
            System.out.println(filename);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));
            AnchorPane root = fxmlLoader.load();

            Menu menu = new Menu(stage, fxmlLoader, this);
            menuButton = menu.getMenuBox();
            root.getChildren().add(menuButton);
            AnchorPane.setLeftAnchor(menuButton, 10.0);
            AnchorPane.setTopAnchor(menuButton, 10.0);

            AnchorPane container = new AnchorPane();
            container.getChildren().add(root);
            Scene scene = new Scene(container, 800, 700);

            initializePlayerButtons(root);
            initializeHexagons(fxmlLoader);

            makeTimeLines();

            // Start with red player's turn
            playerOneTime.play();
            playerOneButton.setVisible(true);
            for (Polygon hexagon : hexagons) {
                hexagon.setDisable(true);
                hexagon.setOpacity(0.5);
            }

            // Apply scaling to the entire board
            Scale scale = new Scale(0.5, 0.5);
            root.getTransforms().add(scale);
            root.setTranslateX(50);
            root.setTranslateY(0);

            stage.setTitle("HexOust");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the visual pop-up buttons that indicate whose turn it is.
     *
     * @param root the root AnchorPane to which the buttons will be added.
     */
    private void initializePlayerButtons(AnchorPane root) {
        // Red player's turn pop-up
        playerOneButton = new Button(" : RED player's turn");
        playerOneButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-style: none; -fx-background-radius: 30; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
        playerOneButton.setPrefSize(500, 200);
        playerOneButton.setVisible(false);
        Image redImage = new Image(getClass().getResourceAsStream("red.png"));
        ImageView redView = new ImageView(redImage);
        redView.setFitWidth(50);
        redView.setFitHeight(50);
        redView.setPreserveRatio(true);
        playerOneButton.setGraphic(redView);
        root.getChildren().add(playerOneButton);
        AnchorPane.setLeftAnchor(playerOneButton, 450.0);
        AnchorPane.setTopAnchor(playerOneButton, 600.0);

        // Blue player's turn pop-up
        playerTwoButton = new Button(" : BLUE player's turn");
        playerTwoButton.setStyle(playerOneButton.getStyle());
        playerTwoButton.setPrefSize(500, 200);
        playerTwoButton.setVisible(false);
        Image blueImage = new Image(getClass().getResourceAsStream("blue.png"));
        ImageView blueView = new ImageView(blueImage);
        blueView.setFitWidth(50);
        blueView.setFitHeight(50);
        blueView.setPreserveRatio(true);
        playerTwoButton.setGraphic(blueView);
        root.getChildren().add(playerTwoButton);
        AnchorPane.setLeftAnchor(playerTwoButton, 450.0);
        AnchorPane.setTopAnchor(playerTwoButton, 600.0);
    }

    /**
     * Initializes hexagon shapes, setting default state and click behavior.
     *
     * @param fxmlLoader the FXMLLoader used to get the controller and board elements.
     */
    private void initializeHexagons(FXMLLoader fxmlLoader) {
        HelloController controller = fxmlLoader.getController();
        controller.setApp(this);
        hexagons = controller.getHexagons();
        for (Polygon hex : hexagons) {
            hex.setUserData(HexState.OFF);
            hex.setOnMouseClicked(event -> playerTurn(hex));
        }
    }

    /**
     * Defines the duration and effects for each player's pop-up timeline.
     */
    public void makeTimeLines() {
        playerOneTime = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            for (Polygon hexagon : hexagons) {
                hexagon.setDisable(false);
                hexagon.setOpacity(1);
            }
            playerOneButton.setVisible(false);
        }));

        playerTwoTime = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            for (Polygon hexagon : hexagons) {
                hexagon.setDisable(false);
                hexagon.setOpacity(1);
            }
            playerTwoButton.setVisible(false);
        }));
    }

    /**
     * Executes a player's turn and alternates to the other player.
     *
     * @param hexagon the clicked hexagon representing a move.
     */
    public void playerTurn(Polygon hexagon) {
        if (isPlayerOneTurn()) {
            PlayerOne(hexagon);
            setPlayerOneTurn(false);
        } else {
            PlayerTwo(hexagon);
            setPlayerOneTurn(true);
        }
    }

    /**
     * Handles red player's move by setting color, state, and triggering the blue turn pop-up.
     *
     * @param hex the hexagon selected by red player.
     */
    public void PlayerOne(Polygon hex) {
        hex.setFill(Color.RED);
        hex.setUserData(HexState.PLAYER1);
        playerTwoTime.play();
        playerTwoButton.setVisible(true);
        for (Polygon hexagon : hexagons) {
            hexagon.setDisable(true);
            hexagon.setOpacity(0.5);
        }
    }

    /**
     * Handles blue player's move by setting color, state, and triggering the red turn pop-up.
     *
     * @param hex the hexagon selected by blue player.
     */
    public void PlayerTwo(Polygon hex) {
        hex.setFill(Color.BLUE);
        hex.setUserData(HexState.PLAYER2);
        playerOneTime.play();
        playerOneButton.setVisible(true);
        for (Polygon hexagon : hexagons) {
            hexagon.setDisable(true);
            hexagon.setOpacity(0.5);
        }
    }

    /**
     * Launches the application.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}
