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


public class VistaAjustesPredefinidos {
    @FXML
    public Button ButtonEmpezar;
    @FXML
    public Label nombreUsuarioLabel1;
    @FXML
    public TextField TextFieldCol;
    @FXML
    public TextField TextFieldNegras;
    @FXML
    public TextField TextFieldFil;
    @FXML
    public TextField TextFieldValor;

    CtrlDomain domain = CtrlDomain.getInstance();

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
    }
}
