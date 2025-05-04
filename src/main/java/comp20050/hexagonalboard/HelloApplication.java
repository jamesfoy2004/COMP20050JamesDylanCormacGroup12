package comp20050.hexagonalboard;

import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    VBox menuButton;

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
            if (isNewGame) {
                // Just start with a fresh board — no prompt
                loadMainScene(stage, null); // or use a flag to indicate it's a new game
            } else {
                // Option for another button
            }
        });
    }

    private void loadMainScene(Stage stage, String filename) {
        try {
            System.out.println(filename);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));
            AnchorPane root = fxmlLoader.load();

            Menu dropDownMenu = new Menu(stage, fxmlLoader);
            menuButton = dropDownMenu.getMenuBox();
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