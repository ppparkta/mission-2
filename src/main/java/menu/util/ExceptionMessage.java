package menu.util;

public enum ExceptionMessage {
    NAME_LENGTH_ERROR("이름은 2자 이상 4자 이하여야 합니다."),
    PICKY_MENU_SIZE_ERROR("못 먹는 음식은 2개 이하여야 합니다."),
    PICKY_MENU_DUPLICATED_ERROR("못 먹는 음식은 중복될 수 없습니다."),
    WEEKLY_MENU_DUPLICATED_ERROR("한 주의 메뉴는 중복될 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
