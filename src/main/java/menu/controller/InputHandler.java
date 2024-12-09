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

    public String getPickyMenus(Coaches coaches) {
        while (true) {
            return null;
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
