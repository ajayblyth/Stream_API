package Functional_Interfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> val= x -> x>3;
       boolean result = val.test(10);
        System.out.println(result);
        PredicateExample pe = new PredicateExample();
        pe.evenOdd();
        stringExample();
        startString();
        lengthh();

    }


    public  void evenOdd(){
       Predicate<Integer> val = i-> i%2==0;
        boolean  result = val.test(201);
        if(result){
            System.out.println(" even");
        }
        else{
            System.out.println("odd");

        }
    }
    public static void stringExample() {
        Predicate<String> val = i -> i.equals("ajay");
        Boolean result = val.test("dahixuhx");
        if (result) {
            System.out.println(result);
        } else {
            System.out.println(result);
        }
    }
      public static void startString(){
       Predicate<String> val =  i -> i.startsWith("s");
          Boolean result = val.test("sjay");
          if(result){
              System.out.println("starts with = " + result);
          }else{
              System.out.println("starts with = " + result);
          }

      }
    public static void lengthh(){
        Predicate<String> val =  i -> i.length()>=4;
        Boolean result = val.test("sjay");
        if(result){
            System.out.println("length = " + result);
        }else{
            System.out.println("length = " + result);
        }
}}
//Note: when our logic requires an input which gives a BOOLEAN input then we use predicate