package udemy_Stream_Api.FP_01;


import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {

        // ✅ Arrays.stream(): Converts array to stream (works with primitive arrays too)
        int[] arr = {1, 2, 3, 4};
        Arrays.stream(arr).forEach(System.out::print); // 1234
        System.out.println();

        // ✅ Stream.of(): Creates a stream from varargs or single object
        Stream<String> fruitStream = Stream.of("apple", "banana", "mango");
        fruitStream.forEach(System.out::println); // apple banana mango

        // 🔹 Difference: Stream.of works on varargs, while list.stream() works on collections
        List<String> fruits = List.of("grapes", "papaya");
        fruits.stream().forEach(System.out::println); // grapes papaya

        // ✅ IntStream.range vs rangeClosed
        IntStream.range(1, 5).forEach(System.out::print);     // 1234
        System.out.println();
        IntStream.rangeClosed(1, 5).forEach(System.out::print); // 12345
        System.out.println();

        // 🔹 IntStream uses primitives directly (no boxing/unboxing needed)

        // ✅ Optional from findFirst() example
        List<String> names = List.of("ram", "ramesh", "radha");
        Optional<String> first = names.stream().filter(x -> x.startsWith("r")).findFirst();
        System.out.println(first.get()); // ram

        // ✅ allMatch, anyMatch, noneMatch — used for stream-wide condition checking
        List<Integer> nums = List.of(2, 4, 6, 8);
        System.out.println(nums.stream().allMatch(x -> x % 2 == 0));  // true
        System.out.println(nums.stream().anyMatch(x -> x > 5));       // true
        System.out.println(nums.stream().noneMatch(x -> x < 0));      // true

        // ✅ toSet(): collect stream elements into Set (removes duplicates)
        Set<String> fruitSet = fruits.stream().collect(Collectors.toSet());
        System.out.println(fruitSet); // [grapes, papaya]

        // ✅ toMap(): collect into key-value pairs
        Map<Integer, String> map = names.stream().collect(Collectors.toMap(
                String::length,
                x -> x,
                (v1, v2) -> v1
        ));
        System.out.println(map); // {3=ram, 6=ramesh}

        // ✅ flatMap example with nested list
        List<List<String>> nested = List.of(
                List.of("one", "two"),
                List.of("three", "four")
        );
        List<String> flatList = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flatList); // [one, two, three, four]

        // ✅ flatMap with separate lists
        List<String> list1 = List.of("A", "B");
        List<String> list2 = List.of("C", "D");
        List<String> list3 = List.of("E", "F");

        List<String> combined = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(combined); // [A, B, C, D, E, F]

        // ✅ reduce() — used for aggregation/summarizing (sum, min, max, etc.)
        List<Integer> reduceList = List.of(10, 20, 30);
        int sum = reduceList.stream().reduce(0, Integer::sum); // 60
        System.out.println(sum);

        // ✅ Integer::compare — used for min/max comparators
        List<Integer> compareList = List.of(8, 3, 7, 1);
        int min = compareList.stream().min(Integer::compare).orElse(-1);
        int max = compareList.stream().max(Integer::compare).orElse(-1);
        System.out.println("Min: " + min); // Min: 1
        System.out.println("Max: " + max); // Max: 8

        // ✅ orElse(): provides default when Optional is empty
        Optional<Integer> maybeNum = Optional.empty();
        System.out.println(maybeNum.orElse(100)); // 100

        // ✅ mapToInt(): used to convert objects to primitive int (for summary stats etc.)
        int maxVal = compareList.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(-1);
        System.out.println("Max using mapToInt: " + maxVal); // 8

        // ✅ count(): counts number of elements in stream
        long count = compareList.stream().count();
        System.out.println("Count: " + count); // 4

        // ✅ contains() outside stream — checks existence directly in collection
        boolean containsSeven = compareList.contains(7);
        System.out.println("Contains 7? " + containsSeven); // true

        // ✅ Parallel Stream — runs in multi-threaded manner (non-deterministic order)
        System.out.println("Parallel Stream:");
        Arrays.asList("a", "b", "c", "d")
                .parallelStream()
                .forEach(System.out::println);

        // ✅ Custom Comparator — reverse sorting
        List<String> animals = Arrays.asList("dog", "cat", "zebra", "lion");
        animals.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println); // zebra, lion, dog, cat

        // ✅ peek(): debugging or modifying elements in middle of pipeline
        List<String> debugList = Arrays.asList("one", "two", "three");
        debugList.stream()
                .peek(e -> System.out.println("Original: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Uppercased: " + e))
                .collect(Collectors.toList());

        // ✅ Collectors.groupingBy — group elements by key (like SQL group by)
        List<String> words = Arrays.asList("bat", "ball", "apple", "ant", "banana");
        Map<Character, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(grouped); // {a=[apple, ant], b=[bat, ball, banana]}

        // ✅ Collectors.partitioningBy — splits into two groups based on predicate (true/false)
        List<Integer> mix = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = mix.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned); // {false=[1, 3, 5], true=[2, 4, 6]}

        // ✅ summaryStatistics(): get count, sum, min, average, max
        IntSummaryStatistics stats = mix.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Summary Stats: " + stats);

        // ✅ distinct(): remove duplicates from stream
        List<Integer> duplicateList = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> noDuplicates = duplicateList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct values: " + noDuplicates); // [1, 2, 3]

        // ✅ limit() and skip() for pagination-like behavior
        List<Integer> rangeList = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> paginated = rangeList.stream()
                .skip(3)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Skip 3, Limit 4: " + paginated); // [4, 5, 6, 7]

        // ✅ takeWhile() and dropWhile() — introduced in Java 9
        List<Integer> values = List.of(2, 4, 6, 1, 8, 10);

        List<Integer> taken = values.stream()
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("TakeWhile: " + taken); // [2, 4, 6]

        List<Integer> dropped = values.stream()
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("DropWhile: " + dropped); // [1, 8, 10]

        // ✅ stream.concat — merge two separate streams
        Stream<String> streamA = Stream.of("x", "y");
        Stream<String> streamB = Stream.of("z");
        Stream<String> merged = Stream.concat(streamA, streamB);
        merged.forEach(System.out::println); // x y z

        // ✅ Performance tuning tip: avoid intermediate object creation in huge pipelines,
        // prefer primitive streams when dealing with large data sets, and use parallelStream judiciously.
        // Don't overuse peek(), avoid stateful lambda, and prefer terminal ops like collect/count etc.
    }
}

