package comp20050.hexagonalboard;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloController {

    public static final String FILE_NAME = "Save1.ser";

    @FXML
    private AnchorPane hexBoardPane;

    private List<HexCube> boardHexCubes = new ArrayList<>();

    @FXML
    public void initialize() {

        assert hex1 != null : "fx:id=\"hex1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex2 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex3 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex4 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex5 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex6 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex7 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex8 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex9 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex10 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex12 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex13 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex14 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex15 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex16 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex17 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex18 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex19 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex20 != null : "fx:id=\"hex20\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex21 != null : "fx:id=\"hex21\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex22 != null : "fx:id=\"hex22\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex23 != null : "fx:id=\"hex23\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex24 != null : "fx:id=\"hex24\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex25 != null : "fx:id=\"hex25\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex26 != null : "fx:id=\"hex26\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex27 != null : "fx:id=\"hex27\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex28 != null : "fx:id=\"hex28\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex29 != null : "fx:id=\"hex29\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex30 != null : "fx:id=\"hex30\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex31 != null : "fx:id=\"hex31\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex32 != null : "fx:id=\"hex32\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex33 != null : "fx:id=\"hex33\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex34 != null : "fx:id=\"hex34\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex35 != null : "fx:id=\"hex35\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex36 != null : "fx:id=\"hex36\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex37 != null : "fx:id=\"hex37\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex38 != null : "fx:id=\"hex38\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex39 != null : "fx:id=\"hex39\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex40 != null : "fx:id=\"hex40\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex41 != null : "fx:id=\"hex41\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex42 != null : "fx:id=\"hex42\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex43 != null : "fx:id=\"hex43\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex44 != null : "fx:id=\"hex44\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex45 != null : "fx:id=\"hex45\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex46 != null : "fx:id=\"hex46\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex47 != null : "fx:id=\"hex47\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex48 != null : "fx:id=\"hex48\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex49 != null : "fx:id=\"hex49\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex50 != null : "fx:id=\"hex50\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex51 != null : "fx:id=\"hex51\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex52 != null : "fx:id=\"hex52\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex53 != null : "fx:id=\"hex53\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex54 != null : "fx:id=\"hex54\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex55 != null : "fx:id=\"hex55\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex56 != null : "fx:id=\"hex56\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex57 != null : "fx:id=\"hex57\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex58 != null : "fx:id=\"hex58\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex59 != null : "fx:id=\"hex59\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex60 != null : "fx:id=\"hex60\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex61 != null : "fx:id=\"hex61\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex62 != null : "fx:id=\"hex62\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex63 != null : "fx:id=\"hex63\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex64 != null : "fx:id=\"hex64\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex65 != null : "fx:id=\"hex65\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex66 != null : "fx:id=\"hex66\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex67 != null : "fx:id=\"hex67\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex68 != null : "fx:id=\"hex68\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex69 != null : "fx:id=\"hex69\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex70 != null : "fx:id=\"hex70\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex71 != null : "fx:id=\"hex71\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex72 != null : "fx:id=\"hex72\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex73 != null : "fx:id=\"hex73\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex74 != null : "fx:id=\"hex74\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex75 != null : "fx:id=\"hex75\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex76 != null : "fx:id=\"hex76\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex77 != null : "fx:id=\"hex77\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex78 != null : "fx:id=\"hex78\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex79 != null : "fx:id=\"hex79\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex80 != null : "fx:id=\"hex80\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex81 != null : "fx:id=\"hex81\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex82 != null : "fx:id=\"hex82\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex83 != null : "fx:id=\"hex83\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex84 != null : "fx:id=\"hex84\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex85 != null : "fx:id=\"hex85\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex86 != null : "fx:id=\"hex86\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex87 != null : "fx:id=\"hex87\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex88 != null : "fx:id=\"hex88\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex89 != null : "fx:id=\"hex89\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex90 != null : "fx:id=\"hex90\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex91 != null : "fx:id=\"hex91\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex92 != null : "fx:id=\"hex92\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex93 != null : "fx:id=\"hex93\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex94 != null : "fx:id=\"hex94\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex95 != null : "fx:id=\"hex95\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex96 != null : "fx:id=\"hex96\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex97 != null : "fx:id=\"hex97\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex98 != null : "fx:id=\"hex98\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex99 != null : "fx:id=\"hex99\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex100 != null : "fx:id=\"hex100\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex101 != null : "fx:id=\"hex101\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex102 != null : "fx:id=\"hex102\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex103 != null : "fx:id=\"hex103\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex104 != null : "fx:id=\"hex104\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex105 != null : "fx:id=\"hex105\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex106 != null : "fx:id=\"hex106\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex107 != null : "fx:id=\"hex107\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex108 != null : "fx:id=\"hex108\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex109 != null : "fx:id=\"hex109\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110 != null : "fx:id=\"hex110\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex111 != null : "fx:id=\"hex111\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex112 != null : "fx:id=\"hex112\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex113 != null : "fx:id=\"hex113\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex114 != null : "fx:id=\"hex114\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex115 != null : "fx:id=\"hex115\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex116 != null : "fx:id=\"hex116\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex117 != null : "fx:id=\"hex117\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex118 != null : "fx:id=\"hex118\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex119 != null : "fx:id=\"hex119\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex120 != null : "fx:id=\"hex120\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex121 != null : "fx:id=\"hex121\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex122 != null : "fx:id=\"hex122\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex123 != null : "fx:id=\"hex123\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex124 != null : "fx:id=\"hex124\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex125 != null : "fx:id=\"hex125\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex126 != null : "fx:id=\"hex126\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex127 != null : "fx:id=\"hex127\" was not injected: check your FXML file 'hello-view.fxml'.";


        hexagons.add(hex1);
        hexagons.add(hex2);
        hexagons.add(hex3);
        hexagons.add(hex4);
        hexagons.add(hex5);
        hexagons.add(hex6);
        hexagons.add(hex7);
        hexagons.add(hex8);
        hexagons.add(hex9);
        hexagons.add(hex10);
        hexagons.add(hex11);
        hexagons.add(hex12);
        hexagons.add(hex13);
        hexagons.add(hex14);
        hexagons.add(hex15);
        hexagons.add(hex16);
        hexagons.add(hex17);
        hexagons.add(hex18);
        hexagons.add(hex19);
        hexagons.add(hex20);
        hexagons.add(hex21);
        hexagons.add(hex22);
        hexagons.add(hex23);
        hexagons.add(hex24);
        hexagons.add(hex25);
        hexagons.add(hex26);
        hexagons.add(hex27);
        hexagons.add(hex28);
        hexagons.add(hex29);
        hexagons.add(hex30);
        hexagons.add(hex31);
        hexagons.add(hex32);
        hexagons.add(hex33);
        hexagons.add(hex34);
        hexagons.add(hex35);
        hexagons.add(hex36);
        hexagons.add(hex37);
        hexagons.add(hex38);
        hexagons.add(hex39);
        hexagons.add(hex40);
        hexagons.add(hex41);
        hexagons.add(hex42);
        hexagons.add(hex43);
        hexagons.add(hex44);
        hexagons.add(hex45);
        hexagons.add(hex46);
        hexagons.add(hex47);
        hexagons.add(hex48);
        hexagons.add(hex49);
        hexagons.add(hex50);
        hexagons.add(hex51);
        hexagons.add(hex52);
        hexagons.add(hex53);
        hexagons.add(hex54);
        hexagons.add(hex55);
        hexagons.add(hex56);
        hexagons.add(hex57);
        hexagons.add(hex58);
        hexagons.add(hex59);
        hexagons.add(hex60);
        hexagons.add(hex61);
        hexagons.add(hex62);
        hexagons.add(hex63);
        hexagons.add(hex64);
        hexagons.add(hex65);
        hexagons.add(hex66);
        hexagons.add(hex67);
        hexagons.add(hex68);
        hexagons.add(hex69);
        hexagons.add(hex70);
        hexagons.add(hex71);
        hexagons.add(hex72);
        hexagons.add(hex73);
        hexagons.add(hex74);
        hexagons.add(hex75);
        hexagons.add(hex76);
        hexagons.add(hex77);
        hexagons.add(hex78);
        hexagons.add(hex79);
        hexagons.add(hex80);
        hexagons.add(hex81);
        hexagons.add(hex82);
        hexagons.add(hex83);
        hexagons.add(hex84);
        hexagons.add(hex85);
        hexagons.add(hex86);
        hexagons.add(hex87);
        hexagons.add(hex88);
        hexagons.add(hex89);
        hexagons.add(hex90);
        hexagons.add(hex91);
        hexagons.add(hex92);
        hexagons.add(hex93);
        hexagons.add(hex94);
        hexagons.add(hex95);
        hexagons.add(hex96);
        hexagons.add(hex97);
        hexagons.add(hex98);
        hexagons.add(hex99);
        hexagons.add(hex100);
        hexagons.add(hex101);
        hexagons.add(hex102);
        hexagons.add(hex103);
        hexagons.add(hex104);
        hexagons.add(hex105);
        hexagons.add(hex106);
        hexagons.add(hex107);
        hexagons.add(hex108);
        hexagons.add(hex109);
        hexagons.add(hex110);
        hexagons.add(hex111);
        hexagons.add(hex112);
        hexagons.add(hex113);
        hexagons.add(hex114);
        hexagons.add(hex115);
        hexagons.add(hex116);
        hexagons.add(hex117);
        hexagons.add(hex118);
        hexagons.add(hex119);
        hexagons.add(hex120);
        hexagons.add(hex121);
        hexagons.add(hex122);
        hexagons.add(hex123);
        hexagons.add(hex124);
        hexagons.add(hex125);
        hexagons.add(hex126);
        hexagons.add(hex127);

        //==============================================================================================================

        for (Polygon hexagon : hexagons) {
            HexState state = HexState.OFF;
            hexagon.setUserData(state);
            setHexagonColour(hexagon, state);

            //preserve hex hover functionality
            hexagon.setOnMouseEntered(event -> hexHoverHandler(event));
            hexagon.setOnMouseExited(event -> hexExit(event));

        }

    }

    private Polygon getHexById(String id) {
        try {
            Field field = getClass().getDeclaredField(id);
            field.setAccessible(true);
            return (Polygon) field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HexState getHexState(Polygon hex) {
        Paint fill = hex.getFill();
        if (fill.equals(Color.RED)) return HexState.PLAYER1;
        if (fill.equals(Color.BLUE)) return HexState.PLAYER2;
        return HexState.OFF;
    }

    private void applyHexState(Polygon hex, HexState state) {
        switch (state) {
            case PLAYER1 -> hex.setFill(Color.RED);
            case PLAYER2 -> hex.setFill(Color.BLUE);
            default -> hex.setFill(Color.GREY);
        }
    }



    private static HexagonState[] loadBoard() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HexagonState[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setHexagonColour(Polygon hexagon, HexState state) {
        state = (HexState) hexagon.getUserData();
        switch (state) {
            case PLAYER1:
                hexagon.setFill(Color.RED);
                break;
            case PLAYER2:
                hexagon.setFill(Color.BLUE);
                break;
            case OFF:
            default:
                hexagon.setFill(Color.GREY);
                break;
        }
    }

    //used for calling PlayerTurn in HelloApplication class from getHexID
    private HelloApplication app;

    public void setApp(HelloApplication app) {
        this.app = app;
    }

    private ImageView iviewTick;
    private ImageView iviewX;


    void hexHoverHandler(MouseEvent event) {
        Node hover = (Node) event.getTarget();

        if (hover instanceof Polygon hexagon) {
            checkValidity(hexagon);


            boolean validPlacement = (boolean) hexagon.getUserData();

            if (validPlacement) {
                hexHoverTick(event);
            } else if (!validPlacement) {
                hexHoverX(event);
            }
        }
    }

    void hexHoverTick(MouseEvent event) {

        Node hover = (Node) event.getTarget();

        if (hover instanceof Polygon hexagon) {
            if (hexagon.getFill().equals(Color.GREY)) {
                Image imageTick = new Image(getClass().getResourceAsStream("tick.png"));
                iviewTick = new ImageView(imageTick);

                iviewTick.setFitWidth(50);
                iviewTick.setFitHeight(50);
                iviewTick.setPreserveRatio(true);

                double centerX = hexagon.getBoundsInParent().getCenterX();
                double centerY = hexagon.getBoundsInParent().getCenterY();

                iviewTick.setLayoutX(centerX - iviewTick.getFitWidth() / 2);
                iviewTick.setLayoutY(centerY - iviewTick.getFitHeight() / 2);

                iviewTick.setMouseTransparent(true);
                AnchorPane parent = (AnchorPane) hexagon.getParent();
                parent.getChildren().add(iviewTick);
            }
        }
    }

    void hexHoverX(MouseEvent event) {

        Node hover = (Node) event.getTarget();

        if (hover instanceof Polygon hexagon) {
            if (hexagon.getFill().equals(Color.GREY)) {
                Image imageX = new Image(getClass().getResourceAsStream("x.png"));
                iviewX = new ImageView(imageX);

                iviewX.setFitWidth(50);
                iviewX.setFitHeight(50);
                iviewX.setPreserveRatio(true);

                double centerX = hexagon.getBoundsInParent().getCenterX();
                double centerY = hexagon.getBoundsInParent().getCenterY();

                iviewX.setLayoutX(centerX - iviewX.getFitWidth() / 2);
                iviewX.setLayoutY(centerY - iviewX.getFitHeight() / 2);

                iviewX.setMouseTransparent(true);
                AnchorPane parent = (AnchorPane) hexagon.getParent();
                parent.getChildren().add(iviewX);
            }
        }
    }

    void hexExit(MouseEvent event) {
        Node exit = (Node) event.getTarget();

        if (exit instanceof Polygon hexagon) {
            AnchorPane parent = (AnchorPane) hexagon.getParent();

            if (iviewTick != null && parent.getChildren().contains(iviewTick)) {
                parent.getChildren().remove(iviewTick);
                iviewTick = null;
            }

            if (iviewX != null && parent.getChildren().contains(iviewX)) {
                parent.getChildren().remove(iviewX);
                iviewX = null;
            }
        }
    }


    @FXML
    void getHexID(MouseEvent event) {

        Node click = (Node) event.getTarget();

        //ensure you click a hexagon
        if (click instanceof Polygon hexagon) {
            Paint fill = hexagon.getFill();

            //ensure hexagon is empty
            if (fill.equals(Color.GREY)) {
                boolean isValidNCP = isValidNonCapturingMove(hexagon);
                boolean isValidCP = isValidCapturingMove(hexagon);

                if (isValidNCP || isValidCP) {
                    //HexState currentState = (HexState) hexagon.getUserData();//Toggle between off, player1 or player2
                    hexagon.setUserData(HexState.PLAYER1);
                    checkCaptures(hexagon); //clear opponents stones if surrounded
                    String hexid = hexagon.getId();
                    System.out.println("Hexagon ID: " + hexid);

                    //this stops getHexID being called again for parent AnchorPane
                    //ensures getHexID is only called once for actual hexagon object clicked
                    event.consume();

                    //calls PlayerTurn() off reference to HelloApplication
                    if (app != null) {
                        app.playerTurn(hexagon);
                    } else {
                        System.out.println("error");
                    }
                } else {
                    System.out.println("Invalid move — can't place here!");
                    event.consume();
                }
            } else {
                //make button to show this
                System.out.println("Choose an empty Hexagon");
                event.consume();
            }
        } else{
            System.out.println("INVALID: must click on a hexagon");
            event.consume();
        }


    }

    /**
     * Checks all neighboring hexagons of the most recently placed stone to determine
     * if any opponent groups are captured. If a group is captured,
     * all hexagons in that group are changed to grey.
     * @param placedHex The hexagon where the current player has just placed their stone.
     */


    //check if any opponent groups are captured after valid move
    public void checkCaptures(Polygon placedHex) {
        Paint placedColor = placedHex.getFill();
        Paint opponentColor = placedColor.equals(Color.RED) ? Color.BLUE : Color.RED;
        // Check each neighboring hexagon
        for (Polygon neighbor : getNeighborHexagons(placedHex)) {
            if (neighbor.getFill().equals(opponentColor)) {
                List<Polygon> group = new ArrayList<>();
                if (isCapturedGroup(neighbor, opponentColor, new ArrayList<>(), group)) {
                    //capture group by clearing them
                    for (Polygon captured : group) {
                        captured.setFill(Color.GREY);
                    }
                }
            }
        }
    }

    /**
     * Determines whether a group of opponent-colored hexagons is fully surrounded and can be captured.
     *
     * @param current The current hexagon being checked.
     * @param opponentColor The color of the opponent's stones.
     * @param visited A list of already visited hexagons to avoid reprocessing.
     * @param group The group of hexagons that can be captured.
     * @return true if the group is fully surrounded (capturable); false otherwise.
     */

    private boolean isCapturedGroup(Polygon current, Paint opponentColor, List<Polygon> visited, List<Polygon> group) {
        if (visited.contains(current)) return true;

        visited.add(current);
        group.add(current);

        for (Polygon neighbor : getNeighborHexagons(current)) {
            Paint fill = neighbor.getFill();

            if (fill.equals(Color.GREY)) {
                return false;
            }

            if (fill.equals(opponentColor)) {
                boolean result = isCapturedGroup(neighbor, opponentColor, visited, group);
                if (!result) return false;
            }
        }

        return true; //fully surrounded
    }

    /**
     * Checks if a move is a valid non-capturing move by verifying that the hexagon does not touch any friendly stones.
     * @param hexagon The hexagon to test.
     * @return true if the move is legal and does not connect to any friendly neighbors; false otherwise.
     */

    private boolean isValidNonCapturingMove(Polygon hexagon) {
        List<Polygon> neighbors = getNeighborHexagons(hexagon);

        for (Polygon neighbor : neighbors) {
            Paint fill = neighbor.getFill();
            //not valid NCP if friendly neighbour is found
            if (app.isPlayerOneTurn() && fill.equals(Color.RED)) return false;
            if (!app.isPlayerOneTurn() && fill.equals(Color.BLUE)) return false;
        }

        return true; //only connects to empty or opponents stones
    }

    /**
     * Determines whether placing a stone on the given hexagon is a valid capturing move.
     * A capturing move must form a new group that is larger than all adjacent opponent groups it touches.
     * @param hexagon The hexagon to test for a capturing move.
     * @return true if this is a legal capturing move; false otherwise.
     */

    private boolean isValidCapturingMove(Polygon hexagon) {
        Paint playerColor = app.isPlayerOneTurn() ? Color.RED : Color.BLUE;
        Paint opponentColor = app.isPlayerOneTurn() ? Color.BLUE : Color.RED;

        //make new group starting from placed hex
        List<Polygon> newGroup = new ArrayList<>();
        newGroup.add(hexagon);

        //add all directly connected same colour hexagons to group
        for (Polygon neighbor : getNeighborHexagons(hexagon)) {
            if (neighbor.getFill().equals(playerColor)) {
                expandGroup(neighbor, playerColor, newGroup);
            }
        }

        int newGroupSize = newGroup.size();

        //track all opponent groups
        List<List<Polygon>> opponentGroups = new ArrayList<>();
        // get adjacent opponent groups around new group
        for (Polygon playerHex  : newGroup) {
            for (Polygon neighbor : getNeighborHexagons(playerHex)) {
                if (neighbor.getFill().equals(opponentColor)) {
                    List<Polygon> group = new ArrayList<>();
                    expandGroup(neighbor, opponentColor, group);

                    if (!containsGroup(opponentGroups, group)) {
                        opponentGroups.add(group);
                    }
                }
            }
        }

        //must touch at least one opponent group
        if (opponentGroups.isEmpty()) return false;

        //all touched opponent groups must be smaller than new group
        for (List<Polygon> group : opponentGroups) {
            if (group.size() >= newGroupSize) return false;
        }

        return true;
    }

    /**
     * Recursively adds all directly connected hexagons of the same colour to the specified group.
     * @param start  The starting hexagon for group expansion.
     * @param color  The colour to match during expansion.
     * @param group  The list of hexagons belonging to the group.
     */


    //helper function: adds connected same colour hexes to group
    private void expandGroup(Polygon start, Paint color, List<Polygon> group) {
        if (group.contains(start)) return;
        group.add(start);

        for (Polygon neighbor : getNeighborHexagons(start)) {
            if (neighbor.getFill().equals(color)) {
                expandGroup(neighbor, color, group);
            }
        }
    }


    /**
     * Checks whether a new group already exists in a list of known groups.
     * @param groups A list of existing groups.
     * @param newGroup The new group being checked.
     * @return true if the group is already present in the list; false otherwise.
     */

    //check if group is already in list of existing group
    private boolean containsGroup(List<List<Polygon>> groups, List<Polygon> newGroup) {
        for (List<Polygon> g : groups) {
            if (g.containsAll(newGroup) && newGroup.containsAll(g)) return true;
        }
        return false;
    }

    /**
     * Assigns validity status to the given hexagon by checking for both capturing and non-capturing move legality.
     * @param hexagon The hexagon that we want to validate.
     */

    private void checkValidity(Polygon hexagon) {
        boolean isValid = isValidNonCapturingMove(hexagon) || isValidCapturingMove(hexagon);
        hexagon.setUserData(isValid);
    }

    /**
     * Returns a list of adjacent hexagons for a given hexagon based on its board position.
     * @param hexagon The hexagon for which to find neighbors.
     * @return A list of up to 6 neighboring hexagons.
     */

    //Gets neighbour for given hexagon
    private List<Polygon> getNeighborHexagons(Polygon hexagon) {
        List<Polygon> neighbors = new ArrayList<>();
        int index = hexagons.indexOf(hexagon);

        if (index == -1) return neighbors; // Empty if no hexagon found

        // Convert index to HexCube co-ordinates
        HexCube hex = getHexCubeFromIndex(index);

        // Find positions of neighbouring hexagons
        for (int i = 0; i < 6; i++) { //Any hexagon will have up to 6 neighbours
            HexCube neighborHex = hex.neighbor(i);
            Polygon neighborPolygon = getHexagonFromCube(neighborHex); //Get corresponding polygon

            if (neighborPolygon != null) {
                neighbors.add(neighborPolygon);
            }
        }

        return neighbors;
    }


    /**
     * Converts an index from the list of hexagons into its corresponding HexCube coordinate.
     * @param index The index in the list of hexagons.
     * @return The corresponding HexCube coordinates for that index.
     */

    //Converts a hexagon's index into HexCube coordinate system.
    private HexCube getHexCubeFromIndex(int index) {
        int row = index / 7;
        int col = index % 7;
        int q = col - 3; // Shift to center
        int r = row - 3; // Shift to center
        int s = -q - r;
        return new HexCube(q, r, s);
    }


    /**
     * Finds and returns the Polygon hexagon that matches the given HexCube coordinate.
     * @param hex The HexCube co-ordinate to search for.
     * @return The matching Polygon hexagon, or null if none is found.
     */

    //Finds Polygon hexagon corresponding to a given HexCube co-ordinate.
    private Polygon getHexagonFromCube(HexCube hex) {
        for (int i = 0; i < hexagons.size(); i++) {
            HexCube current = getHexCubeFromIndex(i); //Convert index to HexCube co-ordinates.
            if (current.q == hex.q && current.r == hex.r && current.s == hex.s) {
                return hexagons.get(i); //Return matching hexagon
            }
        }
        return null;
    }

    public HelloApplication getApp() {
        return this.app;
    }

    public void applyLoadedBoard(HexState[] states) {
        if (states != null && states.length == hexagons.size()) {
            for (int i = 0; i < hexagons.size(); i++) {
                Polygon hex = hexagons.get(i);
                hex.setUserData(states[i]);
                setHexagonColour(hex, states[i]);
            }
        } else {
            System.out.println("Invalid or corrupt save file.");
        }
    }

    //==================================================================================================================

    @FXML // fx:id="hex1"
    private Polygon hex1; // Value injected by FXMLLoader

    @FXML // fx:id="hex2"
    private Polygon hex2; // Value injected by FXMLLoader

    @FXML // fx:id="hex3"
    private Polygon hex3; // Value injected by FXMLLoader

    @FXML // fx:id="hex4"
    private Polygon hex4; // Value injected by FXMLLoader

    @FXML // fx:id="hex5"
    private Polygon hex5; // Value injected by FXMLLoader

    @FXML // fx:id="hex6"
    private Polygon hex6; // Value injected by FXMLLoader

    @FXML // fx:id="hex7"
    private Polygon hex7; // Value injected by FXMLLoader

    @FXML // fx:id="hex8"
    private Polygon hex8; // Value injected by FXMLLoader

    @FXML // fx:id="hex9"
    private Polygon hex9; // Value injected by FXMLLoader

    @FXML // fx:id="hex10"
    private Polygon hex10; // Value injected by FXMLLoader

    @FXML // fx:id="hex11"
    private Polygon hex11; // Value injected by FXMLLoader

    @FXML // fx:id="hex12"
    private Polygon hex12; // Value injected by FXMLLoader

    @FXML // fx:id="hex13"
    private Polygon hex13; // Value injected by FXMLLoader

    @FXML // fx:id="hex14"
    private Polygon hex14; // Value injected by FXMLLoader

    @FXML // fx:id="hex15"
    private Polygon hex15; // Value injected by FXMLLoader

    @FXML // fx:id="hex16"
    private Polygon hex16; // Value injected by FXMLLoader

    @FXML // fx:id="hex17"
    private Polygon hex17; // Value injected by FXMLLoader

    @FXML // fx:id="hex18"
    private Polygon hex18; // Value injected by FXMLLoader

    @FXML // fx:id="hex19"
    private Polygon hex19; // Value injected by FXMLLoader

    @FXML
    private Polygon hex20;

    @FXML
    private Polygon hex21;

    @FXML
    private Polygon hex22;

    @FXML
    private Polygon hex23;

    @FXML
    private Polygon hex24;

    @FXML
    private Polygon hex25;

    @FXML
    private Polygon hex26;

    @FXML
    private Polygon hex27;

    @FXML
    private Polygon hex28;

    @FXML
    private Polygon hex29;

    @FXML
    private Polygon hex30;

    @FXML
    private Polygon hex31;

    @FXML
    private Polygon hex32;

    @FXML
    private Polygon hex33;

    @FXML
    private Polygon hex34;

    @FXML
    private Polygon hex35;

    @FXML
    private Polygon hex36;

    @FXML
    private Polygon hex37;

    @FXML
    private Polygon hex38;

    @FXML
    private Polygon hex39;

    @FXML
    private Polygon hex40;

    @FXML
    private Polygon hex41;

    @FXML
    private Polygon hex42;

    @FXML
    private Polygon hex43;

    @FXML
    private Polygon hex44;

    @FXML
    private Polygon hex45;

    @FXML
    private Polygon hex46;

    @FXML
    private Polygon hex47;

    @FXML
    private Polygon hex48;

    @FXML
    private Polygon hex49;

    @FXML
    private Polygon hex50;

    @FXML
    private Polygon hex51;

    @FXML
    private Polygon hex52;

    @FXML
    private Polygon hex53;

    @FXML
    private Polygon hex54;

    @FXML
    private Polygon hex55;

    @FXML
    private Polygon hex56;

    @FXML
    private Polygon hex57;

    @FXML
    private Polygon hex58;

    @FXML
    private Polygon hex59;

    @FXML
    private Polygon hex60;

    @FXML
    private Polygon hex61;

    @FXML
    private Polygon hex62;

    @FXML
    private Polygon hex63;

    @FXML
    private Polygon hex64;

    @FXML
    private Polygon hex65;

    @FXML
    private Polygon hex66;

    @FXML
    private Polygon hex67;

    @FXML
    private Polygon hex68;

    @FXML
    private Polygon hex69;

    @FXML
    private Polygon hex70;

    @FXML
    private Polygon hex71;

    @FXML
    private Polygon hex72;

    @FXML
    private Polygon hex73;

    @FXML
    private Polygon hex74;

    @FXML
    private Polygon hex75;

    @FXML
    private Polygon hex76;

    @FXML
    private Polygon hex77;

    @FXML
    private Polygon hex78;

    @FXML
    private Polygon hex79;

    @FXML
    private Polygon hex80;

    @FXML
    private Polygon hex81;

    @FXML
    private Polygon hex82;

    @FXML
    private Polygon hex83;

    @FXML
    private Polygon hex84;

    @FXML
    private Polygon hex85;

    @FXML
    private Polygon hex86;

    @FXML
    private Polygon hex87;

    @FXML
    private Polygon hex88;

    @FXML
    private Polygon hex89;

    @FXML
    private Polygon hex90;

    @FXML
    private Polygon hex91;

    @FXML
    private Polygon hex92;

    @FXML
    private Polygon hex93;

    @FXML
    private Polygon hex94;

    @FXML
    private Polygon hex95;

    @FXML
    private Polygon hex96;

    @FXML
    private Polygon hex97;

    @FXML
    private Polygon hex98;

    @FXML
    private Polygon hex99;

    @FXML
    private Polygon hex100;

    @FXML
    private Polygon hex101;

    @FXML
    private Polygon hex102;

    @FXML
    private Polygon hex103;

    @FXML
    private Polygon hex104;

    @FXML
    private Polygon hex105;

    @FXML
    private Polygon hex106;

    @FXML
    private Polygon hex107;

    @FXML
    private Polygon hex108;

    @FXML
    private Polygon hex109;

    @FXML
    private Polygon hex110;

    @FXML
    private Polygon hex111;

    @FXML
    private Polygon hex112;

    @FXML
    private Polygon hex113;

    @FXML
    private Polygon hex114;

    @FXML
    private Polygon hex115;

    @FXML
    private Polygon hex116;

    @FXML
    private Polygon hex117;

    @FXML
    private Polygon hex118;

    @FXML
    private Polygon hex119;

    @FXML
    private Polygon hex120;

    @FXML
    private Polygon hex121;

    @FXML
    private Polygon hex122;

    @FXML
    private Polygon hex123;

    @FXML
    private Polygon hex124;

    @FXML
    private Polygon hex125;

    @FXML
    private Polygon hex126;

    @FXML
    private Polygon hex127;

    List<Polygon> hexagons = new ArrayList<>();

    public List<Polygon> getHexagons() {
        return hexagons;
    }

}
