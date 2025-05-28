package udemy_Stream_Api.FP_02;

import java.util.*;
import java.util.stream.*;

public class WordLengthDemo {

    public static void main(String[] args) {
        String sentence = "Java is a powerful language and Java is fun";

        // ✅ Approach 1: Using Stream API to directly print word and its length
        System.out.println("Approach 1: Stream + forEach");
        Arrays.stream(sentence.split("\\s+"))  // split by one or more spaces
                .forEach(word -> System.out.println(word + " → " + word.length()));

        System.out.println("\n-----------------------------");

        // ✅ Approach 2: Traditional for-each loop
        System.out.println("Approach 2: Traditional For-Each Loop");
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            System.out.println(word + " → " + word.length());
        }

        System.out.println("\n-----------------------------");

        // ✅ Approach 3: Using Collectors.toMap to store word and its length in a Map
        System.out.println("Approach 3: Using Stream + Collectors.toMap");
        Map<String, Integer> wordLengthMap = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.toMap(
                        word -> word,            // keyMapper: word as the key
                        word -> word.length(),   // valueMapper: length of the word
                        (len1, len2) -> len1      // mergeFunction: if duplicate key (same word), keep first one
                        // Reason: words like "Java" and "is" are repeated
                ));

        // Print map entries
        wordLengthMap.forEach((word, length) ->
                System.out.println(word + " → " + length));
    }
}

