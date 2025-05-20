package View.components;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class painelBotoes extends HBox {
     public  Button btnCadastrar = new Button("Cadastrar");
     public  Button btnAtualizar = new Button("Atualizar");
     public  Button btnExcluir = new Button("Excluir");

    public painelBotoes() {
        Image imgBtnCad = new Image(getClass().getResourceAsStream
                ("/view/resources/img/cadastrar.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream
                ("/view/resources/img/atualizar.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream
                ("/view/resources/img/excluir.png"));

        //carregar fontes
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream(
                "/View/resources/fonts/" + "RobotoSlab-Regular.ttf"
        ),14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream(
                "/View/resources/fonts/" + "RobotoSlab-Bold.ttf"
        ),15);

        ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(20); //Definição de largura
        viewImgBtnCad.setFitHeight(20); //Definição de altura



        ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);

        ImageView viewImgBtnDel = new ImageView(imgBtnDel);
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);

        btnCadastrar.setStyle("-fx-background-color: #bebece");
        btnAtualizar.setStyle("-fx-background-color: #bebece");
        btnExcluir.setStyle("-fx-background-color: #bebece");

        btnCadastrar.setGraphic(viewImgBtnCad);
        btnAtualizar.setGraphic(viewImgBtnUp);
        btnExcluir.setGraphic(viewImgBtnDel);

        btnCadastrar.setFont(Font.font(fontRegular.getFamily(),12));
        btnAtualizar.setFont(Font.font(fontRegular.getFamily(),12));
        btnExcluir.setFont(Font.font(fontRegular.getFamily(),12));

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;"+
                "-fx-cursor: hand";

        btnCadastrar.setStyle(styleButton);
        btnAtualizar.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);

        //mudar cor ao passar o cursor
        btnCadastrar.setOnMouseEntered(evento ->
                btnCadastrar.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnCadastrar.setOnMouseExited(evento -> btnCadastrar.setStyle(styleButton));

        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButton));

        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "#D6C388FF" )));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButton));

        setSpacing(10);

        getChildren().addAll(btnCadastrar,btnAtualizar,btnExcluir);


    }

}
