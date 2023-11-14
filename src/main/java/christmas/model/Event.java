package christmas.model;

import java.time.LocalDate;

public abstract class Event {

    protected final LocalDate orderDate;
    protected final Orders orders;

    public Event(LocalDate orderDate, Orders orders) {
        this.orderDate = orderDate;
        this.orders = orders;
    }

    public abstract int calculateDiscount();

    /*
    * 이벤트 적용 대상 여부
    * */
    public abstract boolean isEventActive();

    public abstract String getEventName();
}
