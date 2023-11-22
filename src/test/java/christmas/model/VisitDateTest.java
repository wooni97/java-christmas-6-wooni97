package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDateTest {

    @DisplayName("날짜 입력 시 1~31 사이가 아니면 예외 발생")
    @Test
    void dateValidateRangeTest() {
        //given
        int dateInput = 32;

        //when, then
        assertThatThrownBy(() -> new VisitDate(dateInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}