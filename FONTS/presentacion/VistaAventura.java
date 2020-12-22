package presentacion;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Vista aventura.
 */
public class VistaAventura implements Initializable {

    /**
     * The Time label.
     */
    @FXML
    Label timeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeLabel.setText("Hola");

    }
}
