package presentacion;

import dades.CtrlDades;
import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * The type Vista selector partida.
 */
public class VistaSelectorPartida {
    /**
     * The Atras button.
     */
    @FXML
    public Button AtrasButton;
    /**
     * The Nombre usuario label.
     */
    @FXML
    public Label nombreUsuarioLabel;
    /**
     * The Cinco button.
     */
    @FXML
    public Button CincoButton;
    /**
     * The Diez button.
     */
    @FXML
    public Button DiezButton;
    /**
     * The Quince button.
     */
    @FXML
    public Button QuinceButton;
    /**
     * The Pre button.
     */
    @FXML
    public Button PreButton;
    /**
     * The Aleat button.
     */
    @FXML
    public Button AleatButton;
    /**
     * The Importar button.
     */
    @FXML
    public Button ImportarButton;

    /**
     * Initialize.
     */
    public void initialize() {
        CtrlDomain domain = CtrlDomain.getInstance();
        nombreUsuarioLabel.setText(domain.perfilActual.getNom());

        AleatButton.setOnMouseClicked((event) -> {
            domain.tipoEntrada = 1;
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

        PreButton.setOnMouseClicked((event) -> {
            domain.tipoEntrada = 2;
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaAjustesPredefinidos.fxml"));
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        CincoButton.setOnMouseClicked((event) -> {

            domain.num_kakuros_aventura = 5;
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaAventura.fxml"));
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        DiezButton.setOnMouseClicked((event) -> {

            domain.num_kakuros_aventura = 10;

            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaAventura.fxml"));
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        QuinceButton.setOnMouseClicked((event) -> {

            domain.num_kakuros_aventura = 15;

            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaAventura.fxml"));
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ImportarButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();

            domain.tipoEntrada = 3;

            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File file = fileChooser.showOpenDialog(thisStage);
                if (file != null) {
                    CtrlDades dades = CtrlDades.getInstance();
                    domain.kakuro = dades.leer_kakuro(file.getPath());
                    domain.kakuro.getBoard().print();
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        AtrasButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaPrincipal.fxml"));
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

