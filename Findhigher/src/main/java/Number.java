import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Dom on 14.10.2015.
 */
public class Number
{
    private Integer _number;


        public Number(String numberString)
        {
            _number = Integer.parseInt(numberString);
        }

        public static Number[] Parse(String input)
        {

            List<String> numberTab = Arrays.asList(input.split(","));
            Set<String> numberSet = new HashSet<String>();
            numberSet.addAll(numberTab);
            return numberSet.stream().map(n -> new Number(n));
        }
        public Number GetHighest()
        {
            String digit = _number.toString();
            Iterable numbers = digit
            numbers = numbers.OrderByDescending(n => n);
            String higherNumber = string.Join("", numbers);
            return new Number(higherNumber);
        }
        public String ToString()
        {
            return _number.toString();
        }
}
