package christmas.service;

import christmas.dto.OrderDtos;
import christmas.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventPlannerService {

    public Orders makeOrders(OrderDtos orderDtos) {
        List<Order> orders = new ArrayList<>();

        orderDtos.forEach(orderDto -> {
            String menuName = orderDto.getMenuName();
            int orderCount = orderDto.getOrderCount();

            orders.add(new Order(menuName, orderCount));
        });

        return new Orders(orders);
    }

    public Events makeEvents(VisitDate visitDate, Orders orders) {
        return new Events(visitDate.getVisitDate(), orders);
    }

    public Boolean isGiftEventActivated(Events events) {
        return events.stream()
                .anyMatch(event -> event instanceof GiftEvent && event.isEventActive());

    }

    public int calculateTotalAmountAfterDiscount(Orders orders, Events events) {
        return orders.getTotalPrice() - events.getTotalDiscountAmount();
    }

    public EventBadge getEventBadge(Events events) {
        return new EventBadge(events);
    }
}
