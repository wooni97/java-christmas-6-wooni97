package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ChristmasEventTest {
    
    @DisplayName("할인 적용 가능 날짜일 시 할인 가격 테스트")
    @Test
    void calculateDiscountWhenEventConditionSatisfied() {
        //given
        LocalDate orderDate = LocalDate.of(2023,12,10);

        //when
        ChristmasEvent christmasEvent = new ChristmasEvent(orderDate);

        //then
        assertEquals(1900, christmasEvent.calculateDiscount());
    }

    @DisplayName("할인 적용 가능 날짜가 아닐 시 할인 가격 0원 테스트")
    @Test
    void calculateDiscountWhenEventConditionNotSatisfied() {
        //given
        LocalDate orderDate = LocalDate.of(2023,12,27);

        //when
        ChristmasEvent christmasEvent = new ChristmasEvent(orderDate);

        //then
        assertEquals(0, christmasEvent.calculateDiscount());
    }

    @DisplayName("할인 적용 가능 날짜일 시 할인 적용이 true")
    @Test
    void eventActiveWhenEventConditionSatisfied() {
        //given
        LocalDate orderDate = LocalDate.of(2023,12,3);

        //when
        ChristmasEvent christmasEvent = new ChristmasEvent(orderDate);

        //then
        assertTrue(christmasEvent.isEventActive());
    }

    @DisplayName("할인 적용 가능 날짜가 아나면 할인 적용이 false")
    @Test
    void eventNotActiveWhenEventConditionNotSatisfied() {
        //given
        LocalDate orderDate = LocalDate.of(2023,12,28);

        //when
        ChristmasEvent christmasEvent = new ChristmasEvent(orderDate);

        //then
        assertFalse(christmasEvent.isEventActive());
    }

    @DisplayName("이벤트명 크리스마스 디데이 할인으로 일치한다")
    @Test
    void eventNameTest() {
        //given
        LocalDate orderDate = LocalDate.of(2023,12,3);

        //when
        ChristmasEvent christmasEvent = new ChristmasEvent(orderDate);

        //then
        assertEquals("크리스마스 디데이 할인", christmasEvent.getEventName());
    }
}