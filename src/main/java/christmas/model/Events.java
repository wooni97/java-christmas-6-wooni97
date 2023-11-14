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

        initializeEvents(orderDate, orders);
    }

    private void initializeEvents(LocalDate orderDate, Orders orders) {
        events.add(new ChristmasEvent(orderDate, orders));
        events.add(new WeekdayEvent(orderDate, orders));
        events.add(new WeekendEvent(orderDate, orders));
        events.add(new SpecialEvent(orderDate, orders));
        events.add(new GiftEvent(orderDate, orders));
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
