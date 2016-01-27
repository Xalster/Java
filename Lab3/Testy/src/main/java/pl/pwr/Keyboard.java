package pl.pwr;

import java.util.Scanner;

public class Keyboard {
    private int wybor;
    private String tekst;
    private Scanner input;

    public void wybor() {
        input = new Scanner(System.in);
        wybor = input.nextInt();
    }

    public void tekst() {
        input = new Scanner(System.in);
        tekst = input.next();
    }

    public int getWybor()// zwraca warto�� wpisan� z klawiatury
    {
        return wybor;
    }

    public String getTekst() {
        return tekst;
    }

    public void zamknij() {
        input.close();
    }
}
