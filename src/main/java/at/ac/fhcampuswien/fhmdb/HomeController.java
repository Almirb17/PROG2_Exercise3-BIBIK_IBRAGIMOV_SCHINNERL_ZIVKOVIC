package at.ac.fhcampuswien.fhmdb;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class HomeController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburgerNav;

    private boolean isMenuCollapsed = true;

    public void initialize(){
        initHamburger();
        setContent("MovieList.fxml");
    }

    private void initHamburger() {
        hamburgerNav.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toggleMenuDrawer());
    }

    public void toggleMenuDrawer() {
        if (isMenuCollapsed) {
            drawer.open();
        } else {
            drawer.close();
        }
        isMenuCollapsed = !isMenuCollapsed;
    }

    public void setContent(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/ac/fhcampuswien/fhmdb/" + fxmlPath));
            Parent content = loader.load();
            mainPane.setCenter(content);
        } catch (IOException e) {
            System.err.println("Fehler beim Laden von: " + fxmlPath);
            e.printStackTrace();
        }

        // Optional: Menü zuklappen nach Navigation
        if (!isMenuCollapsed) {
            toggleMenuDrawer();
        }
    }


    @FXML
    public void navigateToMovielist(ActionEvent event) {

    }

    @FXML
    public void navigateToWatchlist(ActionEvent event) {

    }
}
