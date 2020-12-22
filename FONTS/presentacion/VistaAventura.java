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
import javafx.scene.layout.GridPane;
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
    @FXML
    GridPane panel_aventuras;


    public void initialize() {
        CtrlDomain domain = CtrlDomain.getInstance();
        LabelPerfil.setText(domain.perfilActual.getNom());
        Button uno = new Button();


        int n = domain.num_kakuros_aventura;


        if(n == 5) {
            int x = 1;
            for (int i = 0; i < n; i++) {

                    uno.setText("nivel" + x );
                    panel_aventuras.add(uno,0,i);
                    ++x;

            }

        }

        if(n == 10) {
            int x = 1;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    uno.setText("nivel" + x );
                    panel_aventuras.add(uno,i,j);
                    ++x;
                }
            }

        }

        if(n == 15) {
            int x = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    uno.setText("nivel" + x );
                    panel_aventuras.add(uno,i,j);
                    ++x;
                }
            }

        }



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
