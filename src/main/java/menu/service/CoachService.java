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
        coaches.getCoaches().forEach(coach -> {
            inputHandler.getPickyMenus(coach, menus);
        });
    }

    public void pickWeeklyMenus(Menus menus, Coaches coaches, List<Category> categories) {
        int week = WeekConfig.MON.getValue();
        while (week <= WeekConfig.FRI.getValue()) {
            pickCoachWeeklyMenu(coaches, menus.getMenuByCategories(categories.get(week)));
            week++;
        }
    }

    private void pickCoachWeeklyMenu(Coaches coaches, Menu menu) {
        for (Coach coach : coaches.getCoaches()) {
            pickTodayMenu(coach, menu);
        }
    }

    private void pickTodayMenu(Coach coach, Menu menu) {
        while (true) {
            String selectedMenu = menu.shuffle();
            try {
                coach.addWeekMenu(selectedMenu);
                return;
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }
}
