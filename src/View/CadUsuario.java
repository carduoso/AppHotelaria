package View; //Package view (classes que, quando executadas, interagem com o usuário)

import View.components.MenuLateral;
import View.components.painelBotoes;
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class CadUsuario extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        painelBotoes buttons = new painelBotoes();
        MenuLateral menu = new MenuLateral();
        //Carregar imagens
        Image imgBtnLog = new Image(getClass().getResourceAsStream
                ("/view/resources/img/ibis.png"));
        Image imgUserBlack = new Image("/view/resources/img/icon-funcionario.png");



        //Criação de um container principal
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImageUser = new ImageView(imgUserBlack);
        viewImageUser.setFitWidth(20);
        viewImageUser.setFitHeight(20);


        //Titulo
        Label lbTitulo = new Label("Login Funcionario");
        lbTitulo.setAlignment(Pos.CENTER);
        lbTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight:  bold");

        HBox tituloBox = new HBox(viewImageUser, lbTitulo);
        tituloBox.setAlignment(Pos.CENTER);


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setMinWidth(150);

        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();
        txtSenha.setMinWidth(150);

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setMinWidth(150);

        Label lblCargo= new Label("Cargo: ");
        TextField txtCargo = new TextField();
        txtEmail.setMinWidth(150);

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@yahoo.com", "@icloud.com");
        boxEmail.setValue("selecione");

        ComboBox<String> boxCargo = new ComboBox<>();
        boxCargo.getItems().addAll("T.I", "Segurança", "Portaria", "Limpeza", "Administração", "Marketing", "Cozinha");
        boxCargo.setValue("selecione");






        GridPane fromGrid = new GridPane();
        fromGrid.add(lblNome, 0, 0);
        fromGrid.add(txtNome, 1, 0);

        fromGrid.add(lblSenha, 0, 1);
        fromGrid.add(txtSenha, 1, 1);

        fromGrid.add(lblEmail, 0, 2);
        fromGrid.add(txtEmail, 1, 2);
        fromGrid.add(boxEmail, 2, 2);

        fromGrid.add(lblCargo, 0, 3);
//        fromGrid.add(txtCargo, 1, 3);
        fromGrid.add(boxCargo, 1, 3);


        fromGrid.setHgap(10);
        fromGrid.setVgap(10);
        fromGrid.setAlignment(Pos.CENTER);

        fromGrid.add(buttons,1,4);

        VBox contentBox = new VBox(10, lbTitulo, fromGrid, buttons);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: rgba(155, 155, 155, 0.9); -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;-fx-background-radius: 10px");
        contentBox.setMaxHeight(300);
        contentBox.setMaxWidth(400);

        // Layout principal com fundo
        StackPane layoutimg = new StackPane();
        layoutimg.setStyle("-fx-background-image: url('/View/resources/img/recepcao.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");




        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        layout.getChildren().addAll(contentBox);
        mainPane.setCenter(layout);
        mainPane.setCenter(layoutimg);
        layoutimg.getChildren().add(layout);












        Scene scene = new Scene(mainPane, 750, 500);
        janela.setTitle("Grand Hotel");

        janela.getIcons().add(imgBtnLog);
        janela.setScene(scene);

        janela.show();
    }


    //Metodo para criar um campo de texto com mascara
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }


    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}


