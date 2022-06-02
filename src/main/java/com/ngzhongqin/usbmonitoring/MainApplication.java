package com.ngzhongqin.usbmonitoring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
//        waitForNotifying();
        setIcon();
        launch();
    }

    private static void setIcon(){
        try {
            //loading an image from a file
            final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            final URL imageResource = MainApplication.class.getResource("/icon.png");
            final Image image = defaultToolkit.getImage(imageResource);
            //this is new since JDK 9
            final Taskbar taskbar = Taskbar.getTaskbar();
            //set icon for mac os (and other systems which do support this method)
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
            System.out.println("The os does not support: 'taskbar.setIconImage'");
        } catch (final SecurityException e) {
            System.out.println("There was a security exception for: 'taskbar.setIconImage'");
        }
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