package comp20050.hexagonalboard;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.List;
import java.util.Optional;

/**
 * Represents a vertical menu in our HexOust application.
 * Includes options for starting a new game, saving, loading, and quitting.
 */
public class Menu {

    private final HelloApplication app;

    private final VBox menuBox;

    /**
     * Constructs a Menu with buttons for New Game, Save Game, Load Game, and Quit.
     *
     * @param stage      the stage containing the hex grid
     * @param fxmlLoader the FXMLLoader used to retrieve the controller
     */
    public Menu(Stage stage, FXMLLoader fxmlLoader, HelloApplication app) {
        this.app = app;

        menuBox = new VBox(20); //Spacing between the buttons
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setStyle("-fx-padding: 10;");

        Button newGameBtn = createMenuButton("New Game", () -> handleNewGame(fxmlLoader));
        Button saveGameBtn = createMenuButton("Save game", () -> handleSaveGame(fxmlLoader));
        Button loadGameBtn = createMenuButton("Load Game", () -> handleLoadGame(fxmlLoader));
        Button quitBtn = createMenuButton("Quit", () -> handleQuit(stage, fxmlLoader));

        menuBox.getChildren().addAll(newGameBtn, saveGameBtn, loadGameBtn, quitBtn);
    }

    /**
     *
     * @return the menu container VBox
     */
    public VBox getMenuBox() {
        return menuBox;
    }

    /**
     * Creates a menu button with the given text and action.
     *
     * @param text   The Button Name
     * @param action The action to perform on click
     * @return a styled Button
     */
    private Button createMenuButton(String text, Runnable action) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");
        button.setOnAction(e -> action.run());
        return button;
    }

    /**
     * Handles the logic for "starting" a new game.
     *
     * @param fxmlLoader the FXMLLoader used to access the controller
     */
    private void handleNewGame(FXMLLoader fxmlLoader) {
        if (promptToSave(fxmlLoader)) {
            HelloController controller = fxmlLoader.getController();
            SaveAndLoad.clearBoard(controller);
            showMessage("New Game Started");
        }
    }

    /**
     * Handles the logic for saving a game.
     *
     * @param fxmlLoader the FXMLLoader used to access the controller
     */
    private void handleSaveGame(FXMLLoader fxmlLoader) {
        promptToSave(fxmlLoader);
    }

    /**
     * Handles the logic for loading a game from a given save slot.
     *
     * @param fxmlLoader the FXMLLoader used to access the controller
     */
    private void handleLoadGame(FXMLLoader fxmlLoader) {
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
    }

    /**
     * Handles the logic for quitting the game.
     *
     * @param stage      the main application stage
     * @param fxmlLoader the FXMLLoader used to access the controller
     */
    private void handleQuit(Stage stage, FXMLLoader fxmlLoader) {
        if (promptToSave(fxmlLoader)) {
            stage.close();
        }
    }

    /**
     * Prompts the user to save the game. If they choose to save, it asks for a save slot and saves to that slot.
     *
     * @param fxmlLoader the FXMLLoader used to access the controller
     * @return true if the user proceeds (with or without saving), false if cancelled
     */
    private boolean promptToSave(FXMLLoader fxmlLoader) {
        if (!app.isPlayerOneTurn()) {
            showMessage("Cannot save mid turn.");
            return false;
        }

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
                    return false;
                }
            } else if (result.get() == continueWithoutSaving) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prompts the user to choose a save/load slot.
     *
     * @param title the title of the dialog
     * @return the selected slot number (1–4), or -1 if canceled
     */
    public static int promptForSlot(String title) {
        Dialog<Integer> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText("Choose a save slot:");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-padding: 20;");

        List<Button> slotButtons = List.of(
                createSlotButton(dialog, 1),
                createSlotButton(dialog, 2),
                createSlotButton(dialog, 3),
                createSlotButton(dialog, 4)
        );

        grid.add(slotButtons.get(0), 0, 0);
        grid.add(slotButtons.get(1), 1, 0);
        grid.add(slotButtons.get(2), 0, 1);
        grid.add(slotButtons.get(3), 1, 1);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<Integer> result = dialog.showAndWait();
        return result.orElse(-1);
    }

    /**
     * Creates a button representing a save/load slot, which when clicked, calls to either save or load to/from this slot before closing the pop-up window.
     *
     * @param dialog the dialog to close upon selection
     * @param slot   the slot number represented by this button
     * @return the configured Button
     */
    private static Button createSlotButton(Dialog<Integer> dialog, int slot) {
        Button button = new Button("Save " + slot);
        button.setPrefSize(100, 40);
        button.setOnAction(e -> {
            dialog.setResult(slot);
            dialog.close();
        });
        return button;
    }

    /**
     * Shows a popup with the given message.
     *
     * @param message the message to display
     */
    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Menu Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
