package presentacion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Vista gestion partida.
 */
public class VistaGestionPartida {
    /**
     * The Stack pane 1.
     */
    @FXML
    public StackPane StackPane1;
    /**
     * The V box 1.
     */
    @FXML
    public VBox VBox1;
    /**
     * The Border pane 1.
     */
    @FXML
    public BorderPane BorderPane1;
    /**
     * The Title label.
     */
    @FXML
    public Label TitleLabel;
    /**
     * The Separator 1.
     */
    @FXML
    public Separator Separator1;
    /**
     * The Reanudar button.
     */
    @FXML
    public Button ReanudarButton;
    /**
     * The Separator 2.
     */
    @FXML
    public Separator Separator2;
    /**
     * The Restart button.
     */
    @FXML
    public Button RestartButton;
    /**
     * The Separator 3.
     */
    @FXML
    public Separator Separator3;
    /**
     * The Exit button.
     */
    @FXML
    public Button ExitButton;
    /**
     * The Separator 4.
     */
    @FXML
    public Separator Separator4;


    /**
     * Initialize.
     */
    public void initialize() {
        ReanudarButton.setOnMouseClicked((event) -> {
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
            thisStage.setTitle("KakuroMasters");
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
            thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });
    }



}
