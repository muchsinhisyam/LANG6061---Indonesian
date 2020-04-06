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
    private String Hints;

    @FXML private Button backButton;
    @FXML private Button hintButton;
    @FXML private Label topicLabel;
    @FXML private Label numberLabel;
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
        Hints = CurrentData[CurrentIndex][6];
        refreshNumberLabel();
    }

    private void refreshNumberLabel(){
        String num = (CurrentIndex+1) + "/" + CurrentData.length;
        numberLabel.setText(num);
    }

    private void nextQuestion(ActionEvent event) throws IOException {
        try {
            CurrentIndex++;
            questionArea.setText(CurrentData[CurrentIndex][0]);
            answerButton1.setText(CurrentData[CurrentIndex][1]);
            answerButton2.setText(CurrentData[CurrentIndex][2]);
            answerButton3.setText(CurrentData[CurrentIndex][3]);
            answerButton4.setText(CurrentData[CurrentIndex][4]);
            CorrectAnswer = Integer.parseInt(CurrentData[CurrentIndex][5]);
            Hints = CurrentData[CurrentIndex][6];
            refreshNumberLabel();
        } catch (ArrayIndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Congratulations!");
            alert.setHeaderText("You have learn about "+ CurrentTopic + " words of Indonesian!");
            alert.setContentText("Thank you for playing!");
            alert.showAndWait();
            // Back to topic selection
            backButtonClicked(event);
        }
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
            return false;
        }
    }

    public void printWrongAnswer(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong Answer!");
        alert.setHeaderText("Your answer is wrong!");
        alert.setContentText("You must choose correct answer to continue to next questions. \n If you're stuck, you can click 'Hint' button.");
        alert.showAndWait();
    }

    public void button1Clicked(ActionEvent event) throws IOException {
        System.out.println("answerButton1 Clicked at QuizTemplate");
        buttonClicked = 1;
        if (isCorrectAnswer()) {
            nextQuestion(event);
        } else {
            printWrongAnswer();
        }
    }

    public void button2Clicked(ActionEvent event) throws IOException {
        System.out.println("answerButton2 Clicked at QuizTemplate");
        buttonClicked = 2;
        if (isCorrectAnswer()) {
            nextQuestion(event);
        } else {
            printWrongAnswer();
        }
    }

    public void button3Clicked(ActionEvent event) throws IOException {
        System.out.println("answerButton3 Clicked at QuizTemplate");
        buttonClicked = 3;
        if (isCorrectAnswer()) {
            nextQuestion(event);
        } else {
            printWrongAnswer();
        }
    }

    public void button4Clicked(ActionEvent event) throws IOException {
        System.out.println("answerButton4 Clicked at QuizTemplate");
        buttonClicked = 4;
        if (isCorrectAnswer()) {
            nextQuestion(event);
        } else {
            printWrongAnswer();
        }
    }

    public void hintButtonClicked(){
        System.out.println("HintButton Clicked at QuizTemplate");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hints");
        alert.setHeaderText("Here's the hint!");
        alert.setContentText(Hints);
        alert.showAndWait();
    }
}