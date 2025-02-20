package udemy_Stream_Api.Functional_Programmin_Intro;

import java.util.Arrays;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
       List<Integer> list = Arrays.asList(12,45,61,87,54,67,89,32);
//       isOddNumber(list);
          courses();
//       cubeOfOddNumbers(list);
    }

    private static void cubeOfOddNumbers(List<Integer> list) {
        list.stream().filter(x-> x%2 !=0).map(x-> x*x*x).forEach(System.out::println);
    }

    private static void isOddNumber(List<Integer> list) {
        list.stream().filter(x-> x%2 !=0).forEach(System.out::println);
    }
    private static void courses(){
        List <String > course = Arrays.asList("spring","spring boot", "api", "kubernate", "micro service ", "abc");

//      course.stream().filter(x -> x.contains("spring")).forEach(System.out::println);

//        course.stream().filter(x -> x.length()>=4).forEach(System.out::println);
        course.stream().map(x ->x + "-> " + x.length() + "characters").forEach(System.out::println);
    }
}
