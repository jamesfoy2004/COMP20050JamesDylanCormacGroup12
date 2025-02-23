package comp20050.hexagonalboard;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.transform.Scale;
import java.io.IOException;

public class HelloApplication extends Application {
    Button button;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));;

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

        AnchorPane root = fxmlLoader.load();
        root.getChildren().add(button);
        AnchorPane.setLeftAnchor(button, 0.0);
        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane container = new AnchorPane();
        container.getChildren().add(root);

        Scene scene = new Scene(container, 800, 700);

        Scale scale = new Scale(0.5, 0.5);
        root.getTransforms().add(scale);

        root.setTranslateX(50);
        root.setTranslateY(0);

        stage.setTitle("HexOust");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}