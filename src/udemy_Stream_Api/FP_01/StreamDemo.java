package udemy_Stream_Api.FP_01;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import java.util.Optional;
import java.util.IntSummaryStatistics;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());


        // ✅ Arrays.stream(): Converts array to stream (works with primitive arrays too)
        int[] arr = {1, 2, 3, 4};
        Arrays.stream(arr).forEach(System.out::print); // 1234
        System.out.println();

        // ✅ Stream.of(): Creates a stream from varargs or single object
        Stream<String> fruitStream = Stream.of("apple", "banana", "mango");
        fruitStream.forEach(System.out::println); // apple banana mango

        // 🔹 Difference: Stream.of works on varargs or arrays,
        //     whereas List.of creates an immutable list, and list.stream() works on collections
        List<String> fruits = List.of("grapes", "papaya");
        fruits.stream().forEach(System.out::println); // grapes papaya


        // 🔹IntStream uses primitives directly (no boxing/unboxing needed)
        // ✅ IntStream.range vs rangeClosed
        IntStream.range(1, 5).forEach(System.out::print);     // 1234
        System.out.println();
        IntStream.rangeClosed(1, 5).forEach(System.out::print); // 12345
        System.out.println();


        // ✅ Print even numbers between 1 to 10
        IntStream.rangeClosed(1, 10)
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.print(x + " "));  // 2 4 6 8 10
        System.out.println();

        // ✅ Print odd numbers between 1 to 10
        IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 != 0)
                .forEach(n -> System.out.print(n + " "));  // 1 3 5 7 9
        System.out.println();

        // ✅ Sum of numbers from 1 to 10
        int totalSum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum: " + totalSum); // Sum: 55

        // ✅ Square each number and print
        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));  // 1 4 9 16 25
        System.out.println();

        // ✅ Count even numbers from 1 to 20
        long evenCount = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Even Count: " + evenCount); // 10

        // ✅ Convert IntStream to List<Integer>
        List<Integer> squares = IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Squares List: " + squares); // [1, 4, 9, 16, 25]

        // ✅ Find max and min in a range
        int max = IntStream.rangeClosed(10, 50).max().orElse(-1);
        int min = IntStream.rangeClosed(10, 50).min().orElse(-1);
        System.out.println("Max: " + max + ", Min: " + min); // Max: 50, Min: 10

        // ✅ Filter prime numbers in a range (basic)
        IntStream.rangeClosed(1, 20)
                .filter(n -> isPrime(n))
                .forEach(n -> System.out.print(n + " ")); // 2 3 5 7 11 13 17 19
        System.out.println();

        // ✅ Optional from findFirst() example
        List<String> names = List.of("ram", "ramesh", "radha");
        Optional<String> first = names.stream().filter(x -> x.startsWith("r")).findFirst();
        System.out.println(first.get()); // ram


        // ✅ allMatch returns true if *all* elements in the stream satisfy the condition.
        // anyMatch: returns true if *any one* element satisfies the condition.
        // noneMatch: returns true if *none* of the elements satisfy the condition.
        List<Integer> nums = List.of(2, 4, 6, 8);
        System.out.println(nums.stream().allMatch(x -> x % 2 == 0));  // true
        System.out.println(nums.stream().anyMatch(x -> x > 5));       // true
        System.out.println(nums.stream().noneMatch(x -> x < 0));      // true

        // ✅ toSet(): collect stream elements into Set (removes duplicates)
        Set<String> fruitSet = fruits.stream().collect(Collectors.toSet());
        System.out.println(fruitSet); // [grapes, papaya]

        // ✅ toMap(): collect into key-value pairs
        Map<Integer, String> map = names.stream()
                .collect(Collectors.toMap(
                        String::length,     // ✅ keyMapper → key = length of the string
                        x -> x,             // ✅ valueMapper → value = the string itself
                        (v1, v2) -> v1      // ✅ mergeFunction → if same key, keep first one, beacause duplicate keys not allowed
                ));
        System.out.println(map); // {3=ram, 6=ramesh}

        // ✅ flatMap example with nested list
        List<List<String>> nested = List.of(
                List.of("one", "two"),
                List.of("three", "four")
        );
        List<String> flatList = nested.stream()
                .flatMap(Collection::stream)//Collections::stream because it will work on different types as well, i.e List , Set etc.
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


        // ✅ flatMap example using Arrays.asList() — mutable list backed by array
        List<String> l1 = Arrays.asList("apple", "banana");
        List<String> l2 = Arrays.asList("cherry", "date");
        List<List<String>> fruitNested = Arrays.asList(l1, l2);
        List<String> fruitss = fruitNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(fruitss); // [apple, banana, cherry, date]

        // ✅ Nested mutable list using constructor chaining
        List<List<String>> cityNested = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList("Mumbai", "Pune")),
                        new ArrayList<>(Arrays.asList("Delhi", "Bangalore"))
                )
        );

        List<String> cities = cityNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(cities); // [Mumbai, Pune, Delhi, Bangalore]

        // 🔸 Note:
        // Arrays.asList() returns a fixed-size list backed by array.
        // You can modify elements, but can't add/remove elements (will throw UnsupportedOperationException)



        /*
        📝 Difference between List.of(), Arrays.asList(), and new ArrayList<>():
        - List.of(...)         → Immutable list, throws UnsupportedOperationException on add/remove (Java 9+)
        - Arrays.asList(...)   → Fixed-size, mutable elements but can't add/remove structure
        - new ArrayList<>()    → Fully mutable list, recommended for dynamic list operations (add/remove etc.)
        */

        // ✅ reduce() — used for aggregation/summarizing (sum, min, max, etc.)
        // 💡 reduce(identity, accumulator)
        // identity    → Initial value used as a starting point (e.g., 0 for sum, Integer.MAX_VALUE for min, Integer.MIN_VALUE for max)
        // accumulator → A lambda expression or method reference that takes two inputs and returns a combined result
        //             → Example: (x, y) -> x + y OR Integer::sum


        // ✅ reduce() — find minimum number using lambda
        List<Integer> nums2 = List.of(12, 5, 8, -3, 21);
        int minVal = nums2.stream()
                .reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x); // Picks smaller of x and y
        System.out.println("min = " + minVal);

        // ✅ reduce() — find maximum number using lambda
        int maxVal = nums2.stream()
                .reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y); // Picks greater of x and y
        System.out.println("max = " + maxVal);

        // ✅ reduce() — using built-in method reference Integer::sum
        int addition = nums2.stream()
                .reduce(0, Integer::sum); // Adds all elements together
        System.out.println("addition = " + addition);

        // ✅ reduce() — using lambda (same logic as Integer::sum)
        int sum = nums2.stream()
                .reduce(0, (x, y) -> x + y); // x is the accumulator, y is the next element
        System.out.println("sum = " + sum);

        // ✅ reduce() — using custom method reference
        int reducedCustom = nums2.stream()
                .reduce(0, StreamDemo::sum); // Using custom static method
        System.out.println("reducedCustom = " + reducedCustom);

        // ✅ Integer::compare — used for min/max comparators
        List<Integer> compareList = List.of(8, 3, 7, 1);
        int minC = compareList.stream().min(Integer::compare).orElse(-1);
        int maxC = compareList.stream().max(Integer::compare).orElse(-1);
        System.out.println("Min: " + minC); // Min: 1
        System.out.println("Max: " + maxC); // Max: 8
        // orElse(): provides default when Optional is empty


        // ✅ mapToInt(): used to convert objects to primitive int (for summary stats etc.)
        int maxUsingMapToInt = compareList.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(-1);
        System.out.println("Max using mapToInt: " + maxUsingMapToInt); // 8

        // ✅ count(): counts number of elements in stream
        long count = compareList.stream().count();
        System.out.println("Count: " + count); // 4

        // ✅ Parallel Stream — runs in multithreaded manner (non-deterministic order)
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
                .collect(Collectors.groupingBy(x -> x.charAt(0)));
        System.out.println(grouped); // {a=[apple, ant], b=[bat, ball, banana]}




        // ✅ Collectors.partitioningBy — splits into two groups based on predicate (true/false)
        List<Integer> mix = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = mix.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned); // {false=[1, 3, 5], true=[2, 4, 6]}

        //for even and odd instead of true/false like in partitioningBy

        Map<String, List<Integer>> result = mix.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0 ? "even" : "odd"));


        // ✅ summaryStatistics(): get count, sum, min, average, max
        IntSummaryStatistics stats = mix.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Summary Stats: " + stats);   // Output:
        // Summary Stats: IntSummaryStatistics{count=6, sum=21, min=1, average=3.500000, max=6}

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
        System.out.println(LocalDate.now());
        System.out.println(System.currentTimeMillis());

//        System.currentTimeMillis() vs LocalDateTime.now()
    }

    // ✅ Helper method for checking prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0);
    }

    // ✅ Custom static sum method for reduce()
    public static int sum(int a, int b) {
        return a + b;
    }
}

