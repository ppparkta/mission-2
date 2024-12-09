package menu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.ExceptionMessage;
import menu.util.MenuConfig;

public class Coach {
    private final String name;
    private final Set<String> pickyMenus = new HashSet<>();
    private final List<String> weeklyMenus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getWeeklyMenus() {
        return weeklyMenus;
    }

    public void addPickyMenu(List<String> menus) {
        if (menus == null) {
            return;
        }
        if (menus.size() > MenuConfig.MAX_PICKY_MENU_SIZE.getValue()) {
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
        if (pickyMenus.contains(menu)) {
            throw new IllegalArgumentException(ExceptionMessage.PICKY_MENU_SELECTED_ERROR.getMessage());
        }
        if (weeklyMenus.size() == 5) {
            throw new IllegalArgumentException(ExceptionMessage.WEEKLY_MENU_SIZE_ERROR.getMessage());
        }
        weeklyMenus.add(menu);
    }

    private void validatePickyMenu(String menu) {
        if (pickyMenus.contains(menu)) {
            throw new IllegalArgumentException(ExceptionMessage.PICKY_MENU_DUPLICATED_ERROR.getMessage());
        }
    }

    private void validate(String name) {
        if (name.length() < MenuConfig.MIN_NAME_LENGTH.getValue()
                || name.length() > MenuConfig.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }
}
