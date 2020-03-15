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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    public void startButtonClicked(ActionEvent event) throws IOException {
        System.out.println("startButton Clicked at MainPage");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChooseTopicPage.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

        scene.getStylesheets().add(css);
        currentStage.setScene(scene);
        currentStage.show();
    }

    @FXML
    public void aboutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("aboutButton Clicked at MainPage");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AboutUsPage.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

        scene.getStylesheets().add(css);
        currentStage.setScene(scene);
        currentStage.show();
    }

    private void backButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

        scene.getStylesheets().add(css);
        currentStage.setScene(scene);
        currentStage.show();
    }

    @FXML
    public void backButtonTopic(ActionEvent event) throws IOException {
        System.out.println("backButton Clicked at ChooseTopicPage");
        backButtonClicked(event);
    }

    @FXML
    public void backButtonAbout(ActionEvent event) throws IOException {
        System.out.println("backButton Clicked at AboutUsPage");
        backButtonClicked(event);
    }

    private void topicClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("QuizTemplate.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

        scene.getStylesheets().add(css);
        currentStage.setScene(scene);
        currentStage.show();
    }

    @FXML
    public void BasicsClicked(ActionEvent event) throws IOException {
        System.out.println("BasicsTopic Clicked at ChooseTopicPage");
    }

}
