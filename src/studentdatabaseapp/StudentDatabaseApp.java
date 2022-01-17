package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

  public static void main(String[] args) {
    // Ask how many users we want to add
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of user you want to enroll: ");
    int numberOfStudents = scanner.nextInt();
    Student[] students = new Student[numberOfStudents];

    // Create a number of students
    for (int i = 0; i < numberOfStudents; i++) {
      students[i] = new Student();
      students[i].payTuition();
      students[i].enroll();
      System.out.println(students[i].toString());
    }
  }
}
