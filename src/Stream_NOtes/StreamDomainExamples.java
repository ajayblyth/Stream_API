package Stream_NOtes;

import java.util.*;
import java.util.stream.*;

public class StreamDomainExamples {

    // ---------------------- STUDENT DOMAIN --------------------------
    static class Student {
        int id;
        String name;
        String grade;
        double marks;

        public Student(int id, String name, String grade, double marks) {
            this.id = id;
            this.name = name;
            this.grade = grade;
            this.marks = marks;
        }

        public String getName() { return name; }
        public String getGrade() { return grade; }
        public double getMarks() { return marks; }
    }

    // ---------------------- ORDER DOMAIN ----------------------------
    static class Order {
        int orderId;
        String customer;
        double amount;
        boolean isDelivered;

        public Order(int orderId, String customer, double amount, boolean isDelivered) {
            this.orderId = orderId;
            this.customer = customer;
            this.amount = amount;
            this.isDelivered = isDelivered;
        }

        public double getAmount() { return amount; }
        public boolean isDelivered() { return isDelivered; }
        public String getCustomer() { return customer; }
    }

    // ---------------------- PRODUCT DOMAIN --------------------------
    static class Product {
        int id;
        String name;
        String category;
        double price;
        boolean inStock;

        public Product(int id, String name, String category, double price, boolean inStock) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.inStock = inStock;
        }

        public boolean isInStock() { return inStock; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }
        public String getName() { return name; }
    }

    public static void main(String[] args) {

        // STUDENT EXAMPLES
        List<Student> students = List.of(
                new Student(1, "Arjun", "A", 88),
                new Student(2, "Bhavna", "B", 76),
                new Student(3, "Chirag", "A", 92),
                new Student(4, "Divya", "C", 60),
                new Student(5, "Esha", "B", 84)
        );

        Optional<Student> topper = students.stream()
                .max(Comparator.comparingDouble(Student::getMarks));

        Map<String, Double> avgMarks = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.averagingDouble(Student::getMarks)));

        List<String> aGraders = students.stream()
                .filter(s -> s.getGrade().equals("A"))
                .map(Student::getName)
                .collect(Collectors.toList());

        // ORDER EXAMPLES
        List<Order> orders = List.of(
                new Order(1, "Ravi", 2500, true),
                new Order(2, "Sita", 1800, false),
                new Order(3, "Amit", 3200, true),
                new Order(4, "Geeta", 4100, false)
        );

        double deliveredTotal = orders.stream()
                .filter(Order::isDelivered)
                .mapToDouble(Order::getAmount)
                .sum();

        Map<Boolean, List<Order>> groupedOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::isDelivered));

        List<String> sortedCustomers = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .map(Order::getCustomer)
                .collect(Collectors.toList());

        // PRODUCT EXAMPLES
        List<Product> products = List.of(
                new Product(1, "Laptop", "Electronics", 55000, true),
                new Product(2, "Chair", "Furniture", 3500, false),
                new Product(3, "Pen", "Stationery", 20, true),
                new Product(4, "Smartphone", "Electronics", 25000, true)
        );

        List<Product> filtered = products.stream()
                .filter(p -> p.isInStock() && p.getPrice() > 1000)
                .collect(Collectors.toList());

        Map<String, List<Product>> byCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        Optional<Product> expensive = products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));

        // PRINT RESULTS
        System.out.println("Topper: " + (topper.isPresent() ? topper.get().getName() : "None"));
        System.out.println("Average Marks by Grade: " + avgMarks);
        System.out.println("A Graders: " + aGraders);

        System.out.println("Total Delivered Amount: " + deliveredTotal);
        System.out.println("Orders Grouped by Delivery: " + groupedOrders);
        System.out.println("Customers by Amount Desc: " + sortedCustomers);

        System.out.println("Filtered In-Stock Products > 1000: " +
                filtered.stream().map(Product::getName).collect(Collectors.toList()));
        System.out.println("Products by Category: " + byCategory);
        System.out.println("Most Expensive Product: " +
                (expensive.isPresent() ? expensive.get().getName() : "None"));
    }
}

