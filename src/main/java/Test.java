import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Set<Integer> numbers;




        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        int result = numbers.size();

        System.out.println(result);


    }
}
