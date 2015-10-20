/**
 * Created by Dom on 14.10.2015.
 */

import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Number[] numbers = Number.Parse(keyboard.next());
        for(Number number : numbers)
        {
            System.out.println(number.GetHighest());
        }
    }
}
