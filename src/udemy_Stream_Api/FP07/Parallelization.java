package udemy_Stream_Api.FP07;

import java.util.stream.LongStream;

public class Parallelization {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(1,1000000000L).parallel().sum());
        System.out.println(System.currentTimeMillis() - time);
    }
}
