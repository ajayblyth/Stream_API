package udemy_Stream_Api.FP03;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiConsumer_predicate_function {
    public static void main(String[] args) {
        BiPredicate < Integer ,String> biPredicate = (x, y)->{

        return x>10 && y.length()>3;
        } ;
        System.out.println(biPredicate.test(13, "abcdes"));

        BiFunction< Integer ,String,String > biFunction = (x, y)->{

            return x + " " + y;
        };
            System.out.println(biFunction.apply(10,"ajay"));

        BiConsumer< Integer, String> biConsumer = (x,y)->{
            System.out.println(x);
            System.out.println(y);
        };
       biConsumer.accept(10,"abc");


    }

}
