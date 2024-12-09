package menu.util;

public enum WeekConfig {
    MON(0),
    FRI(4),
    MAX(5),
    ;
    private final int value;

    WeekConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
