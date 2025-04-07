package udemy_Stream_Api.FP_01;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

public class StreamOperationsDemo {

    public static void main(String[] args) {
        reduceExamples();
        filterReduceExample();
        distinctExample();
        sortedExample();
        reverseSortingExample();     // ✅ Newly added
        stringSortingExample();
        mapCollectExample();
    }

    // 1. Demonstrating reduce operations
    public static void reduceExamples() {
        List<Integer> numbers = List.of(1, 2, 3);

        Optional<Integer> sumOpt = numbers.stream().reduce(Integer::sum);
        System.out.println("Sum using Optional: " + sumOpt.get()); // 6

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum with identity: " + sum); // 6

        int max = numbers.stream().reduce(0, (x, y) -> x > y ? x : y);
        System.out.println("Max using reduce: " + max); // 3

        int min = numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);
        System.out.println("Min using reduce: " + min); // 1

        int squareSum = numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + squareSum); // 14

        int cubeSum = numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
        System.out.println("Sum of cubes: " + cubeSum); // 36
    }

    // 2. Filtering odd numbers and summing
    public static void filterReduceExample() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int oddSum = list.stream()
                .filter(x -> x % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("Sum of odd numbers: " + oddSum); // 25
    }

    // 3. Distinct values from a list
    public static void distinctExample() {
        List<Integer> number = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,5,6,7,6,5,8,9,8,6,8));
        System.out.println("Distinct elements:");
        number.stream().distinct().forEach(System.out::println);
    }

    // 4. Sorting list of integers (ascending and descending)
    public static void sortedExample() {
        List<Integer> number = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,5,6,7,6,5,8,9,8,6,8));

        System.out.println("Sorted ascending:");
        number.stream().sorted().forEach(System.out::println);
    }

    // 5. Sorting in reverse order using Comparator (dedicated method)
    public static void reverseSortingExample() {
        List<Integer> number = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,5,6,7,6,5,8,9,8,6,8));

        System.out.println("Sorted descending using Comparator:");
        number.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    // 6. Sorting list of strings by length
    public static void stringSortingExample() {
        List<String> locations = List.of("jammu", "kashmir", "ladakh", "kathua", "delhi", "jammu");

        System.out.println("Strings sorted by length:");
        locations.stream()
                .sorted(Comparator.comparing(x -> x.length()))
                .forEach(System.out::println);
    }

    // 7. Mapping integers to squares and collecting to list
    public static void mapCollectExample() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        List<Integer> squares = list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        System.out.println("Squares list: " + squares); // [1, 4, 9, ..., 81]
    }
}
