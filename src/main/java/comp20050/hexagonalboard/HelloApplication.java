package comp20050.hexagonalboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/comp20050/hexagonalboard/hello-view.fxml"));;

        AnchorPane root = fxmlLoader.load();
        AnchorPane container = new AnchorPane();
        container.getChildren().add(root);

        Scene scene = new Scene(container, 800, 700);

        Scale scale = new Scale(0.5, 0.5);
        root.getTransforms().add(scale);

        root.setTranslateX(50);
        root.setTranslateY(0);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}