package udemy_Stream_Api.FP03;

import java.util.List;
import java.util.function.Predicate;

public class BehaviourParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,23,34,45,56,67,78,56);

        filterAndPrint(numbers, x-> x%2 ==0);

//        filterAndPrint(numbers, x-> x%2 !=0);

//        filterAndPrint(numbers, x -> x%3 ==0);

        
    }
    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate){

        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
