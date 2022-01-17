package studentdatabaseapp;

import java.util.Scanner;

public class Student {

  private String firstName;
  private String lastName;
  private int gradeYear;
  private String studentID;
  private String courses = null;
  private int tuitionBalance = 0;
  private static int costOfCourse = 600;
  private static int id = 1001;

  // Constructor: prompt user to enter student's name and year
  public Student() {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter student's first name: ");
    this.firstName = in.nextLine();

    System.out.println("Enter student's last name: ");
    this.lastName = in.nextLine();

    System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student's grade level: ");
    this.gradeYear = in.nextInt();

    setStudentId();

  }

  // Generate an ID
  private void setStudentId() {
    // grade level + ID
    id++;
    this.studentID = gradeYear + "" + id;
  }

  // Enroll a courses
  public void enroll() {
    // Get inside a loop, user hits 0
    do {
      System.out.println("Enter course to enroll (Q to quit): ");
      Scanner in = new Scanner(System.in);
      String course = in.nextLine();

      if(!course.equals("Q")) {
        courses = courses + "\n" + course;
        tuitionBalance = tuitionBalance + costOfCourse;
      } else {
        break;
      }
    } while (true);

    System.out.println("ENROLLED IN: " + courses);
  }

  // View balance
  public void viewBalance() {
    System.out.println("Your balance is: $" + tuitionBalance);
  }

  // Pay tuition
  public void payTuition() {
    viewBalance();
    System.out.println("Enter you payment: $");
    Scanner scanner = new Scanner(System.in);
    int payment = scanner.nextInt();
    tuitionBalance = tuitionBalance - payment;
    System.out.println("Thanks you for your payment of $" + payment);
    viewBalance();
  }

  // Show status
  @Override
  public String toString() {
    return "Name: " + firstName + " " + lastName +
            "\nGrade level:" + gradeYear +
            "\n Student ID:" + studentID +
            "\nCourses Enrolled:" + courses +
            "\nBalance $" + tuitionBalance;
  }
}
