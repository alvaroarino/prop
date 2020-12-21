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

    public void initialize() {

        AleatButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });
    }

}

