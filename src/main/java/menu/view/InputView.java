package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine().replaceAll(" ", "");
    }
}
