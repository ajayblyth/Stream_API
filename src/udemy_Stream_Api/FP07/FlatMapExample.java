package udemy_Stream_Api.FP07;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> list2 = Arrays.asList("Dog", "Elephant", "Fox");
        List<String> list3 = Arrays.asList("Guitar", "Harmonica", "Violin");

        // Using flatMap to merge all lists into a single list
        List<String> mergedList = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .collect(Collectors.toList());


        System.out.println(mergedList);
    }
}
