package com.ngzhongqin.usbmonitoring;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Random: "+rand());
    }

    private int rand(){
        return new Random().nextInt();
    }

}