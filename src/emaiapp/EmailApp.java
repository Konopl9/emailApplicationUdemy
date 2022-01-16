package emaiapp;

public class EmailApp {

    public static void main(String[] args) {
        Email email = new Email("Max", "Mishchenko");

        System.out.println(email.showInfo());
    }
}
