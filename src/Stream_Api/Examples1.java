package Stream_Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Examples1 {
    public static void main(String[] args) {
        List<Integer> salary = new ArrayList<>(Arrays.asList(1234, 4567, 3245, 5678, 8765, 3456, 9456, 7456));
        List<Integer> result = salary.stream().filter(i -> i >= 4000).collect(Collectors.toList());
        System.out.println(result);

        secondHighestSalary(salary);
    }

    public static void secondHighestSalary(List<Integer> salary) {
        Optional<Integer> second = salary.stream().distinct().sorted((a, b) -> b - a) //descendind order.. a-b for ascending
                //.sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(second);

        second.ifPresentOrElse(value -> System.out.println("second highest salary" + value),
                () -> System.out.println("no second highest salary"));
    }
}