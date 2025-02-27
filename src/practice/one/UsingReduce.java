package practice.one;

import java.util.List;

public class UsingReduce {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println(numbers.stream().reduce(0,Integer::sum));

        System.out.println("using lambda");
        System.out.println(numbers.stream().reduce(0,(a,b)->a+b));

        System.out.println("MethodRefernce: ");
        System.out.println(numbers.stream().reduce(0,Integer::sum));

    }
}
