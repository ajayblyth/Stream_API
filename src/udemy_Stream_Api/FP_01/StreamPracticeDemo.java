package udemy_Stream_Api.FP_01;


import java.util.*;
import java.util.stream.Collectors;

public class StreamPracticeDemo {
    public static void main(String[] args) {
        squareOfNumbers();
        cubeOfOddNumbers();
        evenOddFilter();
        filterAndPrintLocations();
        stringLengthMapping();
        sumUsingReduce();
        filterOddNumbersList();
        stringWithLengthInList();
    }

    // 1. Square of each number using map()
    public static void squareOfNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2, 2, 3, 4);
        System.out.println("Squares of numbers:");
        numbers.stream().map(x -> x * x).forEach(System.out::println);
    }

    // 2. Cube of only odd numbers
    public static void cubeOfOddNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Cubes of odd numbers:");
        numbers.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * x * x)
                .forEach(System.out::println);
    }

    // 3. Filter even and odd numbers
    public static void evenOddFilter() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.print("Even numbers: ");
        numbers.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
        System.out.println("\nOdd numbers:");
        numbers.stream().filter(x -> x % 2 != 0).forEach(System.out::println);
    }

    // 4. Filter and print locations based on condition
    public static void filterAndPrintLocations() {
        List<String> locations = List.of("jammu", "kashmir", "ladakh", "chennai", "karnataka");

        System.out.println("Locations containing 'na':");
        locations.stream().filter(x -> x.contains("na")).forEach(System.out::println);

        System.out.println("Locations with length > 7:");
        locations.stream().filter(x -> x.length() > 7).forEach(System.out::println);
    }

    // 5. Map strings to include their length
    public static void stringLengthMapping() {
        List<String> locations = List.of("jammu", "kashmir", "ladakh", "chennai", "karnataka");

        System.out.println("Locations with their lengths:");
        locations.stream()
                .map(x -> x + " " + x.length())
                .forEach(System.out::println);
    }

    // 6. Reduce operation for sum
    public static void sumUsingReduce() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println("Sum using reduce:");
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        System.out.println("Sum using lambda:");
        System.out.println(numbers.stream().reduce(0, (a, b) -> a + b));

        System.out.println("Sum using method reference:");
        System.out.println(numbers.stream().reduce(0, Integer::sum));
    }

    // 7. Filter odd numbers and collect to list
    public static void filterOddNumbersList() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2, 2, 3, 4);

        System.out.println("Filtered odd numbers:");
        List<Integer> odd = numbers.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(odd);
    }

    // 8. String list mapped to include length (alternative version)
    public static void stringWithLengthInList() {
        List<String> locations = List.of("jammu", "kashmir", "ladakh", "chennai", "karnataka");

        System.out.println("Locations mapped to 'name length' format:");
        List<String> result = locations.stream()
                .map(x -> x + " " + x.length())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

