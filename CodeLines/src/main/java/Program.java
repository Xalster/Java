/**
 * Created by Dom on 19.10.2015.
 */
public class Program {
    public static void main(String[] args)
    {
        if (args.length<1)return;
        while (true)
        {
            new CodeReader(args[0]);
        }
    }
}
