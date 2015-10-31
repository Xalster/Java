/**
 * Created by Alek on 14.10.2015.
 */
public class Program {
    public static void main(String[] args)
    {

        Input input = new Input();
        MyFile file = new MyFile();
        Menu menu = new Menu();
        menu.showMenu();
        file.Load();

        do{

            input.choice();
            switch(input.getChoice()){
                case 1:
                    file.all();
                    break;
                case 2:
                    file.withoutComments();
                    break;
                case 3:
                    file.withoutEmpty();
                    break;
                case 4:
                    file.withoutBrackets();
                    break;
                default:
                    break;
            }
        }while(input.getChoice() != 5);
    }
}
