package presentacion;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaPartida implements Initializable {



    @FXML
    Label timeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeLabel.setText("Hola");

    }
}
