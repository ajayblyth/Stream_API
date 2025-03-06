package udemy_Stream_Api.fpo6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,34,6,43,4,67,87); //uses reference means wrapper classes involved
        list.stream();

        //2nd
        Stream.of(10,20,30,40,50);// also uses reference means wrapper classes involved


        //3rd
        int[] arr = {23,43,56,88,65,78,98,43};

        Arrays.stream(arr);// works on primitive, hence faster
        System.out.println(Arrays.stream(arr).min());
        System.out.println(Arrays.stream(arr).max());
        System.out.println(Arrays.stream(arr).average());
        System.out.println(Arrays.stream(arr).sum());

        //4 IntStream
        System.out.println(IntStream.range(1,10).sum()); //45, exclude last digit

        System.out.println(IntStream.rangeClosed(1,10).sum());//55,include last digit

        System.out.println(IntStream.iterate(2, x->x+2).limit(10).peek(System.out::println).sum());

//       IntStream.iterate(2, x->x+2).limit(10).collect(Collectors.toList())); //error because cant use collector onprimitive type

        //use .boxed()

        System.out.println(IntStream.iterate(2, x->x*2).limit(10).boxed().collect(Collectors.toList()));

        //there are other methods as well , like LongStream , DoubleStream etc.

    }
}
