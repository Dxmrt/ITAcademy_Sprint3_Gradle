package N2.PaymentMethods;

public class PaymentGateway {

    public static void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}

