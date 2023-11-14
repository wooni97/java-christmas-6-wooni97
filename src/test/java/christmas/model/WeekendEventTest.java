package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;

class WeekendEventTest {

    @DisplayName("")
    @Test
    void weekEndEventDiscountCalculateTest() {
        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("티본스테이크", 2);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,8);

        //when
        WeekendEvent weekendEvent = new WeekendEvent(orderDate, orders);

        //then
        assertEquals(4046, weekendEvent.calculateDiscount());

    }

}