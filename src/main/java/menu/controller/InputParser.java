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
            notDuplicatedNames.add(name);
        });
        return Arrays.stream(names).toList();
    }

}
