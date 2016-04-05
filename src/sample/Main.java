package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("SceneBuilder.fxml"));

        primaryStage.setTitle("SimpleDraw");
        primaryStage.setScene(new Scene(root));
                
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
