import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        //initiate transfer after prompting user for input
        if (args[0].equals("transfer")) {
            String amt = args[1];
            System.out.print("You just initiated a transfer\nPlease enter a bank out of the following that you wish to transfer " + args[1] + " to:\naccess\ngtb\npos\n Here: ");
            Scanner userInput = new Scanner(System.in);
            String bank = userInput.nextLine();
            System.out.println(calculateServiceFee(bank,amt));
        }
        else
            System.out.println("Invalid action");
    }

    //Class to calculate the cost based on the bank put by the user
    public static String calculateServiceFee(String bank, String amt){
        double money = Double.parseDouble(amt);
        double serviceFee = switch (bank) { //This is the cost here
            case "access" -> 0.03 * money;
            case "gtb" -> 0.05 * money;
            case "pos" -> 0.1 * money;
            default -> 0.0d;
        };
        double amountToPay = serviceFee + money; // Total Cost of transferring = Fee + AmountToBeSent
        return "The total cost is " + amountToPay;
    }
}