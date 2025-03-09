package practice.Section7;


import java.util.function.Function;

public class HOF {
    public static Function<Integer, Integer> getOperation(String type) {
        if ("ajay".equals(type)) {
            return x -> x * 2;


        } else if ("sharma".equals(type)) {

            return x -> x * x;
        } else {
            return x -> x; // Identity function
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> operation = getOperation("ajay");
        System.out.println(operation.apply(4));
    }
}

