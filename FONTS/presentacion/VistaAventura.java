package presentacion;

import dades.CtrlDades;
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

import java.io.File;
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
    /**
     * The Atras button.
     */
    @FXML
    Button AtrasButton;
    /**
     * The Panel aventura.
     */
    @FXML
    GridPane panelAventura;


    /**
     * Initialize.
     */
    public void initialize() {
        CtrlDomain domain = CtrlDomain.getInstance();
        LabelPerfil.setText(domain.perfilActual.getNom());

        int n = domain.num_kakuros_aventura;

        if (n == 5) {
            int x = 1;
            for (int i = 0; i < n; i++) {

                Button button = new Button();
                button.setText("Nivel" + x + " medio");
                button.setPrefWidth(100);
                int finalX = x;
                button.setOnMouseClicked(event -> {
                    Node node = (Node) event.getSource();
                    Stage thisStage = (Stage) node.getScene().getWindow();
                    domain.tipoEntrada = 3;
                    try {
                        CtrlDades dades = CtrlDades.getInstance();
                        System.out.println((getClass().getResource("/Aventura" + finalX + ".txt").getPath()));
                        File f = new File(getClass().getResource("/Aventura" + finalX + ".txt").getPath());
                        domain.kakuro = dades.leer_kakuro(f.getAbsolutePath());
                        domain.kakuro.getBoard().print();
                        Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                        Scene scene = new Scene(root);
                        thisStage.setTitle("KakuroMasters");
                        thisStage.setScene(scene);
                        thisStage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                panelAventura.add(button,i,0);
                ++x;
            }
        }

        if (n == 10 || n == 15) {
            int x = 1;
            for (int i = 0; i < n/5; i++) {
                for (int j = 0; j < 5; j++) {
                    Button button = new Button();
                    button.setText("Nivel" + x + " medio");
                    button.setPrefWidth(100);

                    int finalX = x;
                    button.setOnMouseClicked(event -> {
                        Node node = (Node) event.getSource();
                        Stage thisStage = (Stage) node.getScene().getWindow();
                        domain.tipoEntrada = 3;
                        try {
                            CtrlDades dades = CtrlDades.getInstance();
                            System.out.println((getClass().getResource("/Aventura" + finalX + ".txt").getPath()));
                            File f = new File(getClass().getResource("/Aventura" + finalX + ".txt").getPath());
                            domain.kakuro = dades.leer_kakuro(f.getAbsolutePath());
                            domain.kakuro.getBoard().print();
                            Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                            Scene scene = new Scene(root);
                            thisStage.setTitle("KakuroMasters");
                            thisStage.setScene(scene);
                            thisStage.show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    panelAventura.add(button,j,i);
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
