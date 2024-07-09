package N2.ShoeStore;


import N2.PaymentMethods.BankAccount;
import N2.PaymentMethods.Card;
import N2.PaymentMethods.PaymentGateway;
import N2.PaymentMethods.Paypal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SneakerShop {
    private final String name;
    private final List<Sneakers> sneakersList;

    public SneakerShop() {
        this.name = "Default Name";
        this.sneakersList = new ArrayList<>();
        this.sneakersList.add(new Sneakers("Nike", "Air Max", 42, 150.0, 5));
        this.sneakersList.add(new Sneakers("Adidas", "Ultra Boost", 43, 200.0, 3));
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        PaymentGateway paymentGateway = new PaymentGateway();
        BankAccount bankAccount = new BankAccount("Usuario", "000000000", 1000.0);
        Card card = new Card("0000 0000 0000 0000", "01/24", "000");
        Paypal paypal = new Paypal("example@example.com");

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
                    System.out.print("Enter sneaker number to buy: ");
                    int sneakerNumber = scanner.nextInt();
                    System.out.println("Choose payment method: 1. Card 2. Paypal 3. Bank Account");
                    int paymentMethod = scanner.nextInt();

                    if (sneakerNumber > 0 && sneakerNumber <= sneakersList.size()) {
                        Sneakers selectedSneaker = sneakersList.get(sneakerNumber - 1);
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
                    break;
                case 3:
                    System.out.println("Thank you for visiting the Sneaker Shop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void showSneakers() {
        System.out.println("\nAvailable Sneakers:");
        for (int i = 0; i < sneakersList.size(); i++) {
            System.out.println((i + 1) + ". " + sneakersList.get(i));
        }
    }
}
