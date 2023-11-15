package christmas.model;

import christmas.enums.Badge;

public class EventBadge {

    private static final int AMOUNT_FOR_SANTA = 20000;
    private static final int AMOUNT_FOR_TREE = 10000;
    private static final int AMOUNT_FOR_STAR = 5000;

    private final Events events;

    public EventBadge(Events events) {
        this.events = events;
    }

    public Badge getBadge() {
        int totalBenefitAmount = events.getTotalBenefitAmount();

        if (totalBenefitAmount >= AMOUNT_FOR_SANTA) {
            return Badge.SANTA;
        }

        if (totalBenefitAmount >= AMOUNT_FOR_TREE) {
            return Badge.TREE;
        }

        if (totalBenefitAmount >= AMOUNT_FOR_STAR) {
            return Badge.STAR;
        }

        return Badge.NONE;
    }

}
