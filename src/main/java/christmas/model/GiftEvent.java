package christmas.model;


import christmas.enums.MenuItem;

public class GiftEvent implements Event{

    public static final String EVENT_NAME = "증정 이벤트";
    private static final int GIFT_EVENT_CRITERIA_AMOUNT = 120000;
    private static final MenuItem GIFT = MenuItem.샴페인;

    private final Orders orders;

    public GiftEvent(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int calculateDiscount() {
        if (isEventActive()) {
            return GIFT.getPrice();
        }

        return 0;
    }

    @Override
    public boolean isEventActive() {
        return orders.getTotalPrice() >= GIFT_EVENT_CRITERIA_AMOUNT;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }
}
