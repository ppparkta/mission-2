package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final Category category;
    private final List<String> food = new ArrayList<>();

    public Menu(Category category) {
        this.category = category;
    }
}
