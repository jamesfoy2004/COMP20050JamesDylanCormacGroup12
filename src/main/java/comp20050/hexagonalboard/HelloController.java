package comp20050.hexagonalboard;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;


import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.BLACK;

public class HelloController {
    @FXML
    private AnchorPane hexBoardPane;

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

    }

    @FXML
    void getHexID(MouseEvent event) {
        Polygon hexagon = (Polygon) event.getSource();
        hexagon.setFill(BLACK);
    }

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
}
