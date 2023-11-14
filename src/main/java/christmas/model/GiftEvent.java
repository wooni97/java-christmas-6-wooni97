package christmas.model;

import java.time.LocalDate;

public class GiftEvent extends Event{

    public static final String EVENT_NAME = "증정 이벤트";
    private static final int GIFT_EVENT_CRITERIA_AMOUNT = 120000;
    private static final MenuItem GIFT = MenuItem.샴페인;

    public GiftEvent(LocalDate orderDate, Orders orders) {
        super(orderDate, orders);
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
