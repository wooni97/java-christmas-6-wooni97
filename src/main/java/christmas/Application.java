package christmas;

import christmas.controller.PromotionController;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        PromotionController promotionController = new PromotionController(new InputView());
        promotionController.run();
    }
}
