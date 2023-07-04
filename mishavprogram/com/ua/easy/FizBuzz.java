package mishavprogram.com.ua.easy;

import java.util.ArrayList;
import java.util.List;

public class FizBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String element = "";
            boolean anyConditionWasTrue = false;

            if (i % 3 == 0) {
                element += "Fizz";
                anyConditionWasTrue = true;
            }

            if (i % 5 == 0) {
                element += "Buzz";
                anyConditionWasTrue = true;
            }

            if (!anyConditionWasTrue) {
                element = String.valueOf(i);
            }

            result.add(element);
        }
        return result;
    }

    public static void main(String[] args) {
        FizBuzz fizBuzz = new FizBuzz();
        List<String> strings = fizBuzz.fizzBuzz(10);
        System.out.println(strings);
    }


}
