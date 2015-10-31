import java.util.Scanner;

/**
 * Created by Alek on 14.10.2015.
 */
public class Input {
    private String chain;

    public void inputNumbers(){

        Scanner numbers = new Scanner(System.in);
        chain = numbers.next();
        numbers.close();
    }

    public String getChain(){

        return chain;
    }

}
