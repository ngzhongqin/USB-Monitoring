module com.ngzhongqin.usbmonitoring {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.ngzhongqin.usbmonitoring to javafx.fxml;
    exports com.ngzhongqin.usbmonitoring;
}