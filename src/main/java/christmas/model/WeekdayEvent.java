package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class WeekdayEvent extends Event{

    public static final String EVENT_NAME = "평일 할인";
    private static final int DISCOUNT_AMOUNT_PER_MENU = 2023;

    public WeekdayEvent(LocalDate orderDate, Orders orders) {
        super(orderDate, orders);
    }

    @Override
    public int calculateDiscount() {
        if (isEventActive()) {
            return orders.stream()
                    .filter(order -> order.getMenuItem().getMenuCategory().equals(MenuCategory.DESSERT))
                    .mapToInt(order -> order.getOrderCount() * DISCOUNT_AMOUNT_PER_MENU)
                    .sum();
        }

        return 0;
    }

    @Override
    public boolean isEventActive() {
        return Weekday.isWeekday(orderDate.getDayOfWeek());
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    enum Weekday {
        SUNDAY(DayOfWeek.SUNDAY),
        MONDAY(DayOfWeek.MONDAY),
        TUESDAY(DayOfWeek.TUESDAY),
        WEDNESDAY(DayOfWeek.WEDNESDAY),
        THURSDAY(DayOfWeek.THURSDAY);

        private final DayOfWeek dayOfWeek;

        Weekday(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public static boolean isWeekday(DayOfWeek dayOfWeek) {
            return Arrays.stream(Weekday.values())
                    .anyMatch(weekday -> weekday.dayOfWeek.equals(dayOfWeek));
        }

    }
}
