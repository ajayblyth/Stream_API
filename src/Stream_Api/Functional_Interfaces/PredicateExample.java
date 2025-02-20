package Stream_Api.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> val= x -> x>3;
       boolean result = val.test(10);
        System.out.println(result);
        PredicateExample pe = new PredicateExample();
        pe.evenOdd();
        stringExample();
        startString();
        filterByLength();
        filterByNumber();

    }


    public  void evenOdd(){
       Predicate<Integer> val = i-> i%2==0;
        boolean  result = val.test(201);
        if(result){
            System.out.println(" even");
        }
        else{
            System.out.println("odd");

        }
    }
    public static void stringExample() {
        Predicate<String> val = i -> i.equals("ajay");
        Boolean result = val.test("dahixuhx");
        if (result) {
            System.out.println(result);
        } else {
            System.out.println(result);
        }
    }
      public static void startString(){
       Predicate<String> val =  i -> i.startsWith("s");
          Boolean result = val.test("sjay");
          if(result){
              System.out.println("starts with = " + result);
          }else{
              System.out.println("starts with = " + result);
          }

      }
public static void filterByLength(){
            List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");

            Predicate<String> greaterThanThree = x -> x.length() > 3;


            words.stream()
                    .filter(greaterThanThree)
                    .forEach(System.out::println);
        }
        public static void filterByNumber(){
    List<Integer> numbers = Arrays.asList(5, 12, 8, 30, 25, 18, 7);

    Predicate<Integer> greaterThanTen = num -> num > 10;

        numbers.stream().filter(greaterThanTen).forEach(System.out::println);
}
}

