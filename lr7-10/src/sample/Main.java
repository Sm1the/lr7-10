package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private static int W = 800;
    private static int H = 500;
    private static String TITLE = "lr7-10(Работа с H2)";


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root, W, H));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
