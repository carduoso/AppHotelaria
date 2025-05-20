package View; //Package view (classes que, quando executadas, interagem com o usuário)

import View.components.MenuLateral;
import View.components.painelBotoes;
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)


public class CadQuarto extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        painelBotoes buttons = new painelBotoes();
        MenuLateral menu = new MenuLateral();
        //Carregar imagens
        Image imgBtnLog = new Image(getClass().getResourceAsStream("/view/resources/img/ibis.png"));
        Image imgUserBlack = new Image("/view/resources/img/icon-quarto.png");


        //Criação de um container principal
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImageUser = new ImageView(imgUserBlack);
        viewImageUser.setFitWidth(20);
        viewImageUser.setFitHeight(20);


        //Titulo
        Label lbTitulo = new Label("Reservas de Quartos");
        lbTitulo.setAlignment(Pos.CENTER);
        lbTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight:  bold");

        HBox tituloBox = new HBox(viewImageUser, lbTitulo);
        tituloBox.setAlignment(Pos.CENTER);


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setMinWidth(150);

        Label lblNumero = new Label("Numero: ");
        TextField txtNumero = new TextField();
        txtNumero.setMinWidth(150);

        Label lblCamas = new Label("Qtd camas casal: ");
        Spinner<Integer> spnCamas = new Spinner<Integer>();
        spnCamas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));


        Label lblSolteiro = new Label("Qtd camas solteiro: ");
        Spinner<Integer> spnSolteiro = new Spinner<Integer>();
        spnSolteiro.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

        Label lblPreco = new Label("Preço do Quarto: ");
        TextField txtPreco = new TextField("R$ ");
        txtPreco.setMinWidth(150);


        txtPreco.textProperty().addListener((obs, oldText, newText) -> {
            // Garante que começa com "R$ "
            if (!newText.startsWith("R$ ")) {
                txtPreco.setText("R$ ");
                return;
            }
            // Remove "R$ " e formata
            String value = newText.replaceAll("[^0-9]", "");
            if (value.isEmpty()) {
                txtPreco.setText("R$ ");
                return;
            }
            try {
                double number = Double.parseDouble(value) / 100.0;
                String formatted = String.format("R$ %.2f", number).replace(".", ",");
                txtPreco.setText(formatted);
                txtPreco.positionCaret(formatted.length());
            } catch (Exception e) {
                txtPreco.setText("R$ ");
            }
        });

//        Label lblPreco = new Label("Preço do Quarto: ");
//        TextField txtPreco = criarMascaraCampo("R$") ;
//
//        // Listener para formatar em tempo real como moeda
//        txtPreco.textProperty().addListener((obs, oldText, newText) -> {
//            String valorNumerico = newText.replaceAll("[^0-9]", "");
//            if (valorNumerico.isEmpty()) valorNumerico = "0";
//            double valor = Double.parseDouble(valorNumerico) / 100;
//            String formatado = String.format("R$ %,.2f", valor);
//            txtPreco.setText(formatado);
//            txtPreco.positionCaret(txtPreco.getText().length());
//        });


        Label lblDisponivel = new Label("Disponivel: ");

        ComboBox<String> boxDisponivel = new ComboBox<>();
        boxDisponivel.getItems().addAll("Sim", "Não");
        boxDisponivel.setValue("selecione");


        GridPane fromGrid = new GridPane();
        fromGrid.add(lblNome, 0, 0);
        fromGrid.add(txtNome, 1, 0);

        fromGrid.add(lblNumero, 0, 1);
        fromGrid.add(txtNumero, 1, 1);


        fromGrid.add(lblCamas, 0, 2);
        fromGrid.add(spnCamas, 1, 2);

        fromGrid.add(lblSolteiro, 0, 3);
        fromGrid.add(spnSolteiro, 1, 3);

        fromGrid.add(lblDisponivel, 0, 4);
        fromGrid.add(boxDisponivel, 1, 4);

        fromGrid.add(lblPreco, 0, 5);
        fromGrid.add(txtPreco, 1, 5);


        fromGrid.setHgap(10);
        fromGrid.setVgap(10);
        fromGrid.setAlignment(Pos.CENTER);

        fromGrid.add(buttons, 1, 6);

        VBox contentBox = new VBox(10, lbTitulo, fromGrid, buttons);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: rgba(155, 155, 155, 0.9); -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;-fx-background-radius: 10px");
        contentBox.setMaxHeight(300);
        contentBox.setMaxWidth(400);

        // Layout principal com fundo
        StackPane layoutimg = new StackPane();
        layoutimg.setStyle("-fx-background-image: url('/View/resources/img/quartinhodomal.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");


        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
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
        txtMascara.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
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


