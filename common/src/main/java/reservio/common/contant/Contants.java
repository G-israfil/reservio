package reservio.common.contant;

public class Contants {
    public static class ErrorMessage {
        public static String USER_NOT_FOUND = "User not found. id: ";
        public static String PAYMENT_NOT_FOUND = "Payment not found. id: ";
        public static String PAYMENT_METHOD_NOT_FOUND = "Payment Method not found. id: ";
        public static String DEFAULT_PAYMENT_METHOD_NOT_FOUND = "Payment Method not found. id: ";
        public static String TABLE_NOT_FOUND = "Table not found. id: ";
        public static String ACCOUNT_NOT_FOUND = "Account not found. id: ";
        public static String PRODUCT_SPECIFICATION_NOT_FOUND = "Product Specification not found with id: ";
        public static String TOKEN_IS_NOT_VALID = "Token is not valid";
    }

    public static class ResponseMessage {
        public static String CANCELLED = "Entity successfully cancelled";
    }

    public static class PaymentMethod {
        public static String CASH = "Cash";
        public static String DEBIT_CARD = "Debit Card";
        public static String CREDIT_CARD = "Credit Card";
        public static String BANK_TRANSFER = "Bank Transfer";

        public static String DIGITAL_PAYMENT = "Digital Wallet";
        public static String MOBILE_PAYMENT = "Mobile Payment";
        public static String WIRE_TRANSFER = "Wire Transfer";
        public static String DEFAULT_METHOD = "DefaultMethod";
    }

    public static class CommonQueue{
        public static String EXCHANGE_NAME = "CommonExchange";
    }
}

