package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.view.OutputView;

public class MenuController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public MenuController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
    }

    public void run() {
        Coaches coaches = inputHandler.getCoachNames();

        coaches.getCoaches().stream().forEach(coach -> {
            inputHandler.getPickyMenus(coach);
        });

        // 메뉴 추천 로직

        // 메뉴 추천 결과 출력
    }

}
