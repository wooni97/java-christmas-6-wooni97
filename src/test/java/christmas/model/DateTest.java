package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {
    @DisplayName("날짜 입력 시 숫자가 아니면 예외 발생")
    @Test
    void dateValidateNumericTest() {
        //given
        String dateInput = "one";

        //when, then
        assertThatThrownBy(() -> new Date(dateInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력 시 1~31 사이가 아니면 예외 발생")
    @Test
    void dateValidateRangeTest() {
        //given
        String dateInput = "32";

        //when, then
        assertThatThrownBy(() -> new Date(dateInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}