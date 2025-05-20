package View.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Font;


public class MenuLateral extends VBox {
    public Button btnCliente = new Button("Cadastro de Cliente");
    public Button btnQuarto = new Button("Cadastro de Quarto");
    public Button btnReserva = new Button("Reserva");
    public Button btnRelatorios = new Button("Relatorio");
    public Button btnFuncionario = new Button("Funcionario");

    public MenuLateral(){
        Image iconFuncionario = new Image(getClass().getResourceAsStream(
                "/View/resources/img/icon-funcionario.png"
        ));

        Image iconCliente = new Image(getClass().getResourceAsStream(
              "/View/resources/img/icon-cliente.png"
        ));
        Image iconQuarto = new Image(getClass().getResourceAsStream(
                "/View/resources/img/icon-quarto.png"
        ));
        Image iconRelatorio = new Image(getClass().getResourceAsStream(
                "/View/resources/img/icon-relatorio.png"
        ));
        Image iconReserva = new Image(getClass().getResourceAsStream(
               "/View/resources/img/icon-reserva.png"

        ));

        //carregar fontes
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream(
                "/View/resources/fonts/" + "RobotoSlab-Regular.ttf"
        ),14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream(
                "/View/resources/fonts/" + "RobotoSlab-Bold.ttf"
        ),15);


        ImageView ViewiconFuncionario = new ImageView(iconFuncionario);
        ViewiconFuncionario.setFitWidth(30); //Definição de largura
        ViewiconFuncionario.setFitHeight(30); //Definição de altura
        //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)


        ImageView ViewiconCliente = new ImageView(iconCliente);
        ViewiconCliente.setFitWidth(30);
        ViewiconCliente.setFitHeight(30);

        ImageView ViewiconQuarto = new ImageView(iconQuarto);
        ViewiconQuarto.setFitWidth(30);
        ViewiconQuarto.setFitHeight(30);

        ImageView viewiconRelatorio = new ImageView(iconRelatorio);
        viewiconRelatorio.setFitWidth(30);
        viewiconRelatorio.setFitHeight(30);

        ImageView ViewiconReserva = new ImageView(iconReserva);
        ViewiconReserva.setFitWidth(30);
        ViewiconReserva.setFitHeight(30);


        btnCliente.setGraphic(ViewiconCliente);
        btnFuncionario.setGraphic(ViewiconFuncionario);
        btnQuarto.setGraphic(ViewiconQuarto);
        btnReserva.setGraphic(ViewiconReserva);
        btnRelatorios.setGraphic(viewiconRelatorio);



        setPadding(new Insets(20));
        setSpacing(15);


        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #784a07");

        lblMenu.setFont(Font.font(fontNegrito.getFamily(),25));

        setStyle("-fx-background-color: #ffffff; -fx-padding: 35px");

        //estlização dos botões
        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;"+
                             "-fx-cursor: hand";

        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorios.setStyle(styleButton);

        //mudar cor ao passar o cursor
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));


        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorios.setOnMouseEntered(evento ->
                btnRelatorios.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnRelatorios.setOnMouseExited(evento -> btnRelatorios.setStyle(styleButton));

        setMargin(lblMenu,new Insets(0, 0, 20,0));


        getChildren().addAll(lblMenu, btnCliente,btnQuarto,btnReserva,btnRelatorios,btnFuncionario);

    }
}
