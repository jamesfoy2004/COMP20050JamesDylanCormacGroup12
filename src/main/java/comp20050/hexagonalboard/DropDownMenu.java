package comp20050.hexagonalboard;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.List;
import java.util.Optional;

public class DropDownMenu {

    private final MenuButton menuButton;

    public DropDownMenu(Stage stage, FXMLLoader fxmlLoader) {
        menuButton = new MenuButton("Menu");
        menuButton.setStyle("-fx-background-color: red;");
        menuButton.setPrefHeight(100);
        menuButton.setPrefWidth(200);

        MenuItem changeTheme = new MenuItem("Change Theme");
        MenuItem newGame = new MenuItem("New Game");
        MenuItem loadGame = new MenuItem("Load Game");
        MenuItem quitMenuButton = new MenuItem("Quit");

        changeTheme.setOnAction(event -> showMessage("Change Theme Selected"));

        newGame.setOnAction(event -> {
            if (promptToSave(fxmlLoader)) {
                HelloController controller = fxmlLoader.getController();
                SaveAndLoad.clearBoard(controller);
                showMessage("New Game Started");
            }
        });

        loadGame.setOnAction(event -> {
            int slot = promptForSlot("Load Game");
            if (slot != -1) {
                HelloController controller = fxmlLoader.getController();
                HexState[] loaded = SaveAndLoad.loadBoardState(slot);
                if (loaded != null) {
                    controller.applyLoadedBoard(loaded);
                    showMessage("Game Loaded from Slot " + slot);
                } else {
                    showMessage("Failed to load game from Slot " + slot);
                }
            }
        });


        quitMenuButton.setOnAction(event -> {
            if (promptToSave(fxmlLoader)) {
                stage.close();
            }
        });

        menuButton.getItems().addAll(changeTheme, newGame, loadGame, quitMenuButton);
    }

    private boolean promptToSave(FXMLLoader fxmlLoader) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save Game?");
        alert.setHeaderText("Would you like to save the game before proceeding?");
        alert.setContentText("Choose your option.");

        ButtonType saveAndContinue = new ButtonType("Save and Continue");
        ButtonType continueWithoutSaving = new ButtonType("Don't Save");
        ButtonType cancel = ButtonType.CANCEL;

        alert.getButtonTypes().setAll(saveAndContinue, continueWithoutSaving, cancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == saveAndContinue) {
                int slot = promptForSlot("Save Game");
                if (slot != -1) {
                    HelloController controller = fxmlLoader.getController();
                    SaveAndLoad.saveBoardState(controller.getHexagons(), slot);
                    showMessage("Game Saved to Slot " + slot);
                    return true;
                } else {
                    return false; // user cancelled the slot choice
                }
            } else if (result.get() == continueWithoutSaving) {
                return true;
            }
        }
        return false; // Cancel or dialog closed
    }

    private int promptForSlot(String title) {

            Dialog<Integer> dialog = new Dialog<>();
            dialog.setTitle(title);
            dialog.setHeaderText("Choose a save slot:");

            // Create GridPane with 2x2 layout
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setStyle("-fx-padding: 20;");

            // Slot buttons
            Button slot1 = new Button("Save 1");
            Button slot2 = new Button("Save 2");
            Button slot3 = new Button("Save 3");
            Button slot4 = new Button("Save 4");

            // Set same size for buttons
            double width = 100;
            double height = 40;
            for (Button b : List.of(slot1, slot2, slot3, slot4)) {
                b.setPrefSize(width, height);
            }

            // Place in 2x2 grid
            grid.add(slot1, 0, 0);
            grid.add(slot2, 1, 0);
            grid.add(slot3, 0, 1);
            grid.add(slot4, 1, 1);

            dialog.getDialogPane().setContent(grid);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            // Set result converter
            slot1.setOnAction(e -> {
                dialog.setResult(1);
                dialog.close();
            });
            slot2.setOnAction(e -> {
                dialog.setResult(2);
                dialog.close();
            });
            slot3.setOnAction(e -> {
                dialog.setResult(3);
                dialog.close();
            });
            slot4.setOnAction(e -> {
                dialog.setResult(4);
                dialog.close();
            });

            // Show and get result
            Optional<Integer> result = dialog.showAndWait();
            return result.orElse(-1);
        }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Menu Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public MenuButton getMenuButton() {
        return menuButton;
    }
}
