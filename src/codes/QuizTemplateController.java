package codes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizTemplateController implements Initializable {

    private String CurrentTopic;
    private int CurrentIndex;
    private String[][] CurrentData;

    private int CorrectAnswer;
    private int buttonClicked;

    @FXML private Button backButton;
    @FXML private Button hintButton;
    @FXML private Label topicLabel;
    @FXML private TextArea questionArea;
    @FXML private Button answerButton1;
    @FXML private Button answerButton2;
    @FXML private Button answerButton3;
    @FXML private Button answerButton4;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questionArea.setEditable(false);
    }

    public void initData(String topic, String[][] data){
        CurrentTopic = topic;
        CurrentIndex = 0;
        CurrentData = data;
        topicLabel.setText(topic);
        questionArea.setText(data[CurrentIndex][0]);
        answerButton1.setText(data[CurrentIndex][1]);
        answerButton2.setText(data[CurrentIndex][2]);
        answerButton3.setText(data[CurrentIndex][3]);
        answerButton4.setText(data[CurrentIndex][4]);
        CorrectAnswer = Integer.parseInt(data[CurrentIndex][5]);
    }

    private void nextQuestion(){
        CurrentIndex++;
        questionArea.setText(CurrentData[CurrentIndex][0]);
        answerButton1.setText(CurrentData[CurrentIndex][1]);
        answerButton2.setText(CurrentData[CurrentIndex][2]);
        answerButton3.setText(CurrentData[CurrentIndex][3]);
        answerButton4.setText(CurrentData[CurrentIndex][4]);
        CorrectAnswer = Integer.parseInt(CurrentData[CurrentIndex][5]);
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        System.out.println("backButton Clicked at QuizTemplate");
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

    public boolean isCorrectAnswer() {
        if (buttonClicked == CorrectAnswer) {
            System.out.println("The following answer is correct");
            return true;
        } else {
            System.out.println("The following answer is wrong");
            return false;
        }
    }

    public void button1Clicked() {
        System.out.println("answerButton1 Clicked at QuizTemplate");
        buttonClicked = 1;
        if (isCorrectAnswer()) {
            nextQuestion();
        }
    }
    public void button2Clicked() {
        System.out.println("answerButton2 Clicked at QuizTemplate");
        buttonClicked = 2;
        if (isCorrectAnswer()) {
            nextQuestion();
        }
    }
    public void button3Clicked() {
        System.out.println("answerButton3 Clicked at QuizTemplate");
        buttonClicked = 3;
        if (isCorrectAnswer()) {
            nextQuestion();
        }
    }
    public void button4Clicked() {
        System.out.println("answerButton4 Clicked at QuizTemplate");
        buttonClicked = 4;
        if (isCorrectAnswer()) {
            nextQuestion();
        }
    }

}
