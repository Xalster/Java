/**
 * Created by Alek on 14.10.2015.
 */

public class Program {
    public static void main(String[] args) {
        Number number =new Number();
        System.out.println("Podaj liczby odzielajac je przecinkiem");
        number.chainNumbers();
        System.out.println("\nNajwieksze liczby, ktore mozna ulozyc to: ");
        number.ordering();
    }
}
