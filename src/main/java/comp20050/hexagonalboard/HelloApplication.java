package comp20050.hexagonalboard;

import javafx.application.Application;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

public class HelloApplication extends Application {
    Button quitButton;
    MenuButton menuButton;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));

        File imageFile = new File("src/main/java/comp20050/hexagonalboard/WhatsApp Image 2025-03-03 at 20.40.55.jpeg"); // Update with actual path
        Image image = new Image(new FileInputStream(imageFile));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(800);
        imageView.setFitHeight(700);

        AnchorPane imagePane = new AnchorPane(imageView);
        Scene imageScene = new Scene(imagePane, 800, 700);

        stage.setScene(imageScene);
        stage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> loadMainScene(stage));
        delay.play();
    }

    private void loadMainScene(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));

            quitButton = new Button("Quit");
            quitButton.setStyle("-fx-background-color: yellow; -fx-text-fill: blue; -fx-border-color: red; -fx-border-style: solid; -fx-border-width: 20; -fx-font-weight: bold; -fx-font-size: 32");
            quitButton.setPrefHeight(200);
            quitButton.setPrefWidth(400);
            quitButton.setOnAction(event -> {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Quit Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to quit?");
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
                if (result == ButtonType.YES) {
                    stage.close();
                }
            });

            menuButton = new MenuButton("Menu");
            menuButton.setStyle("-fx-background-color: red;");
            menuButton.setPrefHeight(100);
            menuButton.setPrefWidth(200);

            MenuItem newGame = new MenuItem("New Game");
            MenuItem loadGame = new MenuItem("Load Game");
            MenuItem thirdOption = new MenuItem("Third Option");

            newGame.setOnAction(event -> showMessage("New Game Selected"));
            loadGame.setOnAction(event -> showMessage("Load Game Selected"));
            thirdOption.setOnAction(event -> showMessage("Third Option Selected"));

            menuButton.getItems().addAll(newGame, loadGame, thirdOption);

            AnchorPane root = fxmlLoader.load();
            root.getChildren().addAll(quitButton, menuButton);

            AnchorPane.setLeftAnchor(quitButton, 0.0);
            AnchorPane.setBottomAnchor(quitButton, 10.0);
            AnchorPane.setLeftAnchor(menuButton, 10.0);
            AnchorPane.setTopAnchor(menuButton, 10.0);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Menu Selection");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
