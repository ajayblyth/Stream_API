package practice.section3;

import java.util.List;

public class Names_with_their_length {
    public static void main(String[] args) {
        List<String> names = List.of("ajay", "vijay", "ajay", "shravan", "pankaj", "abcc","kuchbhi");
names.stream().distinct().map(x-> x + " " + x.length() ).forEach(System.out::println);

    }

}
