package christmas.validator;

import christmas.constant.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void dateInputValidator(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_INVALID_ERROR_MESSAGE);
        }
    }

    public static void orderInputValidator(String input) {
        String regex = "([a-zA-Z가-힣]+-\\d+,)*[a-zA-Z가-힣]+-\\d+";

        if(!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_INVALID_ERROR_MESSAGE);
        }
    }


}
