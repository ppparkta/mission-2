package menu.controller;

import java.util.List;
import menu.model.Category;
import menu.service.CoachService;
import menu.model.Coaches;
import menu.model.Menus;
import menu.service.CategoryService;
import menu.view.OutputView;

public class MenuController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final CategoryService categoryService;
    private final CoachService coachService;

    public MenuController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
        this.categoryService = new CategoryService();
        this.coachService = new CoachService(inputHandler);
    }

    public void run() {
        Menus menus = InitHandler.initMenus();
        outputView.printStartMessage();
        Coaches coaches = inputHandler.getCoachNames();

        coachService.addPickyMenus(menus, coaches);

        List<Category> categories = categoryService.pickWeeklyCategories();
        coachService.pickWeeklyMenus(menus, coaches, categories);

        outputView.printMenuResult(categories, coaches);
    }
}
