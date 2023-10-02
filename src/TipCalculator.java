import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int people = scan.nextInt();
        scan.nextLine();
        System.out.print("What's the tip percentage? (0-100): ");
        int percentage = scan.nextInt();
        scan.nextLine();
        double cost;
        double totalNoTip = 0;
        String item;
        List<String> Items = new ArrayList<>();
        while (true) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
            if (cost == -1) {
                break;
            }
            totalNoTip += cost;
            scan.nextLine();
            System.out.print("Enter the item: ");
            item = scan.nextLine();
            Items.add(item);
        }

        BigDecimal totalTipBD = BigDecimal.valueOf(Math.round((double) percentage / 100 * totalNoTip * 100));
        totalTipBD = totalTipBD.movePointLeft( 2);
        BigDecimal perPersonCostNoTipBD = BigDecimal.valueOf((Math.round(totalNoTip / people * 100)));
        perPersonCostNoTipBD = perPersonCostNoTipBD.movePointLeft(2);
        double totalTipDouble = totalTipBD.doubleValue();
        double totalWithTip = totalNoTip + totalTipDouble;
        final double FLORIN_PER_DOLLAR = 1.80;
        System.out.println("-------------------------------");
        System.out.println("Total bill before tip: $" + totalNoTip);
        System.out.println("Total percentage: " + percentage + "%");
        System.out.println("Total tip: $" + totalTipBD);
        System.out.println("Total bill with tip: $" + (totalWithTip));
        System.out.println("Per person cost before tip:  $" + perPersonCostNoTipBD);
        System.out.println("Tip per person: $" + totalTipDouble / people);
        System.out.println("Total cost per person: $" + totalWithTip / people);
        System.out.println("-------------------------------");
        System.out.println("Items ordered:");
        for (String s : Items) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        System.out.print("Total bill with tip (Aruban florin): " + totalWithTip * FLORIN_PER_DOLLAR + " AWG");
    }
}