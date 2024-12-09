package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private final List<Menu> menus = new ArrayList<>();

    public Menus(List<Menu> menus) {
        menus.stream().forEach(menu -> {
            this.menus.add(menu);
        });
    }

    public boolean contains(String name) {
        for (Menu menu : menus) {
            if (menu.contains(name)) {
                return true;
            }
        }
        return false;
    }
}
