package christmas.model;

public class Order {
    private final MenuItem menuItem;
    private final int orderCount;


    public Order(String menuName, int orderCount) {
        validate(menuName, orderCount);

        this.menuItem = validateMenuItemExists(menuName);
        this.orderCount = orderCount;
    }


    private void validate(String menuItem, int orderCount) {
        validateMenuItemExists(menuItem);
        validateOrderCount(orderCount);
    }

    private MenuItem validateMenuItemExists(String menuName) {
        try {
            return MenuItem.findByName(menuName);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOrderCount(int orderCount) {
        if (orderCount < 1) {
            throw new IllegalArgumentException();
        }
    }


    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
