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

/**
 * The type Vista partida.
 */
public class VistaPartida {
    /**
     * The Button salir.
     */
    @FXML
    public Button ButtonSalir;
    /**
     * The Label perfil.
     */
    @FXML
    public Label LabelPerfil;
    /**
     * The Time label.
     */
    @FXML
    public Label timeLabel;
    /**
     * The Button pausa.
     */
    @FXML
    public Button ButtonPausa;
    /**
     * The Check button.
     */
    @FXML
    public Button CheckButton;
    /**
     * The Kakuro grid pane.
     */
    @FXML
    public GridPane KakuroGridPane;


    /**
     * The Label sol.
     */
    @FXML
    public Label LabelSol;

    /**
     * The Domain.
     */
    CtrlDomain domain = CtrlDomain.getInstance();
    /**
     * The Generated.
     */
    Kakuro generated = new Kakuro();
    /**
     * The Timer.
     */
    Timer timer = new Timer();
    /**
     * The Time.
     */
    int time = 0;

    /**
     * Gets node by row column index.
     *
     * @param row      the row
     * @param column   the column
     * @param gridPane the grid pane
     * @return the node by row column index
     */
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

    /**
     * Initialize.
     */
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
                if(value.equals("Enhorabona, has solucionat el kakuro!")){
                    String dif = generated.getBoard().getDificulty();
                    int aux = 0;
                    if(dif.equals("facil")) {
                        aux = 300 - time;
                    }
                    else if(dif.equals("medio")) {
                        aux = 600 - time;
                    }
                    else if(dif.equals("hard")){
                        aux = 900 - time;
                    }
                    int punt = (int)aux;

                    if(aux != 0) {
                        if (!domain.perfilActual.conteKakuro(domain.kakuro.getId())) {
                            domain.rankActual.afegirIndex(domain.perfilActual.getNom(), punt);
                            domain.perfilActual.addKakuro(domain.kakuro.getId());
                            try{
                                domain.storeRanking();
                            } catch(IOException p) {
                                p.printStackTrace();
                            }
                        }
                    }
                }
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