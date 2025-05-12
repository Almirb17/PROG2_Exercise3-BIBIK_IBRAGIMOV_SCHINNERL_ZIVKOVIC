package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.exceptions.DatabaseException;
import javafx.scene.control.Alert;

public class AlertHandler {

    public static void throwAlert(DatabaseException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setContentText(e.getMessage());
        alert.setHeaderText("Your Exception Message");
        alert.showAndWait();

    }
}
