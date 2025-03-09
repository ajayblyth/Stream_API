package practice.Section7;

import java.util.stream.LongStream;

public class Performance {


        public static void main(String[] args) {

            long timeTaken = System.currentTimeMillis();//time before excution

            System.out.println(LongStream.rangeClosed(1,999999999).parallel().sum());

            System.out.println("first time");
            System.out.println( System.currentTimeMillis() - timeTaken); // time after


        }
    }


