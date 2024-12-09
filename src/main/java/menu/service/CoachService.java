package menu.service;

import java.util.List;
import menu.controller.InputHandler;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.Menus;
import menu.util.WeekConfig;

public class CoachService {
    private final InputHandler inputHandler;

    public CoachService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void addPickyMenus(Menus menus, Coaches coaches) {
        coaches.getCoaches().stream().forEach(coach -> {
            inputHandler.getPickyMenus(coach, menus);
        });
    }

    public void pickWeeklyMenus(Menus menus, Coaches coaches, List<Category> categories) {
        for (Coach coach : coaches.getCoaches()) {
            pickCoachWeeklyMenu(coach, menus, categories);
        }
    }

    private void pickCoachWeeklyMenu(Coach coach, Menus menus, List<Category> categories) {
        int week = WeekConfig.MON.getValue();
        while (week <= WeekConfig.FRI.getValue()) {
            if (pickTodayMenu(coach, menus.getMenuByCategories(categories.get(week)))) {
                week++;
            }
        }
    }

    private boolean pickTodayMenu(Coach coach, Menu menu) {
        String selectedMenu = menu.shuffle();
        try {
            coach.addWeekMenu(selectedMenu);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
