package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Vista aventura.
 */
public class VistaAventura  {

    /**
     * The Time label.
     */
    @FXML
    Label LabelPerfil;
    @FXML
    Button AtrasButton;


    public void initialize() {
        CtrlDomain domain = CtrlDomain.getInstance();
        LabelPerfil.setText(domain.perfilActual.getNom());


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
