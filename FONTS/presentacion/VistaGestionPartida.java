package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class VistaGestionPartida {

    @FXML
    public Label TitleLabel;
    @FXML
    public Button ReanudarButton;
    @FXML
    public Button RestartButton;
    @FXML
    public Button ExitButton;


    public void initialize() {
        ReanudarButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            //thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });

        RestartButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            //thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });

        ExitButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPrincipal.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            //thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });
    }
}
