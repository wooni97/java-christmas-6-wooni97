package christmas.model;

public interface Event {
    int calculateDiscount();
    boolean isEventActive();
    String getEventName();
}
