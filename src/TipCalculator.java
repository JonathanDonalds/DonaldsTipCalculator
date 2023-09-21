import java.util.Scanner;

public class TipCalculator {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello there!");
        System.out.println("Welcome to my tip calculator!");
        System.out.println("How many people are in your group?");
        int people = scan.nextInt();
        scan.nextLine();
        System.out.println("What would you like your tip percentage to be?");
        double percentage = scan.nextDouble();
        scan.nextLine();
        double cost = 0;
        String item;
        while (cost != -1) {
            System.out.println("What is an item that you ordered?");
            item = scan.nextLine();
            System.out.println("How much money did " + item + " cost?");
        }
    }
}