package christmas.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDtos implements Iterable<OrderDtos.OrderDto> {

    private final List<OrderDto> orderDtos;

    public OrderDtos(List<OrderDto> orderDtos) {
        this.orderDtos = new ArrayList<>(orderDtos);
    }

    @Override
    public Iterator<OrderDto> iterator() {
        return orderDtos.iterator();
    }

    public static class OrderDto {

        private final String menuName;
        private final int orderCount;

        public OrderDto(String menuName, int orderCount) {
            this.menuName = menuName;
            this.orderCount = orderCount;
        }

        public String getMenuName() {
            return menuName;
        }

        public int getOrderCount() {
            return orderCount;
        }
    }
}
