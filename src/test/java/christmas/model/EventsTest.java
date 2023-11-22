package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

class EventsTest {

    @DisplayName("총 주문 금액이 기준 미달일 시 이벤트 적용 되지 않는다")
    @Test
    void eventApplicapableTest() {

        //given
        LocalDate visitDate = LocalDate.of(2023, 12, 26);

        Order order1= new Order("제로콜라", 1);
        Order order2 = new Order("타파스", 1);

        Orders orders = new Orders(List.of(order1, order2));

        //when
        Events events = new Events(visitDate, orders);

        //then
        assertEquals(0, events.getAppliedEventAndDiscount().size());
    }

    @DisplayName("이벤트 총 할인 금액 테스트")
    @Test
    void eventCalculateDiscountAmountTest() {

        //given
        LocalDate visitDate = LocalDate.of(2023, 12, 3);

        Order order1 = new Order("티본스테이크", 1);
        Order order2 = new Order("바비큐립", 1);
        Order order3 = new Order("초코케이크", 2);
        Order order4 = new Order("제로콜라", 1);

        Orders orders = new Orders(List.of(order1, order2, order3, order4));

        //when
        Events events = new Events(visitDate, orders);

        //then
        assertEquals(6246, events.getTotalDiscountAmount());
    }

    @DisplayName("이벤트 총 할인 금액 테스트")
    @Test
    void eventCalculateBenfitAmountTest() {

        //given
        LocalDate visitDate = LocalDate.of(2023, 12, 3);

        Order order1 = new Order("티본스테이크", 1);
        Order order2 = new Order("바비큐립", 1);
        Order order3 = new Order("초코케이크", 2);
        Order order4 = new Order("제로콜라", 1);

        Orders orders = new Orders(List.of(order1, order2, order3, order4));

        //when
        Events events = new Events(visitDate, orders);

        //then
        assertEquals(31246, events.getTotalBenefitAmount());
    }
}