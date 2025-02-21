package udemy_Stream_Api.FP07;

import java.util.function.Function;

public class HigherOrderFunctionReturn {
    // Higher-order function: Returns a function
    public static Function<Integer, Integer> getOperation(String type) {
        if ("double".equals(type)) {
            return x -> x * 2;
        } else if ("square".equals(type)) {
            return x -> x * x;
        } else {
            return x -> x; // Identity function
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> operation = getOperation("square");
        System.out.println(operation.apply(4));
    }
}
//Note: HOF Returning a Function--	Function<Integer, Integer> op = getOperation("square");
