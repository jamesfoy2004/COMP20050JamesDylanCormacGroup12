package comp20050.hexagonalboard;

import javafx.application.Platform;
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
            InputStream imageStream = getClass().getResourceAsStream("/comp20050/hexagonalboard/splash.png");
            if (imageStream == null) {
                throw new IOException("Splash image not found!");
            }

            Image image = new Image(imageStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(800);
            imageView.setFitHeight(500);

            // Buttons for "New Game" and "Load Game"
            Button playGameBtn = new Button("Play");
            Button quitGameBtn = new Button("Quit");

            playGameBtn.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");
            quitGameBtn.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");

            // Button actions
            playGameBtn.setOnAction(e -> afterSplash.accept(true));
            quitGameBtn.setOnAction(e -> Platform.exit());


            // Adding buttons to layout
            VBox menuBox = new VBox(20, playGameBtn, quitGameBtn);
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
}
