package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.OrderDtos;
import christmas.utils.StringUtils;
import christmas.validator.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int readDate() {
        while (true) {
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                String input = readInput();
                InputValidator.dateInputValidator(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                OutputView.printBlankLine();
            }
        }
    }

    public OrderDtos readOrders() {
        while (true) {
            try {
                System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
                String input = readInput();
                InputValidator.orderInputValidator(input);
                return requestOrdersMapper(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                OutputView.printBlankLine();
            }
        }
    }

    public static String readInput() {
        String input = Console.readLine();
        return input.replaceAll("\\s", "");
    }


    private OrderDtos requestOrdersMapper(String input) {
        List<String> orderInput = StringUtils.splitString(input);

        List<OrderDtos.OrderDto> orderDtos = new ArrayList<>();
        orderInput.forEach(order -> {
            List<String> parts = List.of(order.split("-"));

            String menuName = parts.get(0);
            int orderCount = Integer.parseInt(parts.get(1));

            OrderDtos.OrderDto orderDto = new OrderDtos.OrderDto(menuName, orderCount);
            orderDtos.add(orderDto);
        });

        return new OrderDtos(orderDtos);
    }
}
