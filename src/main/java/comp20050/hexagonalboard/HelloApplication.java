package comp20050.hexagonalboard;

import javafx.geometry.Pos;
import javafx.scene.control.MenuButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    Button quitButton;
    MenuButton menuButton;

    //red turn and blue turn pop-ups
    Button playerOneButton;
    Button playerTwoButton;

    private List<Polygon> hexagons;

    //used for dictating how long a pop-up runs
    private Timeline playerOneTime;
    private Timeline playerTwoTime;

    private boolean isPlayerOneTurn = true;

    public boolean isPlayerOneTurn() {
        return isPlayerOneTurn;
    }

    public void setPlayerOneTurn(boolean playerOneTurn) {
        isPlayerOneTurn = playerOneTurn;
    }

    @Override
    public void start(Stage stage) throws IOException {
//=======================================================FXML===========================================================

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));

//=======================================================Splash=========================================================

        new SplashLoadingScreen().show(stage, isNewGame -> {
            // This lambda will be triggered after the splash screen when the user clicks "New Game" or "Load Game"
            if (isNewGame) {
                // For a new game, you need to show the slot selection prompt
                // (Note: the file names here will be used to represent the game saves)
                // You can call the prompt to choose the slot, and once chosen, load the respective save.
                promptForGameSlot(stage, true);
            } else {
                // For loading an existing game, the same slot prompt will appear
                promptForGameSlot(stage, false);
            }
        });

    }

    private void promptForGameSlot(Stage stage, boolean isNewGame) {
        // Create an Alert to ask the user for the save slot
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Select Saved Game");
        alert.setHeaderText(isNewGame ? "Select a Save for New Game" : "Select a Save File to load");
        alert.setContentText("Select a Save:");

        // Create a GridPane to display buttons in a 2x2 grid
        GridPane grid = new GridPane();
        grid.setHgap(10);  // Horizontal gap between buttons
        grid.setVgap(10);  // Vertical gap between buttons
        grid.setAlignment(Pos.CENTER);  // Align the grid to the center

        // Create the buttons for slots 1, 2, 3, and 4
        Button slot1 = new Button("Slot 1");
        Button slot2 = new Button("Slot 2");
        Button slot3 = new Button("Slot 3");
        Button slot4 = new Button("Slot 4");

        // Add buttons to the grid
        grid.add(slot1, 0, 0);  // Row 0, Column 0
        grid.add(slot2, 1, 0);  // Row 0, Column 1
        grid.add(slot3, 0, 1);  // Row 1, Column 0
        grid.add(slot4, 1, 1);  // Row 1, Column 1

        // Set the grid as the content of the alert
        alert.getDialogPane().setContent(grid);

        // Set action listeners for each button to load the respective game
        slot1.setOnAction(e -> {
            String fileName = "Save1.ser";
            loadMainScene(stage, fileName);
            alert.close(); // Close the alert after the selection
        });
        slot2.setOnAction(e -> {
            String fileName = "Save2.ser";
            loadMainScene(stage, fileName);
            alert.close(); // Close the alert after the selection
        });
        slot3.setOnAction(e -> {
            String fileName = "Save3.ser";
            loadMainScene(stage, fileName);
            alert.close(); // Close the alert after the selection
        });
        slot4.setOnAction(e -> {
            String fileName = "Save4.ser";
            loadMainScene(stage, fileName);
            alert.close(); // Close the alert after the selection
        });

        // Show the alert and wait for the user to select a slot
        alert.showAndWait();
    }

    private void loadMainScene(Stage stage, String filename) {
        try {
            System.out.println(filename);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));
            AnchorPane root = fxmlLoader.load();

            DropDownMenu dropDownMenu = new DropDownMenu(stage, fxmlLoader);
            menuButton = dropDownMenu.getMenuButton();
            root.getChildren().add(menuButton);

            AnchorPane.setLeftAnchor(menuButton, 10.0);
            AnchorPane.setTopAnchor(menuButton, 10.0);

            AnchorPane container = new AnchorPane();
            container.getChildren().add(root);
            Scene scene = new Scene(container, 800, 700);


            //red pop-up
            playerOneButton = new Button();
            playerOneButton.setStyle("-fx-background-color: white; -fx-text-fill: black;  -fx-border-style: none; -fx-background-radius: 30; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
            playerOneButton.setText(" : RED player's turn");
            playerOneButton.setPrefHeight(200);
            playerOneButton.setPrefWidth(500);
            playerOneButton.setVisible(false);

            //add red circle to pop-up
            Image image = new Image(getClass().getResourceAsStream("red.png"));
            ImageView iview = new ImageView(image);

            iview.setFitWidth(50);
            iview.setFitHeight(50);
            iview.setPreserveRatio(true);

            playerOneButton.setGraphic(iview);

            root.getChildren().add(playerOneButton);
            AnchorPane.setLeftAnchor(playerOneButton, 450.0);
            AnchorPane.setTopAnchor(playerOneButton, 600.0);

            //blue pop-up
            playerTwoButton = new Button();
            playerTwoButton.setStyle("-fx-background-color: white; -fx-text-fill: black;  -fx-border-style: none; -fx-background-radius: 30; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
            playerTwoButton.setText(" : BLUE player's turn");
            playerTwoButton.setPrefHeight(200);
            playerTwoButton.setPrefWidth(500);
            playerTwoButton.setVisible(false);

            //add blue circle to pop-up
            Image imageBlue = new Image(getClass().getResourceAsStream("blue.png"));
            ImageView iviewBlue = new ImageView(imageBlue);

            iviewBlue.setFitWidth(50);
            iviewBlue.setFitHeight(50);
            iviewBlue.setPreserveRatio(true);

            playerTwoButton.setGraphic(iviewBlue);

            root.getChildren().add(playerTwoButton);
            AnchorPane.setLeftAnchor(playerTwoButton, 450.0);
            AnchorPane.setTopAnchor(playerTwoButton, 600.0);


            HelloController controller = fxmlLoader.getController();
            controller.setApp(this);
            hexagons = controller.getHexagons();
            for (Polygon hex : hexagons) {
                hex.setUserData(HexState.OFF); // Initial state
                hex.setOnMouseClicked(event -> {
                    playerTurn(hex); // this will assign the correct state
                });

            }

            //method which defines how long the pop-ups run
            makeTimeLines();

            //by default start game with red players turn
            playerOneTime.play();
            playerOneButton.setVisible(true);
            for (Polygon hexagon : hexagons) {
                hexagon.setDisable(true);
                hexagon.setOpacity(0.5);
            }


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

    public void updateFillFromState(Polygon hex) {
        HexState state = (HexState) hex.getUserData();
        switch (state) {
            case PLAYER1 -> hex.setFill(Color.RED);
            case PLAYER2 -> hex.setFill(Color.BLUE);
            default -> hex.setFill(Color.LIGHTGRAY);
        }
    }


    private void showMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Menu Selection");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void makeTimeLines(){
        playerOneTime = new Timeline(new KeyFrame(
                Duration.seconds(2),
                event ->{
                    for(Polygon hexagon : hexagons) {
                        hexagon.setDisable(false);
                        hexagon.setOpacity(1);
                    }
                    playerOneButton.setVisible(false);
                }
        ));

        playerTwoTime = new Timeline(new KeyFrame(
                Duration.seconds(2),
                eventBlue ->{
                    for(Polygon hexagon : hexagons) {
                        hexagon.setDisable(false);
                        hexagon.setOpacity(1);
                    }
                    playerTwoButton.setVisible(false);
                }
        ));
    }

    public void playerTurn(Polygon hexagon){

        if(isPlayerOneTurn()){
            PlayerOne(hexagon);
            setPlayerOneTurn(false);
        }
        else{
            PlayerTwo(hexagon);
            setPlayerOneTurn(true);
        }
    }

    public void PlayerOne(Polygon hex){
        //colour given hex red
        hex.setFill(Color.RED);
        hex.setUserData(HexState.PLAYER1);

        //show BLUE TURN pop up
        playerTwoTime.play();
        playerTwoButton.setVisible(true);
        for(Polygon hexagon : hexagons) {
            hexagon.setDisable(true);
            hexagon.setOpacity(0.5);
        }
    }

    public void PlayerTwo(Polygon hex){
        //colour given hex blue
        hex.setFill(Color.BLUE);
        hex.setUserData(HexState.PLAYER2);

        //show RED TURN pop up
        playerOneTime.play();
        playerOneButton.setVisible(true);
        for(Polygon hexagon : hexagons) {
            hexagon.setDisable(true);
            hexagon.setOpacity(0.5);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}