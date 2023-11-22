package christmas.model;

import christmas.enums.MenuCategory;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class WeekdayEvent implements Event {

    public static final String EVENT_NAME = "평일 할인";
    private static final int DISCOUNT_AMOUNT_PER_MENU = 2023;

    private final LocalDate visitDate;
    private final Orders orders;

    public WeekdayEvent(LocalDate visitDate, Orders orders) {
        this.visitDate = visitDate;
        this.orders = orders;
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
        return Weekday.isWeekday(visitDate.getDayOfWeek());
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
