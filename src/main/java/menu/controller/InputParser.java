package menu.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.ExceptionMessage;

public class InputParser {

    public List<String> parseCoachNames(String inputValue) {
        String[] names = inputValue.split(",");
        Set<String> notDuplicatedNames = new HashSet<>();
        Arrays.stream(names).forEach(name -> {
            if (notDuplicatedNames.contains(name)) {
                throw new IllegalArgumentException(ExceptionMessage.NAME_DUPLICATED_ERROR.getMessage());
            }
            notDuplicatedNames.add(name.trim());
        });
        return Arrays.stream(names).toList();
    }

    public List<String> parsePickyMenus(String inputValue) {
        String[] menus = inputValue.split(",");
        Set<String> notDuplicatedMenus = new HashSet<>();
        Arrays.stream(menus).forEach(menu -> {
            if (notDuplicatedMenus.contains(menu)) {
                throw new IllegalArgumentException(ExceptionMessage.PICKY_MENU_DUPLICATED_ERROR.getMessage());
            }
        });
        if (menus.length > 2) {
            throw new IllegalArgumentException(ExceptionMessage.PICKY_MENU_SIZE_ERROR.getMessage());
        }
        return Arrays.stream(menus).map(menu -> menu.trim()).toList();
    }
}
