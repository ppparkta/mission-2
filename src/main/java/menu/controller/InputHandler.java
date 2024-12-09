package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final InputParser inputParser;

    public InputHandler() {
        this.inputView = new InputView();
        this.inputParser = new InputParser();
    }

    public Coaches getCoachNames() {
        while (true) {
            try {
                String inputValue = inputView.getInput("코치의 이름을 입력해 주세요. (, 로 구분)");
                List<String> names = inputParser.parseCoachNames(inputValue);
                List<Coach> coach = createCoach(names);
                return new Coaches(coach);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getPickyMenus(Coach coach) {
        while (true) {
            try {
                String inputValue = inputView.getInput(coach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                List<String> pickyMenus = inputParser.parsePickyMenus(inputValue);
                coach.addPickyMenu(pickyMenus);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Coach> createCoach(List<String> names) {
        List<Coach> result = new ArrayList<>();
        if (names == null || names.isEmpty()) {
            return null;
        }
        for (String name : names) {
            result.add(new Coach(name));
        }
        return result;
    }
}
