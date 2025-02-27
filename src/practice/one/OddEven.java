package practice.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddEven {
    public static void main(String[] args) {
      List<Integer> numbers=  new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
      numbers.stream().filter(x-> x%2 ==0).forEach(x-> System.out.print(x + " ") );//check

      numbers.stream().filter(x->x%2!=0).forEach(System.out::println);//check

    }
}
