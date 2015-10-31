
import java.util.*;

/**
 * Created by Alek on 14.10.2015.
 */
public class Number {

    Set<String> numberList = new LinkedHashSet<String>();

    void chainNumbers(){

        Input in = new Input();
        in.inputNumbers();
        String[] splitNumbers =  in.getChain().split(",");
        Collections.addAll(numberList, splitNumbers);

    }

    void ordering(){

        for(String number : numberList){
            Long numberL = Long.parseLong(number);
            List<Long> digits = new LinkedList<Long>();
            while(numberL>0){
                Long next = numberL%10;
                numberL /= 10;
                digits.add(next);
            }
            Collections.sort(digits, Collections.reverseOrder());
            digits.size();
            for (Long digit : digits) {
                System.out.print(digit);
            }
            System.out.println(" ");
        }
    }
}
