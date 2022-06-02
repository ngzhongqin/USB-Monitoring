package com.ngzhongqin.usbmonitoring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.setTitle("USB Monitoring");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        waitForNotifying();
        launch();
    }

    static File[] oldListRoot = File.listRoots();

    public static void waitForNotifying() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (File.listRoots().length > oldListRoot.length) {
                        System.out.println("new drive detected");
                        oldListRoot = File.listRoots();
                        System.out.println("drive"+oldListRoot[oldListRoot.length-1]+" detected");

                    } else if (File.listRoots().length < oldListRoot.length) {
                        System.out.println(oldListRoot[oldListRoot.length-1]+" drive removed");

                        oldListRoot = File.listRoots();

                    }

                }
            }
        });
        t.start();
    }
}