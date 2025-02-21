package udemy_Stream_Api.FP04;


import java.util.List;
import java.util.function.Predicate;


class Course {
    public Course(String name, String category, int noOfStudents, int reviewScore) {
        this.name = name;
        this.noOfStudents = noOfStudents;
        this.reviewScore = reviewScore;
        this.category = category;
    }

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {

        return name + ":" + noOfStudents + ": " + reviewScore;
    }
}


public class customClass {



    public static void main(String[] args) {
        List<Course> courses= List.of(
                new Course("Spring","Framework", 98 , 20000),
                new Course("Spring Boot","Framework", 95 , 18000),

                new Course("API","Microservices", 97 , 22000),

                new Course("MicroServices","Framework", 96 , 25000),

                new Course("FullStack","fullstack", 91 , 14000),

                new Course("Aws","cloud", 92 , 21000),

                new Course("Azure","cloud", 99 , 24000),

                new Course("Docker","cloud", 92 , 20000),
                new Course("Kubernates","cloud", 91 , 20000)

                );
        System.out.println(courses.stream().allMatch(getReviewScoreGreateThan90()));
        System.out.println(courses.stream().anyMatch(getReviewScoreGreateThan95()));
        System.out.println(courses.stream().noneMatch(getReviewScoreLessThan90()));


    }

    private static Predicate<Course> getReviewScoreGreateThan90() {
        return course -> course.getReviewScore() > 90;
    }

    private static Predicate<Course> getReviewScoreGreateThan95() {
        return course -> course.getReviewScore() >95;
    }
    private static Predicate<Course> getReviewScoreLessThan90() {
        return course -> course.getReviewScore() < 90;
    }
}
