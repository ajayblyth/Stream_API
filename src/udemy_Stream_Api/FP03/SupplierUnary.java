package udemy_Stream_Api.FP03;

import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SupplierUnary {
    public static void main(String[] args) {
        Supplier<Integer> suplier = ()->{
            Random random = new Random();
            return random.nextInt(1000);

        };
        System.out.println(suplier.get());


        UnaryOperator<Integer> unaryOperator = (x)-> x*5;

        System.out.println(unaryOperator.apply(10));
    }
}
