package udemy_Stream_Api.FP08;

//File Operation	                           Functional Approach
//Read a File	                               Files.lines(path).forEach(...)
//Filter and Transform	                         .filter(...).map(...).collect(...)
//Write a File	                                Files.write(path, List.of(...))
//Efficient Large File Processing	            Stream<String> (Lazy Evaluation)
//List Files in a Directory	                     Files.list(path).forEach(...)
//Count Words in a File                   	.flatMap(line -> Arrays.stream(line.split("\\s+")))
//Merge Multiple Files	                      flatMap(Files.lines(file))
//

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP08_files {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("src/random.txt"))
                .map(x->x.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);


    }
}
