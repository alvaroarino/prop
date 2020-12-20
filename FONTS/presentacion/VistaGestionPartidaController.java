public class VistaGestionPartidaController {
    @FXML
    public StackPane StackPane1;
    @FXML
    public VBox VBox1;
    @FXML
    public BorderPane BorderPane1;
    @FXML
    public Label TitleLabel;
    @FXML
    public Separator Separator1;
    @FXML
    public Button ReanudarButton;
    @FXML
    public Separator Separator2;
    @FXML
    public Button RestartButton;
    @FXML
    public Separator Separator3;
    @FXML
    public Button ExitButton;
    @FXML
    public Separator Separator4;

    public void initialize() {
        ReanudarButton.setOnMouseClicked((event) -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/vistaPartida.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            //thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
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
            //thisStage.setTitle("KakuroMasters");
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
            //thisStage.setTitle("KakuroMasters");
            thisStage.setScene(scene);
            thisStage.show();
        });
}
