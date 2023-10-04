import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!"); // Welcomes the user.
        System.out.print("How many people are in your group: "); // Asks for the number of guests.
        int people = scan.nextInt();
        scan.nextLine();
        System.out.print("What's the tip percentage? (0-100): "); // Asks for the tip percentage.
        int percentage = scan.nextInt();
        scan.nextLine();
        double cost;
        double totalNoTip = 0;
        String item;
        List<String> Items = new ArrayList<>();

        while (true) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): "); // Asks for a cost in dollars and cents.
            cost = scan.nextDouble();
            if (cost == -1) {
                break;
            }
            totalNoTip += cost;
            scan.nextLine();
            System.out.print("Enter the item: "); // Asks for the name of an item.
            item = scan.nextLine();
            Items.add(item);
        }

        int totalNoTipVariable = (int)(totalNoTip * 100);
        BigDecimal totalNoTipBD = BigDecimal.valueOf(totalNoTipVariable); // 3300
        totalNoTipBD = totalNoTipBD.movePointLeft(2);
        totalNoTip = totalNoTipBD.doubleValue();
        BigDecimal perPersonCostNoTip = BigDecimal.valueOf((Math.round(totalNoTip / people * 100)));
        perPersonCostNoTip = perPersonCostNoTip.movePointLeft(2);
        BigDecimal totalTipBD = BigDecimal.valueOf(Math.round((double) percentage / 100 * totalNoTip * 100));
        totalTipBD = totalTipBD.movePointLeft( 2);
        double totalTipDouble = totalTipBD.doubleValue();
        double totalWithTip = totalNoTip + totalTipDouble;
        final double FLORIN_PER_DOLLAR = 1.80;
        BigDecimal tipPerPersonBD = BigDecimal.valueOf(Math.round(totalTipDouble / people * 100));
        tipPerPersonBD = tipPerPersonBD.movePointLeft(2);
        BigDecimal totalCostPerPerson = BigDecimal.valueOf(Math.round(totalWithTip / people * 100));
        totalCostPerPerson = totalCostPerPerson.movePointLeft(2);
        BigDecimal totalWithTipFlorin = BigDecimal.valueOf(Math.round(totalWithTip * FLORIN_PER_DOLLAR * 100));
        totalWithTipFlorin = totalWithTipFlorin.movePointLeft(2);

        System.out.println("-------------------------------");
        System.out.println("Total bill before tip: $" + totalNoTipBD); // Reports the total cost without the tip.
        System.out.println("Total percentage: " + percentage + "%"); // Reports the input percentage.
        System.out.println("Total tip: $" + totalTipBD); // Reports the tip amount.
        System.out.println("Total bill with tip: $" + totalWithTip); // Reports the total cost with the tip.
        System.out.println("Per person cost before tip: $" + perPersonCostNoTip); // Reports the per-person cost without the tip.
        System.out.println("Tip per person: $" + tipPerPersonBD); // Reports the portion of the tip that each person should pay.
        System.out.println("Total cost per person: $" + totalCostPerPerson); // Reports the per-person cost with the tip.
        System.out.println("-------------------------------");
        System.out.println("Items ordered:");

        for (String s : Items) {
            System.out.println(s);
        }

        System.out.println("-------------------------------");
        System.out.print("Total bill with tip (Aruban florin): " + totalWithTipFlorin + " AWG"); // Reports the total cost with the tip in Aruban florin.
    }
}