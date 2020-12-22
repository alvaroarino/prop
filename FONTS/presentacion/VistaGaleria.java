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
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * The type Vista galeria.
 */
public class VistaGaleria {
    /**
     * The Panel galeria.
     */
    @FXML
    public GridPane PanelGaleria;

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
     * Initialize.
     */
    public void initialize() {
        CtrlDomain domain = CtrlDomain.getInstance();

        nombreUsuarioLabel.setText(domain.perfilActual.getNom());

        int n = 20;
        int x = 1;
        for (int i = 0; i < 10; i++) {
            Button button = new Button();
            button.setText("Easy");
            button.setPrefWidth(100);
            int finalX = x;
            button.setOnMouseClicked(event -> {
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                domain.tipoEntrada = 3;
                try {
                    CtrlDades dades = CtrlDades.getInstance();
                    System.out.println((getClass().getResource("/Facil" + finalX + ".txt").getPath()));
                    File f = new File(getClass().getResource("/Facil" + finalX + ".txt").getPath());
                    domain.kakuro = dades.leer_kakuro(f.getAbsolutePath());
                    domain.kakuro.getBoard().print();
                    domain.kakuro.getBoard().setDificulty("facil");
                    domain.kakuro.setId("facil"+finalX);
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            PanelGaleria.add(button,i,0);
            ++x;
        }
        x = 1;
        for (int i = 0; i < 5; i++) {
            Button button = new Button();
            button.setText("Medium");
            button.setPrefWidth(100);
            int finalX = x;
            button.setOnMouseClicked(event -> {
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                domain.tipoEntrada = 3;
                try {
                    CtrlDades dades = CtrlDades.getInstance();
                    System.out.println((getClass().getResource("/Medio" + finalX + ".txt").getPath()));
                    File f = new File(getClass().getResource("/Medio" + finalX + ".txt").getPath());
                    domain.kakuro = dades.leer_kakuro(f.getAbsolutePath());
                    domain.kakuro.getBoard().print();
                    domain.kakuro.getBoard().setDificulty("medio");
                    domain.kakuro.setId("medio"+finalX);
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            PanelGaleria.add(button,i,1);
            ++x;
        }

        x = 1;
        for (int i = 0; i < 5; i++) {
            Button button = new Button();
            button.setText("Hard");
            button.setPrefWidth(100);
            int finalX = x;
            button.setOnMouseClicked(event -> {
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                domain.tipoEntrada = 3;
                try {
                    CtrlDades dades = CtrlDades.getInstance();
                    System.out.println((getClass().getResource("/Hard" + finalX + ".txt").getPath()));
                    File f = new File(getClass().getResource("/Hard" + finalX + ".txt").getPath());
                    domain.kakuro = dades.leer_kakuro(f.getAbsolutePath());
                    domain.kakuro.getBoard().print();
                    domain.kakuro.getBoard().setDificulty("hard");
                    domain.kakuro.setId("hard"+finalX);
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            PanelGaleria.add(button,i,2);
            ++x;
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
