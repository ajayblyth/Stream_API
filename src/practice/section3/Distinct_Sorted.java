package practice.section3;

import java.util.List;

public class Distinct_Sorted {
    public static void main(String[] args) {
        List<Integer> numbers  = List.of(22,33,43,2,4,4,23,42,2,4,5,6,33,4);

        numbers.stream().distinct().sorted().forEach(System.out::println);

    }

}
