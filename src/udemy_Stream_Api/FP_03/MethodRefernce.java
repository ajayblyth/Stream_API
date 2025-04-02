package udemy_Stream_Api.FP_03;

import java.util.List;
import java.util.stream.Collectors;

public class MethodRefernce {
    public static void main(String[] args) {
        List<String> names = List.of("ajay", "sharma", " abc"," defg",  "kunla", "jammu");
//        names.stream()
//        .map(x-> x.toUpperCase())
//        .forEach(System.out::println);

        List<String> result =names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);

    }
}
