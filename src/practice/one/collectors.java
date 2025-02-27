package practice.one;

import java.util.List;
import java.util.stream.Collectors;

public class collectors {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,2,2,3,4);

        numbers.stream().map(x->x*x).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("even number filtered");

        List<Integer> odd= numbers.stream().filter(x-> x%2 !=0).collect(Collectors.toList());

        System.out.println(odd);

        List<String> locations = List.of("jammu", "kashmir", "ladakh", "chennai", "karnataka");

List<String > locationsLength= locations.stream().map(x-> x + " " + x.length()).collect(Collectors.toList());
        System.out.println(locationsLength);

    }
}
