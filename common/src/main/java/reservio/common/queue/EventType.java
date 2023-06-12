package reservio.common.queue;

public enum EventType {
    USER_CREATED,
    USER_ACTIVATED,
    USER_DELETED,
    ACCOUNT_CREATED,
    ACCOUNT_SUSPENDED,
    ACCOUNT_ACTIVATED,
    SUBSCRIPTION_CREATED,
    SUBSCRIPTION_ACTIVATED,
    SUBSCRIPTION_DEACTIVATED,
    SUBSCRIPTION_CANCELLED,
    ORDER_CREATED,
    ORDER_COMPLETED
}