package christmas.model;

import java.time.LocalDate;
import java.util.Arrays;

public class SpecialEvent extends Event {

    public static final String EVENT_NAME = "특별 할인";
    private static final int DISCOUNT_AMOUNT = 1000;

    public SpecialEvent(LocalDate orderDate, Orders orders) {
        super(orderDate, orders);
    }

    @Override
    public int calculateDiscount() {
        if (isEventActive()) {
            return DISCOUNT_AMOUNT;
        }

        return 0;
    }

    @Override
    public boolean isEventActive() {
        return SpecialDay.isSpecialDay(orderDate.getDayOfMonth());
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    enum SpecialDay {
        DAY_3(3),
        DAY_10(10),
        DAY_17(17),
        DAY_24(24),
        DAY_25(25),
        DAY_31(31);

        private final int day;

        SpecialDay(int day) {
            this.day = day;
        }

        public static boolean isSpecialDay(int day) {
            return Arrays.stream(SpecialDay.values())
                    .anyMatch(specialDay -> specialDay.day == day);

        }

    }
}
