package udemy_Stream_Api.FP_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CollectionMethods {


        public static void main(String[] args) {
            List<String> mutable = new ArrayList<>(Arrays.asList("jammu", "ludhiana", "jalandhar", "himachal", "chennai"));

            // Convert all elements to uppercase
            mutable.replaceAll(String::toUpperCase);
            System.out.println("After replaceAll: " + mutable);
            // Output: [JAMMU, LUDHIANA, JALANDHAR, HIMACHAL, CHENNAI]

            // Remove elements with length greater than 8
            mutable.removeIf(x -> x.length() > 8);
            System.out.println("After removeIf: " + mutable);
            // Output: [JAMMU, CHENNAI]

            // Adding more elements to demonstrate more methods
            mutable.add("delhi");
            mutable.add("mumbai");
            mutable.add("pune");
            System.out.println("After adding new elements: " + mutable);
            // Output: [JAMMU, CHENNAI, delhi, mumbai, pune]

            // Remove a specific element
            mutable.remove("pune");
            System.out.println("After remove(\"pune\"): " + mutable);
            // Output: [JAMMU, CHENNAI, delhi, mumbai]

            // Remove multiple elements using removeAll()
            mutable.removeAll(Arrays.asList("MUMBAI", "DELHI"));
            System.out.println("After removeAll: " + mutable);
            // Output: [JAMMU, CHENNAI, delhi, mumbai] (unchanged because removeAll is case-sensitive)

            // Retain only specified elements using retainAll()
            mutable.retainAll(Arrays.asList("JAMMU", "CHENNAI"));
            System.out.println("After retainAll: " + mutable);
            // Output: [JAMMU, CHENNAI]

            // Add new elements again for more operations
            mutable.add("kolkata");
            mutable.add("bangalore");
            mutable.add("hyderabad");
            System.out.println("After adding new elements again: " + mutable);
            // Output: [JAMMU, CHENNAI, kolkata, bangalore, hyderabad]

            // Sorting the list alphabetically
            mutable.sort(String::compareToIgnoreCase);
            System.out.println("After sorting: " + mutable);
            // Output: [bangalore, CHENNAI, hyderabad, JAMMU, kolkata]

            // Check if the list contains an element
            boolean containsDelhi = mutable.contains("DELHI");
            System.out.println("Contains 'DELHI'?: " + containsDelhi);
            // Output: false (case-sensitive check)

            // Convert list to array
            String[] array = mutable.toArray(new String[0]); //check note at bottom for more explanation
            System.out.println("Converted to array: " + Arrays.toString(array));
            // Output: [bangalore, CHENNAI, hyderabad, JAMMU, kolkata]

            // Clear all elements
            mutable.clear();
            System.out.println("After clear(): " + mutable);
            // Output: []

            // Check if the list is empty
            boolean isEmpty = mutable.isEmpty();
            System.out.println("Is the list empty?: " + isEmpty);
            // Output: true
        }
    }
/*
Note:2. What happens internally?
When mutable.toArray(new String[0]) is called:

Java sees that the provided array (new String[0]) is too small.
It creates a new array of size mutable.size().
It copies all elements from the list into this new array.
Returns the new array.
*/