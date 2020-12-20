package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaLogIn {
    @FXML
    public Button reanudar;
    @FXML
    public Button restart;
    @FXML
    public Button exit;

    public void initialize() {
        reanudar.setOnMouseClicked((event) -> {
            node node = (Stage) node.getScene().getWindow();
            Prent root = null;
            try {
                root = FXMLLoader.load(getClass.getResource("/VistaPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
        });

        restart.setOnMouseClicked((event) -> {
            node node = (Stage) node.getScene().getWindow();
            Prent root = null;
            try {
                root = FXMLLoader.load(getClass.getResource("/VistaPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
        });

        exit.setOnMouseClicked((event) -> {
            node node = (Stage) node.getScene().getWindow();
            Prent root = null;
            try {
                root = FXMLLoader.load(getClass.getResource("/vistaPerfil.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
        });
    }
    }