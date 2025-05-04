package comp20050.hexagonalboard;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class SplashLoadingScreen {

    public void show(Stage stage, Consumer<Boolean> afterSplash) {
        try {
            // Loading splash image
            InputStream imageStream = getClass().getResourceAsStream("/comp20050/hexagonalboard/splash.png");
            if (imageStream == null) {
                throw new IOException("Splash image not found!");
            }

            Image image = new Image(imageStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(800);
            imageView.setFitHeight(500);

            // Buttons for "New Game" and "Load Game"
            Button newGameBtn = new Button("New Game");
            Button loadGameBtn = new Button("Load Game");

            newGameBtn.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");
            loadGameBtn.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");

            // Button actions
            newGameBtn.setOnAction(e -> afterSplash.accept(true));  // New Game selected
            loadGameBtn.setOnAction(e -> afterSplash.accept(false)); // Load Game selected

            // Adding buttons to layout
            VBox menuBox = new VBox(20, newGameBtn, loadGameBtn);
            menuBox.setAlignment(Pos.CENTER);
            menuBox.setLayoutY(520);
            menuBox.setLayoutX(300);

            // Setting up scene
            AnchorPane root = new AnchorPane(imageView, menuBox);
            Scene scene = new Scene(root, 800, 700);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the game (stubbed here for your use)
    private void loadMainScene(Stage stage, String fileName) {
        // Here you would load the game from the specified file
        System.out.println("Loading game from: " + fileName);

        // Assuming the logic to load and display the game is in this method
    }
}
