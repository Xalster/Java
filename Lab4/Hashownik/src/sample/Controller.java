package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import logic.Question;
import logic.QuestionFactory;

import java.util.ArrayList;
import java.util.Random;


public class Controller {

    private QuestionFactory questionFactory = new QuestionFactory();
    private Question randomQ = null;
    private Random rand = new Random();

    @FXML private Button startButton = new Button();
    @FXML private Button resetButton = new Button();
    @FXML private Button nextButton = new Button();
    @FXML private Button button1 = new Button();
    @FXML private Button button2 = new Button();
    @FXML private Button button3 = new Button();
    @FXML private Button button4 = new Button();
    @FXML private Label label1 = new Label();
    @FXML private Label label2 = new Label();
    @FXML private Label label3 = new Label();
    @FXML private Label label4 = new Label();
    @FXML private Label questionBar = new Label();
    @FXML private Label correctAnswerLabel = new Label();
    @FXML private Label wrongAnswerLabel = new Label();
    @FXML private Label previousQuestionsLabel = new Label();



    @FXML private void startButtonClicked()
    {
        questionFactory.loadQuestions();

        showStats();

        this.randomQ = questionFactory.getRandomQuestion();
        pushQ(randomQ);

        startButton.setDisable(true);
        resetButton.setDisable(false);
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
    }

    @FXML private void resetButtonCLicked()
    {
        questionFactory.getStats().resetStats();
        showStats();
        questionFactory.saveStats();
        startButton.setDisable(false);
        resetButton.setDisable(true);
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
    }

    @FXML private void button1clicked()
    {
        this.checkQ(this.randomQ, label1);
    }
    @FXML private void button2clicked()
    {
        this.checkQ(this.randomQ, label2);
    }
    @FXML private void button3clicked()
    {
        this.checkQ(this.randomQ, label3);
    }
    @FXML private void button4clicked()
    {
        this.checkQ(this.randomQ, label4);
    }

    private void showStats()
    {
        correctAnswerLabel.setText(String.valueOf(questionFactory.getStats().getCorrectAnswer()));
        wrongAnswerLabel.setText(String.valueOf(questionFactory.getStats().getWrongAnswer()));
        previousQuestionsLabel.setText((String.valueOf(questionFactory.getStats().getPreviousQuestions())));

    }

    private void pushQ(Question q)
    {
        ArrayList<String> AnswerTab = new ArrayList<>();
        AnswerTab.add(q.getCorrectAns());
        AnswerTab.add(q.getWrongAns1());
        AnswerTab.add(q.getWrongAns2());
        AnswerTab.add(q.getWrongAns3());

        questionBar.setText(q.getQuestion());

        int rand;
        rand = Math.abs(this.rand.nextInt()%4);
        label1.setText(AnswerTab.get(rand));
        AnswerTab.remove(rand);
        rand = Math.abs(this.rand.nextInt()%3);
        label2.setText(AnswerTab.get(rand));
        AnswerTab.remove(rand);
        rand = Math.abs(this.rand.nextInt()%2);
        label3.setText(AnswerTab.get(rand));
        AnswerTab.remove(rand);
        label4.setText((AnswerTab.get(0)));
    }

    @FXML private void nextButtonCLicked()
    {
        label1.setTextFill(Color.BLACK);
        label2.setTextFill(Color.BLACK);
        label3.setTextFill(Color.BLACK);
        label4.setTextFill(Color.BLACK);
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);

        nextButton.setDisable(true);

        this.randomQ = questionFactory.getRandomQuestion();
        pushQ(randomQ);
    }

    private void checkQ(Question question, Label label)
    {
        nextButton.setDisable(false);

        if (label.getText().equals(question.getCorrectAns()))
        {
            label.setTextFill(Color.LIME);
            questionFactory.getStats().addCorrAnswer();
        }
        else
        {
            label.setTextFill(Color.RED);
            questionFactory.getStats().addWrongAnswer();
        }

        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);

        questionFactory.saveStats();
        showStats();
    }

}
