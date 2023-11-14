package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;

class SpecialEventTest {

    @DisplayName("")
    @Test
    void specialDayEventDiscountCalculateTest() {
        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("레드와인", 5);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,3);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate, orders);

        //then
        assertEquals(1000, specialEvent.calculateDiscount());
    }

    @DisplayName("")
    @Test
    void notSpecialDayDiscountCalculateTest() {
        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("레드와인", 5);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,11);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate, orders);

        //then
        assertEquals(0, specialEvent.calculateDiscount());
    }

}