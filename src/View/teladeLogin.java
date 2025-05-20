package View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teladeLogin extends Application {
    private boolean darkMode = false;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar imagens

        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));


        // Configuração do layout principal
        BorderPane mainPane = new BorderPane();


        Label lblTitulo = new Label("Faça seu login");
        lblTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        lblTitulo.setTextFill(Color.BROWN);

        HBox headerBox = new HBox(15, lblTitulo);
        headerBox.setAlignment(Pos.TOP_CENTER);
        headerBox.setPadding(new Insets(20));

        // Formulário de login
        GridPane loginGrid = new GridPane();
        loginGrid.setPrefSize(200, 150);
        loginGrid.setMaxSize(30, 20);
        loginGrid.setMinSize(300, 200);
        loginGrid.setAlignment(Pos.TOP_CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(20));

        // Campo de email
        Label lblEmail = new Label("Email:");
        lblEmail.setStyle("-fx-font-weight: bold;");
        TextField txtEmail = new TextField();

        txtEmail.setPromptText("Digite seu email");

        // Campo de senha
        Label lblSenha = new Label("Senha:");
        lblSenha.setStyle("-fx-font-weight: bold;");

        // Campo de senha oculta
        PasswordField pfSenha = new PasswordField();
        pfSenha.setPromptText("Digite sua senha");



        // Campo de senha visível (inicialmente invisível)
        TextField tfSenhaVisivel = new TextField();
        tfSenhaVisivel.setPromptText("Digite sua senha");
        tfSenhaVisivel.setManaged(false);
        tfSenhaVisivel.setVisible(false);

        // Sincronizar o texto dos dois campos
        tfSenhaVisivel.textProperty().bindBidirectional(pfSenha.textProperty());

        // Botão de mostrar/ocultar (olho)
        ImageView eyeOpen = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/eye.png")));
        ImageView eyeClosed = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/eye-off.png")));
        eyeOpen.setFitHeight(16);
        eyeOpen.setFitWidth(16);
        eyeClosed.setFitHeight(16);
        eyeClosed.setFitWidth(16);

        Button btnEye = new Button();
        btnEye.setGraphic(eyeClosed);
        btnEye.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        btnEye.setOnAction(e -> {

            boolean isVisible = tfSenhaVisivel.isVisible();
            tfSenhaVisivel.setVisible(!isVisible);
            tfSenhaVisivel.setManaged(!isVisible);
            pfSenha.setVisible(isVisible);
            pfSenha.setManaged(isVisible);
            btnEye.setGraphic(isVisible ? eyeOpen : eyeClosed);

        });

        // HBox contendo apenas o campo (visível ou não) e o botão fora do campo
        StackPane senhaFieldPane = new StackPane(pfSenha, tfSenhaVisivel, btnEye);
        senhaFieldPane.setPrefWidth(100);
        senhaFieldPane.setMaxWidth(Double.MAX_VALUE);
        StackPane.setMargin(btnEye, new Insets(0, 0, 0, 120));

        HBox senhaBox = new HBox(senhaFieldPane);
        senhaBox.setAlignment(Pos.CENTER_LEFT);
        senhaBox.setSpacing(10);









        // Botão de login
        Button btnLogin = new Button("Entrar");
        btnLogin.setStyle("-fx-background-color: #784a07; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");
        btnLogin.setMaxWidth(300);


        // Mensagem de status
        Text txtStatus = new Text();
        txtStatus.setFill(Color.RED);

        // Adicionando componentes ao grid
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.add(lblEmail, 0, 0);
        loginGrid.add(txtEmail, 1, 0);
        loginGrid.add(lblSenha, 0, 1);


        loginGrid.add(btnLogin, 1, 2);
        loginGrid.add(txtStatus, 1, 3);
        loginGrid.add(senhaFieldPane, 1, 1);


        // Container principal do formulário
        VBox loginBox = new VBox(20, headerBox, loginGrid);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));
        loginBox.setStyle("-fx-background-color: rgba(255, 255, 255, 20); " + "-fx-border-color: #916a27; -fx-border-width: 2px; " + "-fx-border-radius: 3px; -fx-background-radius: 10px");
        loginBox.setMaxWidth(400);
        loginBox.setPadding(new Insets(20));

        // Layout com imagem de fundo

        StackPane root = new StackPane();
        root.setStyle("-fx-background-image: url('/view/resources/img/predio.jpg'); " + "-fx-background-repeat: stretch; -fx-background-size: cover;");
        root.getChildren().add(loginBox);
        root.setAlignment(Pos.CENTER_RIGHT);

        // Configuração da cena
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Grand Hotel - Login");
        primaryStage.getIcons().add(imgIcon);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Ação do botão de login
        btnLogin.setOnAction(e -> {
            String email = txtEmail.getText();
            String senha = pfSenha.getText();
            if (email.isEmpty() || senha.isEmpty()) {
                txtStatus.setText("Email e senha são obrigatórios!");
                txtStatus.setFill(Color.RED);
            } else if (validarLogin(email, senha)) {
                txtStatus.setText("Login bem-sucedido! Bem-vindo ao Hotel!");
                txtStatus.setFill(Color.GREEN);                // Aqui você pode redirecionar para a tela principal
            } else {
                txtStatus.setText("Credenciais inválidas! Tente novamente.");
                txtStatus.setFill(Color.RED);
            }
        });
    }

    private boolean validarLogin(String email, String senha) {
        // Lógica de validação simples (substitua por uma verificação real)
        return email.equals("joaohenriquecardoso07@gmail.com") && senha.equals("jota123");
    }

    private void toggleDarkMode(BorderPane mainPane) {
        darkMode = !darkMode;
        if (darkMode) {
            applyDarkTheme(mainPane);
        } else {
            applyLightTheme(mainPane);
        }
    }

    private void applyLightTheme(Pane... panes) {
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(240, 240, 240, 0.9); " + "-fx-border-color: #1b7c9a; -fx-border-width: 2px; " + "-fx-border-radius: 10px; -fx-background-radius: 10px;");
        }
    }

    private void applyDarkTheme(Pane... panes) {
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(60, 60, 60, 0.9); " + "-fx-border-color: #276cb0; -fx-border-width: 2px; " + "-fx-border-radius: 10px; -fx-background-radius: 10px; " + "-fx-text-fill: white;");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}




