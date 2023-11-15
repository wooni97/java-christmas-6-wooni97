package christmas.view;

import christmas.enums.MenuItem;
import christmas.model.Orders;
import christmas.model.VisitDate;

import java.util.Map;

public class OutputView {

    public void printEventPlanMessage(VisitDate visitDate) {
        System.out.printf("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", visitDate.getVisitDate().getMonthValue(), visitDate.getVisitDate().getDayOfMonth());
        printBlankLine();
    }

    public void printOrders(Orders orders) {
        printBlankLine();

        System.out.println("<주문 메뉴>");

        orders.forEach(order -> {
            System.out.println(order.getMenuItem().name() + " " + order.getOrderCount() + "개");
        });
    }

    public void printTotalPriceBeforeDiscount(int totalPrice) {
        printBlankLine();

        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", totalPrice);
    }

    public void printGiftEventInformation(Boolean applied) {
        printBlankLine();
        System.out.println("<증정 메뉴>");

        if (applied) {
            System.out.printf("%s 1개", MenuItem.샴페인.name());
            printBlankLine();
            return;
        }

        System.out.println("없음");
    }
    public void printAppliedEventAndDiscount(Map<String, Integer> eventAndDiscounts) {
        printBlankLine();
        System.out.println("<혜택 내역>");

        if (eventAndDiscounts.isEmpty()) {
            System.out.println("없음");
            return;
        }

        eventAndDiscounts.forEach((eventName, discountAmount) -> System.out.printf("%s: -%,d원%n", eventName, discountAmount));
    }

    public void printTotalBenefitAmount(int benefitAmount) {
        printBlankLine();

        System.out.println("<총혜택 금액>");

        System.out.printf("%,d원", benefitAmount);
        printBlankLine();
    }

    public void printTotalAmountAfterDiscount(int amount) {
        printBlankLine();

        System.out.println("<할인 후 예상 결제 금액>");

        System.out.printf("%,d원", amount);
        printBlankLine();
    }

    public void printEventBadge(String badgeName) {
        printBlankLine();

        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeName);
        printBlankLine();
    }

    public void printBlankLine() {
        System.out.println(" ");
    }
}
