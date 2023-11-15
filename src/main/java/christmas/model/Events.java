package christmas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events {

    private final List<Event> events;

    public Events(LocalDate orderDate, Orders orders) {
        this.events = new ArrayList<>();

        if (isEventApplicable(orders)) {
            initializeEvents(visitDate, orders);
        }
    }

    private boolean isEventApplicable(Orders orders) {
        return orders.getTotalPrice() >= EVENT_APPLICABLE_MINIMUM_AMOUNT;
    }
    private void initializeEvents(LocalDate visitDate, Orders orders) {
        events.add(new ChristmasEvent(visitDate));
        events.add(new WeekdayEvent(visitDate, orders));
        events.add(new WeekendEvent(visitDate, orders));
        events.add(new SpecialEvent(visitDate));
        events.add(new GiftEvent(orders));
    }

    public Map<String, Integer> getAppliedDiscounts() {
        Map<String, Integer> appliedDiscounts = new HashMap<>();

        events.stream().filter(Event::isEventActive)
                .forEach(event -> {
                    appliedDiscounts.put(event.getEventName(), event.calculateDiscount());
                });

        return appliedDiscounts;
    }

    public int getTotalDiscountAmount() {
        return events.stream()
                .filter(Event::isEventActive)
                .mapToInt(Event::calculateDiscount)
                .sum();
    }
}
