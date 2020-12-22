package presentacion;

import domain.ranking.Stat;
import domaincontrollers.CtrlDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class VistaEstadistica {
    @FXML
    public Button AtrasButton;
    @FXML
    public Label nombreUsuarioLabel;
    @FXML
    public TableView<Stat> ranking = new TableView<>();
    CtrlDomain domain = CtrlDomain.getInstance();

    private final ObservableList<Stat> data = FXCollections.observableArrayList();

    public void initialize() {

        nombreUsuarioLabel.setText(domain.perfilActual.getNom());
        List<Stat> rank = domain.getRanking();
        int pos = 1;
        for (Stat t : rank) {
            t.setPosicion(pos);
            ++pos;
            data.add(t);
        }

        TableColumn posColumn = new TableColumn("Posicio");
        posColumn.setCellValueFactory(new PropertyValueFactory<>("posicio"));

        TableColumn perfilColumn = new TableColumn("Perfil");
        perfilColumn.setCellValueFactory(new PropertyValueFactory<>("perfil"));

        TableColumn puntColumn = new TableColumn("Puntuacion");
        puntColumn.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));

        ranking.getColumns().addAll(posColumn,perfilColumn,puntColumn);

        ranking.setItems(data);
        ranking.getColumns().addAll(posColumn, perfilColumn, puntColumn);

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
