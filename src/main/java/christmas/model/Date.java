package christmas.model;

public class Date {

    public Date(String date) {
        validateNumeric(date);
        validateInRange(date);
    }

    private void validateNumeric(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInRange(String date) {
        if (Integer.parseInt(date) < 1 || Integer.parseInt(date) > 31) {
            throw new IllegalArgumentException();
        }
    }
}
