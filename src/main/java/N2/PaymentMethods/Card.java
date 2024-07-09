package N2.PaymentMethods;


public class Card implements PaymentMethod {

    private final String cardNumber;

    public Card(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double price) {
        System.out.println("Payment of " + price + " made with Card number: " + cardNumber);
    }
}

