package N2.PaymentMethods;


public class Paypal implements PaymentMethod {

    private final String email;

    public Paypal(String email) {
        this.email = email;
    }

    @Override
    public void pay(double price) {
        System.out.println("Payment of " + price + " made via PayPal using email: " + email);
    }
}

