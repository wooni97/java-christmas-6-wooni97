package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class SpecialEventTest {

    @DisplayName("특별 할인 날이면 할인 금액이 1000원과 일치한다")
    @Test
    void specialDayEventDiscountCalculateTest() {

        //given
        LocalDate orderDate = LocalDate.of(2023,12,3);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate);

        //then
        assertEquals(1000, specialEvent.calculateDiscount());
    }

    @DisplayName("특별 할인 날이 아니면 할인 금액이 0원과 일치한다")
    @Test
    void notSpecialDayDiscountCalculateTest() {

        //given
        LocalDate orderDate = LocalDate.of(2023,12,11);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate);

        //then
        assertEquals(0, specialEvent.calculateDiscount());
    }

    @DisplayName("특별 할인 날이면 이벤트 적용 true")
    @Test
    void specialDayEventActiveTest() {

        //given
        LocalDate orderDate = LocalDate.of(2023,12,3);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate);

        //then
        assertTrue(specialEvent.isEventActive());
    }

    @DisplayName("특별 할인 날이 아니면 이벤트 적용 false")
    @Test
    void notSpecialDayEventActiveTest() {

        //given
        LocalDate orderDate = LocalDate.of(2023,12,4);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate);

        //then
        assertFalse(specialEvent.isEventActive());
    }

}