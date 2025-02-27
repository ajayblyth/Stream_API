package practice.section3;

import java.util.Comparator;
import java.util.List;

public class Comparatorr {
    public static void main(String[] args) {
        List<String> names = List.of("ajay", "vijay", "ajay", "shravan", "pankaj", "abcc","kuchbhi");
        names.stream().sorted(Comparator.reverseOrder()).distinct().forEach(System.out::println);

        System.out.println("compare and sort by length");
        names.stream().sorted(Comparator.comparing(x->x.length())).forEach(System.out::println);

    }
}
