package udemy_Stream_Api.FP_03;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
/key Takeaways
Version	Behavior 	                              Flexibility
Predicate<Integer>                             	Only works with Predicate<Integer>
Predicate<? super Integer>	                  Works with Predicate<Integer>,
                                               Predicate<Number>, Predicate<Object>
                                                allowing predicates for parent types
 */

public class BehaviourParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,23,34,45,56,67,78,56);

        filterAndPrint(numbers, x-> x%2 ==0);

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

    private static void filterAndPrint(List<Integer> numbers, Predicate < Integer> predicate){

        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
