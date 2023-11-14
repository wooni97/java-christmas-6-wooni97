package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;

class WeekdayEventTest {
    @DisplayName("")
    @Test
    void weekDayEventDiscountCalculateTest() {
        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("초코케이크", 2);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,5);

        //when
        WeekdayEvent weekDayEvent = new WeekdayEvent(orderDate, orders);

        //then
        assertEquals(4046, weekDayEvent.calculateDiscount());
    }
}