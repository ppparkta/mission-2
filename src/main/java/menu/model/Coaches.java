package menu.model;

import java.util.List;
import menu.util.ExceptionMessage;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        if (coaches == null || coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.COACHES_SIZE_ERROR.getMessage());
        }
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
