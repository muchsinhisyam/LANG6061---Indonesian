package codes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static String[][] Basics =
    {
        {"What is the word for 'what' in Bahasa Indonesia?",
        "Kapan", "Siapa", "Apa", "Bagaimana", "3"},
        {"What is the word for 'where' in Bahasa Indonesia?",
        "Siapa", "Di mana", "Bagaimana", "Apa", "2"},
        {"What is the word for 'when' in Bahasa Indonesia",
        "Kemarin", "Siapa", "Di mana", "Kapan", "4"},
        {"What is the meaning of the question below?\n" + "\"Permisi, Di mana kamar kecilnya?\"",
        "Excuse me, when will the bathroom be cleaned?", "Excuse me, where is the bathroom?",
        "Excuse me, who is in the bathroom?", "Excuse me, Do you want to go to the bathroom first?", "2"},
        {"Fill in the blanks below!\n" + "Permisi, _____ kamar kecilnya akan di bersihkan?",
        "Kapan", "Di mana", "Kemarin", "Siapa", "1"},
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

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