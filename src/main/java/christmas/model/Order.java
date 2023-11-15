package christmas.model;

import christmas.constant.ErrorMessage;
import christmas.enums.MenuItem;

public class Order {
    private final MenuItem menuItem;
    private final int orderCount;


    public Order(String menuName, int orderCount) {
        validate(menuName, orderCount);

        this.menuItem = MenuItem.findByName(menuName);
        this.orderCount = orderCount;
    }


    private void validate(String menuItem, int orderCount) {
        validateMenuItemExists(menuItem);
        validateOrderCount(orderCount);
    }

    private void validateMenuItemExists(String menuName) {
        try {
            MenuItem.findByName(menuName);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_INVALID_ERROR_MESSAGE);
        }
    }

    private void validateOrderCount(int orderCount) {
        if (orderCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_INVALID_ERROR_MESSAGE);
        }
    }


    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
