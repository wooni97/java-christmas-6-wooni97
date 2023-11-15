package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class WeekendEventTest {

    @DisplayName("주말 할인 적용될 시 할인 금액 테스트")
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
        assertTrue(weekendEvent.isEventActive());
        assertEquals(4046, weekendEvent.calculateDiscount());

    }

    @DisplayName("주말 할인 적용일이 아닐 시 할인 금액 테스트")
    @Test
    void weekEndEventDiscountCalculateTestWhenNotWeekend() {

        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("티본스테이크", 2);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,7);

        //when
        WeekendEvent weekendEvent = new WeekendEvent(orderDate, orders);

        //then
        assertFalse(weekendEvent.isEventActive());
        assertEquals(0, weekendEvent.calculateDiscount());

    }

    @DisplayName("주말 할인 적용일이지만 할인 품목 주문하지 않을 시 할인 금액 테스트")
    @Test
    void weekEndEventDiscountCalculateTestWithNoEventMenu() {

        //given
        Order order = new Order("양송이수프", 5);

        Orders orders = new Orders(List.of(order));

        LocalDate orderDate = LocalDate.of(2023,12,2);

        //when
        WeekendEvent weekendEvent = new WeekendEvent(orderDate, orders);

        //then
        assertTrue(weekendEvent.isEventActive());
        assertEquals(0, weekendEvent.calculateDiscount());

    }

}