package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.enums.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class OrdersTest {

    @DisplayName("중복된 메뉴가 있으면 예외 처리")
    @Test
    void invalidOrdersWithDuplicatedMenusTest() {

        //given
        Order order1 = new Order("양송이수프", 2);
        Order order2 = new Order("타파스", 1);
        Order order3 = new Order("양송이수프", 1);

        List<Order> orders = Arrays.asList(order1, order2, order3);

        //when, then
        assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("총 주문 갯수가 20개가 넘으면 예외 처리")
    @Test
    void invalidTotalOrderCountLimitTest() {

        //given
        Order order1 = new Order("양송이수프", 15);
        Order order2 = new Order("타파스", 5);
        Order order3 = new Order("초코케이크", 1);

        List<Order> orders = Arrays.asList(order1, order2, order3);

        //when, then
        assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("음료만 주문시 예외 처리")
    @Test
    void invalidWithOnlyBeverageOrder() {

        //given
        Order order1 = new Order("제로콜라", 5);
        Order order2 = new Order("레드와인", 5);

        List<Order> orders = Arrays.asList(order1, order2);

        //when, then
        assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 주문일 시 아무런 예외를 반환하지 않는다")
    @Test
    void validOrderTest() {

        //given
        Order order1 = new Order("양송이수프", 2);
        Order order2 = new Order("크리스마스파스타", 2);
        Order order3 = new Order("초코케이크", 1);

        List<Order> orders = Arrays.asList(order1, order2, order3);

        //when, then
        assertDoesNotThrow(() -> new Orders(orders));
    }

    @DisplayName("총 주문 금액 테스트")
    @Test
    void calulateTotalPriceTest() {

        //given
        Order order1 = new Order("양송이수프", 2);
        Order order2 = new Order("크리스마스파스타", 2);
        Order order3 = new Order("초코케이크", 1);

        //when
        Orders orders = new Orders(Arrays.asList(order1, order2, order3));

        //then
        int actualAmount = MenuItem.양송이수프.getPrice() * 2 + MenuItem.크리스마스파스타.getPrice() * 2 + MenuItem.초코케이크.getPrice();
        assertEquals(actualAmount, orders.getTotalPrice());
    }

}