package menu.util;

public enum MenuConfig {
    FIRST(0),
    MAX_PICKY_MENU_SIZE(2),
    MIN_NAME_LENGTH(2),
    MAX_NAME_LENGTH(4),
    ;
    private final int value;

    MenuConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
