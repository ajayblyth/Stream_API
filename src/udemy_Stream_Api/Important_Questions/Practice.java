package udemy_Stream_Api.Important_Questions;

import java.util.Arrays;
import java.util.List;

/*
filter() - How do you filter a list of words to keep only those that start with 'a'?

map() - How do you convert all words in a list to uppercase using Streams?

flatMap() - How do you flatten a list of lists into a single list using Streams?

distinct() - How do you remove duplicate elements from a Stream?

sorted() - How do you sort a list of words in alphabetical order using Streams?

peek() - How can you use peek() to debug elements before transformation in a Stream?

limit() - How do you retrieve only the first 3 elements from a Stream?

skip() - How do you skip the first 2 elements in a Stream and collect the remaining ones?

Combine Operations - How do you filter words that start with 'a', convert them to uppercase, and then sort them?

Performance - What is the effect of distinct() before or after sorting in a Stream pipeline?
 */
public class Practice {
    public static void main(String[] args) {
List<String> words = List.of("ajay", "vijay", "Aakash", "rathore", "srikant", "akshay");
words.stream().filter(x->x.startsWith("a") || x.startsWith("A")).forEach(System.out::println);

//
        String sentence = " What is the effect of distinct() before or after sorting in a Stream pipeline";
        List<String> words1 = Arrays.asList(sentence.split(" "));
        words1.stream().filter(x->x.startsWith("d") || x.startsWith("p")).forEach(System.out::println);
    }
}
