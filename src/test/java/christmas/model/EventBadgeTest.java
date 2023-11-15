package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import christmas.enums.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

class EventBadgeTest {

    @DisplayName("총 혜택 금액이 20000원이 넘을 시 산타 배지")
    @Test
    void eventBadgeTest() {

        //given
        LocalDate visitDate = LocalDate.of(2023, 12, 3);

        Order order1 = new Order("티본스테이크", 1);
        Order order2 = new Order("바비큐립", 1);
        Order order3 = new Order("초코케이크", 2);
        Order order4 = new Order("제로콜라", 1);

        Orders orders = new Orders(List.of(order1, order2, order3, order4));

        Events events = new Events(visitDate, orders);

        //when
        EventBadge eventBadge = new EventBadge(events);

        //then
        assertTrue(events.getTotalBenefitAmount() >= 20000);
        assertEquals(Badge.SANTA, eventBadge.getBadge());
    }

}