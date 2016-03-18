import java.util.Scanner;

/**
 * Created by xalst on 18.03.2016.
 */
public class Kolo {
    public static void main(String[] args) {
        int wyb;
        float pi = (float) 3.14,pole = 0, obw = 0, r = 0;
        Scanner reader = new Scanner(System.in);  // potrzebujesz by czytac dane od uzytkownika
        Scanner rad = new Scanner(System.in);
        do {
            System.out.println("Opcje operacji:");
            System.out.println("1. Policz pole.");
            System.out.println("2. Policz obwod.");
            System.out.println("0. Wyjdz.");
            System.out.println("Wybierz opcje: ");
            wyb = reader.nextInt(); // pobieranie danych o wyborze opcji

            switch (wyb) {
                case 1:
                    //pole
                    System.out.println("Podaj promień");
                    r = rad.nextFloat(); //pobieranie promienia
                    while(r < 0)
                    {
                        System.out.println("Podaj dodatnią wartość:");
                        r = rad.nextFloat(); //pobieranie promienia
                    }
                    pole = pi*r*r;
                    System.out.println("Pole wynosi:" + pole);
                    break;
                case 2:
                    //obwód
                    System.out.println("Podaj promień");
                    r = rad.nextFloat(); //pobieranie promienia
                    while(r < 0)
                    {
                        System.out.println("Podaj dodatnią wartość:");
                        r = rad.nextFloat(); //pobieranie promienia
                    }
                    obw = 2*pi*r;
                    System.out.println("Obwod wynosi:"+obw);
                    break;
                default:
                    break;
            }
        }while(wyb !=0);
    }
}
