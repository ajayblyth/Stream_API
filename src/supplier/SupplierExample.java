package supplier;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        random();
        dateTime();
    }

    public static void random() {
        Supplier<Integer> randomNumber = () -> new Random().nextInt(10);

        Stream.generate(randomNumber).limit(5).forEach(System.out::println);
    }

    public static void dateTime() {
        Supplier<LocalDateTime> currentDateTime = LocalDateTime::now;
        System.out.println("date & time " + currentDateTime.get());
    }
}
