package udemy_Stream_Api.FP_07;

import java.util.function.Function;
//Note:  A higher-order function (HOF) is a function that does at least one of the following:
//
//Takes another function as an argument
//Returns a function as a result
//Higher-order functions enable functional programming in Java, making the code more flexible and reusable.



public class HigherOrderFunctionExample {
    // Higher-Order Function: Accepts a function as an argument
    public static int applyOperation(int number, Function<Integer, Integer> operation) {
        return operation.apply(number);
    }

    public static void main(String[] args) {

        Function<Integer,Integer> square = x -> x * x;
        Function<Integer, Integer> increment = x ->x + 1;

        // Using  higher-order function
        System.out.println(applyOperation(5, square));
        System.out.println(applyOperation(5, increment));
    }
}
//Note: HOF Accepting a Function	applyOperation(5, square);