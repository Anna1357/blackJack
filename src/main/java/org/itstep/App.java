package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URISyntaxException;

public class App extends Application {
public static final Paint BLACK=Paint.valueOf( "#000000" );
    public static final Paint WHITE =Paint.valueOf( "#ffffff" );
    public static final Font LABEL_FONT=Font.font("Roboto", FontWeight.BOLD, 18 );
    @Override
    public void start(Stage stage) {
        //ImageView logoView = new ImageView();

        //Image image = new Image(pathToCard("itstep-logo.png"));

        //logoView.setImage(image);//
        //logoView.setPreserveRatio(true);
        //logoView.setFitWidth(100);

        //playAnimation(logoView);
        //корневой узел
Pane root=new Pane();
Rectangle greeenRect =new Rectangle(530,600);//создане прямоугольника
        greeenRect.setFill( Paint.valueOf("#249477") );

        Rectangle blackRect=new Rectangle(270,600);
        blackRect.setFill( BLACK );
        blackRect.relocate( 530,0 );

//метка-текст
Label dealerlabel=new Label("Dealer: ");
dealerlabel.setFont(  LABEL_FONT );
dealerlabel.setTextFill(WHITE);
dealerlabel.relocate( 153,15 );
dealerlabel.setPrefWidth( 194 );
dealerlabel.setAlignment( Pos.CENTER );


Label blackJackLabel=new Label("Black Jack");
blackJackLabel.setTextFill( WHITE );
        blackJackLabel.relocate( 135,272 );
        blackJackLabel.setFont( Font.font( "Robot", FontWeight.MEDIUM, 48  ) );

        Label playerLabel=new Label("Player: ");
        playerLabel.setTextFill( WHITE );
        playerLabel.setFont( LABEL_FONT );playerLabel.relocate( 156,565 );

        playerLabel.setPrefWidth( 217 );
        playerLabel.setAlignment( Pos.CENTER );

Label cashLabel=new Label("Cash: ");
cashLabel.setTextFill( WHITE );
cashLabel.setFont(Font.font( "Robot",FontWeight.MEDIUM,24 ));
cashLabel.relocate( 603,11 );
cashLabel.setPrefWidth( 122 );
cashLabel.setAlignment( Pos.CENTER );

Label labelbet=new Label("BET");
        labelbet.setFont(  LABEL_FONT );
        labelbet.setTextFill(WHITE);
        labelbet.relocate( 573,308 );
        labelbet.setPrefWidth( 179 );
        labelbet.setAlignment( Pos.CENTER );
        //buttons
        Button buttonhit=new Button("HIT");
        buttonhit.setBackground( new Background( new BackgroundFill( Paint.valueOf( "#C4C4C4" ),null,null ) ) );
        buttonhit.setFont(LABEL_FONT);
        buttonhit.setPrefWidth( 190 );
        buttonhit.setPrefHeight( 40 );
        buttonhit.relocate( 572,156 );

        Button buttonstand=new Button("STAND");
        buttonstand.setBackground( new Background( new BackgroundFill( Paint.valueOf( "#C4C4C4" ),null,null ) ) );
        buttonstand.setFont(LABEL_FONT);
        buttonstand.setPrefWidth( 190 );
        buttonstand.setPrefHeight( 40 );
        buttonstand.relocate( 572,236 );

        Button buttonplay=new Button("PLAY");
        buttonplay.setBackground( new Background( new BackgroundFill( Paint.valueOf( "#C4C4C4" ),null,null ) ) );
        buttonplay.setFont(LABEL_FONT);
        buttonplay.setPrefWidth( 190 );
        buttonplay.setPrefHeight( 40 );
        buttonplay.relocate( 572,537 );


        //pole vvoda
        TextField textField=new TextField("100");
        textField.setPrefWidth( 190 );
        textField.setPrefHeight( 54 );
        textField.setAlignment( Pos.CENTER );
        textField.setFont(Font.font( "Robot",FontWeight.MEDIUM,24 )  );
        textField.relocate( 572,368 );

//добавить метку в корневой узел
        root.getChildren().add( greeenRect );
        root.getChildren().add(blackRect);
root.getChildren().add( dealerlabel );
root.getChildren().add(blackJackLabel);
root.getChildren().add(playerLabel);
root.getChildren().add( cashLabel );
root.getChildren().add(buttonhit);
        root.getChildren().add(buttonstand);
        root.getChildren().add(buttonplay);
        root.getChildren().add(textField);
        root.getChildren().add(labelbet);

//создать сцену
        Scene scene = new Scene(root, 800, 600);
        //установить сцену в окне
        stage.setResizable( false );//фиксируем размер сцены
        stage.setScene(scene);
        stage.setTitle("Simple application in JavaFX");
        stage.getIcons().add(new Image("icon.png"));
        stage.show();
    }

    private String pathToCard(String cardFilename) {
        if(cardFilename == null) return null;
        String[] parts = cardFilename.split("/");
        return App.class.getClassLoader().getResource(parts[0]) + (parts.length == 2 ? parts[1] : "");
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch();
    }

}