package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class WeekdayEventTest {

    @DisplayName("평일 할인 적용될 시 할인 금액 테스트")
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

    @DisplayName("평일 할인 적용일이 아닐 시 할인 금액 테스트")
    @Test
    void weekDayEventDiscountCalculateTestWhenNotWeekDay() {

        //given
        Order order1 = new Order("양송이수프", 5);
        Order order2 = new Order("초코케이크", 2);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        LocalDate orderDate = LocalDate.of(2023,12,1);

        //when
        WeekdayEvent weekDayEvent = new WeekdayEvent(orderDate, orders);

        //then
        assertFalse(weekDayEvent.isEventActive());
        assertEquals(0, weekDayEvent.calculateDiscount());
    }

    @DisplayName("평일 할인 적용일이지만 할인 메뉴 주문 하지 않을 시 할인 금액 테스트")
    @Test
    void weekDayEventDiscountCalculateTestWithNoEventMenu() {

        //given
        Order order = new Order("양송이수프", 5);

        Orders orders = new Orders(List.of(order));

        LocalDate orderDate = LocalDate.of(2023,12,5);

        //when
        WeekdayEvent weekDayEvent = new WeekdayEvent(orderDate, orders);

        //then
        assertTrue(weekDayEvent.isEventActive());
        assertEquals(0, weekDayEvent.calculateDiscount());
    }
}