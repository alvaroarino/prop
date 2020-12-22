package presentacion;

import domain.cella.Cella;
import domain.cella.ColorCella;
import domain.kakuro.Kakuro;
import domain.kakuro.Tauler;
import domaincontrollers.CtrlDomain;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.print.Collation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class VistaPartida {
    @FXML
    public Button ButtonSalir;
    @FXML
    public Label LabelPerfil;
    @FXML
    public Label timeLabel;
    @FXML
    public Button ButtonPausa;
    @FXML
    public Button CheckButton;
    @FXML
    public GridPane KakuroGridPane;
    @FXML
    public Button PistaButton;

    @FXML
    public Label LabelSol;

    CtrlDomain domain = CtrlDomain.getInstance();
    Kakuro generated = new Kakuro();
    Timer timer = new Timer();
    int time = 0;

    public Node getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for(Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    public void initialize() {




        Tauler board = generated.getBoard();
        int nSolucions;
        System.out.println(domain.tipoEntrada);
        if (domain.tipoEntrada == 1)  {

            generated.generar();
            board = generated.getBoard();
        } else if (domain.tipoEntrada == 2) {
            generated = new Kakuro(domain.n, domain.m);
            generated.generar_usuario(domain.negras, domain.valor);
            board = generated.getBoard();
        }

        else if (domain.tipoEntrada == 3) {
            generated = domain.kakuro;

            board = generated.getBoard();
        }



        for (int i = 0; i < board.getDimn(); i++) {
            for (int j = 0; j < board.getDimm(); j++) {
                Cella cella = board.getCella(i, j);
                TextField tf = new TextField();
                if (cella.color() == ColorCella.Blanca) {
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setEditable(true);
                    if (cella.getValor_blanca() != -1  ) {
                        tf.setText("" + cella.getValor_blanca());
                    } else {
                        tf.setText("");
                    }
                } else if (cella.color() == ColorCella.Negra) {
                    tf.setStyle("-fx-control-inner-background: #000000");
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setEditable(false);
                    if (cella.getValorEsquerre() != -1 && cella.getValorDret() != -1) {
                        tf.setText(cella.getValorEsquerre() + " / " + cella.getValorDret());
                    } else if (cella.getValorEsquerre() != -1 && cella.getValorDret() == -1) {
                        tf.setText("" + cella.getValorEsquerre());
                    } else if (cella.getValorEsquerre() == -1 && cella.getValorDret() != -1) {
                        tf.setText("" + cella.getValorDret());
                    } else {
                        tf.setText("");
                    }
                }
                KakuroGridPane.add(tf, j, i);
            }
        }

        nSolucions = generated.getBoard().solve();

        LabelSol.setText(String.valueOf(nSolucions));

        LabelPerfil.setText(domain.perfilActual.getNom());
        timeLabel.setText(String.format("%s seg", time));
        TimerTask task = new TimerTask() {
            public void run() {
                time += 1;
                Platform.runLater(() -> timeLabel.setText(String.format("%s seg", time)));
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

        ButtonPausa.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaGestionPartida.fxml"));
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


        CheckButton.setOnMouseClicked((event) -> {
            Kakuro kComprobar = generated;
            Tauler b = kComprobar.getBoard();
            for (int i = 0; i < b.getDimn(); i++) {
                for (int j = 0; j < b.getDimm(); j++) {
                    if (b.getCella(i,j).color() == ColorCella.Blanca) {
                        int old = b.getCella(i, j).getValor_blanca();
                        int actual = Integer.parseInt(((TextField) getNodeByRowColumnIndex(i,j,KakuroGridPane)).getText());
                        if (old != actual) b.setCellaBlanca(i, j, actual);
                    }
                }
            }
            String value = b.validar();

            Stage popupwindow = new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Validación del Kakuro");

            Button saveButton = new Button("Ok");
            saveButton.setOnAction(e -> {
                popupwindow.close();
            });

            Label validLabel = new Label(value);

            VBox layout = new VBox(10);
            layout.getChildren().addAll(validLabel, saveButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene1 = new Scene(layout, 300, 250);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();



        });


            PistaButton.setOnMouseClicked((event) -> {
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaGestionPartida.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        });

        ButtonSalir.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistaGestionPartida.fxml"));
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