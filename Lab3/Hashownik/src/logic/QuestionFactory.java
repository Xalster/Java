package logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class QuestionFactory
{
    private ArrayList<Question> questionPack = new ArrayList<>();
    private int numberOfQuestions = 0;
    private Stats stats = new Stats();
    private Random r = new Random();

    public int getNumberOfQuestions()
    {
        return numberOfQuestions;
    }

    public void saveStats()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(KEYS.STATS_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.stats);
            oos.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void loadStats()
    {
        try
        {
            FileInputStream fis = new FileInputStream(KEYS.STATS_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            this.stats = (Stats)object;
            ois.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    public void loadQuestions()
    {
        File file = new File(KEYS.QUESTIONS_PATH);
        FileReader fr = null;
        try
        {
            fr = new FileReader(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);

        String line = null;
        try
        {
            while ((line = br.readLine()) != null)
            {
                String[] splittedLine = line.split("_");
                this.questionPack.add(new Question(splittedLine[0],splittedLine[1],splittedLine[2],splittedLine[3],splittedLine[4]));
                this.numberOfQuestions++;
            }
            br.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public Question getRandomQuestion()
    {
        return this.questionPack.get(Math.abs(r.nextInt() % getNumberOfQuestions()));
    }

    public Stats getStats()
    {
        return stats;
    }

}
