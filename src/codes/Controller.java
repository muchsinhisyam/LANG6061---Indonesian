package codes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Buttons On MainPage
    @FXML private Button startButton;
    @FXML private Button optionsButton;
    @FXML private Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initialize MainPage");
    }

    @FXML
    public void startButtonClicked(ActionEvent event) throws IOException {
        System.out.println("startButton Clicked at MainPage");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("QuizBasics.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
//        String css = Main.class.getResource("MainPage.css").toExternalForm();

//        scene.getStylesheets().add(css);
        currentStage.setScene(scene);
        currentStage.show();
    }

}
