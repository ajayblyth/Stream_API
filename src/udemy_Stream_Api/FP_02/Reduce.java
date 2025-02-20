package udemy_Stream_Api.FP_02;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> numbers =Arrays.asList(23,234,56,77,-89,76,543,32);
//        int  result = reduceMethod(numbers);
//        System.out.println(result);
        reduceByLambda(numbers);
        reduceByBuiltInMethods(numbers);
        maxNumberUsingReduce(numbers);
        minNumberUsingReduce(numbers);
    }

    private static void minNumberUsingReduce(List<Integer> numbers) {
        int min = numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);
        System.out.println("min = " +min);
    }
    //Note use Interger.Min_value to deal with negative numbers as well

    private static void maxNumberUsingReduce(List<Integer> numbers) {
        int max = numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
        System.out.println("max= " + max);
    }

    private static void reduceByBuiltInMethods(List<Integer> numbers) {
        int addition = numbers.stream().reduce(0, Integer::sum);
        System.out.println("addition = " + addition);
    }

    private static void reduceByLambda(List<Integer> numbers) {
        int sum = numbers.stream().reduce(0,(x,y)-> x+y);
        System.out.println("sum = " + sum);
    }

    private static int sum(int a, int b){
        return a+b;
}
    private static int reduceMethod(List<Integer> numbers) {
        return  numbers.stream().reduce(0,Reduce::sum);
    }
}
