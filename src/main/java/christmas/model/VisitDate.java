package christmas.model;

import java.time.LocalDate;

public class VisitDate {

    private final LocalDate visitDate;

    public VisitDate(int date) {
        validateInRange(date);

        this.visitDate = LocalDate.of(2023, 12, date);
    }

    private void validateInRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }
}
