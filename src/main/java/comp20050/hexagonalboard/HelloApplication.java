package comp20050.hexagonalboard;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.transform.Scale;
import javafx.util.Duration;


import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    Button button;

    //red turn and blue turn pop-ups
    Button redButton;
    Button blueButton;

    private List<Polygon> hexagons;

    //used for dictating how long a pop-up runs
    private Timeline redTime;
    private Timeline blueTime;


    private boolean isRedTurn = true;

    public boolean isRedTurn() {
        return isRedTurn;
    }

    public void setRedTurn(boolean redTurn) {
        isRedTurn = redTurn;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));

        AnchorPane container = new AnchorPane();
        AnchorPane root = fxmlLoader.load();
        container.getChildren().add(root);
        Scene scene = new Scene(container, 800, 700);

        button = new Button();
        button.setStyle("-fx-background-color: yellow; -fx-text-fill: blue; -fx-border-colour: red; -fx-border-style: solid; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
        button.setText("Quit");
        button.setPrefHeight(200);
        button.setPrefWidth(400);
        button.setOnAction(event -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Quit Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to quit?");
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
            if (result == ButtonType.YES) {
                //save to file
                stage.close();
                //quit application
        }});

        root.getChildren().add(button);
        AnchorPane.setLeftAnchor(button, 0.0);
        AnchorPane.setBottomAnchor(button, 10.0);


        //red pop-up
        redButton = new Button();
        redButton.setStyle("-fx-background-color: white; -fx-text-fill: black;  -fx-border-style: none; -fx-background-radius: 30; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
        redButton.setText(" : RED player's turn");
        redButton.setPrefHeight(200);
        redButton.setPrefWidth(500);
        redButton.setVisible(false);

        //add red circle to pop-up
        Image image = new Image(getClass().getResourceAsStream("red.png"));
        ImageView iview = new ImageView(image);

        iview.setFitWidth(50);
        iview.setFitHeight(50);
        iview.setPreserveRatio(true);

        redButton.setGraphic(iview);

        root.getChildren().add(redButton);
        AnchorPane.setLeftAnchor(redButton, 450.0);
        AnchorPane.setTopAnchor(redButton, 600.0);

        //blue pop-up
        blueButton = new Button();
        blueButton.setStyle("-fx-background-color: white; -fx-text-fill: black;  -fx-border-style: none; -fx-background-radius: 30; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
        blueButton.setText(" : BLUE player's turn");
        blueButton.setPrefHeight(200);
        blueButton.setPrefWidth(500);
        blueButton.setVisible(false);

        //add blue circle to pop-up
        Image imageBlue = new Image(getClass().getResourceAsStream("blue.png"));
        ImageView iviewBlue = new ImageView(imageBlue);

        iviewBlue.setFitWidth(50);
        iviewBlue.setFitHeight(50);
        iviewBlue.setPreserveRatio(true);

        blueButton.setGraphic(iviewBlue);

        root.getChildren().add(blueButton);
        AnchorPane.setLeftAnchor(blueButton, 450.0);
        AnchorPane.setTopAnchor(blueButton, 600.0);



        HelloController controller = fxmlLoader.getController();
        controller.setApp(this);
        hexagons = controller.getHexagons();

        //method which defines how long the pop-ups run
        makeTimeLines();

        //by default start game with red players turn
        redTime.play();
        redButton.setVisible(true);
        for(Polygon hexagon : hexagons) {
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
    }

    public void makeTimeLines(){
        redTime = new Timeline(new KeyFrame(
                Duration.seconds(2),
                event ->{
                    for(Polygon hexagon : hexagons) {
                        hexagon.setDisable(false);
                        hexagon.setOpacity(1);
                    }
                    redButton.setVisible(false);
                }
        ));

        blueTime = new Timeline(new KeyFrame(
                Duration.seconds(2),
                eventBlue ->{
                    for(Polygon hexagon : hexagons) {
                        hexagon.setDisable(false);
                        hexagon.setOpacity(1);
                    }
                    blueButton.setVisible(false);
                }
        ));
    }

    public void playerTurn(Polygon hexagon){

        if(isRedTurn()){
            RedPlayer(hexagon);
            setRedTurn(false);
        }
        else{
            BluePlayer(hexagon);
            setRedTurn(true);
        }
    }

    public void RedPlayer(Polygon hex){
        //colour given hex red
        hex.setFill(Color.RED);

        //show BLUE TURN pop up
        blueTime.play();
        blueButton.setVisible(true);
        for(Polygon hexagon : hexagons) {
            hexagon.setDisable(true);
            hexagon.setOpacity(0.5);
        }
    }

    public void BluePlayer(Polygon hex){
        //colour given hex blue
        hex.setFill(Color.BLUE);

        //show RED TURN pop up
        redTime.play();
        redButton.setVisible(true);
        for(Polygon hexagon : hexagons) {
            hexagon.setDisable(true);
            hexagon.setOpacity(0.5);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}