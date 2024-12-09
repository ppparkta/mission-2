package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.Menus;
import menu.view.OutputView;

public class MenuController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public MenuController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
    }

    public void run() {
        Menus menus = InitHandler.initMenus();
        Coaches coaches = inputHandler.getCoachNames();

        coaches.getCoaches().stream().forEach(coach -> {
            inputHandler.getPickyMenus(coach);
        });

        // 메뉴 추천 로직

        // 메뉴 추천 결과 출력
    }
}
