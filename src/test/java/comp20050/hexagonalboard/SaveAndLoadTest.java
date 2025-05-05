package comp20050.hexagonalboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaveAndLoadTest {

    private List<Polygon> hexagons;
    private File tempFile;

    @BeforeEach
    void setUp() {
        hexagons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Polygon hex = new Polygon();
            hex.setUserData(HexState.PLAYER1);
            hexagons.add(hex);
        }
    }

    @AfterEach
    void tearDown() {
        for (int i = 1; i <= 4; i++) {
            File f = new File("Save" + i + ".ser");
            if (f.exists()) {
                f.delete();
            }
        }
    }

    @Test
    public void testSavingBoardToFile_ShouldCreateFile(){
        int slot = givenHexagonsAndSaveSlotExist();
        whenSaveTheBoardToGivenSaveSlot(slot);
        thenFileIsCreated(slot);
    }
    private int givenHexagonsAndSaveSlotExist() {
        return 1;
    }
    private void whenSaveTheBoardToGivenSaveSlot(int slot){
        SaveAndLoad.saveBoardState(hexagons, slot);
    }
    private void thenFileIsCreated(int slot){
        File savedFile = new File("Save" + slot + ".ser");
        assertTrue(savedFile.exists(), "Save file should be created.");
    }

    @Test
    public void testLoadingASavedBoard_shouldReturnHexStateArray(){
        int slot = givenSavedBoardExistsInSaveSlot2();
        HexState[] loaded = whenLoadExistingBoardState(slot);
        thenReturnsHexStateArray(loaded);
    }
    private int givenSavedBoardExistsInSaveSlot2() {
        int slot = 2;
        SaveAndLoad.saveBoardState(hexagons, slot);
        return slot;
    }
    private HexState[] whenLoadExistingBoardState(int slot) {
        HexState[] loaded = SaveAndLoad.loadBoardState(slot);
        return loaded;
    }
    private void thenReturnsHexStateArray(HexState[] loaded) {
        assertNotNull(loaded);
        assertEquals(3, loaded.length);
        for (HexState state : loaded) {
            assertEquals(HexState.PLAYER1, state);
        }
    }

    @Test
    public void testLoadingBoardStateWhenNoSaveFile_shouldReturnNull(){
        int slot = givenNoSaveFileInSaveSlot3();
        HexState[] result = whenLoadNonExistentBoardState(slot);
        thenReturnsNull(result);
    }
    private int givenNoSaveFileInSaveSlot3(){
        int slot = 3;
        return slot;
    }
    private HexState[] whenLoadNonExistentBoardState(int slot){
        HexState[] result = SaveAndLoad.loadBoardState(slot);
        return result;
    }
    private void thenReturnsNull(HexState[] result) {
        assertNull(result, "Expected null when loading non-existent file.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 99})
    public void testGetSaveFileName_ShouldGetFileName(int slot) {
        // Given - slot number is provided by ValueSource
        // When
        String filename = SaveAndLoad.getSaveFileName(slot);
        String expected = null;
        if (slot < 4) {
            expected = "Save" + slot + ".ser";
        } else {
            expected = "Save4.ser";
        }
        assertEquals(expected, filename, "Filename should match for slot " + slot);
    }

    @Test
    void testClearingTheBoard_ShouldSetHexagonStatesToOffAndMakesPlayerOnesTurnTrue() {

        //Mock
        HelloController mockController = mockTheController();
        HelloApplication mockApp = mockTheApp();
        List<Polygon> mockHexagons = mockTheHexagons();

        //When
        when(mockController.getHexagons()).thenReturn(mockHexagons);
        when(mockController.getApp()).thenReturn(mockApp);
        whenTheBoardIsCleared(mockController);

        //Then
        thenHexagonStatesAreOffAndItsPlayerOnesTurn(mockHexagons, mockApp);
    }
    private HelloController mockTheController() {
        return mock(HelloController.class);
    }
    private HelloApplication mockTheApp() {
        return mock(HelloApplication.class);
    }
    private List<Polygon> mockTheHexagons() {
        List<Polygon> mockHexagons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Polygon hex = new Polygon();
            hex.setUserData(HexState.PLAYER2);
            hex.setFill(Color.RED);
            mockHexagons.add(hex);
        }
        return mockHexagons;
    }
    private void whenTheBoardIsCleared(HelloController mockController) {
        SaveAndLoad.clearBoard(mockController);
    }
    private void thenHexagonStatesAreOffAndItsPlayerOnesTurn(List<Polygon> mockHexagons, HelloApplication mockApp) {
        //Assert states and colours are reset
        for (Polygon hex : mockHexagons) {
            assertEquals(HexState.OFF, hex.getUserData());
            assertEquals(Color.GREY, hex.getFill());
        }

        //Verify that setPlayerOneTurn was called on the mockApp
        verify(mockApp, times(1)).setPlayerOneTurn(true);
    }
}
