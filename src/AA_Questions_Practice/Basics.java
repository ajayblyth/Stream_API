package AA_Questions_Practice;

import java.util.*;
import java.util.stream.*;

public class Basics {
    public static void main(String[] args) {
      isEven();
      toUppercase();
      startsA();
      square();
      fivePluslength();
      sum();

    }

    private static void sum() {

        int sum = IntStream.rangeClosed(1,10).reduce(0,(x,y)->x+y);
        System.out.println("sum using reduce is = " + sum);
    }

    private static void fivePluslength() {

       List<String> five =  Stream.of("vjahvmh", "mdBHB", "fjashfh" , "hjbdjd","gsg", "gjnn").filter(x->x.length() > 5).collect(Collectors.toList());
        System.out.println("greater than 5 string = " + five);
    }

    private static void square() {
        List<Integer> squares= List.of(1,2,3,4,5,6).stream().map(x-> x*x).collect(Collectors.toList());

        System.out.println("squares = " + squares);
    }

    private static void startsA() {
       long lettersA= Stream.of("ajay", "vijay", "Aakash", "arun").filter(x->x.toUpperCase().startsWith("A")).count();
        System.out.println("letters starting with A = "  + lettersA);

        //count returns long value
    }


    private static void toUppercase() {
        Stream.of("ajay", "vijay", "gajay", "tajay").map(x->x.toUpperCase()).forEach(x-> System.out.println(x));
    }



    private static void isEven() {
        List<Integer> list  = Arrays.asList(1,2,3,4,5,6,7,8);
        /*

         */

//        list.stream().filter(x-> x % 2 == 0).forEach(x); // fix how to use for each here
        List<Integer> even = list.stream().filter(x-> x % 2 == 0).collect(Collectors.toList());
        System.out.println(even);
    }
}


/*
Intermediate operations return a Stream and can be chained.
Examples: map(), filter(), sorted()

Terminal operations produce a final result or void and end the stream pipeline.
Examples: forEach() (void), collect() (collection), reduce() (value), count() (long)

Intermediate = transforms stream → returns Stream
Terminal = consumes stream → returns result or void

------------------------------------------------------------------------

   IntStream.of(1, 2, 3);    // Stream of specified values: 1, 2, 3
        IntStream.range(1, 4) ;           // Stream from 1 to 3 (end is exclusive)
        IntStream.rangeClosed(1, 4);      // Stream from 1 to 4 (end is inclusive)
        ---------------------------------------------------------------------------------------
         In Java Streams, forEach() requires a Consumer (a function that takes an element and does something).
 Use a lambda:     stream.forEach(x -> System.out.println(x));
 Or a method ref:  stream.forEach(System.out::println);
 You can't pass just a variable like forEach(x); — that's invalid.

 ------------------------------------------------------------------------

 | No | Method / Expression               | Input Type   | Output Type     | Returns?                |
|----|----------------------------------|--------------|------------------|--------------------------|
| 1  | x.length()                       | String       | int              | Integer (length)         |
| 2  | x.toUpperCase()                  | String       | String           | Transformed String       |
| 3  | x.startsWith("A")                | String       | boolean          | Boolean result           |
| 4  | x.substring(0, 2)                | String       | String           | Substring                |
| 5  | x.charAt(0)                      | String       | char             | Character                |
| 6  | x.split(",")                     | String       | String[]         | Array of Strings         |
| 7  | x.toCharArray()                  | String       | char[]           | Character Array          |
| 8  | Integer.parseInt(x)              | String       | int              | Primitive int            |
| 9  | String.valueOf(x)                | int, boolean | String           | String value             |
| 10 | x.doubleValue()                  | Integer      | double           | Primitive double         |
| 11 | x.getName()                      | Object       | String           | Name property            |
| 12 | x.getSalary()                    | Employee     | double           | Salary value             |
| 13 | LocalDate.parse(x)               | String       | LocalDate        | Date object              |
| 14 | x.format(DateTimeFormatter)      | LocalDate    | String           | Formatted String         |
| 15 | Stream.of(...).count()           | Stream<T>    | long             | Count value              |


 */