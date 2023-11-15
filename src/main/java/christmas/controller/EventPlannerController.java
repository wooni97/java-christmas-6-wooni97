package christmas.controller;

import christmas.dto.OrderDtos;
import christmas.model.*;
import christmas.service.EventPlannerService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlannerController {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventPlannerService eventPlannerService;
    public EventPlannerController(InputView inputView, OutputView outputView, EventPlannerService eventPlannerService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventPlannerService = eventPlannerService;
    }

    public void run() {
        VisitDate visitDate = readVisitDate();
        Orders orders = readOrders();

        Events events = makeEvents(visitDate, orders);

        printEventPlan(visitDate, orders, events);
    }

    private VisitDate readVisitDate() {

        while (true) {
            try {
                int visitDate = inputView.readDate();
                return new VisitDate(visitDate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                outputView.printBlankLine();
            }
        }
    }

    private Orders readOrders() {

        while (true) {
            try {
                OrderDtos orderInput = inputView.readOrders();
                return eventPlannerService.makeOrders(orderInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                outputView.printBlankLine();
            }
        }

    }

    private void printEventPlan(VisitDate visitDate, Orders orders, Events events) {
        outputView.printEventPlanMessage(visitDate);

        printOrders(orders);
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());

        printGiftEvent(events);
        printAppliedEvents(events);
        printTotalBenefitAmount(events);
        printTotalAmountAfterDiscount(orders, events);
        printEventBadgeName(events);
    }

    private void printOrders(Orders orders) {
        outputView.printOrders(orders);
    }

    private Events makeEvents(VisitDate visitDate, Orders orders) {
        return eventPlannerService.makeEvents(visitDate, orders);
    }

    private void printGiftEvent(Events events) {
        outputView.printGiftEventInformation(eventPlannerService.isGiftEventActivated(events));
    }
    private void printAppliedEvents(Events events) {
        Map<String, Integer> eventAndDiscount = events.getAppliedEventAndDiscount();

        outputView.printAppliedEventAndDiscount(eventAndDiscount);
    }

    private void printTotalBenefitAmount(Events events) {
        int totalBenefitAmount = events.getTotalBenefitAmount();

        outputView.printTotalBenefitAmount(totalBenefitAmount);
    }

    private void printTotalAmountAfterDiscount(Orders orders, Events events) {
        int totalAmount = eventPlannerService.calculateTotalAmountAfterDiscount(orders, events);

        outputView.printTotalAmountAfterDiscount(totalAmount);
    }

    private void printEventBadgeName(Events events) {
        String badgeName = eventPlannerService.getEventBadge(events).getBadge().getBadgeName();

        outputView.printEventBadge(badgeName);
    }

}
