package practice;

import java.util.List;

public class printAndFilter {
    public static void main(String[] args) {
        List<String> locations = List.of("jammu", "kashmir", "ladakh", "chennai", "karnataka");
//      locations.stream().forEach(x-> System.out.print(x + " "));
//      locations.stream().forEach(System.out::println);

        locations.stream().filter(x -> x.contains("na")).forEach(System.out::println);
        System.out.println("length > 7");
        locations.stream().filter(x -> x.length() > 7).forEach(System.out::println);

        System.out.println(" length of characters");
        locations.stream().map(x -> x + " " + x.length())
                .forEach(System.out::println);
    }
}
