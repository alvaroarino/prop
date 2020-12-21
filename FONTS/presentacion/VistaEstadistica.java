package presentacion;

import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import domain.ranking.Stat;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VistaEstadistica {
    CtrlDomain domain = CtrlDomain.getInstance();
    @FXML
    private TableView<Stat> ranking = new TableView<Stat>();

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
