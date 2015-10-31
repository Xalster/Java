import java.util.Scanner;

/**
 * Created by Alek on 14.10.2015.
 */
public class Input {

    private Integer choice;

    public void choice(){

        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
    }

    public int getChoice(){
        return choice;
    }
}
