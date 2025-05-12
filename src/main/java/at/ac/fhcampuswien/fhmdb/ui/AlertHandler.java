package at.ac.fhcampuswien.fhmdb.ui;

import javafx.scene.control.Alert;

public class AlertHandler {
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fehler");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

