package presentacion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaSelectorPartida {
    @FXML
    public Button AtrasButton;
    @FXML
    public Label nombreUsuarioLabel;
    @FXML
    public Button CincoButton;
    @FXML
    public Button DiezButton;
    @FXML
    public Button QuinceButton;
    @FXML
    public Button PreButton;
    @FXML
    public Button AleatButton;

    @FXML
    public Button ImportarButton;

    public void initialize() {

        AleatButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

