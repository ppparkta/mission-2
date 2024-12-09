package menu.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.ExceptionMessage;

public class Coach {
    private final String name;
    private final Set<String> pickyMenus = new HashSet<>();
    private final Set<String> weeklyMenus = new HashSet<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPickyMenu(List<String> menus) {
        if (menus == null) {
            return;
        }
        if (menus.size() > 2) {
            throw new IllegalArgumentException(ExceptionMessage.PICKY_MENU_SIZE_ERROR.getMessage());
        }
        for (String menu : menus) {
            validatePickyMenu(menu);
            pickyMenus.add(menu);
        }
    }

    public void addWeekMenu(String menu) {
        if (weeklyMenus.contains(menu)) {
            throw new IllegalArgumentException(ExceptionMessage.WEEKLY_MENU_DUPLICATED_ERROR.getMessage());
        }
        weeklyMenus.add(menu);
    }

    private void validatePickyMenu(String menu) {
        if (pickyMenus.contains(menu)) {
            throw new IllegalArgumentException(ExceptionMessage.PICKY_MENU_DUPLICATED_ERROR.getMessage());
        }
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }
}
