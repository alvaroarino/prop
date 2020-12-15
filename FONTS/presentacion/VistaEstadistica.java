package presentacion;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import domain.ranking.Stat;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaEstadistica {
    @FXML
    private TableView<Stat> ranking = new TableView<Stat>();
    private final ObservableList<Stat> data =
            FXCollections.observableArrayList(
                    new Stat("A", 100),
                    new Stat("B", 200),
                    new Stat("C", 300)
            );

    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        //stage.setWidth();
        //stage.setHeight();

        ranking.setEditable(true);

        TableColumn posicionCol = new TableColumn("Posición");
        posicionCol.setCellValueFactory(new PropertyValueFactory<Stat, Integer>("posicion"));

        TableColumn usuarioCol = new TableColumn("Usuario");
        usuarioCol.setCellValueFactory(
                new PropertyValueFactory<Stat, String>("usuario")
        );

        TableColumn puntuacionCol = new TableColumn("Puntuación");
        puntuacionCol.setCellValueFactory(
                new PropertyValueFactory<Stat, Integer>("puntuacion")
        );

        ranking.setItems(data);
        ranking.getColumns().addAll(posicionCol,usuarioCol,puntuacionCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(ranking);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
