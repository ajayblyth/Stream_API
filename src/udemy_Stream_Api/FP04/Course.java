package udemy_Stream_Api.FP04;

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
