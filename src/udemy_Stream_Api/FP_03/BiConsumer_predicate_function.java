package udemy_Stream_Api.FP_03;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiConsumer_predicate_function {
    public static void main(String[] args) {

        //bipredicate test() two values and returns boolean only

        BiPredicate < Integer ,String> biPredicate = (x, y)->{

        return x>10 && y.length()>3;
        } ;
        System.out.println(biPredicate.test(13, "abcdes"));

        //bifunction , apply() two values and return one

        BiFunction< Integer ,String,String > biFunction = (x, y)->{

            return x + " " + y;
        };
            System.out.println(biFunction.apply(10,"ajay"));

        //accept() two values returns same
        BiConsumer< Integer, String> biConsumer = (x,y)->{
            System.out.println(x);
            System.out.println(y);
        };
       biConsumer.accept(10,"abc");
    }}
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
