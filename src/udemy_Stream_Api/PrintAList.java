package udemy_Stream_Api;

import java.util.List;

public class PrintAList {
    public static void main(String[] args) {
        printAllNumbers(List.of(1,3,4,5,7,3,4));

    }

    private static void printAllNumbers(List<Integer> numbers) {
        for(int number: numbers){
            System.out.println(number);
        }
    }
}
