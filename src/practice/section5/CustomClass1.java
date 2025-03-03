package practice.section5;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    @Override
    public String toString() {
        return name + ":" + category + ":" + noOfStudents + ": " + reviewScore;
    }
}

public class CustomClass1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Course> courses = List.of(
                new Course("Java Basics", "Programming", 95, 15000),
                new Course("Python", "Data Science", 98, 18000),
                new Course("Machine Learning", "Artificial Intelligence", 97, 22000),
                new Course("ReactJS", "Web Development", 93, 17000),
                new Course("Angular", "Web Development", 91, 16000),
                new Course("AWS Cloud Essentials", "Cloud Computing", 96, 25000),
                new Course("Azure Fundamentals", "Cloud Computing", 94, 20000),
                new Course("Docker & Kubernetes", "DevOps", 92, 21000),
                new Course("Spring Boot", "Backend Development", 97, 24000),
                new Course("Hibernate with JPA", "Backend Development", 90, 13000)
        );


        Comparator<Course> compareByStudents = Comparator.comparingInt(Course::getNoOfStudents);
        Comparator<Course> compareByStudentsReversed = compareByStudents.reversed();
        Comparator<Course> compareByStudentsThenReviews =
                Comparator.comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore);
//
//        System.out.println("Sorted by Students: " + courses.stream().sorted(compareByStudents).collect(Collectors.toList()));
//        System.out.println("Sorted by Students Descending: " + courses.stream().sorted(compareByStudentsReversed).collect(Collectors.toList()));
//        System.out.println("Sorted by Students & Reviews: " + courses.stream().sorted(compareByStudentsThenReviews).collect(Collectors.toList()));
//
//        System.out.println(numbers.stream().sorted().skip(2).collect(Collectors.toList()));
//        System.out.println(numbers.stream().sorted().skip(2).limit(3).collect(Collectors.toList()));
//        System.out.println(numbers.stream().takeWhile(x -> x < 3).collect(Collectors.toList()));
//        System.out.println(numbers.stream().dropWhile(x -> x < 4).collect(Collectors.toList()));
//
//        // Max, Min, and Filtering with `orElse`
//        System.out.println(courses.stream().max(compareByStudentsThenReviews));
//        System.out.println(courses.stream().min(compareByStudentsThenReviews));
//        System.out.println(courses.stream()
//                .filter(getReviewScoreLessThan90())
//                .min(compareByStudentsThenReviews)
//                .orElse(new Course("C++ Fundamentals", "Programming", 89, 12000)));
//
//        // Finding Elements
        System.out.println(courses.stream().filter(x -> x.getReviewScore() > 90).findFirst());
        System.out.println(courses.stream().filter(x -> x.getReviewScore() > 95).findAny());



        //Aggregate
        System.out.println("Total Students with >90 Review: " +
                courses.stream().filter(getReviewScoreGreaterThan90()).mapToInt(Course::getNoOfStudents).sum());

        System.out.println("Average Students with >90 Review: " +
                courses.stream().filter(getReviewScoreGreaterThan90()).mapToInt(Course::getNoOfStudents).average());

        System.out.println("Count of Courses with >90 Review: " +
                courses.stream().filter(getReviewScoreGreaterThan90()).count());

        System.out.println("Max Students in >90 Review Courses: " +
                courses.stream().filter(getReviewScoreGreaterThan90()).mapToInt(Course::getNoOfStudents).max());

//        // Grouping
//        System.out.println("Courses Grouped by Category: " +
//                courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
//
//        System.out.println("Count of Courses per Category: " +
//                courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
//
//        System.out.println("Max Review Score per Category: " +
//                courses.stream().collect(Collectors.groupingBy(Course::getCategory,
//                        Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore)))));
//
//        System.out.println("Courses Names Grouped by Category: " +
//                courses.stream().collect(Collectors.groupingBy(Course::getCategory,
//                        Collectors.mapping(Course::getName, Collectors.toList()))));
    }

        //allmatch, nonematch, anymatch, predicate for filtering
        private static Predicate<Course> getReviewScoreGreaterThan90 () {
            return course -> course.getReviewScore() > 90;
        }

        private static Predicate<Course> getReviewScoreGreaterThan95 () {
            return course -> course.getReviewScore() > 95;
        }

        private static Predicate<Course> getReviewScoreLessThan90 () {
            return course -> course.getReviewScore() < 90;
        }
    }
