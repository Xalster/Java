package logic;
import java.io.Serializable;

public class Stats implements Serializable
{
    private int previousQuestions;
    private int correctAnswer;
    private int wrongAnswer;


    public void resetStats()
    {
        this.correctAnswer = 0;
        this.wrongAnswer = 0;
        this.previousQuestions = 0;
    }

    public double getPercentageOfCorrectAnswers()
    {
        return (correctAnswer/wrongAnswer)*100;
    }

    public int getCorrectAnswer()
    {
        return correctAnswer;
    }
    public int getWrongAnswer()
    {
        return wrongAnswer;
    }
    public int getPreviousQuestions()
    {
        return previousQuestions;
    }

    public void addCorrAnswer()
    {
        this.correctAnswer++;
        this.previousQuestions++;
    }
    public void addWrongAnswer()
    {
        this.wrongAnswer++;
        this.previousQuestions++;
    }
}
