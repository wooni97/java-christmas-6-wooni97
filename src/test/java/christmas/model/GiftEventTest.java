package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import christmas.enums.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class GiftEventTest {

    @DisplayName("총 주문 금액이 12만원 이상이면 혜택 금이 샴페인 가격과 일치한다")
    @Test
    void giftEventDiscountCalculateTestWhenConditonSatisfied() {
        //given
        Order order1 = new Order("티본스테이크", 5);
        Order order2 = new Order("바비큐립", 5);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        //when
        GiftEvent giftEvent = new GiftEvent(orders);

        //then
        assertEquals(MenuItem.샴페인.getPrice(), giftEvent.calculateDiscount());
    }

    @DisplayName("총 주문 금액이 12만원 미만이면 혜택 금액이 0원이다")
    @Test
    void giftEventDiscountCalculateTestWhenConditionNotSatisfied() {
        //given
        Order order1 = new Order("초코케이크", 3);

        Orders orders = new Orders(Arrays.asList(order1));

        //when
        GiftEvent giftEvent = new GiftEvent(orders);

        //then
        assertEquals(0, giftEvent.calculateDiscount());
    }

    @DisplayName("이벤트명 테스트")
    @Test
    void eventNameTest() {
        //given
        Order order1 = new Order("초코케이크", 3);

        Orders orders = new Orders(Arrays.asList(order1));

        //when
        GiftEvent giftEvent = new GiftEvent(orders);

        //then
        assertEquals("증정 이벤트", giftEvent.getEventName());
    }

}