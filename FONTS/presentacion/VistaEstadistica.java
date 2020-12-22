package presentacion;

import domain.ranking.Stat;
import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class VistaEstadistica {
    @FXML
    public Button AtrasButton;
    @FXML
    public Label nombreUsuarioLabel;
    @FXML
    public TableView<Stat> ranking = new TableView<>();
    CtrlDomain domain = CtrlDomain.getInstance();

    public void initialize() {
        List<Stat> rank;

        rank = domain.getRanking();

        TableColumn posColumn = new TableColumn("Posicio");
        posColumn.setCellValueFactory(new PropertyValueFactory<>("posicio"));

        TableColumn perfilColumn = new TableColumn("Perfil");
        perfilColumn.setCellValueFactory(new PropertyValueFactory<>("perfil"));

        TableColumn puntColumn = new TableColumn("Puntuacion");
        puntColumn.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));

        ranking.getColumns().addAll(posColumn,perfilColumn,puntColumn);

        int pos = 1;
        for (Stat t : rank) {
            t.setPosicion(pos);
            ++pos;
            ranking.getItems().add(t);
        }
    }
}
