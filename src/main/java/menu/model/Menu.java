package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final Category category;
    private final List<String> foods = new ArrayList<>();

    public Menu(Category category) {
        this.category = category;
    }

    public static Menu of(Category category, List<String> foods) {
        Menu menu = new Menu(category);
        foods.stream().forEach(food -> {
            menu.addFood(food);
        });
        return menu;
    }

    public void addFood(String food) {
        foods.add(food);
    }

    public boolean contains(String name) {
        for (String food : foods) {
            if (name.equals(food)) {
                return true;
            }
        }
        return false;
    }
}
