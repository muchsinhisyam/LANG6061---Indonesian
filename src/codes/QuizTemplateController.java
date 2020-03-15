package codes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class QuizTemplateController implements Initializable {

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

    public void initData(String topic, String question, String answer1, String answer2, String answer3, String answer4){
        topicLabel.setText(topic);
        questionArea.setText(question);
        answerButton1.setText(answer1);
        answerButton2.setText(answer2);
        answerButton3.setText(answer3);
        answerButton4.setText(answer4);
    }

}
