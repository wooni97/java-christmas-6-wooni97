package christmas.model;

import christmas.constant.ErrorMessage;
import christmas.enums.MenuCategory;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Orders implements Iterable<Order> {
    private static final int MAX_TOTAL_ORDER_COUNT = 20;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validate(orders);

        this.orders = new ArrayList<>(orders);
    }

    private void validate(List<Order> orders) {
        validateMenuNameNotDuplicated(orders);
        validateTotalOrderCountLimit(orders);
        validateNotOnlyBeverageOrder(orders);
    }

    private void validateMenuNameNotDuplicated(List<Order> orders) {
        Set<String> menuNames = new HashSet<>();

        orders.forEach(order -> {
            if (!menuNames.add(order.getMenuItem().name())) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_INVALID_ERROR_MESSAGE);
            }
        });
    }

    private void validateTotalOrderCountLimit(List<Order> orders){
        int totalOrderCount = orders.stream()
                .mapToInt(Order::getOrderCount)
                .sum();

        if (totalOrderCount > MAX_TOTAL_ORDER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_INVALID_ERROR_MESSAGE);
        }
    }

    private void validateNotOnlyBeverageOrder(List<Order> orders) {
        int beverageCount = (int) orders.stream()
                .filter(order -> order.getMenuItem().getMenuCategory().equals(MenuCategory.BEVERAGE))
                .count();

        if (beverageCount == orders.size()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_INVALID_ERROR_MESSAGE);
        }
    }

    public int getTotalPrice() {
        return orders.stream()
                .mapToInt(order -> order.getMenuItem().getPrice() * order.getOrderCount())
                .sum();
    }

    public Stream<Order> stream() {
        Spliterator<Order> spliterator = Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }


    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}
