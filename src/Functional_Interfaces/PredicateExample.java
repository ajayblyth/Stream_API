package Functional_Interfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> val= x -> x>3;
       boolean result = val.test(10);
        System.out.println(result);
    }
}
