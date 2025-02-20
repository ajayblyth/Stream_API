package udemy_Stream_Api.FP03;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BehaviourParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,23,34,45,56,67,78,56);

//        filterAndPrint(numbers, x-> x%2 ==0);

//        filterAndPrint(numbers, x-> x%2 !=0);

//        filterAndPrint(numbers, x -> x%3 ==0);
     List<Integer> squared = mapAndPrint(numbers, x -> x * x);
        List<Integer> doubledNumbers = mapAndPrint(numbers, x -> x + x);
//        List<Integer> cubedNumbers = mapAndPrint(numbers, x -> x * x);
//        System.out.println(squared);
//        System.out.println(doubledNumbers);
//
//        System.out.println(cubedNumbers);




    }

    private static List<Integer> mapAndPrint(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
   return  numbers.stream().map(mappingFunction).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate){

        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
