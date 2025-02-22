package psa_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) {
        List<Employee> data = Arrays.asList(
                new Employee(1, "Mike", 20000),
                new Employee(2, "Adam", 25000),
                new Employee(3, "Smith", 22000),
                new Employee(4, "mike", 22000),
                new Employee(5, "kyoto", 18000)
        );

        System.out.println(data.stream().collect(Collectors.toList()) );
        List<Employee>newData = data.stream().filter(e->e.getSalary()>20000).collect(Collectors.toList());
        for(Employee e: newData){
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getSalary());
            System.out.println(" ....");
            System.out.println(" ....");
        }

      newData = data.stream().filter(e->e.getName().equalsIgnoreCase("mike")).collect(Collectors.toList());
        for(Employee e: newData){
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getSalary());
            System.out.println(" ....");
            System.out.println(" ....");
        }
        List<String> salaryHike = data.stream()
                .map(e-> " employee: " + e.getName() + " previous salary = " + e.getSalary()
                        + " new salary = " +( e.getSalary() + e.getSalary()* 10/100))
                .collect(Collectors.toList());

       salaryHike.forEach(System.out::println);
    }

}
