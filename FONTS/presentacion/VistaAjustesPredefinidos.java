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


/**
 * The type Vista ajustes predefinidos.
 */
public class VistaAjustesPredefinidos {
    /**
     * The Button empezar.
     */
    @FXML
    public Button ButtonEmpezar;
    /**
     * The Atras button.
     */
    @FXML
    public Button AtrasButton;
    /**
     * The Nombre usuario label 1.
     */
    @FXML
    public Label nombreUsuarioLabel1;
    /**
     * The Text field col.
     */
    @FXML
    public TextField TextFieldCol;
    /**
     * The Text field negras.
     */
    @FXML
    public TextField TextFieldNegras;
    /**
     * The Text field fil.
     */
    @FXML
    public TextField TextFieldFil;
    /**
     * The Text field valor.
     */
    @FXML
    public TextField TextFieldValor;

    /**
     * The Domain.
     */
    CtrlDomain domain = CtrlDomain.getInstance();

    /**
     * Initialize.
     */
    public void initialize() {
        nombreUsuarioLabel1.setText(domain.perfilActual.getNom());

        ButtonEmpezar.setOnMouseClicked((event) -> {

            domain.n = Integer.parseInt(TextFieldFil.getText());
            domain.m = Integer.parseInt(TextFieldCol.getText());
            domain.negras = Integer.parseInt(TextFieldNegras.getText());
            domain.valor = Integer.parseInt(TextFieldValor.getText());


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

        AtrasButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaSelectorPartida.fxml"));
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
