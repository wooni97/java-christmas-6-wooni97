package christmas.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasEvent extends Event{
    public static final String EVENT_NAME = "크리스마스 디데이 할인";
    private static final int STARTING_AMOUNT = 1000;
    private static final int DAILY_INCREASE = 100;
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12,25);

    public ChristmasEvent(LocalDate orderDate, Orders orders) {
        super(orderDate, orders);
    }

    @Override
    public int calculateDiscount() {
        if (isEventActive()) {
            int daysDifference = (int) ChronoUnit.DAYS.between(START_DATE, this.orderDate);
            return STARTING_AMOUNT + (daysDifference) * DAILY_INCREASE;
        }

        return 0;
    }

    @Override
    public boolean isEventActive() {
        return END_DATE.isAfter(this.orderDate);
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }


}
