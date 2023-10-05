import java.math.BigDecimal; // Imports the class BigDecimal from the java.math package
import java.util.ArrayList; // Imports the class ArrayList from the java.util package
import java.util.List; // Imports the class List from the java.util package
import java.util.Scanner; // Imports the class Scanner from the java.util package

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!"); // Welcomes the user
        System.out.print("How many people are in your group: "); // Asks for the number of guests
        int people = scan.nextInt(); // Records the number of guests
        scan.nextLine();
        System.out.print("What's the tip percentage? (0-100): "); // Asks for the tip percentage
        int percentage = scan.nextInt(); // Records the tip percentage
        scan.nextLine();
        String item;
        List<String> Items = new ArrayList<>();

        double subtotal = 0;
        while (true) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): "); // Asks for the cost of an item ordered
            double cost = scan.nextDouble(); // Records the cost of an item ordered
            if (cost == -1) {
                break; // Stops the program from asking for the cost and name of items when the user enters -1 as the cost of an item
            }
            subtotal += cost; // Adds the cost of each item ordered to the subtotal
            scan.nextLine();
            System.out.print("Enter the item: "); // Asks for the name of an item
            item = scan.nextLine(); // Records the name of an item ordered
            Items.add(item); // Adds the name of each item ordered to a list
        }

        // Ensures that the printed subtotal follows the syntax for U.S. dollars - $X.XX
        int totalNoTipVariable = (int) (Math.round(subtotal * 100));
        BigDecimal subtotalBD = BigDecimal.valueOf(totalNoTipVariable);
        subtotalBD = subtotalBD.movePointLeft(2);
        subtotal = subtotalBD.doubleValue();

        // Ensures that the printed tip follows the syntax for U.S. dollars (USD) - $X.XX
        BigDecimal tipBD = BigDecimal.valueOf(Math.round((double) percentage / 100 * subtotal * 100));
        tipBD = tipBD.movePointLeft(2);
        double totalTipDouble = tipBD.doubleValue();

        // Combines the subtotal and the tip to create the total
        BigDecimal totalWithTipBD  = subtotalBD.add(tipBD);
        double totalWithTip = totalWithTipBD.doubleValue();

        // Ensures that the printed per-person subtotal follows the syntax for U.S. dollars (USD) - $X.XX
        BigDecimal perPersonCostNoTip = BigDecimal.valueOf((Math.round(subtotal / people * 100)));
        perPersonCostNoTip = perPersonCostNoTip.movePointLeft(2);

        // Ensures that the printed per-person tip follows the syntax for U.S. dollars (USD) - $X.XX
        BigDecimal tipPerPersonBD = BigDecimal.valueOf(Math.round(totalTipDouble / people * 100));
        tipPerPersonBD = tipPerPersonBD.movePointLeft(2);

        // Ensures that the printed per-person total follows the syntax for U.S. dollars (USD) - $X.XX
        BigDecimal totalCostPerPerson = BigDecimal.valueOf(Math.round(totalWithTip / people * 100));
        totalCostPerPerson = totalCostPerPerson.movePointLeft(2);

        // Converts the total from U.S. dollars (USD) to Aruban florin (AWG)
        final double FLORIN_PER_DOLLAR = 1.80;
        BigDecimal totalWithTipFlorin = BigDecimal.valueOf(Math.round(totalWithTip * FLORIN_PER_DOLLAR * 100));
        totalWithTipFlorin = totalWithTipFlorin.movePointLeft(2);

        System.out.println("-------------------------------");
        System.out.println("Total bill before tip: $" + subtotalBD); // Prints the subtotal in U.S. dollars (USD)
        System.out.println("Total percentage: " + percentage + "%"); // Prints the tip percentage in U.S. dollars (USD)
        System.out.println("Total tip: $" + tipBD); // Prints the tip in U.S. dollars (USD)
        System.out.println("Total bill with tip: $" + totalWithTip); // Prints the total in U.S. dollars (USD)
        System.out.println("Per person cost before tip: $" + perPersonCostNoTip); // Prints the per-person subtotal in U.S. dollars (USD)
        System.out.println("Tip per person: $" + tipPerPersonBD); // Prints the per-person tip in U.S. dollars (USD)
        System.out.println("Total cost per person: $" + totalCostPerPerson); // Prints the per-person total in U.S. dollars (USD)
        System.out.println("-------------------------------");
        System.out.println("Items ordered:");

        for (String s : Items) {
            System.out.println(s); // Prints the names of the items ordered by the user
        }

        System.out.println("-------------------------------");
        System.out.print("Total bill with tip (Aruban florin): " + totalWithTipFlorin + " AWG"); // Prints the total in Aruban florin (AWG)
    }
}