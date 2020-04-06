package codes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

    @FXML
    public void exitClicked(){
       System.exit(0);
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

    private void topicClicked(ActionEvent event, String topics) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("QuizTemplate.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Passing data to ProductFormController
        QuizTemplateController controller = loader.getController();

        if (topics == "Basics"){
            controller.initData("Basics", Main.Basics);
        } else if (topics == "Travel"){
            controller.initData("Travel", Main.Travel);
        }
        else if (topics == "Time"){
            controller.initData("Time", Main.Time);
        }

        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

        scene.getStylesheets().add(css);
        currentStage.setScene(scene);
        currentStage.show();
    }

    @FXML
    public void BasicsClicked(ActionEvent event) throws IOException {
        System.out.println("BasicsTopic Clicked at ChooseTopicPage");
        topicClicked(event, "Basics");
    }

    @FXML
    public void TravelClicked(ActionEvent event) throws IOException {
        System.out.println("TravelTopic Clicked at ChooseTopicPage");
        topicClicked(event, "Travel");
    }

    @FXML
    public void TimeClicked(ActionEvent event) throws IOException {
        System.out.println("TimeTopic Clicked at ChooseTopicPage");
        topicClicked(event, "Time");
    }

    @FXML
    public void ComingSoonClicked(ActionEvent event) throws IOException {
        System.out.println("ComingSoon Topic Clicked at QuizTemplate");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Topic Unavailable");
        alert.setHeaderText("Topic still coming soon!");
        alert.setContentText("The topics is still coming soon! \nStay tune.");
        alert.showAndWait();
    }
}
