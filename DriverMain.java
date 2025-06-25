package task3;

import java.util.Scanner;

//Interface
interface Taxable {
 double SALES_TAX = 0.07;
 double INCOME_TAX = 0.105;

 void calcTax();
}

//Employee class
class Employee implements Taxable {
 int empId;
 String name;
 double salary;

 public Employee(int empId, String name, double salary) {
     this.empId = empId;
     this.name = name;
     this.salary = salary;
 }

 public void calcTax() {
     double yearlySalary = salary * 12;
     System.out.println("Yearly salary:"+" "+yearlySalary);
     double incomeTax = yearlySalary * INCOME_TAX;
     System.out.println("Income Tax for " + name + " is: ₹" + incomeTax);
 }
}

//Product class
class Product implements Taxable {
 int pid;
 double price;
 int quantity;

 public Product(int pid, double price, int quantity) {
     this.pid = pid;
     this.price = price;
     this.quantity = quantity;
 }

 public void calcTax() {
     double salesTax = price * SALES_TAX;
     System.out.println("Per Unit Sales Tax for Product ID " + pid + " is: ₹" + salesTax);
 }
}

//Driver class
public class DriverMain {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Employee Input
     System.out.println("Enter Employee Details:");
     System.out.print("ID: ");
     int empId = scanner.nextInt();
     scanner.nextLine(); // consume leftover newline
     System.out.print("Name: ");
     String name = scanner.nextLine();
     System.out.print("Monthly Salary: ₹");
     double salary = scanner.nextDouble();

     Employee emp = new Employee(empId, name, salary);
     System.out.println();
     emp.calcTax();

     System.out.println(); // Spacer

     // Product Input
     System.out.println("Enter Product Details:");
     System.out.print("Product ID: ");
     int pid = scanner.nextInt();
     System.out.print("Price per unit: ₹");
     double price = scanner.nextDouble();
     System.out.print("Quantity: ");
     int quantity = scanner.nextInt();

     Product product = new Product(pid, price, quantity);
     System.out.println();
     product.calcTax();

     scanner.close();
 }
}