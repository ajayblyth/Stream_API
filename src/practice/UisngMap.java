package practice;

import java.util.List;

public class UisngMap {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        System.out.println("square: ");
        numbers.stream().map(x -> x * x).forEach(System.out::println);

        System.out.println("cube of odd numbers: ");
        numbers.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * x * x)
                .forEach(System.out::println);

    }
}
