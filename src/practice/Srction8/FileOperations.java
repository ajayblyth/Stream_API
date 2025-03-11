package practice.Srction8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {
    public static void main(String[] args) throws IOException {
//        Files.lines(Paths.get("src/TestFile"))
//                .map(x-> x.split(" "))
//                        .flatMap(Arrays::stream).forEach(System.out::println);

//        Breakdown of Files.lines(Paths.get("src/TestFile"))
//        Files – A utility class in java.nio.file for file operations.
//        lines(...) – Reads a file line by line and returns a Stream<String>.
//        Paths – A utility class to create Path objects.
//        get(...) – Converts a file path (e.g., "src/TestFile") into a Path object.
//        This reads "src/TestFile" as a stream of lines.


                // for list
        Files.list(Paths.get(".")).filter(Files::isDirectory)
                .forEach(System.out::println);

    }
}


//File Operation	                           Functional Approach
//Read a File	                               Files.lines(path).forEach(...)
//Filter and Transform	                         .filter(...).map(...).collect(...)
//Write a File	                                Files.write(path, List.of(...))
//Efficient Large File Processing	            Stream<String> (Lazy Evaluation)
//List Files in a Directory	                     Files.list(path).forEach(...)
//Count Words in a File                   	.flatMap(line -> Arrays.stream(line.split("\\s+")))
//Merge Multiple Files	                      flatMap(Files.lines(file))
//


