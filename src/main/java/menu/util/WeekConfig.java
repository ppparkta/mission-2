package menu.util;

public enum WeekConfig {
    MON(0),
    TUE(1),
    WED(2),
    THU(3),
    FRI(4),
    ;
    private final int value;

    WeekConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
