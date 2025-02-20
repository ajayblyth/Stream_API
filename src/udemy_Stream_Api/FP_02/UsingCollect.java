package udemy_Stream_Api.FP_02;

import java.util.List;
import java.util.stream.Collectors;

public class UsingCollect {
    public static void main(String[] args) {
        List<Integer>numbers = List.of(12,23,34,45,67,4,4,34);

        evenList(numbers);
        squaredNumbers(numbers);
    }

    private static void squaredNumbers(List<Integer> numbers) {
        List<Integer> squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(squaredNumbers);
    }

    private static void evenList(List<Integer> numbers) {
        List<Integer> evenNumbers = numbers.stream().filter(x ->x%2 ==0).collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
}
