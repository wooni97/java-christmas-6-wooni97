package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("MenuItem에 존재하지 않는 메뉴이면 예외 처리")
    @Test
    void invalidOrderWithNonExistMenuItemTest() {

        //유효하지 않은 주문 생성 테스트
        assertThatThrownBy(() -> new Order("해산물스튜", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1보다 작은 갯수의 메뉴 주문하면 예외 처리")
    @Test
    void invalidOrderWithInvalidQuantityTest() {

        //유효하지 않은 주문 생성 테스트
        assertThatThrownBy(() -> new Order("해산물파스타", 0))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("유효한 주문이면 예외를 반환하지 않는다")
    @Test
    void validOrderWithValidQuantityTest() {

        //유효한 주문 생성 테스트
        assertDoesNotThrow(() -> new Order("해산물파스타", 2));
    }
}