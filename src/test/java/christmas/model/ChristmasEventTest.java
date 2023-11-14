package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;

class ChristmasEventTest {
    @DisplayName("할인 가격 테스트")
    @Test
    void discountCalculateTestWhenEventConditionsSatisfied() {
        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("레드와인", 5);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,10);

        //when
        ChristmasEvent christmasEvent = new ChristmasEvent(orderDate, orders);

        //then
        assertEquals(1900, christmasEvent.calculateDiscount());

    }
}