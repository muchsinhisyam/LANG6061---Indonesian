package codes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        String css = Main.class.getResource("MainPage.css").toExternalForm();

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setResizable(false);

        primaryStage.setTitle("Study Belajar");
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}