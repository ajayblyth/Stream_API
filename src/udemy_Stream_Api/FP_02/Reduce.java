package udemy_Stream_Api.FP_02;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> numbers =Arrays.asList(23,234,56,77,89,76,543,32);
        int  result = reduceMethod(numbers);
        System.out.println(result);
    }
private static int sum(int a, int b){
        return a+b;
}
    private static int reduceMethod(List<Integer> numbers) {
        return  numbers.stream().reduce(0,Reduce::sum);
    }
}
