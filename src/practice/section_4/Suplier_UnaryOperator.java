package practice.section_4;

import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Suplier_UnaryOperator {
    public static void main(String[] args) {
        Supplier<Integer> randomNumber = ()->{
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(randomNumber.get());
//unary operator is specialization of function<T,T> , it takes one argument and gives output of same type
        UnaryOperator<Integer> unaryOperator =(x)->x*10;
        System.out.println("unary " + unaryOperator.apply(10));
    }
}
