package practice.Section7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class flatMap_joining_split {

        public static void main(String[] args) {
            
            flatMap();
            joiningExample();
            splitExample();
           
                }

    private static void splitExample() {
            List<String> list = List.of("one", "two", "three", "four");

        List collect = list.stream().map(x -> x.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        //we cant use flatMap(List::stream) as map() gives array of words
        System.out.println("split " + collect);
    }

    private static void joiningExample() {
            List<String> list = List.of("sunday", "monday", "tuesday", "wednesday");
        String collect = list.stream().collect(Collectors.joining(" "));
        System.out.println("join with space= " + collect);
    }

    private static void flatMap() {
        List<String> list1 = Arrays.asList("Apple", "Banana");
        List<String> list2 = Arrays.asList("Orange", "Grapes");
        List<String> list3 = Arrays.asList("Pineapple", "Peach");

        // Use Stream.of() to create a stream of lists and then flatten them
        List<String> flattenedList = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList);  // Output: [Apple, Banana, Orange, Grapes, Pineapple, Peach]


        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Orange", "Grapes"),
                Arrays.asList("Pineapple", "Peach")
        );


        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)  // Flatten the stream of lists into a single stream of strings
                .collect(Collectors.toList());

        System.out.println(flatList);  // Output: [Apple, Banana, Orange, Grapes, Pineapple, Peach]


        //another way to create multiple lists
        List<List<String>> combinedListOfLists = List.of(
                List.of("Apple", "Banana"),
                List.of("Cherry", "Date"),
                List.of("Elderberry", "Fig")
        );
    }
}




