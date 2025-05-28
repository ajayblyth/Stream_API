package practice;

public class Sum {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5};
        int totall = 0;
        for(int n : numbers){
            totall += n;
        }
        System.out.println(totall);
    }
}
