package practice.section_4;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class BehaviourParameterization1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 23, 34, 45, 56, 67, 78, 56);
        System.out.println("even ");
        filterAndPrint(numbers, x -> x % 2 == 0);

        System.out.println("odd ");
        filterAndPrint(numbers, x -> x % 2 != 0);

        System.out.println(" divisor of 3");
        filterAndPrint(numbers, x -> x % 3 == 0);

        List<Integer> squared = mapThenPrint(numbers, x -> x * x);
        System.out.println("squared =" + squared);

        List<Integer> cubed = mapThenPrint(numbers , x->x*x*x);
        System.out.println("cubed = " + cubed);

    }

    private static List<Integer> mapThenPrint(List<Integer> numbers, Function<Integer, Integer> function) {
       return numbers.stream().map(function).collect(Collectors.toList());

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate< Integer> predicate){

        numbers.stream().filter(predicate).forEach(System.out::println);

}

}
