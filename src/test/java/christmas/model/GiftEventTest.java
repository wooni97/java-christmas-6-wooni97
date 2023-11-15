package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import christmas.enums.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class GiftEventTest {

    @DisplayName("")
    @Test
    void giftEventDiscountCalculateTest() {
        //given
        Order order1 = new Order("티본스테이크", 5);
        Order order2 = new Order("바비큐립", 5);

        Orders orders = new Orders(Arrays.asList(order1, order2));

        //when
        GiftEvent giftEvent = new GiftEvent(orders);

        //then
        assertEquals(MenuItem.샴페인.getPrice(), giftEvent.calculateDiscount());
    }



}