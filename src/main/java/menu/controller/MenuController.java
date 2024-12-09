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
        // 이름 입력 및 코치 생성
        Coaches coaches = inputHandler.getCoachNames();

        // 각 코치 별 못 먹는 메뉴 입력
        inputHandler.getPickyMenus(coaches);

        // 메뉴 추천 로직

        // 메뉴 추천 결과 출력
    }

}
