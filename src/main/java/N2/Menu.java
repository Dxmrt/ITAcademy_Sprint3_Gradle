package N2;

import N2.PaymentMethods.BankAccount;
import N2.PaymentMethods.Card;
import N2.PaymentMethods.Paypal;
import N2.PaymentMethods.PaymentGateway;
import N2.ShoeStore.SneakerShop;
import N2.ShoeStore.Sneakers;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final BankAccount bankAccount = new BankAccount("Usuario", "000000000", 1000.0);
    private final Card card = new Card("0000 0000 0000 0000", "01/24", "000");
    private final Paypal paypal = new Paypal("example@example.com");
    private final SneakerShop sneakerShop = new SneakerShop();

    public void showMenu() {
        while (true) {
            System.out.println("\nWelcome to the Sneaker Shop!");
            System.out.println("1. Show Sneakers");
            System.out.println("2. Buy Sneaker");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    showSneakers();
                    break;
                case 2:
                    buySneaker();
                    break;
                case 3:
                    System.out.println("Thank you for visiting the Sneaker Shop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showSneakers() {
        System.out.println("\nAvailable Sneakers:");
        for (int i = 0; i < sneakerShop.getSneakersList().size(); i++) {
            Sneakers sneaker = sneakerShop.getSneakersList().get(i);
            System.out.println((i + 1) + ". " + sneaker.getName() + " - $" + sneaker.getPrice() + " - Stock: " + sneaker.getStock());
        }
    }

    private void buySneaker() {
        System.out.print("Enter sneaker number to buy: ");
        int sneakerNumber = scanner.nextInt();
        System.out.println("Choose payment method: 1. Card 2. Paypal 3. Bank Account");
        int paymentMethod = scanner.nextInt();

        if (sneakerNumber > 0 && sneakerNumber <= sneakerShop.getSneakersList().size()) {
            Sneakers selectedSneaker = sneakerShop.getSneakersList().get(sneakerNumber - 1);
            if (paymentMethod == 1) {
                PaymentGateway.processPayment(card, selectedSneaker.getPrice());
            } else if (paymentMethod == 2) {
                PaymentGateway.processPayment(paypal, selectedSneaker.getPrice());
            } else if (paymentMethod == 3) {
                PaymentGateway.processPayment(bankAccount, selectedSneaker.getPrice());
            } else {
                System.out.println("Invalid payment method.");
            }
            selectedSneaker.setStock(selectedSneaker.getStock() - 1);
            System.out.println("Sneaker purchased successfully. New stock: " + selectedSneaker.getStock());
        } else {
            System.out.println("Invalid sneaker number.");
        }
    }
}
