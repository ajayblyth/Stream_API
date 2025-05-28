package practice;

import java.util.*;

public class Examples {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(2000,3000,4000,5000,4333,9888));
//
//        var secondHighest  = list.stream()
//                .distinct()
//                .sorted(Comparator.reverseOrder())
//                .skip(1).findFirst();
//        System.out.println(secondHighest);

        int[] salary = {2000,3000,4000,5000,4333,9888, 9500};

        int n = salary.length;

        int largest = Integer.MIN_VALUE;

        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i<n ;i++){
            if(salary[i] > largest){

                secondLargest = largest;
            largest = salary[i];

            }

            if(salary[i]>secondLargest && salary[i]< largest){
                secondLargest = salary[i];

            }

        }

        System.out.println("largest number = " + largest);
        System.out.println("second largest = " + secondLargest);



    }
}
