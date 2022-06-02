module com.ngzhongqin.usbmonitoring {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.ngzhongqin.usbmonitoring to javafx.fxml;
    exports com.ngzhongqin.usbmonitoring;
}