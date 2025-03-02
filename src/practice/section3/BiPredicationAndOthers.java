package practice.section3;

import org.w3c.dom.ls.LSOutput;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicationAndOthers {
    public static void main(String[] args) {

        //bipredicate test() two values and returns boolean only
        BiPredicate<Integer,String> value = (x,y)->x>10 && y.length()<7;

        System.out.println(value.test(12,"ajay"));

        //bifunction , apply() two values and return one
        BiFunction<Integer,String,String>value1 = (x,y)-> {
            return x + " " +y;
        };
        System.out.println(value1.apply(11, "  sharma"));


        //accept() two values returns same
        BiConsumer<Integer, String> value2 =(x,y)->{
            System.out.println(x);
            System.out.println(y);
        };
        value2.accept(56,"biconsumer");
    }

}
/*
Tips use primitive date type when using lambda on primitives, its saves the time of boxing/unboxing
e.g IntBinaryOperator intBinaryOperator = (x,y) -> x+y; it deals with primitive instead of wrapper INTEGER
other examples are:
IntConsumer
IntFunction
IntPredicate
IntSupplier
IntToDoubleFunction
IntUnaryOperator
 */