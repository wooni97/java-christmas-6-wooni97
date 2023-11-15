package christmas.validator;

public class InputValidator {

    private InputValidator() {
    }

    public static void dateInputValidator(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void orderInputValidator(String input) {
        String regex = "([a-zA-Z가-힣]+-\\d+,)*[a-zA-Z가-힣]+-\\d+";

        if(!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


}
