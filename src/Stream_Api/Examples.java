package Stream_Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Examples {
    public static void main(String[] args) {
evenOdd();
namesFilter();

    }

    public static void evenOdd() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 12, 33, 30, 40, 11, 23, 67, 89));// ,mutable because of newArrayList<>
        List<Integer> evenNumbers = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("even = " + evenNumbers);

        List<Integer> oddNumbers = list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);
    }
    public static void namesFilter(){
        List<String> list = new ArrayList<>(Arrays.asList("Ajay ", "Sonu ", "sijay578", "SUNal", "Tarun"));
        List<String> newData = list.stream()
                .map(i -> i.replaceAll("\\s", ""))  // Remove spaces
                .filter(i -> i.toLowerCase().startsWith("s"))  // Case-insensitive startsWith("s")
                .filter(i -> i.matches("^[a-zA-Z]+$"))  // Only alphabets (no numbers or special chars)
                .collect(Collectors.toList());

        System.out.println(newData);

        list.stream()
                .map(String::trim)
                .filter(i -> i.toLowerCase().startsWith("s"))
                .filter(i -> i.matches("^[a-zA-Z]+$"))
                .forEach(System.out::println);
    }

}