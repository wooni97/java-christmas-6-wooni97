package christmas.model;

import christmas.constant.ErrorMessage;
import java.time.LocalDate;

public class VisitDate {

    private final LocalDate visitDate;

    public VisitDate(int date) {
        validateInRange(date);

        this.visitDate = LocalDate.of(2023, 12, date);
    }

    private void validateInRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_INVALID_ERROR_MESSAGE);
        }
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }
}
