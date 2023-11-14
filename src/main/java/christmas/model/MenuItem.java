package christmas.model;

import java.util.Arrays;

public enum MenuItem {

    양송이수프(MenuCategory.APPETIZER, 6000),
    타파스(MenuCategory.APPETIZER,5000),
    시저샐러드(MenuCategory.APPETIZER,8000),

    티본스테이크(MenuCategory.MAIN_DISH,55000),
    바비큐립(MenuCategory.MAIN_DISH,54000),
    해산물파스타(MenuCategory.MAIN_DISH,3500),
    크리스마스파스타(MenuCategory.MAIN_DISH,25000),

    초코케이크(MenuCategory.DESSERT,15000),
    아이스크림(MenuCategory.DESSERT,5000),

    제로콜라(MenuCategory.BEVERAGE,3000),
    레드와인(MenuCategory.BEVERAGE,60000),
    샴페인(MenuCategory.BEVERAGE,25000);

    private final MenuCategory menuCategory;
    private final int price;

    MenuItem(MenuCategory menuCategory, int price) {
        this.menuCategory = menuCategory;
        this.price = price;
    }

    public static MenuItem findByName(String menuName) {
        return Arrays.stream(MenuItem.values())
                .filter(item -> item.name().equals(menuName))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public int getPrice() {
        return price;
    }
}
