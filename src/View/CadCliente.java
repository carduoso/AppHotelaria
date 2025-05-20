package View; //Package view (classes que, quando executadas, interagem com o usuário)

import View.components.MenuLateral;
import View.components.painelBotoes;
import com.sun.source.tree.SwitchExpressionTree;
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.Objects;

public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        painelBotoes buttons = new painelBotoes();
        MenuLateral menu = new MenuLateral();
        //Carregar imagens
        Image imgBtnLog = new Image(getClass().getResourceAsStream
                ("/view/resources/img/logo.png"));
        Image imgUserBlack = new Image("/view/resources/img/person.png");



        //Criação de um container principal
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImageUser = new ImageView(imgUserBlack);
        viewImageUser.setFitWidth(20);
        viewImageUser.setFitHeight(20);


        //Titulo
        Label lbTitulo = new Label("Cadastro de Clientes");
        lbTitulo.setAlignment(Pos.CENTER);
        lbTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight:  bold");

        HBox tituloBox = new HBox(viewImageUser, lbTitulo);
        tituloBox.setAlignment(Pos.CENTER);


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();

        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@yahoo.com", "@icloud.com");
        boxEmail.setValue("selecione");

        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMascaraCampo("(##) #####-####");

        ComboBox<String> boxTel = new ComboBox<>();
        boxTel.getItems().addAll("(__)___-___");


        GridPane fromGrid = new GridPane();
        fromGrid.add(lblNome, 0, 0);
        fromGrid.add(txtNome, 1, 0);

        fromGrid.add(lblCPF, 0, 1);
        fromGrid.add(txtCPF, 1, 1);

        fromGrid.add(lblEmail, 0, 2);
        fromGrid.add(txtEmail, 1, 2);
        fromGrid.add(boxEmail, 2, 2);

        fromGrid.add(lblTel, 0, 3);
        fromGrid.add(txtTel, 1, 3);

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
        layoutimg.setStyle("-fx-background-image: url('/View/resources/img/hotel.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");




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

