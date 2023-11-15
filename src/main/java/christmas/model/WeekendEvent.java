package christmas.model;

import christmas.enums.MenuCategory;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class WeekendEvent implements Event {

    public static final String EVENT_NAME = "주말 할인";
    private static final int DISCOUNT_AMOUNT_PER_MENU = 2023;

    private final LocalDate visitDate;
    private final Orders orders;

    public WeekendEvent(LocalDate visitDate, Orders orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    @Override
    public int calculateDiscount() {
        if (isEventActive()) {
            return orders.stream()
                    .filter(order -> order.getMenuItem().getMenuCategory().equals(MenuCategory.MAIN_DISH))
                    .mapToInt(order -> order.getOrderCount() * DISCOUNT_AMOUNT_PER_MENU)
                    .sum();
        }

        return 0;
    }

    @Override
    public boolean isEventActive() {
        return Weekend.isWeekEnd(visitDate.getDayOfWeek());
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    enum Weekend {
        FRIDAY(DayOfWeek.FRIDAY),
        SATURDAY(DayOfWeek.SATURDAY);

        private final DayOfWeek dayOfWeek;

        Weekend(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public static boolean isWeekEnd(DayOfWeek dayOfWeek) {
            return Arrays.stream(Weekend.values())
                    .anyMatch(weekend -> weekend.dayOfWeek.equals(dayOfWeek));
        }
    }
}
