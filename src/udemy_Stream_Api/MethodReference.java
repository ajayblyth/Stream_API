package udemy_Stream_Api;

import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 4, 5, 7, 3, 8,10);
//        printAllNumbers(numbers);
        evenNumber(numbers);

    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void evenNumber(List<Integer> numbers) {
        numbers.stream().filter(MethodReference::isEven).forEach(System.out::println);
    }




    private static void print(int number){
        System.out.println(number);
    }

    private static void printAllNumbers(List<Integer> numbers) {
       numbers.stream().forEach(MethodReference::print); //method refernce
        }
    }
