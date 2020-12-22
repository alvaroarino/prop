package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * The type Vista principal.
 */
public class VistaPrincipal {
    /**
     * The Nombre usuario label.
     */
    @FXML
    public Label nombreUsuarioLabel;
    /**
     * The Jugar button.
     */
    @FXML
    public Button JugarButton;
    /**
     * The Galeria button.
     */
    @FXML
    public Button GaleriaButton;
    /**
     * The Estadisticas button.
     */
    @FXML
    public Button EstadisticasButton;
    /**
     * The Ajustes button.
     */
    @FXML
    public Button manualButton;
    /**
     * The Perfil button.
     */
    @FXML
    public Button PerfilButton;
    /**
     * The Salir button.
     */
    @FXML
    public Button SalirButton;

    /**
     * The Domain.
     */
    CtrlDomain domain = CtrlDomain.getInstance();

    /**
     * Initialize.
     */
    public void initialize() {
        nombreUsuarioLabel.setText(domain.perfilActual.getNom());

        JugarButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaSelectorPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });

        GaleriaButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaGaleria.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });

        EstadisticasButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaEstadistica.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });

        manualButton.setOnMouseClicked((event) -> {
            HostServices hostServices = CtrlPresentacion.getInstance().getHostServices();
            hostServices.showDocument(getClass().getResource("/manual.pdf").toString());
        });

        PerfilButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });

        SalirButton.setOnMouseClicked((event) -> {
            /*
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();

             */
        });



    }
}
