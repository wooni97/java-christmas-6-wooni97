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
        LocalDate orderDate = LocalDate.of(2023,12,3);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate);

        //then
        assertEquals(1000, specialEvent.calculateDiscount());
    }

    @DisplayName("")
    @Test
    void notSpecialDayDiscountCalculateTest() {
        //given
        LocalDate orderDate = LocalDate.of(2023,12,11);

        //when
        SpecialEvent specialEvent = new SpecialEvent(orderDate);

        //then
        assertEquals(0, specialEvent.calculateDiscount());
    }

}