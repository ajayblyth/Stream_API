package practice;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPi {
    public static void main(String[] args) {
        System.out.println(  Stream.of(11,23,55,32,1,3,4,3,2,5,7,8,5,4,2).reduce(0,Integer::sum));

        List<Integer> list = new ArrayList<>(Arrays.asList(22,3,44,5,65,11,23,55,32,1,3,4,3,2,5,7,8,5,4,2,43,67));


//avg
        double avg = list.stream()
                .reduce(0, Integer::sum) / (double) list.size();
        System.out.println(avg);

        //avg

        System.out.println(
                list.stream().mapToInt(x -> x).average().orElse(0.0));

        //square/average
        double db = list.stream().map(x -> x * x).peek(System.out::println).mapToInt(x -> x).average().orElse(0.0);

        System.out.println("square and average " + db);

        System.out.println(list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));


        //starts with

        list.stream()
                .filter(x -> String.valueOf(x).startsWith("2"))
                .forEach(System.out::println);


        //give duplicates
        Set<Integer> set= list.stream().filter(x->Collections.frequency(list,x)>1).collect(Collectors.toSet());
        System.out.println(set);

        //min and max
        int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(max);

        int min =list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(min);

        //second highest salary
        Optional<Integer> secondHighest = list.stream()
                .distinct()
                .sorted((a, b) -> b - a)  // descending order
                .skip(1)
                .findFirst();

        System.out.println(secondHighest);


    }


}
