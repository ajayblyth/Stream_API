package practice.section3;

import java.util.List;
import java.util.stream.Collectors;

public class MehtodReference1 {
    public class MethodRefernce {
        public static void main(String[] args) {
            List<String> names = List.of("jammu", "kashmir", " ladakh"," doda",  "pathankot");
//        names.stream()
//        .map(x-> x.toUpperCase())
//        .forEach(System.out::println);

            List<String> result =names.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            System.out.println(result);

        }
    }

}
